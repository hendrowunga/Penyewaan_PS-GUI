package Inputan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.table.TableRowSorter;

public class DataPlayStation extends JFrame {

    private JLabel idLabel, JenisPSlabel, HargaSewalabel, stokLabel;
    private JTextField idField, hargaField, cariField, stokField;
    private JButton saveButton, updateButton, deleteButton, searchButton, cancelButton, generate, showdata;
    private JTable table;
    private JScrollPane scrollPane;
    JComboBox<String> comboBoxJenisPS;

    public DataPlayStation() {
        setTitle("Data PlayStation");
        setLayout(null);
        setSize(800, 700);
        getContentPane().setBackground(new Color(173, 216, 230));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("DATA PLAYSTATION");
        add(label);
        label.setBounds(300, 10, 200, 30);
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        idLabel = new JLabel("ID Playstation");
        idLabel.setBounds(300, 70, 200, 30);
        idLabel.setFont(new Font("Segoe UI", 0, 17));
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(250, 100, 200, 30);
        add(idField);
        generate = new JButton("Ganarate");
        generate.setBounds(470, 100, 120, 30);
        generate.setPreferredSize(new Dimension(120, 30));
        generate.setFont(new Font("Segoe UI", 0, 17));
        generate.setContentAreaFilled(false);
        generate.setForeground(new Color(0, 80, 239));
        generate.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 239), 1, true));
        add(generate);

        JenisPSlabel = new JLabel("Jenis PlayStation");
        JenisPSlabel.setBounds(300, 140, 200, 30);
        JenisPSlabel.setFont(new Font("Segoe UI", 0, 17));
        add(JenisPSlabel);
        comboBoxJenisPS = new JComboBox<>(new String[]{"PS1", "PS2", "PS3", "PS4", "PS5"});
        comboBoxJenisPS.setBounds(250, 170, 200, 30);
        add(comboBoxJenisPS);

        HargaSewalabel = new JLabel("Harga Sewa/Hari");
        HargaSewalabel.setBounds(300, 210, 200, 30);
        HargaSewalabel.setFont(new Font("Segoe UI", 0, 17));
        add(HargaSewalabel);
        hargaField = new JTextField();
        hargaField.setBounds(250, 240, 200, 30);
        hargaField.setEditable(false);
        add(hargaField);

        stokLabel = new JLabel("Jumlah PS");
        stokLabel.setBounds(300, 280, 200, 30);
        stokLabel.setFont(new Font("Segoe UI", 0, 17));
        add(stokLabel);
        stokField = new JTextField();
        stokField.setBounds(250, 310, 200, 30);
