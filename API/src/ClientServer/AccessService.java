package ClientServer;

import keeper.api.User;

import java.net.MalformedURLException;
import java.sql.SQLException;

public interface AccessService {
    //int multiplicat(int a, int b);
    boolean login(String login, String password);
    //void createUser(User user) throws SQLException;
    void createUser(int id, String login, String password, String position) throws SQLException, MalformedURLException;
    String checkUserType(String login) throws SQLException;


}
