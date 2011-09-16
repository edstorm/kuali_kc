/*
 * Copyright 2005-2010 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.negotiations.web.struts.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.kuali.kra.authorization.KraAuthorizationConstants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.negotiations.bo.NegotiationAssociatedDetailBean;
import org.kuali.kra.negotiations.bo.NegotiationAssociationType;
import org.kuali.kra.negotiations.bo.NegotiationStatus;
import org.kuali.kra.negotiations.bo.NegotiationUnassociatedDetail;
import org.kuali.kra.negotiations.document.NegotiationDocument;
import org.kuali.kra.negotiations.service.NegotiationService;
import org.kuali.kra.web.struts.form.KraTransactionalDocumentFormBase;
import org.kuali.rice.kns.service.BusinessObjectService;
import org.kuali.rice.kns.util.KNSConstants;

/**
 * 
 * This class holds all the objects required for a negotiation web object.
 */
public class NegotiationForm extends KraTransactionalDocumentFormBase {
    
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(NegotiationForm.class);

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3641922366447898075L;
    
    private List<NegotiationUnassociatedDetail> negotiationUnassociatedDetailsToDelete;
    private NegotiationActivityHelper negotiationActivityHelper;
    private NegotiationAssociatedDetailBean negotiationAssociatedDetailBean;
    
    /**
     * 
     * Constructs a NegotiationForm.java.
     */
    public NegotiationForm() {
        super();
        negotiationUnassociatedDetailsToDelete = new ArrayList<NegotiationUnassociatedDetail>();
        negotiationActivityHelper = new NegotiationActivityHelper(this);
    }
    
    public NegotiationDocument getNegotiationDocument() {
        return this.getDocument();
    }
    
    @Override
    public NegotiationDocument getDocument() {
        return (NegotiationDocument) super.getDocument();
    }

    public List<NegotiationUnassociatedDetail> getNegotiationUnassociatedDetailsToDelete() {
        return negotiationUnassociatedDetailsToDelete;
    }

    @Override
    protected String getDefaultDocumentTypeName() {
        return "NegotiationDocument";
    }

    @Override
    protected String getLockRegion() {
        return KraAuthorizationConstants.LOCK_NEGOTIATION;
    }

    @Override
    protected void setSaveDocumentControl(Map editMode) {
        getDocumentActions().put(KNSConstants.KUALI_ACTION_CAN_SAVE, KNSConstants.KUALI_DEFAULT_TRUE_VALUE);

    }
    
    @Override
    public void populate(HttpServletRequest request) {
        super.populate(request);
        this.negotiationAssociatedDetailBean = getNegotiationService().buildNegotiationAssociatedDetailBean(this.getNegotiationDocument().getNegotiation());
    }
    
    public BusinessObjectService getBusinessObjectService() {
        return KraServiceLocator.getService(BusinessObjectService.class);
    }
    
    public NegotiationService getNegotiationService() {
        return KraServiceLocator.getService(NegotiationService.class);
    }
    
    private boolean isAssocitationType(String typeCode) {
        if (this.getNegotiationDocument().getNegotiation().getNegotiationAssociationType() != null) {
            return StringUtils.equalsIgnoreCase(typeCode, this.getNegotiationDocument().getNegotiation().getNegotiationAssociationType().getCode());
        }
        return false;
    }
    
    public boolean getDisplayUnAssociatedDetail() {
        return isAssocitationType(NegotiationAssociationType.NONE_ASSOCIATION);
    }
    
    public boolean getDisplayProposalLog() {
        return isAssocitationType(NegotiationAssociationType.PROPOSAL_LOG_ASSOCIATION);
    }
    
    public boolean getDisplayInstitutionalProposal() {
        return isAssocitationType(NegotiationAssociationType.INSTITUATIONAL_PROPOSAL_ASSOCIATION);
    }
    
    public boolean getDisplayAward() {
        return isAssocitationType(NegotiationAssociationType.AWARD_ASSOCIATION);
    }
    
    public boolean getDisplaySubAward() {
        return isAssocitationType(NegotiationAssociationType.SUB_AWARD_ASSOCIATION);
    }

    public NegotiationActivityHelper getNegotiationActivityHelper() {
        return negotiationActivityHelper;
    }

    public void setNegotiationActivityHelper(NegotiationActivityHelper negotiationActivityHelper) {
        this.negotiationActivityHelper = negotiationActivityHelper;
    }
    
    public boolean getDispayAssociatedDetailPanel() { 
        return !getDisplayUnAssociatedDetail() && StringUtils.isNotEmpty(this.getNegotiationDocument().getNegotiation().getAssociatedDocumentId());
    }
    
    /**
     * 
     * This method returns the NegotiationAssociatedDetailBean.  If it hasn't been set, it does so.
     * @return
     */
    public NegotiationAssociatedDetailBean getNegotiationAssociatedDetailBean() {
        if (negotiationAssociatedDetailBean == null ) {
            this.negotiationAssociatedDetailBean = getNegotiationService().buildNegotiationAssociatedDetailBean(this.getNegotiationDocument().getNegotiation());
        }
        return negotiationAssociatedDetailBean;
    }
    
    /**
     * 
     * This method builds the javascript the disables and enables the ending date field based on the status field.
     * @return
     */
    public String getStatusRelatedJavascript() {
        StringBuffer sb = new StringBuffer(100);
        String newLine = "\n ";
        sb.append("function manageStatusEndDate(doUpdateDate){").append(newLine);
        sb.append("var statusField = document.getElementById('document.negotiationList[0].negotiationStatusId');").append(newLine);
        sb.append("var dateField = document.getElementById('document.negotiationList[0].negotiationEndDate');").append(newLine);
        sb.append("var statusFieldSelectedVal = statusField.options[statusField.selectedIndex].value;").append(newLine);
        
        sb.append("if (");
        int currentIndex = 0;
        List<String> completedCodes = this.getNegotiationService().getCompletedStatusCodes();
        for (String currentCode : completedCodes) {
            NegotiationStatus currentStatus = getNegotiationStatus(currentCode);
            sb.append("statusFieldSelectedVal == '").append(currentStatus.getId().toString()).append("'");
            if (currentIndex + 1 < completedCodes.size()) {
                sb.append(" || ");
            }
            currentIndex++;
        }
        sb.append(") {").append(newLine);
        
        sb.append("  dateField.disabled = false;").append(newLine);
        sb.append("  if (dateField.value == '' && doUpdateDate) {").append(newLine);
        sb.append("    var currentTime = new Date();").append(newLine);
        sb.append("    dateField.value = currentTime.getMonth() + 1 + \"/\" +  currentTime.getDate() + \"/\" + currentTime.getFullYear();").append(newLine);
        sb.append("  }").append(newLine).append("} else {").append(newLine);
        sb.append("  dateField.disabled = true;").append(newLine).append("  dateField.value = '';").append(newLine);
        sb.append("}").append(newLine).append("}").append(newLine);
        sb.append("manageStatusEndDate(false);");

        return sb.toString();
    }
    
    private NegotiationStatus getNegotiationStatus(String code) {
        Map params = new HashMap();
        params.put("NEGOTIATION_STATUS_CODE", code);
        return (NegotiationStatus) this.getBusinessObjectService().findMatching(NegotiationStatus.class, params).iterator().next();
    }
}