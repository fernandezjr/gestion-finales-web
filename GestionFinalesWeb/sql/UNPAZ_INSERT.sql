INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(1, 24621349, 'Lucrecia', 'Rogado', 'Femenino');

INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(2, 32112415, 'Aldo', 'Osorio', 'Masculino');

INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(3, 29666535, 'Rocio', 'Montenegro', 'Femenino');

INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(4, 35272741, 'Esteban', 'Lopez', 'Masculino');

INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(5, 34621764, 'Ricardo', 'Fuentes', 'Masculino');

INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(6, 32121744, 'Marta', 'Sanchez', 'Femenino');

INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(7, 26721432, 'Carlos', 'Casares', 'Masculino');

INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(8, 30612745, 'Norma', 'Perez', 'Femenino');

INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(9, 35213982, 'Soledad', 'Amaya', 'Femenino');

INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero)
VALUES(10, 29152127, 'Lucia', 'Rios', 'Femenino');

INSERT INTO Materia (ID, Descripcion)
VALUES(1, 'Algebra y Analisis I');

INSERT INTO Materia (ID, Descripcion)
VALUES(2, 'Taller de Programacion');

INSERT INTO Materia (ID, Descripcion)
VALUES(3, 'Practica Integradora');

INSERT INTO Materia (ID, Descripcion)
VALUES(4, 'Comunicaciones y Redes');

INSERT INTO Materia (ID, Descripcion)
VALUES(5, 'Base de Datos I');

INSERT INTO Materia (ID, Descripcion)
VALUES(6, 'Estadistica y Probabilidad');

INSERT INTO Materia (ID, Descripcion)
VALUES(7, 'Paradigmas de Programacion');

INSERT INTO Materia (ID, Descripcion)
VALUES(8, 'Sistemas Operativos I');

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(1, 1, '17-07-2018', 3.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(1, 1, '12-12-2018', 8.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(5, 1, '16-12-2018', 4.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(1, 2, '15-07-2018', 4.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(2, 2, '19-07-2018', 4.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(6, 3, '16-07-2018', 8.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(7, 3, '17-07-2018', 7.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(3, 3, '18-07-2018', 3.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(8, 3, '14-07-2018', 5.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(1, 4, '12-12-2018', 4.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(2, 4, '13-12-2018', 3.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(8, 4, '10-12-2018', 9.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(4, 5, '14-12-2018', 2.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(2, 5, '19-07-2018', 6.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(6, 6, '16-07-2018', 7.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(3, 6, '18-07-2018', 8.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(2, 6, '13-12-2018', 7.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(1, 7, '15-07-2018', 5.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(2, 7, '13-12-2018', 6.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(7, 7, '11-12-2018', 8.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(8, 7, '10-12-2018', 10.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(2, 8, '19-07-2018', 8.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(4, 8, '14-12-2018', 3.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(4, 9, '14-12-2018', 4.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(6, 9, '16-07-2018', 5.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(7, 10, '17-07-2018', 6.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(1, 10, '12-12-2018', 7.00);

INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota)
VALUES(8, 10, '14-07-2018', 4.00);

SELECT * FROM Final ORDER BY Legajo_Alumno;