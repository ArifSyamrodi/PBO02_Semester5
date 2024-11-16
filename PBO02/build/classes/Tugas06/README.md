
# Aplikasi Cek Cuaca Sederhana

Aplikasi ini memungkinkan pengguna untuk memeriksa cuaca di berbagai lokasi menggunakan data real-time dari API eksternal (misalnya OpenWeatherMap). Aplikasi ini menampilkan kondisi cuaca dalam bentuk gambar berdasarkan status cuaca seperti cerah, berawan, atau hujan.

## Deskripsi Program
Fitur utama aplikasi ini meliputi:
- **Cek Cuaca Real-Time**: Mengambil data cuaca secara langsung dari API eksternal, seperti OpenWeatherMap.
- **Tampilan Cuaca**: Menampilkan gambar yang sesuai dengan kondisi cuaca (misalnya gambar cerah, berawan, hujan).
- **Pilih Lokasi**: Pengguna dapat memilih lokasi cuaca menggunakan `JComboBox`.
- **Lokasi Favorit**: Menyimpan lokasi yang sering dicek ke dalam daftar lokasi favorit untuk memudahkan pencarian berikutnya.
- **Simpan Data Cuaca**: Menyediakan tombol untuk menyimpan data cuaca ke dalam file CSV atau teks dan memuatnya kembali untuk ditampilkan di aplikasi.

## Komponen GUI
Aplikasi ini menggunakan beberapa komponen GUI untuk menyusun antarmuka:
- **JFrame**: Sebagai jendela utama aplikasi.
- **JPanel**: Untuk menyusun elemen-elemen antarmuka.
- **JLabel**: Untuk menampilkan hasil cuaca, gambar cuaca, dan informasi lainnya.
- **JTextField**: Untuk input nama kota atau lokasi.
- **JComboBox**: Untuk memilih lokasi cuaca dari daftar favorit.
- **JButton**: Untuk tombol **Cek Cuaca** dan menyimpan data.
  
## Logika Program
- **Integrasi API Eksternal**: Aplikasi mengakses API cuaca (seperti OpenWeatherMap) untuk mendapatkan data cuaca berdasarkan lokasi yang dipilih.
  - API mengembalikan data dalam format JSON yang kemudian diproses untuk menampilkan informasi cuaca.
  - Kondisi cuaca ditampilkan menggunakan gambar sesuai dengan status cuaca (cerah, berawan, hujan, dll).
- **Gambar Cuaca**: Berdasarkan data yang diterima dari API, gambar yang sesuai akan ditampilkan di antarmuka.
- **Lokasi Favorit**: Menyimpan kota atau lokasi yang sering dipilih dalam sebuah daftar yang dapat dipilih kembali dengan mudah melalui `JComboBox`.
- **Menyimpan dan Memuat Data Cuaca**: Data cuaca yang diterima dapat disimpan dalam file CSV atau teks, dan dapat dimuat kembali untuk ditampilkan di antarmuka.

## Events
- **ActionListener**:
  - Digunakan pada tombol **Cek Cuaca** untuk mengambil data cuaca dari API dan menampilkan informasi cuaca serta gambar.
- **ItemListener**:
  - Digunakan pada `JComboBox` untuk memilih lokasi dari daftar favorit dan menampilkan data cuaca untuk lokasi yang dipilih.

## Variasi
- **Daftar Lokasi Favorit**: Menyimpan kota atau lokasi yang sering dicek ke dalam daftar sehingga pengguna dapat memilihnya dengan cepat melalui `JComboBox`.
- **Menyimpan Data Cuaca**: Tambahkan tombol untuk menyimpan data cuaca ke dalam file CSV atau file teks, agar pengguna dapat mengaksesnya kembali di masa depan.
- **Memuat Data Cuaca yang Tersimpan**: Fitur untuk memuat dan menampilkan data cuaca yang sebelumnya disimpan ke dalam `JTable`.

## Langkah-langkah Penggunaan
1. Masukkan nama kota atau pilih kota dari daftar lokasi favorit menggunakan `JComboBox`.
2. Klik tombol **Cek Cuaca** untuk mengambil data cuaca dari API dan menampilkan kondisi cuaca serta gambarnya.
3. (Opsional) Simpan data cuaca ke dalam file CSV atau teks untuk akses berikutnya.
4. (Opsional) Pilih kota dari daftar lokasi favorit untuk melihat cuaca di lokasi tersebut.

## Pembuat
- **Nama**: Muhamad Arif Syamrodi
- **NPM**: 2210010316

## Teknologi yang Digunakan
- **Java Swing** untuk antarmuka pengguna (GUI).
- **OpenWeatherMap API** (atau API cuaca eksternal lainnya) untuk mendapatkan data cuaca secara real-time.
- **Java IO** untuk menyimpan dan memuat data cuaca ke/dari file CSV atau teks.
- **JSON Parsing** untuk memproses data cuaca yang diterima dari API.

## Instalasi
1. Pastikan Java Development Kit (JDK) telah diinstal di komputer Anda.
2. Unduh atau clone repositori aplikasi:
   ```bash
   git clone https://github.com/username/repository.git
   ```
3. Daftarkan dan dapatkan **API Key** dari OpenWeatherMap atau API cuaca lainnya (atau sesuaikan dengan API yang digunakan).
4. Masukkan API Key yang diperoleh ke dalam kode aplikasi.
5. Kompilasi dan jalankan aplikasi:
   ```bash
   javac AplikasiCekCuaca.java
   java AplikasiCekCuaca
   ```

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](LICENSE).
```

### Penjelasan:

- **Deskripsi Program** menjelaskan fitur-fitur aplikasi, termasuk integrasi API dan tampilan cuaca.
- **Komponen GUI** memberikan gambaran mengenai elemen antarmuka aplikasi.
- **Logika Program** merinci cara aplikasi mengambil data dari API cuaca dan menampilkan gambar serta informasi cuaca.
- **Variasi** memberikan tambahan fitur yang dapat meningkatkan fungsionalitas aplikasi, seperti daftar lokasi favorit dan kemampuan menyimpan data cuaca.
- **Instalasi** memberikan langkah-langkah untuk menjalankan aplikasi, termasuk cara mendapatkan dan menggunakan API cuaca.

Dokumen ini siap digunakan untuk mendokumentasikan aplikasi "Cek Cuaca Sederhana" yang telah Anda buat.