package Inputan;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class LoginAdmin extends JFrame {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;
    DatabaseConnection c = new DatabaseConnection();
    String spassword;
    String susername;

    LoginAdmin() {

        super("Login");
        setLayout(null);
        setVisible(true);

        setSize(450, 650);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(95, 30, 250, 250);
        add(l3);

        l1 = new JLabel("Username");
        l1.setBounds(40, 350, 100, 30);
        l1.setFont(new Font("Segoe UI", 0, 17));
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 400, 100, 30);
        l2.setFont(new Font("Segoe UI", 0, 17));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 350, 200, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 400, 200, 30);
        add(t2);

        b1 = new JButton("LOGIN");
        b1.setBounds(50, 500, 120, 25);
        b1.setPreferredSize(new Dimension(120, 30));
        b1.setFont(new Font("Segoe UI", 0, 17));
        b1.setContentAreaFilled(false);
        b1.setForeground(new Color(0, 80, 239));
        b1.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 239), 1, true));
        add(b1);

        b2 = new JButton("REGISTER");
        b2.setBounds(230, 500, 120, 25);
        b2.setPreferredSize(new Dimension(120, 30));
        b2.setFont(new Font("Segoe UI", 0, 17));
        b2.setContentAreaFilled(false);
        b2.setForeground(new Color(0, 80, 239));
        b2.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 239), 1, true));
        add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                susername = t1.getText();
                spassword = t2.getText();

                try {
                    String query = "select * from register WHERE Username = '" + susername + "' AND password = '" + spassword + "'";
                    ResultSet result = c.executeQuery(query);

                    if (result.next()) {

                        JOptionPane.showMessageDialog(null, "Login Successful");
                        setVisible(false);
                        // Jika login berhasil, pindah ke frame lain

                       
                        new Dashboard(susername);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Login");
                        t1.setText("");
                        t2.setText("");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Register(); // Panggil frame Register dengan mengirimkan referensi ke frame LoginAdmin
                return;
            }
        });

        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setLocationRelativeTo(null); // Menempatkan frame di tengah layar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new LoginAdmin();

    }
}
