 CREATE TABLE IF NOT EXISTS STATUS_ENUM(
   ENUM_ID INT(1),
   DESCRIPTION VARCHAR2(50)   
   );
   
    
   CREATE TABLE IF NOT EXISTS DEGREE_ENUM(
   ENUM_ID INT(1),
   DESCRIPTION VARCHAR2(50)
   );
   
CREATE TABLE IF NOT EXISTS CANDIDATE(
	PERSON_ID INT(16) AUTO_INCREMENT,
   FIRST_NAME VARCHAR2(100),
   LAST_NAME VARCHAR2(100),
   PHONE_NUMBER VARCHAR2(10),
   EMAIL_ADDRESS VARCHAR2(20),  
   
   START_DATE DATE,
   DEGREE_EN INT(1),
   MAJOR VARCHAR2(20),
   SKILL_SET VARCHAR2(100),
   GRADUATION_DATE DATE,
   STATUS_EN INT(1),
   COMMENTS VARCHAR2(100),
   RESUME BLOB,
   
     
   PRIMARY KEY (PERSON_ID),
   FOREIGN KEY (DEGREE_EN) REFERENCES STATUS_ENUM(ENUM_ID),
   FOREIGN KEY (STATUS_EN) REFERENCES DEGREE_ENUM(ENUM_ID)
 
   );   

   
--INSERT INTO STATUS_ENUM (ENUM_ID, DESCRIPTION) VALUES (1,'F1');
--INSERT INTO STATUS_ENUM  (ENUM_ID, DESCRIPTION) VALUES (2,'H1B');
--INSERT INTO STATUS_ENUM  (ENUM_ID, DESCRIPTION) VALUES (3,'F1-OPT');
--INSERT INTO STATUS_ENUM  (ENUM_ID, DESCRIPTION) VALUES (4,'GREEN CARD');
--INSERT INTO STATUS_ENUM   (ENUM_ID, DESCRIPTION) VALUES (5,'U.S CITIZEN');
--
--INSERT INTO DEGREE_ENUM  (ENUM_ID, DESCRIPTION) VALUES (1,'BACHELORS');
--INSERT INTO DEGREE_ENUM   (ENUM_ID, DESCRIPTION) VALUES (2,'MASTERS');
--INSERT INTO DEGREE_ENUM (ENUM_ID, DESCRIPTION) VALUES (3,'EXPERIENCED');

-- INSERT INTO CANDIDATE (PERSON_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL_ADDRESS, START_DATE, DEGREE_EN, MAJOR, SKILL_SET, GRADUATION_DATE, STATUS_EN, COMMENTS, RESUME)
--VALUES (1,'BRAD','MARK','1234567890','brad.mark@gmail.com','2016-07-01',2,'CS','C,C++,JAVA','2016-05-01',1,'PASSED ALL TESTS', RAWTOHEX('HELLO'));
   
  