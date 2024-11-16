
# Aplikasi Cek Nomor Genap/Ganjil

Aplikasi ini memungkinkan pengguna untuk memeriksa apakah suatu angka adalah bilangan genap atau ganjil. Aplikasi ini juga memiliki fitur tambahan untuk memeriksa apakah angka tersebut merupakan bilangan prima. Antarmuka pengguna dibuat menggunakan Java Swing, dengan validasi input untuk memastikan hanya angka yang dapat dimasukkan.

## Deskripsi Program
Fitur utama aplikasi ini meliputi:
- **Pengecekan Genap/Ganjil**: Pengguna dapat memasukkan angka pada kolom input, dan aplikasi akan menampilkan apakah angka tersebut genap atau ganjil.
- **Pengecekan Bilangan Prima**: Selain memeriksa genap/ganjil, aplikasi juga dapat memberi tahu apakah angka tersebut adalah bilangan prima.
- **Validasi Input**: Input hanya diperbolehkan berupa angka. Kesalahan input akan ditangani menggunakan `JOptionPane`.
- **Pembersihan Input**: Kolom input otomatis dibersihkan saat mendapatkan fokus.

## Komponen GUI
Aplikasi ini menggunakan beberapa komponen GUI, antara lain:
- **JFrame**: Sebagai jendela utama aplikasi.
- **JPanel**: Untuk mengelompokkan dan menyusun komponen GUI.
- **JLabel**: Untuk menampilkan teks hasil.
- **JTextField**: Untuk input angka.
- **JButton**: Untuk tombol **Cek**.

## Logika Program
- **Kondisional**: Menggunakan struktur **if-else** untuk menentukan apakah angka genap atau ganjil.
- **Validasi Input**: Memastikan bahwa input hanya berisi angka.
- **Bilangan Prima**: Menggunakan logika matematika untuk memeriksa apakah angka adalah bilangan prima.
- **JOptionPane**: Untuk menampilkan pesan hasil (genap/ganjil dan bilangan prima) atau kesalahan input.

## Events
- **ActionListener** digunakan untuk menangani event pada tombol **Cek**.
- **KeyAdapter** digunakan untuk membatasi input pada **JTextField** hanya berupa angka.
- **FocusListener** digunakan untuk membersihkan **JTextField** saat mendapatkan fokus.

## Variasi
- **Pengecekan Bilangan Prima**: Tambahkan logika untuk memeriksa apakah angka adalah bilangan prima.
- **JOptionPane**: Tampilkan hasil dan pesan kesalahan menggunakan dialog interaktif.
- **FocusListener**: Otomatis membersihkan kolom input setiap kali pengguna kembali fokus pada **JTextField**.

## Langkah-langkah Penggunaan
1. Masukkan angka pada kolom input.
2. Klik tombol **Cek** untuk melihat hasil pengecekan (genap/ganjil dan bilangan prima).
3. Jika input tidak valid (bukan angka), aplikasi akan menampilkan pesan kesalahan.
4. Kolom input akan otomatis kosong saat pengguna memindahkan fokus kembali ke kolom tersebut.

## Pembuat
- **Nama**: Muhamad Arif Syamrodi
- **NPM**: 2210010316

## Teknologi yang Digunakan
- **Java Swing** untuk antarmuka pengguna (GUI).
- **JOptionPane** untuk dialog pesan hasil dan error.
- **Java AWT Events** untuk menangani event seperti klik tombol dan perubahan fokus.

## Instalasi
1. Pastikan Java Development Kit (JDK) telah diinstal di komputer Anda.
2. Unduh atau clone repositori aplikasi:
   ```bash
   git clone https://github.com/username/repository.git
   ```
3. Kompilasi dan jalankan aplikasi:
   ```bash
   javac AplikasiCekNomorGenapGanjil.java
   java AplikasiCekNomorGenapGanjil
   ```

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](LICENSE).
```

Penjelasan:
- Penjelasan fitur dan langkah-langkah penggunaan dirancang agar mudah dipahami.
- Validasi input, fitur bilangan prima, dan pembersihan input saat fokus sudah dijelaskan sebagai bagian dari variasi.
- Bagian "Instalasi" memberi langkah-langkah untuk menjalankan aplikasi. 

Dokumen ini siap digunakan dan dapat dimodifikasi sesuai kebutuhan.