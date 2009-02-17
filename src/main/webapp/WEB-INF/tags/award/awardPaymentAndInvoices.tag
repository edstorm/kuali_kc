<%--
 Copyright 2006-2008 The Kuali Foundation
 
 Licensed under the Educational Community License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
 http://www.osedu.org/licenses/ECL-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>


<kul:tabTop tabTitle="Payment & Invoices" defaultOpen="false" tabErrorKey="" >
	<div class="tab-container" align="right">
		<kra-a:awardPaymentAndInvoicesTopPanel />	
		<kra-a:awardReportClasses index="5" reportClassKey="${KualiForm.reportClassForPaymentsAndInvoices.reportClassCode}" 
			reportClassLabel="Payment & Invoice Requirements" defaultOpenForTab="true" noShowHideButton="true" />
	</div>
</kul:tabTop>
