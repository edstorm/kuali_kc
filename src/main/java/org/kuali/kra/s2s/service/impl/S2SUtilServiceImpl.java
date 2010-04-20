/*
 * Copyright 2008 The Kuali Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License");
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
package org.kuali.kra.s2s.service.impl;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import noNamespace.InstituteProposalDocument;
import noNamespace.InstituteProposalDocument.InstituteProposal;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.bo.Country;
import org.kuali.kra.bo.Organization;
import org.kuali.kra.bo.Rolodex;
import org.kuali.kra.bo.State;
import org.kuali.kra.bo.Unit;
import org.kuali.kra.bo.versioning.VersionHistory;
import org.kuali.kra.budget.personnel.BudgetPersonnelDetails;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.proposaladmindetails.ProposalAdminDetails;
import org.kuali.kra.proposaldevelopment.bo.DevelopmentProposal;
import org.kuali.kra.proposaldevelopment.bo.ProposalPerson;
import org.kuali.kra.proposaldevelopment.bo.ProposalYnq;
import org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument;
import org.kuali.kra.proposaldevelopment.service.ProposalDevelopmentService;
import org.kuali.kra.questionnaire.Questionnaire;
import org.kuali.kra.questionnaire.answer.Answer;
import org.kuali.kra.questionnaire.answer.AnswerHeader;
import org.kuali.kra.s2s.bo.S2sAppSubmission;
import org.kuali.kra.s2s.bo.S2sOpportunity;
import org.kuali.kra.s2s.generator.bo.DepartmentalPerson;
import org.kuali.kra.s2s.generator.bo.KeyPersonInfo;
import org.kuali.kra.s2s.service.S2SUtilService;
import org.kuali.kra.s2s.util.S2SConstants;
import org.kuali.kra.service.VersionHistoryService;
import org.kuali.rice.kns.service.BusinessObjectService;
import org.kuali.rice.kns.service.DateTimeService;
import org.kuali.rice.kns.service.KualiConfigurationService;
import org.kuali.rice.kns.service.ParameterService;

/**
 * 
 * 
 * This class is the implementation for all reusable components that are part of S2S
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class S2SUtilServiceImpl implements S2SUtilService {

	private BusinessObjectService businessObjectService;
	private DateTimeService dateTimeService;
	private KualiConfigurationService kualiConfigurationService;
	private ParameterService parameterService;
    private ProposalDevelopmentService proposalDevelopmentService;
	private static final String SUBMISSION_TYPE_CODE = "submissionTypeCode";
	private static final String SUBMISSION_TYPE_DESCRIPTION = "submissionTypeDescription";
	private static final String PROPOSAL_YNQ_STATE_REVIEW = "EO";
	private static final String YNQ_NOT_REVIEWED = "X";
	private static final String KEY_COUNTRY_CODE = "countryCode";
	private static final String KEY_STATE_CODE = "stateCode";
	private static final int DIVISION_NAME_MAX_LENGTH = 30;
	private static final Logger LOG = Logger.getLogger(S2SUtilServiceImpl.class);
	
	private static final String MODULE_ITEM_KEY = "moduleItemKey";
	private static final String MODULE_ITEM_CODE = "moduleItemCode";
	private static final Integer MODULE_ITEM_CODE_THREE = 3;
	private static final String MODULE_SUB_ITEM_CODE="moduleSubItemCode";
	private static final Integer MODULE_SUB_ITEM_CODE_ZERO= 0;
	private static final String MODULE_SUB_ITEM_KEY= "moduleSubItemKey";
	private static final Integer MODULE_SUB_ITEM_KEY_ZERO= 0;
    
	private static final String SEQUENCE_NUMBER="sequenceNumber";
	private static final String QUESTIONNAIRE_ID="questionnaireId";
	private static final String QUESTIONNAIRE_REF_ID_FK="questionnaireRefIdFk";

	/**
	 * This method creates and returns Map of submission details like submission
	 * type, description and Revision code
	 * 
	 * @param pdDoc
	 *            Proposal Development Document.
	 * @return Map<String, String> Map of submission details.
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getSubmissionType(org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument)
	 */
	public Map<String, String> getSubmissionType(
			ProposalDevelopmentDocument pdDoc) {
		Map<String, String> submissionInfo = new HashMap<String, String>();
		S2sOpportunity opportunity = pdDoc.getDevelopmentProposal()
				.getS2sOpportunity();
		if (opportunity != null) {
			opportunity.refreshNonUpdateableReferences();
			String submissionTypeCode = opportunity.getS2sSubmissionTypeCode();
			String submissionTypeDescription = "";
			if (opportunity.getS2sSubmissionType() != null) {
				submissionTypeDescription = opportunity.getS2sSubmissionType()
						.getDescription();
			}
			String revisionCode = opportunity.getRevisionCode();
			String revisionOtherDescription = opportunity
					.getRevisionOtherDescription();

			submissionInfo.put(SUBMISSION_TYPE_CODE, submissionTypeCode);
			submissionInfo.put(SUBMISSION_TYPE_DESCRIPTION,
					submissionTypeDescription);
			submissionInfo.put(S2SConstants.KEY_REVISION_CODE, revisionCode);
			if (revisionOtherDescription != null) {
				submissionInfo.put(S2SConstants.KEY_REVISION_OTHER_DESCRIPTION,
						revisionOtherDescription);
			}
		}
		return submissionInfo;
	}

	/**
	 * This method populates and returns the Departmental Person object for a
	 * given proposal document
	 * 
	 * @param pdDoc
	 *            Proposal Development Document.
	 * @return DepartmentalPerson departmental Person object for a given
	 *         proposal document.
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getDepartmentalPerson(org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument)
	 */
	public DepartmentalPerson getDepartmentalPerson(
			ProposalDevelopmentDocument pdDoc) {
		int count = 0;
		DepartmentalPerson depPerson = new DepartmentalPerson();
		// TODO fetch count from institute proposal tables after its
		// implementation
		if (count < 1) {
			// Proposal has not been submitted

			Organization organization = pdDoc.getDevelopmentProposal()
					.getApplicantOrganization().getOrganization();
			Rolodex rolodex = organization == null ? null : organization
					.getRolodex();
			if (rolodex != null) {
				depPerson.setFirstName(rolodex.getFirstName());
				depPerson.setMiddleName(rolodex.getMiddleName());
				depPerson.setLastName(rolodex.getLastName());
				StringBuilder fullName = new StringBuilder();
				if (rolodex.getFirstName() != null) {
					fullName.append(rolodex.getFirstName());
					fullName.append(" ");
				}
				if (rolodex.getMiddleName() != null) {
					fullName.append(rolodex.getMiddleName());
					fullName.append(" ");
				}
				if (rolodex.getLastName() != null) {
					fullName.append(rolodex.getLastName());
				}
				depPerson.setFullName(fullName.toString());

				depPerson.setEmailAddress(rolodex.getEmailAddress());
				depPerson.setOfficePhone(rolodex.getPhoneNumber());
				depPerson.setPrimaryTitle(rolodex.getTitle());
				depPerson.setAddress1(rolodex.getAddressLine1());
				depPerson.setAddress2(rolodex.getAddressLine2());
				depPerson.setAddress3(rolodex.getAddressLine3());
				depPerson.setCity(rolodex.getCity());
				depPerson.setCounty(rolodex.getCounty());
				depPerson.setCountryCode(rolodex.getCountryCode());
				depPerson.setFaxNumber(rolodex.getFaxNumber());
				depPerson.setPostalCode(rolodex.getPostalCode());
				depPerson.setState(rolodex.getState());
				depPerson.setPersonId(Integer.toString(rolodex.getRolodexId()));
				depPerson.setDirDept(organization.getOrganizationName());
			}
		} else {
			// proposal has been submitted
			// TODO fetched SIGNED_BY fromPROPOSAL_ADMIN_DETAILS after
			// implementation and complete the remaining logic

		}
		return depPerson;
	}

	/**
	 * This method limits the number of key persons to n, returns list of key
	 * persons, first n in case firstN is true, or all other than first n, in
	 * case of firstN being false
	 * 
	 * @param proposalPersons
	 *            list of {@link ProposalPerson}
	 * @param firstN
	 *            value that determines whether the returned list should contain
	 *            first n persons or the rest of persons
	 * @param n
	 *            number of key persons that are considered as not extra persons
	 * @return list of {@link ProposalPerson}
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getNKeyPersons(java.util.List,
	 *      boolean, int)
	 */
	public List<ProposalPerson> getNKeyPersons(
			List<ProposalPerson> proposalPersons, boolean firstN, int n) {
		ProposalPerson proposalPerson, previousProposalPerson;
		int size = proposalPersons.size();

		for (int i = size - 1; i > 0; i--) {
			proposalPerson = proposalPersons.get(i);
			previousProposalPerson = proposalPersons.get(i - 1);
			if (proposalPerson.getPersonId() != null
					&& previousProposalPerson.getPersonId() != null
					&& proposalPerson.getPersonId().equals(
							previousProposalPerson.getPersonId())) {
				proposalPersons.remove(i);
			} else if (proposalPerson.getRolodexId() != null
					&& previousProposalPerson.getRolodexId() != null
					&& proposalPerson.getRolodexId().equals(
							previousProposalPerson.getRolodexId())) {
				proposalPersons.remove(i);
			}
		}

		size = proposalPersons.size();
		if (firstN) {
			List<ProposalPerson> firstNPersons = new ArrayList<ProposalPerson>();

			// Make sure we don't exceed the size of the list.
			if (size > n) {
				size = n;
			}
			// remove extras
			for (int i = 0; i < size; i++) {
				firstNPersons.add(proposalPersons.get(i));
			}
			return firstNPersons;
		} else {
			// return extra people
			List<ProposalPerson> extraPersons = new ArrayList<ProposalPerson>();
			for (int i = n; i < size; i++) {
				extraPersons.add(proposalPersons.get(i));
			}
			return extraPersons;
		}
	}

	/**
	 * This method returns a map containing the answers related to EOState
	 * REview for a given proposal
	 * 
	 * @param pdDoc
	 *            Proposal Development Document.
	 * @return Map<String, String> map containing the answers related to
	 *         EOState Review for a given proposal.
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getEOStateReview(org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument)
	 */
	public Map<String, String> getEOStateReview(
			ProposalDevelopmentDocument pdDoc) {
		Map<String, String> stateReview = new HashMap<String, String>();
		for (ProposalYnq proposalYnq : pdDoc.getDevelopmentProposal()
				.getProposalYnqs()) {
			if (proposalYnq.getQuestionId().equals(PROPOSAL_YNQ_STATE_REVIEW)) {
				stateReview.put(S2SConstants.YNQ_ANSWER, proposalYnq
						.getAnswer());
				if (proposalYnq.getReviewDate() != null) {
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					stateReview.put(S2SConstants.YNQ_REVIEW_DATE, dateFormat
							.format(proposalYnq.getReviewDate()));
				}
			}
		}

		// If question is not answered or question is inactive
		if (stateReview.size() == 0) {
			stateReview.put(S2SConstants.YNQ_ANSWER, YNQ_NOT_REVIEWED);
			stateReview.put(S2SConstants.YNQ_REVIEW_DATE, null);
		}
		return stateReview;

	}

    /**
     * This method returns the Federal ID for a given proposal
     * 
     * @param proposalDevelopmentDocument Proposal Development Document.
     * @return Federal ID for a given proposal.
     * @see org.kuali.kra.s2s.service.S2SUtilService#getFederalId(org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument)
     */
    public String getFederalId(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        String federalIdComesFromAwardStr = parameterService.getParameterValue(ProposalDevelopmentDocument.class, "FEDERAL_ID_COMES_FROM_CURRENT_AWARD");
        Boolean federalIdComesFromAward = federalIdComesFromAwardStr != null && federalIdComesFromAwardStr.equalsIgnoreCase("Y");
        DevelopmentProposal proposal = proposalDevelopmentDocument.getDevelopmentProposal();
        Award currentAward = null;
        if (StringUtils.isNotBlank(proposal.getCurrentAwardNumber())) {
            currentAward = proposalDevelopmentService.getProposalCurrentAwardVersion(proposalDevelopmentDocument);
        }
        InstitutionalProposal institutionalProposal = null;
        if (StringUtils.isNotBlank(proposal.getContinuedFrom())) {
            institutionalProposal = proposalDevelopmentService.getProposalContinuedFromVersion(proposalDevelopmentDocument);
        }
        if (proposal.getSponsor().getAcronym().equalsIgnoreCase("NSF")) {
            return null;
        } else if (isProposalTypeRenewalRevisionContinuation(proposal.getProposalTypeCode())) {
            if (!StringUtils.isBlank(proposal.getSponsorProposalNumber())) {
                return proposal.getSponsorProposalNumber();
            } else if (currentAward != null && !StringUtils.isBlank(currentAward.getSponsorAwardNumber())
                    && federalIdComesFromAward) {
                return currentAward.getSponsorAwardNumber();
            } else { 
                return null;
            }
        } else if (isProposalTypeNew(proposal.getProposalTypeCode())
                && StringUtils.equalsIgnoreCase(proposal.getS2sOpportunity().getS2sSubmissionTypeCode(), "3")
                || isProposalTypeResubmission(proposal.getProposalTypeCode())) {
            if (!StringUtils.isBlank(proposal.getSponsorProposalNumber())) {
                return proposal.getSponsorProposalNumber();
            } else if (institutionalProposal != null && !StringUtils.isBlank(institutionalProposal.getSponsorProposalNumber())) {
                return institutionalProposal.getSponsorProposalNumber();
            } else {
                return null;
            }
        }
        return null;
    } 

	/**
	 * This method fetches system constant parameters
	 * 
	 * @param parameter
	 *            String for which value must be fetched
	 * @return String System constant parameters.
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getParameterValue(java.lang.String)
	 */
	public String getParameterValue(String parameter) {
		String parameterValue = null;
		try {
			parameterValue = this.parameterService.getParameterValue(
					ProposalDevelopmentDocument.class, parameter);
		} catch (IllegalArgumentException e) {
			LOG.error("Parameter not found - " + parameter, e);
		}
		return parameterValue;
	}

    private boolean isProposalTypeRenewalRevisionContinuation(String proposalTypeCode) {
        String proposalTypeCodeRenewal = 
            parameterService.getParameterValue(ProposalDevelopmentDocument.class, KeyConstants.PROPOSALDEVELOPMENT_PROPOSALTYPE_RENEWAL);
        String proposalTypeCodeRevision = 
            parameterService.getParameterValue(ProposalDevelopmentDocument.class, KeyConstants.PROPOSALDEVELOPMENT_PROPOSALTYPE_REVISION);
        String proposalTypeCodeContinuation = 
            parameterService.getParameterValue(ProposalDevelopmentDocument.class, KeyConstants.PROPOSALDEVELOPMENT_PROPOSALTYPE_CONTINUATION);
         
        return !StringUtils.isEmpty(proposalTypeCode) &&
               (proposalTypeCode.equals(proposalTypeCodeRenewal) ||
                proposalTypeCode.equals(proposalTypeCodeRevision) ||
                proposalTypeCode.equals(proposalTypeCodeContinuation));
    }  
    
    /**
     * Is the Proposal Type set to Resubmission?
     * @param proposalTypeCode proposal type code
     * @return true or false
     */
    private boolean isProposalTypeResubmission(String proposalTypeCode) {
        String proposalTypeCodeResubmission = 
            parameterService.getParameterValue(ProposalDevelopmentDocument.class, KeyConstants.PROPOSALDEVELOPMENT_PROPOSALTYPE_RESUBMISSION);
         
        return !StringUtils.isEmpty(proposalTypeCode) &&
               (proposalTypeCode.equals(proposalTypeCodeResubmission));
    }
    
    /**
     * Is the Proposal Type set to New?
     * @param proposalTypeCode proposal type code
     * @return true or false
     */
    private boolean isProposalTypeNew(String proposalTypeCode) {
        String proposalTypeCodeNew = 
            parameterService.getParameterValue(ProposalDevelopmentDocument.class, KeyConstants.PROPOSALDEVELOPMENT_PROPOSALTYPE_NEW);
         
        return !StringUtils.isEmpty(proposalTypeCode) &&
               (proposalTypeCode.equals(proposalTypeCodeNew));
    }    


	/**
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getProperty(java.lang.String)
	 */
	public String getProperty(String key) {
		String value = kualiConfigurationService.getPropertyString(key);
		return value == null ? "" : value;
	}

	/**
	 * This method returns a {@link Calendar} whose date matches the date passed
	 * as {@link String}
	 * 
	 * @param dateStr
	 *            string in "MM/dd/yyyy" format for which the Calendar value has
	 *            to be returned.
	 * @return Calendar calendar value corresponding to the date string.
	 * @see org.kuali.kra.s2s.service.S2SUtilService#convertDateStringToCalendar(java.lang.String)
	 */
	public Calendar convertDateStringToCalendar(String dateStr) {
		Calendar calendar = null;
		if (dateStr != null) {
			calendar = dateTimeService.getCurrentCalendar();
			calendar.set(Integer.parseInt(dateStr.substring(6, 10)), Integer
					.parseInt(dateStr.substring(0, 2)) - 1, Integer
					.parseInt(dateStr.substring(3, 5)));
		}
		return calendar;
	}

	/**
	 * 
	 * This method is used to get current Calendar
	 * 
	 * @return {@link Calendar}
	 */
	public Calendar getCurrentCalendar() {
		return dateTimeService.getCurrentCalendar();
	}

	/**
	 * This method is used to get Calendar date for the corresponding date
	 * object.
	 * 
	 * @param date(Date)
	 *            date for which Calendar value has to be found.
	 * @return calendar value corresponding to the date.
	 * @see org.kuali.kra.s2s.service.S2SUtilService#convertDateToCalendar(java.sql.Date)
	 */
	public Calendar convertDateToCalendar(Date date) {
		Calendar calendar = null;
		if (date != null) {
			calendar = dateTimeService.getCalendar(date);
		}
		return calendar;
	}

	/**
	 * This method is to set businessObjectService
	 * 
	 * @param businessObjectService(BusinessObjectService)
	 */
	public void setBusinessObjectService(
			BusinessObjectService businessObjectService) {
		this.businessObjectService = businessObjectService;
	}

	/**
	 * Sets the dateTimeService attribute value.
	 * 
	 * @param dateTimeService
	 *            The dateTimeService to set.
	 */
	public void setDateTimeService(DateTimeService dateTimeService) {
		this.dateTimeService = dateTimeService;
	}

	/**
	 * Gets the kualiConfigurationService attribute.
	 * 
	 * @return Returns the kualiConfigurationService.
	 */
	public KualiConfigurationService getKualiConfigurationService() {
		return kualiConfigurationService;
	}

	/**
	 * Sets the ParameterService.
	 * 
	 * @param parameterService
	 *            the parameter service.
	 */
	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

	/**
	 * Sets the kualiConfigurationService attribute value.
	 * 
	 * @param kualiConfigurationService
	 *            The kualiConfigurationService to set.
	 */
	public void setKualiConfigurationService(
			KualiConfigurationService kualiConfigurationService) {
		this.kualiConfigurationService = kualiConfigurationService;
	}

	/**
	 * This method is to get division name using the OwnedByUnit and traversing
	 * through the parent units till the top level
	 * 
	 * @param pdDoc
	 *            Proposal development document.
	 * @return divisionName based on the OwnedByUnit.
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getDivisionName(org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument)
	 */
	public String getDivisionName(ProposalDevelopmentDocument pdDoc) {
		String divisionName = null;
		if (pdDoc != null
				&& pdDoc.getDevelopmentProposal().getOwnedByUnit() != null) {
			Unit ownedByUnit = pdDoc.getDevelopmentProposal().getOwnedByUnit();
			// traverse through the parent units till the top level unit
			while (ownedByUnit.getParentUnit() != null) {
				ownedByUnit = ownedByUnit.getParentUnit();
			}
			divisionName = ownedByUnit.getUnitName();
			if (divisionName.length() > DIVISION_NAME_MAX_LENGTH) {
				divisionName = divisionName.substring(0,
						DIVISION_NAME_MAX_LENGTH);
			}
		}
		return divisionName;
	}

	/**
	 * This method is to get PrincipalInvestigator from person list
	 * 
	 * @param pdDoc
	 *            Proposal development document.
	 * @return ProposalPerson PrincipalInvestigator for the proposal.
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getPrincipalInvestigator(org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument)
	 */
	public ProposalPerson getPrincipalInvestigator(
			ProposalDevelopmentDocument pdDoc) {
		ProposalPerson proposalPerson = null;
		if (pdDoc != null) {
			for (ProposalPerson person : pdDoc.getDevelopmentProposal()
					.getProposalPersons()) {
				if (ContactRole.PI_CODE.equals(person.getProposalPersonRoleId())) {
					proposalPerson = person;
				}
			}
		}
		return proposalPerson;
	}
	/**
	 * Finds all the Investigators associated with the provided pdDoc.
	 * @param ProposalDevelopmentDocument
	 * @return
	 */
	public List<ProposalPerson> getCoInvestigators(ProposalDevelopmentDocument pdDoc) {
		List<ProposalPerson> investigators = new ArrayList<ProposalPerson>();
		if (pdDoc != null) {
			for (ProposalPerson person : pdDoc.getDevelopmentProposal()
					.getProposalPersons()) {
				if(ContactRole.COI_CODE.equals(person.getProposalPersonRoleId())){
					investigators.add(person);
				}
			}
		}
		return investigators;
	}
	/**
	 * Finds all the key Person associated with the provided pdDoc.
	 * @param ProposalDevelopmentDocument
	 * @return
	 */
	public List<ProposalPerson> getKeyPersons (ProposalDevelopmentDocument pdDoc) {
		List<ProposalPerson> keyPersons = new ArrayList<ProposalPerson>();
		if (pdDoc != null) {
			for (ProposalPerson person : pdDoc.getDevelopmentProposal()
					.getProposalPersons()) {
				if(ContactRole.KEY_PERSON_CODE.equals(person.getProposalPersonRoleId())){
					keyPersons.add(person);
				}
			}
		}
		return keyPersons;
	}
	/**
	 * This method is to get a Country object from the country code
	 * 
	 * @param countryCode
	 *            country code for the country.
	 * @return Country object matching the code
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getCountryFromCode(java.lang.String)
	 */
	public Country getCountryFromCode(String countryCode) {
		Map<String, String> countryMap = new HashMap<String, String>();
		countryMap.put(KEY_COUNTRY_CODE, countryCode);
		Country country = (Country) businessObjectService.findByPrimaryKey(
				Country.class, countryMap);
		return country;
	}

	/**
	 * This method is to get a State object from the state name
	 * 
	 * @param stateName
	 *            Name of the state
	 * @return State object matching the name.
	 * @see org.kuali.kra.s2s.service.S2SUtilService#getStateFromName(java.lang.String)
	 */
	public State getStateFromName(String stateName) {
		State state = null;
		Map<String, String> stateMap = new HashMap<String, String>();
		stateMap.put(KEY_STATE_CODE, stateName);
		Iterator<State> stateList = businessObjectService.findMatching(
				State.class, stateMap).iterator();
		while (stateList.hasNext()) {
			state = stateList.next();
			if (state.getStateCode().equals(stateName)) {
				break;
			}
		}
		return state;
	}

	/**
	 * This method compares a proposal person with budget person. It checks
	 * whether the proposal person is from PERSON or ROLODEX and matches the
	 * respective person ID with the person in {@link BudgetPersonnelDetails}.
	 * It returns true only if IDs are not null and also matches eachother.
	 * 
	 * @param proposalPerson -
	 *            key person from proposal
	 * @param budgetPersonnelDetails
	 *            person from BudgetPersonnelDetails
	 * @return true if persons match, false otherwise
	 * @see org.kuali.kra.s2s.service.S2SUtilService#proposalPersonEqualsBudgetPerson(org.kuali.kra.proposaldevelopment.bo.ProposalPerson,
	 *      org.kuali.kra.budget.personnel.BudgetPersonnelDetails)
	 */
	public boolean proposalPersonEqualsBudgetPerson(
			ProposalPerson proposalPerson,
			BudgetPersonnelDetails budgetPersonnelDetails) {
		boolean equal = false;
		if (proposalPerson != null && budgetPersonnelDetails != null) {
			String budgetPersonId = budgetPersonnelDetails.getPersonId();
			if ((proposalPerson.getPersonId() != null && proposalPerson
					.getPersonId().equals(budgetPersonId))
					|| (proposalPerson.getRolodexId() != null && proposalPerson
							.getRolodexId().toString().equals(budgetPersonId))) {
				equal = true;
			}
		}
		return equal;
	}


    /**
     * This method compares a key person with budget person. It checks whether the key person is from PERSON or ROLODEX and matches
     * the respective person ID with the person in {@link BudgetPersonnelDetails}
     * 
     * @param keyPersonInfo - key person to compare
     * @param budgetPersonnelDetails person from BudgetPersonnelDetails
     * @return true if persons match, false otherwise
     * @see org.kuali.kra.s2s.service.S2SUtilService#keyPersonEqualsBudgetPerson(org.kuali.kra.s2s.generator.bo.KeyPersonInfo,
     *      org.kuali.kra.budget.personnel.BudgetPersonnelDetails)
     */
    public boolean keyPersonEqualsBudgetPerson(KeyPersonInfo keyPersonInfo, BudgetPersonnelDetails budgetPersonnelDetails) {
        boolean equal = false;
        if (keyPersonInfo != null && budgetPersonnelDetails != null) {
            String budgetPersonId = budgetPersonnelDetails.getPersonId();
            if ((keyPersonInfo.getPersonId() != null && keyPersonInfo.getPersonId().equals(budgetPersonId))
                    || (keyPersonInfo.getRolodexId() != null && keyPersonInfo.getRolodexId().toString().equals(budgetPersonId))) {
                equal = true;
            }
        }         
        return equal;
    }
    
    public void setProposalDevelopmentService(ProposalDevelopmentService proposalDevelopmentService) {
        this.proposalDevelopmentService = proposalDevelopmentService;
    }
	

	/**
	 * @see org.kuali.kra.s2s.service.S2SUtilService#convertStringArrayToString(String[])
	 */
	public String convertStringArrayToString(String[] stringArray) {
		StringBuilder stringBuilder = new StringBuilder();
		if (stringArray != null && stringArray.length > 0) {
			for (int i = 0; i < stringArray.length; i++) {
				if (stringBuilder.length() > 0) {
					stringBuilder.append(", ");
				}
				stringBuilder.append(stringArray[i]);
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * Finds all the Questionnaire Answers associates with provided
	 * ProposalNumber.
	 * 
	 * @param pdDoc
	 * @return List of Questionnaire {@link Answer}.
	 */
	public List<Answer> getQuestionnaireAnswers(
			ProposalDevelopmentDocument pdDoc,Integer questionnaireId) {
		List<Answer> questionnaireAnswers = new ArrayList<Answer>();
		String proposalNumber = pdDoc.getDevelopmentProposal()
				.getProposalNumber();
		Questionnaire questionnaire = getHighestSequenceNumberQuestionnair(questionnaireId);
		if (questionnaire != null) {
			Map<String, Object> fieldValues = new HashMap<String, Object>();
			fieldValues.put(MODULE_ITEM_KEY, proposalNumber);
			fieldValues.put(MODULE_ITEM_CODE, MODULE_ITEM_CODE_THREE);
			fieldValues.put(MODULE_SUB_ITEM_CODE, MODULE_SUB_ITEM_CODE_ZERO);
			fieldValues.put(MODULE_SUB_ITEM_KEY, MODULE_SUB_ITEM_KEY_ZERO);
			fieldValues.put(QUESTIONNAIRE_REF_ID_FK, questionnaire
					.getQuestionnaireRefId());
			Collection<AnswerHeader> answerHeaderList = businessObjectService
					.findMatching(AnswerHeader.class, fieldValues);
			for (AnswerHeader answerHeader : answerHeaderList) {
				questionnaireAnswers.addAll(answerHeader.getAnswers());
			}
		}
		return questionnaireAnswers;
	}

	/*
	 * Finds the {@link Questionnaire} with Highest Sequence Number
	 * 
	 */
	private Questionnaire getHighestSequenceNumberQuestionnair(
			Integer questionnaireId) {
		Questionnaire highestQuestionnairSequenceNumber = null;
		Map<String, Object> fieldValues = new HashMap<String, Object>();
		fieldValues.put(QUESTIONNAIRE_ID, questionnaireId);
		Collection<Questionnaire> questionnairs = businessObjectService
				.findMatchingOrderBy(Questionnaire.class, fieldValues,
						SEQUENCE_NUMBER, Boolean.FALSE);
		if (questionnairs.size() > 0) {
			List<Questionnaire> questionnairList = new ArrayList<Questionnaire>();
			questionnairList.addAll(questionnairs);
			highestQuestionnairSequenceNumber = questionnairList.get(0);
		}
		return highestQuestionnairSequenceNumber;
	}
	
}
