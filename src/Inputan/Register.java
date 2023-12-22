/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inputan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Register extends JFrame {

    JButton create, back;
    JLabel labelusername, labelemail, labelpassword;
    JTextField username, email, password;
    

    Register() {
        super("Register");

        
        setBounds(45,150,500, 750);
        setLayout(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBounds(15, 20, 450, 650);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.BOLD, 20), Color.BLUE));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/SignUp.png"));
        Image i2 = i1.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(95, 30, 250, 250);
        panel.add(l3);

        labelusername = new JLabel("Username");
        labelusername.setBounds(40, 350, 100, 30);
        labelusername.setFont(new Font("Segoe UI", 0, 17));
        panel.add(labelusername);

        labelemail = new JLabel("Email");
        labelemail.setBounds(40, 400, 100, 30);
        labelemail.setFont(new Font("Segoe UI", 0, 17));
        panel.add(labelemail);

        labelpassword = new JLabel("Password");
        labelpassword.setBounds(40, 450, 100, 30);
        labelpassword.setFont(new Font("Segoe UI", 0, 17));
        panel.add(labelpassword);

        username = new JTextField();
        username.setBounds(150, 350, 200, 30);
        panel.add(username);

        
        email = new JTextField();
        email.setBounds(150, 400, 200, 30);
        panel.add(email);

        

        password = new JPasswordField();
        password.setBounds(150, 450, 200, 30);
        panel.add(password);

        create = new JButton("CREATE");
        create.setBounds(100, 550, 120, 25);
        create.setPreferredSize(new Dimension(120, 30));
        create.setFont(new Font("Segoe UI", 0, 17));
        create.setContentAreaFilled(false);
        create.setForeground(new Color(0, 80, 239));
        create.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 239), 1, true));
        panel.add(create);

        back = new JButton("BACK");
        back.setBounds(250, 550, 120, 25);
        back.setPreferredSize(new Dimension(120, 30));
        back.setFont(new Font("Segoe UI", 0, 17));
        back.setContentAreaFilled(false);
        back.setForeground(Color.BLUE);
        back.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1, true));
        panel.add(back);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String susername = username.getText();
                String semail = email.getText();
                String spassword = password.getText();

                try {
                    DatabaseConnection c = new DatabaseConnection();
                    if (susername.equals("") || semail.equals("") || spassword.equals("")) {
                        JOptionPane.showMessageDialog(null, "Silahkan isi semua field");
                    } else {
                        String query = "insert into register (Username, Email, password) values ('" + susername + "', '" + semail + "', '" + spassword + "')";
                        c.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Account Created Successfully");
                        setVisible(false);
                        new LoginAdmin(); // Menampilkan kembali frame LoginAdmin
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                username.setText("");
                email.setText("");
                password.setText("");
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new LoginAdmin().setVisible(true); // Kembali ke frame LoginAdmin
            }
        });
        
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setLocationRelativeTo(null); // Menempatkan frame di tengah layar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new Register();
    }

   
}
