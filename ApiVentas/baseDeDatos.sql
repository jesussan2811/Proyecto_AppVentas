CREATE DATABASE APPVENTAS

USE APPVENTAS

CREATE TABLE USUARIOS(
    USERID INT PRIMARY KEY AUTOINCREMENT,
    USERNAME VARCHAR(30) NOT NULL,
    USERPASSWORD VARCHAR(30) NOT NULL
)

CREATE TABLE CLIENTES(
    CLIID INT PRIMARY KEY AUTOINCREMENT,
    CLINOMBRE VARCHAR(30) NOT NULL,
    APELLIDOS VARCHAR(30) NOT NULL,
    CREDITO DOUBLE NOT NULL,
    TELEFONO VARCHAR(10) NOT NULL,
    DOMICILIO VARCHAR(50) NOT NULL,
    FECHANACIMIENTO DATE NOT NULL
)

CREATE TABLE PRODUCTOS(
    CODIGO INT PRIMARY KEY AUTOINCREMENT,
    PRODNOMBRE VARCHAR(30) NOT NULL,
    DESCRIPCION VARCHAR(50) NOT NULL,
    MARCA VARCHAR(20) NOT NULL,
    CANTIDAD INT NOT NULL,
    PRECIO DOUBLE NOT NULL
)

CREATE TABLE VENTAS(
    FOLIO INT PRIMARY KEY AUTOINCREMENT,
    CLIENTE INT NOT NULL,
    PRODUCTOS VARCHAR NOT NULL,
    IMPORTE DOUBLE NOT NULL,
    FECHAVENTA DATE NOT NULL
)

INSERT INTO USUARIOS (USERNAME,USERPASSWORD)
VALUES("jesus","eduardo")
INSERT INTO USUARIOS (USERNAME,USERPASSWORD)
VALUES("rudy","s09r12e15")
INSERT INTO USUARIOS (USERNAME,USERPASSWORD)
VALUES("shirou","ubw")

INSERT INTO CLIENTES (CLINOMBRE,APELLIDOS,CREDITO,TELEFONO,DOMICILIO,FECHANACIMIENTO)
VALUES("jesus","sanchez",1000.00,"6677475067","guillermo prieto 1210 vallado","1998-11-28")
INSERT INTO CLIENTES (CLINOMBRE,APELLIDOS,CREDITO,TELEFONO,DOMICILIO,FECHANACIMIENTO)
VALUES("javier","ortiz",5000.00,"6677475067","guillermo prieto 1210 vallado","1998-11-28")
INSERT INTO CLIENTES (CLINOMBRE,APELLIDOS,CREDITO,TELEFONO,DOMICILIO,FECHANACIMIENTO)
VALUES("carlos","chavez",3000.00,"6677475067","guillermo prieto 1210 vallado","1998-11-28")

INSERT INTO PRODUCTOS (PRODNOMBRE,DESCRIPCION,MARCA,CANTIDAD,PRECIO)
VALUES("Dualshock 4","control inalambrico para ps4","Sony",70,250.00)
INSERT INTO PRODUCTOS (PRODNOMBRE,DESCRIPCION,MARCA,CANTIDAD,PRECIO)
VALUES("Iphone 13","telefono celular","Apple",100,8000.00)
INSERT INTO PRODUCTOS (PRODNOMBRE,DESCRIPCION,MARCA,CANTIDAD,PRECIO)
VALUES("HEM-7120","monitor de presion arterial automatico","OMRON",50,500.00)

--INSERT INTO VENTAS (CLIENTE,PRODUCTOS,IMPORTE,FECHAVENTA)
--VALUES(cliente,productos,importe,fechaVenta)

SELECT * FROM USUARIOS
SELECT * FROM CLIENTES
SELECT * FROM PRODUCTOS
SELECT * FROM VENTAS

DROP TABLE USUARIOS
DROP TABLE CLIENTES
DROP TABLE PRODUCTOS
DROP TABLE VENTAS