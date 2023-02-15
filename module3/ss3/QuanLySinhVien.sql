create database QuanLySinhVien;
use QuanLySinhVien;

create table Class(
	ClassID int primary key,
    ClassName varchar(50),
    StartDate date,
    Status int
);

-- alter table mark
-- drop foreign key mark_ibfk_2;
 /* alter table student 
 add ClassID int;
 alter table student
 add foreign key (ClassID) references Class(ClassID); */
 drop table mark;
 drop table student;
create table Student(
	StudentID int auto_increment primary key,
    StudentName varchar(50),
    Address varchar(50),
    Phone int,
    Status int,
     ClassID int,
     foreign key (ClassID) references Class(ClassID)
);

create table Subject(
	SubID int primary key,
    SubName varchar(50),
    Credit int,
    Status int
);

create table Mark(
	MarkID int primary key default 0,
    SubID int,
    StudentID int,
    -- primary key (SubID, StudentID),
    foreign key (SubID) references Subject(SubID),
    foreign key (StudentID) references Student(StudentID),
    mark int,
    ExamTimes int
);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
/*alter table Mark
modify column ExamTimes int;*/
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);