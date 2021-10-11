package boutique.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import boutique.model.ProductBean;
import boutique.connection.ConnectionManager;

public class ProductDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String prodId;
	 
	//add new product
	public void add(ProductBean bean){
		String prodName = bean.getProdName();
		String prodDesc = bean.getProdDesc();
		String prodPrice = bean.getProdPrice();
		int prodQty = bean.getProdQty();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into PRODUCT (PROD_NAME,PROD_DESC,PROD_PRICE,PROD_QUANTITY)values(?,?,?,?)");
			ps.setString(1,prodName);
			ps.setString(2,prodDesc);
			ps.setString(3,prodPrice);
			ps.setInt(4,prodQty);
			ps.executeUpdate();
		}

		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}

		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		//return bean;
		}
	
	public static List<ProductBean> getAllCurrProduct() {
		    List<ProductBean> prod = new ArrayList<ProductBean>();
		    try {
		    	currentCon = ConnectionManager.getConnection();
		    	stmt = currentCon.createStatement();
		        ResultSet rs = stmt.executeQuery("select * from PRODUCT");
		        
		        while (rs.next()) {
		        	  ProductBean product = new ProductBean();
		              product.setProdId(rs.getString("PROD_ID"));
		              product.setProdName(rs.getString("PROD_NAME"));
		              product.setProdDesc(rs.getString("PROD_DESC"));
		              product.setProdPrice(rs.getString("PROD_PRICE"));
		              product.setProdQty(rs.getInt("PROD_QUANTITY"));
		              prod.add(product);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return prod;
		}
	
	public static List<ProductBean> getAllProduct() {
	    List<ProductBean> prod = new ArrayList<ProductBean>();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	stmt = currentCon.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from PRODUCT");
	        
	        while (rs.next()) {
	        	  ProductBean product = new ProductBean();
	              product.setProdId(rs.getString("PROD_ID"));
	              product.setProdName(rs.getString("PROD_NAME"));
	              product.setProdDesc(rs.getString("PROD_DESC"));
	              product.setProdPrice(rs.getString("PROD_PRICE"));
	              product.setProdQty(rs.getInt("PROD_QUANTITY"));
	              prod.add(product);
	              System.out.println(product);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return prod;
	}
	
	public void deleteProduct(String prodId) {
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	ps = currentCon.prepareStatement("Delete from PRODUCT where PROD_ID = ?");
	        ps.setString(1, prodId);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateProduct(ProductBean bean) {

		String prodId = bean.getProdId();
		String prodName = bean.getProdName();
		String prodDesc = bean.getProdDesc();
		String prodPrice = bean.getProdPrice();
		int prodQty = bean.getProdQty();	   
		
		String searchQuery = "UPDATE product SET PROD_ID ='" + prodId + "', PROD_NAME ='" + prodName + "', PROD_DESC ='" + prodDesc + "', PROD_PRICE ='" + prodPrice + "',PROD_QUANTITY ='" + prodQty + "' WHERE PROD_ID= '" + prodId + "'";
		
	
		try {

	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public ProductBean getProdId(String prodId) {
		ProductBean prod = new ProductBean();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from PRODUCT where PROD_ID = ?");
	        ps.setString(1, prodId);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {	
	        	  ProductBean product = new ProductBean();
	        	  product.setProdId(rs.getString("PROD_ID"));
	              product.setProdName(rs.getString("PROD_NAME"));
	              product.setProdDesc(rs.getString("PROD_DESC"));
	              product.setProdPrice(rs.getString("PROD_PRICE"));
	              product.setProdQty(rs.getInt("PROD_QUANTITY"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return prod;
	}

}