#Product ( maker , model , type ) 
#PC ( model , speed , ram , hd , price ) 
#Laptop ( model , speed , ram , hd , screen , price ) 
#Printer ( model , color , type , price )

/* Comment the CREATE and USE for cssgate */
CREATE DATABASE ProductDB;
USE ProductDB;

CREATE TABLE Product (
	maker 	VARCHAR(30),
	model 	INT,
	`type` 	VARCHAR(15)
);

ALTER TABLE Product ADD PRIMARY KEY(maker, model);
INSERT INTO Product
VALUES ('A', 1001, 'pc'),
('A', 1002, 'pc'),
('A', 1003, 'pc'),
('A', 2004, 'laptop'),
('A', 2005, 'laptop'),
('A', 2006, 'laptop'),
('B', 1004, 'pc'),
('B', 1005, 'pc'),
('B', 1006, 'pc'),
('B', 2007, 'laptop'),
('C', 1007, 'pc'),
('D', 1008, 'pc'),
('D', 1009, 'pc'),
('D', 1010, 'pc'),
('D', 3004, 'printer'),
('D', 3005, 'printer'),
('E', 1011, 'pc'),
('E', 1012, 'pc'),
('E', 1013, 'pc'),
('E', 2001, 'laptop'),
('E', 2002, 'laptop'),
('E', 2003, 'laptop'),
('E', 3001, 'printer'),
('E', 3002, 'printer'),
('E', 3003, 'printer'),
('F', 2008, 'laptop'),
('F', 2009, 'laptop'),
('F', 2010, 'laptop'),
('H', 3006, 'printer'),
('H', 3007, 'printer');

CREATE TABLE PC (
	model 	INT PRIMARY KEY,
	speed 	NUMERIC(5, 2),
	ram		INT,
	hd		INT,
	price	NUMERIC(9, 2)
);
insert into PC VALUES
(1001, 2.66, 1024, 250, 2114),
(1002, 2.10, 512, 250, 995),
(1003, 1.42, 512, 80, 478),
(1004, 2.80, 1024, 250, 649),
(1005, 3.2, 512, 250, 630),
(1006, 3.2, 1024, 320, 1049),
(1007, 2.2, 1024, 200, 510),
(1008, 2.2, 2048, 250, 770),
(1009, 2.2, 1024, 250, 650),
(1010, 2.8, 2048, 300, 770),
(1011, 1.86, 2048, 160, 959),
(1012, 2.8, 1024, 160, 649),
(1013, 3.06, 512, 80, 529);

CREATE TABLE Laptop (
	model	INT PRIMARY KEY,
	speed	NUMERIC (5, 2),
	ram		INT,
	hd		INT,
	screen	TINYINT,
	price	NUMERIC(9, 2)
);

INSERT INTO Laptop Values
(2001, 2.0, 2048, 240, 20.1, 3673),
(2002, 1.73, 1024, 80, 17.0, 949),
(2003, 1.80, 512, 60, 15.4, 549),
(2004, 2.0, 512, 60, 13.3, 1150),
(2005, 2.16, 1024, 120, 17.0, 2500),
(2006, 2.0, 2048, 80, 15.4, 1700),
(2007, 1.83, 1024, 120, 13.3, 1429),
(2009, 1.60, 512, 80, 14.1, 680),
(2010, 2.0, 2048, 160, 15.4, 2300);


CREATE TABLE Printer (
	model	INT PRIMARY KEY,
	color	VARCHAR(5) DEFAULT 'false',
	`type`	VARCHAR(9),
	price 	NUMERIC(9, 2)
);

INSERT INTO Printer
VALUES (3001, 'true', 'ink-jet', 99),
(3002, 'false', 'laser', 239),
(3003, 'true', 'laser', 899),
(3004, 'true', 'ink-jet', 120),
(3005, 'false', 'laser', 120),
(3006, 'true', 'ink-jet', 100),
(3007, 'true', 'laser', 200);