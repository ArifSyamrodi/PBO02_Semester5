
# Aplikasi Perhitungan Diskon

Aplikasi ini membantu pengguna menghitung harga akhir produk setelah diskon. Pengguna dapat memasukkan harga asli, memilih persentase diskon, dan melihat harga akhir serta jumlah penghematan. Aplikasi ini dirancang menggunakan antarmuka berbasis Java Swing.

## Deskripsi Program
Fitur utama aplikasi ini meliputi:
- **Input Harga Asli**: Pengguna dapat memasukkan harga produk dalam kolom input.
- **Pilih Diskon**: Pengguna dapat memilih persentase diskon menggunakan `JComboBox` atau `JSlider`.
- **Hasil Perhitungan**: Aplikasi menghitung dan menampilkan harga akhir setelah diskon serta jumlah penghematan.
- **Kode Kupon Diskon Tambahan**: Pengguna dapat menambahkan kupon diskon tambahan untuk penghematan lebih besar.
- **Riwayat Perhitungan**: Menampilkan daftar hasil perhitungan diskon sebelumnya.

## Komponen GUI
Aplikasi ini menggunakan beberapa komponen GUI:
- **JFrame**: Jendela utama aplikasi.
- **JPanel**: Untuk menyusun elemen antarmuka.
- **JLabel**: Label teks untuk petunjuk dan hasil perhitungan.
- **JTextField**: Untuk input harga asli dan kode kupon (opsional).
- **JComboBox**: Untuk memilih persentase diskon.
- **JSlider**: Sebagai alternatif untuk memilih persentase diskon.
- **JButton**: Tombol **Hitung** untuk memulai perhitungan.

## Logika Program
- **Perhitungan Aritmatika**:
  - **Harga Akhir**: \( \text{Harga Akhir} = \text{Harga Asli} \times (1 - \frac{\text{Diskon}}{100}) \)
  - **Penghematan**: \( \text{Penghematan} = \text{Harga Asli} - \text{Harga Akhir} \)
- **Penanganan Eksepsi**: Memastikan input harga valid dan menangani kesalahan seperti input kosong atau tidak numerik.

## Events
- **ActionListener** pada tombol **Hitung** untuk memicu perhitungan diskon.
- **ItemListener** pada `JComboBox` untuk menangani perubahan persentase diskon.
- **ChangeListener** pada `JSlider` (opsional) untuk memperbarui nilai persentase diskon secara real-time.

## Variasi
- **Kode Kupon Diskon Tambahan**: Masukkan kode kupon untuk diskon tambahan, yang akan dihitung bersama diskon utama.
- **JSlider untuk Persentase Diskon**: Sebagai alternatif `JComboBox`, pengguna dapat menggunakan slider untuk memilih persentase diskon.
- **Riwayat Perhitungan Diskon**: Menyimpan dan menampilkan hasil perhitungan diskon sebelumnya.

## Langkah-langkah Penggunaan
1. Masukkan harga asli produk dalam kolom input.
2. Pilih persentase diskon menggunakan `JComboBox` atau `JSlider`.
3. (Opsional) Masukkan kode kupon diskon tambahan.
4. Klik tombol **Hitung** untuk melihat harga akhir dan jumlah penghematan.
5. Hasil perhitungan akan ditampilkan di layar, dan riwayat perhitungan akan diperbarui.

## Pembuat
- **Nama**: Muhamad Arif Syamrodi
- **NPM**: 2210010316

## Teknologi yang Digunakan
- **Java Swing** untuk antarmuka pengguna (GUI).
- **AWT Events** untuk menangani interaksi pengguna.
- **Java Math** untuk logika perhitungan diskon.

## Instalasi
1. Pastikan Java Development Kit (JDK) telah diinstal di komputer Anda.
2. Unduh atau clone repositori aplikasi:
   ```bash
   git clone https://github.com/username/repository.git
   ```
3. Kompilasi dan jalankan aplikasi:
   ```bash
   javac AplikasiPerhitunganDiskon.java
   java AplikasiPerhitunganDiskon
   ```

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](LICENSE).
```

**Penjelasan:**
- Fitur utama dijelaskan di bagian "Deskripsi Program."
- Komponen GUI dan logika program dirinci agar pengembang memahami struktur aplikasi.
- Variasi tambahan seperti kupon diskon, `JSlider`, dan riwayat perhitungan disoroti sebagai nilai tambah.
- Bagian "Instalasi" memberikan langkah untuk menjalankan aplikasi.

Dokumen ini siap digunakan untuk mendokumentasikan aplikasi Anda.