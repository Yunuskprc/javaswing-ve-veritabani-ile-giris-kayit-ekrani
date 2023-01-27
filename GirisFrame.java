import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GirisFrame {

    static String kadi,sifre;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TWOXBET");

        JTable table = new JTable();
        table.setBounds(100, 100, 650, 350);
        table.setBackground(Color.decode("#96a0a6"));

        JLabel label = new JLabel("LOGİN PAGE");
        label.setBounds(375, 120, 120, 25);
        label.setFont(new Font("Calibri", Font.BOLD, 22));

        JLabel label2 = new JLabel("Kullanıcı Adı: ");
        label2.setBounds(190, 200, 120, 25);
        label2.setFont(new Font("Calibri", Font.BOLD, 20));

        JLabel label3 = new JLabel("Şifre: ");
        label3.setBounds(255, 250, 80, 25);
        label3.setFont(new Font("Calibri", Font.BOLD, 20));

        JTextField textField = new JTextField();
        textField.setBounds(330, 200, 240, 25);
        textField.setBackground(Color.decode("#Bec5c7"));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(330, 250, 240, 25);
        passwordField.setBackground(Color.decode("#Bec5c7"));

        JLabel label4 = new JLabel();
        label4.setText("Kullanıcı adı veya şifre hatalı");
        label4.setBounds(350, 290, 220, 25);
        label4.setFont(new Font("Calibri", Font.BOLD, 15));
        label4.setVisible(false);

        JButton button = new JButton("Giriş");
        button.setBounds(330, 340, 80, 40);
        button.setBackground(Color.decode("#F1f0ef"));
        button.setFont(new Font("Calibri", Font.BOLD, 20));

        JButton button2 = new JButton("Kayıt Ol");
        button2.setBounds(440, 340, 100, 40);
        button2.setBackground(Color.decode("#F1f0ef"));
        button2.setFont(new Font("Calibri", Font.BOLD, 20));


        
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                kadi = textField.getText();
                sifre = passwordField.getText();
                GirisSorgulama nGirisSorgulama = new GirisSorgulama();
                try {

                    if(nGirisSorgulama.sorgulama(kadi, sifre))
                    {
                        try {Thread.sleep(1000);} catch (Exception es) {}
                        label4.setText("Giriş Başarılı");
                        kadi="";
                        sifre="";
                    }
                    else
                    {
                        try {Thread.sleep(1000);} catch (Exception es) {}   
                        label4.setText("Kayıt Bulunamadı!! Tekrar Deneyin");
                        kadi="";
                        sifre="";
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                label4.setVisible(true);
            }
            
        });


        button2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                kayitOlFrame nKayitOlFrame = new kayitOlFrame();
                nKayitOlFrame.main(args);
                frame.setVisible(false);
            }

        });

        

        frame.add(button2);
        frame.add(button);
        frame.add(label4);
        frame.add(passwordField);
        frame.add(textField);
        frame.add(label3);
        frame.add(label2);
        frame.add(label);
        frame.add(table);
        frame.getContentPane().setBackground(Color.decode("#788085"));
        frame.setSize(900, 600);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
