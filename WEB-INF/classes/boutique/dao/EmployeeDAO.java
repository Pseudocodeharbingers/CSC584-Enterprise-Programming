package boutique.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import boutique.dao.EmployeeDAO;
import boutique.model.EmployeeBean;
import boutique.model.SupprodBean;
import boutique.connection.ConnectionManager;

public class EmployeeDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
    
	//add new order
	public void add(EmployeeBean bean){
		
		String empName = bean.getEmpName();
		String empPhone = bean.getEmpPhone();
		String empAddress = bean.getEmpAddress();
		String empEmail = bean.getEmpEmail();
		String empBirthDate = bean.getEmpBirthDate();
		String empGender = bean.getEmpGender();
		int empSalary = bean.getEmpSalary();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into EMPLOYEE (EMP_NAME,EMP_PHONE,EMP_ADDRESS,EMP_EMAIL,EMP_BIRTHDATE,EMP_GENDER,EMP_SALARY)values(?,?,?,?,?,?,?)");
			ps.setString(1,empName);
			ps.setString(2,empPhone);
			ps.setString(3,empAddress);
			ps.setString(4,empEmail);
			ps.setString(5,empBirthDate);
			ps.setString(6,empGender);
			ps.setInt(7,empSalary);
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
	
	public static List<EmployeeBean> getAllCurrEmployee() {
		    List<EmployeeBean> emp = new ArrayList<EmployeeBean>();
		    try {
		    	currentCon = ConnectionManager.getConnection();
		    	stmt = currentCon.createStatement();
		        ResultSet rs = stmt.executeQuery("select EMP_ID,EMP_NAME,EMP_PHONE, EMP_EMAIL from EMPLOYEE");
		        
		        while (rs.next()) {
		        	  EmployeeBean employee = new EmployeeBean();
		              employee.setEmpId(rs.getString("EMP_ID"));
		              employee.setEmpName(rs.getString("EMP_NAME"));
		              employee.setEmpPhone(rs.getString("EMP_PHONE"));
		              employee.setEmpEmail(rs.getString("EMP_EMAIL"));
		              emp.add(employee);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return emp;
		}
	
	public static List<EmployeeBean> getAllEmployee() {
	    List<EmployeeBean> emp = new ArrayList<EmployeeBean>();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	stmt = currentCon.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from EMPLOYEE");
	        
	        while (rs.next()) {
	        	EmployeeBean employee = new EmployeeBean();
	              employee.setEmpId(rs.getString("EMP_ID"));
	              employee.setEmpName(rs.getString("EMP_NAME"));
	              employee.setEmpPhone(rs.getString("EMP_PHONE"));
	              employee.setEmpAddress(rs.getString("EMP_ADDRESS"));
	              employee.setEmpEmail(rs.getString("EMP_EMAIL"));
	              employee.setEmpBirthDate(rs.getString("EMP_BIRTHDATE"));
	              employee.setEmpGender(rs.getString("EMP_GENDER"));
	              employee.setEmpSalary(rs.getInt("EMP_SALARY"));
	              emp.add(employee);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return emp;
	}
	
	public void deleteEmployee(String empId) {
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	ps = currentCon.prepareStatement("Delete from EMPLOYEE where EMP_ID = ?");
	        ps.setString(1, empId);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateEmployee(EmployeeBean bean) {

		String empId = bean.getEmpId();
		String empName = bean.getEmpName();
		String empPhone = bean.getEmpPhone();
		String empAddress = bean.getEmpAddress();
		String empEmail = bean.getEmpEmail();
		String empBirthDate = bean.getEmpBirthDate();
		String empGender = bean.getEmpGender();
		int empSalary = bean.getEmpSalary();
	   
		
		String searchQuery = "UPDATE employee SET EMP_NAME ='" + empName + "', EMP_PHONE ='" + empPhone + "', EMP_ADDRESS ='" + empAddress + "', EMP_EMAIL ='" + empEmail + "',EMP_BIRTHDATE ='" + empBirthDate + "', EMP_GENDER ='" + empGender +"', EMP_SALARY ='" + empSalary + "' WHERE EMP_ID= '" + empId + "'";
	
		try {

	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public EmployeeBean getEmpId(String empId) {
		EmployeeBean employee = new EmployeeBean();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from employee where EMP_ID = ?");
	        ps.setString(1, empId);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {	
	        	 
	        	  employee.setEmpId(rs.getString("EMP_ID"));
	              employee.setEmpName(rs.getString("EMP_NAME"));
	              employee.setEmpPhone(rs.getString("EMP_PHONE"));
	              employee.setEmpAddress(rs.getString("EMP_ADDRESS"));
	              employee.setEmpEmail(rs.getString("EMP_EMAIL"));
	              employee.setEmpBirthDate(rs.getString("EMP_BIRTHDATE"));
	              employee.setEmpGender(rs.getString("EMP_GENDER"));
	              employee.setEmpSalary(rs.getInt("EMP_SALARY"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return employee;
	}
	
	//login Employee
	 static String empEmail, empPhone;
		public static EmployeeBean login(EmployeeBean bean) throws NoSuchAlgorithmException {
    	
        empEmail = bean.getEmpEmail();
        empPhone = bean.getEmpPhone();

        
        String searchQuery = "select * from EMPLOYEE where EMP_EMAIL='" + empEmail + "' AND EMP_PHONE='" + empPhone + "'";

        System.out.println("Your Employee Email is " + empEmail );
        System.out.println("Your Phone Number is " + empPhone);
        System.out.println("Query: " + searchQuery);

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	String empEmail = rs.getString("EMP_EMAIL");
           		System.out.println("Welcome " + empEmail);
                bean.setEmpEmail(empEmail);
                bean.setValid(true);
           	}
           
            // if user does not exist set the isValid variable to false
            else if (!more) {
            	System.out.println("Sorry, you are not a registered Employee! Please sign up first");
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
    
		public static List<EmployeeBean> getReportEmpFem() {
		    List<EmployeeBean> emp = new ArrayList<EmployeeBean>();
		    try {
		    	currentCon = ConnectionManager.getConnection();
		    	stmt = currentCon.createStatement();
		        ResultSet rs = stmt.executeQuery("select EMP_ID, EMP_NAME, EMP_EMAIL, EMP_GENDER, EMP_SALARY FROM EMPLOYEE WHERE EMP_GENDER = 'Female' ");
		        
		        while (rs.next()) {
		        	  EmployeeBean employee = new EmployeeBean();
		              employee.setEmpId(rs.getString("EMP_ID"));
		              employee.setEmpName(rs.getString("EMP_NAME"));
		              employee.setEmpEmail(rs.getString("EMP_EMAIL"));
		              employee.setEmpGender(rs.getString("EMP_GENDER"));
		              employee.setEmpSalary(rs.getInt("EMP_SALARY"));
		              emp.add(employee);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return emp;
		}
		
		public static List<EmployeeBean> getReportEmpMale() {
		    List<EmployeeBean> emp = new ArrayList<EmployeeBean>();
		    try {
		    	currentCon = ConnectionManager.getConnection();
		    	stmt = currentCon.createStatement();
		        ResultSet rs = stmt.executeQuery("select EMP_ID, EMP_NAME, EMP_EMAIL, EMP_GENDER, EMP_SALARY FROM EMPLOYEE WHERE EMP_GENDER = 'Male' ");
		        
		        while (rs.next()) {
		        	  EmployeeBean employee = new EmployeeBean();
		              employee.setEmpId(rs.getString("EMP_ID"));
		              employee.setEmpName(rs.getString("EMP_NAME"));
		              employee.setEmpEmail(rs.getString("EMP_EMAIL"));
		              employee.setEmpGender(rs.getString("EMP_GENDER"));
		              employee.setEmpSalary(rs.getInt("EMP_SALARY"));
		              emp.add(employee);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return emp;
		}
		
		public static List<SupprodBean> getReportSupp() {
		    List<SupprodBean> supplier = new ArrayList<SupprodBean>();
		    try {
		    	currentCon = ConnectionManager.getConnection();
		    	stmt = currentCon.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT P.PROD_NAME, P.PROD_DESC, P.PROD_QUANTITY, P.PROD_PRICE, S.SUP_NAME FROM SUP_PROD SP JOIN PRODUCT P ON P.PROD_ID = SP.PROD_ID JOIN SUPPLIER S ON S.SUP_ID = SP.SUP_ID");
		        
		        while (rs.next()) {
		        	  SupprodBean supp = new SupprodBean();
		              supp.setProdname(rs.getString("PROD_NAME"));
		              supp.setProddesc(rs.getString("PROD_DESC"));
		              supp.setProdqty(rs.getString("PROD_QUANTITY"));
		              supp.setProdprice(rs.getString("PROD_PRICE"));
		              supp.setSupname(rs.getString("SUP_NAME"));
		              supplier.add(supp);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return supplier;
		}

}
