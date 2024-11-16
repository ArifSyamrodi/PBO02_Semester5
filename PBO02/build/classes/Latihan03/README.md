
# Aplikasi Pengelolaan Kontak

Aplikasi Pengelolaan Kontak adalah aplikasi desktop berbasis Java yang memungkinkan pengguna untuk menyimpan, mengelola, dan mengelompokkan informasi kontak ke dalam kategori tertentu. Data kontak disimpan menggunakan database SQLite, dan aplikasi dilengkapi dengan fitur CRUD (Create, Read, Update, Delete), pencarian kontak, serta impor/ekspor data ke/dari file CSV.

## Deskripsi Program
Fitur utama aplikasi ini meliputi:
- **Menyimpan informasi kontak**: Pengguna dapat menambahkan kontak baru dengan informasi nama, nomor telepon, dan kategori (keluarga, teman, kerja, dll.).
- **Pengelolaan kontak**: Kontak yang tersimpan dapat diedit, dihapus, atau dilihat berdasarkan kategori.
- **Pencarian kontak**: Fitur pencarian memungkinkan pengguna untuk mencari kontak berdasarkan nama atau nomor telepon.
- **Impor/Ekspor kontak**: Daftar kontak dapat diekspor ke file CSV untuk dicadangkan atau diimpor dari file CSV untuk menambahkan data ke dalam database.

## Komponen GUI
Aplikasi ini menggunakan beberapa komponen GUI, antara lain:
- **JFrame**: Sebagai jendela utama aplikasi.
- **JPanel**: Untuk mengelompokkan dan menyusun komponen GUI.
- **JLabel**: Untuk menampilkan teks label.
- **JTextField**: Untuk input nama dan nomor telepon.
- **JButton**: Untuk tombol aksi seperti Tambah, Edit, Hapus, dan Cari.
- **JComboBox**: Untuk memilih kategori kontak.
- **JTable**: Untuk menampilkan daftar kontak.
- **JScrollPane**: Untuk memungkinkan tabel atau daftar panjang dapat digulir.

## Logika Program
- Database menggunakan **SQLite** untuk menyimpan data kontak secara lokal.
- Implementasi fitur CRUD untuk menambahkan, membaca, memperbarui, dan menghapus kontak dari database.
- Validasi input untuk memastikan nomor telepon hanya berisi angka dan memiliki panjang tertentu.
- Pencarian kontak berdasarkan nama atau nomor telepon, dengan hasil yang ditampilkan di **JTable**.
- Fitur ekspor kontak ke file CSV dan impor dari file CSV ke database.

## Events
- **ActionListener** digunakan untuk menangani event pada tombol Tambah, Edit, Hapus, dan Cari.
- **ItemListener** digunakan untuk menangani perubahan pilihan pada **JComboBox** kategori kontak.

## Variasi
- Fitur pencarian kontak yang fleksibel berdasarkan nama atau nomor telepon.
- Validasi input pada nomor telepon untuk memastikan hanya angka yang dapat dimasukkan, dan panjang nomor sesuai standar.
- Impor dan ekspor data kontak untuk mendukung pencadangan dan pemulihan data dengan file CSV.

## Langkah-langkah Penggunaan
1. **Menambahkan kontak**:
   - Masukkan nama, nomor telepon, dan pilih kategori.
   - Klik tombol **Tambah** untuk menyimpan kontak ke database.
2. **Mengedit kontak**:
   - Pilih kontak dari daftar di tabel.
   - Edit informasi pada kolom input dan klik tombol **Edit** untuk memperbarui data.
3. **Menghapus kontak**:
   - Pilih kontak dari daftar di tabel.
   - Klik tombol **Hapus** untuk menghapus data dari database.
4. **Mencari kontak**:
   - Masukkan nama atau nomor telepon di kolom pencarian.
   - Klik tombol **Cari** untuk menampilkan hasil di tabel.
5. **Impor/Ekspor kontak**:
   - Klik tombol **Ekspor CSV** untuk menyimpan kontak ke file CSV.
   - Klik tombol **Impor CSV** untuk menambahkan data dari file CSV ke database.

## Pembuat
- **Nama**: Muhamad Arif Syamrodi
- **NPM**: 2210010316

## Teknologi yang Digunakan
- **Java Swing** untuk antarmuka pengguna (GUI).
- **SQLite** untuk penyimpanan data lokal.
- **OpenCSV** (opsional) untuk membaca dan menulis file CSV.

## Instalasi
1. Pastikan Java Development Kit (JDK) dan pustaka SQLite telah diinstal di komputer Anda.
2. Unduh atau clone repositori aplikasi:
   ```bash
   git clone https://github.com/username/repository.git
   ```
3. Kompilasi dan jalankan aplikasi:
   ```bash
   javac AplikasiPengelolaanKontak.java
   java AplikasiPengelolaanKontak
   ```
4. (Opsional) Tambahkan pustaka `sqlite-jdbc` dan `opencsv` ke classpath jika diperlukan.

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](LICENSE).
```

Penjelasan:
- Penjelasan fitur utama dan langkah-langkah penggunaan aplikasi dijelaskan secara rinci.
- Fitur ekspor dan impor CSV disoroti sebagai tambahan opsional.
- Teknologi yang digunakan disebutkan termasuk pustaka SQLite dan OpenCSV.
- Tidak ada tampilan contoh, sesuai permintaan Anda. 

Dokumen ini dapat digunakan langsung atau disesuaikan lebih lanjut sesuai kebutuhan.