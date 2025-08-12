package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class mainWindow extends JFrame{
        Color lightBlue = new Color(62, 119, 185);
        Color darkBlue = new Color(5, 5, 78);
        Color transparentLightBlue = new Color(209, 232, 240);
    public mainWindow() {
            Container container = super.getContentPane();
            container.setLayout(null);

            //////////////////////// JPanel 1 ////////////////////////
            JPanel panel = new JPanel();
            panel.setLayout(null);

            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(new ImageIcon("C:\\Users\\hp 450 G7\\IdeaProjects\\FinalProject\\src\\Images\\logo.png"));
            imageLabel.setBounds(50, 50, 170, 80);
            panel.add(imageLabel);

            JLabel label_welcome = new JLabel("Welcome to our library");
            label_welcome.setBounds(240, 50, 400, 40);
            label_welcome.setForeground(Color.WHITE);
            label_welcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
            panel.add(label_welcome);

            JLabel label_happy = new JLabel("we are happy when join us ^_^");
            label_happy.setBounds(250, 100, 400, 40);
            label_happy.setForeground(Color.WHITE);
            label_happy.setFont(new Font("Segoe Print", Font.ITALIC, 16));
            panel.add(label_happy);

            JLabel close = new JLabel("x");
            close.setBounds(940, 0, 50, 25);
            close.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
            close.setForeground(Color.WHITE);
            panel.add(close);
            mouseClick(close, "close");
            panel.setBackground(lightBlue);
            panel.setBounds(0, 0, 960, 150);
            container.add(panel);

            //////////////////////// JPanel 2 ////////////////////////
            JPanel panel2 = new JPanel();
            panel2.setLayout(null);

            //////////////////////// JPanel 3 ////////////////////////
            JPanel panel3 = new JPanel();
            panel3.setBounds(100, 40, 120, 120);
            panel3.setBackground(new Color(250, 250, 250));
            panel3.setBorder(BorderFactory.createLineBorder(lightBlue));
            //Manger
            JLabel managerImage = new JLabel();
            managerImage.setIcon(new ImageIcon("C:\\Users\\hp 450 G7\\IdeaProjects\\FinalProject\\src\\Images\\manager.png"));

            panel3.add(managerImage);

            JLabel managerLabel = new JLabel("Manager");
            managerLabel.setForeground(lightBlue);
            managerLabel.setBackground(new Color(250, 250, 250));
            managerLabel.setOpaque(true);
            panel3.add(managerLabel);
            panel2.add(panel3);
            mouseClick(panel3, "manager");
            //////////////////////// JPanel 4 ////////////////////////
            JPanel panel4 = new JPanel();
            panel4.setBounds(100, 180, 120, 120);
            panel4.setBackground(new Color(250, 250, 250));
            panel4.setBorder(BorderFactory.createLineBorder(lightBlue));
            // Customer
            JLabel customerImage = new JLabel();
            customerImage.setIcon(new ImageIcon("C:\\Users\\hp 450 G7\\IdeaProjects\\FinalProject\\src\\Images\\clients.png"));
            panel4.add(customerImage);
            JLabel customerLabel = new JLabel("Customer");
            customerLabel.setForeground(lightBlue);
            customerLabel.setBackground(new Color(250, 250, 250));
            customerLabel.setOpaque(true);//بتخلي العنصر خاص في اللون مش تابع للون الخلفية
            panel4.add(customerLabel);

            panel2.add(panel4);

            mouseClick(panel4, "customer");

            //////////////////////// JPanel 2 Background Image ////////////////////////
            JLabel imagebodyLabel = new JLabel();
            imagebodyLabel.setIcon(new ImageIcon("C:\\Users\\hp 450 G7\\IdeaProjects\\FinalProject\\src\\Images\\7759.png"));
            imagebodyLabel.setBounds(0, 0, 960, 455);
            panel2.add(imagebodyLabel);

            panel2.setBounds(0, 145, 960, 455);
            container.add(panel2);
            //////////////////////// Super Stuff /////////////////////

            super.setSize(960, 595);
            super.setUndecorated(true);// بتخليني بس اعتمد الزر مش 3 ازرار للجي فريم
            super.setLocationRelativeTo(null); // بتخلي الشاشة في النص
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
                        case "close" -> { // طريقة محدثة للسويتش بدون بريك
                            System.out.println("Closed");
                            dispose(); // اطفي الفريم
                            System.out.println("Closed!!");
                            System.exit(0);
                        }
                        case "manager" -> {
                            System.out.println("clicked manager!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            new ManagerLogin();
//                            dispose();
                        }
                        case "customer" -> {
                            System.out.println("clicked customer!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        }
                        default ->{
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
    public static void main(String[] args) {
        new mainWindow();
    }
}
