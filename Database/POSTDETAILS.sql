
  CREATE TABLE "SYSTEM"."POSTDETAILS" 
   (	"FULLNAME" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"DESCRIPTION" VARCHAR2(500 BYTE), 
	"CURRENTDATE" VARCHAR2(100 BYTE), 
	"COLLEGENAME" VARCHAR2(80 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
 
