package youtube.krishnaitprojects.model;

import java.io.Serializable;
import java.sql.Date;

public class CustomerVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String customer_Role = "CUSTOMER";

	private int customer_Id;

	private String customer_Name;

	private String customer_Username;

	private String customer_Password;

	private String customer_Address;
	
	private Date customer_createddate;
	
	private Date customer_lastmodifieddate;
	
	private String customer_InCorrectData;

	public String getCustomer_Role() {
		return customer_Role;
	}

	public void setCustomer_Role(String customer_Role) {
		this.customer_Role = customer_Role;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getCustomer_Username() {
		return customer_Username;
	}

	public void setCustomer_Username(String customer_Username) {
		this.customer_Username = customer_Username;
	}

	public String getCustomer_Password() {
		return customer_Password;
	}

	public void setCustomer_Password(String customer_Password) {
		this.customer_Password = customer_Password;
	}

	public String getCustomer_Address() {
		return customer_Address;
	}

	public void setCustomer_Address(String customer_Address) {
		this.customer_Address = customer_Address;
	}

	public Date getCustomer_createddate() {
		return customer_createddate;
	}

	public void setCustomer_createddate(Date customer_createddate) {
		this.customer_createddate = customer_createddate;
	}

	public Date getCustomer_lastmodifieddate() {
		return customer_lastmodifieddate;
	}

	public void setCustomer_lastmodifieddate(Date customer_lastmodifieddate) {
		this.customer_lastmodifieddate = customer_lastmodifieddate;
	}

	public String getCustomer_InCorrectData() {
		return customer_InCorrectData;
	}

	public void setCustomer_InCorrectData(String customer_InCorrectData) {
		this.customer_InCorrectData = customer_InCorrectData;
	}

}
