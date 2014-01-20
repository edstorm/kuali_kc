-- Add KRIM_PERM_T with PERM_ID = '1247' and PERM_TMPL_ID = '1002'
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND)
    VALUES (KRIM_PERM_ID_BS_S.NEXTVAL, sys_guid(), 1, (SELECT PERM_TMPL_ID FROM KRIM_PERM_TMPL_T WHERE NM = 'Perform Document Action'), 'KC-PD', 'Delete Proposal', 'Delete a Proposal', 'Y');
    
COMMIT;