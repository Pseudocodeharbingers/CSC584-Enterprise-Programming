package boutique.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import boutique.dao.UserDAO;
import boutique.model.UserBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
    HttpServletRequest request;
    HttpServletResponse response;
    String forward="";
    String action="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		action = request.getParameter("action");
        
		
        	try {
    			
    			UserBean user = new UserBean();
    			user.setAdmin_id(request.getParameter("admin_id"));
    			user.setAdmin_password(request.getParameter("admin_password"));
    			user = UserDAO.login(user);

    			if(user.isValid())
    			{
    				HttpSession session = request.getSession(true);
    				session.setAttribute("currentSessionUser", user);
    				response.sendRedirect("/ZarisaBoutique/indexAdmin.jsp"); 
    			}
    			else
    			{
    				//sini pun sama tukar dia pergi ke page apa
    				response.sendRedirect("/ZarisaBoutique/invalidLogin.html"); 
    			}
    			
    		}
    		catch (Throwable ex) {
    			System.out.println(ex);
    		}
 
	}


}
