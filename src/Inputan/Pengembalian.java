
package Inputan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.MessageFormat;

public class Pengembalian extends JFrame {

    private JLabel labelKembalian, labelBayarpelanggan, totalbayarLabel, notransaksilabel, adminLabel, tglPeminjamanLabel, idPelangganLabel, nikLabel, namaPelangganLabel,
            nomorTeleponLabel, alamatLabel, idPlaystationLabel, playstationLabel, totaldendalabel, keterlambatanlabel, dendalabel,
            totalHargaLabel, tglPengembalianLabel;

    private JTextField kembalianField, BayarFieldPelanggan, totalbayarField, noTransaksifield, tglPeminjamanField, idPelangganField, nikField, namaPelangganField,
            nomorTeleponField, idPlaystationField, playstationField, totaldendaField, keterlambatanField, dendaField,
            totalHargaField, tglPengembalianField, cariField;

    private JButton bayarButton, showdata, hitungButton, searchButton, saveButton, cetakButton, hapusButton, batalButton, generate, clenderButton1, clenderButton2;
    private JTable table;
    private JScrollPane scrollPane;
    private JTextArea addressArea;
    DefaultTableModel model;

    String adminName;

    public Pengembalian() {

    }

    public Pengembalian(String adminName) {
        this.adminName = adminName;

        setTitle("Pengembalian");
        setLayout(null);
        setSize(1500, 900);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216, 230));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("PENGEMBALIAN");
        add(label);
        label.setBounds(750, 10, 250, 30);
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        notransaksilabel = new JLabel("No.Transaksi");
        notransaksilabel.setBounds(650, 63, 200, 30);
        notransaksilabel.setFont(new Font("Segoe UI", 0, 17));
        add(notransaksilabel);
        noTransaksifield = new JTextField();
        noTransaksifield.setBounds(770, 63, 150, 30);
