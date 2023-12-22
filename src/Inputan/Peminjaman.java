package Inputan;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.UUID;
import javax.swing.table.TableRowSorter;

public class Peminjaman extends JFrame {

    private JLabel notransaksilabel, adminLabel, tglPeminjamanLabel, idPelangganLabel, nikLabel, namaPelangganLabel,
            nomorTeleponLabel, alamatLabel, idPlaystationLabel, playstationLabel, hargaLabel, lamaSewaLabel,
            totalHargaLabel, tglPengembalianLabel;

    private JTextField noTransaksifield, adminField, tglPeminjamanField, idPelangganField, nikField, namaPelangganField,
            nomorTeleponField, idPlaystationField, playstationField, hargaField, lamaSewaField,
            totalHargaField, tglPengembalianField, cariField;

    private JButton showdata, hitungButton, carinik, cariidps, searchButton, saveButton, cetakButton, hapusButton, batalButton, generate, clenderButton1, clenderButton2;
    private JTable table;
    private JScrollPane scrollPane;
    private JTextArea addressArea;
    DefaultTableModel model;

    String adminName;

    public Peminjaman(String adminName) {
        this.adminName = adminName;

        setTitle("Peminjaman");
        setLayout(null);
        setSize(1500, 900);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216, 230));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("PEMINJAMAN");
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

        tglPengembalianLabel = new JLabel("Tggl.Pinjam");
        tglPengembalianLabel.setBounds(650, 100, 200, 30);
        tglPengembalianLabel.setFont(new Font("Segoe UI", 0, 17));
        add(tglPengembalianLabel);
        tglPeminjamanField = new JTextField();
        tglPeminjamanField.setBounds(770, 100, 150, 30);
        tglPeminjamanField.setEnabled(false);
        add(tglPeminjamanField);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/clender.jpg"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        clenderButton1 = new JButton(new ImageIcon(i2));
        clenderButton1.setBackground(Color.CYAN);
        clenderButton1.setBounds(940, 100, 80, 30);
        add(clenderButton1);

        idPlaystationLabel = new JLabel("ID Playstation");
        idPlaystationLabel.setBounds(650, 200, 200, 30);
        idPlaystationLabel.setFont(new Font("Segoe UI", 0, 17));
        add(idPlaystationLabel);
        idPlaystationField = new JTextField();
        idPlaystationField.setBounds(800, 200, 150, 30);
        add(idPlaystationField);
        cariidps = new JButton("Cari ID");
        cariidps.setBounds(960, 200, 80, 30);
        add(cariidps);

        playstationLabel = new JLabel("Jenis Playstation");
        playstationLabel.setBounds(650, 240, 200, 30);
        playstationLabel.setFont(new Font("Segoe UI", 0, 17));
        add(playstationLabel);
        playstationField = new JTextField();
        playstationField.setBounds(800, 240, 150, 30);
        add(playstationField);

        hargaLabel = new JLabel("Harga Sewa Rp.");
        hargaLabel.setBounds(650, 280, 290, 30);
        hargaLabel.setFont(new Font("Segoe UI", 0, 17));
        add(hargaLabel);
        hargaField = new JTextField();
        hargaField.setBounds(800, 280, 150, 30);
        add(hargaField);

        lamaSewaLabel = new JLabel("Lama Sewa");
        lamaSewaLabel.setBounds(650, 320, 200, 30);
        lamaSewaLabel.setFont(new Font("Segoe UI", 0, 17));
        add(lamaSewaLabel);
        lamaSewaField = new JTextField();
        lamaSewaField.setBounds(800, 320, 150, 30);
        add(lamaSewaField);

        totalHargaLabel = new JLabel("Total Harga Rp.");
        totalHargaLabel.setBounds(650, 360, 200, 30);
        totalHargaLabel.setFont(new Font("Segoe UI", 0, 17));
        add(totalHargaLabel);
        totalHargaField = new JTextField();
        totalHargaField.setBounds(800, 360, 150, 30);
        add(totalHargaField);
        hitungButton = new JButton("Hitung");
        hitungButton.setBounds(960, 360, 80, 30);
        add(hitungButton);

        tglPengembalianLabel = new JLabel("Tggl. Kembali Rp.");
        tglPengembalianLabel.setBounds(650, 400, 200, 30);
        tglPengembalianLabel.setFont(new Font("Segoe UI", 0, 17));
        add(tglPengembalianLabel);
        tglPengembalianField = new JTextField();
        tglPengembalianField.setBounds(800, 400, 150, 30);
        tglPengembalianField.setEnabled(false);
        add(tglPengembalianField);
        clenderButton2 = new JButton(new ImageIcon(i2));
        clenderButton2.setBackground(Color.CYAN);
        clenderButton2.setBounds(960, 400, 80, 30);
        add(clenderButton2);

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
        carinik = new JButton("Cari Nik");
        carinik.setBounds(340, 200, 80, 30);
        add(carinik);

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
        alamatLabel.setBounds(40, 360, 200, 30);
        alamatLabel.setFont(new Font("Segoe UI", 0, 17));
        add(alamatLabel);
        addressArea = new JTextArea();
        addressArea.setBounds(180, 360, 250, 100); // Atur ukuran sesuai kebutuhan
        scrollPane = new JScrollPane(addressArea);
        scrollPane.setBounds(180, 360, 250, 100);
        add(scrollPane);

        saveButton = new JButton("Simpan");
        saveButton.setBounds(190, 500, 100, 30);
        add(saveButton);

        cetakButton = new JButton("Cetak");
        cetakButton.setBounds(400, 500, 100, 30);
        add(cetakButton);

        hapusButton = new JButton("Hapus");
        hapusButton.setBounds(610, 500, 100, 30);
        add(hapusButton);

        batalButton = new JButton("Batal");
        batalButton.setBounds(820, 500, 100, 30);
        add(batalButton);

        showdata = new JButton("Show");
        showdata.setBounds(1030, 500, 100, 30);
        add(showdata);

        searchButton = new JButton("Cari");
        searchButton.setBounds(220, 570, 100, 30);
        add(searchButton);

        cariField = new JTextField();
        cariField.setBounds(10, 570, 200, 30);
        add(cariField);

        String[] columns = {"Admin", "Nomor Transaksi", "Tggl_Pinjam", "Id_Pelanggan", "Nik", "Nama_Pelanggan", "No_tlpn", "Alamat", "Id_PS", "Jenis_PS", "Harga", "Lama_Sewa", "Total_Harga", "Tggl.Kembali"};

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };
        table.getColumnModel().getColumn(3).setMinWidth(0); // Menetapkan lebar minimum kolom indeks ke-3 menjadi 0
        table.getColumnModel().getColumn(3).setMaxWidth(0); // Menetapkan lebar maksimum kolom indeks ke-3 menjadi 0
        table.getColumnModel().getColumn(3).setWidth(0); // Menetapkan lebar kolom indeks ke-3 menjadi 0
        table.getColumnModel().getColumn(8).setMinWidth(0); // Menetapkan lebar minimum kolom indeks ke-8 menjadi 0
        table.getColumnModel().getColumn(8).setMaxWidth(0); // Menetapkan lebar maksimum kolom indeks ke-8 menjadi 0
        table.getColumnModel().getColumn(8).setWidth(0); // Menetapkan lebar kolom indeks ke-8 menjadi 0

        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setResizingAllowed(false);// Digunakan agar garis pembatas nama kolom tidak bisa digeser oleh pengguna
        table.getTableHeader().setReorderingAllowed(false);//Mencegah pengguna untuk merubah urutan tabel
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 610, 1470, 200);
        add(scrollPane);

        table.addMouseListener(new MouseAdapter() { // Menambahkan adapter mouse pada tabel
            @Override
            public void mouseClicked(MouseEvent e) { // Aksi yang terjadi saat klik mouse
                int selectedRow = table.getSelectedRow(); // Mendapatkan baris yang dipilih

                // Memastikan baris yang dipilih tidak sama dengan -1 (artinya ada baris yang dipilih)
                if (selectedRow != -1) {
                    // Mengambil data dari baris yang dipilih
                    String notransaksi = table.getValueAt(selectedRow, 1).toString(); // Mengambil nilai dari kolom 1 di baris yang dipilih dan mengubahnya menjadi string
                    String admin = table.getValueAt(selectedRow, 0).toString(); // Mengambil nilai dari kolom 0 di baris yang dipilih dan mengubahnya menjadi string

                    // Menampilkan dialog konfirmasi
                    int choice = JOptionPane.showConfirmDialog(null, "Apakah data yang dipilih sudah benar?",
                            "Konfirmasi Data", JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) { // Jika pilihan adalah YES_OPTION
                        String adminName = admin; // Menyimpan nama admin
                        Pengembalian pengembalianframe = new Pengembalian(adminName); // Membuat objek frame Pengembalian dengan nama admin yang sesuai
                        // Set nilai field di frame Data Peminjaman dengan data yang diterima
                        pengembalianframe.setNomorTrasnsaksi(notransaksi);
                        // Sembunyikan frame Data Pelanggan yang sedang ditampilkan
                        setVisible(false);
                        // Tampilkan frame Data Peminjaman
                        pengembalianframe.setVisible(true);
                    }
                }
                cariField.setText(""); // Set teks pada field pencarian menjadi kosong
            }
        });

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = generateID();
                noTransaksifield.setText(id);
            }
        });
        clenderButton1.addActionListener(new ActionListener() { // Menambahkan pendengar aksi pada tombol clenderButton1
            @Override
            public void actionPerformed(ActionEvent e) { // Mendefinisikan tindakan yang akan dilakukan ketika tombol ditekan
                Date selectedDate = null; // Variabel selectedDate untuk menyimpan tanggal yang dipilih, awalnya null

                // Membuat objek SimpleDateFormat untuk mengatur format tanggal
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                // Memulai perulangan untuk memilih tanggal
                while (selectedDate == null) { // Melakukan perulangan sampai tanggal dipilih
                    JDateChooser dateChooser = new JDateChooser(); // Membuat objek JDateChooser untuk memilih tanggal
                    dateChooser.setDateFormatString("yyyy-MM-dd"); // Mengatur format tanggal pada dateChooser

                    // Menampilkan dialog JOptionPane untuk memilih tanggal dengan tombol OK_CANCEL_OPTION
                    int option = JOptionPane.showConfirmDialog(null, dateChooser, "Pilih Tanggal", JOptionPane.OK_CANCEL_OPTION);

                    // Jika tombol OK ditekan
                    if (option == JOptionPane.OK_OPTION) {
                        selectedDate = dateChooser.getDate(); // Mendapatkan tanggal yang dipilih dari dateChooser
                        // Jika tidak ada tanggal yang dipilih, tampilkan pesan peringatan
                        if (selectedDate == null) {
                            JOptionPane.showMessageDialog(null, "Masukkan tanggal pinjam", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        break; // Jika pengguna membatalkan, keluar dari perulangan
                    }
                }

                // Jika tanggal dipilih
                if (selectedDate != null) {
                    String dateString = dateFormat.format(selectedDate); // Mengubah tanggal menjadi string sesuai format yang ditentukan
                    tglPeminjamanField.setText(dateString); // Menetapkan string tanggal ke dalam tglPeminjamanField
                }
            }
        });

        clenderButton2.addActionListener(new ActionListener() { // Menambahkan action listener pada tombol clenderButton2
            @Override
            public void actionPerformed(ActionEvent e) { // Mendefinisikan aksi yang akan terjadi ketika tombol ditekan
                Date selectedDate = null; // Mendeklarasikan variabel selectedDate untuk menyimpan tanggal yang dipilih, awalnya null

                // Membuat objek SimpleDateFormat untuk mengatur format tanggal
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                // Memulai perulangan untuk memilih tanggal
                while (selectedDate == null) { // Melakukan loop hingga tanggal dipilih
                    JDateChooser dateChooser = new JDateChooser(); // Membuat objek JDateChooser untuk memilih tanggal
                    dateChooser.setDateFormatString("yyyy-MM-dd"); // Mengatur format tanggal pada dateChooser

                    // Menampilkan dialog JOptionPane untuk memilih tanggal dengan tombol OK_CANCEL_OPTION
                    int option = JOptionPane.showConfirmDialog(null, dateChooser, "Pilih Tanggal", JOptionPane.OK_CANCEL_OPTION);

                    // Jika tombol OK ditekan
                    if (option == JOptionPane.OK_OPTION) {
                        selectedDate = dateChooser.getDate(); // Mendapatkan tanggal yang dipilih dari dateChooser
                        // Jika tidak ada tanggal yang dipilih, tampilkan pesan peringatan
                        if (selectedDate == null) {
                            JOptionPane.showMessageDialog(null, "Masukkan tanggal pinjam", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        break; // Jika pengguna membatalkan, keluar dari perulangan
                    }
                }

                // Jika tanggal dipilih
                if (selectedDate != null) {
                    String dateString = dateFormat.format(selectedDate); // Mengonversi tanggal menjadi string sesuai dengan format yang telah ditentukan
                    tglPengembalianField.setText(dateString); // Menetapkan string tanggal ke dalam tglPengembalianField
                }
            }
        });

        carinik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nik = nikField.getText().trim();

                if (!nik.isEmpty()) {
                    // Memanggil fungsi pencarian di frame DataPelanggan

                    searchByNIK(nik);
                } else {
                    JOptionPane.showMessageDialog(null, "Masukkan NIK untuk mencari data pelanggan.");
                }
            }
        });
        cariidps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idplaystation = idPlaystationField.getText().trim();

                if (!idplaystation.isEmpty()) {
                    // Memanggil fungsi pencarian di frame DataPelanggan

                    searchByIDPlaystation(idplaystation);
                } else {
                    JOptionPane.showMessageDialog(null, "Masukkan ID PlaySation untuk mencari data Playstation.");
                }
            }
        });

        hitungButton.addActionListener(new ActionListener() { // Menambahkan pendengar aksi pada tombol hitungButton
            @Override
            public void actionPerformed(ActionEvent e) { // Mendefinisikan tindakan yang akan dilakukan ketika tombol ditekan
                try {
                    // Ambil tanggal pinjam dan tanggal kembali dari field
                    String tglPinjamText = tglPeminjamanField.getText(); // Mendapatkan teks tanggal pinjam dari tglPeminjamanField
                    String tglKembaliText = tglPengembalianField.getText(); // Mendapatkan teks tanggal kembali dari tglPengembalianField

                    // Konversi tanggal dari String ke tipe Date
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Membuat objek SimpleDateFormat untuk mengubah string menjadi tanggal
                    Date tglPinjam = dateFormat.parse(tglPinjamText); // Mengubah teks tanggal pinjam menjadi objek Date
                    Date tglKembali = dateFormat.parse(tglKembaliText); // Mengubah teks tanggal kembali menjadi objek Date

                    // Hitung perbedaan hari antara tanggal pinjam dan tanggal kembali
                    long diffInMillies = Math.abs(tglKembali.getTime() - tglPinjam.getTime()); // Hitung perbedaan waktu dalam milidetik antara tanggal kembali dan tanggal pinjam
                    long diff = diffInMillies / (1000 * 60 * 60 * 24); // Hitung selisih dalam hari,// Konversi perbedaan waktu dari milidetik menjadi jumlah hari
                    // 1000 milidetik = 1 detik, 60 detik = 1 menit, 60 menit = 1 jam, 24 jam = 1 hari

                    // Tampilkan hasil perhitungan lama sewa
                    lamaSewaField.setText(String.valueOf(diff)); // Menampilkan selisih hari pada lamaSewaField

                    // Ambil harga sewa per hari dari field
                    int hargaSewaPerHari = Integer.parseInt(hargaField.getText()); // Mengambil harga sewa per hari dari field hargaField

                    // Hitung total harga
                    int totalHarga = (int) (hargaSewaPerHari * diff); // Menghitung total harga berdasarkan harga sewa per hari dan selisih hari
                    totalHargaField.setText(String.valueOf(totalHarga)); // Menampilkan total harga pada totalHargaField
                } catch (ParseException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Masukkan tanggal yang valid dan pastikan harga terisi dengan benar."); // Menampilkan pesan jika terjadi kesalahan pada konversi tanggal atau format angka
                }
            }
        });

        saveButton.addActionListener(new ActionListener() { // Menambahkan listener untuk tombol simpan
            @Override
            public void actionPerformed(ActionEvent e) { // Tindakan yang dilakukan saat tombol ditekan
                String admin = adminName; // Mengambil nama admin dari variabel adminName
                // Mengambil nilai dari setiap field input untuk data peminjaman
                String noTransaksi = noTransaksifield.getText();
                String tglPeminjaman = tglPeminjamanField.getText();
                String idPelanggan = idPelangganField.getText();
                String nik = nikField.getText();
                String namaPelanggan = namaPelangganField.getText();
                String nomorTelepon = nomorTeleponField.getText();
                String alamat = addressArea.getText();
                String idPlaystation = idPlaystationField.getText();
                String jenisPlaystation = playstationField.getText();
                String hargaSewa = hargaField.getText();
                String lamaSewa = lamaSewaField.getText();
                String totalHarga = totalHargaField.getText();
                String tglPengembalian = tglPengembalianField.getText();

                // Memeriksa apakah semua field sudah terisi
                if (admin.isEmpty() || noTransaksi.isEmpty() || tglPeminjaman.isEmpty() || idPelanggan.isEmpty()
                        || nik.isEmpty() || namaPelanggan.isEmpty() || nomorTelepon.isEmpty() || alamat.isEmpty()
                        || idPlaystation.isEmpty() || jenisPlaystation.isEmpty() || hargaSewa.isEmpty()
                        || lamaSewa.isEmpty() || totalHarga.isEmpty() || tglPengembalian.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lengkapi semua data sebelum menyimpan."); // Menampilkan pesan jika ada field yang kosong
                } else {
                    try {
                        DatabaseConnection c = new DatabaseConnection(); // Membuat koneksi ke database
                        // Membuat query untuk memasukkan data peminjaman ke database
                        String query = "INSERT INTO peminjaman (NoTransaksi, NamaAdmin, TglPeminjaman,IDPelanggan,NIK,NamaPelanggan,NoTelepon,Alamat,IDPlaystation,JenisPlaystation,Harga,LamaSewa,TotalHarga,TglPengembalian) VALUES ('"
                                + noTransaksi + "', '" + admin + "', '" + tglPeminjaman + "', '" + idPelanggan + "', '" + nik + "', '" + namaPelanggan + "', '" + nomorTelepon + "', '" + alamat + "', '" + idPlaystation + "', '" + jenisPlaystation + "', '" + hargaSewa + "', '" + lamaSewa + "', '" + totalHarga + "', '" + tglPengembalian + "')";

                        c.executeUpdate(query); // Menjalankan query untuk memasukkan data ke database

                        // Mengambil nilai stok dari database dan menguranginya
                        int currentStock = 0;
                        String stockQuery = "SELECT stok FROM playstation WHERE id = '" + idPlaystation + "'";
                        ResultSet result = c.executeQuery(stockQuery);
                        if (result.next()) {
                            currentStock = result.getInt("stok");
                        }
                        int updatedStock = currentStock - 1; // Mengurangi stok

                        // Memperbarui stok di database
                        if (updatedStock >= 0) {
                            String updateQuery = "UPDATE playstation SET stok = " + updatedStock + " WHERE id = '" + idPlaystation + "'";
                            c.executeUpdate(updateQuery);

                            // Menampilkan pesan bahwa data berhasil disimpan ke dalam tabel
                            JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke dalam tabel.");
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            // Menambahkan baris baru dengan data yang dimasukkan ke dalam tabel
                            model.addRow(new Object[]{admin, noTransaksi, tglPeminjaman, idPelanggan, nik, namaPelanggan, nomorTelepon, alamat, idPlaystation, jenisPlaystation, hargaSewa, lamaSewa, totalHarga, tglPengembalian});

                            // Mengosongkan nilai field setelah data disimpan
                            noTransaksifield.setText("");
                            tglPeminjamanField.setText("");
                            idPelangganField.setText("");
                            nikField.setText("");
                            namaPelangganField.setText("");
                            nomorTeleponField.setText("");
                            addressArea.setText("");
                            idPlaystationField.setText("");
                            playstationField.setText("");
                            hargaField.setText("");
                            lamaSewaField.setText("");
                            totalHargaField.setText("");
                            tglPengembalianField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Stok tidak mencukupi untuk transaksi ini."); // Menampilkan pesan jika stok tidak mencukupi
                            idPlaystationField.setText("");
                            playstationField.setText("");
                            hargaField.setText("");
                            lamaSewaField.setText("");
                            totalHargaField.setText("");
                        }

                        c.closeConnection(); // Menutup koneksi ke database

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam penyimpanan data."); // Menampilkan pesan jika terjadi kesalahan
                    }
                }
            }
        });

        showdata.addActionListener(new ActionListener() { // Menambahkan listener pada tombol 'Tampilkan Data'
            @Override
            public void actionPerformed(ActionEvent e) { // Tindakan yang dilakukan saat tombol ditekan
                try {
                    // Membuat koneksi ke database
                    DatabaseConnection c = new DatabaseConnection();

                    // Query untuk mengambil semua data dari tabel peminjaman
                    String query = "SELECT * FROM peminjaman";

                    // Menjalankan query dan mendapatkan hasilnya
                    ResultSet result = c.executeQuery(query);

                    model.setRowCount(0); // Mengosongkan tabel sebelum menambahkan data baru

                    // Meloop melalui hasil query dan menambahkan data ke dalam tabel di aplikasi
                    while (result.next()) {
                        // Mengambil data dari setiap kolom hasil query
                        String noTransaksi = result.getString("NoTransaksi");
                        String admin = result.getString("NamaAdmin");
                        String tglPeminjaman = result.getString("TglPeminjaman");
                        String idPelanggan = result.getString("IDPelanggan");
                        String nik = result.getString("NIK");
                        String namaPelanggan = result.getString("NamaPelanggan");
                        String nomorTelepon = result.getString("NoTelepon");
                        String alamat = result.getString("Alamat");
                        String idPlaystation = result.getString("IDPlaystation");
                        String jenisPlaystation = result.getString("JenisPlaystation");
                        String hargaSewa = result.getString("Harga");
                        String lamaSewa = result.getString("LamaSewa");
                        String totalHarga = result.getString("TotalHarga");
                        String tglPengembalian = result.getString("TglPengembalian");

                        // Menambahkan baris baru ke dalam tabel aplikasi dengan data yang diambil dari database
                        model.addRow(new Object[]{admin, noTransaksi, tglPeminjaman, idPelanggan, nik, namaPelanggan, nomorTelepon, alamat, idPlaystation, jenisPlaystation, hargaSewa, lamaSewa, totalHarga, tglPengembalian});
                    }

                    // Menutup koneksi ke database setelah selesai
                    c.closeConnection();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam menampilkan data."); // Menampilkan pesan kesalahan jika terjadi masalah dalam menampilkan data
                }
            }
        });

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow >= 0) {
                    try {

                        String noTransaksi = model.getValueAt(selectedRow, 1).toString(); // Mengambil nomor transaksi dari baris terpilih

                        // Buatlah koneksi ke database
                        DatabaseConnection c = new DatabaseConnection();

                        // Query DELETE untuk menghapus data berdasarkan nomor transaksi
                        String query = "DELETE FROM peminjaman WHERE NoTransaksi = '" + noTransaksi + "'";

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

        batalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Dashboard();
                dispose(); // Menutup frame Peminjaman saat ini
            }
        });

        searchButton.addActionListener(new ActionListener() { // Menambahkan listener pada tombol 'Cari'
            @Override
            public void actionPerformed(ActionEvent e) { // Tindakan yang dilakukan saat tombol ditekan
                String searchText = cariField.getText().toLowerCase().trim(); // Mendapatkan teks yang ingin dicari dan mengonversinya ke huruf kecil serta menghapus spasi di awal dan akhir

                // Membuat sorter untuk model tabel
                TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
                table.setRowSorter(rowSorter); // Menetapkan sorter pada tabel

                if (searchText.length() == 0) { // Jika panjang teks pencarian adalah 0 (tidak ada inputan)
                    // Menampilkan pesan peringatan
                    JOptionPane.showMessageDialog(null, "Masukkan inputan yang ingin dicari", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Menetapkan filter baris untuk sorter dengan pola pencarian yang diinginkan
                    // (?i) untuk pencarian yang case-insensitive
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
                cariField.setText(""); // Mengosongkan field pencarian setelah proses pencarian selesai
            }
        });

        cetakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MessageFormat header = new MessageFormat("DATA PEMINJAMAN");

                    // Melakukan pencetakan tabel dengan judul
                    table.print(JTable.PrintMode.FIT_WIDTH, header, null);
                } catch (Exception xe) {
                    xe.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    private String generateID() {
        String id = UUID.randomUUID().toString().substring(0, 10);
        return id;
    }

    // Metode setter untuk field ID PlayStation di frame Peminjaman
    public void setIdPlaystationField(String idPlaystation) {
        idPlaystationField.setText(idPlaystation);
    }

    // Metode setter untuk field Jenis PlayStation di frame Peminjaman
    public void setPlaystationField(String jenisPlaystation) {
        playstationField.setText(jenisPlaystation);
    }

    // Metode setter untuk field Harga di frame Peminjaman
    public void setHargaField(String harga) {
        hargaField.setText(harga);
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

    public void setAlamatField(String Alamat) {
        addressArea.setText(Alamat);
    }

    public void searchByNIK(String nik) { // Fungsi untuk mencari data pelanggan berdasarkan NIK
        try {
            DatabaseConnection c = new DatabaseConnection(); // Membuat koneksi ke database
            String query = "SELECT * FROM pelanggan WHERE nik = '" + nik + "'"; // Query untuk mencari data pelanggan berdasarkan NIK
            ResultSet result = c.executeQuery(query); // Eksekusi query

            boolean found = false; // Variabel untuk menandakan apakah data ditemukan atau tidak

            while (result.next()) { // Melakukan iterasi melalui hasil query
                found = true; // Setel menjadi true karena data ditemukan
                // Mengambil data dari hasil query
                String id = result.getString("id_pelanggan");
                String name = result.getString("nama");
                String phone = result.getString("no_telp");
                String address = result.getString("alamat");

                // Mengatur nilai field dengan data yang ditemukan
                setIdPelangganField(id);
                setNikField(nik);
                setNamaField(name);
                setNoTeleponField(phone);
                setAlamatField(address);
            }

            if (!found) { // Jika data tidak ditemukan
                JOptionPane.showMessageDialog(null, "Data pelanggan tidak ditemukan."); // Tampilkan pesan bahwa data tidak ditemukan
                // Di sini bisa ditambahkan penanganan jika data tidak ditemukan, seperti membersihkan field atau menampilkan pesan tertentu.
            }

            c.closeConnection(); // Menutup koneksi ke database
        } catch (Exception ex) {
            ex.printStackTrace(); // Menampilkan informasi jika terjadi kesalahan dalam pencarian
        }
    }

    public void searchByIDPlaystation(String idps) { // Fungsi untuk mencari data PlayStation berdasarkan ID
        try {
            DatabaseConnection c = new DatabaseConnection(); // Membuat koneksi ke database
            String query = "SELECT * FROM playstation WHERE id = '" + idps + "'"; // Query untuk mencari data PlayStation berdasarkan ID
            ResultSet result = c.executeQuery(query); // Eksekusi query

            boolean found = false; // Variabel untuk menandakan apakah data ditemukan atau tidak

            while (result.next()) { // Melakukan iterasi melalui hasil query
                found = true; // Setel menjadi true karena data ditemukan
                // Mengambil data dari hasil query
                String idPlayStation = result.getString("id");
                String jenisPS = result.getString("jenis_playstation");
                String hargaSewa = result.getString("harga_sewa");

                // Mengatur nilai field dengan data yang ditemukan
                setIdPlaystationField(idPlayStation);
                setPlaystationField(jenisPS);
                setHargaField(hargaSewa);
            }

            if (!found) { // Jika data tidak ditemukan
                JOptionPane.showMessageDialog(null, "Data PlayStation tidak ditemukan."); // Tampilkan pesan bahwa data tidak ditemukan
                // Di sini bisa ditambahkan penanganan jika data tidak ditemukan, seperti membersihkan field atau menampilkan pesan tertentu.
            }

            c.closeConnection(); // Menutup koneksi ke database
        } catch (Exception ex) {
            ex.printStackTrace(); // Menampilkan informasi jika terjadi kesalahan dalam pencarian
        }
    }

}
