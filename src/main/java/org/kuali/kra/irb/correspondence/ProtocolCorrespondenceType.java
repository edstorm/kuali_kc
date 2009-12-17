/*
 * Copyright 2006-2008 The Kuali Foundation
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
package org.kuali.kra.irb.correspondence;

import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.kuali.kra.bo.KraPersistableBusinessObjectBase;

@Entity 
@Table(name="PROTO_CORRESP_TYPE")
public class ProtocolCorrespondenceType extends KraPersistableBusinessObjectBase { 

    private static final long serialVersionUID = -4725522827463252054L;

    @Id 
    @Column(name="PROTO_CORRESP_TYPE_CODE")
    private String protoCorrespTypeCode; 

    @Column(name="DESCRIPTION")
    private String description; 

    @Column(name="MODULE_ID")
    private String moduleId; 
    
    private List<ProtocolCorrespondenceTemplate> protocolCorrespondenceTemplates;
    
    public ProtocolCorrespondenceType() { 

    } 
    
    public String getProtoCorrespTypeCode() {
        return protoCorrespTypeCode;
    }

    public void setProtoCorrespTypeCode(String protoCorrespTypeCode) {
        this.protoCorrespTypeCode = protoCorrespTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
    
    public List<ProtocolCorrespondenceTemplate> getProtocolCorrespondenceTemplates() {
        return protocolCorrespondenceTemplates;
    }

    public void setProtocolCorrespondenceTemplates(List<ProtocolCorrespondenceTemplate> protocolCorrespondenceTemplates) {
        this.protocolCorrespondenceTemplates = protocolCorrespondenceTemplates;
    }

    /** {@inheritDoc} */
    @Override 
    protected LinkedHashMap<String, Object> toStringMapper() {
        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();
        hashMap.put("protoCorrespTypeCode", this.getProtoCorrespTypeCode());
        hashMap.put("description", this.getDescription());
        hashMap.put("moduleId", this.getModuleId());
        return hashMap;
    }
    
}