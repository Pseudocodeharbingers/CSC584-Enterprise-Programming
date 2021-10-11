package boutique.model;

public class ProductBean {
	String prodId;
	String prodName;
	String prodDesc;
	String prodPrice;
	int prodQty;
	/**
	 * 
	 */
	public ProductBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductBean(String prodId, String prodName, String prodDesc, String prodPrice, int prodQty) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodPrice = prodPrice;
		this.prodQty = prodQty;
	}

	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getProdQty() {
		return prodQty;
	}
	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}
	@Override
	public String toString() {
		return "ProductBean [prodId=" + prodId + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodPrice="
				+ prodPrice + ", prodQty=" + prodQty + "]";
	}
	
	
}
