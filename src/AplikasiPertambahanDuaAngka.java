import javax.swing.*;
import java.awt.event.*;

public class AplikasiPertambahanDuaAngka extends javax.swing.JFrame {

    public  AplikasiPertambahanDuaAngka() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAngka1 = new javax.swing.JLabel();
        lblAngka2 = new javax.swing.JLabel();
        lblHasil = new javax.swing.JLabel();
        txtAngka1 = new javax.swing.JTextField();
        txtAngka2 = new javax.swing.JTextField();
        txtHasil = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Pertambahan Dua Angka");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(230, 240, 255));

        lblAngka1.setText("Angka Pertama:");
        lblAngka2.setText("Angka Kedua:");
        lblHasil.setText("Hasil:");

        txtHasil.setEditable(false);

        // === KeyAdapter: hanya angka dan titik ===
        txtAngka1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != '-') {
                    e.consume();
                }
            }
        });

        txtAngka2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != '-') {
                    e.consume();
                }
            }
        });

        // === FocusListener: bersihkan field saat fokus ===
        txtAngka1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                txtAngka1.setText("");
            }
        });

        txtAngka2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                txtAngka2.setText("");
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        // === Layout ===
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAngka1)
                    .addComponent(lblAngka2)
                    .addComponent(lblHasil))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAngka1)
                    .addComponent(txtAngka2)
                    .addComponent(txtHasil)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAngka1)
                    .addComponent(txtAngka1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAngka2)
                    .addComponent(txtAngka2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHasil)
                    .addComponent(txtHasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnHapus)
                    .addComponent(btnKeluar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        pack();
        setLocationRelativeTo(null);
    }

    // === EVENT HANDLER ===
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            double angka1 = Double.parseDouble(txtAngka1.getText());
            double angka2 = Double.parseDouble(txtAngka2.getText());
            double hasil = angka1 + angka2;
            txtHasil.setText(String.valueOf(hasil));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Input harus berupa angka!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        txtAngka1.setText("");
        txtAngka2.setText("");
        txtHasil.setText("");
        txtAngka1.requestFocus();
    }

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Yakin ingin keluar?", 
            "Konfirmasi", 
            JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // === MAIN METHOD ===
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new  AplikasiPertambahanDuaAngka().setVisible(true));
    }

    // === Deklarasi Komponen ===
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JLabel lblAngka1;
    private javax.swing.JLabel lblAngka2;
    private javax.swing.JLabel lblHasil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAngka1;
    private javax.swing.JTextField txtAngka2;
    private javax.swing.JTextField txtHasil;
}

