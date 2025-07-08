CREATE TABLE IF NOT EXISTS student (
    id_student int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    lastname VARCHAR(255),
    firstname VARCHAR(255),
    age int,
    average float
    );

CREATE TABLE IF NOT EXISTS staff (
    id_user int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(255),
    password VARCHAR(255)
)

CREATE TABLE IF NOT EXISTS project (
    id_project int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS group_project (
    id_group int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_project int NOT NULL,
    grade int,
    FOREIGN KEY (id_project) REFERENCES project(id_project)
    );

INSERT INTO staff (username, password)
VALUES ('adeline', '123456');

CREATE TABLE IF NOT EXISTS student_group (
    id_student int NOT NULL,
    id_group int NOT NULL,
    PRIMARY KEY (id_student, id_group),
    FOREIGN KEY (id_student) REFERENCES student(id_student) ON DELETE CASCADE,
    FOREIGN KEY (id_group) REFERENCES group_project(id_group) ON DELETE CASCADE
    );

INSERT INTO student (lastname, firstname, age, average)
VALUES ('Doe', 'John', 25, 12), ('Navet', 'Florence', 40, 18), ('Patenne', 'Adeline', 29, 15), ('Mangeot', 'Jolyne', 20, 17);

INSERT INTO student (lastname, firstname, age, average)
VALUES
    ('Caron', 'Thibault', 33, 18.2),
    ('Leite', 'Anna', 35, 16),
    ('Wilde', 'Leila', 37, 14),
    ('Rossi', 'Morgane', 35, 15),
    ('Abdallah', 'Eltigani', 25, 13),
    ('De Biaggio', 'Allan', 31, 14),
    ('Portal', 'Olivier', 40, 13),
    ('Boughanmi', 'Ryhad', 29, 19),
    ('Sabatier', 'Vanessa', 35, 11),
    ('Sherstiuk', 'Yuliia', 40, 11),
    ('Marchenko', 'Daria', 20, 14),
    ('Sergey', 'Chukhno', 35, 20),
    ('Rimma', 'Chukhno', 35, 17);

INSERT INTO student (lastname, firstname, age, average)
VALUES
    ('Martin', 'Alice', 22, 14.3),
    ('Dupont', 'Louis', 30, 11.5),
    ('Moreau', 'Emma', 27, 16.2),
    ('Petit', 'Lucas', 35, 9.8),
    ('Garnier', 'Léa', 24, 12.9),
    ('Robert', 'Maxime', 42, 17.3),
    ('Lemoine', 'Anna', 33, 13.4),
    ('Renard', 'Paul', 20, 15.6),
    ('Noel', 'Julie', 26, 10.5),
    ('Charpentier', 'Sophie', 29, 18.2),
    ('Leclerc', 'Thomas', 25, 9.3),
    ('Girard', 'Camille', 23, 14.8),
    ('Chevalier', 'Antoine', 32, 17.1),
    ('Benoit', 'Sarah', 28, 13.9),
    ('Lambert', 'Hugo', 38, 8.4),
    ('Faure', 'Clara', 40, 12.0),
    ('Roussel', 'Nathan', 36, 6.7),
    ('Collet', 'Eva', 19, 16.7),
    ('Giraud', 'Bastien', 22, 10.2),
    ('Andre', 'Manon', 34, 11.9),
    ('Durand', 'Axel', 23, 13.3),
    ('Marchand', 'Ines', 37, 12.7),
    ('Mercier', 'Julien', 41, 17.5),
    ('Roy', 'Nina', 39, 9.4),
    ('Henry', 'Sami', 44, 14.2),
    ('Muller', 'Alicia', 20, 18.5),
    ('Barbier', 'Noa', 21, 10.0),
    ('Perrin', 'Elise', 46, 11.3),
    ('Bertrand', 'Leo', 31, 15.0),
    ('Renaud', 'Jade', 48, 5.1),
    ('Lopez', 'Tom', 43, 13.7),
    ('Vidal', 'Margaux', 47, 16.0),
    ('Bonnet', 'Enzo', 49, 7.3),
    ('Texier', 'Lucie', 50, 8.6),
    ('Gilbert', 'Amelie', 27, 18.7),
    ('Fabre', 'Quentin', 45, 9.1),
    ('Pierre', 'Salome', 26, 19.6),
    ('Leroy', 'Mathis', 25, 15.5),
    ('Robin', 'Maya', 24, 6.4),
    ('Gauthier', 'Leo', 21, 14.4),
    ('Masson', 'Carla', 23, 12.2),
    ('Riviere', 'Nathan', 19, 17.8),
    ('Guillot', 'Laura', 28, 11.8),
    ('Pires', 'Victor', 29, 10.1),
    ('Baron', 'Chloe', 30, 13.6),
    ('Boucher', 'Ethan', 32, 8.9),
    ('Jacquet', 'Emma', 33, 16.3),
    ('Fernandez', 'Hugo', 35, 15.1),
    ('Paris', 'Nina', 36, 7.4),
    ('Gaillard', 'Théo', 38, 10.7),
    ('Marin', 'Lou', 39, 11.6),
    ('Legrand', 'Mael', 40, 12.3),
    ('Rolland', 'Lina', 41, 13.1),
    ('Langlois', 'Yanis', 42, 6.8),
    ('Da Silva', 'Mila', 43, 7.9),
    ('Hebert', 'Noham', 44, 10.6),
    ('Perrot', 'Nael', 45, 9.2),
    ('Lucas', 'Eva', 46, 19.2),
    ('Blanc', 'Ilyes', 47, 8.3),
    ('Guichard', 'Louise', 48, 11.2);

INSERT INTO project (name)
VALUES
    ('Weather App'),
    ('Blog Platform'),
    ('Game Engine'),
    ('Portfolio Website'),
    ('Banking System'),
    ('School Tracker'),
    ('Social Network'),
    ('Chat App'),
    ('Fitness Tracker'),
    ('E-commerce Store');


INSERT INTO student (lastname, firstname, age, average)
VALUES
    ('Caron', 'Thibault', 33, 18.2),
    ('Leite', 'Anna', 35, 16),
    ('Wilde', 'Leila', 37, 14),
    ('Rossi', 'Morgane', 35, 15),
    ('Abdallah', 'Eltigani', 25, 13),
    ('De Biaggio', 'Allan', 31, 14),
    ('Portal', 'Olivier', 40, 13),
    ('Boughanmi', 'Ryhad', 29, 19),
    ('Sabatier', 'Vanessa', 35, 11),
    ('Sherstiuk', 'Yuliia', 40, 11),
    ('Marchenko', 'Daria', 20, 14),
    ('Sergey', 'Chukhno', 35, 20),
    ('Rimma', 'Chukhno', 35, 17);

INSERT INTO student (lastname, firstname, age, average)
VALUES
    ('Martin', 'Alice', 22, 14.3),
    ('Dupont', 'Louis', 30, 11.5),
    ('Moreau', 'Emma', 27, 16.2),
    ('Petit', 'Lucas', 35, 9.8),
    ('Garnier', 'Léa', 24, 12.9),
    ('Robert', 'Maxime', 42, 17.3),
    ('Lemoine', 'Anna', 33, 13.4),
    ('Renard', 'Paul', 20, 15.6),
    ('Noel', 'Julie', 26, 10.5),
    ('Charpentier', 'Sophie', 29, 18.2),
    ('Leclerc', 'Thomas', 25, 9.3),
    ('Girard', 'Camille', 23, 14.8),
    ('Chevalier', 'Antoine', 32, 17.1),
    ('Benoit', 'Sarah', 28, 13.9),
    ('Lambert', 'Hugo', 38, 8.4),
    ('Faure', 'Clara', 40, 12.0),
    ('Roussel', 'Nathan', 36, 6.7),
    ('Collet', 'Eva', 19, 16.7),
    ('Giraud', 'Bastien', 22, 10.2),
    ('Andre', 'Manon', 34, 11.9),
    ('Durand', 'Axel', 23, 13.3),
    ('Marchand', 'Ines', 37, 12.7),
    ('Mercier', 'Julien', 41, 17.5),
    ('Roy', 'Nina', 39, 9.4),
    ('Henry', 'Sami', 44, 14.2),
    ('Muller', 'Alicia', 20, 18.5),
    ('Barbier', 'Noa', 21, 10.0),
    ('Perrin', 'Elise', 46, 11.3),
    ('Bertrand', 'Leo', 31, 15.0),
    ('Renaud', 'Jade', 48, 5.1),
    ('Lopez', 'Tom', 43, 13.7),
    ('Vidal', 'Margaux', 47, 16.0),
    ('Bonnet', 'Enzo', 49, 7.3),
    ('Texier', 'Lucie', 50, 8.6),
    ('Gilbert', 'Amelie', 27, 18.7),
    ('Fabre', 'Quentin', 45, 9.1),
    ('Pierre', 'Salome', 26, 19.6),
    ('Leroy', 'Mathis', 25, 15.5),
    ('Robin', 'Maya', 24, 6.4),
    ('Gauthier', 'Leo', 21, 14.4),
    ('Masson', 'Carla', 23, 12.2),
    ('Riviere', 'Nathan', 19, 17.8),
    ('Guillot', 'Laura', 28, 11.8),
    ('Pires', 'Victor', 29, 10.1),
    ('Baron', 'Chloe', 30, 13.6),
    ('Boucher', 'Ethan', 32, 8.9),
    ('Jacquet', 'Emma', 33, 16.3),
    ('Fernandez', 'Hugo', 35, 15.1),
    ('Paris', 'Nina', 36, 7.4),
    ('Gaillard', 'Théo', 38, 10.7),
    ('Marin', 'Lou', 39, 11.6),
    ('Legrand', 'Mael', 40, 12.3),
    ('Rolland', 'Lina', 41, 13.1),
    ('Langlois', 'Yanis', 42, 6.8),
    ('Da Silva', 'Mila', 43, 7.9),
    ('Hebert', 'Noham', 44, 10.6),
    ('Perrot', 'Nael', 45, 9.2),
    ('Lucas', 'Eva', 46, 19.2),
    ('Blanc', 'Ilyes', 47, 8.3),
    ('Guichard', 'Louise', 48, 11.2);