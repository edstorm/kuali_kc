set define off 
set sqlblanklines on 
spool KR-Release-3_0_1-3_1_S1-Upgrade-Oracle-Install.log
@ORACLE/DML/DML_BS_OBJ_ID_CLEAN.sql
@ORACLE/DML/DML_BS2_KRNS_PARM_DTL_TYP_T.sql
@ORACLE/DML/DML_BS2_KRNS_PARM_T.sql
@ORACLE/DML/DML_BS3_KRIM_PERM_T.sql
@ORACLE/DML/DML_BS4_KRIM_PERM_ATTR_DATA_T.sql
@ORACLE/DML/DML_BS4_KRIM_ROLE_PERM_T.sql
@ORACLE/DML/DML_BS5_KREW_RULE_RSP_T.sql
@ORACLE/DML/DML_BS5_KREW_RULE_T.SQL.sql
@ORACLE/DML/DML_BS5_KRIM_APP_ADMIN.sql
@ORACLE/DML/DML_BS5_KRIM_GROUP_MBR_T.sql
@ORACLE/DML/DML_BS7_KRNS_PARM_T.sql
commit;
exit;
