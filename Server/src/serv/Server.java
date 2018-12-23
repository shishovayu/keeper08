package serv;

import ClientServer.AccessService;
import com.caucho.hessian.server.HessianServlet;
import keeper.api.User;



import java.awt.*;
import java.net.MalformedURLException;
import java.sql.SQLException;


public class Server extends HessianServlet implements AccessService {

    public boolean login(String login, String password) {
        boolean authorization = datamanager.getInstance().login(login, password);
        return authorization;
    }

    public String checkUserType(String login) throws SQLException {
        String userType = datamanager.getInstance().checkUser(login);
        return userType;
    }



    public void createUser(int id, String login, String password, String position) throws SQLException, MalformedURLException {
        User user = new User();
        user.setUserID(id);
        user.setPosition(position);
        user.setPassword(password);
        user.setLogin(login);
        //serv.connectionManager();
        datamanager.getInstance().createUser(user);
    }


}
