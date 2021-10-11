package boutique.model;

public class EmployeeBean {
	private String empId;
	private String empName;
	private String empPhone;
	private String empAddress;
	private String empEmail;
	private String empBirthDate;
	private String empGender;
	private int empSalary;
	public boolean valid; 
	
	/**
	 * @param empId
	 * @param empName
	 * @param empPhone
	 * @param empAddress
	 * @param empEmail
	 * @param empBirthDate
	 * @param empGender
	 * @param empSalary
	 */
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * 
	 */
	public EmployeeBean() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeBean(String empId, String empName, String empPhone, String empAddress, String empEmail,
			String empBirthDate, String empGender, int empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empAddress = empAddress;
		this.empEmail = empEmail;
		this.empBirthDate = empBirthDate;
		this.empGender = empGender;
		this.empSalary = empSalary;
	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpBirthDate() {
		return empBirthDate;
	}
	public void setEmpBirthDate(String empBirthDate) {
		this.empBirthDate = empBirthDate;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", empPhone=" + empPhone + ", empAddress="
				+ empAddress + ", empEmail=" + empEmail + ", empBirthDate=" + empBirthDate + ", empGender=" + empGender
				+ ", empSalary=" + empSalary + "]";
	}
}
	