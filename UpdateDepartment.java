package com.company;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class UpdateDepartment extends JFrame {

    Color lightBlue = new Color(62, 119, 185);
    Color darkBlue = new Color(5, 5, 78);
    Color transparentLightBlue = new Color(209, 232, 240);

    public UpdateDepartment(Department department) {

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

        JLabel updateDepartmentLabel = new JLabel("Update Department");
        updateDepartmentLabel.setBounds(180, 10, 400, 40);
        updateDepartmentLabel.setForeground(darkBlue);
        updateDepartmentLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        container.add(updateDepartmentLabel);

        JLabel close = new JLabel("x");
        close.setBounds(510, 10, 50, 25);
        close.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        close.setForeground(lightBlue);
        container.add(close);

        mouseClick(close, "close");
        //////////////////////// Department Name Label/////////////////////
        JLabel departmentNameJLabel = new JLabel("Name :");
        departmentNameJLabel.setForeground(lightBlue);
        departmentNameJLabel.setBounds(50, 100, 100, 35);
        departmentNameJLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        container.add(departmentNameJLabel);

        //////////////////////// Department Name TextField/////////////////////
        JTextField departmentNameJTextField = new JTextField();
        departmentNameJTextField.setBounds(150, 100, 320, 35);
        departmentNameJTextField.setForeground(darkBlue);
        departmentNameJTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        departmentNameJTextField.setText(department.getName());
        container.add(departmentNameJTextField);

        //////////////////////// Department Description Label/////////////////////
        JLabel departmentDescJLabel = new JLabel("Descritopn :");
        departmentDescJLabel.setForeground(lightBlue);
        departmentDescJLabel.setBounds(50, 155, 100, 35);
        departmentDescJLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        container.add(departmentDescJLabel);

        //////////////////////// Department Description TextField/////////////////////
        JTextArea departmentDescJTextArea = new JTextArea();
        departmentDescJTextArea.setBounds(50, 200, 420, 225);
        departmentDescJTextArea.setForeground(darkBlue);
        departmentDescJTextArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
        departmentDescJTextArea.setText(department.getDescription());
        container.add(departmentDescJTextArea);

        //////////////////////// Buttons /////////////////////
        JButton updateDeparmentButton = new JButton("Update Department");
        updateDeparmentButton.setBounds(50, 460, 200, 40);
        updateDeparmentButton.setForeground(darkBlue);
        updateDeparmentButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        container.add(updateDeparmentButton);

        mouseClick(updateDeparmentButton, "Update Department");

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(280, 460, 200, 40);
        cancel.setForeground(darkBlue);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        container.add(cancel);

        mouseClick(cancel, "Cancel");

        super.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, darkBlue));
        super.setSize(550, 550);
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
                        System.out.println("Closed");
                        dispose();
//                        System.out.println("Closed!!");
//                        System.exit(0);
                    }
                    case "Update Department" -> {
                        System.out.println("clicked manager!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            new UpdateDepartment(new Department());
//                       new ManagerLogin();
//                        dispose();
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
