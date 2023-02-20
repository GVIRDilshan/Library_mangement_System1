Library mangement System quarys

show databases;

use Library;

show tables;

create table Member(
    memberId varchar(10),
    name varchar(30),
    address varchar(20),
    contact varchar(11),
    age INT,
     constraint primary key(memberId)
);
 
create table Book(
    bookId varchar(10),
    name varchar(30),
    author varchar(20),
    qty INT,
    constraint primary key(bookId)
);

create table issuse(
    iid varchar(15),
    issus_date date,
    member_Id varchar(10),
    constraint primary key(iid),
    constraint foreign key(member_Id) references member(memberId)
);

desc issuse;

desc member;

desc book;

select * from member;

select * from member;