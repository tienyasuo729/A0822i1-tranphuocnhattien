USE QuanLySinhVien;

select Address, count(StudentID) AS 'số lượng sinh viên'
from Student 
group by Address;

