package serv;// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import keeper.api.Position;
import keeper.api.User;


import java.sql.*;

public class datamanager {
    private static datamanager instance;


    private datamanager() {
    }

    public static datamanager getInstance() {
        if (instance == null) {
            instance = new datamanager();
        }

        return instance;
    }

    public boolean login(String login, String password) {

        try {
            String sql ="SELECT login, password\n" +
                    "  FROM public.\"User\";\n";
            ResultSet resultSet = connectionManager.getInstance().select(sql);

            while (resultSet.next()) {
                if (login.equals(resultSet.getString("login"))) {
                    if (password.equals(resultSet.getString("password"))) {
                        System.out.println("вход выполнен");
                        return true;
                    }
                    else System.out.println("Invalid password or login");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return true;

    }

    public String checkUser(String login) {

        try {
            String sql ="SELECT login, user_type\n" +
                    "  FROM public.\"User\";\n";
            ResultSet resultSet = connectionManager.getInstance().select(sql);
            while (resultSet.next()) {
                if (login.equals(resultSet.getString("login"))) {
                    return resultSet.getString("user_type");
                }
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

        String sql ="INSERT INTO public.\"User\"(\n" +
                "            user_id, user_type, login, password)" + "VALUES ("+userID+", '"+position+"', '"+login+"', '"+password+"');";
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
