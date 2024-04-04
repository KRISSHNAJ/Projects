package youtube.krishnaitprojects.model;

import java.io.Serializable;
import java.sql.Date;

public class ProductVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int seller_Id;
	
	private int customer_Id;
	
	private int order_Id;

	private int product_Id;

	private String product_No;

	private String product_Name;
	
	private String product_Description;

	private double product_PerPrice;
	
	private double product_QtyObtained;  //from seller

	private double product_QtyNeeded; //from customer
	
	private String product_Review;
	
	private String product_Image;
	
	private Date product_createddate;
	
	private Date product_lastmodifieddate;
	
	private String product_InCorrectData;
	

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public String getProduct_No() {
		return product_No;
	}

	public void setProduct_No(String product_No) {
		this.product_No = product_No;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public double getProduct_PerPrice() {
		return product_PerPrice;
	}

	public void setProduct_PerPrice(double product_PerPrice) {
		this.product_PerPrice = product_PerPrice;
	}

	public String getProduct_Description() {
		return product_Description;
	}

	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}

	public double getProduct_QtyObtained() {
		return product_QtyObtained;
	}

	public void setProduct_QtyObtained(double product_QtyObtained) {
		this.product_QtyObtained = product_QtyObtained;
	}

	public double getProduct_QtyNeeded() {
		return product_QtyNeeded;
	}

	public void setProduct_QtyNeeded(double product_QtyNeeded) {
		this.product_QtyNeeded = product_QtyNeeded;
	}

	public String getProduct_Review() {
		return product_Review;
	}

	public void setProduct_Review(String product_Review) {
		this.product_Review = product_Review;
	}

	public String getProduct_Image() {
		return product_Image;
	}

	public void setProduct_Image(String product_Image) {
		this.product_Image = product_Image;
	}

	public Date getProduct_createddate() {
		return product_createddate;
	}

	public void setProduct_createddate(Date product_createddate) {
		this.product_createddate = product_createddate;
	}

	public Date getProduct_lastmodifieddate() {
		return product_lastmodifieddate;
	}

	public void setProduct_lastmodifieddate(Date product_lastmodifieddate) {
		this.product_lastmodifieddate = product_lastmodifieddate;
	}

	public String getProduct_InCorrectData() {
		return product_InCorrectData;
	}

	public void setProduct_InCorrectData(String product_InCorrectData) {
		this.product_InCorrectData = product_InCorrectData;
	}

	public int getSeller_Id() {
		return seller_Id;
	}

	public void setSeller_Id(int seller_Id) {
		this.seller_Id = seller_Id;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

}
