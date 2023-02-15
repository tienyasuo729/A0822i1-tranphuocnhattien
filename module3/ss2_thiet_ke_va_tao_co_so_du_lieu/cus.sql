create database XayDungCoSoQuanLyBanHang;
use XayDungCoSoQuanLyBanHang;
create table Customer(
	cID int primary key,
	cName varchar(45),
    cAge int
);
create table OrderByC(
	oID int primary key,
    cID int, 
    foreign key (cID) references Customer(cID),
    oDate date,
    oTotalPrice int    
);