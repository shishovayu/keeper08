package ClientServer;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.sql.SQLException;

public interface AccessService {
    //int multiplicat(int a, int b);
    boolean login(String login, String password) throws SQLException;
    //void createUser(User user) throws SQLException;
    void createUser(int id, String login, String password, String position);
    String checkUserType(String login);
    DefaultMutableTreeNode getNodes(DefaultMutableTreeNode node, String position);
   // String getPositionType(String x);
    //JTree getTree(String position) throws SQLException;


}
