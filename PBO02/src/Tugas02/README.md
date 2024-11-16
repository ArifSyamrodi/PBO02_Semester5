
# Aplikasi Konversi Suhu

Aplikasi ini dirancang untuk membantu pengguna melakukan konversi suhu antara beberapa skala, seperti Celcius, Fahrenheit, Kelvin, dan Reamur. Pengguna dapat memilih jenis konversi dan melihat hasilnya langsung setelah memasukkan nilai suhu.

## Deskripsi Program
Fitur utama aplikasi ini meliputi:
- **Input Suhu**: Pengguna dapat memasukkan nilai suhu dalam kolom input.
- **Pilih Konversi**: Pilih arah konversi suhu, seperti Celcius ke Fahrenheit atau Celcius ke Kelvin, menggunakan `JRadioButton` dan `JComboBox`.
- **Hasil Konversi**: Hasil konversi ditampilkan setelah tombol **Konversi** ditekan atau secara otomatis saat nilai input berubah.

## Komponen GUI
Aplikasi ini menggunakan komponen berikut:
- **JFrame**: Sebagai jendela utama aplikasi.
- **JPanel**: Untuk menyusun komponen GUI.
- **JLabel**: Untuk teks label pada antarmuka.
- **JTextField**: Untuk input nilai suhu.
- **JComboBox**: Untuk memilih skala suhu tujuan.
- **JRadioButton**: Untuk memilih arah konversi suhu (misalnya, Celcius ke Fahrenheit).
- **JButton**: Untuk tombol **Konversi**.

## Logika Program
- **Rumus Konversi**: Program menggunakan rumus matematika untuk menghitung konversi suhu antara skala berikut:
  - **Celcius ke Fahrenheit**: \( F = \frac{9}{5}C + 32 \)
  - **Celcius ke Kelvin**: \( K = C + 273.15 \)
  - **Celcius ke Reamur**: \( R = \frac{4}{5}C \)
- **Validasi Input**: Input suhu divalidasi untuk memastikan hanya angka yang diperbolehkan.
- **Konversi Otomatis**: Nilai konversi diperbarui secara otomatis jika nilai input diubah.

## Events
- **ActionListener** untuk tombol **Konversi**, yang memicu perhitungan dan menampilkan hasil.
- **KeyAdapter** pada `JTextField` untuk membatasi input hanya berupa angka.
- **ItemListener** pada `JRadioButton` untuk mengubah arah konversi suhu.
- **DocumentListener** (opsional) untuk konversi otomatis ketika nilai input berubah.

## Variasi
- Tambahkan skala suhu lain seperti Kelvin dan Reamur.
- Gunakan `JRadioButton` untuk memilih arah konversi suhu, seperti Fahrenheit ke Celcius atau Kelvin ke Celcius.
- Implementasikan konversi otomatis menggunakan `DocumentListener` atau mekanisme serupa untuk memperbarui hasil secara real-time saat nilai input berubah.

## Langkah-langkah Penggunaan
1. Masukkan nilai suhu dalam kolom input.
2. Pilih arah konversi menggunakan `JRadioButton`.
3. Pilih skala tujuan suhu menggunakan `JComboBox`.
4. Klik tombol **Konversi** untuk melihat hasil konversi.
5. Hasil konversi akan ditampilkan dalam label atau dialog.

## Pembuat
- **Nama**: Muhamad Arif Syamrodi
- **NPM**: 2210010316

## Teknologi yang Digunakan
- **Java Swing** untuk antarmuka pengguna (GUI).
- **AWT Events** untuk menangani interaksi pengguna.
- **Java Math** untuk logika perhitungan suhu.

## Instalasi
1. Pastikan Java Development Kit (JDK) telah diinstal di komputer Anda.
2. Unduh atau clone repositori aplikasi:
   ```bash
   git clone https://github.com/username/repository.git
   ```
3. Kompilasi dan jalankan aplikasi:
   ```bash
   javac AplikasiKonversiSuhu.java
   java AplikasiKonversiSuhu
   ```

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](LICENSE).
```

**Penjelasan:**
- Penjelasan tentang fitur aplikasi dijabarkan dalam **Deskripsi Program**.
- Komponen GUI dirinci untuk menunjukkan elemen-elemen antarmuka.
- **Logika Program** menjelaskan rumus dan validasi input.
- Langkah penggunaan disusun agar mudah diikuti.
- Informasi tentang teknologi dan cara instalasi disediakan untuk membantu pengembang menjalankan aplikasi.

Dokumen ini dapat langsung digunakan atau dimodifikasi lebih lanjut sesuai kebutuhan.