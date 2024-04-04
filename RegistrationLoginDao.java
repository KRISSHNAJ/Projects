package youtube.krishnaitprojects.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import youtube.krishnaitprojects.database.DatabaseDetails;
import youtube.krishnaitprojects.model.CustomerVo;

public class RegistrationLoginDao {
	
	private Connection connection;

    public RegistrationLoginDao() {
        initConnection();
    }

    private void initConnection() {
        try {
            connection = DatabaseDetails.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public boolean saveCustomer(CustomerVo customervo1) {
		try {
            if (connection == null) {
                initConnection();
            }
			PreparedStatement statement = connection.prepareStatement("INSERT INTO userdetails (role, name, username, password, address, createddate, lastmodifieddate) VALUES (?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, customervo1.getCustomer_Role());
			statement.setString(2, customervo1.getCustomer_Name());
			statement.setString(3, customervo1.getCustomer_Username());
			statement.setString(4, customervo1.getCustomer_Password());
			statement.setString(5, customervo1.getCustomer_Address());
			statement.setDate(6, customervo1.getCustomer_createddate());
			statement.setDate(7, customervo1.getCustomer_lastmodifieddate());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("~~~~~~~~~~~EXCEPTION OCCCURED : RegistrationLoginDao.saveCustomer()~~~~~~~~~~~");
			e.printStackTrace();
		}
		return false;
	}
	
	public CustomerVo getCustomerById(CustomerVo customervo1) {
		
		int customerId = customervo1.getCustomer_Id();
		CustomerVo customervo2 = new CustomerVo();
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM userdetails WHERE pid = ?");
			statement.setInt(1, customerId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {

				if (!customervo1.getCustomer_Role().equals(resultSet.getString("role"))) {
					customervo2.setCustomer_InCorrectData("role");
					return customervo2;
				} else if (!customervo1.getCustomer_Username().equals(resultSet.getString("username"))) {
					customervo2.setCustomer_InCorrectData("username");
					return customervo2;
				} else if (!customervo1.getCustomer_Password().equals(resultSet.getString("password"))) {
					customervo2.setCustomer_InCorrectData("password");
					return customervo2;
				} else {
					customervo2.setCustomer_Id(resultSet.getInt("pid"));
					customervo2.setCustomer_Role(resultSet.getString("role"));
					customervo2.setCustomer_Name(resultSet.getString("name"));
					customervo2.setCustomer_Username(resultSet.getString("username"));
					customervo2.setCustomer_Password(resultSet.getString("password"));
					customervo2.setCustomer_Address(resultSet.getString("address"));
					customervo2.setCustomer_createddate(resultSet.getDate("createddate"));
					customervo2.setCustomer_lastmodifieddate(resultSet.getDate("lastmodifieddate"));
					customervo2.setCustomer_InCorrectData("");
					return customervo2;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customervo2;
	}
}
