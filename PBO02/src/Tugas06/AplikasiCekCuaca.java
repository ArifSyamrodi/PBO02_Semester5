
package Tugas06;
// Nama : Muhamad Arif Syamrodi
// Npm  : 2210010316
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import javax.swing.JFileChooser;

public class AplikasiCekCuaca extends javax.swing.JFrame {

    private final String API_KEY = "abec15796646d777be75b12ae8e485db"; //Apikey Dari OpenWeatheMap
    
    public AplikasiCekCuaca() {
        initComponents();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(

    new Object [][] {},

    new String [] {

        "Kota", "Suhu (°C)", "Cuaca", "Deskripsi"

    }

));
        
         jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
        "Pilih Kota Favorit", "Jakarta", "Bogor", "Medan", "Jepara"
    }));
         jComboBox1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
        }
    });
    }
   private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedCity = (String) jComboBox1.getSelectedItem();
        if (!selectedCity.equals("Pilih Kota Favorit")) {
            jTextFieldKota.setText(selectedCity);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldKota = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButtonCek = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabelIconCuaca = new javax.swing.JLabel();
        jButtonSaveCSV = new javax.swing.JButton();
        jButtonFavorit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Cek Cuaca");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 51, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cek Cuaca ");
        jPanel3.add(jLabel1);

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cek Cuaca di Kota   :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cek di Kota Favorit :");

        jButtonCek.setText("Cek");
        jButtonCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCekActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabelIconCuaca.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIconCuaca.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabelIconCuaca.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIconCuaca.setText("Cuaca di Kota :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelIconCuaca)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabelIconCuaca)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jButtonSaveCSV.setText("Save to CSV");
        jButtonSaveCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCSVActionPerformed(evt);
            }
        });

        jButtonFavorit.setText("Tambah Ke Favorit");
        jButtonFavorit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFavoritActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldKota)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButtonCek, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSaveCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonFavorit, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCek)
                    .addComponent(Reset)
                    .addComponent(jButtonSaveCSV)
                    .addComponent(jButtonFavorit))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCekActionPerformed
    String cityName = jTextFieldKota.getText().trim(); // Ambil dari JTextField

    if (cityName.isEmpty() && !jComboBox1.getSelectedItem().equals("Pilih Kota Favorit")) {
        // Jika JTextField kosong, gunakan pilihan dari JComboBox
        cityName = (String) jComboBox1.getSelectedItem();
    }

    if (!cityName.isEmpty()) {
        // Ambil data cuaca
        WeatherData weatherData = getWeatherData(cityName);

        if (weatherData != null) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{weatherData.city, weatherData.temperature, weatherData.weather, weatherData.description});
        }
    } else {
        JOptionPane.showMessageDialog(this, "Silakan masukkan kota atau pilih kota favorit");
    }
    }//GEN-LAST:event_jButtonCekActionPerformed

    
    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
    jTextFieldKota.setText("");
    
    // Set jComboBox1 kembali ke pilihan default
    jComboBox1.setSelectedIndex(0);
    
    // Kosongkan hasil cuaca di jLabelIconKota
    jLabelIconCuaca.setText("Cuaca di Kota :");

    // Kosongkan ikon cuaca jika ada
    jLabelIconCuaca.setIcon(null); 
    }//GEN-LAST:event_ResetActionPerformed

    private void jButtonSaveCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCSVActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Pilih Lokasi dan Nama File untuk Menyimpan");
    
    // Set filter file ke .csv saja
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV files", "csv"));
    
    int userSelection = fileChooser.showSaveDialog(this);
    
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        try {
            // Mendapatkan file yang dipilih user
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            
            // Tambahkan ekstensi .csv jika belum ada
            if (!filePath.endsWith(".csv")) {
                filePath += ".csv";
            }
            
            // Buat FileWriter untuk file yang dipilih
            FileWriter csvWriter = new FileWriter(filePath);
            
            // Tulis header CSV
            csvWriter.append("Kota,Suhu (°C),Cuaca,Deskripsi\n");

            // Ambil data dari tabel dan simpan ke CSV
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    csvWriter.append(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) {
                        csvWriter.append(",");
                    }
                }
                csvWriter.append("\n");
            }

            // Tutup FileWriter
            csvWriter.flush();
            csvWriter.close();

            JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data ke CSV.");
        }
    }
    }//GEN-LAST:event_jButtonSaveCSVActionPerformed

    private void jButtonFavoritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFavoritActionPerformed
// Ambil teks dari jTextFieldKota
    String kota = jTextFieldKota.getText().trim();

    // Periksa apakah kota tidak kosong
    if (!kota.isEmpty()) {
        // Periksa apakah kota sudah ada di dalam jComboBox1
        boolean kotaSudahAda = false;
        for (int i = 0; i < jComboBox1.getItemCount(); i++) {
            if (jComboBox1.getItemAt(i).equalsIgnoreCase(kota)) {
                kotaSudahAda = true;
                break;
            }
        }

        // Jika kota belum ada, tambahkan ke dalam jComboBox1
        if (!kotaSudahAda) {
            jComboBox1.addItem(kota);
            JOptionPane.showMessageDialog(this, "Kota " + kota + " berhasil ditambahkan ke favorit.");
        } else {
            JOptionPane.showMessageDialog(this, "Kota " + kota + " sudah ada di daftar favorit.");
        }
    } else {
        // Jika jTextFieldKota kosong
        JOptionPane.showMessageDialog(this, "Silakan masukkan nama kota terlebih dahulu.");
    }       
    }//GEN-LAST:event_jButtonFavoritActionPerformed

    private WeatherData getWeatherData(String kota) {
        try {
        
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + kota + "&appid=" + API_KEY + "&units=metric&lang=id";

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();

       
        JSONObject jsonResponse = new JSONObject(content.toString());
        double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
        String description = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");
        String iconCode = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("icon");

        
        jLabelIconCuaca.setText("Kota: " + kota + ", Suhu: " + temperature + "°C, Cuaca: " + description);

        // Tampilkan ikon cuaca
        updateWeatherIcon(iconCode);

        return new WeatherData(kota, temperature, description);

    } catch (Exception e) {
        e.printStackTrace();
        jLabelIconCuaca.setText("Gagal mengambil data cuaca. Pastikan koneksi internet dan API Key benar.");
        return null; 
    }
    }
    
    private void updateWeatherIcon(String iconCode) {
         try {

       

        String iconUrl = "http://openweathermap.org/img/wn/" + iconCode + "@2x.png";

        URL url = new URL(iconUrl);


        

        ImageIcon originalIcon = new ImageIcon(ImageIO.read(url));


      

        int maxWidth = 30; 

        int maxHeight = 30;


        

        Image img = originalIcon.getImage();

        Image scaledImg = img.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);

        jLabelIconCuaca.setIcon(new ImageIcon(scaledImg)); // Set ikon cuaca

    } catch (Exception e) {

        e.printStackTrace();

        jLabelIconCuaca.setText("Gagal memuat ikon cuaca.");

    }
    }
    class WeatherData {

    String city;

    double temperature;

    String weather;

    String description;


    WeatherData(String city, double temperature, String description) {

        this.city = city;

        this.temperature = temperature;

        this.weather = "Cuaca"; 

        this.description = description;

    }

}
    
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiCekCuaca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reset;
    private javax.swing.JButton jButtonCek;
    private javax.swing.JButton jButtonFavorit;
    private javax.swing.JButton jButtonSaveCSV;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelIconCuaca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldKota;
    // End of variables declaration//GEN-END:variables
}
