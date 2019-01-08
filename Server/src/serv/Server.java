package serv;

import ClientServer.AccessService;
import com.caucho.hessian.server.HessianServlet;
import keeper.api.User;
import java.sql.SQLException;
import java.util.ArrayList;


public class Server extends HessianServlet implements AccessService {

    public ArrayList<String> getNodes(String position) {
            return datamanager.getInstance().getNodes(position);

    }

    public boolean login(String login, String password) throws SQLException {
        boolean authorization = datamanager.getInstance().login(login, password);
        return authorization;
    }

    public String checkUserType(String login) {
        String userType = datamanager.getInstance().checkUser(login);
        return userType;
    }


    public void createUser(int id, String login, String password, String position)  {
        User user = new User();
        user.setUserID(id);
        user.setPosition(position);
        user.setPassword(password);
        user.setLogin(login);
        try {
            datamanager.getInstance().createUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
