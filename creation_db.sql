CREATE TABLE IF NOT EXISTS student (
    id_student int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    lastname VARCHAR(255),
    firstname VARCHAR(255),
    age int,
    average float

);

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

CREATE TABLE IF NOT EXISTS student_group (
    id_student int NOT NULL,
    id_group int NOT NULL,
    PRIMARY KEY (id_student, id_group),
    FOREIGN KEY (id_student) REFERENCES student(id_student) ON DELETE CASCADE,
    FOREIGN KEY (id_group) REFERENCES group_project(id_group) ON DELETE CASCADE
);

INSERT INTO student (lastname, firstname, age, average)
VALUES ('Doe', 'John', 25, 12), ('Navet', 'Florence', 40, 18), ('Patenne', 'Adeline', 29, 15), ('Mangeot', 'Jolyne', 20, 17);