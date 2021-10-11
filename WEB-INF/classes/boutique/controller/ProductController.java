package boutique.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boutique.dao.ProductDAO;
import boutique.model.EmployeeBean;
import boutique.model.ProductBean;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String ADD = "/addProduct.html";
    private static String UPDATE = "/updateProduct.jsp";
    private static String LIST_ALL = "/ListProduct.jsp";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String forward="";
	        String action = request.getParameter("action");
	        ProductDAO  dao = new ProductDAO();
	        
	        if (action.equalsIgnoreCase("delete")){
        	    String prodId = request.getParameter("prodId");
	            dao.deleteProduct(prodId);
	            forward = LIST_ALL;
	            request.setAttribute("product", dao.getAllProduct());    
	        } else if (action.equalsIgnoreCase("update")){
        	    forward = UPDATE;
        	    String prodId = request.getParameter("prodId");
	            ProductBean prod = dao.getProdId(prodId);
	            request.setAttribute("product", prod);
	        } else if (action.equalsIgnoreCase("listAll")){
        	forward = LIST_ALL;
        	request.setAttribute("product", dao.getAllProduct());
	        }else {
            forward = ADD;
        }
	        
	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
		}
	

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductBean prod = new ProductBean();
		ProductDAO  dao = new ProductDAO();
		prod.setProdName(request.getParameter("prodName"));
		prod.setProdDesc(request.getParameter("prodDesc"));
		prod.setProdPrice(request.getParameter("prodPrice"));
		prod.setProdQty(Integer.parseInt(request.getParameter("prodQty")));
		
		String prodId = request.getParameter("prodId");
		if(prodId == null || prodId.isEmpty()){
	        dao.add(prod);
	        }
	    else{
	        prod.setProdId(prodId);
	        dao.updateProduct(prod); 
	   }
	     response.sendRedirect("ListProduct.jsp");
	}

	

}
