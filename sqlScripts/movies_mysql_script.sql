/* Comment the first two lines for CSSGATE*/
CREATE DATABASE MovieDB;
USE MovieDB;

CREATE TABLE Movies (
	title VARCHAR(100),
	`year` INT,
	length INT,
	genre VARCHAR(10),
	studioName VARCHAR(30),
	`producerC#` INT,
	PRIMARY KEY(title, `year`)
);

INSERT INTO Movies VALUES
('Pretty Woman', 1990, 119, 'romance', 'Disney', 12345),
('Star Wars', 1977, 124, 'SciFi', 'Fox', 12345),
('Wayne\'s World', 1992, 95, 'comedy', 'Paramount', 12345 ),
('Gone With the Wind', 1939, 231, 'drama', 'MGM Studios', 54321),
('Galaxy Quest', 1999, 104, 'comedy', 'DreamWorks', 54321),
('Love Story', 1970, 99, 'drama', 'Paramount', 12345),
('Ordinary People', 1980, 124, 'drama', 'Paramount', 12345),
('Titanic', 1997, 194, 'drama', 'Fox', 12345),
('GoldenEye', 1995, 130, 'action', 'MGM Studios', 54321),
('Get Shorty', 1995, 105, 'comedy', 'MGM Studios', 54321);

CREATE TABLE MovieStar (
	`name` VARCHAR(30) PRIMARY KEY,
	address VARCHAR(30),
	gender CHAR(1),
	birthdate DATE
);

INSERT INTO MovieStar VALUES
('Carrie Fisher', '123 Maple St.,Hollywood', 'F','1999-09-09'),
('Mark Hamill', '456 Oak Rd., Malibu', 'M', '1988-08-08'),
('Harrison Ford', '789 Palm Dr., Beverly Hills', 'M', '1977-07-07'),
('Sandra Bullock', '123 Walnut Dr., Hollywood', 'F', '1970-05-05'),
('Leonardo DiCaprio', '333 Walnut Dr., Hollywood', 'M', '1975-05-05');

CREATE TABLE StarsIn(
	movieTitle VARCHAR(100),
	movieYear	INT,
	starName VARCHAR(30),
	PRIMARY KEY(movieTitle, movieYear, starName)
);

INSERT INTO StarsIn VALUES
('Pretty Woman', 1990, 'Julia Roberts'),
('Star Wars', 1970, 'Harrison Ford'),
('Ordinary People', 1980, 'Donald Sutherland'),
('Ordinary People', 1980, 'Mary Tyler Moore'),
('Love Story', 1970, 'Ali McGraw'),
('Love Story', 1970, 'Ryan O\'Neal'),
('Titanic', 1997, 'Leonardo DiCaprio'),
('Get Shorty', 1995, 'Gene Hackman'),
('Get Shorty', 1995, 'Rene Russo'),
('GoldenEye', 1995, 'Pierce Brosnan');


CREATE TABLE MovieExec (
	`name` VARCHAR(30) ,
	address VARCHAR(30),
	`cert#` INT PRIMARY KEY,
	netWorth DECIMAL(10, 2)
);

INSERT INTO MovieExec VALUES
('Harrison Ford', '789 Palm Dr., Beverly Hills', 12345, 15000000),
('Jonathan Glickman', '111 Dream Ln., Hollywood', 54321, 12000000);

CREATE TABLE Studio (
	`name` VARCHAR(30) PRIMARY KEY,
	address VARCHAR(30),
	`presC#` INT
);

INSERT INTO Studio VALUES('Disney', null, null);
INSERT INTO Studio VALUES('Fox', '123 Hollywood Blvd.', 12345);
INSERT INTO Studio VALUES('MGM Studios', '456 Hollywood Blvd.', 54321);