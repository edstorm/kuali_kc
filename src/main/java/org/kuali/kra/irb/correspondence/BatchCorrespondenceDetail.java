/*
 * Copyright 2006-2010 The Kuali Foundation
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
package org.kuali.kra.irb.correspondence;

import java.util.LinkedHashMap;

import org.kuali.kra.bo.KraPersistableBusinessObjectBase;

public class BatchCorrespondenceDetail extends KraPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;
    
    private Integer batchCorrespondenceDetailId;
    private String batchCorrespondenceTypeCode;
    private Integer correspondenceNumber;
    private String protoCorrespTypeCode;
    private Integer noOfDaysTillNext;
    
    public BatchCorrespondenceDetail() {
        
    }

    public Integer getBatchCorrespondenceDetailId() {
        return batchCorrespondenceDetailId;
    }

    public void setBatchCorrespondenceDetailId(Integer batchCorrespondenceDetailId) {
        this.batchCorrespondenceDetailId = batchCorrespondenceDetailId;
    }

    public String getBatchCorrespondenceTypeCode() {
        return batchCorrespondenceTypeCode;
    }

    public void setBatchCorrespondenceTypeCode(String batchCorrespondenceTypeCode) {
        this.batchCorrespondenceTypeCode = batchCorrespondenceTypeCode;
    }

    public Integer getCorrespondenceNumber() {
        return correspondenceNumber;
    }

    public void setCorrespondenceNumber(Integer correspondenceNumber) {
        this.correspondenceNumber = correspondenceNumber;
    }

    public String getProtoCorrespTypeCode() {
        return protoCorrespTypeCode;
    }

    public void setProtoCorrespTypeCode(String protoCorrespTypeCode) {
        this.protoCorrespTypeCode = protoCorrespTypeCode;
    }

    public Integer getNoOfDaysTillNext() {
        return noOfDaysTillNext;
    }

    public void setNoOfDaysTillNext(Integer noOfDaysTillNext) {
        this.noOfDaysTillNext = noOfDaysTillNext;
    }
    
    /** {@inheritDoc} */
    @Override 
    protected LinkedHashMap<String, Object> toStringMapper() {
        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();
        hashMap.put("batchCorrespondenceDetailId", this.getBatchCorrespondenceDetailId());
        hashMap.put("batchCorrespondenceTypeCode", this.getBatchCorrespondenceTypeCode());
        hashMap.put("correspondenceNumber", this.getCorrespondenceNumber());
        hashMap.put("protoCorrespTypeCode", this.getProtoCorrespTypeCode());
        hashMap.put("noOfDaysTillNext", this.getNoOfDaysTillNext());
        return hashMap;
    }
}
