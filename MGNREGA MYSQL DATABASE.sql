mysql> create database mgnrega;
Query OK, 1 row affected (0.01 sec)

mysql> use mgnrega;
Database changed
mysql> create table BDO
    -> (
    -> bdoId int primary key auto_increment,
    -> name varchar(20),
    -> email varchar(20),
    -> password varchar(10)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> create table BDOlogin
    -> (
    -> email varchar(20),
    -> password varchar(10)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> create table BDOproject
    -> (
    -> projectId int primary key auto_increment,
    -> projectName varchar(40),
    -> projectWorkDetail varchar(100),
    -> projectWorklocation varchar(10)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> create table GPM
    -> (
    -> gpmId int primary key auto_increment,
    -> gpmName varchar(20),
    -> gpmAddress varchar(100),
    -> gpmEmail varchar(20),
    -> gpmpassword varchar(10)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> create table Gpm_Project
    -> (
    -> gpmId int,
    -> projectId int,
    -> gpmName varchar(30),
    -> projectName varchar(40),
    -> foreign key(gpmId) references gpm(gpmId),
    -> foreign key(projectId) references BDOproject(projectId)
    -> );
Query OK, 0 rows affected (0.04 sec)

mysql> create table Employee
    -> (
    -> emplId int primary key auto_increment,
    -> emplName varchar(40),
    -> emplWorkStatus varchar(10)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> create table Employee_Project
    -> (
    -> emplId int,
    -> projectId int,
    -> emplName varchar(30),
    -> projectName varchar(40),
    -> workingDay int,
    -> foreign key(emplId) references Employee(emplId),
    -> foreign key(projectId) references BDOproject(projectId)
    -> );


mysql> create table employee_workingDetail
    -> (
    -> employeeId int,
    -> employeeName varchar(40),
    -> employeeSkill varchar(50),
    -> projectName varchar(40),
    -> assignDays int,
    -> noOfAbsentDays int,
    -> noOfWorkingDays int,
    -> wages int
    -> );
Query OK, 0 rows affected (0.01 sec)
