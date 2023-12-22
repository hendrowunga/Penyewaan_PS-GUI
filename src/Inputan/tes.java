/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inputan;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Peminjaman {
    String perangkat;
    String statusPengembalian;

    public Peminjaman(String perangkat, String statusPengembalian) {
        this.perangkat = perangkat;
        this.statusPengembalian = statusPengembalian;
    }
}

class Pelanggan {
    String nama;
    ArrayList<Peminjaman> peminjamanAktif;
    ArrayList<Peminjaman> riwayatPeminjaman;

    public Pelanggan(String nama) {
        this.nama = nama;
        this.peminjamanAktif = new ArrayList<>();
        this.riwayatPeminjaman = new ArrayList<>();
    }

    public void tambahPeminjamanAktif(String perangkat, String statusPengembalian) {
        Peminjaman peminjaman = new Peminjaman(perangkat, statusPengembalian);
        peminjamanAktif.add(peminjaman);
    }

    public void tambahRiwayatPeminjaman(String perangkat, String statusPengembalian) {
        Peminjaman peminjaman = new Peminjaman(perangkat, statusPengembalian);
        riwayatPeminjaman.add(peminjaman);
    }
}

public class tes extends JFrame {
    Pelanggan pelanggan;

    public tes() {
        pelanggan = new Pelanggan("John Doe");
        pelanggan.tambahPeminjamanAktif("PlayStation 5", "Belum dikembalikan");
        pelanggan.tambahPeminjamanAktif("Controller", "Sudah dikembalikan");

        pelanggan.tambahRiwayatPeminjaman("PlayStation 4", "Sudah dikembalikan");
        pelanggan.tambahRiwayatPeminjaman("Headset", "Sudah dikembalikan");
        
        setTitle("Info Peminjaman");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JTextArea statusPeminjamanAktifArea = new JTextArea();
        JTextArea riwayatPeminjamanArea = new JTextArea();

        for (Peminjaman peminjaman : pelanggan.peminjamanAktif) {
            statusPeminjamanAktifArea.append("Perangkat: " + peminjaman.perangkat + ", Status: " + peminjaman.statusPengembalian + "\n");
        }

        for (Peminjaman peminjaman : pelanggan.riwayatPeminjaman) {
            riwayatPeminjamanArea.append("Perangkat: " + peminjaman.perangkat + ", Status: " + peminjaman.statusPengembalian + "\n");
        }

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(BorderFactory.createTitledBorder("Status Peminjaman Aktif"));
        panel1.add(new JScrollPane(statusPeminjamanAktifArea), BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(BorderFactory.createTitledBorder("Riwayat Peminjaman"));
        panel2.add(new JScrollPane(riwayatPeminjamanArea), BorderLayout.CENTER);

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new tes());
    }
}

