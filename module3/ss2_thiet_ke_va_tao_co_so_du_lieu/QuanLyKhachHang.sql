create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer (
	cID int not null auto_increment,
    cName varchar(45) not null,
    cAge int not null,
primary key (cID));

create table `Order` (
	oID int not null auto_increment,
    cID int not null,
    oDate date not null,
    oTotalPrice float not null default 0.0,
    foreign key (cID) references Customer (cID),
primary key (oID));

create table Product (
	pID int not null auto_increment,
    pName varchar(45) not null,
    pPrice float not null default 0.0,
primary key (pID));

create table OrderDetail (
	oID int not null,
    pID int not null,
    odQTY varchar(45) not null,
    foreign key (oID) references `Order` (oID),
    foreign key (pID) references Product (pID),
primary key (oID, pID)
);