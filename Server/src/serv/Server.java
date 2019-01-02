package serv;

import ClientServer.AccessService;
import com.caucho.hessian.server.HessianServlet;
import jdk.nashorn.api.tree.Tree;
import keeper.api.User;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.sql.SQLException;


public class Server extends HessianServlet implements AccessService {

    public DefaultMutableTreeNode getNodes(DefaultMutableTreeNode node, String position) {
            //DefaultMutableTreeNode new_node = new DefaultMutableTreeNode();
            return datamanager.getInstance().getNodes(node, position);

    }

//    public JTree getTree( String position) throws SQLException {
//       return datamanager.getInstance().getNode( position);
//    }


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
        //serv.connectionManager();
        try {
            datamanager.getInstance().createUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
