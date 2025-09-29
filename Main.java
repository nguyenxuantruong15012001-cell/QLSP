import java.util.*;

public class Main {
    static List<Product> dsSanPham = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them san pham");
            System.out.println("2. Cap nhat thong tin san pham");
            System.out.println("3. Hien thi danh sach san pham");
            System.out.println("4. Tinh tong gia tri ton kho theo danh muc");
            System.out.println("5. Ap dung giam gia");
            System.out.println("6. Dat hang");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: themSanPham(); break;
                case 2: capNhatSanPham(); break;
                case 3: hienThiSanPham(); break;
                case 4: tinhTonKho(); break;
                case 5: apDungGiamGia(); break;
                case 6: datHang(); break;
                case 0: System.exit(0);
                default: System.out.println("Lua chon khong hop le!");
            }
        }
    }

    static void themSanPham() {
        System.out.print("Nhap ten: ");
        String ten = sc.nextLine();
        System.out.print("Nhap mo ta: ");
        String moTa = sc.nextLine();
        System.out.print("Nhap danh muc: ");
        String danhMuc = sc.nextLine();
        System.out.print("Nhap gia: ");
        double gia = sc.nextDouble();
        System.out.print("Nhap so luong: ");
        int soLuong = sc.nextInt();
        sc.nextLine();

        dsSanPham.add(new Product(ten, moTa, danhMuc, gia, soLuong));
        System.out.println("Them thanh cong!");
    }

    static void capNhatSanPham() {
        System.out.print("Nhap ten san pham muon cap nhat: ");
        String ten = sc.nextLine();
        for (Product sp : dsSanPham) {
            if (sp.ten.equalsIgnoreCase(ten)) {
                System.out.print("Nhap gia moi: ");
                sp.gia = sc.nextDouble();
                sc.nextLine();
                System.out.print("Nhap mo ta moi: ");
                sp.moTa = sc.nextLine();
                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham!");
    }

    static void hienThiSanPham() {
        System.out.println("Hien thi theo: 1. Gia  2. Danh muc");
        int chon = sc.nextInt(); sc.nextLine();

        if (chon == 1) {
            dsSanPham.sort(Comparator.comparingDouble(sp -> sp.gia));
        } else if (chon == 2) {
            dsSanPham.sort(Comparator.comparing(sp -> sp.danhMuc));
        }

        for (Product sp : dsSanPham) {
            System.out.println(sp);
        }
    }

    static void tinhTonKho() {
        Map<String, Double> tongTheoDanhMuc = new HashMap<>();
        for (Product sp : dsSanPham) {
            tongTheoDanhMuc.put(sp.danhMuc,
                    tongTheoDanhMuc.getOrDefault(sp.danhMuc, 0.0) + sp.tongGiaTri());
        }
        for (String dm : tongTheoDanhMuc.keySet()) {
            System.out.println("Danh muc: " + dm + " - Tong gia tri: " + tongTheoDanhMuc.get(dm));
        }
    }

    static void apDungGiamGia() {
        System.out.print("Nhap ten san pham muon giam gia: ");
        String ten = sc.nextLine();
        for (Product sp : dsSanPham) {
            if (sp.ten.equalsIgnoreCase(ten)) {
                System.out.print("Nhap phan tram giam: ");
                double pt = sc.nextDouble();
                sc.nextLine();
                sp.giamGia(pt);
                System.out.println("Giam gia thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham!");
    }

    static void datHang() {
        System.out.print("Nhap ten san pham muon dat: ");
        String ten = sc.nextLine();
        for (Product sp : dsSanPham) {
            if (sp.ten.equalsIgnoreCase(ten)) {
                System.out.print("Nhap so luong muon dat: ");
                int sl = sc.nextInt();
                sc.nextLine();
                if (sl <= sp.soLuong) {
                    double tongTien = sl * sp.gia;
                    sp.soLuong -= sl;
                    System.out.println("Dat hang thanh cong! Tong tien: " + tongTien);
                } else {
                    System.out.println("Khong du so luong ton kho!");
                }
                return;
            }
        }
        System.out.println("Khong tim thay san pham!");
    }
}
