package Inputan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;
import java.sql.ResultSet;
import javax.swing.table.TableRowSorter;

public class DataPelanggan extends JFrame {

    private JLabel adminLabel, idLabel, nameLabel, phoneLabel, genderLabel, addressLabel, nikLabel;
    private JTextField idField, nameField, phoneField, nikField, cariField;
    private JButton showdata, saveButton, updateButton, deleteButton, searchButton, cancelButton, generate;
    private JTable table;
    private JTextArea addressArea;
    private JScrollPane scrollPane;
    DefaultTableModel model;
    String adminName;

    public DataPelanggan(String adminName) {
        this.adminName = adminName;
        setTitle("Data Pelangggan");
        setLayout(null);
        setSize(900, 800);
        getContentPane().setBackground(new Color(173, 216, 230));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("DATA PELANGGAN");
        add(label);
        label.setBounds(400, 10, 200, 30);
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        adminLabel = new JLabel("Admin   : " + adminName);
        adminLabel.setBounds(570, 70, 200, 30);
        adminLabel.setFont(new Font("Segoe UI", 0, 17));
        add(adminLabel);

        idLabel = new JLabel("ID Pelanggan");
        idLabel.setBounds(20, 70, 200, 30);
        idLabel.setFont(new Font("Segoe UI", 0, 17));
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(150, 70, 200, 30);
        add(idField);
        generate = new JButton("Ganarate");
        generate.setBounds(390, 70, 120, 25);
        generate.setPreferredSize(new Dimension(120, 30));
        generate.setFont(new Font("Segoe UI", 0, 17));
        generate.setContentAreaFilled(false);
        generate.setForeground(new Color(0, 80, 239));
        generate.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 239), 1, true));
        add(generate);

        nameLabel = new JLabel("Nama");
        nameLabel.setBounds(20, 110, 200, 30);
        nameLabel.setFont(new Font("Segoe UI", 0, 17));
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(150, 110, 200, 30);
        add(nameField);

        nikLabel = new JLabel("NIK");
        nikLabel.setBounds(20, 150, 200, 30);
        nikLabel.setFont(new Font("Segoe UI", 0, 17));
        add(nikLabel);
        nikField = new JTextField();
        nikField.setBounds(150, 150, 200, 30);
        add(nikField);

        genderLabel = new JLabel("Jenis Kelamin");
        genderLabel.setBounds(20, 190, 200, 30);
        genderLabel.setFont(new Font("Segoe UI", 0, 17));
        add(genderLabel);
        JRadioButton lakiLaki = new JRadioButton("Laki-laki");
        JRadioButton perempuan = new JRadioButton("Perempuan");
        lakiLaki.setBounds(150, 190, 90, 30);
        perempuan.setBounds(250, 190, 95, 30);
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(lakiLaki);
        radioGroup.add(perempuan);
        add(lakiLaki);
        add(perempuan);

        phoneLabel = new JLabel("No.Telepon");
        phoneLabel.setBounds(20, 230, 200, 30);
        phoneLabel.setFont(new Font("Segoe UI", 0, 17));
        add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setBounds(150, 230, 200, 30);
        add(phoneField);

        addressLabel = new JLabel("Alamat");
        addressLabel.setBounds(20, 270, 100, 25);
        addressLabel.setFont(new Font("Segoe UI", 0, 17));
        add(addressLabel);

        addressArea = new JTextArea();
        addressArea.setBounds(150, 270, 250, 100); // Atur ukuran sesuai kebutuhan
        scrollPane = new JScrollPane(addressArea);
        scrollPane.setBounds(150, 270, 250, 100);
        add(scrollPane);

        saveButton = new JButton("Simpan");
        saveButton.setBounds(50, 400, 100, 30);
        add(saveButton);

        updateButton = new JButton("Ubah");
        updateButton.setBounds(200, 400, 100, 30);
        add(updateButton);

        deleteButton = new JButton("Hapus");
        deleteButton.setBounds(350, 400, 100, 30);
        add(deleteButton);

        showdata = new JButton("Show");
        showdata.setBounds(650, 400, 100, 30);
        add(showdata);

        cancelButton = new JButton("Batal");
        cancelButton.setBounds(500, 400, 100, 30);
        add(cancelButton);

        searchButton = new JButton("Cari");
        searchButton.setBounds(270, 470, 100, 30);
        add(searchButton);

        cariField = new JTextField();
        cariField.setBounds(50, 470, 200, 30);
        add(cariField);

        String[] columns = {"Id Pelanggan", "Admin", "Nama", "NIK", "No.Telepon", "Jenis Kelamin", "Alamat"};

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
        scrollPane.setBounds(20, 520, 850, 200);
        add(scrollPane);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();

                // Memastikan baris yang dipilih ada dan tidak -1
                if (selectedRow != -1) {
                    // Ambil data dari baris yang dipilih
                    String id = table.getValueAt(selectedRow, 0).toString();
                    String admin = table.getValueAt(selectedRow, 1).toString();
                    String nama = table.getValueAt(selectedRow, 2).toString();
                    String nik = table.getValueAt(selectedRow, 3).toString();
                    String phone = table.getValueAt(selectedRow, 4).toString();
                    String gender = table.getValueAt(selectedRow, 5).toString();
                    String address = table.getValueAt(selectedRow, 6).toString();

                    // Menampilkan data pada JTextField
                    idField.setText(id);
                    nameField.setText(nama);
                    nikField.setText(nik);
                    phoneField.setText(phone);
                    addressArea.setText(address);

                    // Menampilkan dialog konfirmasi
                    int choice = JOptionPane.showConfirmDialog(null, "Apakah data yang dipilih sudah benar?",
                            "Konfirmasi Data", JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {
                        String adminName = admin; // Ganti dengan admin yang sesuai
                        Peminjaman peminjamanFrame = new Peminjaman(adminName);

                        // Setel nilai field di frame Data Peminjaman dengan data yang diterima
                        peminjamanFrame.setNikField(nik);
                        peminjamanFrame.setNamaField(nama);
                        peminjamanFrame.setNoTeleponField(phone);
                        peminjamanFrame.setAlamatField(address);
                        peminjamanFrame.setIdPelangganField(id);

                        // Sembunyikan frame Data Pelanggan
                        setVisible(false);

                        // Tampilkan frame Data Peminjaman
                        peminjamanFrame.setVisible(true);
                    }
                }
                cariField.setText("");
            }
        });

        // Add a listener to the generate button
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generate a unique ID for the customer
                String id = generateCustomerID();

                idField.setText(id);

                nameField.setEnabled(true);
                nikField.setEnabled(true);
                phoneField.setEnabled(true);
                addressArea.setEnabled(true);

                // Disable the generate button to prevent duplicate IDs
                generate.setEnabled(false);
            }
        });

        // Tambahkan ActionListener untuk tombol-tombol
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String admin = adminName;
                String id = idField.getText();
                String name = nameField.getText();
                String nik = nikField.getText();
                String phone = phoneField.getText();
                String gender = "";
                if (lakiLaki.isSelected()) {
                    gender = "Laki-laki";
                } else if (perempuan.isSelected()) {
                    gender = "Perempuan";
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih Jenis Kelamin");
                    return; // Memberhentikan proses update jika jenis kelamin tidak dipilih
                }
                String address = addressArea.getText();

                if (nik.length() != 16 || phone.length() != 12) {
                    JOptionPane.showMessageDialog(DataPelanggan.this, "Panjang NIK harus 16 angka dan panjang nomor telepon harus 12 angka", "Error", JOptionPane.ERROR_MESSAGE);
                    // Kosongkan field NIK dan nomor telepon
                    nikField.setText("");
                    phoneField.setText("");
                    return;
                }
                if (admin.isEmpty() || id.isEmpty() || name.isEmpty() || nik.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(DataPelanggan.this, "Silahkan isi semua inputan", "Error", JOptionPane.ERROR_MESSAGE);
                    idField.setText("");
                    nameField.setText("");
                    nikField.setText("");
                    phoneField.setText("");
                    lakiLaki.setSelected(false);
                    perempuan.setSelected(false);
                    addressArea.setText("");
                } else {
                    try {
                        DatabaseConnection c = new DatabaseConnection();
                        String sql = "INSERT INTO pelanggan (id_pelanggan,admin, nama, nik, no_telp, jenis_kelamin,alamat) VALUES ('" + id + "','" + admin + "',  '" + name + "', '" + nik + "', '" + phone + "','" + gender + "',  '" + address + "')";
                        c.executeUpdate(sql);

                        model.addRow(new Object[]{id, admin, name, nik, phone, gender, address});

                        // Clear the fields
                        idField.setText("");
                        nameField.setText("");
                        nikField.setText("");
                        phoneField.setText("");
                        lakiLaki.setSelected(false);
                        perempuan.setSelected(false);
                        addressArea.setText("");

                        // Enable the generate button for new entries
                        generate.setEnabled(true);
                    } catch (Exception x) {
                        x.printStackTrace();

                    }
                }
            }
        }
        );

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {

                    idField.setEnabled(false);
                    String updatedId = idField.getText();
                    String updatedName = nameField.getText();
                    String updatedNik = nikField.getText();
                    String updatedPhone = phoneField.getText();
                    String updatedAddress = addressArea.getText();
                    String gender = "";
                    if (lakiLaki.isSelected()) {
                        gender = "Laki-laki";
                    } else if (perempuan.isSelected()) {
                        gender = "Perempuan";
                    } else {
                        JOptionPane.showMessageDialog(null, "Pilih Jenis Kelamin");
                        return; // Memberhentikan proses update jika jenis kelamin tidak dipilih
                    }

                    // Cek apakah ada field yang kosong sebelum melakukan update
                    if (updatedId.isEmpty() || updatedName.isEmpty() || updatedNik.isEmpty() || updatedPhone.isEmpty() || updatedAddress.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Lengkapi data yang ingin diupdate");
                    } else {

                        try {
                            DatabaseConnection c = new DatabaseConnection();
                            String query = "UPDATE pelanggan SET id_pelanggan='" + updatedId + "', nama='" + updatedName + "', "
                                    + "nik='" + updatedNik + "', no_telp='" + updatedPhone + "', jenis_kelamin='" + gender + "' , alamat='" + updatedAddress + "' WHERE id_pelanggan='" + updatedId + "'";
                            c.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        idField.setText("");
                        nameField.setText("");
                        nikField.setText("");
                        phoneField.setText("");
                        lakiLaki.setSelected(false);
                        perempuan.setSelected(false);
                        addressArea.setText("");
                        generate.setEnabled(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang akan diupdate");
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
                    int option = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus baris ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        try {
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            String id_ps = table.getValueAt(selectedRow, 0).toString(); // Ambil nilai ID PlayStation dari baris yang dipilih

                            DatabaseConnection c = new DatabaseConnection();
                            String sql = "DELETE FROM pelanggan WHERE id_pelanggan = '" + id_ps + "'";
                            c.executeUpdate(sql);
                            c.closeConnection();

                            model.removeRow(selectedRow); // Hapus baris dari tabel GUI
                            JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                            // Clear the fields
                            idField.setText("");
                            nameField.setText("");
                            nikField.setText("");
                            phoneField.setText("");
                            addressArea.setText("");

                            // Enable the generate button
                            generate.setEnabled(true);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            // Handle exceptions (tampilkan pesan error atau tindakan lainnya)

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
                    String query = "SELECT * FROM pelanggan";
                    ResultSet result = c.executeQuery(query);

                    model.setRowCount(0); // Reset tabel

                    while (result.next()) {
                        String admin = result.getString("admin");
                        String id = result.getString("id_pelanggan");
                        String name = result.getString("nama");
                        String nik = result.getString("nik");
                        String phone = result.getString("no_telp");
                        String gender = "";
                        if (lakiLaki.isSelected()) {
                            gender = "Laki-laki";
                        } else if (perempuan.isSelected()) {
                            gender = "Perempuan";
                        }
                        gender = result.getString("jenis_kelamin");
                        String address = result.getString("alamat");

                        Object[] rowData = {id, admin, name, nik, phone, gender, address};
                        model.addRow(rowData);
                    }

                    c.closeConnection();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        );

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = cariField.getText().toLowerCase().trim();
                TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
                table.setRowSorter(rowSorter);

                if (searchText.length() == 0) {
                    // Tampilkan pesan jika tidak ada inputan pada pencarian
                    JOptionPane.showMessageDialog(null, "Masukkan inputan yang ingin dicari", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
                cariField.setText("");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose(); // Close the current frame

                // Show the existing instance of the Dashboard frame
                new Dashboard();
            }
        }
        );

        setVisible(true);
    }

    private String generateCustomerID() { // Mengambil 8 karakter saja dari id yang dimasukan
        String id = UUID.randomUUID().toString().substring(0, 8);
        return id;
    }

}
