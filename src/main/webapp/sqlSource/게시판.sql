--------------------------------------------------------
--  파일이 생성됨 - 화요일-8월-08-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table NOTICE
--------------------------------------------------------

  CREATE TABLE "SCOTT"."NOTICE" 
   (	"NOTICE_NUMBER" NUMBER(7,0), 
	"ID" VARCHAR2(12 BYTE), 
	"NOTICE_TITLE" VARCHAR2(120 BYTE), 
	"WRITE_DATE" VARCHAR2(20 BYTE), 
	"NOTICE_CONTENTS" VARCHAR2(4000 BYTE), 
	"VIEWCNT" NUMBER DEFAULT 0
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table NOTICE_ATTACH
--------------------------------------------------------

  CREATE TABLE "SCOTT"."NOTICE_ATTACH" 
   (	"FULLNAME" VARCHAR2(150 BYTE), 
	"NOTICE_NUMBER" NUMBER, 
	"REGDATE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table NOTICE_REPLY
--------------------------------------------------------

  CREATE TABLE "SCOTT"."NOTICE_REPLY" 
   (	"NOTICE_REPLY_NUMBER" NUMBER(5,0), 
	"NOTICE_NUMBER" NUMBER(7,0), 
	"NOTICE_REPLY_ID" VARCHAR2(12 BYTE), 
	"NOTICE_REPLY_WDATE" DATE DEFAULT SYSDATE, 
	"NOTICE_REPLY_CONTENTS" VARCHAR2(900 BYTE), 
	"NOTICE_REPLY_UDATE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table QNA
--------------------------------------------------------

  CREATE TABLE "SCOTT"."QNA" 
   (	"QNA_NUMBER" NUMBER(7,0), 
	"ID" VARCHAR2(12 BYTE), 
	"QNA_TITLE" VARCHAR2(120 BYTE), 
	"WRITE_DATE" VARCHAR2(20 BYTE) DEFAULT NULL, 
	"QNA_CONTENTS" VARCHAR2(4000 BYTE), 
	"VIEWCNT" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table QNA_ATTACH
--------------------------------------------------------

  CREATE TABLE "SCOTT"."QNA_ATTACH" 
   (	"FULLNAME" VARCHAR2(150 BYTE), 
	"QNA_NUMBER" NUMBER, 
	"REGDATE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table QNA_REPLY
--------------------------------------------------------

  CREATE TABLE "SCOTT"."QNA_REPLY" 
   (	"QNA_REPLY_NUMBER" NUMBER(5,0), 
	"QNA_NUMBER" NUMBER(7,0), 
	"QNA_REPLY_ID" VARCHAR2(12 BYTE), 
	"QNA_REPLY_WDATE" DATE DEFAULT SYSDATE, 
	"QNA_REPLY_CONTENTS" VARCHAR2(900 BYTE), 
	"QNA_REPLY_UDATE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STUDY
--------------------------------------------------------

  CREATE TABLE "SCOTT"."STUDY" 
   (	"STUDY_NUMBER" NUMBER(7,0), 
	"ID" VARCHAR2(12 BYTE), 
	"STUDY_TITLE" VARCHAR2(120 BYTE), 
	"WRITE_DATE" VARCHAR2(20 BYTE), 
	"STUDY_CONTENTS" VARCHAR2(4000 BYTE), 
	"VIEWCNT" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STUDY_ATTACH
--------------------------------------------------------

  CREATE TABLE "SCOTT"."STUDY_ATTACH" 
   (	"FULLNAME" VARCHAR2(150 BYTE), 
	"STUDY_NUMBER" NUMBER, 
	"REGDATE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STUDY_REPLY
--------------------------------------------------------

  CREATE TABLE "SCOTT"."STUDY_REPLY" 
   (	"STUDY_REPLY_NUMBER" NUMBER(5,0), 
	"STUDY_NUMBER" NUMBER(7,0), 
	"STUDY_REPLY_ID" VARCHAR2(12 BYTE), 
	"STUDY_REPLY_WDATE" DATE DEFAULT SYSDATE, 
	"STUDY_REPLY_CONTENTS" VARCHAR2(900 BYTE), 
	"STUDY_REPLY_UDATE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into SCOTT.NOTICE
SET DEFINE OFF;
REM INSERTING into SCOTT.NOTICE_ATTACH
SET DEFINE OFF;
REM INSERTING into SCOTT.NOTICE_REPLY
SET DEFINE OFF;
REM INSERTING into SCOTT.QNA
SET DEFINE OFF;
Insert into SCOTT.QNA (QNA_NUMBER,ID,QNA_TITLE,WRITE_DATE,QNA_CONTENTS,VIEWCNT) values (4,'test','test','17-08-08 10:06:37','test',0);
Insert into SCOTT.QNA (QNA_NUMBER,ID,QNA_TITLE,WRITE_DATE,QNA_CONTENTS,VIEWCNT) values (5,'tt','tt','17-08-08 10:11:05','tt',0);
Insert into SCOTT.QNA (QNA_NUMBER,ID,QNA_TITLE,WRITE_DATE,QNA_CONTENTS,VIEWCNT) values (6,'tt','tt','17-08-08 10:11:46','tt',0);
Insert into SCOTT.QNA (QNA_NUMBER,ID,QNA_TITLE,WRITE_DATE,QNA_CONTENTS,VIEWCNT) values (7,'tt','tt','17-08-08 10:12:36','tt',1);
Insert into SCOTT.QNA (QNA_NUMBER,ID,QNA_TITLE,WRITE_DATE,QNA_CONTENTS,VIEWCNT) values (1,'test','test','17-08-08 10:01:59','test',0);
Insert into SCOTT.QNA (QNA_NUMBER,ID,QNA_TITLE,WRITE_DATE,QNA_CONTENTS,VIEWCNT) values (3,'test','test','17-08-08 10:04:53','test',0);
Insert into SCOTT.QNA (QNA_NUMBER,ID,QNA_TITLE,WRITE_DATE,QNA_CONTENTS,VIEWCNT) values (8,'t1','t1','17-08-08 10:28:57','t1',20);
Insert into SCOTT.QNA (QNA_NUMBER,ID,QNA_TITLE,WRITE_DATE,QNA_CONTENTS,VIEWCNT) values (2,'test','test','17-08-08 10:03:59','test',0);
REM INSERTING into SCOTT.QNA_ATTACH
SET DEFINE OFF;
Insert into SCOTT.QNA_ATTACH (FULLNAME,QNA_NUMBER,REGDATE) values ('/2017/08/08/s_05c0753f-d0bb-45ef-9e7e-7fc5d1691c28_1.gif',1,'17-08-08 10:01:59');
Insert into SCOTT.QNA_ATTACH (FULLNAME,QNA_NUMBER,REGDATE) values ('/2017/08/08/s_c1e5b2ed-977d-4fdc-a262-9776a7111cc6_1.gif',4,'17-08-08 10:06:37');
Insert into SCOTT.QNA_ATTACH (FULLNAME,QNA_NUMBER,REGDATE) values ('/2017/08/08/s_ec08d1f7-43af-4637-b850-4a42f218a9ba_1.gif',2,'17-08-08 10:03:59');
Insert into SCOTT.QNA_ATTACH (FULLNAME,QNA_NUMBER,REGDATE) values ('/2017/08/08/5af46591-5323-408c-9b08-1a5a81e8c6e0_R x64 3.4.1.lnk',8,null);
Insert into SCOTT.QNA_ATTACH (FULLNAME,QNA_NUMBER,REGDATE) values ('/2017/08/08/e93046d7-0504-4874-8635-e245790d25ab_rstudio.lnk',8,null);
REM INSERTING into SCOTT.QNA_REPLY
SET DEFINE OFF;
REM INSERTING into SCOTT.STUDY
SET DEFINE OFF;
Insert into SCOTT.STUDY (STUDY_NUMBER,ID,STUDY_TITLE,WRITE_DATE,STUDY_CONTENTS,VIEWCNT) values (2,'test','test','17-08-08 11:41:43','test',2);
REM INSERTING into SCOTT.STUDY_ATTACH
SET DEFINE OFF;
Insert into SCOTT.STUDY_ATTACH (FULLNAME,STUDY_NUMBER,REGDATE) values ('/2017/08/08/s_356d0eb5-4e9e-414c-b489-905acd7097c7_1.gif',2,'17-08-08 11:41:43');
REM INSERTING into SCOTT.STUDY_REPLY
SET DEFINE OFF;
Insert into SCOTT.STUDY_REPLY (STUDY_REPLY_NUMBER,STUDY_NUMBER,STUDY_REPLY_ID,STUDY_REPLY_WDATE,STUDY_REPLY_CONTENTS,STUDY_REPLY_UDATE) values (2,2,'te',to_date('17/08/08','RR/MM/DD'),'te 22',to_date('17/08/08','RR/MM/DD'));
--------------------------------------------------------
--  DDL for Index NOTICE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."NOTICE_PK" ON "SCOTT"."NOTICE" ("NOTICE_NUMBER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index NOTICE_ATTACH_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."NOTICE_ATTACH_PK" ON "SCOTT"."NOTICE_ATTACH" ("FULLNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index NOTICE_REPLY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."NOTICE_REPLY_PK" ON "SCOTT"."NOTICE_REPLY" ("NOTICE_REPLY_NUMBER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0011164
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SYS_C0011164" ON "SCOTT"."QNA" ("QNA_NUMBER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index QNA_ATTACH_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."QNA_ATTACH_PK" ON "SCOTT"."QNA_ATTACH" ("FULLNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index QNA_REPLY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."QNA_REPLY_PK" ON "SCOTT"."QNA_REPLY" ("QNA_REPLY_NUMBER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index STUDY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."STUDY_PK" ON "SCOTT"."STUDY" ("STUDY_NUMBER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index STUDY_ATTACH_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."STUDY_ATTACH_PK" ON "SCOTT"."STUDY_ATTACH" ("FULLNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index STUDY_REPLY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."STUDY_REPLY_PK" ON "SCOTT"."STUDY_REPLY" ("STUDY_REPLY_NUMBER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table NOTICE
--------------------------------------------------------

  ALTER TABLE "SCOTT"."NOTICE" ADD CONSTRAINT "NOTICE_PK" PRIMARY KEY ("NOTICE_NUMBER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."NOTICE" MODIFY ("NOTICE_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table NOTICE_ATTACH
--------------------------------------------------------

  ALTER TABLE "SCOTT"."NOTICE_ATTACH" ADD CONSTRAINT "NOTICE_ATTACH_PK" PRIMARY KEY ("FULLNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."NOTICE_ATTACH" MODIFY ("FULLNAME" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."NOTICE_ATTACH" MODIFY ("NOTICE_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table NOTICE_REPLY
--------------------------------------------------------

  ALTER TABLE "SCOTT"."NOTICE_REPLY" ADD CONSTRAINT "NOTICE_REPLY_PK" PRIMARY KEY ("NOTICE_REPLY_NUMBER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."NOTICE_REPLY" MODIFY ("NOTICE_REPLY_NUMBER" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."NOTICE_REPLY" MODIFY ("NOTICE_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table QNA
--------------------------------------------------------

  ALTER TABLE "SCOTT"."QNA" ADD CONSTRAINT "SYS_C0011164" PRIMARY KEY ("QNA_NUMBER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table QNA_ATTACH
--------------------------------------------------------

  ALTER TABLE "SCOTT"."QNA_ATTACH" ADD CONSTRAINT "QNA_ATTACH_PK" PRIMARY KEY ("FULLNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."QNA_ATTACH" MODIFY ("FULLNAME" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."QNA_ATTACH" MODIFY ("QNA_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table QNA_REPLY
--------------------------------------------------------

  ALTER TABLE "SCOTT"."QNA_REPLY" ADD CONSTRAINT "QNA_REPLY_PK" PRIMARY KEY ("QNA_REPLY_NUMBER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."QNA_REPLY" MODIFY ("QNA_REPLY_NUMBER" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."QNA_REPLY" MODIFY ("QNA_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STUDY
--------------------------------------------------------

  ALTER TABLE "SCOTT"."STUDY" ADD CONSTRAINT "STUDY_PK" PRIMARY KEY ("STUDY_NUMBER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."STUDY" MODIFY ("STUDY_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STUDY_ATTACH
--------------------------------------------------------

  ALTER TABLE "SCOTT"."STUDY_ATTACH" ADD CONSTRAINT "STUDY_ATTACH_PK" PRIMARY KEY ("FULLNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."STUDY_ATTACH" MODIFY ("FULLNAME" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."STUDY_ATTACH" MODIFY ("STUDY_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STUDY_REPLY
--------------------------------------------------------

  ALTER TABLE "SCOTT"."STUDY_REPLY" ADD CONSTRAINT "STUDY_REPLY_PK" PRIMARY KEY ("STUDY_REPLY_NUMBER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."STUDY_REPLY" MODIFY ("STUDY_REPLY_NUMBER" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."STUDY_REPLY" MODIFY ("STUDY_NUMBER" NOT NULL ENABLE);