//        stokField.setEditable(false);
        add(stokField);

        saveButton = new JButton("Simpan");
        saveButton.setBounds(50, 370, 100, 30);
        add(saveButton);

        updateButton = new JButton("Ubah");
        updateButton.setBounds(200, 370, 100, 30);
        add(updateButton);

        deleteButton = new JButton("Hapus");
        deleteButton.setBounds(340, 370, 100, 30);
        add(deleteButton);

        searchButton = new JButton("Cari");
        searchButton.setBounds(250, 420, 100, 30);
        add(searchButton);

        showdata = new JButton("Show");
        showdata.setBounds(650, 370, 100, 30);
        add(showdata);

        cancelButton = new JButton("Batal");
        cancelButton.setBounds(500, 370, 100, 30);
        add(cancelButton);

        cariField = new JTextField();
        cariField.setBounds(20, 420, 200, 30);
        add(cariField);

        comboBoxJenisPS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dapatkan nilai dari comboBoxJenisPS
                String jenisPS = (String) comboBoxJenisPS.getSelectedItem();

                // Set harga berdasarkan jenis PS
                switch (jenisPS) {
                    case "PS1":
                        hargaField.setText("35000");
//                        int stokPS1 = 10;
//                        stokField.setText(String.valueOf(stokPS1));
                        break;
                    case "PS2":
                        hargaField.setText("45000");
//                        int stokPS2 = 15;
//                        stokField.setText(String.valueOf(stokPS2));
                        break;
                    case "PS3":
                        hargaField.setText("55000");
//                        int stokPS3 = 20;
//                        stokField.setText(String.valueOf(stokPS3));
                        break;
                    case "PS4":
                        hargaField.setText("65000");
//                        int stokPS4 = 5;
//                        stokField.setText(String.valueOf(stokPS4));
                        break;
                    case "PS5":
                        hargaField.setText("75000");
//                        int stokPS5 = 3;
//                        stokField.setText(String.valueOf(stokPS5));
                        break;
                    default:
                        break;
                }
            }
        });

        String[] columns = {"Id PlayStation", "Jenis PlayStation", "Harga Sewa", "Stok"};

        DefaultTableModel model = new DefaultTableModel(columns, 0);
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
        scrollPane.setBounds(20, 470, 700, 150);
        add(scrollPane);

        table.getSelectionModel().addListSelectionListener(e -> {
            // Mendapatkan baris yang dipilih
            int selectedRow = table.getSelectedRow();

            // Memastikan baris yang dipilih ada dan tidak -1
            if (selectedRow != -1) {
                String id_ps = table.getValueAt(selectedRow, 0).toString();
                String jenisPS = table.getValueAt(selectedRow, 1).toString();
                String hargaSewa = table.getValueAt(selectedRow, 2).toString();
                String stokps = table.getValueAt(selectedRow, 3).toString();

                // Tampilkan nilai-nilai ini kembali di JTextFields
                idField.setText(id_ps);
                hargaField.setText(hargaSewa);
                stokField.setText(stokps);
                comboBoxJenisPS.setSelectedItem(jenisPS);

            }
        });

        // Tambahkan ActionListener untuk tombol-tombol
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_ps = idField.getText();
                String jenisPS = (String) comboBoxJenisPS.getSelectedItem();
                String hargaSewa = hargaField.getText();
                String stok = (String) stokField.getText();

                // Implementasi penyimpanan data ke dalam database
                if (id_ps.isEmpty() || jenisPS.isEmpty() || hargaSewa.isEmpty() || stok.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Masukkan data Playstation untuk menyimpan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else if (!isValidJenisPS(jenisPS)) {
                    JOptionPane.showMessageDialog(null, "Jenis PlayStation tidak valid.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        DatabaseConnection c = new DatabaseConnection();
                        String sql = "INSERT INTO playstation (id, jenis_playstation, harga_sewa,stok) VALUES ('" + id_ps + "', '" + jenisPS + "', '" + hargaSewa + "', '" + stok + "')";
                        c.executeUpdate(sql);
                        c.closeConnection();

                        // Jika penyimpanan ke database berhasil, tambahkan juga ke dalam tabel GUI
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.addRow(new Object[]{id_ps, jenisPS, hargaSewa, stok});

                        // Reset field setelah disimpan
                        idField.setText("");
                        hargaField.setText("");
                        stokField.setText("");
                        comboBoxJenisPS.setSelectedIndex(0);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        // Handle kesalahan penyimpanan ke database di sini
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow(); // Dapatkan baris yang dipilih di tabel

                // Pastikan baris dipilih sebelum melakukan update
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih baris pada tabel untuk diubah.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    String id_ps = idField.getText();
                    String jenisPS = (String) comboBoxJenisPS.getSelectedItem();
                    String hargaSewa = hargaField.getText();
                    String stok = (String) stokField.getText();

                    // Lakukan update jika data sudah diisi
                    if (id_ps.isEmpty() || jenisPS.isEmpty() || hargaSewa.isEmpty() || stok.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Isi semua data untuk melakukan update.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    } else if (!isValidJenisPS(jenisPS)) {
                        JOptionPane.showMessageDialog(null, "Jenis PlayStation tidak valid.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            DatabaseConnection c = new DatabaseConnection();
                            String sql = "UPDATE playstation SET jenis_playstation = '" + jenisPS + "', harga_sewa = '" + hargaSewa + "',stok = '" + stok + "' WHERE id = '" + id_ps + "'";
                            c.executeUpdate(sql);
                            c.closeConnection();

                            // Update juga di dalam tabel GUI
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.setValueAt(jenisPS, selectedRow, 1);
                            model.setValueAt(hargaSewa, selectedRow, 2);
                            model.setValueAt(stok, selectedRow, 3);

                            // Reset field setelah update
                            idField.setText("");
                            hargaField.setText("");
                            stokField.setText("");
                            comboBoxJenisPS.setSelectedIndex(0);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            // Handle kesalahan update ke database di sini
                        }
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow(); // Dapatkan baris yang dipilih di tabel

                // Pastikan baris dipilih sebelum melakukan penghapusan
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih baris pada tabel untuk dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    int option = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        try {
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            String id_ps = table.getValueAt(selectedRow, 0).toString(); // Ambil nilai ID PlayStation dari baris yang dipilih

                            DatabaseConnection c = new DatabaseConnection();
                            String sql = "DELETE FROM playstation WHERE id = '" + id_ps + "'";
                            c.executeUpdate(sql);
                            c.closeConnection();

                            model.removeRow(selectedRow); // Hapus baris dari tabel GUI
                            JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                            // Reset field setelah update
                            idField.setText("");
                            hargaField.setText("");
                            stokField.setText("");
                            comboBoxJenisPS.setSelectedIndex(0);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            // Handle kesalahan penghapusan dari database di sini
                        }
                    }
                }
            }
        });

        showdata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                try {
                    DatabaseConnection c = new DatabaseConnection();
                    String query = "SELECT * FROM playstation";
                    ResultSet result = c.executeQuery(query);
                    model.setRowCount(0); // Reset tabel untuk menampilkan data baru

                    while (result.next()) {
                        String id = result.getString("id");
                        String jenisPS = result.getString("jenis_playstation");
                        String hargaSewa = result.getString("harga_sewa");
                        String stokps = result.getString("stok");

                        // Tambahkan data ke dalam tabel
                        model.addRow(new Object[]{id, jenisPS, hargaSewa, stokps});
                    }
                    c.closeConnection();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchText = cariField.getText().toLowerCase().trim();
                // Buat TableRowSorter dan terapkan ke tabel
                TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
                table.setRowSorter(rowSorter);

                if (searchText.length() == 0) {
                    // Tampilkan pesan jika tidak ada inputan pada pencarian
                    JOptionPane.showMessageDialog(null, "Masukkan inputan yang ingin dicari", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Set filter jika Anda ingin memfilter baris berdasarkan nilai tertentu
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
                cariField.setText("");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Dashboard();
                dispose(); // Close the current frame
            }
        });
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = generateID();
                idField.setText(id);
            }
        });

        setVisible(true);

    }

    private String generateID() {
        String id = UUID.randomUUID().toString().substring(0, 10);
        return id;
    }
    // Fungsi untuk memeriksa validitas jenis PS

    private boolean isValidJenisPS(String jenisPS) {
        return jenisPS.equals("PS1") || jenisPS.equals("PS2") || jenisPS.equals("PS3") || jenisPS.equals("PS4") || jenisPS.equals("PS5");
    }

    public void updateStock(String idPlaystation, int newStock) { // Fungsi untuk memperbarui stok PlayStation
        try {
            DatabaseConnection c = new DatabaseConnection(); // Membuat koneksi ke database
            String updateQuery = "UPDATE playstation SET stok = " + newStock + " WHERE id = '" + idPlaystation + "'"; // Query untuk memperbarui stok berdasarkan ID PlayStation
            c.executeUpdate(updateQuery); // Eksekusi query untuk memperbarui stok
            c.closeConnection(); // Menutup koneksi ke database setelah selesai
        } catch (Exception ex) {
            ex.printStackTrace(); // Menampilkan informasi jika terjadi kesalahan dalam pembaruan stok
        }
    }

}
