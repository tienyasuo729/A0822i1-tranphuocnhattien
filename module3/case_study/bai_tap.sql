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
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, sum(dv.chi_phi_thue + hdct.so_luong * dvdk.gia) as tong_tien
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong;
