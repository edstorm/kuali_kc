<%--
 Copyright 2005-2010 The Kuali Foundation
 
 Licensed under the Educational Community License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
 http://www.opensource.org/licenses/ecl1.php
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="subAwardFundingSourceAttributes" value="${DataDictionary.SubAwardFundingSource.attributes}" />
<c:set var="action" value="subAward" />
<c:set var="subAwardFundingSource" value="${KualiForm.document.subAwardList[0].subAwardFundingSourceList}"/>
<c:set var="newSubAwardFundingSource" value="${KualiForm.newSubAwardFundingSource}" />

<kul:tab tabTitle="SubAward Funding Source" defaultOpen="true" alwaysOpen="true" transparentBackground="true" tabErrorKey="" auditCluster="requiredFieldsAuditErrors" tabAuditKey="" useRiceAuditMode="true">
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left"> SubAward Funding Source</span>
    		<span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.bo.SubAwardFundingSource" altText="help"/></span>
        </h3>
        <table cellpadding=0 cellspacing=0 summary="">
        
        <tr>
      	<th><div align="left">&nbsp;</div></th>
        <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFundingSourceAttributes.awardId}" /></div></th>
        <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFundingSourceAttributes.accountNumber}" /></div></th>
        <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFundingSourceAttributes.statusCode}" /></div></th>
        <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFundingSourceAttributes.sponsorCode}" /></div></th>
        <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFundingSourceAttributes.amountObligatedToDate}" /></div></th>
        <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFundingSourceAttributes.obligationExpirationDate}" /></div></th>
         <kul:htmlAttributeHeaderCell literalLabel="Actions" scope="col"/>
          	   </tr>     
			   <tr>
               <th class="infoline" >
						Add:
				</th>
     			 <td align="left" valign="middle"><kul:htmlControlAttribute property="newSubAwardFundingSource.award.awardNumber" attributeEntry="${subAwardFundingSourceAttributes.awardId}" />
                 <kul:lookup boClassName="org.kuali.kra.award.home.Award" fieldConversions="awardNumber:newSubAwardFundingSource.award.awardNumber,awardId:newSubAwardFundingSource.awardId,accountNumber:newSubAwardFundingSource.award.accountNumber,statusCode:newSubAwardFundingSource.award.statusCode,sponsorCode:newSubAwardFundingSource.award.sponsorCode,awardAmountInfos[0].amountObligatedToDate:newSubAwardFundingSource.award.awardAmountInfos[0].amountObligatedToDate,awardAmountInfos[0].obligationExpirationDate:newSubAwardFundingSource.award.awardAmountInfos[0].obligationExpirationDate" anchor="${tabKey}" />
               	</td>
   				<td><div align="center">
     					<kul:htmlControlAttribute property="newSubAwardFundingSource.award.accountNumber" readOnly="${readOnly}" attributeEntry="${subAwardFundingSourceAttributes.accountNumber}" datePicker="false" />           
   					</div> 
   				</td>
   				<td><div align="center">
     					<kul:htmlControlAttribute property="newSubAwardFundingSource.award.statusCode" readOnly="${readOnly}" attributeEntry="${subAwardFundingSourceAttributes.statusCode}" datePicker="false" />         
   					</div> 
   				</td>
   				<td><div align="center">
     					<kul:htmlControlAttribute property="newSubAwardFundingSource.award.sponsorCode" readOnly="${readOnly}" attributeEntry="${subAwardFundingSourceAttributes.sponsorCode}" datePicker="false" />         
   					</div> 
   					</td>	
   				<td><div align="center">
     					<kul:htmlControlAttribute property="newSubAwardFundingSource.award.awardAmountInfos[0].amountObligatedToDate" readOnly="${readOnly}" attributeEntry="${subAwardFundingSourceAttributes.amountObligatedToDate}" datePicker="false" />         
   					</div> 
   				</td>	
   				<td><div align="center">
     					<kul:htmlControlAttribute property="newSubAwardFundingSource.award.awardAmountInfos[0].obligationExpirationDate" readOnly="${readOnly}" attributeEntry="${subAwardFundingSourceAttributes.obligationExpirationDate}" datePicker="false" />         
   					</div> 
   				</td>		
   				<td class="infoline" rowspan="1"><div align="center">
						<html:image property="methodToCall.addFundingSource.anchor${tabKey}" 
						            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-add1.gif' 
						            styleClass="tinybutton"/>
	                </div>
	            </td>   
   			</tr> 
     	<c:forEach var="subAwardFundingSource" items="${KualiForm.document.subAwardList[0].subAwardFundingSourceList}" varStatus="status">
		             <tr>
		             
						<th width="5%" class="infoline" rowspan="1">
							<c:out value="${status.index+1}" />
						</th>
						     
		                 <td width="9%" valign="middle">
						<div align="left">
	                		<kul:htmlControlAttribute property="document.subAwardList[0].subAwardFundingSourceList[${status.index}].award.awardNumber" attributeEntry="${subAwardFundingSourceAttributes.awardId}" />
						</div>
						</td> 
		                <td width="9%" valign="middle">
						<div align="center">
	                		<kul:htmlControlAttribute property="document.subAwardList[0].subAwardFundingSourceList[${status.index}].award.accountNumber" attributeEntry="${subAwardFundingSourceAttributes.accountNumber}"/>                		
						</div>
						</td>
		                <td width="9%" valign="middle">
						<div align="center">
	                		<kul:htmlControlAttribute property="document.subAwardList[0].subAwardFundingSourceList[${status.index}].award.statusCode" attributeEntry="${subAwardFundingSourceAttributes.statusCode}"/>
						</div>
						</td>
						<td width="9%" valign="middle">
						<div align="center">
							<kul:htmlControlAttribute property="document.subAwardList[0].subAwardFundingSourceList[${status.index}].award.sponsorCode" attributeEntry="${subAwardFundingSourceAttributes.sponsorCode}"/>         
						</div>
						</td>
						<td width="9%" valign="middle">
						<div align="center">
							<kul:htmlControlAttribute property="document.subAwardList[0].subAwardFundingSourceList[${status.index}].award.awardAmountInfos[0].amountObligatedToDate" attributeEntry="${subAwardFundingSourceAttributes.amountObligatedToDate}"/>
						</div>
						</td>
						<td width="9%" valign="middle">
						<div align="center">
							<kul:htmlControlAttribute property="document.subAwardList[0].subAwardFundingSourceList[${status.index}].award.awardAmountInfos[0].obligationExpirationDate" attributeEntry="${subAwardFundingSourceAttributes.obligationExpirationDate}" datePicker="false"/>
						</div>
						</td>
						
						    <td width="10%" valign="middle" rowspan="1">
						<div align="center">
						  <c:if test="${!readOnly}">
	                		<html:image property="methodToCall.deleteFundingSource.line${status.index}.anchor${currentTabIndex}"
								src='${ConfigProperties.kra.externalizable.images.url}tinybutton-delete1.gif' styleClass="tinybutton"/>
						  </c:if>
						  <c:if test="${readOnly}">&nbsp;</c:if>
						</div>
						</td>           
		            </tr>
      
	        	</c:forEach>
        </table>
    </div> 
</kul:tab>