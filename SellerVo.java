package youtube.krishnaitprojects.model;

import java.io.Serializable;

public class SellerVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String seller_Role = "SELLER";

	private int seller_Id;

	private String seller_Name;

	private String seller_Username;

	private String seller_Password;

	private String seller_Address;

	public String getSeller_Role() {
		return seller_Role;
	}

	public void setSeller_Role(String seller_Role) {
		this.seller_Role = seller_Role;
	}

	public int getSeller_Id() {
		return seller_Id;
	}

	public void setSeller_Id(int seller_Id) {
		this.seller_Id = seller_Id;
	}

	public String getSeller_Name() {
		return seller_Name;
	}

	public void setSeller_Name(String seller_Name) {
		this.seller_Name = seller_Name;
	}

	public String getSeller_Username() {
		return seller_Username;
	}

	public void setSeller_Username(String seller_Username) {
		this.seller_Username = seller_Username;
	}

	public String getSeller_Password() {
		return seller_Password;
	}

	public void setSeller_Password(String seller_Password) {
		this.seller_Password = seller_Password;
	}

	public String getSeller_Address() {
		return seller_Address;
	}

	public void setSeller_Address(String seller_Address) {
		this.seller_Address = seller_Address;
	}

}
