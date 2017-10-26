#TCSS 445 HW#2



#8 Concatenated first and last name of all employees with columns for hours completed and hours registered, no nulls

#the one below works
SELECT CONCAT(FirstName, " ", LastName) AS Name
  , IFNULL(HoursCompleted, 0) AS HoursCompleted
  , IFNULL(HoursRegistered, 0) AS HoursRegistered
FROM Employee E
LEFT OUTER JOIN (
	SELECT EmployeeId AS Eid
		, Status
    	, SUM(CreditHours) AS HoursCompleted
    FROM chadtc.Class C
    INNER JOIN Transcript T
    ON C.ClassId = T.ClassId
    WHERE Status = 'COMPLETED'
    GROUP BY Eid) 
	AS HC
ON E.EmployeeId = HC.Eid
LEFT OUTER JOIN (
	SELECT EmployeeId
    	, Name, Status
    	, SUM(CreditHours) AS HoursRegistered
    FROM chadtc.Class CR
    INNER JOIN Transcript TR
    ON CR.ClassId = TR.ClassId
    WHERE Status = 'REGISTERED'
    GROUP BY TR.EmployeeId) 
	AS HR
ON E.EmployeeId = HR.EmployeeId
ORDER BY E.LastName ASC ;


