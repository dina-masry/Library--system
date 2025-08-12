package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManagerWindow extends JFrame {
    Color lightBlue = new Color(62, 119, 185);
    Color darkBlue = new Color(5, 5, 78);
    Color transparentLightBlue = new Color(209, 232, 240);

    public ManagerWindow() {

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

        //////////////////////// JPanel 1 ////////////////////////
        JPanel panel = new JPanel();
        panel.setLayout(null);

        //////////////////////// Manager Window Logo Label /////////////////////
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("C:\\Users\\hp 450 G7\\IdeaProjects\\FinalProject\\src\\Images\\logo100.png"));
        imageLabel.setBounds(5, 0, 100, 80);
        panel.add(imageLabel);

        //////////////////////// Manager Window Text Label /////////////////////
        JLabel label_manager_window = new JLabel("Manager Window");
        label_manager_window.setBounds(110, 10, 125, 40);
        label_manager_window.setForeground(darkBlue);
        label_manager_window.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        panel.add(label_manager_window);

        //////////////////////// Exit Label /////////////////////
        JLabel close = new JLabel("x");
        close.setBounds(930, 0, 55, 30);
        close.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        close.setForeground(lightBlue);
        panel.add(close);

        mouseClick(close, "close");
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 960, 80);
        container.add(panel);

        //////////////////////// Department Panel ////////////////////////
        JPanel department = new JPanel();
        department.setBackground(lightBlue);
        deparmentCode(department);

        //////////////////////// Books Panel ////////////////////////
        JPanel books = new JPanel();
        books.setBackground(lightBlue);
        booksCode(books);

        //////////////////////// Customer Panel ////////////////////////
        JPanel customer = new JPanel();
        customer.setBackground(lightBlue);
        customerCode(customer);

        //////////////////////// JTabbed Pane ////////////////////////
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Department", department);
        tabbedPane.addTab("Books", books);
        tabbedPane.addTab("Customer", customer);
        tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 12));
        tabbedPane.setForeground(Color.BLACK);
        tabbedPane.setBounds(50, 85, 870, 470);

        container.add(tabbedPane);

        //////////////////////// Super Stuff /////////////////////
        super.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, lightBlue));
        super.setSize(960, 595);//الوالد الاول بنحطله بوردر ونوعه ماتي
        super.setUndecorated(true);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    private void deparmentCode(JPanel panel) {
        panel.setLayout(null);
        //////////////////////// Department List Label/////////////////////
        JLabel departmentListJLabel = new JLabel("Department List");
        departmentListJLabel.setForeground(Color.WHITE);
        departmentListJLabel.setBounds(20, 35, 240, 35);
        departmentListJLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.add(departmentListJLabel);

//////////////////////// Department List JList /////////////////////
//       String name[]= { " a ", "b" , "c","d"};
        JList departmentList = new JList();
        departmentList.setBounds(20, 70, 240, 280);
        panel.add(departmentList);

        //////////////////////// Department Name Label/////////////////////
        JLabel departmentNameJLabel = new JLabel("Deparment Name :", SwingConstants.RIGHT);//بتخلي المحتويات عاليمين
        departmentNameJLabel.setForeground(Color.WHITE);
        departmentNameJLabel.setBounds(290, 70, 130, 35);
        departmentNameJLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.add(departmentNameJLabel);

        //////////////////////// Department Name TextField/////////////////////
        JTextField departmentNameJTextField = new JTextField();
        departmentNameJTextField.setBounds(430, 70, 350, 35);
        departmentNameJTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        departmentNameJTextField.setEditable(false);
        panel.add(departmentNameJTextField);

        //////////////////////// Department Description Label/////////////////////
        JLabel departmentDescJLabel = new JLabel("Descritopn :", SwingConstants.RIGHT);
        departmentDescJLabel.setForeground(Color.WHITE);
        departmentDescJLabel.setBounds(290, 125, 130, 35);
        departmentDescJLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.add(departmentDescJLabel);

        //////////////////////// Department Description TextField/////////////////////
        JTextArea departmentDescJTextArea = new JTextArea();
        departmentDescJTextArea.setBounds(430, 125, 350, 225);
        departmentDescJTextArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
        departmentDescJTextArea.setEditable(false);
        panel.add(departmentDescJTextArea);

        //////////////////////// Buttons /////////////////////
        JButton newDeparmentButton = new JButton("Add New Department");
        newDeparmentButton.setBounds(300, 380, 200, 40);
        newDeparmentButton.setForeground(darkBlue);
        newDeparmentButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.add(newDeparmentButton);

        mouseClick(newDeparmentButton, "Add New Department");

    }

    private void booksCode(JPanel panel) {
        panel.setLayout(null);
        //////////////////////// Book List Label/////////////////////
        JLabel booksListJLabel = new JLabel("Books List");
        booksListJLabel.setForeground(Color.WHITE);
        booksListJLabel.setBounds(20, 35, 350, 35);
        booksListJLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.add(booksListJLabel);

        //////////////////////// Book List JList /////////////////////
        JList booksList = new JList();
        booksList.setBounds(20, 70, 350, 280);
        panel.add(booksList);

        //////////////////////// Book Name /////////////////////
        labelAndTextField("Book", "textField", "Book Name :", 400, 70, 350, panel);
        //////////////////////// Book Price /////////////////////
        labelAndTextField("Book", "textField", "Price :", 400, 110, 150, panel);
        //////////////////////// Book No. Copies /////////////////////
        labelAndTextField("Book", "textField", "No. Copies :", 400, 155, 150, panel);
        //////////////////////// Book Department /////////////////////
        labelAndTextField("Book", "comboBox", "Department :", 400, 200, 200, panel);
        //////////////////////// Book Auther /////////////////////
        labelAndTextField("Book", "textField", "Auther :", 400, 245, 350, panel);
        //////////////////////// Book ISBN /////////////////////
        labelAndTextField("Book", "textField", "ISBN :", 400, 290, 350, panel);

        //////////////////////// Buttons /////////////////////
        JButton newBookButton = new JButton("New Book");
        newBookButton.setBounds(370, 380, 150, 40);
        newBookButton.setForeground(darkBlue);
        newBookButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.add(newBookButton);

        mouseClick(newBookButton, "New Book");

    }

    private void customerCode(JPanel panel) {
        panel.setLayout(null);
        //////////////////////// Customer List Label/////////////////////
        JLabel customerListJLabel = new JLabel("Customer List");
        customerListJLabel.setForeground(Color.WHITE);
        customerListJLabel.setBounds(20, 35, 240, 35);
        customerListJLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.add(customerListJLabel);

        //////////////////////// Csutomer List JList /////////////////////
        JList customerList = new JList();
        customerList.setBounds(20, 70, 240, 280);
        panel.add(customerList);

        //////////////////////// Customer ID /////////////////////
        labelAndTextField("Customer", "textField", "Customer ID :", 300, 70, 200, panel);
        //////////////////////// Customer Name /////////////////////
        labelAndTextField("Customer", "textField", "Customer Name :", 300, 115, 350, panel);
        //////////////////////// Customer Address /////////////////////
        labelAndTextField("Customer", "textField", "Address :", 300, 160, 350, panel);
        //////////////////////// Customer User Name /////////////////////
        labelAndTextField("Customer", "textField", "User Name :", 300, 205, 200, panel);
        //////////////////////// Customer Password /////////////////////
        labelAndTextField("Customer", "textField", "Password :", 300, 250, 200, panel);

        //////////////////////// Buttons /////////////////////
        JButton newCustomerButton = new JButton("New Customer");
        newCustomerButton.setBounds(300, 380, 150, 40);
        newCustomerButton.setForeground(darkBlue);
        newCustomerButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.add(newCustomerButton);

        mouseClick(newCustomerButton, "New Customer");
    }

    private void labelAndTextField(String panelName, String type, String labelName, int x, int y, int itemwidth, JPanel panel) {
        JLabel label = new JLabel(labelName, SwingConstants.RIGHT);
        label.setForeground(Color.WHITE);
        if (panelName.equals("Customer")) {
            label.setBounds(x, y, 120, 35);
        } else {
            label.setBounds(x, y, 90, 35);
        }
        label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        panel.add(label);

        switch (type) {
            case "textField":
                JTextField jTextField = new JTextField();
                if (panelName.equals("Customer")) {
                    jTextField.setBounds(x + 135, y, itemwidth, 35);
                } else {
                    jTextField.setBounds(x + 105, y, itemwidth, 35);
                }
                jTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
                jTextField.setEditable(false);
                panel.add(jTextField);
                break;
            case "comboBox":
                String[] values = {"Adminsration", "Cataloging", "Circulation/access service",
                        "Digital Collection", "Goverment document"};
                JComboBox comboBox = new JComboBox(values);
                comboBox.setBounds(x + 105, y, itemwidth, 35);
                comboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
                comboBox.setEditable(false);
                panel.add(comboBox);
                break;
            default:
                System.out.println("nothing !!!!!!");
        }

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
                    case "Add New Department" -> {
                       // new Department();
                    }
                    case "New Book" -> {
                       // new Book();
                    }
                    case "New Customer" -> {
                        System.out.println("new customer!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        break;
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
