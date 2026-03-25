## Deskripsi kasus
Saya memilih masalah ini karena pengalaman pribadi yang cukup susah untuk mengatur keuangan di setiap bulannya

## Penjelasan Prinsip OOP yang Diterapkan
Semua atribut dalam kelas Produk, DaftarBelanja, dan User dideklarasikan sebagai private. Data seperti harga dan jumlah dalam Produk tidak dapat diakses atau diubah secara langsung dari luar kelas, hanya dapat diambil melalui metode getTotalHarga() dan getInfo(). Demikian pula, daftarProduk dalam DaftarBelanja tidak dapat dimanipulasi secara langsung dari main.
Abstraksi
Kelas DaftarBelanja menyembunyikan cara kerjanya dari main. Ketika metode tambahProduk() dipanggil, main tidak perlu mengetahui bagaimana produk disimpan dalam ArrayList. Begitu juga dengan hitungTotal(), semua logika perhitungan tersembunyi di dalam metode tersebut.
Tanggung Jawab Tunggal (bagian dari desain OOP)
Setiap kelas memiliki tanggung jawab yang jelas dan tidak tumpang tindih. Kelas Produk hanya menyimpan data barang, DaftarBelanja mengelola logika daftar dan anggaran, dan User mengelola interaksi dengan pengguna melalui input dari keyboard.

## Keunikan Program
Keunikan dari program ini ada pada pemisahan tanggung jawab pada input ke User. Biasanya logika scanner langsung ditulis di main,tapi di sini proses input produk dipindahkan ke method inputProduk() milik user. Ini mebuat main lebih bersih dan bila suatu saat input ingin diubah , cukup hanya mengganti di satu tempat.