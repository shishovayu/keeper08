package serv;// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import keeper.api.Position;
import keeper.api.User;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.Serializable;
import java.sql.*;

public class datamanager {
    private static datamanager instance;


    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private datamanager() {
    }

    public static datamanager getInstance() {
        if (instance == null) {
            instance = new datamanager();
        }

        return instance;
    }


    public DefaultMutableTreeNode getNodes (DefaultMutableTreeNode node, String position)  {


        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/keeper", "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT position_name\n" +
                    "  FROM public.\"Position\"" + " WHERE type_1 =" + "\'"+position+"\'");

            node = new DefaultMutableTreeNode(position);

            while (resultSet.next()) {
                String str = resultSet.getString("position_name");

                node.add(new DefaultMutableTreeNode(str));
            }
        }
        catch (ClassNotFoundException e) {
        e.printStackTrace();
        } catch (SQLException e) {
        e.printStackTrace();
    }
        return node;

    }
//    public JTree getNodes (String position) throws SQLException {
//        DefaultMutableTreeNode menu = new DefaultMutableTreeNode("MENU");
//        DefaultMutableTreeNode kitchen = new DefaultMutableTreeNode("KITCEN");
//        DefaultMutableTreeNode bar = new DefaultMutableTreeNode("BAR");
//        JTree tree = new JTree(menu);
//        menu.add(kitchen);
//        menu.add(bar);
//
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/keeper", "postgres", "postgres");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT position_name\n" +
//                    "  FROM public.\"Position\"" + " WHERE type_1 =" + "\'" + position + "\'");
//
//            while (resultSet.next()) {
//                //DefaultMutableTreeNode url = new DefaultMutableTreeNode(resultSet.getString("colNode"));
//                //mutableTreeNode.add(url);
//                 kitchen.add(new DefaultMutableTreeNode(resultSet.getString("position_name")));
//                //System.out.println(resultSet.getString("position_name"));
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return tree;
//    }

    public boolean login(String login, String password) throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/keeper", "postgres", "postgres");
            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(String.format("SELECT \"login\", \"password\"  FROM public.\"User\"WHERE login= '%s' and 'password='%s'", login, password));
            ResultSet resultSet = statement.executeQuery("SELECT login, password  FROM public.\"User\"" +
                    " WHERE login =" + "\'" + login + "\'" + " and password = " + "\'" + password + "\'");
            if (resultSet.next()) {
                System.out.println("Successfully");
                return true;
            } else {
                System.out.println("Invalid password or login");
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public String checkUser(String login) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/keeper", "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT user_type\n" +
                    "  FROM public.\"User\"" + " WHERE login =" + "\'" + login + "\'");
            if (resultSet.next()) {
                String str = resultSet.getString("user_type");

                return str;
            }
            //else return "No users";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "No users";

    }


    public void createUser(User user) throws SQLException {

        int userID = user.getUserID();
        String login = user.getLogin();
        String password = user.getPassword();
        String position = user.getPosition();

        String sql = "INSERT INTO public.\"User\"\n" +
                "            user_id, user_type, login, password)" + "VALUES (" + userID + ", '" + position + "', '" + login + "', '" + password + "');";
        connectionManager.getInstance().insert(sql);
    }



    public void updateUsers(User user) {
    }

    public void deleteUsers(User user) {
    }

    public void createPosition(Position position) throws SQLException {
        int id = position.getPosition_id();
        String name = position.getPosition_name();
        int price = position.getPrice();
    }

    public void updatePosition(Position position) {
    }

    public void deletePosition(Position position) {
    }
}
