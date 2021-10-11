package boutique.model;

public class SupprodBean {
	private String prodname;
	private String proddesc;
	private String prodqty;
	private String prodprice;
	private String supname;
	public SupprodBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupprodBean(String prodname, String proddesc, String prodqty, String prodprice, String supname) {
		super();
		this.prodname = prodname;
		this.proddesc = proddesc;
		this.prodqty = prodqty;
		this.prodprice = prodprice;
		this.supname = supname;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	public String getProdqty() {
		return prodqty;
	}
	public void setProdqty(String prodqty) {
		this.prodqty = prodqty;
	}
	public String getProdprice() {
		return prodprice;
	}
	public void setProdprice(String prodprice) {
		this.prodprice = prodprice;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	
}
