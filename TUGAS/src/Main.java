import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String namaUser = scanner.nextLine();
        System.out.print("Masukkan budget bulanan: ");
        double budget = scanner.nextDouble();
        scanner.nextLine();

        User user = new User(namaUser, scanner);
        DaftarBelanja daftar = new DaftarBelanja(budget);

        int pilihan;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Daftar");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    Produk p = user.inputProduk();
                    daftar.tambahProduk(p);
                    System.out.println("Produk berhasil ditambahkan!");
                    break;
                case 2:
                    daftar.tampilkanDaftar();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan program!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);

        scanner.close();
    }
}
class Produk {
    private String nama;
    private double harga;
    private int jumlah;

    public Produk(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public double getTotalHarga() {
        return harga * jumlah;
    }

    public String getInfo() {
        return nama + " | Harga: " + harga +
               " | Jumlah: " + jumlah +
               " | Total: " + getTotalHarga();
    }
}

class DaftarBelanja {
    private ArrayList<Produk> daftarProduk = new ArrayList<>();
    private double budget;

    public DaftarBelanja(double budget) {
        this.budget = budget;
    }

    public void tambahProduk(Produk p) {
        daftarProduk.add(p);
    }

    public double hitungTotal() {
        double total = 0;
        for (Produk p : daftarProduk) {
            total += p.getTotalHarga();
        }
        return total;
    }

    public void tampilkanDaftar() {
        System.out.println("\n=== DAFTAR BELANJA ===");
        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada produk.");
            return;
        }
        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo());
        }
        double total = hitungTotal();
        System.out.println("----------------------");
        System.out.println("Total Belanja: " + total);
        System.out.println("Budget: " + budget);
        if (total > budget) {
            System.out.println("Melebihi budget!");
        } else {
            System.out.println("Masih dalam batas budget");
        }
    }
}

class User {
    private String nama;
    private Scanner scanner;

    public User(String nama, Scanner scanner) {
        this.nama = nama;
        this.scanner = scanner;
    }

    public Produk inputProduk() {
        System.out.print("Nama produk   : ");
        String nama = scanner.nextLine();
        System.out.print("Harga         : ");
        double harga = scanner.nextDouble();
        System.out.print("Jumlah        : ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();
        return new Produk(nama, harga, jumlah);
    }
}
