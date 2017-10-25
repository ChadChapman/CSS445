SHOW DATABASES ;

USE chadtc;
SHOW TABLES;

CREATE TABLE Employee (
  EmployeeId INT
  ,FirstName VARCHAR(50) NOT NULL
  ,RecordCreateDate TIMESTAMP
    DEFAULT CURRENT_TIMESTAMP
  ,PRIMARY KEY(EmployeeID)
);

SHOW TABLES;

CREATE TABLE Employee2 (
  EmpId INT
  ,Fname VARCHAR(50) NOT NULL
  ,Lname VARCHAR(50) NOT NULL
  ,Gender VARCHAR(50)
  ,MgrId INT
  ,LocId INT
  ,EmailAddress VARCHAR(80)
);

SHOW TABLES;

CREATE TABLE Location (
  LocId INT
  ,LocName VARCHAR(100)
  ,City VARCHAR(100)
  ,State VARCHAR(100)
);

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

INSERT INTO Location (LocId, LocName, City, State) VALUES
  (21, 'Tacoma Dome', 'Tacoma', 'WA')
  ,(23, 'Edgewater Inn', 'Coos Bay', 'OR')

SELECT * FROM Location;
SELECT * FROM Employee;

ALTER TABLE Employee
  ADD LastName VARCHAR(50) DEFAULT 'unknown'
  AFTER FirstName

SELECT * FROM Employee;
INSERT INTO Employee (EmployeeId, FirstName, LastName) VALUES
  (34, 'Robert', 'Paulson')
  ,(00, 'Tyler', 'Durden')

SELECT * FROM Employee;
