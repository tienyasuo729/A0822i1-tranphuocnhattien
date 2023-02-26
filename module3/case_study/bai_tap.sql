use casestudy;

-- câu 2
select * 
from nhan_vien 
where ho_ten like "h%" 
or ho_ten like "t%" 
or ho_ten like "k%" 
and length(ho_ten) <= 15;

-- câu 3
select * 
from khach_hang
where year(ngay_sinh) < 2005 and year(ngay_sinh) >= 1973 and dia_chi like "%đà nẵng" or dia_chi like "%quảng trị";

-- câu 4
select kh.ma_khach_hang, kh.ho_ten, count(hop_dong.ma_hop_dong) as so_lan_dat_phong
from khach_hang kh
inner join hop_dong on kh.ma_khach_hang = hop_dong.ma_khach_hang
inner join loai_khach on kh.ma_loai_khach = loai_khach.ma_loai_khach
where loai_khach.ten_loai_khach = "Diamond"
group by kh.ma_khach_hang order by so_lan_dat_phong;

-- câu 5
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, 
sum(dv.chi_phi_thue + hdct.so_luong * dvdk.gia) as tong_tien
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by kh.ma_khach_hang;

-- cau 6
select dv.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue,ten_loai_dich_vu from dich_vu dv join loai_dich_vu ldv using (ma_loai_dich_vu)
where ma_dich_vu not in (select ma_dich_vu from hop_dong hd join dich_vu dv using (ma_dich_vu) where month(ngay_lam_hop_dong) between 1 and 3 );

-- cau 7 
select distinct dv.ma_dich_vu, ten_dich_vu, dien_tich,so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
from dich_vu dv join loai_dich_vu ldv using (ma_loai_dich_vu) join hop_dong hd using (ma_dich_vu)
where dv.ma_dich_vu in (select ma_dich_vu from hop_dong hd join dich_vu dv using (ma_dich_vu) where year(ngay_lam_hop_dong)= 2020) 
and dv.ma_dich_vu not in (select ma_dich_vu from hop_dong hd join dich_vu dv using (ma_dich_vu) where year(ngay_lam_hop_dong)= 2021) ;
 
-- cau 8 
select distinct ho_ten from khach_hang; 

-- cau 9 
select month(ngay_lam_hop_dong) 'tháng' , count(kh.ma_khach_hang) 'số lượng' 
from khach_hang kh join hop_dong hd using (ma_khach_hang)
group by month(ngay_lam_hop_dong)
order by  month(ngay_lam_hop_dong);

-- cau 10
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, count(hop_dong_chi_tiet.ma_dich_vu_di_kem) as so_luong_dich_vu
from hop_dong inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong 
group by hop_dong.ma_hop_dong;

-- cau 11
select ma_dich_vu_di_kem  from hop_dong_chi_tiet;
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
from hop_dong
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where loai_khach.ten_loai_khach = 'Diamond' and (khach_hang.dia_chi like '%Vinh%' or khach_hang.dia_chi like '%Quảng Ngãi%');

-- cau 12
select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dien_thoai, dich_vu.ten_dich_vu,
sum(tien_dat_coc) as tong_tien_dat_coc, sum(so_luong) as tong_so_luong
from hop_dong
left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where not exists(select hop_dong.ma_hop_dong where hop_dong.ngay_lam_hop_dong between '2021-01-01' and '2021-06-31')
and exists (select hop_dong.ma_hop_dong where hop_dong.ngay_lam_hop_dong between '2020-10-01' and '2021-12-31');

-- cau 13
-- cau 14
select hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem,
count(hop_dong_chi_tiet.ma_dich_vu_di_kem) as so_lan_su_dung
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung = 1;

-- cau 15
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi,
count(hop_dong.ma_nhan_vien) tong_so_hop_dong
from
nhan_vien
inner join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
inner join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
inner join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) between 2020 and 2021
group by nhan_vien.ma_nhan_vien
having tong_so_hop_dong <= 3;

-- cau 16
delete from nhan_vien
where not exists(select * from hop_dong
where hop_dong.ngay_lam_hop_dong between '2019-01-01' and '2021-12-31'  and hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien);

-- cau 17
update khach_hang,(
select hd.ma_khach_hang as id, sum (dv.chi_phi_thue + dvdk.gia * hdct.so_luong) as tong_tien
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach 
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu

where year(hop_dong.ngay_lam_hop_dong) = 2019
group by hd.ma_khach_hang
having tong_tien>10000000) as temp 
set khach_hang.ma_loai_khach = (select loai_khach.ma_loai_khach from loai_khach 
where loai_khach.ten_loai_khach = 'Diamond')
where khach_hang.ma_loai_khach = (select loai_khach.ma_loai_khach from loai_khach 
where loai_khach.ten_loai_khach = 'Platinum')
and temp.id = khach_hang.ma_khach_hang;


-- cau 18
delete from khach_hang 
where not exists(
select * from hop_dong where khach_hang.ma_khach_hang = hop_dong.ma_khach_hang and year(hop_dong.ngay_lam_hop_dong) >= '2021');

delete from nhan_vien
where not exists(select * from hop_dong
where hop_dong.ngay_lam_hop_dong between '2019-01-01' and '2021-12-31'  and hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien);

-- cau 19
update dich_vu_di_kem
inner join (select dich_vu_di_kem.ten_dich_vu_di_kem as ten_dich_vu_di_kem from hop_dong_chi_tiet
inner join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having count(hop_dong_chi_tiet.ma_dich_vu_di_kem)> 10) as temp set dich_vu_di_kem.gia = dich_vu_di_kem.gia* 2 where dich_vu_di_kem.ten_dich_vu_di_kem = temp.ten_dich_vu_di_kem;

-- cau 20
select ma_nhan_vien as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien
union all 
select  ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang;