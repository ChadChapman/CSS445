

SHOW DATABASES ;

USE chadtc;
SHOW TABLES;



CREATE TABLE Class (
  ClassId INT
  ,Cname VARCHAR(100)
  ,InstructorId INT
  ,LocId INT
  ,TotHours INT
  ,PRIMARY KEY (ClassId)
);

SHOW TABLES;

ALTER TABLE Employee #example only now
  ADD LastName VARCHAR(50) DEFAULT 'unknown'
  AFTER FirstName;

SELECT * FROM Employee;

CREATE TABLE Employee (
   EmployeeId INT NOT NULL #implied b/c is pk?
  ,FirstName VARCHAR(50)
  ,LastName VARCHAR(50)
  ,Gender VARCHAR(20) #be PC and non-binary?
  ,ManagerId INT #ok to be NULL
  ,EmailAddress VARCHAR(80) #NULL ok? not sure
  ,RecordCreateDate TIMESTAMP
  DEFAULT CURRENT_TIMESTAMP
  ,PRIMARY KEY(EmployeeID)
);

SHOW TABLES;
SELECT * FROM Employee;

CREATE TABLE Transcript (
  TranscriptId INT AUTO_INCREMENT
  ,EmployeeId INT NOT NULL
  ,ClassId INT NOT NULL
  ,Status VARCHAR(30)
  ,PRIMARY KEY(TranscriptId)
);

CREATE TABLE Class (
   ClassId INT AUTO_INCREMENT
  ,Name VARCHAR(50)
  ,InstructorId INT #ok to be NULL ?
  ,TotalHours INT
  ,RecordCreateDate TIMESTAMP
  DEFAULT CURRENT_TIMESTAMP
  ,PRIMARY KEY(ClassID)
)
AUTO_INCREMENT=1001;

ALTER TABLE Class  #fix this statement
    CHANGE TotalHours CreditHours SMALLINT;

SELECT * FROM Class;
SELECT * FROM Transcript;
SELECT * FROM Employee;
SHOW TABLES;

INSERT INTO Employee (EmployeeId, FirstName, LastName, Gender, ManagerId
  ,EmailAddress) VALUES
  (106, 'Petrina', 'Tillman', 'F', NULL, 'Petrina.Tillman@company.com')
  ,(112, 'Alec', 'Wilhoit', 'M', 106, 'Alec.Wilhoit@company.com');

INSERT INTO Employee (EmployeeId, FirstName, LastName, Gender, ManagerId
  ,EmailAddress) VALUES
  (117, 'Lourie', 'Johns', 'F', 106, 'Lourie.Johns@company.com')
  ,(119, 'Florencio', 'Chaves', 'M', 112, 'Florencio.Chaves@company.com')
  ,(122, 'Tanya', 'Vanasse', 'F', 112, 'Tanya.Vanasse@company.com')
  ,(127, 'Chana', 'Thorman', 'F', 112, 'Chana.Thorman@company.com')
  ,(139, 'Geoffery', 'Sjorgren', 'M', 117, 'Geoffrey.Sjorgren@company.com')
  ,(140, 'Gorardo', 'Borrego', 'M', 117, 'Gorardo.Borrego@company.com')
  ,(142, 'Blain', 'Wishon', 'M', 117, 'Blain.Wishon@company.com')
  ,(150, 'Danita', 'Lansford', 'F', 122, 'Danita.Lansford@company.com')
;

INSERT INTO Class (Name, InstructorId, CreditHours) VALUES
  ('Customer Service 101', 119, 10)
  ,('Synergy For Dummies', 119, 20);

INSERT INTO Class (Name, InstructorId, CreditHours) VALUES
  ('Conflict Management', 112, 10)
  ,('Building Relationships', 117, 25)
  ,('Managment Essentials', 112, 40)
  ,('Office Synergy', 117, 10)
  ,('How to Succeed', 112, 10);

INSERT INTO Transcript (EmployeeId, ClassId, Status) VALUES
  (106, 1005, 'COMPLETED')
  ,(106, 1002, 'REGISTERED');

INSERT INTO Transcript (EmployeeId, ClassId, Status) VALUES
  (106, 1003, 'COMPLETED')
  ,(112, 1003, 'REGISTERED')
  ,(112, 1001, 'COMPLETED')
  ,(117, 1001, 'COMPLETED')
  ,(117, 1002, 'COMPLETED')
  ,(127, 1001, 'REGISTERED')
  ,(127, 1002, 'REGISTERED')
  ,(127, 1003, 'COMPLETED')
  ,(139, 1004, 'REGISTERED')
  ,(139, 1006, 'REGISTERED')
  ,(142, 1003, 'COMPLETED')
  ,(142, 1005, 'REGISTERED')
  ,(150, 1005, 'COMPLETED');

##### #6
SELECT Name AS ClassName
  ,FirstName, LastName, Gender
FROM Employee
INNER JOIN Transcript
ON Employee.EmployeeId = Transcript.EmployeeId
INNER JOIN Class
ON Class.ClassId = Transcript.ClassId
WHERE Status = 'COMPLETED' OR Status = 'REGISTERED';

##### #7

/*
INNER JOIN Class
    ON Class.ClassId = Transcript.ClassId
 */
###########################################################################
CREATE TABLE TestTable (
   ClassId INT AUTO_INCREMENT
  ,Name VARCHAR(50)
  ,InstructorId INT #ok to be NULL ?
  ,TotalHours INT
  ,PRIMARY KEY(ClassID)
)
AUTO_INCREMENT=1001;

INSERT INTO TestTable (Name, InstructorId, TotalHours) VALUES
  ('CS class', 112, 40);
INSERT INTO TestTable (Name, InstructorId, TotalHours) VALUES
  ('CS seminar', 110, 25);
SHOW TABLES;
SELECT * FROM TestTable;
