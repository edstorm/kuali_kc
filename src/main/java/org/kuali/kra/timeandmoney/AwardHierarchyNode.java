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
package org.kuali.kra.timeandmoney;

import java.sql.Date;
import java.util.LinkedHashMap;

import org.kuali.kra.award.awardhierarchy.AwardHierarchy;
import org.kuali.rice.kns.util.KualiDecimal;

public class AwardHierarchyNode extends AwardHierarchy { 
    
    private Date currentFundEffectiveDate;
    private Date obligationExpirationDate;
    private Date finalExpirationDate;
    private KualiDecimal anticipatedTotalAmount; 
    private KualiDecimal antDistributableAmount;
    private KualiDecimal amountObligatedToDate; 
    private KualiDecimal obliDistributableAmount;
    private String leadUnitName;
    private String principalInvestigatorName;
    
    public AwardHierarchyNode() {
        anticipatedTotalAmount = new KualiDecimal("0");
        antDistributableAmount = new KualiDecimal("0");
        amountObligatedToDate = new KualiDecimal("0");
        obliDistributableAmount = new KualiDecimal("0");
    }

    /** {@inheritDoc} */
    @Override 
    protected LinkedHashMap<String, Object> toStringMapper() {
        LinkedHashMap<String, Object> hashMap = super.toStringMapper();
        hashMap.put("currentFundEffectiveDate", this.getCurrentFundEffectiveDate());
        hashMap.put("obligationExpirationDate", this.getObligationExpirationDate());
        hashMap.put("finalExpirationDate", this.getFinalExpirationDate());
        hashMap.put("anticipatedTotalAmount", this.getAnticipatedTotalAmount());
        hashMap.put("antDistributableAmount", this.getAntDistributableAmount());
        hashMap.put("amountObligatedToDate", this.getAmountObligatedToDate());
        hashMap.put("obliDistributableAmount", this.getObliDistributableAmount());
        return hashMap;
    }

    /**
     * Gets the currentFundEffectiveDate attribute. 
     * @return Returns the currentFundEffectiveDate.
     */
    public Date getCurrentFundEffectiveDate() {
        return currentFundEffectiveDate;
    }

    /**
     * Sets the currentFundEffectiveDate attribute value.
     * @param currentFundEffectiveDate The currentFundEffectiveDate to set.
     */
    public void setCurrentFundEffectiveDate(Date currentFundEffectiveDate) {
        this.currentFundEffectiveDate = currentFundEffectiveDate;
    }

    /**
     * Gets the obligationExpirationDate attribute. 
     * @return Returns the obligationExpirationDate.
     */
    public Date getObligationExpirationDate() {
        return obligationExpirationDate;
    }

    /**
     * Sets the obligationExpirationDate attribute value.
     * @param obligationExpirationDate The obligationExpirationDate to set.
     */
    public void setObligationExpirationDate(Date obligationExpirationDate) {
        this.obligationExpirationDate = obligationExpirationDate;
    }

    /**
     * Gets the finalExpirationDate attribute. 
     * @return Returns the finalExpirationDate.
     */
    public Date getFinalExpirationDate() {
        return finalExpirationDate;
    }

    /**
     * Sets the finalExpirationDate attribute value.
     * @param finalExpirationDate The finalExpirationDate to set.
     */
    public void setFinalExpirationDate(Date finalExpirationDate) {
        this.finalExpirationDate = finalExpirationDate;
    }

    /**
     * Gets the anticipatedTotalAmount attribute. 
     * @return Returns the anticipatedTotalAmount.
     */
    public KualiDecimal getAnticipatedTotalAmount() {
        return anticipatedTotalAmount;
    }

    /**
     * Sets the anticipatedTotalAmount attribute value.
     * @param anticipatedTotalAmount The anticipatedTotalAmount to set.
     */
    public void setAnticipatedTotalAmount(KualiDecimal anticipatedTotalAmount) {
        this.anticipatedTotalAmount = anticipatedTotalAmount;
    }

    /**
     * Gets the antDistributableAmount attribute. 
     * @return Returns the antDistributableAmount.
     */
    public KualiDecimal getAntDistributableAmount() {
        return antDistributableAmount;
    }

    /**
     * Sets the antDistributableAmount attribute value.
     * @param antDistributableAmount The antDistributableAmount to set.
     */
    public void setAntDistributableAmount(KualiDecimal antDistributableAmount) {
        this.antDistributableAmount = antDistributableAmount;
    }

    /**
     * Gets the amountObligatedToDate attribute. 
     * @return Returns the amountObligatedToDate.
     */
    public KualiDecimal getAmountObligatedToDate() {
        return amountObligatedToDate;
    }

    /**
     * Sets the amountObligatedToDate attribute value.
     * @param amountObligatedToDate The amountObligatedToDate to set.
     */
    public void setAmountObligatedToDate(KualiDecimal amountObligatedToDate) {
        this.amountObligatedToDate = amountObligatedToDate;
    }

    /**
     * Gets the obliDistributableAmount attribute. 
     * @return Returns the obliDistributableAmount.
     */
    public KualiDecimal getObliDistributableAmount() {
        return obliDistributableAmount;
    }

    /**
     * Sets the obliDistributableAmount attribute value.
     * @param obliDistributableAmount The obliDistributableAmount to set.
     */
    public void setObliDistributableAmount(KualiDecimal obliDistributableAmount) {
        this.obliDistributableAmount = obliDistributableAmount;
    }

    /**
     * Gets the leadUnitName attribute. 
     * @return Returns the leadUnitName.
     */
    public String getLeadUnitName() {
        return leadUnitName;
    }

    /**
     * Sets the leadUnitName attribute value.
     * @param leadUnitName The leadUnitName to set.
     */
    public void setLeadUnitName(String leadUnitName) {
        this.leadUnitName = leadUnitName;
    }

    /**
     * Gets the principalInvestigatorName attribute. 
     * @return Returns the principalInvestigatorName.
     */
    public String getPrincipalInvestigatorName() {
        return principalInvestigatorName;
    }

    /**
     * Sets the principalInvestigatorName attribute value.
     * @param principalInvestigatorName The principalInvestigatorName to set.
     */
    public void setPrincipalInvestigatorName(String principalInvestigatorName) {
        this.principalInvestigatorName = principalInvestigatorName;
    }
    
}