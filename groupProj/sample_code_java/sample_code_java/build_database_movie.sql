DROP TABLE IF EXISTS Movies;

CREATE TABLE Movies (
	title VARCHAR(100),
	`employer` INT,
	length INT,
	term VARCHAR(10),
	phone VARCHAR(30),
	`producerC#` INT,
	PRIMARY KEY(title, `employer`)
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