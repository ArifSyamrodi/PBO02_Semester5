
package Latihan03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AplikasiPengelolaKontak extends javax.swing.JFrame {
    
    private Connection conn;
    private DefaultTableModel model;
    
    public AplikasiPengelolaKontak() {
        initComponents();
        connectToDatabase();
        loadData();
    
    
     
        
    jTextFieldCariNamaTelpon.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    @Override
    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        cariKontak();
    }
    
    @Override
    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        cariKontak();
    }
    
    @Override
    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        cariKontak();
    }
});
    
    jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
    @Override
    public void valueChanged(javax.swing.event.ListSelectionEvent e) {
        // Mengecek apakah ada baris yang dipilih
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            // Jika ada row yang dipilih, aktifkan tombol
            jButtonEdit.setEnabled(true);
            jButtonHapus.setEnabled(true);
            jButtonSimpan.setEnabled(true);
        } else {
            // Jika tidak ada row yang dipilih, nonaktifkan tombol
            jButtonEdit.setEnabled(false);
            jButtonHapus.setEnabled(false);
            jButtonSimpan.setEnabled(false);
        }
    }
});
jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
    @Override
    public void valueChanged(javax.swing.event.ListSelectionEvent e) {
        int row = jTable1.getSelectedRow();  // Mendapatkan row yang dipilih
        if (row != -1) {
            // Jika ada row yang dipilih, ambil data dari tabel dan tampilkan di jTextField
            String nama = model.getValueAt(row, 0).toString();  // Nama berada di kolom 0
            String noTelp = model.getValueAt(row, 1).toString();  // Nomor Telepon berada di kolom 1
            String kategori = model.getValueAt(row, 2).toString();  // Kategori berada di kolom 2
            
            // Menampilkan data ke dalam text field dan combo box
            jTextFieldNamaKontak.setText(nama);
            jTextFieldNoTelpon.setText(noTelp);
            jComboBoxPilihKategori.setSelectedItem(kategori);  // Menyesuaikan kategori yang dipilih
        }
    }
});
jButtonEdit.setEnabled(false);
jButtonHapus.setEnabled(false);
jButtonSimpan.setEnabled(false);
    jComboBoxPilihKategori.addItem("Teman");
    jComboBoxPilihKategori.addItem("Keluarga");
    jComboBoxPilihKategori.addItem("Kerja");
    jComboBoxPilihKategori.addItem("Lainnya");
    }
    
    private void cariKontak() {
    String keyword = jTextFieldCariNamaTelpon.getText().trim();
    if (keyword.isEmpty()) {
        loadData(); // Jika kolom pencarian kosong, tampilkan semua data
    } else {
        try {
            // Mencari berdasarkan nama atau nomor telepon
            String query = "SELECT * FROM kontak WHERE nama LIKE ? OR noTelp LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            // Clear table terlebih dahulu sebelum memuat data baru
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("nama"), rs.getString("noTelp"), rs.getString("kategori")});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencari kontak: " + e.getMessage());
        }
    }
}
    
    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:kontak.db");
            System.out.println("Koneksi ke database berhasil");
            // Membuat tabel jika belum ada
            Statement stmt = conn.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS kontak (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nama TEXT, " +
                    "noTelp TEXT, " +
                    "kategori TEXT)";
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database: " + e.getMessage());
        }
    }
    
    private void loadData() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM kontak");

            // Set the table model
            model = new DefaultTableModel(new String[]{"Nama", "No Telp", "Kategori"}, 0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("nama"), rs.getString("noTelp"), rs.getString("kategori")});
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
        }
    }

    private void tambahKontak() {
        try {
            String nama = jTextFieldNamaKontak.getText();
            String noTelp = jTextFieldNoTelpon.getText();
            String kategori = jComboBoxPilihKategori.getSelectedItem().toString();

            String sql = "INSERT INTO kontak (nama, noTelp, kategori) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nama);
            pstmt.setString(2, noTelp);
            pstmt.setString(3, kategori);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Kontak berhasil ditambahkan!");
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menambah kontak: " + e.getMessage());
        }
    }
    
     private void editKontak() {
         try {
        String nama = jTextFieldNamaKontak.getText();
        String noTelp = jTextFieldNoTelpon.getText();
        String kategori = jComboBoxPilihKategori.getSelectedItem().toString();

        int row = jTable1.getSelectedRow(); // Ambil row yang dipilih
        if (row != -1) {
            String selectedNama = model.getValueAt(row, 0).toString();
            String selectedNoTelp = model.getValueAt(row, 1).toString();

            // Query untuk update kontak berdasarkan nama dan nomor telepon
            String sql = "UPDATE kontak SET nama = ?, noTelp = ?, kategori = ? WHERE nama = ? AND noTelp = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nama);
            pstmt.setString(2, noTelp);
            pstmt.setString(3, kategori);
            pstmt.setString(4, selectedNama);
            pstmt.setString(5, selectedNoTelp);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Kontak berhasil diubah!");
            
            // Mengosongkan form setelah data diubah
            jTextFieldNamaKontak.setText("");  // Menghapus text di jTextFieldNama
            jTextFieldNoTelpon.setText("");  // Menghapus text di jTextFieldNoTelp
            jComboBoxPilihKategori.setSelectedIndex(0);  // Mengembalikan combo box ke indeks pertama
            
            loadData();  // Muat ulang data
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal mengubah kontak: " + e.getMessage());
    }
    }
     
    private void hapusKontak() {
        try {
        int row = jTable1.getSelectedRow(); // Ambil row yang dipilih
        if (row != -1) {
            String nama = model.getValueAt(row, 0).toString(); // Ambil nama dari tabel
            String noTelp = model.getValueAt(row, 1).toString(); // Ambil nomor telepon dari tabel

            // Query untuk menghapus kontak berdasarkan nama dan nomor telepon
            String sql = "DELETE FROM kontak WHERE nama = ? AND noTelp = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nama);
            pstmt.setString(2, noTelp);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Kontak berhasil dihapus!");
            
            // Mengosongkan form setelah data dihapus
            jTextFieldNamaKontak.setText("");  // Menghapus text di jTextFieldNama
            jTextFieldNoTelpon.setText("");  // Menghapus text di jTextFieldNoTelp
            jComboBoxPilihKategori.setSelectedIndex(0);  // Mengembalikan combo box ke indeks pertama
            
            loadData();  // Muat ulang data
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menghapus kontak: " + e.getMessage());
    }
    }
    
     private void simpanData() {
        loadData(); // Refresh data after any changes
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNamaKontak = new javax.swing.JTextField();
        jTextFieldNoTelpon = new javax.swing.JTextField();
        jComboBoxPilihKategori = new javax.swing.JComboBox<>();
        jButtonTambah = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jButtonSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCariNamaTelpon = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Eras Medium ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aplikasi Pengelola Kontak");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 50));

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setForeground(new java.awt.Color(0, 204, 153));

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama                 :");

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nomor Telepon :");

        jLabel4.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pilih Kategori  :");

        jTextFieldNoTelpon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNoTelponKeyTyped(evt);
            }
        });

        jButtonTambah.setText("Tambah");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTambah))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldNamaKontak)
                        .addComponent(jTextFieldNoTelpon)
                        .addComponent(jComboBoxPilihKategori, 0, 290, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNamaKontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNoTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxPilihKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonHapus)
                    .addComponent(jButtonTambah)
                    .addComponent(jButtonSimpan))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTable1.setBorder(null);
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

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cari Berdasarkan Nama atau Nomor Telp :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCariNamaTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCariNamaTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 490, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahActionPerformed
         tambahKontak();
    }//GEN-LAST:event_jButtonTambahActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
         editKontak();
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        hapusKontak();
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        simpanData();
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void jTextFieldNoTelponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNoTelponKeyTyped
        char c = evt.getKeyChar(); // Mendapatkan karakter yang diketikkan

    // Mengecek apakah karakter yang dimasukkan bukan angka
    if (!Character.isDigit(c)) {
        // Jika bukan angka, batalkan aksi (tidak memasukkan karakter)
        evt.consume();
        JOptionPane.showMessageDialog(null, "Hanya angka yang diperbolehkan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jTextFieldNoTelponKeyTyped

    
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
            java.util.logging.Logger.getLogger(AplikasiPengelolaKontak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiPengelolaKontak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiPengelolaKontak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiPengelolaKontak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiPengelolaKontak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JComboBox<String> jComboBoxPilihKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCariNamaTelpon;
    private javax.swing.JTextField jTextFieldNamaKontak;
    private javax.swing.JTextField jTextFieldNoTelpon;
    // End of variables declaration//GEN-END:variables
}
