use human_friends;
CREATE TABLE  Pets
(       
	ID INT PRIMARY KEY AUTO_INCREMENT, 
	PetName VARCHAR(20), 
	PetType VARCHAR(15),
	BirthDate DATE, 
	Commands VARCHAR(100)
);
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Snoopy', 'Dog', '2020-01-01', 'Sit, Stay, Fetch' );
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Coco', 'Cat', '2019-06-05', 'Sit, Pounce');
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Pops', 'Hamster', '2021-10-14', 'Roll, Hide');
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Sweety', 'Cat', '2022-09-07', 'Sit, Pounce, Scratch');
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Lolly', 'Dog', '2020-12-30', 'Sit, Stay, Roll');
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Fatty', 'Hamster', '2019-10-21', 'Roll, Spin');
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Killby', 'Dog', '2021-07-21', 'Sit, Stay, Fetch');
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Lusy', 'Cat', '2017-02-15', 'Sit, Pounce');
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Kuku', 'Hamster', '2021-04-14', 'Roll, Hide');
INSERT INTO Pets (PetName, PetType, BirthDate, Commands) VALUES ('Grinch', 'Dog', '2020-08-01', 'Sit, Stay');

CREATE TABLE  PackAnimals
(       
	ID INT PRIMARY KEY AUTO_INCREMENT, 
	PetName VARCHAR(20), 
	PetType VARCHAR(15),
	BirthDate DATE, 
	Commands VARCHAR(100)
);
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Jonsy', 'Horse', '2014-08-11', 'Trot, Canter, Gallop');
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Sandy', 'Camel', '2017-03-09', 'Walk, Carry Load');
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Brady', 'Donkey', '2019-04-03', 'Walk, Carry Load, Bray');
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Pound', 'Horse', '2021-10-17', 'Trot, Canter');
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Slowsy', 'Camel', '2022-04-15', 'Walk, Sit');
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Bony', 'Donkey', '2021-06-23', 'Walk, Kick, Bray');
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Punk', 'Horse', '2018-07-21', 'Trot, Gallop');
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Rock', 'Camel', '2015-01-29', 'Walk, Carry Load');
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Woncky', 'Donkey', '2017-11-17', 'Walk, Carry Load, Bray');
INSERT INTO PackAnimals (PetName, PetType, BirthDate, Commands) VALUES ('Lucky', 'Horse', '2020-12-04', 'Trot, Canter, Gallop');

DELETE FROM PackAnimals WHERE PetType = 'Camel' AND ID > 0;

CREATE TABLE YoungAnimals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    PetName VARCHAR(50),
    PetType VARCHAR(50),
    BirthDate DATE,
    Age_years INT
);

INSERT INTO YoungAnimals (PetName, PetType, BirthDate, Age_years)
SELECT PetName, PetType, BirthDate, TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) AS Age_years
FROM Pets
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3;
INSERT INTO YoungAnimals (PetName, PetType, BirthDate, Age_years)
SELECT PetName, PetType, BirthDate, TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) AS Age_years
FROM PackAnimals
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3;

CREATE TABLE Animals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    PetName VARCHAR(50),
    PetType VARCHAR(50),
    BirthDate DATE,
    Commands VARCHAR(100),
    Age_years INT
);


INSERT INTO Animals (PetName, PetType, BirthDate, Commands, Age_years)
SELECT PetName, PetType, BirthDate, Commands, TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) AS Age_years
FROM (
    SELECT PetName, PetType, BirthDate, Commands FROM Pets
    UNION ALL
    SELECT PetName, PetType, BirthDate, Commands FROM PackAnimals
) AS comb_data;

SELECT * FROM Animals;
