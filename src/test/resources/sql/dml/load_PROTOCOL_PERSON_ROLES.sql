DELETE FROM PROTOCOL_ATTACHMENT_PERSONNEL;
DELETE FROM PROTOCOL_PERSONS;
DELETE FROM PROTOCOL_PERSON_ROLE_MAPPING;
DELETE FROM PROTOCOL_PERSON_ROLES;
INSERT INTO PROTOCOL_PERSON_ROLES ( PROTOCOL_PERSON_ROLE_ID, DESCRIPTION, UNIT_DETAILS_REQUIRED, AFFILIATION_DETAILS_REQUIRED, TRAINING_DETAILS_REQUIRED, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID )  VALUES ( 'PI', 'Principal Investigator', 'Y', 'Y', 'Y', to_date('2010-01-28 12:00:00','YYYY-MM-DD HH24:MI:SS'),'admin', 1, 'BE78D35C1E76405AB6955A7B87A8AD23' ); 
INSERT INTO PROTOCOL_PERSON_ROLES ( PROTOCOL_PERSON_ROLE_ID, DESCRIPTION, UNIT_DETAILS_REQUIRED, AFFILIATION_DETAILS_REQUIRED, TRAINING_DETAILS_REQUIRED, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID )  VALUES ( 'COI', 'Co-Investigator', 'Y', 'Y', 'Y', to_date('2010-01-28 12:00:00','YYYY-MM-DD HH24:MI:SS'),'admin', 1, 'D5AD9B2933DA4CC28922A96A38FE0905' ); 
INSERT INTO PROTOCOL_PERSON_ROLES ( PROTOCOL_PERSON_ROLE_ID, DESCRIPTION, UNIT_DETAILS_REQUIRED, AFFILIATION_DETAILS_REQUIRED, TRAINING_DETAILS_REQUIRED, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID )  VALUES ( 'SP', 'Study Personnel', 'Y', 'Y', 'Y', to_date('2010-01-28 12:00:00','YYYY-MM-DD HH24:MI:SS'),'admin', 1, '4AEDCBE139A040B9A21DFC4C7AED02BC' ); 
INSERT INTO PROTOCOL_PERSON_ROLES ( PROTOCOL_PERSON_ROLE_ID, DESCRIPTION, UNIT_DETAILS_REQUIRED, AFFILIATION_DETAILS_REQUIRED, TRAINING_DETAILS_REQUIRED, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID )  VALUES ( 'CA', 'Correspondent Administrator', 'N', 'N', 'N', to_date('2010-01-28 12:00:00','YYYY-MM-DD HH24:MI:SS'),'admin', 1, '579644BAD4AD4F6EA2C0AF7A9C246C6C' ); 
INSERT INTO PROTOCOL_PERSON_ROLES ( PROTOCOL_PERSON_ROLE_ID, DESCRIPTION, UNIT_DETAILS_REQUIRED, AFFILIATION_DETAILS_REQUIRED, TRAINING_DETAILS_REQUIRED, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID )  VALUES ( 'CRC', 'Correspondent - CRC', 'N', 'N', 'N', to_date('2010-01-28 12:00:00','YYYY-MM-DD HH24:MI:SS'),'admin', 1, '8A5E7CFB7D014A1A89E1E8A36CDFF86B' ); 

