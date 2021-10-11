package boutique.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boutique.dao.EmployeeDAO;
import boutique.model.EmployeeBean;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String ADD = "/addEmployee.html";
    private static String UPDATE = "/updateEmployee.jsp";
    private static String LIST_ALL = "/ListEmployee.jsp";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String forward="";
	        String action = request.getParameter("action");
	        EmployeeDAO  dao = new EmployeeDAO();
	        
	        if (action.equalsIgnoreCase("delete")){
	        	    String empId = request.getParameter("empId");
		            dao.deleteEmployee(empId);
		            forward = LIST_ALL;
		            request.setAttribute("employee", dao.getAllEmployee());    
	        } else if (action.equalsIgnoreCase("update")){
	        	    forward = UPDATE;
	        	    String empId = request.getParameter("empId");
		            EmployeeBean emp = dao.getEmpId(empId);
		            request.setAttribute("emp", emp);
	        } else if (action.equalsIgnoreCase("listAll")){
	        	forward = LIST_ALL;
	        	request.setAttribute("employee", dao.getAllEmployee());
	        }else {
	            forward = ADD;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
		}
	

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeBean employee = new EmployeeBean();
		EmployeeDAO  dao = new EmployeeDAO();
		employee.setEmpName(request.getParameter("empName"));
		employee.setEmpPhone(request.getParameter("empPhone"));
		employee.setEmpAddress(request.getParameter("empAddress"));
		employee.setEmpEmail(request.getParameter("empEmail"));
		employee.setEmpBirthDate(request.getParameter("empBirthDate"));
		employee.setEmpGender(request.getParameter("empGender"));
		employee.setEmpSalary(Integer.parseInt(request.getParameter("empSalary")));

		String empId = request.getParameter("empId");
		if(empId == null || empId.isEmpty()){
	        dao.add(employee);
	        }
	    else{
	        employee.setEmpId(empId);
	        dao.updateEmployee(employee);    
	   }
	     response.sendRedirect("ListEmployee.jsp");
	}

	

}
