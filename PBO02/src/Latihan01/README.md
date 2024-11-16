


# Aplikasi Pertambahan Dua Angka

Aplikasi ini memungkinkan pengguna untuk menjumlahkan dua angka yang dimasukkan melalui antarmuka grafis. Aplikasi ini dilengkapi dengan fitur validasi input, tombol untuk menambahkan, menghapus, dan keluar dari aplikasi. Selain itu, aplikasi ini juga memiliki beberapa fitur tambahan seperti pembatasan input hanya angka, dan pengelolaan fokus pada komponen input.

## Deskripsi Program
Aplikasi ini menyediakan tiga tombol utama dengan fungsi sebagai berikut:
- **Tambah**: Menjumlahkan dua angka yang dimasukkan oleh pengguna dan menampilkan hasilnya.
- **Hapus**: Menghapus nilai di kedua kolom input (TextField) dan memfokuskan kembali ke kolom input angka pertama.
- **Keluar**: Menutup aplikasi.

Fitur lainnya:
- **KeyAdapter** untuk membatasi input hanya angka pada TextField.
- **JOptionPane** digunakan untuk menampilkan pesan kesalahan jika input tidak valid.
- **FocusListener** untuk membersihkan TextField ketika mendapatkan fokus.

## Komponen GUI
Aplikasi ini menggunakan beberapa komponen GUI, antara lain:
- **JFrame**: Sebagai jendela utama aplikasi.
- **JPanel**: Sebagai wadah untuk komponen lainnya.
- **JLabel**: Untuk menampilkan teks label.
- **JTextField**: Untuk input angka oleh pengguna.
- **JButton**: Untuk tombol-tombol aksi (Tambah, Hapus, Keluar).

## Logika Program
- Penambahan dua angka dilakukan dengan mengonversi input dari pengguna menjadi tipe data numerik, kemudian menjumlahkannya dan menampilkan hasilnya.
- Validasi input dilakukan untuk memastikan pengguna hanya memasukkan angka. Jika input tidak valid, aplikasi akan menampilkan pesan kesalahan menggunakan `JOptionPane`.

## Events
- **ActionListener** untuk menangani event klik pada tombol **Tambah**, **Hapus**, dan **Keluar**.
- **KeyAdapter** untuk membatasi input pada JTextField hanya angka.
- **FocusListener** untuk membersihkan TextField saat mendapat fokus.

## Langkah-langkah Penggunaan
1. Masukkan dua angka pada kolom input pertama dan kedua.
2. Klik tombol **Tambah** untuk melihat hasil penjumlahan dari kedua angka.
3. Klik tombol **Hapus** untuk menghapus inputan dan mengatur fokus kembali ke TextField pertama.
4. Klik tombol **Keluar** untuk menutup aplikasi.

## Contoh Tampilan

```plaintext
+--------------------------------------+
|      Aplikasi Pertambahan Dua Angka  |
+--------------------------------------+
| Angka 1: [__________]                |
| Angka 2: [__________]                |
|                                      |
| [Tambah] [Hapus] [Keluar]            |
+--------------------------------------+
```

## Pembuat
- **Nama**: Muhamad Arif Syamrodi
- **NPM**: 2210010316

## Teknologi yang Digunakan
- Java Swing (JFrame, JPanel, JLabel, JTextField, JButton)
- Event Handling (ActionListener, KeyAdapter, FocusListener)
- Validasi Input menggunakan `JOptionPane`

## Instalasi
1. Pastikan Java Development Kit (JDK) telah terinstal di komputer Anda.
2. Clone repositori ini ke direktori lokal Anda:
   ```bash
   git clone https://github.com/username/repository.git
   ```
3. Kompilasi dan jalankan aplikasi:
   ```bash
   javac AplikasiPertambahanDuaAngka.java
   java AplikasiPertambahanDuaAngka
   ```

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](LICENSE).
```

Penjelasan:
- Bagian **Deskripsi Program** merangkum fungsionalitas utama aplikasi.
- Komponen-komponen GUI yang digunakan dicantumkan di bagian **Komponen GUI**.
- **Logika Program** dan **Events** menjelaskan alur dan penanganan event yang ada dalam aplikasi.
- Di bagian **Pembuat**, saya telah menambahkan nama dan NPM Anda.
- **Teknologi yang Digunakan** memberikan informasi mengenai pustaka dan metode yang dipakai.

