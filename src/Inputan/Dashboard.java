package Inputan;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Lenovo
 */
public class Dashboard extends JFrame implements ActionListener {

    String adminName;

    public Dashboard() {

    }

    public Dashboard(String adminName) {
        this.adminName = adminName;
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/sewa.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        frame.add(image);

        // Buat menu bar
        JMenuBar menuBar = new JMenuBar();

        // Buat menu-menu
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        // Buat item-item dalam menu File
        JMenuItem Pelanggan = new JMenuItem("Data Pelanggan");
        JMenuItem PlayStation = new JMenuItem("Data PlayStation");
        JMenuItem peminjaman = new JMenuItem("Data Peminjaman");
        JMenuItem pengembalian = new JMenuItem("Data Pengembalian");
        JMenuItem exitItem = new JMenuItem("Exit");

        Pelanggan.addActionListener(this);
        PlayStation.addActionListener(this);
        peminjaman.addActionListener(this);
        pengembalian.addActionListener(this);

        // Tambahkan item-item ke menu File
        fileMenu.add(Pelanggan);
        fileMenu.add(PlayStation);
        fileMenu.add(peminjaman);
        fileMenu.add(pengembalian);
        fileMenu.addSeparator(); // Menambahkan pemisah antara item
        fileMenu.add(exitItem);

        // Tambahkan menu-menu ke dalam menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Set menu bar ke frame
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Data Pelanggan")) {
            new DataPelanggan(adminName).setVisible(true);
        } else if (msg.equals("Data PlayStation")) {
            new DataPlayStation().setVisible(true);
        } else if (msg.equals("Data Peminjaman")) {
            new Peminjaman(adminName).setVisible(true);
        } else if (msg.equals("Data Pengembalian")) {
            new Pengembalian(adminName).setVisible(true);
        } else if (msg.equals("Exit")) {
            setVisible(false);

            // Membuat dan menampilkan frame LoginAdmin
            LoginAdmin loginAdmin = new LoginAdmin();
            loginAdmin.setVisible(true);

        }
    }

}
