# student-attendance-management


# creating database and tables on mysql console


create database sam;

use sam;

create table student(xieid varchar(50), name varchar(50), branch varchar(50), email varchar(50));

create table faculty(empid varchar(50), name varchar(50), department varchar(50), email varchar(50));

create table student_attendance(xieid varchar(50), date varchar(50), status varchar(50));

create table faculty_attendance(empid varchar(50), date varchar(50), status varchar(50));
