public class Product {
    String ten;
    String moTa;
    String danhMuc;
    double gia;
    int soLuong;

    public Product(String ten, String moTa, String danhMuc, double gia, int soLuong) {
        this.ten = ten;
        this.moTa = moTa;
        this.danhMuc = danhMuc;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public double tongGiaTri() {
        return gia * soLuong;
    }

    public void giamGia(double phanTram) {
        gia = gia * (1 - phanTram / 100);
    }

    @Override
    public String toString() {
        return "San pham: " + ten + ", Mo ta: " + moTa + ", Danh muc: " + danhMuc
                + ", Gia: " + gia + ", So luong: " + soLuong;
    }
}
