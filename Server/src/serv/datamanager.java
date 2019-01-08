package serv;

import keeper.api.User;
import java.sql.*;
import java.util.ArrayList;

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


    public ArrayList<String> getNodes (String position)  {

        ArrayList nodes = new ArrayList<String>();

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/keeper", "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT position_name\n" +
                    "  FROM public.\"Position\"" + " WHERE type_1 =" + "\'"+position+"\'");


            while (resultSet.next()) {
                String str = resultSet.getString("position_name");
                nodes.add(str);
            }
            //return nodes;
        }
        catch (ClassNotFoundException e) {
        e.printStackTrace();
        } catch (SQLException e) {
        e.printStackTrace();
    }
        return nodes;

    }

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



}