//        noTransaksifield.setEditable(false);
        add(noTransaksifield);
        generate = new JButton("Ganarate");
        generate.setBounds(940, 63, 120, 30);
        generate.setPreferredSize(new Dimension(120, 30));
        generate.setFont(new Font("Segoe UI", 0, 17));
        generate.setContentAreaFilled(false);
        generate.setForeground(new Color(0, 80, 239));
        generate.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 239), 1, true));
        add(generate);

        tglPeminjamanLabel = new JLabel("Tggl.Pinjam");
        tglPeminjamanLabel.setBounds(650, 100, 200, 30);
        tglPeminjamanLabel.setFont(new Font("Segoe UI", 0, 17));
        add(tglPeminjamanLabel);
        tglPeminjamanField = new JTextField();
        tglPeminjamanField.setBounds(770, 100, 150, 30);
        tglPeminjamanField.setEnabled(false);
        add(tglPeminjamanField);

        tglPengembalianLabel = new JLabel("Tggl.Kembali");
        tglPengembalianLabel.setBounds(650, 137, 200, 30);
        tglPengembalianLabel.setFont(new Font("Segoe UI", 0, 17));
        add(tglPengembalianLabel);
        tglPengembalianField = new JTextField();
        tglPengembalianField.setBounds(770, 137, 150, 30);
        tglPengembalianField.setEnabled(false);
        add(tglPengembalianField);

        idPlaystationLabel = new JLabel("ID Playstation");
        idPlaystationLabel.setBounds(650, 200, 200, 30);
        idPlaystationLabel.setFont(new Font("Segoe UI", 0, 17));
        add(idPlaystationLabel);
        idPlaystationField = new JTextField();
        idPlaystationField.setBounds(800, 200, 150, 30);
        add(idPlaystationField);

        playstationLabel = new JLabel("Jenis Playstation");
        playstationLabel.setBounds(650, 240, 200, 30);
        playstationLabel.setFont(new Font("Segoe UI", 0, 17));
        add(playstationLabel);
        playstationField = new JTextField();
        playstationField.setBounds(800, 240, 150, 30);
        add(playstationField);

        totalHargaLabel = new JLabel("Total Harga Rp.");
        totalHargaLabel.setBounds(650, 280, 200, 30);
        totalHargaLabel.setFont(new Font("Segoe UI", 0, 17));
        add(totalHargaLabel);
        totalHargaField = new JTextField();
        totalHargaField.setBounds(800, 280, 150, 30);
        add(totalHargaField);

        keterlambatanlabel = new JLabel("Keterlamabatan");
        keterlambatanlabel.setBounds(650, 320, 290, 30);
        keterlambatanlabel.setFont(new Font("Segoe UI", 0, 17));
        add(keterlambatanlabel);
        keterlambatanField = new JTextField();
        keterlambatanField.setBounds(800, 320, 150, 30);
        add(keterlambatanField);

        dendalabel = new JLabel("Denda");
        dendalabel.setBounds(650, 360, 200, 30);
        dendalabel.setFont(new Font("Segoe UI", 0, 17));
        add(dendalabel);
        dendaField = new JTextField();
        dendaField.setBounds(800, 360, 150, 30);
        add(dendaField);

        totaldendalabel = new JLabel("Total Denda Rp.");
        totaldendalabel.setBounds(650, 400, 200, 30);
        totaldendalabel.setFont(new Font("Segoe UI", 0, 17));
        add(totaldendalabel);
        totaldendaField = new JTextField();
        totaldendaField.setBounds(800, 400, 150, 30);
        totaldendaField.setEnabled(false);
        add(totaldendaField);
        hitungButton = new JButton("Hitung Denda");
        hitungButton.setBounds(960, 400, 130, 30);
        add(hitungButton);

        totalbayarLabel = new JLabel("Total Bayar Rp.");
        totalbayarLabel.setBounds(650, 440, 200, 30);
        totalbayarLabel.setFont(new Font("Segoe UI", 0, 17));
        add(totalbayarLabel);
        totalbayarField = new JTextField();
        totalbayarField.setBounds(800, 440, 150, 30);
        totalbayarField.setEnabled(false);
        add(totalbayarField);
        bayarButton = new JButton("Bayar");
        bayarButton.setBounds(960, 440, 100, 30);
        add(bayarButton);

        adminLabel = new JLabel("Admin   : " + adminName);
        adminLabel.setBounds(40, 100, 200, 30);
        adminLabel.setFont(new Font("Segoe UI", 0, 17));
        add(adminLabel);

        nikLabel = new JLabel("NIK");
        nikLabel.setBounds(40, 200, 200, 30);
        nikLabel.setFont(new Font("Segoe UI", 0, 17));
        add(nikLabel);
        nikField = new JTextField();
        nikField.setBounds(180, 200, 150, 30);
        add(nikField);

        idPelangganLabel = new JLabel("ID Pelanggan");
        idPelangganLabel.setBounds(40, 240, 200, 30);
        idPelangganLabel.setFont(new Font("Segoe UI", 0, 17));
        add(idPelangganLabel);
        idPelangganField = new JTextField();
        idPelangganField.setBounds(180, 240, 150, 30);
        add(idPelangganField);

        namaPelangganLabel = new JLabel("Nama Pelanggan");
        namaPelangganLabel.setBounds(40, 280, 200, 30);
        namaPelangganLabel.setFont(new Font("Segoe UI", 0, 17));
        add(namaPelangganLabel);
        namaPelangganField = new JTextField();
        namaPelangganField.setBounds(180, 280, 150, 30);
        add(namaPelangganField);

        nomorTeleponLabel = new JLabel("Nomor Telepon");
        nomorTeleponLabel.setBounds(40, 320, 200, 30);
        nomorTeleponLabel.setFont(new Font("Segoe UI", 0, 17));
        add(nomorTeleponLabel);
        nomorTeleponField = new JTextField();
        nomorTeleponField.setBounds(180, 320, 150, 30);
        add(nomorTeleponField);

        alamatLabel = new JLabel("Alamat");
        alamatLabel.setBounds(40, 360, 200, 27);
        alamatLabel.setFont(new Font("Segoe UI", 0, 17));
        add(alamatLabel);
        addressArea = new JTextArea();
        addressArea.setBounds(180, 360, 250, 70); // Atur ukuran sesuai kebutuhan
        scrollPane = new JScrollPane(addressArea);
        scrollPane.setBounds(180, 360, 250, 70);
        add(scrollPane);

        labelBayarpelanggan = new JLabel("Bayar");
        labelBayarpelanggan.setBounds(40, 440, 200, 30);
        labelBayarpelanggan.setFont(new Font("Segoe UI", 0, 17));
        add(labelBayarpelanggan);
        BayarFieldPelanggan = new JTextField();
        BayarFieldPelanggan.setBounds(180, 440, 150, 30);
        add(BayarFieldPelanggan);

        labelKembalian = new JLabel("Kembalian");
        labelKembalian.setBounds(40, 480, 200, 30);
        labelKembalian.setFont(new Font("Segoe UI", 0, 17));
        add(labelKembalian);
        kembalianField = new JTextField();
        kembalianField.setBounds(180, 480, 150, 30);
        add(kembalianField);

        saveButton = new JButton("Simpan");
        saveButton.setBounds(190, 550, 100, 30);
        add(saveButton);

        cetakButton = new JButton("Cetak");
        cetakButton.setBounds(400, 550, 100, 30);
        add(cetakButton);

        hapusButton = new JButton("Hapus");
        hapusButton.setBounds(610, 550, 100, 30);
        add(hapusButton);

        batalButton = new JButton("Batal");
        batalButton.setBounds(820, 550, 100, 30);
        add(batalButton);

        showdata = new JButton("Show");
        showdata.setBounds(1030, 550, 100, 30);
        add(showdata);

        searchButton = new JButton("Cari");
        searchButton.setBounds(220, 620, 100, 30);
        add(searchButton);

        cariField = new JTextField();
        cariField.setBounds(10, 620, 200, 30);
        add(cariField);

        String[] columns = {"Admin", "Nomor Transaksi", "Tggl_Pinjam", "Tggl.Kembali", "Id_Pelanggan", "Nik", "Nama_Pelanggan", "No_tlpn", "Alamat", "Id_PS", "Jenis_PS", "Total_Harga", "Keterlamabatan", "Denda", "Total Denda", "Total Bayar", "Bayar", "Kembalian"};

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setResizingAllowed(false);// Digunakan agar garis pembatas nama kolom tidak bisa digeser oleh pengguna
        table.getTableHeader().setReorderingAllowed(false);//Mncegah pengguna untuk merubah urutan tabel
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 670, 1470, 200);
        add(scrollPane);

          
            
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String notransaksi = noTransaksifield.getText().trim();

                if (!notransaksi.isEmpty()) {
                    // Memanggil fungsi pencarian di frame DataPelanggan

                    generateNoTransaksi(notransaksi);
                } else {
                    JOptionPane.showMessageDialog(null, "Masukkan No Transaksi dengan Tepat dan Benar.");
                }
            }
        });

        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungDenda();
            }
        });
        batalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Dashboard();
                dispose(); // Menutup frame Peminjaman saat ini
            }
        });

        bayarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bayar();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String admin = adminName;
                String noTransaksi = noTransaksifield.getText();
                String tglPeminjaman = tglPeminjamanField.getText();
                String tglPengembalian = tglPengembalianField.getText();
                String idPelanggan = idPelangganField.getText();
                String nik = nikField.getText();
                String namaPelanggan = namaPelangganField.getText();
                String nomorTelepon = nomorTeleponField.getText();
                String alamat = addressArea.getText();
                String idPlaystation = idPlaystationField.getText();
                String jenisPlaystation = playstationField.getText();
                String totalharga = totalHargaField.getText();
                String bayar = BayarFieldPelanggan.getText();
                String kembali = kembalianField.getText();
                String keterlambatan = keterlambatanField.getText();
                String denda = dendaField.getText();
                String totaldenda = totaldendaField.getText();
                String totalbayar = totalbayarField.getText();

                if (admin.isEmpty() || noTransaksi.isEmpty() || tglPeminjaman.isEmpty() || tglPengembalian.isEmpty() || idPelanggan.isEmpty()
                        || nik.isEmpty() || namaPelanggan.isEmpty() || nomorTelepon.isEmpty() || alamat.isEmpty()
                        || idPlaystation.isEmpty() || jenisPlaystation.isEmpty() || totalharga.isEmpty()
                        || bayar.isEmpty() || kembali.isEmpty() || keterlambatan.isEmpty() || denda.isEmpty() || totaldenda.isEmpty() || totalbayar.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lengkapi semua data sebelum menyimpan.");
                } else {
                    try {
                        DatabaseConnection c = new DatabaseConnection();

                        // Query untuk menyimpan data ke dalam tabel
                        String query = "INSERT INTO pengembalian (NamaAdmin, NoTransaksi, TglPeminjaman, TglPengembalian, IDPelanggan, NIK, NamaPelanggan, NoTelepon, Alamat, IDPlaystation, JenisPlaystation, TotalHarga, Keterlambatan, Denda, TotalDenda, TotalBayar, Bayar, Kembalian) VALUES ('" + admin + "', '" + noTransaksi + "','" + tglPeminjaman + "','" + tglPengembalian + "','" + idPelanggan + "','" + nik + "','" + namaPelanggan + "','" + nomorTelepon + "','" + alamat + "','" + idPlaystation + "','" + jenisPlaystation + "','" + totalharga + "','" + keterlambatan + "','" + denda + "','" + totaldenda + "','" + totalbayar + "','" + bayar + "','" + kembali + "')";

                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke dalam tabel.");
                        model.addRow(new Object[]{admin, noTransaksi, tglPeminjaman, tglPengembalian, idPelanggan, nik, namaPelanggan, nomorTelepon, alamat, idPlaystation, jenisPlaystation, totalharga, keterlambatan, denda, totaldenda, totalbayar, bayar, kembali});
                        c.executeUpdate(query);

                        // Reset nilai field
                        noTransaksifield.setText("");
                        tglPeminjamanField.setText("");
                        tglPengembalianField.setText("");
                        idPelangganField.setText("");
                        nikField.setText("");
                        namaPelangganField.setText("");
                        nomorTeleponField.setText("");
                        addressArea.setText("");
                        idPlaystationField.setText("");
                        playstationField.setText("");
                        totalHargaField.setText("");
                        keterlambatanField.setText("");
                        dendaField.setText("");
                        totaldendaField.setText("");
                        totalbayarField.setText("");
                        BayarFieldPelanggan.setText("");
                        kembalianField.setText("");
                        // Tutup koneksi setelah selesai
//                        connection.closeConnection();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data.");
                    }
                }
            }
        });
        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow >= 0) {
                    try {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        String noTransaksi = model.getValueAt(selectedRow, 1).toString(); // Mengambil nomor transaksi dari baris terpilih

                        // Buatlah koneksi ke database
                        DatabaseConnection c = new DatabaseConnection();

                        // Query DELETE untuk menghapus data berdasarkan nomor transaksi
                        String query = "DELETE FROM pengembalian WHERE NoTransaksi = '" + noTransaksi + "'";

                        // Eksekusi query DELETE
                        c.executeUpdate(query);

                        // Hapus baris dari tabel di frame
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus dari database.");

                        // Tutup koneksi ke database
                        c.closeConnection();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam menghapus data.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus.");
                }
            }
        });

        showdata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DatabaseConnection c = new DatabaseConnection();

                    // Query untuk mengambil semua data dari tabel pengembalian
                    String query = "SELECT * FROM pengembalian";

                    ResultSet result = c.executeQuery(query);

                    // Membersihkan model tabel sebelum menambahkan data baru
                    model.setRowCount(0);

                    while (result.next()) {
                        // Mendapatkan data dari setiap kolom dalam baris saat ini
                        String admin = result.getString("NamaAdmin");
                        String noTransaksi = result.getString("NoTransaksi");
                        String tglPeminjaman = result.getString("TglPeminjaman");
                        String tglPengembalian = result.getString("TglPengembalian");
                        String idPelanggan = result.getString("IDPelanggan");
                        String nik = result.getString("NIK");
                        String namaPelanggan = result.getString("NamaPelanggan");
                        String nomorTelepon = result.getString("NoTelepon");
                        String alamat = result.getString("Alamat");
                        String idPlaystation = result.getString("IDPlaystation");
                        String jenisPlaystation = result.getString("JenisPlaystation");
                        String totalharga = result.getString("TotalHarga");
                        String keterlambatan = result.getString("Keterlambatan");
                        String denda = result.getString("Denda");
                        String totaldenda = result.getString("TotalDenda");
                        String totalbayar = result.getString("TotalBayar");
                        String bayar = result.getString("Bayar");
                        String kembali = result.getString("Kembalian");

                        // Menambahkan data ke model tabel
                        model.addRow(new Object[]{admin, noTransaksi, tglPeminjaman, tglPengembalian, idPelanggan, nik, namaPelanggan, nomorTelepon, alamat, idPlaystation, jenisPlaystation, totalharga, keterlambatan, denda, totaldenda, totalbayar, bayar, kembali});
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menampilkan data.");
                }
            }
        });
        cetakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MessageFormat header = new MessageFormat("DATA PENGEMBALIAN");
