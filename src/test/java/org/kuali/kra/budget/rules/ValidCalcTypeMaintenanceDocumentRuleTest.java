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
package org.kuali.kra.budget.rules;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.RiceKeyConstants;
import org.kuali.core.UserSession;
import org.kuali.core.document.MaintenanceDocument;
import org.kuali.core.util.ErrorMessage;
import org.kuali.core.util.GlobalVariables;
import org.kuali.core.util.TypedArrayList;
import org.kuali.kra.budget.bo.ValidCalcType;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.maintenance.MaintenanceRuleTestBase;

public class ValidCalcTypeMaintenanceDocumentRuleTest extends MaintenanceRuleTestBase {
    private ValidCalcTypeMaintenanceDocumentRule rule = null;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        rule = new ValidCalcTypeMaintenanceDocumentRule();
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }

    @After
    public void tearDown() throws Exception {
        rule = null;
        super.tearDown();
    }

    @Test
    public void testOK() throws Exception {

        ValidCalcType validCalcType = new ValidCalcType();
        
        validCalcType.setRateClassCode("10");
        validCalcType.setRateTypeCode("1");
        validCalcType.setRateClassType("X");
        validCalcType.setDependentRateClassType("Y");
        MaintenanceDocument validCalcTypeDocument = newMaintDoc(validCalcType);
        assertTrue(rule.processCustomRouteDocumentBusinessRules(validCalcTypeDocument));
        assertTrue(rule.processCustomApproveDocumentBusinessRules(validCalcTypeDocument));
    }

    /**
     * 
     * This method to test rate type does not exist.
     * @throws Exception
     */
    @Test
    public void testRateTypeNotExist() throws Exception {

        ValidCalcType validCalcType = new ValidCalcType();
        
        validCalcType.setRateClassCode("10");
        validCalcType.setRateTypeCode("2");
        validCalcType.setRateClassType("X");
        validCalcType.setDependentRateClassType("Y");
        MaintenanceDocument validCalcTypeDocument = newMaintDoc(validCalcType);
        assertFalse(rule.processCustomRouteDocumentBusinessRules(validCalcTypeDocument));
        TypedArrayList errors = GlobalVariables.getErrorMap().getMessages("document.newMaintainableObject.rateTypeCode");
        assertTrue(errors.size() == 1);
        ErrorMessage message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), KeyConstants.ERROR_RATE_TYPE_NOT_EXIST);

        // approve will have the same error too.
        assertFalse(rule.processCustomApproveDocumentBusinessRules(validCalcTypeDocument));
        errors = GlobalVariables.getErrorMap().getMessages("document.newMaintainableObject.rateTypeCode");
        assertTrue(errors.size() == 1);
        message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), KeyConstants.ERROR_RATE_TYPE_NOT_EXIST);

    }

    @Test
    public void testRateClassTypeNotExist() throws Exception {

        ValidCalcType validCalcType = new ValidCalcType();
        
        validCalcType.setRateClassCode("10");
        validCalcType.setRateTypeCode("1");
        validCalcType.setRateClassType("1");
        validCalcType.setDependentRateClassType("Y");
        MaintenanceDocument validCalcTypeDocument = newMaintDoc(validCalcType);
        assertFalse(rule.processCustomRouteDocumentBusinessRules(validCalcTypeDocument));
        TypedArrayList errors = GlobalVariables.getErrorMap().getMessages("document.newMaintainableObject.rateClassType");
        assertTrue(errors.size() == 1);
        ErrorMessage message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), RiceKeyConstants.ERROR_EXISTENCE);

        // approve will have the same error too.
        assertFalse(rule.processCustomApproveDocumentBusinessRules(validCalcTypeDocument));
        errors = GlobalVariables.getErrorMap().getMessages("document.newMaintainableObject.rateClassType");
        assertTrue(errors.size() == 1);
        message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), RiceKeyConstants.ERROR_EXISTENCE);

    }

    @Test
    public void testDependentrateClassTypeNotExist() throws Exception {

        ValidCalcType validCalcType = new ValidCalcType();
        
        validCalcType.setRateClassCode("10");
        validCalcType.setRateTypeCode("1");
        validCalcType.setRateClassType("X");
        validCalcType.setDependentRateClassType("1");
        MaintenanceDocument validCalcTypeDocument = newMaintDoc(validCalcType);
        assertFalse(rule.processCustomRouteDocumentBusinessRules(validCalcTypeDocument));
        TypedArrayList errors = GlobalVariables.getErrorMap().getMessages("document.newMaintainableObject.dependentRateClassType");
        assertTrue(errors.size() == 1);
        ErrorMessage message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), RiceKeyConstants.ERROR_EXISTENCE);

        // approve will have the same error too.
        assertFalse(rule.processCustomApproveDocumentBusinessRules(validCalcTypeDocument));
        errors = GlobalVariables.getErrorMap().getMessages("document.newMaintainableObject.dependentRateClassType");
        assertTrue(errors.size() == 1);
        message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), RiceKeyConstants.ERROR_EXISTENCE);

    }

}
