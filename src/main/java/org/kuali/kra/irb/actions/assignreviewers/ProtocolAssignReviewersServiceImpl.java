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
package org.kuali.kra.irb.actions.assignreviewers;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.submit.ProtocolReviewer;
import org.kuali.kra.irb.actions.submit.ProtocolReviewerBean;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReviewService;
import org.kuali.rice.kew.exception.WorkflowException;
import org.kuali.rice.kns.service.BusinessObjectService;
import org.kuali.rice.kns.util.GlobalVariables;

/**
 * Implementation of the ProtocolAssignReviewersService.
 */
public class ProtocolAssignReviewersServiceImpl implements ProtocolAssignReviewersService {

    private static Log LOG = LogFactory.getLog(ProtocolAssignReviewersServiceImpl.class);
    
    private BusinessObjectService businessObjectService;
    private ProtocolOnlineReviewService protocolOnlineReviewService;
    
    
    
    /**
     * @see org.kuali.kra.irb.actions.assignreviewers.ProtocolAssignReviewersService#getCurrentSubmission(org.kuali.kra.irb.Protocol)
     */
    public ProtocolSubmission getCurrentSubmission(Protocol protocol) {
        return findSubmission(protocol);
    }

    /**
     * Find the submission.  It is the submission that is either currently pending or
     * already submitted to a committee or the submission assigned to agenda 
     * @param protocol
     * @return
     */
    private ProtocolSubmission findSubmission(Protocol protocol) {
        for (ProtocolSubmission submission : protocol.getProtocolSubmissions()) {
            if (StringUtils.equals(submission.getSubmissionStatusCode(), ProtocolSubmissionStatus.PENDING) ||
                StringUtils.equals(submission.getSubmissionStatusCode(), ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE) 
                ||
                StringUtils.equals(submission.getSubmissionStatusCode(), ProtocolSubmissionStatus.IN_AGENDA)) {
                return submission;
            }
        }
        return null;
    }

    /**
     * @throws  
     * @see org.kuali.kra.irb.actions.assignreviewers.ProtocolAssignReviewersService#assignReviewers(org.kuali.kra.irb.Protocol, java.util.List)
     */
    public void assignReviewers(Protocol protocol, List<ProtocolReviewerBean> reviewerBeans)  {
        ProtocolSubmission submission = findSubmission(protocol);
        if (submission != null) {
            for (ProtocolReviewerBean reviewerBean : reviewerBeans) {
                if (reviewerBean.getChecked()) {
                    if (!protocolOnlineReviewService.isUserAnOnlineReviewerOfProtocol(reviewerBean.getPersonId(), protocol)) {
                        try {
                            protocolOnlineReviewService.createAndRouteProtocolOnlineReviewDocument(protocol, reviewerBean,
                                    String.format("%s/Protocol# %s",protocol.getPrincipalInvestigator().getPerson().getLastName(),protocol.getProtocolNumber()),
                                    "", 
                                    "",
                                    "Online Review Requested by PI during protocol submission.",
                                    false,
                                    null,
                                    null,
                                    GlobalVariables.getUserSession().getPrincipalId());
                            
                        } catch (WorkflowException e) {
                            LOG.error(String.format("WorkflowException creating new ProtocolOnlineReviewDocument for reviewer %s, protocol %s", reviewerBean.getPersonId(), protocol.getProtocolNumber()),e);
                            throw new RuntimeException(String.format("WorkflowException creating new ProtocolOnlineReviewDocument for reviewer %s, protocol %s", reviewerBean.getPersonId(), protocol.getProtocolNumber()),e);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Create a protocol reviewer.
     * @param personId
     * @param reviewerTypeCode
     * @param nonEmployeeFlag
     * @return
     */
//    private ProtocolReviewer createReviewer(ProtocolSubmission submission, String personId, String reviewerTypeCode, boolean nonEmployeeFlag) {
//        ProtocolReviewer protocolReviewer = new ProtocolReviewer();
//        protocolReviewer.setProtocolId(submission.getProtocolId());
//        protocolReviewer.setSubmissionIdFk(submission.getSubmissionId());
//        protocolReviewer.setProtocolNumber(submission.getProtocolNumber());
//        protocolReviewer.setSequenceNumber(submission.getSequenceNumber());
//        protocolReviewer.setSubmissionNumber(submission.getSubmissionNumber());
//        
//        if(nonEmployeeFlag) {
//            protocolReviewer.setRolodexId(Integer.parseInt(personId));
//        } else {
//            protocolReviewer.setPersonId(personId);
//        }
//        protocolReviewer.setReviewerTypeCode(reviewerTypeCode);
//        protocolReviewer.setNonEmployeeFlag(nonEmployeeFlag);
//        return protocolReviewer;
//    }


    /**
     * Set the Business Object Service.
     * @param businessObjectService businessObjectService.
     */
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    /**
     * Set the Protocol Online Review Service.
     * @param protocolOnlineReviewService protocolOnlineReviewService.
     */
    public void setProtocolOnlineReviewService(ProtocolOnlineReviewService protocolOnlineReviewService) {
        this.protocolOnlineReviewService = protocolOnlineReviewService;
    }
    
}