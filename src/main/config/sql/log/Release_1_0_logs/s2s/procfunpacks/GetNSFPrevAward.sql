CREATE OR REPLACE PROCEDURE Getnsfprevaward (AS_PROPOSAL_NUMBER IN OSP$EPS_PROPOSAL.PROPOSAL_NUMBER%TYPE,
     cur_generic IN OUT Result_Sets.cur_generic) IS

BEGIN
  OPEN cur_generic FOR
 SELECT ' ' AWARD
 FROM dual;
  
 /*
 ************* There is no AWARD table - Code modified to return ' ' *************
  
 SELECT DECODE(A.SPONSOR_AWARD_NUMBER,NULL,' ',A.SPONSOR_AWARD_NUMBER) AWARD
 FROM  OSP$AWARD A, OSP$EPS_PROPOSAL P
 WHERE  P.PROPOSAL_NUMBER = as_proposal_number
 AND      P.CURRENT_AWARD_NUMBER = A.MIT_AWARD_NUMBER
   AND      A.SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER) FROM OSP$AWARD WHERE
             MIT_AWARD_NUMBER = A.MIT_AWARD_NUMBER);
*/


END;
/

