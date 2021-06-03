# BÁO CÁO CUỐI KỲ: Quản Lý Thư Viện - Nhóm KHP2T

## I. Phân công công việc:
1. Công việc chung:
* Đặc tả yêu cầu phần mềm
* Thiết kế luồng hoạt động
2. Công việc riêng:
* Nguyễn Đình Khoa: Phân chia công việc, Code chức năng Quản Lý Mượn Trả, Kiểm thử phần mềm, Thiết kế cơ sở dữ liệu.
* Cao Thị Thùy Hằng: Code chức năng Quản Lý Sách và Danh mục Sách, Thiết kế giao diện phần mềm, Thiết kế cơ sở dữ liệu, Viết báo cáo.
* Võ Xuân Phúc: Code chức năng Quản Lý Độc giả, Code chức năng Thống Kê, Kiểm thử phần mềm.
* Lê Quốc Tuấn: Code chức năng Mượn sách, Kiểm thử phần mềm, Thiết kế cơ sở dữ liệu.
* Nguyễn Thị Thu Thủy: Thiết kế giao diện trang chủ, Làm slide thuyết trình dự án.

## II. Tóm tắt dự án
Phần mèm Quản lý thư viện dành cho sinh viên trường ĐH SPKT sử dụng và được quản lý bới thủ thư

## III. Một số lưu ý
* Nếu máy của bạn sử dụng SQL Server 2019 thì hãy chạy file script QuanLyThuVien_SQL2019 để tạo Database trước khi chạy phần mềm.
* Nếu máy của bạn sử dụng SQL Server 2014 thì hãy chạy file script QuanLyThuVien_SQL2014 để tạo Database trước khi chạy phần mềm.
* Hãy đổi tên server trong file KetNoiSQL.java theo đường dẫn ://src/DAO/KetNoiSQL.java
```Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://YourServername:YourPort/QuanLyThuVien6";
            return DriverManager.getConnection(dbUrl);
```            
## IV. Cách sử dụng
* Đăng nhập bằng tài khoản thủ thư: Tên đăng nhập: 101010 | Mật khẩu: abc123
* Đăng nhập bằng tài khoản sinh viên: Tên đăng nhập: Mã sinh viên | Mật khẩu: Tự đặt (Ví dụ: 1911505310132 | abc123)
* Video demo dự án: https://youtu.be/kQuOaejObnc
