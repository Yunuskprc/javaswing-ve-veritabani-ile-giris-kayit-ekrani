import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class kayitOlFrame {

    static String kadi, sifre, sifret, telNo, tc;
    static GirisFrame nesnGirisFrame = new GirisFrame();
    static kayitolSorgulama kSorgulama = new kayitolSorgulama();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kayıt OL");

        JTable table = new JTable();
        table.setBounds(60, 70, 850, 500);
        table.setBackground(Color.decode("#96a0a6"));

        JLabel label = new JLabel("KAYIT OL");
        label.setBounds(470, 110, 110, 25);
        label.setFont(new Font("Calibri", Font.BOLD, 22));

        JLabel label2 = new JLabel();
        label2.setText("Kullanıcı Adı: ");
        label2.setFont(new Font("Calibri", Font.BOLD, 20));
        label2.setBounds(270, 180, 150, 25);

        JLabel label3 = new JLabel();
        label3.setText("Şifre: ");
        label3.setFont(new Font("Calibri", Font.BOLD, 20));
        label3.setBounds(335, 220, 150, 25);

        JLabel label4 = new JLabel();
        label4.setText("Şifre Tekrar: ");
        label4.setFont(new Font("Calibri", Font.BOLD, 20));
        label4.setBounds(275, 260, 150, 35);

        JLabel label5 = new JLabel();
        label5.setText("Telefon No : ");
        label5.setFont(new Font("Calibri", Font.BOLD, 20));
        label5.setBounds(275, 300, 150, 35);

        JLabel label6 = new JLabel();
        label6.setText("TC no: ");
        label6.setFont(new Font("Calibri", Font.BOLD, 20));
        label6.setBounds(320, 340, 150, 35);

        JTextField textField = new JTextField();
        textField.setBounds(400, 180, 260, 25);
        textField.setBackground(Color.decode("#Bec5c7"));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(400, 220, 260, 25);
        passwordField.setBackground(Color.decode("#Bec5c7"));

        JPasswordField passwordField2 = new JPasswordField();
        passwordField2.setBounds(400, 260, 260, 25);
        passwordField2.setBackground(Color.decode("#Bec5c7"));

        JTextField textField2 = new JTextField();
        textField2.setBounds(400, 300, 260, 25);
        textField2.setBackground(Color.decode("#Bec5c7"));

        JTextField textField3 = new JTextField();
        textField3.setBounds(400, 340, 260, 25);
        textField3.setBackground(Color.decode("#Bec5c7"));

        JLabel label7 = new JLabel();
        label7.setBounds(460, 435, 200, 20);
        label7.setFont(new Font("Calibri", Font.CENTER_BASELINE, 15));

        JButton button = new JButton("Kayıt Ol");
        button.setBounds(400, 380, 100, 40);
        button.setBackground(Color.decode("#F1f0ef"));
        button.setFont(new Font("Calibri", Font.BOLD, 20));

        JButton button2 = new JButton("Temizle");
        button2.setBounds(520, 380, 100, 40);
        button2.setBackground(Color.decode("#F1f0ef"));
        button2.setFont(new Font("Calibri", Font.BOLD, 20));

        ImageIcon icon1 = new ImageIcon("C:\\Users\\kopru\\Downloads\\2.png");
        JButton button3 = new JButton(icon1);
        button3.setBounds(5, 5, 40, 40);
        button3.setOpaque(false);
        button3.setFocusPainted(false);
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // kayıt işlemi ve sorgu yapacak
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                kadi = textField.getText();
                sifre = passwordField.getText();
                sifret = passwordField2.getText();
                telNo = textField2.getText();
                tc = textField3.getText();

                try {

                    if (kSorgulama.ksorgulama(kadi, sifre, sifret, tc, telNo)) {
                        try {Thread.sleep(1000);} catch (Exception es) {}
                        label7.setText("Kayıt Başarılı");
                        kSorgulama.kayitEkle(kadi, sifre);
                    } else {
                        try {Thread.sleep(1000);} catch (Exception es) {}
                        label7.setText("Bilgiler hatalı!! Tekrar Deneyin");
                    }

                } catch (Exception e1) {

                    e1.printStackTrace();
                }
            }

        });

        // textfield ve passwordfield verilerini temizleyecek.
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(null);
                textField2.setText(null);
                textField3.setText(null);
                passwordField.setText(null);
                passwordField2.setText(null);
            }

        });

        // giriş ekranına gönderecek
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nesnGirisFrame.main(args);
                frame.setVisible(false);
            }

        });

        frame.add(button3);
        frame.add(button2);
        frame.add(button);
        frame.add(textField3);
        frame.add(textField2);
        frame.add(passwordField2);
        frame.add(passwordField);
        frame.add(textField);
        frame.add(label7);
        frame.add(label6);
        frame.add(label5);
        frame.add(label4);
        frame.add(label3);
        frame.add(label2);
        frame.add(label);
        frame.add(table);
        frame.getContentPane().setBackground(Color.decode("#788085"));
        frame.setSize(1000, 680);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
