/*
 * Copyright 2006-2009 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.web.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.budget.BudgetDecimal;
import org.kuali.kra.budget.core.Budget;
import org.kuali.kra.budget.core.BudgetService;
import org.kuali.kra.budget.document.BudgetDocument;
import org.kuali.kra.budget.document.BudgetParentDocument;
import org.kuali.kra.budget.parameters.BudgetPeriod;
import org.kuali.kra.budget.versions.BudgetDocumentVersion;
import org.kuali.kra.budget.versions.BudgetVersionOverview;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.proposaldevelopment.service.ProposalLockService;
import org.kuali.kra.web.struts.form.BudgetVersionFormBase;
import org.kuali.rice.kew.exception.WorkflowException;
import org.kuali.rice.kns.service.DocumentService;
import org.kuali.rice.kns.service.PessimisticLockService;
import org.kuali.rice.kns.util.WebUtils;
import org.kuali.rice.kns.web.struts.form.KualiForm;

/**
 * This class contains methods common to ProposalDevelopment and Budget actions.
 */
public class BudgetActionBase extends KraTransactionalDocumentActionBase {
    
    /**
     * @see org.kuali.core.web.struts.action.KualiDocumentActionBase#save(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        final BudgetVersionFormBase proposalForm = (BudgetVersionFormBase) form;
        ActionForward forward = super.save(mapping, form, request, response);
        
        if (proposalForm.getMethodToCall().equals("save") && proposalForm.isAuditActivated()) {
            // TODO : need to check whether the error is really fixed ?
            forward = mapping.findForward(Constants.PROPOSAL_ACTIONS_PAGE);
        }

        return forward;
    }

    protected static final String COPY_BUDGET_PERIOD_QUESTION = "copyBudgetQuestion";
    protected static final String QUESTION_TYPE = "copyPeriodsQuestion";
    protected static final String QUESTION_TEXT = "A new version of the budget will be created based on version ";
    
    /**
     * This method looks for the version corresponding to finalBudgetVersion in the list, then marks that version as final.
     * 
     * @param finalBudgetVersion
     * @param budgetVersions
     */
    protected void setFinalBudgetVersion(Integer finalBudgetVersion, List<BudgetVersionOverview> budgetVersions) {
        for (BudgetVersionOverview budgetVersion: budgetVersions) {
            if (budgetVersion.getBudgetVersionNumber().equals(finalBudgetVersion)) {
                budgetVersion.setFinalVersionFlag(true);
            } else {
                budgetVersion.setFinalVersionFlag(false);
            }
        }
    }
    
    /**
     * This method looks at the list of budgetVersions for the final version, then returns the version number.
     * 
     * @param budgetVersions
     * @return
     */
    protected Integer getFinalBudgetVersion(List<BudgetDocumentVersion> budgetVersions) {
        for (BudgetDocumentVersion budgetVersion: budgetVersions) {
            if (budgetVersion.getBudgetVersionOverview().isFinalVersionFlag()) {
                return budgetVersion.getBudgetVersionOverview().getBudgetVersionNumber();
            }
        }
        return null;
    }
    
    /**
     * This method sets the proposal budget status to the status of the final budget version.  If there is no final version, do nothing.
     * 
     * @param parentDocument
     */
    protected void setBudgetParentStatus(BudgetParentDocument parentDocument) {
        for (BudgetDocumentVersion budgetVersion: parentDocument.getBudgetDocumentVersions()) {
            if (budgetVersion.getBudgetVersionOverview().isFinalVersionFlag()) {
                parentDocument.getBudgetParent().setBudgetStatus(budgetVersion.getBudgetVersionOverview().getBudgetStatus());
                return;
            }
        }
    }
    
    /**
     * This method sets the budget status of the 'final' budget version (if it exists) to the proposal budget status
     * as indicated in the proposal development document.
     * 
     * @param proposalDevelopmentDocument
     */
    protected void setBudgetStatuses(BudgetParentDocument proposalDevelopmentDocument) {
        
        for (BudgetDocumentVersion budgetDocumentVersion: proposalDevelopmentDocument.getBudgetDocumentVersions()) {
            BudgetVersionOverview budgetVersion =  budgetDocumentVersion.getBudgetVersionOverview();
            if (budgetVersion.isFinalVersionFlag()) {
                budgetVersion.setBudgetStatus(proposalDevelopmentDocument.getBudgetParent().getBudgetStatus());
            }
            else {
                String budgetStatusIncompleteCode = getParameterService().getParameterValue(
                        BudgetDocument.class, Constants.BUDGET_STATUS_INCOMPLETE_CODE);
                budgetVersion.setBudgetStatus(budgetStatusIncompleteCode);
            }
        }
    }
    
    /**
     * Copy the given budget version and add it to the given proposal.
     * 
     * @param proposalDevelopmentDocument
     * @param budgetToCopy
     * @param copyPeriodOneOnly if only the first budget period is to be copied
     */
    protected void copyBudget(BudgetParentDocument proposalDevelopmentDocument, BudgetVersionOverview budgetToCopy, boolean copyPeriodOneOnly) 
    throws WorkflowException {
        DocumentService documentService = KraServiceLocator.getService(DocumentService.class);
        BudgetDocument budgetDocToCopy = (BudgetDocument) documentService.getByDocumentHeaderId(budgetToCopy.getDocumentNumber());
        Budget budget = budgetDocToCopy.getBudget();
        if (copyPeriodOneOnly) {
            //Copy full first version, then include empty periods for remainder
            List<BudgetPeriod> oldBudgetPeriods = budget.getBudgetPeriods(); 
            BudgetPeriod firstPeriod = oldBudgetPeriods.get(0);
            for ( int i = 1 ; i < oldBudgetPeriods.size(); i++ ) {
                BudgetPeriod period = oldBudgetPeriods.get(i);
                period.getBudgetLineItems().clear();
                period.setCostSharingAmount(new BudgetDecimal(0.0));
                period.setExpenseTotal(new BudgetDecimal(0.0));
                period.setTotalCost(new BudgetDecimal(0.0));
                period.setTotalCostLimit(new BudgetDecimal(0.0));
                period.setTotalDirectCost(new BudgetDecimal(0.0));
                period.setTotalIndirectCost(new BudgetDecimal(0.0));
                period.setUnderrecoveryAmount(new BudgetDecimal(0.0));
            }
        }
        BudgetService budgetService = KraServiceLocator.getService(BudgetService.class);
        BudgetDocument newBudgetDoc = budgetService.copyBudgetVersion(budgetDocToCopy);
        proposalDevelopmentDocument.addNewBudgetVersion(newBudgetDoc, budgetToCopy.getDocumentDescription() + " " 
                                                        + budgetToCopy.getBudgetVersionNumber() + " copy", true);
    }

    protected void populateTabState(KualiForm form, String tabTitle) {
        form.getTabStates().put(WebUtils.generateTabKey(tabTitle), "OPEN");
    }
    
    @Override
    protected PessimisticLockService getPessimisticLockService() {
        return KraServiceLocator.getService(ProposalLockService.class);
    }
}
