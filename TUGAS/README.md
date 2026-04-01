## Deskripsi kasus
Saya memilih masalah ini karena pengalaman pribadi yang cukup susah untuk mengatur keuangan di setiap bulannya, maka dari itu saya membuat sebuah 
program yang mungkin akan membantu saya atau mungkin orang lain untuk mengatur pengeluaran untuk kebutuhan primer.

## CLASS DIAGRAM
<img width="482" height="574" alt="image" src="https://github.com/user-attachments/assets/b21fef88-50ce-43b6-a943-508dc0121015" />

## PROGRES

# User
```
import java.util.Scanner;

class User {
   private String nama;
   private Scanner scanner;

   public User(String var1, Scanner var2) {
      this.nama = var1;
      this.scanner = var2;
   }

   public Produk inputProduk() {
      System.out.print("Nama produk   : ");
      String var1 = this.scanner.nextLine();
      System.out.print("Harga         : ");
      double var2 = this.scanner.nextDouble();
      System.out.print("Jumlah        : ");
      int var4 = this.scanner.nextInt();
      this.scanner.nextLine();
      return new Produk(var1, var2, var4);
   }
}
```

# daftafbelanja dan tampilkanDaftar
```
import java.util.ArrayList;

class DaftarBelanja {
   private ArrayList<Produk> daftarProduk = new ArrayList();
   private double budget;

   public DaftarBelanja(double var1) {
      this.budget = var1;
   }

   public void tambahProduk(Produk var1) {
      this.daftarProduk.add(var1);
   }

   public double hitungTotal() {
      double var1 = (double)0.0F;

      for(Produk var4 : this.daftarProduk) {
         var1 += var4.getTotalHarga();
      }

      return var1;
   }

   public void tampilkanDaftar() {
      System.out.println("\n=== DAFTAR BELANJA ===");
      if (this.daftarProduk.isEmpty()) {
         System.out.println("Belum ada produk.");
      } else {
         for(Produk var2 : this.daftarProduk) {
            System.out.println(var2.getInfo());
         }

         double var3 = this.hitungTotal();
         System.out.println("----------------------");
         System.out.println("Total Belanja: " + var3);
         System.out.println("Budget: " + this.budget);
         if (var3 > this.budget) {
            System.out.println("Melebihi budget!");
         } else {
            System.out.println("Masih dalam batas budget");
         }

      }
   }
}
```

# produk
```
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
class Produk {
   private String nama;
   private double harga;
   private int jumlah;

   public Produk(String var1, double var2, int var4) {
      this.nama = var1;
      this.harga = var2;
      this.jumlah = var4;
   }

   public double getTotalHarga() {
      return this.harga * (double)this.jumlah;
   }

   public String getInfo() {
      String var10000 = this.nama;
      return var10000 + " | Harga: " + this.harga + " | Jumlah: " + this.jumlah + " | Total: " + this.getTotalHarga();
   }
}

```

## Penjelasan Prinsip OOP yang Diterapkan
Semua atribut dalam kelas Produk, DaftarBelanja, dan User dideklarasikan sebagai private. Data seperti harga dan jumlah dalam Produk tidak dapat diakses atau diubah secara langsung dari luar kelas, hanya dapat diambil melalui metode getTotalHarga() dan getInfo(). Demikian pula, daftarProduk dalam DaftarBelanja tidak dapat dimanipulasi secara langsung dari main.
Abstraksi
Kelas DaftarBelanja menyembunyikan cara kerjanya dari main. Ketika metode tambahProduk() dipanggil, main tidak perlu mengetahui bagaimana produk disimpan dalam ArrayList. Begitu juga dengan hitungTotal(), semua logika perhitungan tersembunyi di dalam metode tersebut.
Tanggung Jawab Tunggal (bagian dari desain OOP)
Setiap kelas memiliki tanggung jawab yang jelas dan tidak tumpang tindih. Kelas Produk hanya menyimpan data barang, DaftarBelanja mengelola logika daftar dan anggaran, dan User mengelola interaksi dengan pengguna melalui input dari keyboard.



## Keunikan Program
Keunikan dari program ini ada pada pemisahan tanggung jawab pada input ke User. Biasanya logika scanner langsung ditulis di main,tapi di sini proses input produk dipindahkan ke method inputProduk() milik user. Ini mebuat main lebih bersih dan bila suatu saat input ingin diubah , cukup hanya mengganti di satu tempat.
