//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package keeper.client;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Cook extends JFrame {
//    public static void main(String[] args) {
//        new Cook("r_keeper: Cook");
//    }


    public Cook(String title)  {
        super(title);
        this.setDefaultCloseOperation(3);

        JSplitPane split = new JSplitPane(1);
        split.setOneTouchExpandable(true);
        split.setDividerLocation(150);
        split.setPreferredSize(new Dimension(400,200));
        JPanel leftPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        split.setLeftComponent(leftPanel);
        split.setRightComponent(rightPanel);
        leftPanel.setLayout(new BorderLayout());

        Hessian hessian = new Hessian();


        DefaultMutableTreeNode menu = new DefaultMutableTreeNode("MENU");
        DefaultMutableTreeNode kitchen = new DefaultMutableTreeNode("KITCHEN");
        DefaultMutableTreeNode bar = new DefaultMutableTreeNode("BAR");
        JTree tree = new JTree(menu);

        try {
            ArrayList nodeList;
            nodeList = hessian.Hessian().getNodes("kitchen");
            for(int i = 0; i<nodeList.size(); i++){
                kitchen.add(new DefaultMutableTreeNode(nodeList.get(i)));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList nodeList;
            nodeList = hessian.Hessian().getNodes("bar");
            for(int i = 0; i<nodeList.size(); i++){
                bar.add(new DefaultMutableTreeNode(nodeList.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        menu.add(kitchen);
        menu.add(bar);


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
}
