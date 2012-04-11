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
package org.kuali.kra.award.notification;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.kra.award.contacts.AwardCreditSplitBean;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardAmountInfo;
import org.kuali.kra.common.notification.NotificationRendererBase;
import org.kuali.rice.core.api.util.type.KualiDecimal;
import org.kuali.rice.kew.api.exception.WorkflowException;

/**
 * Renders fields for the Award notifications.
 */
public class AwardNotificationRenderer extends NotificationRendererBase {

    private static final long serialVersionUID = -5066268431930093815L;
    private static Log LOG = LogFactory.getLog(AwardNotificationRenderer.class);
    
    private Award award;
    
    public AwardNotificationRenderer() {
        
    }
    
    /**
     * Constructs an Award notification renderer.
     * @param institutionalProposal
     */
    public AwardNotificationRenderer(Award award) {
        this.award = award;
    }

    /**
     * {@inheritDoc}
     * @see org.kuali.kra.common.notification.NotificationRenderer#getReplacementParameters()
     */
    public Map<String, String> getDefaultReplacementParameters() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");        
        Map<String, String> result = super.getDefaultReplacementParameters();
        result.put("{AWARD_NUMBER}", award.getAwardNumber());
        result.put("{SEQUENCE_NUMBER}", award.getSequenceNumber().toString());
        result.put("{AWARD_TITLE}", award.getTitle());
        if (award.getAwardTypeCode() != null) {
            result.put("{AWARD_TYPE_CODE}", award.getAwardTypeCode().toString());
            result.put("{AWARD_TYPE_NAME}", award.getAwardType().getDescription());
        }
        result.put("{PI_NAME}", award.getPiName());
        result.put("{LEAD_UNIT}", award.getLeadUnitNumber());
        result.put("{LEAD_UNIT_NAME}", award.getLeadUnitName());
        result.put("{ACCOUNT_NUMBER}", award.getAccountNumber());
        result.put("{SPONSOR_AWARD_NUMBER}", award.getSponsorAwardNumber());
        if (award.getStatusCode() != null) {
            result.put("{STATUS_CODE}", award.getStatusCode().toString());
            result.put("{STATUS_NAME}", award.getStatusDescription());
        }
        if (award.getBeginDate() != null) {
            result.put("{BEGIN_DATE}", dateFormatter.format(award.getBeginDate()));
        }
        if (award.getAwardExecutionDate() != null) {
            result.put("{EXECUTION_DATE}", dateFormatter.format(award.getAwardExecutionDate()));
        }
        if (award.getAwardEffectiveDate() != null) {
            result.put("{EFFECTIVE_DATE}", dateFormatter.format(award.getAwardEffectiveDate()));
        }
        if (award.getSponsorCode() != null) {
            result.put("{SPONSOR_CODE}", award.getSponsorCode());
            result.put("{SPONSOR_NAME}", award.getSponsorName());
        }
        AwardAmountInfo awardAmountInfo = null;
        try {
            awardAmountInfo = award.getAwardAmountInfos().get(award.getIndexOfAwardAmountInfoForDisplay());
        }
        catch (WorkflowException e) {
            LOG.warn("Unable to load award amount info information.", e);
        } 
        if (awardAmountInfo != null && awardAmountInfo.getFinalExpirationDate() != null) {
            result.put("{FINAL_EXPIRATION_DATE}", dateFormatter.format(awardAmountInfo.getFinalExpirationDate()));
        }
        if (award.getAwardEffectiveDate() != null) {
            result.put("{OBLIGATION_EFFECTIVE_DATE}", dateFormatter.format(award.getAwardEffectiveDate()));
        }
        if (awardAmountInfo != null && awardAmountInfo.getObligationExpirationDate() != null) {
            result.put("{OBLIGATION_EXPIRATION_DATE}", dateFormatter.format(awardAmountInfo.getObligationExpirationDate()));
        }
        if (awardAmountInfo != null) {
            KualiDecimal totalAmount = KualiDecimal.ZERO;
            if (awardAmountInfo.getObligatedTotalDirect() != null) {
                totalAmount = totalAmount.add(awardAmountInfo.getObligatedTotalDirect());
            }
            if (awardAmountInfo.getObligatedTotalIndirect() != null) {
                totalAmount = totalAmount.add(awardAmountInfo.getObligatedTotalIndirect());
            }
            result.put("{OBLIGATED_TOTAL_AMOUNT}", totalAmount.toString());
        }
        if (awardAmountInfo != null) {
            KualiDecimal totalAmount = KualiDecimal.ZERO;
            if (awardAmountInfo.getAnticipatedTotalAmount() != null) {
                totalAmount = totalAmount.add(awardAmountInfo.getAnticipatedTotalAmount());
            }
            result.put("{ANTICIPATED_TOTAL_AMOUNT}", totalAmount.toString());
        }
        if (award.getPrimeSponsorCode() != null) {
            result.put("{PRIME_SPONSOR_CODE}", award.getPrimeSponsorCode());
            result.put("{PRIME_SPONSOR_NAME}", award.getPrimeSponsorName());
        }
        if (award.getActivityTypeCode() != null) {
            result.put("{ACTIVITY_TYPE_CODE}", award.getActivityTypeCode());
            result.put("{ACTIVITY_TYPE_NAME}", award.getActivityType().getDescription());
        }
        if (award.getAccountTypeCode() != null) {
            result.put("{ACCOUNT_TYPE_CODE}", award.getAccountTypeCode().toString());
            result.put("{ACCOUNT_TYPE_NAME}", award.getAccountTypeDescription());
        }
        return result;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }
    
}