package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;

public class ManagerLogin extends JFrame {

    Color lightBlue = new Color(62, 119, 185);
    Color darkBlue = new Color(5, 5, 78);
    Color transparentLightBlue = new Color(209, 232, 240);

    JTextField usernameField, passwordField;
    public ManagerLogin() {

        //////////////////////// UI Manager Look and Feel ////////////////////////
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Error Message: " + e);
        }

        //////////////////////// Container ////////////////////////
        Container container = super.getContentPane();
        container.setLayout(null);

        //////////////////////// JPanel 1 ////////////////////////
        JPanel panel = new JPanel();
        panel.setLayout(null);

        //////////////////////// Exit Label /////////////////////
        JLabel close = new JLabel("x");
        close.setBounds(580, 0, 50, 25);
        close.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        close.setForeground(Color.WHITE);
        panel.add(close);

        mouseClick(close, "close");

        //////////////////////// Manager Login Label /////////////////////
        JLabel managerLoginJLabel = new JLabel("Manager Login");
        managerLoginJLabel.setForeground(Color.WHITE);
        managerLoginJLabel.setBounds(230, 85, 175, 50);
        managerLoginJLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        panel.add(managerLoginJLabel);

        //////////////////////// Username /////////////////////
        JLabel usernameJLabel = new JLabel("User Name :");
        usernameJLabel.setForeground(Color.WHITE);
        usernameJLabel.setBounds(120, 165, 100, 35);
        usernameJLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel.add(usernameJLabel);

        usernameField = new JTextField();
        usernameField.setBounds(210, 165, 250, 35);
        usernameField.setFont(new Font("Adobe Devanagari", Font.BOLD, 16));
        usernameField.setForeground(darkBlue);
        panel.add(usernameField);

        //////////////////////// Password /////////////////////
        JLabel passwordJLabel = new JLabel("Password :");

        passwordJLabel.setForeground(Color.WHITE);
        passwordJLabel.setBounds(120, 220, 100, 35);
        passwordJLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel.add(passwordJLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 220, 250, 35);
        passwordField.setFont(new Font("Adobe Devanagari", Font.BOLD, 16));
        passwordField.setForeground(darkBlue);
        panel.add(passwordField);

        //////////////////////// Buttons /////////////////////
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(170, 310, 120, 40);
        loginButton.setForeground(lightBlue);
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel.add(loginButton);

        mouseClick(loginButton, "login");

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(340, 310, 120, 40);
        cancelButton.setForeground(lightBlue);
        cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel.add(cancelButton);

        mouseClick(cancelButton, "cancel");

        //////////////////////// panel /////////////////////
        panel.setBackground(lightBlue);
        panel.setBorder(new BevelBorder(BevelBorder.RAISED));
        panel.setBounds(0, 0, 600, 450);
        container.add(panel);
        //////////////////////// Super Stuff /////////////////////

        super.setSize(600, 450);
        super.setUndecorated(true);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    private void mouseClick(JComponent item, String itemName) {
        item.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                switch (itemName) {
                    case "close" -> {
                        new mainWindow();
                    }
                    case "login" -> {
                        System.out.println("logged in !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        String user = usernameField.getText().trim();
                        String password = passwordField.getText().trim();

                        if (user.equals("123") && password.equals("123")) {
                            new ManagerWindow();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect username or password try again.", "Invalid Data!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case "cancel" -> {
                        System.out.println("canceled !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        dispose();
                        new mainWindow();
                    }
                    default -> {
                        System.out.println("nothing!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}
