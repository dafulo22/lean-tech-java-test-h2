/* Populate tables */
-- PERSONS
INSERT INTO Persons (id, name, last_name, address, cellphone, city_name) VALUES(1, 'Daniel', 'Fuentes', 'Calle 30g #50C-50', '3109872167', 'Cartagena');
INSERT INTO Persons (id, name, last_name, address, cellphone, city_name) VALUES(2, 'Aura', 'Romero', 'Calle 30h #51D-51', '3109872168', 'Barranquilla');
INSERT INTO Persons (id, name, last_name, address, cellphone, city_name) VALUES(3, 'Sarith', 'Jaimes', 'Calle 31i #52E-52', '3109872169', 'Sincelejo');
INSERT INTO Persons (id, name, last_name, address, cellphone, city_name) VALUES(4, 'Carmen', 'López', 'Calle 32j #53F-53', '3109872170', 'Medellin');
INSERT INTO Persons (id, name, last_name, address, cellphone, city_name) VALUES(5, 'Adrián', 'Fuentes', 'Calle 33k #54G-54', '3109872171', 'Envigado');

-- POSITIONS
INSERT INTO Positions (id, name) VALUES(1, 'QA');
INSERT INTO Positions (id, name) VALUES(2, 'DEV');
INSERT INTO Positions (id, name) VALUES(3, 'SCRUM MASTER');
INSERT INTO Positions (id, name) VALUES(4, 'TECH LEAD');
INSERT INTO Positions (id, name) VALUES(5, 'DEVOPS');

-- EMPLOYEES
INSERT INTO Employees (id, salary, person_id, position_id) VALUES(1, 7500000, 1, 2);
INSERT INTO Employees (id, salary, person_id, position_id) VALUES(2, 3500000, 2, 1);
INSERT INTO Employees (id, salary, person_id, position_id) VALUES(3, 11500000, 3, 3);
INSERT INTO Employees (id, salary, person_id, position_id) VALUES(4, 9500000, 4, 4);
INSERT INTO Employees (id, salary, person_id, position_id) VALUES(5, 5500000, 5, 5);
