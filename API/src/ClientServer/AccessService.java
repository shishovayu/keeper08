package ClientServer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AccessService {
    boolean login(String login, String password) throws SQLException;
    void createUser(int id, String login, String password, String position);
    String checkUserType(String login);
    ArrayList getNodes(String position);

}
