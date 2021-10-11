package boutique.dao;

//import java.util.*;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import boutique.model.UserBean;
import boutique.connection.ConnectionManager;

public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
    static String admin_id, admin_password;
    
    //login
    public static UserBean login(UserBean bean) throws NoSuchAlgorithmException {
    	
        admin_id = bean.getAdmin_id();
        admin_password = bean.getAdmin_password();
        
        String searchQuery = "select * from admin where admin_id='" + admin_id + "' AND admin_password='" + admin_password + "'";

        System.out.println("Your Admin ID is " + admin_id );
        System.out.println("Your Password is " + admin_password);
        System.out.println("Query: " + searchQuery);

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	String admin_id = rs.getString("admin_id");
           
           		System.out.println("Welcome " + admin_id);
                bean.setAdmin_id(admin_id);
                bean.setValid(true);
           	}
           
            // if user does not exist set the isValid variable to false
            else if (!more) {
            	System.out.println("Sorry, you are not a registered user! Please sign up first");
            	bean.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return bean;
    }
    
    
}

