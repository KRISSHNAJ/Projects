package youtube.krishnaitprojects.model;

import java.io.Serializable;

public class AdminVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String admin_Role = "ADMIN";

	private int admin_Id;

	private String admin_Name;

	private String admin_Username;

	private String admin_Password;

	private String admin_Address;

	public String getAdmin_Role() {
		return admin_Role;
	}

	public void setAdmin_Role(String admin_Role) {
		this.admin_Role = admin_Role;
	}

	public int getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}

	public String getAdmin_Name() {
		return admin_Name;
	}

	public void setAdmin_Name(String admin_Name) {
		this.admin_Name = admin_Name;
	}

	public String getAdmin_Username() {
		return admin_Username;
	}

	public void setAdmin_Username(String admin_Username) {
		this.admin_Username = admin_Username;
	}

	public String getAdmin_Password() {
		return admin_Password;
	}

	public void setAdmin_Password(String admin_Password) {
		this.admin_Password = admin_Password;
	}

	public String getAdmin_Address() {
		return admin_Address;
	}

	public void setAdmin_Address(String admin_Address) {
		this.admin_Address = admin_Address;
	}

}
