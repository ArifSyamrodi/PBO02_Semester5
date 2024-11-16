Berikut adalah `README.md` untuk "Aplikasi Perhitungan Hari":

```markdown
# Aplikasi Perhitungan Hari

Aplikasi ini memungkinkan pengguna untuk mengetahui jumlah hari dalam sebuah bulan tertentu pada tahun tertentu. Aplikasi juga dapat menampilkan informasi tambahan seperti hari pertama dan terakhir dari bulan tersebut, serta menghitung selisih hari antara dua tanggal.

## Deskripsi Program
Fitur utama aplikasi ini meliputi:
- **Perhitungan Hari dalam Bulan**: Menghitung jumlah hari dalam sebuah bulan berdasarkan tahun (termasuk tahun kabisat).
- **Penggunaan JCalendar**: Memungkinkan pengguna memilih bulan dan tahun melalui antarmuka kalender.
- **Informasi Tambahan**: Menampilkan hari pertama dan terakhir dalam bulan tersebut.
- **Selisih Hari**: Menghitung perbedaan jumlah hari antara dua tanggal yang dipilih.

## Komponen GUI
Aplikasi ini menggunakan beberapa komponen antarmuka:
- **JFrame**: Sebagai jendela utama aplikasi.
- **JPanel**: Untuk menyusun elemen antarmuka.
- **JLabel**: Untuk teks petunjuk dan hasil perhitungan.
- **JComboBox**: Untuk memilih bulan.
- **JSpinner**: Untuk memasukkan tahun.
- **JButton**: Untuk memulai perhitungan.
- **JCalendar**: Untuk memilih bulan dan tahun secara visual.

## Logika Program
- **API Tanggal**:
  - Menggunakan `LocalDate` untuk menghitung jumlah hari dalam sebuah bulan dan menentukan tahun kabisat.
  - Menentukan hari pertama dan terakhir dalam bulan.
- **Perhitungan Hari**:
  - Jumlah hari dihitung berdasarkan bulan dan tahun yang dipilih.
  - Tahun kabisat diperhitungkan secara otomatis.
- **Selisih Hari**:
  - Hitung perbedaan jumlah hari antara dua tanggal menggunakan `ChronoUnit.DAYS.between()`.

## Events
- **ActionListener**: Digunakan pada tombol **Hitung** untuk memproses input dan menampilkan hasil perhitungan.
- **ChangeListener**: Digunakan pada `JSpinner` untuk memonitor perubahan input tahun.

## Variasi
- **Informasi Tambahan**: Menampilkan hari pertama dan terakhir dalam bulan yang dipilih.
- **Selisih Hari**: Fitur tambahan untuk menghitung perbedaan jumlah hari antara dua tanggal yang dipilih oleh pengguna.
- **Antarmuka Interaktif**: Menggunakan `JCalendar` untuk memilih bulan dan tahun secara langsung.

## Langkah-langkah Penggunaan
1. Pilih bulan dari `JComboBox` atau `JCalendar`.
2. Masukkan tahun menggunakan `JSpinner` atau pilih melalui `JCalendar`.
3. Klik tombol **Hitung** untuk menampilkan jumlah hari dalam bulan tersebut.
4. (Opsional) Pilih dua tanggal menggunakan `JCalendar` untuk menghitung selisih hari.
5. Hasil akan ditampilkan di layar, termasuk informasi tambahan seperti hari pertama dan terakhir dalam bulan tersebut.

## Pembuat
- **Nama**: Muhamad Arif Syamrodi
- **NPM**: 2210010316

## Teknologi yang Digunakan
- **Java Swing** untuk antarmuka pengguna (GUI).
- **JCalendar** untuk antarmuka pemilihan tanggal.
- **Java Time API** (`LocalDate`) untuk perhitungan tanggal dan tahun kabisat.

## Instalasi
1. Pastikan Java Development Kit (JDK) telah diinstal di komputer Anda.
2. Unduh atau clone repositori aplikasi:
   ```bash
   git clone https://github.com/username/repository.git
   ```
3. Kompilasi dan jalankan aplikasi:
   ```bash
   javac AplikasiPerhitunganHari.java
   java AplikasiPerhitunganHari
   ```

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](LICENSE).
```

**Penjelasan:**
- Penjelasan fitur utama diberikan di bagian "Deskripsi Program."
- Komponen GUI dijelaskan dengan detail untuk memberi gambaran elemen antarmuka.
- Variasi fitur, seperti perhitungan selisih hari dan informasi tambahan, dijelaskan untuk memperlihatkan fleksibilitas aplikasi.
- Langkah instalasi dan teknologi yang digunakan dirinci untuk memudahkan pengembang menjalankan dan memahami aplikasi.

Dokumen ini siap digunakan untuk dokumentasi aplikasi Anda.