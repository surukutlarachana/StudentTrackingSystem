
  CREATE TABLE "SYSTEM"."DIRECTORATE" 
   (	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"UNIVERSITY" VARCHAR2(100 BYTE), 
	"DESIGNATION" VARCHAR2(20 BYTE), 
	"MOBILENUMBER" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"FIRSTCOLLEGE" VARCHAR2(100 BYTE), 
	"SECONDCOLLEGE" VARCHAR2(100 BYTE), 
	"THIRDCOLLEGE" VARCHAR2(100 BYTE), 
	"FOURTHCOLLEGE" VARCHAR2(100 BYTE), 
	"CURRENTCOLLEGE" VARCHAR2(100 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
 
