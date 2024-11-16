
package Tugas04;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Calendar;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class PerhitunganHariApp extends javax.swing.JFrame {

    private boolean isUpdating = false;
    public PerhitunganHariApp() {
        initComponents();
         setUpComboBox();
         
         addListeners();
    }

   private void setUpComboBox() {
        // Mengisi jComboBoxBulan dengan nama-nama bulan
        jComboBoxBulan.setModel(new DefaultComboBoxModel<>(new String[]{
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        }));
    }
   private void addListeners() {
         // Listener untuk perubahan bulan
    jComboBoxBulan.addActionListener(e -> {
        if (!isUpdating) {
            isUpdating = true;
            updateCalendarFromComboBoxSpinner();
            isUpdating = false;
        }
    });

    // Listener untuk perubahan tahun
    jSpinnerTahun.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (!isUpdating) {
                isUpdating = true;
                updateCalendarFromComboBoxSpinner();
                isUpdating = false;
            }
        }
    });

    // Listener untuk perubahan tanggal di jCalendar
    jCalendar1.addPropertyChangeListener("calendar", new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (!isUpdating) {
                isUpdating = true;
                updateComboBoxSpinnerFromCalendar();
                isUpdating = false;
            }
        }
    });
    }
   private void updateCalendarFromComboBoxSpinner() {
        if (!isUpdating) {
        int bulan = jComboBoxBulan.getSelectedIndex(); 
        int tahun = (int) jSpinnerTahun.getValue();
        
        Calendar calendar = jCalendar1.getCalendar();
        calendar.set(Calendar.YEAR, tahun);
        calendar.set(Calendar.MONTH, bulan);
        calendar.set(Calendar.DAY_OF_MONTH, 1); 
        jCalendar1.setCalendar(calendar);
    }
    }
   
   private void updateComboBoxSpinnerFromCalendar() {
        if (!isUpdating) {
        Calendar calendar = jCalendar1.getCalendar();
        int tahun = calendar.get(Calendar.YEAR);
        int bulan = calendar.get(Calendar.MONTH); 

        jSpinnerTahun.setValue(tahun);
        jComboBoxBulan.setSelectedIndex(bulan);
    }
    }
   
   
   
    
    private void updateCalendar() {
        
        int bulan = jComboBoxBulan.getSelectedIndex(); 
        int tahun = (int) jSpinnerTahun.getValue();

        
        Calendar calendar = jCalendar1.getCalendar();
        calendar.set(Calendar.YEAR, tahun);
        calendar.set(Calendar.MONTH, bulan);
        calendar.set(Calendar.DAY_OF_MONTH, 1); 
        jCalendar1.setCalendar(calendar);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxBulan = new javax.swing.JComboBox<>();
        jSpinnerTahun = new javax.swing.JSpinner();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jButtonHitung = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonBersih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Program Hitung Hari");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Program Penghitung Hari");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pilih Bulan & Tahun :");

        jComboBoxBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonHitung.setText("Hitung");
        jButtonHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHitungActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonBersih.setText("Reset");
        jButtonBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBersihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButtonHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonHitung)
                            .addComponent(jButtonBersih)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHitungActionPerformed
       
int tahun = (int) jSpinnerTahun.getValue();
int bulan = jComboBoxBulan.getSelectedIndex() + 1; 

// Menghitung jumlah hari dalam bulan yang dipilih
YearMonth yearMonth = YearMonth.of(tahun, bulan);
int jumlahHari = yearMonth.lengthOfMonth();

// Mendapatkan tanggal pertama dan terakhir dalam bulan tersebut
LocalDate tanggalPertama = LocalDate.of(tahun, bulan, 1);
LocalDate tanggalTerakhir = LocalDate.of(tahun, bulan, jumlahHari);

// Menentukan apakah tahun tersebut adalah tahun kabisat
boolean tahunKabisat = Year.isLeap(tahun);

// Menampilkan hasil pada jTextArea1
jTextArea1.setText("Jumlah hari di bulan " + jComboBoxBulan.getSelectedItem() + " " + tahun + ": " + jumlahHari + "\n");
jTextArea1.append("Hari awal: " +(tanggalPertama.getDayOfWeek()) + "\n");
jTextArea1.append("Hari akhir: " + (tanggalTerakhir.getDayOfWeek()) + "\n");

// Menampilkan informasi apakah tahun tersebut adalah kabisat atau bukan
jTextArea1.append("Tahun Ke " + tahun + (tahunKabisat ? " adalah tahun kabisat.\n" : " bukan tahun kabisat.\n"));

// Menghitung selisih hari antara tanggal pertama di jCalendar1 dan tanggal terakhir di bulan yang dipilih
LocalDate selectedDate = LocalDate.of(
        jCalendar1.getYearChooser().getYear(),
        jCalendar1.getMonthChooser().getMonth() + 1,
        jCalendar1.getDayChooser().getDay()
);

long selisihHari = ChronoUnit.DAYS.between(selectedDate, tanggalTerakhir);
jTextArea1.append("Selisih hari : " + Math.abs(selisihHari) + " hari\n");

    }//GEN-LAST:event_jButtonHitungActionPerformed

    private void jButtonBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBersihActionPerformed
       jTextArea1.setText("");
    }//GEN-LAST:event_jButtonBersihActionPerformed

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
            java.util.logging.Logger.getLogger(PerhitunganHariApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerhitunganHariApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBersih;
    private javax.swing.JButton jButtonHitung;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBoxBulan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerTahun;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
