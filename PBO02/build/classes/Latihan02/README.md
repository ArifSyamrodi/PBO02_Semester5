

# Aplikasi Penghitung Umur

Aplikasi ini memungkinkan pengguna untuk menghitung umur berdasarkan tanggal lahir yang dipilih menggunakan `JDateChooser`. Setelah memilih tanggal lahir, aplikasi akan menampilkan umur dalam satuan tahun, bulan, dan hari. Selain itu, aplikasi juga memberikan informasi tambahan mengenai hari ulang tahun berikutnya dan peristiwa penting yang terjadi pada tanggal tersebut.

## Deskripsi Program
Aplikasi ini memiliki fitur utama sebagai berikut:
- **Pilih tanggal lahir**: Pengguna dapat memilih tanggal lahir menggunakan komponen `JDateChooser`.
- **Hitung umur**: Setelah memilih tanggal lahir dan menekan tombol **Hitung**, aplikasi akan menampilkan umur dalam tahun, bulan, dan hari.
- **Hari ulang tahun berikutnya**: Aplikasi juga akan menampilkan informasi mengenai tanggal ulang tahun berikutnya.
- **Peristiwa penting**: Aplikasi dapat mengintegrasikan API eksternal untuk menampilkan peristiwa yang terjadi pada tanggal lahir.

## Komponen GUI
Aplikasi ini menggunakan beberapa komponen GUI, antara lain:
- **JFrame**: Sebagai jendela utama aplikasi.
- **JPanel**: Sebagai wadah untuk komponen lainnya.
- **JLabel**: Untuk menampilkan teks label.
- **JDateChooser**: Untuk memilih tanggal lahir.
- **JButton**: Untuk tombol **Hitung**.
- **JTextField**: Untuk menampilkan hasil perhitungan umur dan informasi tambahan.

## Logika Program
- Manipulasi tanggal dilakukan menggunakan kelas **LocalDate** untuk mendapatkan umur dalam tahun, bulan, dan hari dengan cara menghitung selisih antara tanggal lahir dan tanggal saat ini.
- Perhitungan ulang tahun berikutnya dilakukan dengan membandingkan tanggal lahir dengan tanggal saat ini.
- API eksternal dapat digunakan untuk menampilkan peristiwa penting yang terjadi pada tanggal lahir, misalnya dengan menggunakan API yang menyediakan data sejarah.

## Events
- **ActionListener** untuk menangani event klik pada tombol **Hitung**.
- **PropertyChangeListener** pada `JDateChooser` untuk mendeteksi perubahan tanggal lahir yang dipilih oleh pengguna.

## Variasi
- Aplikasi ini dapat mengintegrasikan dengan **API eksternal** untuk menampilkan peristiwa penting atau sejarah yang terjadi pada tanggal lahir yang dipilih oleh pengguna.

## Langkah-langkah Penggunaan
1. Pilih tanggal lahir dengan menggunakan `JDateChooser`.
2. Klik tombol **Hitung** untuk melihat hasil umur dalam tahun, bulan, dan hari.
3. Aplikasi akan menampilkan informasi tambahan mengenai hari ulang tahun berikutnya.
4. (Opsional) Jika terintegrasi dengan API eksternal, aplikasi akan menampilkan peristiwa penting pada tanggal tersebut.

## Pembuat
- **Nama**: Muhamad Arif Syamrodi
- **NPM**: 2210010316

## Teknologi yang Digunakan
- Java Swing (JFrame, JPanel, JLabel, JDateChooser, JButton, JTextField)
- Java LocalDate untuk perhitungan tanggal
- API eksternal (opsional) untuk peristiwa penting

## Instalasi
1. Pastikan Java Development Kit (JDK) dan pustaka `JDateChooser` telah terinstal di komputer Anda.
2. Clone repositori ini ke direktori lokal Anda:
   ```bash
   git clone https://github.com/username/repository.git
   ```
3. Kompilasi dan jalankan aplikasi:
   ```bash
   javac AplikasiPenghitungUmur.java
   java AplikasiPenghitungUmur
   ```

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](LICENSE).
```

