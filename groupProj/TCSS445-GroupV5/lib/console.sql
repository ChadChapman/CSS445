/*
 * TCSS 445A - Autumn 2017 - Group A
 */

/* in  command prompt */
/*
mysql -u root -p
CREATE DATABASE internship_review;
GRANT ALL PRIVILEGES ON internship_review.* TO '<UserNameHere>'@'localhost';
FLUSH PRIVILEGES;
quit;
*/
/* end command prompt */
/* from @localhost in Database view in IntelliJ, right-click properties, schemas tab, select internship_review */
/* for cssgate: */
/* mysql -u keeganjk -h cssgate.insttech.washington.edu -p */


USE keeganjk;

DROP TABLE IF EXISTS Student;
CREATE TABLE Student (FirstName    VARCHAR(30)
  , LastName     VARCHAR(30)
  , StudentID    VARCHAR(15)
  , PhoneNumber  CHAR(10)
  , Major        VARCHAR(30)
  , PRIMARY KEY(StudentID)
);

DROP TABLE IF EXISTS Moderator;
CREATE TABLE Moderator (EmployeeID INT
  , FirstName    VARCHAR(30)
  , LastName     VARCHAR(30)
  , Gender       CHAR(1)
  , EmailAddress VARCHAR(50)
  , PRIMARY KEY(EmployeeID)
);

DROP TABLE IF EXISTS Employer;
CREATE TABLE Employer (Name VARCHAR(50)
  , Location     VARCHAR(50)
  , EmailAddress VARCHAR(50)
  , PhoneNumber  CHAR(10)
  , PRIMARY KEY(Name)
);

DROP TABLE IF EXISTS Review;
CREATE TABLE Review (CompanyName VARCHAR(50)
  , ReviewID      INT AUTO_INCREMENT
  , ReviewerEmail VARCHAR(50)
  , ReviewText    VARCHAR(500)
  , PRIMARY KEY(ReviewID)
);

DROP TABLE IF EXISTS Posting;
CREATE TABLE Posting (CompanyName VARCHAR(50)
  , Location     VARCHAR(50)
  , EmailAddress VARCHAR(50)
  , HourlyWage   DOUBLE
  , StartDate    DATE
  , Duration     INT
  , PRIMARY KEY(EmailAddress)
);

INSERT INTO Student VALUES
    ('Chad'  , 'Chapman', '0163579' ,'3606782349', 'Computer Science')
  , ('Hui'   , 'Cai'    , '0263156' ,'3605478925', 'Computer Science')
  , ('Hanan' , 'Abdo'   , '0356945' ,'2066742498', 'Computer Science')
  , ('Keegan', 'James'  , '0478934' ,'3608935325', 'Economics')
;

INSERT INTO Moderator VALUES
  (538935  , 'Kevin'  , 'Anderson'          , 'M'       , 'kevinanderson@uw.edu')
;

INSERT INTO Employer VALUES
    ('InfoBlox'               , 'Tacoma'  , 'info@infoblox.com'          , '4089864000')
  , ('SiteCrafting'           , 'Tacoma'  , 'hello@sitecrafting.com'     , '2532722248')
  , ('Cascadia Software, Inc.', 'Puyallup', 'cyoung@cascadiasoftware.com', '3608720530')
;

INSERT INTO Review (CompanyName, ReviewerEmail, ReviewText) VALUES
    ('InfoBlox'    , 'huicai@uw.edu'        , 'Great company, people, etc.')
  , ('InfoBlox'    , 'departments@gmail.com', 'So so.')
  , ('SiteCrafting', 'hananabdo@uw.edu'     , 'I learned a lot about html and communicating with customers.')
;

INSERT INTO Posting VALUES
    ('InfoBlox'    , 'Tacoma'  , 'info@infoblox.com'     , 14.40, DATE('2018-01-01 06:00:00'), 120)
  , ('SiteCrafting', 'Puyallup', 'hello@sitecrafting.com', 12.00, CURRENT_DATE               , 30)
;
