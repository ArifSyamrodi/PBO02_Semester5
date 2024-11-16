
# Aplikasi Penghitung Kata

Aplikasi ini digunakan untuk menghitung jumlah kata dan karakter dalam sebuah teks. Aplikasi dirancang dengan antarmuka sederhana menggunakan Java Swing, dan dilengkapi dengan fitur tambahan untuk analisis teks lebih mendalam.

## Deskripsi Program
Fitur utama aplikasi ini meliputi:
- **Penghitungan Kata dan Karakter**: Menghitung jumlah kata dan karakter dari teks yang dimasukkan.
- **Teks Input**: Pengguna dapat memasukkan teks dalam area teks yang disediakan.
- **Penghitungan Real-Time**: Jumlah kata dan karakter dihitung secara otomatis saat teks dimasukkan atau dimodifikasi.
- **Fitur Tambahan**:
  - Hitung jumlah kalimat dan paragraf.
  - Cari kemunculan kata tertentu dalam teks.
  - Simpan teks dan hasil perhitungan ke file.

## Komponen GUI
Aplikasi ini menggunakan beberapa komponen GUI:
- **JFrame**: Sebagai jendela utama aplikasi.
- **JPanel**: Untuk menyusun elemen antarmuka.
- **JLabel**: Untuk menampilkan hasil perhitungan jumlah kata, karakter, kalimat, dan paragraf.
- **JTextArea**: Untuk memasukkan teks, yang dibungkus dalam `JScrollPane`.
- **JScrollPane**: Untuk menambahkan kemampuan scrolling pada `JTextArea`.
- **JButton**: Untuk memulai proses perhitungan secara manual.

## Logika Program
- **Manipulasi String**:
  - Kata dihitung berdasarkan spasi atau ekspresi reguler yang memisahkan teks.
  - Karakter dihitung dengan menghitung panjang string.
- **Ekspresi Reguler**:
  - Mengidentifikasi kata, kalimat (dengan tanda titik), dan paragraf (berdasarkan garis baru).
- **Real-Time Update**:
  - Menggunakan `DocumentListener` untuk memperbarui hasil perhitungan setiap kali teks dimodifikasi.

## Events
- **ActionListener**:
  - Digunakan pada tombol **Hitung** untuk memproses teks yang ada dalam `JTextArea` dan menampilkan hasilnya.
- **DocumentListener**:
  - Menghitung jumlah kata dan karakter secara real-time ketika teks dimasukkan atau diubah di `JTextArea`.

## Variasi
- **Hitung Kalimat dan Paragraf**:
  - Tambahkan fitur untuk menghitung jumlah kalimat berdasarkan tanda titik (`.`) dan paragraf berdasarkan baris baru (`\n`).
- **Pencarian Kata**:
  - Implementasikan fitur untuk mencari kata tertentu dalam teks, termasuk jumlah kemunculannya.
- **Simpan Hasil**:
  - Sediakan opsi untuk menyimpan teks dan hasil perhitungan ke dalam file teks.

## Langkah-langkah Penggunaan
1. Masukkan teks ke dalam area teks (`JTextArea`) yang disediakan.
2. Hasil perhitungan jumlah kata dan karakter akan langsung muncul (jika menggunakan real-time update).
3. Klik tombol **Hitung** untuk memproses teks secara manual (opsional).
4. (Opsional) Gunakan fitur tambahan seperti pencarian kata atau simpan hasil perhitungan ke file.

## Pembuat
- **Nama**: Muhamad Arif Syamrodi
- **NPM**: 2210010316

## Teknologi yang Digunakan
- **Java Swing** untuk antarmuka pengguna (GUI).
- **Java IO** untuk menyimpan teks dan hasil perhitungan ke file.
- **Java String Manipulation** dan **Regular Expressions** untuk analisis teks.

## Instalasi
1. Pastikan Java Development Kit (JDK) telah diinstal di komputer Anda.
2. Unduh atau clone repositori aplikasi:
   ```bash
   git clone https://github.com/username/repository.git
   ```
3. Kompilasi dan jalankan aplikasi:
   ```bash
   javac AplikasiPenghitungKata.java
   java AplikasiPenghitungKata
   ```

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](LICENSE).
```

**Penjelasan**:
- Penjelasan fitur utama terdapat di bagian "Deskripsi Program."
- Detail teknis dan komponen GUI dijelaskan agar mempermudah pemahaman.
- Variasi seperti penghitungan kalimat, pencarian kata, dan penyimpanan hasil diberikan sebagai fitur tambahan.
- Informasi instalasi memberikan langkah-langkah untuk menjalankan aplikasi.

Dokumen ini dapat digunakan sebagai dokumentasi resmi aplikasi Anda.