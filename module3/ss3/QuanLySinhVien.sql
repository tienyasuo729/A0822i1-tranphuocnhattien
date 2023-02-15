create database QuanLySinhVien;
use QuanLySinhVien;

create table Class(
	ClassID int primary key,
    ClassName varchar(50),
    StartDate date,
    Status int
);

create table Student(
	StudentID int primary key,
    StudentName varchar(50),
    Address varchar(50),
    Phone int,
    Status int 
);

create table Subject(
	SubID int primary key,
    SubName varchar(50),
    Credit int,
    Status int
);

create table Mark(
	MarkID int,
    SubID int,
    StudentID int,
    primary key (MarkID, SubID, StudentID),
    foreign key (SubID) references Subject(SubID),
    foreign key (StudentID) references Student(StudentID),
    mark int,
    ExamTimes datetime
);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);