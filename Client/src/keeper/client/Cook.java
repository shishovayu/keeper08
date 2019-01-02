//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package keeper.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Cook extends JFrame {
    public static void main(String[] args) {
        new Cook("r_keeper: Cook");
    }

//    public void createTree(ResultSet r, DefaultMutableTreeNode p,
//                           int l) throws Exception {
//
//    }

    public Cook(String title)  {
        super(title);
        this.setDefaultCloseOperation(3);


        JSplitPane split = new JSplitPane(1);
        split.setOneTouchExpandable(true);
        split.setDividerLocation(150);
        Dimension minimumSize = new Dimension(100, 50);
        //treeScrollPane1.setMinimumSize(minimumSize);
        //treeScrollPane2.setMinimumSize(minimumSize);
        split.setPreferredSize(new Dimension(400, 200));
        JPanel leftPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        split.setLeftComponent(leftPanel);
        split.setRightComponent(rightPanel);
        leftPanel.setLayout(new BorderLayout());

        Hessian hessian = new Hessian();
//        DefaultMutableTreeNode menu = new DefaultMutableTreeNode("MENU");
//        DefaultMutableTreeNode kitchen = new DefaultMutableTreeNode("KITCHEN");
//        DefaultMutableTreeNode bar = new DefaultMutableTreeNode("BAR");
//        JTree tree = new JTree(menu);
//        menu.add(kitchen);
//        menu.add(bar);
//        kitchen.add(new DefaultMutableTreeNode(hessian.Hessian().getPositionType("kitchen")));

//        String str = null;
//        try {
//            Hessian hessian = new Hessian();
//           // hessian.Hessian().getPositionType("kitchen");
//            //kitchen.add(new DefaultMutableTreeNode(str));
//            JTree tree = hessian.Hessian().getTree("kitchen");
//            leftPanel.add(tree);
//            System.out.println(hessian.Hessian().getTree("kitchen"));
//
//
//        } catch (IOException | SQLException e1) {
//            e1.printStackTrace();
//        }


        DefaultMutableTreeNode menu = new DefaultMutableTreeNode("MENU");
        DefaultMutableTreeNode kitchen = new DefaultMutableTreeNode("KITCHEN");
        DefaultMutableTreeNode bar = new DefaultMutableTreeNode("BAR");
        JTree tree = new JTree(menu);
        //menu.add(kitchen);

        try {
            kitchen = hessian.Hessian().getNodes(kitchen, "kitchen");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bar = hessian.Hessian().getNodes(bar, "bar");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        menu.add(kitchen);
        menu.add(bar);


//        try {
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/keeper", "postgres", "postgres");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT position_name\n" +
//                    "  FROM public.\"Position\"" + " WHERE type_1 =" + "\'kitchen\'");
//
//            while (resultSet.next()) {
//                //DefaultMutableTreeNode url = new DefaultMutableTreeNode(resultSet.getString("colNode"));
//                //mutableTreeNode.add(url);
//                kitchen.add(new DefaultMutableTreeNode(resultSet.getString("position_name")));
//            }
//        }
//        catch (
//                SQLException e) {
//            e.printStackTrace();
//    }

       // Tree tree = new Tree();

        leftPanel.add(tree);
        leftPanel.add(bottomPanel, "South");
        bottomPanel.setLayout(new BorderLayout());
        JButton btn1 = new JButton("order 1");
        JButton btn2 = new JButton("order 2");
        JButton btn3 = new JButton("order 3");
        rightPanel.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, 1));
        new JPanel();
        rightPanel.add((new JPanel()).add(new JLabel("ORDERS")), "North");
        rightPanel.add(centerPanel, "Center");
        centerPanel.add(btn1);
        centerPanel.add(btn2);
        centerPanel.add(btn3);
        btn1.setAlignmentX(0.5F);
        btn2.setAlignmentX(0.5F);
        btn3.setAlignmentX(0.5F);
        rightPanel.add(new JButton("OUT"), "South");
        add(split);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
//    public void tree() throws IOException {
//        Hessian hessian = new Hessian();
//        DefaultMutableTreeNode menu = new DefaultMutableTreeNode("MENU");
//        DefaultMutableTreeNode kitchen = new DefaultMutableTreeNode("KITCEN");
//        DefaultMutableTreeNode bar = new DefaultMutableTreeNode("BAR");
//        JTree tree = new JTree(menu);
//        menu.add(kitchen);
//        menu.add(bar);
//
//        String str = hessian.Hessian().getPositionType("Kitchen");
//        DefaultMutableTreeNode possition2 = new DefaultMutableTreeNode(str);
//        kitchen.add(possition2);
//
//
//    }
}
