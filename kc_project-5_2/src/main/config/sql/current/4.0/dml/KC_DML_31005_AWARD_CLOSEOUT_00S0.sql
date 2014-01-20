INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '1'),'001002-00001',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '1'),'001002-00001',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '1'),'001002-00001',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '1'),'001002-00001',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00002' AND SEQUENCE_NUMBER = '1'),'001002-00002',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00002' AND SEQUENCE_NUMBER = '1'),'001002-00002',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00002' AND SEQUENCE_NUMBER = '1'),'001002-00002',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00002' AND SEQUENCE_NUMBER = '1'),'001002-00002',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00003' AND SEQUENCE_NUMBER = '1'),'001002-00003',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00003' AND SEQUENCE_NUMBER = '1'),'001002-00003',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00003' AND SEQUENCE_NUMBER = '1'),'001002-00003',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00003' AND SEQUENCE_NUMBER = '1'),'001002-00003',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00005' AND SEQUENCE_NUMBER = '1'),'001002-00005',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00005' AND SEQUENCE_NUMBER = '1'),'001002-00005',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00005' AND SEQUENCE_NUMBER = '1'),'001002-00005',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00005' AND SEQUENCE_NUMBER = '1'),'001002-00005',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00009' AND SEQUENCE_NUMBER = '1'),'001002-00009',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00009' AND SEQUENCE_NUMBER = '1'),'001002-00009',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00009' AND SEQUENCE_NUMBER = '1'),'001002-00009',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00009' AND SEQUENCE_NUMBER = '1'),'001002-00009',1,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '2'),'001002-00001',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '2'),'001002-00001',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '2'),'001002-00001',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '2'),'001002-00001',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00002' AND SEQUENCE_NUMBER = '2'),'001002-00002',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00002' AND SEQUENCE_NUMBER = '2'),'001002-00002',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00002' AND SEQUENCE_NUMBER = '2'),'001002-00002',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00002' AND SEQUENCE_NUMBER = '2'),'001002-00002',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00009' AND SEQUENCE_NUMBER = '2'),'001002-00009',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00009' AND SEQUENCE_NUMBER = '2'),'001002-00009',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00009' AND SEQUENCE_NUMBER = '2'),'001002-00009',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00009' AND SEQUENCE_NUMBER = '2'),'001002-00009',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00003' AND SEQUENCE_NUMBER = '2'),'001002-00003',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00003' AND SEQUENCE_NUMBER = '2'),'001002-00003',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00003' AND SEQUENCE_NUMBER = '2'),'001002-00003',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00003' AND SEQUENCE_NUMBER = '2'),'001002-00003',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00005' AND SEQUENCE_NUMBER = '2'),'001002-00005',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00005' AND SEQUENCE_NUMBER = '2'),'001002-00005',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00005' AND SEQUENCE_NUMBER = '2'),'001002-00005',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00005' AND SEQUENCE_NUMBER = '2'),'001002-00005',2,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '3'),'001002-00001',3,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Financial'),'Financial Report',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '3'),'001002-00001',3,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Property'),'Property',null,'Y','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '3'),'001002-00001',3,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Patent'),'Patent',TO_DATE('20160630','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO AWARD_CLOSEOUT (AWARD_CLOSEOUT_ID,AWARD_ID,AWARD_NUMBER,SEQUENCE_NUMBER,CLOSEOUT_REPORT_CODE,CLOSEOUT_REPORT_NAME,DUE_DATE,MULTIPLE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_AWARD_AWARD_CLOSEOUT.NEXTVAL,(SELECT AWARD_ID FROM AWARD WHERE AWARD_NUMBER = '001002-00001' AND SEQUENCE_NUMBER = '3'),'001002-00001',3,(SELECT CLOSEOUT_REPORT_CODE FROM CLOSEOUT_REPORT_TYPE WHERE DESCRIPTION = 'Technical'),'Technical',TO_DATE('20160315','YYYYMMDD'),'N','quickstart',SYSDATE,SYS_GUID(),0)
/
