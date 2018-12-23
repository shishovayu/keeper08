//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package keeper.client;


import ClientServer.AccessService;
import com.caucho.hessian.client.HessianProxyFactory;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Authorization extends JFrame {
    private JTextField current = new JTextField();
    public JButton enter = new JButton("Enter");

    public void createBtn(JButton btn, int value) {
        String b = String.valueOf(value);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                current.setText(current.getText() + b);
            }
        });
    }

    public Authorization(String title)   {
        super(title);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        GridLayout grid = new GridLayout(4, 5);
        GridLayout grid1 = new GridLayout(3, 1);
        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
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
        //JButton enter = new JButton("Enter");
        final JPanel Panel_1 = new JPanel();
        Panel_1.setLayout(grid);
        this.setLayout(grid1);
        this.add(new JLabel(""));
        this.add(Panel_1, "Center");
        this.add(new JLabel(""));
        Panel_1.add(new JLabel(""));
        Panel_1.add(new JLabel(""));
        Panel_1.add(btn1);
        Panel_1.add(btn2);
        Panel_1.add(btn3);
        Panel_1.add(new JLabel("User ID"));
        Panel_1.add(tf1);
        Panel_1.add(btn4);
        Panel_1.add(btn5);
        Panel_1.add(btn6);
        Panel_1.add(new JLabel("Password"));
        Panel_1.add(tf2);
        Panel_1.add(btn7);
        Panel_1.add(btn8);
        Panel_1.add(btn9);
        Panel_1.add(new JLabel(""));
        Panel_1.add(enter);
        Panel_1.add(btn_del);
        Panel_1.add(btn0);
        Panel_1.add(btn_c);
        tf1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                Authorization.this.current = (JTextField)e.getComponent();
            }
        });
        tf2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                Authorization.this.current = (JTextField)e.getComponent();
            }
        });
        this.createBtn(btn1, 1);
        this.createBtn(btn2, 2);
        this.createBtn(btn3, 3);
        this.createBtn(btn4, 4);
        this.createBtn(btn5, 5);
        this.createBtn(btn6, 6);
        this.createBtn(btn7, 7);
        this.createBtn(btn8, 8);
        this.createBtn(btn9, 9);
        this.createBtn(btn0, 0);
        btn_del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Authorization.this.current.setText(Authorization.this.current.getText().substring(0, Authorization.this.current.getText().length() - 1));
            }
        });
        btn_c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Authorization.this.current.setText("");
            }
        });
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                //datamanager.getInstance().login(tf1.getText(), tf2.getText());


                try {
                    Hessian hessian = new Hessian();
                    boolean authorization = hessian.Hessian().login(tf1.getText(), tf2.getText());
                    //String userType = hessian.Hessian().checkUserType(tf1.getText());
                    if(authorization==true  )
                    {
                        //new Admin(userType);
                        System.out.println("OKAY");
                        dispose();

                    }
                    else System.out.println("Invalid password or login");





                     //accessService.datamanger();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }



            }

            //new Cook("keeper");

        });
        this.pack();
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }
}
