create database Workshop;
use Workshop;
create table account(
account_id int primary key auto_increment,
customer_id int ,
account_type varchar(225),
balance decimal(15,2) not null,
created_at timestamp default current_timestamp,
address varchar(225),
mobile varchar(50));
select * from account;
CREATE TABLE savings_account (
    account_id INT PRIMARY KEY,
    interest_rate DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (`account_id`) REFERENCES account(account_id)
);
select * from savings_account;
create table transaction(
transaction_id int primary key auto_increment,
account_id int ,foreign key(`account_id`) references account(account_id),
transaction_type varchar(50) not null,
amount decimal(15,2) not null,
transaction_date timestamp default current_timestamp
)