create database student_management ;
create table class (
ID int primary key,
NAME varchar(45) 
);
create table teacher (
ID int primary key,
NAME varchar(45),
AGE int,
COUNTRY varchar(45)
);