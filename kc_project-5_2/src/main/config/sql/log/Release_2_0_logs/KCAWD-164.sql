CREATE TABLE AWARD_PERSONS (
   AWARD_PERSON_ID number(22,0) NOT NULL,
   AWARD_ID NUMBER(22,0) NOT NULL,
   AWARD_NUMBER varchar2(10) NOT NULL,
   SEQUENCE_NUMBER number(4,0) NOT NULL,
   PERSON_ID varchar2(10),
   ROLODEX_ID decimal(6),
   FULL_NAME varchar2(90),
   CONTACT_ROLE_CODE varchar2(12) NOT NULL,
   ACADEMIC_YEAR_EFFORT number(5,2),
   CALENDAR_YEAR_EFFORT number(5,2),
   SUMMER_EFFORT number(5,2),
   TOTAL_EFFORT number(5,2),
   FACULTY_FLAG char(1) NOT NULL,
   UPDATE_TIMESTAMP date NOT NULL,
   UPDATE_USER varchar2(60) NOT NULL,
   VER_NBR decimal(8) NOT NULL,
   OBJ_ID varchar2(36) NOT NULL
);

ALTER TABLE AWARD_PERSONS ADD CONSTRAINT PK_AWARD_PERSONS PRIMARY KEY (AWARD_PERSON_ID);

-- Add reference to AWARD table
ALTER TABLE AWARD_PERSONS ADD CONSTRAINT FK_AWARD_AWARD_PERSONS FOREIGN KEY (AWARD_ID) REFERENCES AWARD(AWARD_ID);

-- Add reference to EPS_PROPOSAL_PERSON_ROLE table
ALTER TABLE AWARD_PERSONS ADD CONSTRAINT FK_PROP_PERS_ROLE_AWD_PERSONS FOREIGN KEY (CONTACT_ROLE_CODE) REFERENCES EPS_PROP_PERSON_ROLE(PROP_PERSON_ROLE_ID);

CREATE TABLE AWARD_PERSON_UNITS (
   AWARD_PERSON_UNIT_ID number(22,0) NOT NULL,
   AWARD_PERSON_ID number(22,0) NOT NULL,
   UNIT_NUMBER VARCHAR2(8) NOT NULL,
   LEAD_UNIT_FLAG CHAR(1) NOT NULL,
   UPDATE_TIMESTAMP date NOT NULL,
   UPDATE_USER varchar2(60) NOT NULL,
   VER_NBR decimal(8) NOT NULL,
   OBJ_ID varchar2(36) NOT NULL
);

ALTER TABLE AWARD_PERSON_UNITS ADD CONSTRAINT PK_AWARD_PERSON_UNITS PRIMARY KEY (AWARD_PERSON_UNIT_ID);

-- Add reference to PERSON table
ALTER TABLE AWARD_PERSON_UNITS ADD CONSTRAINT FK_APU_AW_PERSON FOREIGN KEY (AWARD_PERSON_ID) REFERENCES AWARD_PERSONS(AWARD_PERSON_ID);

-- Add reference to UNIT table
ALTER TABLE AWARD_PERSON_UNITS ADD CONSTRAINT FK_APU_UNIT FOREIGN KEY (UNIT_NUMBER) REFERENCES UNIT(UNIT_NUMBER);