SELECT * FROM (SELECT COUNT(1) AS C, OBJ_ID FROM KRIM_TYP_T GROUP BY OBJ_ID) WHERE C > 1; 
--A8488117C37040B2A56531BCBB7DCD9B
--KCIRB-1214.SQL
SELECT * FROM (SELECT COUNT(1) AS C, OBJ_ID FROM KRIM_PERM_T GROUP BY OBJ_ID) WHERE C > 1; 
--3F0FE9D4-83BC-7CC6-5292-49E6F23FA6F0
--KCIRB-857, KCIRB-859.SQL
SELECT * FROM (SELECT COUNT(1) AS C, OBJ_ID FROM KRIM_PERM_ATTR_DATA_T GROUP BY OBJ_ID) WHERE C > 1; 
--77151AD4B1F69985E0404F8189D80E8B
--KRACOEUS-3399.SQL, KCINFR-131.SQL
SELECT * FROM (SELECT COUNT(1) AS C, OBJ_ID FROM KRIM_ROLE_T GROUP BY OBJ_ID) WHERE C > 1; -- NO MATCH
SELECT * FROM (SELECT COUNT(1) AS C, OBJ_ID FROM KRIM_ROLE_MBR_ATTR_DATA_T GROUP BY OBJ_ID) WHERE C > 1; 
--5D0BD1CB88BF4EF794A08CA6E892F500
--KCIRB-694.SQL
SELECT * FROM (SELECT COUNT(1) AS C, OBJ_ID FROM KRIM_ROLE_PERM_T GROUP BY OBJ_ID) WHERE C > 1; 
--1C0D53B5D8EC4928A672DA52C2DB75F4, D28CF8A4-0951-DE4E-4350-D29F8FEFE053
--KCIRB-1214.SQL, --KCIRB-857, KCIRB-859.SQL
SELECT * FROM (SELECT COUNT(1) AS C, OBJ_ID FROM KRIM_GRP_MBR_T GROUP BY OBJ_ID) WHERE C > 1; 
--77151AD4B1E59985E0404F8189D80E8B
--KCIRB-781
SELECT * FROM (SELECT COUNT(1) AS C, OBJ_ID FROM KRNS_PARM_T GROUP BY OBJ_ID) WHERE C > 1; 
--d6173017-d9d4-4309-b69c-75c111efb04b

--This has NOT come thru the incremental SQLs. Direct update to KRDBA?

INSERT INTO KRNS_PARM_T (APPL_NMSPC_CD,CONS_CD,NMSPC_CD,OBJ_ID,PARM_DESC_TXT,PARM_DTL_TYP_CD,PARM_NM,PARM_TYP_CD,TXT,VER_NBR)
  VALUES ('KUALI','A','KC-B','d6173017-d9d4-4309-b69c-75c111efb04b','Broad F','D','BROAD_F_AND_A','CONFG','421502',1)
/
INSERT INTO KRNS_PARM_T (APPL_NMSPC_CD,CONS_CD,NMSPC_CD,OBJ_ID,PARM_DESC_TXT,PARM_DTL_TYP_CD,PARM_NM,PARM_TYP_CD,TXT,VER_NBR)
  VALUES ('KUALI','A','KC-B','d6173017-d9d4-4309-b69c-75c111efb04b','Subcontract F greater than 25K','D','SUBCONTRACTOR_F_AND_A_GT_25K','CONFG','420630',1)
/
INSERT INTO KRNS_PARM_T (APPL_NMSPC_CD,CONS_CD,NMSPC_CD,OBJ_ID,PARM_DESC_TXT,PARM_DTL_TYP_CD,PARM_NM,PARM_TYP_CD,TXT,VER_NBR)
  VALUES ('KUALI','A','KC-B','d6173017-d9d4-4309-b69c-75c111efb04b','Subcontract F less than 25K','D','SUBCONTRACTOR_F_AND_A_LT_25K','CONFG','420610',1)
/
