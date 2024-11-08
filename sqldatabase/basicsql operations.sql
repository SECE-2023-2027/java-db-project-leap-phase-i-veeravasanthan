create database bank;
use bank;
create table banking_application(id int,name varchar(20),age int);
select * from banking_application;
insert into banking_application values(1,'veera',18);
create database mang;
use mang;
create table software
(
id int,
name varchar(20),
age int,
marks int
);
insert into software values(1,"veeravasanthan",18,99),(2,"vasanth",19,99),(3,"surandar",19,99);
select * from software;
update software set name ='veera' where id=1;
delete from software where id=1;
drop table software;

alter table software add city varchar(20);
alter table software drop column city;
alter table software rename column age to newage; 
select name from software where id=1 and name ="veeravasanthan";
select * from software where id between 1 and 2;
select id,newage from software where marks in(99);

select name,id,newage ,marks from software where name like('v%');
select name,id,newage ,marks from software where name like('s%');

select name,id,newage ,marks from software where name is null;

select name,id,newage ,marks from software where name is not null;

create table progress(
id int not null,
lastname varchar(20),
firstname varchar(20),
age int,
work varchar(50),
primary key(id)
);
INSERT INTO progress (id, lastname, firstname, age, work)
VALUES 
(1, 'Smith', 'John', 28, 'Software Developer'),
(2, 'Doe', 'Jane', 32, 'Data Analyst'),
(3, 'Brown', 'Michael', 45, 'Project Manager'),
(4, 'Taylor', 'Emily', 27, 'AI Engineer'),
(5, 'Johnson', 'Chris', 29, 'Research Scientist'),
(6, 'Lee', 'Sophia', 34, 'UX Designer'),
(7, 'Garcia', 'Daniel', 31, 'Network Engineer'),
(8, 'Martinez', 'Olivia', 26, 'Digital Marketer');
select * from progress;

create table progress1(
id int primary key auto_increment,
lastname varchar(20),
firstname varchar(20),
age int,
work varchar(50)
);
create table table1(
id int primary key auto_increment,name varchar(125)
);
create table table2(
id int primary key auto_increment,subject varchar(125),subject_id int,
 foreign key (subject_id) references table1(id)
);
insert into table1 (name) values("veera");
insert into table1 (name) values("vasanth");
insert into table1 (name) values("sura");
select * from table1;
insert into table2 (subject,subject_id) values("tamil",1);
insert into table2 (subject,subject_id) values("english",2);
insert into table2 (subject,subject_id) values("math",3);

select * from table2;
SELECT table1.id, table1.name, table2.subject 
FROM table1 
INNER JOIN table2 
ON table1.id = table2.subject_id;


SELECT table1.id, table1.name, table2.subject 
FROM table1 
LEFT JOIN table2 
ON table1.id = table2.subject_id;

SELECT table1.id, table1.name, table2.subject 
FROM table1 
RIGHT JOIN table2 
ON table1.id = table2.subject_id;

SELECT table1.id, table1.name, table2.subject 
FROM table1, table2 
WHERE table1.id = table2.subject_id;

CREATE TABLE person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    amount DECIMAL(10, 2)
);

INSERT INTO person (name, amount) VALUES 
('Alice', 120.50),
('Bob', 200.00),
('Charlie', 180.75),
('Diana', 90.00),
('Edward', 250.00),
('Fiona', 175.00),
('George', 300.00),
('Hannah', 95.25),
('Ian', 145.75),
('Jane', 220.30);

SELECT * 
FROM person 
ORDER BY amount DESC 
LIMIT 1;
