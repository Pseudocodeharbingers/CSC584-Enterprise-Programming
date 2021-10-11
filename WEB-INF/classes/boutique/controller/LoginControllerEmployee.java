package boutique.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import boutique.dao.EmployeeDAO;
import boutique.model.EmployeeBean;

/**
 * Servlet implementation class LoginControllerEmployee
 */
@WebServlet("/LoginControllerEmployee")
public class LoginControllerEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO dao;
    HttpServletRequest request;
    HttpServletResponse response;
    String forward="";
    String action="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerEmployee() {
        super();
        dao = new EmployeeDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		action = request.getParameter("action");
        
		
        	try {
    			
    			EmployeeBean user = new EmployeeBean();
    			user.setEmpEmail(request.getParameter("empId"));
    			user.setEmpPhone(request.getParameter("empPhone"));

    			user = EmployeeDAO.login(user);

    			if(user.isValid())
    			{
    				HttpSession session = request.getSession(true);
    				session.setAttribute("currentSessionUser", user);
    				response.sendRedirect("/ZarisaBoutique/indexEmployee.jsp");
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
