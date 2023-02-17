create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer(
cID int primary key not null,
cName nvarchar(45),
cAge int
);

create table Order1(
oID int primary key not null,
cID int ,
oDate Date,
oTotalPrice float,
foreign key (cID) references Customer(cID)
);

create table Product(
pID Int primary key not null,
pName nvarchar(45),
pPrice float
);
create table OrderDetail (
oID int,
pID int,
odQTY int,
foreign key (oID) references Order1(oID),
foreign key (pID) references Product (pID)
);
insert into Customer values 
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into Order1 values 
(1,1,'2006/3/21',null),
(2,2,'2006/3/23',null),
(3,1,'2006/3/16',null);

insert into Product values 
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into OrderDetail values 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select oID, oDate,oTotalPrice from order1;

select cname, pname 
from customer c  join order1 o on c.cId = o.cId
join orderdetail od on o.oid= od.oid
join product p on od.pid= p.pid;

select c.cid,c.cname 
from customer c 
where c.cname not in ( select c.cname from customer c join order1 o on c.cid  = o.cid );

select o.oID, oDate, sum(od.odQTY * p.pPrice) totalPrice
from order1 o join orderdetail od on o.oid= od.oid
join product p on od.pid= p.pid
group by o.oID;