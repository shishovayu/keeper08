//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package keeper.client;

import ClientServer.AccessService;
import keeper.api.User;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.io.IOException;
import java.sql.*;

public class Admin extends JFrame {
    private JTextField current = new JTextField();

//    public static void main(String[] args) {
//        new Admin("keeper: Admin");
//    }

    public void createBtn(JButton btn, int value) {
        final String b = String.valueOf(value);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current.setText(current.getText() + b);
            }
        });
    }

    public void addPersonal() {
        JSplitPane split = new JSplitPane(1);
        split.setOneTouchExpandable(true);
        split.setDividerLocation(150);
        JPanel leftPanel = new JPanel();
        split.setLeftComponent(leftPanel);
        JLabel testLabel = new JLabel("tree should be here");
        leftPanel.add(testLabel);
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(6, 5));
        JTextField userID = new JTextField();
        JTextField password = new JTextField();
        JTextField login = new JTextField();
        JButton ok = new JButton("OK");
        JButton back = new JButton("BACK");
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btn0 = new JButton("0");
        JButton btn_del = new JButton("<-");
        JButton btn_c = new JButton("C");

        JComboBox type = new JComboBox();
        type.addItem("barman");
        type.addItem("waiter");
        type.addItem("cook");
        rightPanel.add(new JLabel(" "));
        rightPanel.add(type);
        rightPanel.add(new JLabel(" "));
        rightPanel.add(new JLabel(" "));
        rightPanel.add(new JLabel(" "));
        rightPanel.add(new JLabel("UserID"));
        rightPanel.add(userID);
        rightPanel.add(btn1);
        rightPanel.add(btn2);
        rightPanel.add(btn3);
        rightPanel.add(new JLabel("Login"));
        rightPanel.add(login);
        rightPanel.add(btn4);
        rightPanel.add(btn5);
        rightPanel.add(btn6);
        rightPanel.add(new JLabel("Password"));
        rightPanel.add(password);
        rightPanel.add(btn7);
        rightPanel.add(btn8);
        rightPanel.add(btn9);
        rightPanel.add(ok);
        rightPanel.add(back);
        rightPanel.add(btn_del);
        rightPanel.add(btn_c);
        rightPanel.add(new JLabel(""));
        rightPanel.add(new JLabel(""));
        split.setRightComponent(rightPanel);

        add(split);
        pack();

        userID.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                current = (JTextField) e.getComponent();
            }
        });
        password.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                current = (JTextField) e.getComponent();
            }
        });
        login.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                current = (JTextField) e.getComponent();
            }
        });
        createBtn(btn1, 1);
        createBtn(btn2, 2);
        createBtn(btn3, 3);
        createBtn(btn4, 4);
        createBtn(btn5, 5);
        createBtn(btn6, 6);
        createBtn(btn7, 7);
        createBtn(btn8, 8);
        createBtn(btn9, 9);
        createBtn(btn0, 0);

        ok.addActionListener(l -> {

            //try {

            //User user = new User();
            //int bufID = Integer.parseInt(userID.getText());
            //String bufType = type.getSelectedItem().toString();

//            user.setUserID(Integer.parseInt(userID.getText()));
//            user.setPosition(type.getSelectedItem().toString());
//            user.setPassword(password.getText());
//            user.setLogin(login.getText());

            Hessian hessian = new Hessian();
            try {
                AccessService accessService = hessian.Hessian();
                accessService.createUser(Integer.parseInt(userID.getText()), login.getText(), password.getText(), type.getSelectedItem().toString());
            } catch (IOException | SQLException e1) {
                e1.printStackTrace();
            }

            //datamanager.getInstance().createUser(user);

            // }
//            catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });

        });
    }

    public void ctrlPersonal () {
            final JSplitPane split = new JSplitPane(1);
            split.setOneTouchExpandable(true);
            split.setDividerLocation(150);
            JPanel leftPanel = new JPanel();
            split.setLeftComponent(leftPanel);
            JLabel testLabel = new JLabel("tree should be here");
            leftPanel.add(testLabel);
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BorderLayout());
            JPanel centerPanel = new JPanel();
            JPanel bottomPanel = new JPanel();
            JButton add = new JButton("ADD");
            JButton delete = new JButton("DELETE");
            JButton back = new JButton("BACK");
            JButton out = new JButton("OUT");
            centerPanel.add(add);
            centerPanel.add(delete);
            bottomPanel.add(out);
            bottomPanel.add(back);
            split.setRightComponent(rightPanel);
            rightPanel.add(new JLabel(" "), "North");
            rightPanel.add(centerPanel, "Center");
            rightPanel.add(bottomPanel, "South");
            add.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    remove(split);
                    validate();
                    repaint();
                    addPersonal();
                    validate();
                }
            });

            this.add(split);
            this.pack();
    }


    public Admin(String title) {
            super(title);
            this.setDefaultCloseOperation(3);
            JButton orders = new JButton("ORDERS");
            JButton reserve = new JButton("RESERVE");
            JButton ctrl = new JButton("CONTROL PERSONAL");
            JButton close = new JButton("CLOSE SHIFT");
            JButton menu = new JButton("EDIT MENU");
            final JSplitPane split = new JSplitPane(1);
            split.setOneTouchExpandable(true);
            split.setDividerLocation(150);
            JPanel leftPanel = new JPanel();
            JPanel topPanel = new JPanel();
            split.setLeftComponent(leftPanel);
            leftPanel.setLayout(new BorderLayout());
            leftPanel.add(topPanel, "North");
            topPanel.setLayout(new GridLayout(5, 1));
            topPanel.add(orders);
            topPanel.add(reserve);
            topPanel.add(ctrl);
            topPanel.add(close);
            topPanel.add(menu);
            JPanel rightPanel = new JPanel();
            split.setRightComponent(rightPanel);
            JLabel info = new JLabel("the ingredient x was put into stop-list");
            rightPanel.add(info);
            this.add(split);
            ctrl.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    remove(split);
                    validate();
                    repaint();
                    ctrlPersonal();
                    validate();
                }
            });
            pack();
            setVisible(true);
    }
}


