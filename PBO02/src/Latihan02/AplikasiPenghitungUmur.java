/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Latihan02;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ASUS
 */
public class AplikasiPenghitungUmur extends javax.swing.JFrame {

    private ExecutorService executorService;
    private volatile boolean stopFetching;
    public AplikasiPenghitungUmur() {
        initComponents();
        executorService = Executors.newSingleThreadExecutor();
    }
    
    private String translateToIndonesian(String text) {

        try {

            String urlString = "https://lingva.ml/api/v1/en/id/" + text.replace(" ", "%20");

            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("User -Agent", "Mozilla/5.0");


            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {

                throw new Exception("HTTP response code: " + responseCode);

            }


            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

            String inputLine;

            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {

                content.append(inputLine);

            }

            in.close();

            conn.disconnect();


            JSONObject json = new JSONObject(content.toString());

            return json.getString("translation");

        } catch (Exception e) {

            return text + " (Gagal diterjemahkan)";

        }

    }
    
    private void getPeristiwaBarisPerBaris(LocalDate tanggal) {
     stopFetching = false;


        executorService.submit(() -> {

            try {

                jTextArea1.setText("Tunggu, sedang mengambil data...\n");

                String urlString = "https://byabbe.se/on-this-day/" + tanggal.getMonthValue() + "/" + tanggal.getDayOfMonth() + "/events.json";

                URL url = new URL(urlString);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("GET");

                conn.setRequestProperty("User -Agent", "Mozilla/5.0");


                int responseCode = conn.getResponseCode();

                if (responseCode != 200) {

                    throw new Exception("HTTP response code: " + responseCode);

                }


                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder content = new StringBuilder();

                String inputLine;


                while ((inputLine = in.readLine()) != null) {

                    if (stopFetching) {

                        in.close();

                        conn.disconnect();

                        return;

                    }

                    content.append(inputLine);

                }

                in.close();

                conn.disconnect();


                JSONObject json = new JSONObject(content.toString());

                JSONArray events = json.getJSONArray("events");


                if (events.length() == 0) {

                    SwingUtilities.invokeLater(() -> jTextArea1.setText("Tidak ada peristiwa penting yang ditemukan pada tanggal ini."));

                } else {

                    for (int i = 0; i < events.length(); i++) {

                        if (stopFetching) return;

                        JSONObject event = events.getJSONObject(i);

                        String year = event.getString("year");

                        String description = event.getString("description");

                        String translatedDescription = translateToIndonesian(description); // Panggil fungsi penerjemah

                        String peristiwa = year + ": " + translatedDescription;


                        SwingUtilities.invokeLater(() -> jTextArea1.append(peristiwa + "\n"));

                    }

                }


            } catch (Exception e) {

                SwingUtilities.invokeLater(() -> jTextArea1.setText("Gagal mendapatkan data peristiwa: " + e.getMessage()));

            }

        });
}
    
    private void hitungUmur() {
        // Pastikan tanggal lahir sudah dipilih
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Pilih tanggal lahir terlebih dahulu!");
            return;
        }
        
         LocalDate tanggalLahir = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate tanggalHariIni = LocalDate.now();

        // Menghitung umur dalam tahun, bulan, dan hari
        Period periode = Period.between(tanggalLahir, tanggalHariIni);
        int tahun = periode.getYears();
        int bulan = periode.getMonths();
        int hari = periode.getDays();
        
        
        LocalDate ulangTahunBerikutnya = tanggalLahir.withYear(tanggalHariIni.getYear());
        if (ulangTahunBerikutnya.isBefore(tanggalHariIni) || ulangTahunBerikutnya.equals(tanggalHariIni)) {
        ulangTahunBerikutnya = ulangTahunBerikutnya.plusYears(1);
    }
        Period selisihWaktu = Period.between(tanggalHariIni, ulangTahunBerikutnya);
        int bulanUlangTahun = selisihWaktu.getMonths();
        int hariUlangTahun = selisihWaktu.getDays();
        
        // Menampilkan umur pada jTextField1
        jTextField1.setText(tahun + " tahun, " + bulan + " bulan, " + hari + " hari");
        jTextFieldUlangTahunBerikutnya.setText(bulanUlangTahun + " bulan, " + hariUlangTahun + " hari lagi");
        getPeristiwaBarisPerBaris(ulangTahunBerikutnya);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButtonHitung = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextFieldUlangTahunBerikutnya = new javax.swing.JTextField();
        jButtonTutup = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Aplikasi Penghitung Umur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Malgun Gothic", 0, 14))); // NOI18N

        jLabel1.setText("Pilih Tanggal Lahir");

        jLabel2.setText("Umur Anda");

        jLabel3.setText("Hari Ulang Tahun Berikutnya");

        jButtonHitung.setText("Hitung");
        jButtonHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHitungActionPerformed(evt);
            }
        });

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jTextFieldUlangTahunBerikutnya.setEditable(false);

        jButtonTutup.setText("Tutup");
        jButtonTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jButtonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldUlangTahunBerikutnya)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1))))
                .addGap(134, 134, 134))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(jTextFieldUlangTahunBerikutnya, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonHitung)
                    .addComponent(jButtonHapus)
                    .addComponent(jButtonTutup))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel4.setText("APLIKASI PENGHITUNG UMUR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHitungActionPerformed
        hitungUmur();
    }//GEN-LAST:event_jButtonHitungActionPerformed

    private void jButtonTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTutupActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonTutupActionPerformed

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        jTextField1.setText("");
       jDateChooser1.setDate(null);
       jTextFieldUlangTahunBerikutnya.setText("");
       jTextArea1.setText("");
       stopFetching = true;
    }//GEN-LAST:event_jButtonHapusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(AplikasiPenghitungUmur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitungUmur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitungUmur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitungUmur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiPenghitungUmur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonHitung;
    private javax.swing.JButton jButtonTutup;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldUlangTahunBerikutnya;
    // End of variables declaration//GEN-END:variables
}