//                    MessageFormat footer = new MessageFormat("Page {0}");

                    // Melakukan pencetakan tabel dengan judul
                    table.print(JTable.PrintMode.FIT_WIDTH, header, null);
                } catch (Exception xe) {
                    xe.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    // Method untuk menghitung denda, total denda, dan total bayar
    public void hitungDenda() {
        try {
            int keterlambatan = Integer.parseInt(keterlambatanField.getText());
            int dendaPerHari = Integer.parseInt(dendaField.getText());
            int totalHarga = Integer.parseInt(totalHargaField.getText());

            int totalDenda = keterlambatan * dendaPerHari;
            int totalBayar = totalHarga + totalDenda;

            totaldendaField.setText(String.valueOf(totalDenda));
            totalbayarField.setText(String.valueOf(totalBayar));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Masukkan angka yang valid untuk keterlambatan dan denda per hari.");
        }
    }

    // Method untuk proses pembayaran
    public void bayar() {
        try {
            int totalBayar = Integer.parseInt(totalbayarField.getText());
            int bayarPelanggan = Integer.parseInt(BayarFieldPelanggan.getText());

            if (bayarPelanggan < totalBayar) {
                JOptionPane.showMessageDialog(null, "Pembayaran kurang, silakan masukkan jumlah yang mencukupi.");
            } else if (bayarPelanggan == totalBayar) {
                kembalianField.setText("0");
                JOptionPane.showMessageDialog(null, "Pembayaran berhasil!");
            } else {
                int kembalian = bayarPelanggan - totalBayar;
                kembalianField.setText(String.valueOf(kembalian));
                JOptionPane.showMessageDialog(null, "Pembayaran berhasil! Kembalian: " + kembalian);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Masukkan angka yang valid untuk pembayaran.");
        }
    }

    public void generateNoTransaksi(String notransaksi) {
        try {
            DatabaseConnection c = new DatabaseConnection();
            String query = "SELECT * FROM peminjaman WHERE NoTransaksi = '" + notransaksi + "'";
            ResultSet result = c.executeQuery(query);

            boolean found = false; // Menandakan apakah data ditemukan atau tidak

            while (result.next()) {
                found = true; // Setel menjadi true karena data ditemukan
                String id = result.getString("IDPelanggan");
                String nik = result.getString("NIK");
                String name = result.getString("NamaPelanggan");
                String phone = result.getString("NoTelepon");
                String address = result.getString("Alamat");
                String tgglPinjam = result.getString("TglPeminjaman");
                String tgglKembali = result.getString("TglPengembalian");
                String totalharga = result.getString("TotalHarga");
                String IdPs = result.getString("IDPlaystation");
                String jenisPS = result.getString("JenisPlaystation");

                setIdPelangganField(id);
                setNikField(nik);
                setNamaField(name);
                setNoTeleponField(phone);
                setAlamatField(address);
                setTanggalPinjam(tgglPinjam);
                setTanggalKembali(tgglKembali);
                settotalHargaField(totalharga);
                setIdPlaystationField(IdPs);
                setJenisPlaystationField(jenisPS);

            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "Data Transaksi tidak ditemukan.");
                // Lakukan penanganan jika data tidak ditemukan, seperti membersihkan field atau menampilkan pesan tertentu.
            }

            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Metode setter untuk field ID PlayStation di frame Peminjaman
    public void setIdPlaystationField(String idPlaystation) {
        idPlaystationField.setText(idPlaystation);
    }

    // Metode setter untuk field Jenis PlayStation di frame Peminjaman
    public void setJenisPlaystationField(String jenisPlaystation) {
        playstationField.setText(jenisPlaystation);
    }

    // Metode setter untuk field Harga di frame Peminjaman
    public void settotalHargaField(String totalharga) {
        totalHargaField.setText(totalharga);
    }

    public void setIdPelangganField(String idPelanggan) {
        idPelangganField.setText(idPelanggan);
    }

    public void setNikField(String nik) {
        nikField.setText(nik);
    }

    public void setNamaField(String nama) {
        namaPelangganField.setText(nama);
    }

    public void setNoTeleponField(String nomorTelepon) {
        nomorTeleponField.setText(nomorTelepon);
    }
    public void setNomorTrasnsaksi(String nomorTransaksi) {
        noTransaksifield.setText(nomorTransaksi);
    }

    public void setAlamatField(String Alamat) {
        addressArea.setText(Alamat);
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        tglPeminjamanField.setText(tanggalPinjam);
    }

    public void setTanggalKembali(String tanggalKembali) {
        tglPengembalianField.setText(tanggalKembali);
    }

}

//                        if (rowsAffected > 0) {
//                            JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke database.");
//                            // Lakukan tindakan lanjutan setelah penyimpanan berhasil
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Gagal menyimpan data ke database.");
//                        }
