package com.company;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class UpdateBook extends JFrame {

    Color lightBlue = new Color(62, 119, 185);
    Color darkBlue = new Color(5, 5, 78);
    Color transparentLightBlue = new Color(209, 232, 240);

    JTextField[] booksComponents = new JTextField[5];

    public UpdateBook(Book book) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Error Message: " + e);
        }

        //////////////////////// Container /////////////////////
        Container container = super.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        JLabel updateBookLabel = new JLabel("Update Book");
        updateBookLabel.setBounds(180, 10, 400, 40);
        updateBookLabel.setForeground(darkBlue);
        updateBookLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        container.add(updateBookLabel);

        JLabel close = new JLabel("x");
        close.setBounds(510, 10, 50, 25);
        close.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        close.setForeground(lightBlue);
        container.add(close);

        mouseClick(close, "close");

        //////////////////////// Book Components /////////////////////
        for (int i = 0; i < booksComponents.length; i++) {
            booksComponents[i] = new JTextField();
        }
        //////////////////////// Book Name /////////////////////
        labelAndTextField(booksComponents[0], "Book Name :", 20, 70, 350, container);
        //////////////////////// Book Price /////////////////////
        labelAndTextField(booksComponents[1], "Price :", 20, 115, 150, container);
        //////////////////////// Book No. Copies /////////////////////
        labelAndTextField(booksComponents[2], "No. Copies :", 20, 160, 150, container);
        //////////////////////// Book Auther /////////////////////
        labelAndTextField(booksComponents[3], "Auther :", 20, 200, 350, container);
        //////////////////////// Book ISBN /////////////////////
        labelAndTextField(booksComponents[4], "ISBN :", 20, 245, 350, container);
        //////////////////////// Book Department /////////////////////
        JLabel label = new JLabel("Department :", SwingConstants.RIGHT);
        label.setForeground(lightBlue);
        label.setBounds(20, 290, 90, 35);
        label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        container.add(label);

        String[] values = {"Adminsration", "Cataloging", "Circulation/access service",
                "Digital Collection", "Goverment document"};
        JComboBox bookComboBox = new JComboBox(values);
        bookComboBox.setBounds(125, 290, 200, 35);
        bookComboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
        bookComboBox.setEnabled(false);
        container.add(bookComboBox);

        booksComponents[0].setText(book.getBookName());
        booksComponents[1].setText(book.getPrice());
        booksComponents[2].setText(book.getNoCopies());
        booksComponents[3].setText(book.getAuther());
        booksComponents[4].setText(book.getIsbn());
        bookComboBox.setSelectedItem(book.getDepartment());
        //////////////////////// Buttons /////////////////////
        JButton updateBookButton = new JButton("Update Book");
        updateBookButton.setBounds(50, 410, 200, 40);
        updateBookButton.setForeground(darkBlue);
        updateBookButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        container.add(updateBookButton);

        mouseClick(updateBookButton, "Update Book");

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(280, 410, 200, 40);
        cancel.setForeground(darkBlue);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        container.add(cancel);

        mouseClick(cancel, "Cancel");

        super.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, darkBlue));
        super.setSize(550, 500);
        super.setUndecorated(true);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    private void labelAndTextField(JTextField jTextField, String labelName, int x, int y, int itemwidth, Container container) {
        JLabel label = new JLabel(labelName, SwingConstants.RIGHT);
        label.setForeground(lightBlue);
        label.setBounds(x, y, 90, 35);
        label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        container.add(label);
        if (labelName.equals("Price :")) {
            JLabel updateBookLabel = new JLabel("$");
            updateBookLabel.setBounds(x + 265, y, 50, 40);
            updateBookLabel.setForeground(lightBlue);
            updateBookLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            container.add(updateBookLabel);
        }

        jTextField.setBounds(x + 105, y, itemwidth, 35);
        jTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jTextField.setForeground(darkBlue);
        container.add(jTextField);
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
                        System.out.println("Closed");
                        dispose();
//                        System.out.println("Closed!!");
//                        System.exit(0);
                    }
                    case "Update Book" -> {
                        System.out.println("Hi");
//                    new Book();
                    }
                    case "Cancel" -> {
                        System.out.println("clicked customer!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        dispose();
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
