package youtube.krishnaitprojects.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import youtube.krishnaitprojects.database.DatabaseDetails;
import youtube.krishnaitprojects.model.ProductVo;

public class ProductsDao {
	
	private Connection connection;

    public ProductsDao() {
        initConnection();
    }

    private void initConnection() {
        try {
            connection = DatabaseDetails.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public boolean saveProducts(ProductVo productvo1) {
		try {
            if (connection == null) {
                initConnection();
            }
			PreparedStatement statement = connection.prepareStatement("INSERT INTO productdetails (seller_Id, customer_Id, order_Id, product_No, product_Name, product_Description, product_PerPrice, product_QtyObtained, product_QtyNeeded, product_Review, product_Image, product_createddate, product_lastmodifieddate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, productvo1.getSeller_Id());
			statement.setInt(2, productvo1.getCustomer_Id());
			statement.setInt(3, productvo1.getOrder_Id());
			statement.setString(4, productvo1.getProduct_No());//
			statement.setString(5, productvo1.getProduct_Name());//
			statement.setString(6, productvo1.getProduct_Description());
			statement.setDouble(7, productvo1.getProduct_PerPrice());
			statement.setDouble(8, productvo1.getProduct_QtyObtained());
			statement.setDouble(9, productvo1.getProduct_QtyNeeded());
			statement.setString(10, productvo1.getProduct_Review());
			statement.setString(11, productvo1.getProduct_Image());
			statement.setDate(12, productvo1.getProduct_createddate());
			statement.setDate(13, productvo1.getProduct_lastmodifieddate());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("~~~~~~~~~~~EXCEPTION OCCCURED : ProductsDao.saveProducts()~~~~~~~~~~~");
			e.printStackTrace();
		}
		return false;
	}
	
	public List<ProductVo> getAllProducts() {
		List<ProductVo> allproducts = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM productdetails");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ProductVo productvo = new ProductVo();
				productvo.setSeller_Id(resultSet.getInt("seller_Id"));
				productvo.setCustomer_Id(resultSet.getInt("customer_Id"));
				productvo.setOrder_Id(resultSet.getInt("order_Id"));
				productvo.setProduct_Id(resultSet.getInt("pid"));
				productvo.setProduct_No(resultSet.getString("product_No"));
				productvo.setProduct_Name(resultSet.getString("product_Name"));
				productvo.setProduct_Description(resultSet.getString("product_Description"));
				productvo.setProduct_PerPrice(resultSet.getDouble("product_PerPrice"));
				productvo.setProduct_QtyObtained(resultSet.getDouble("product_QtyObtained"));
				productvo.setProduct_QtyNeeded(resultSet.getDouble("product_QtyNeeded"));
				productvo.setProduct_Review(resultSet.getString("product_Review"));
				productvo.setProduct_Image(resultSet.getString("product_Image"));
				productvo.setProduct_createddate(resultSet.getDate("product_createddate"));
				productvo.setProduct_lastmodifieddate(resultSet.getDate("product_lastmodifieddate"));
				allproducts.add(productvo);
			}
		} catch (SQLException e) {
			System.out.println("EEEEEEEEEEEEEE OCCURED IN GETALLPRODUCTS IN DAO");
			e.printStackTrace();
		}
		return allproducts;
	}
	
	public List<ProductVo> getAllProductsBySellerId() {
		List<ProductVo> allproducts = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM productdetails");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ProductVo productvo = new ProductVo();
				productvo.setSeller_Id(resultSet.getInt("seller_Id"));
				productvo.setCustomer_Id(resultSet.getInt("customer_Id"));
				productvo.setOrder_Id(resultSet.getInt("order_Id"));
				productvo.setProduct_Id(resultSet.getInt("pid"));
				productvo.setProduct_No(resultSet.getString("product_No"));
				productvo.setProduct_Name(resultSet.getString("product_Name"));
				productvo.setProduct_Description(resultSet.getString("product_Description"));
				productvo.setProduct_PerPrice(resultSet.getDouble("product_PerPrice"));
				productvo.setProduct_QtyObtained(resultSet.getDouble("product_QtyObtained"));
				productvo.setProduct_QtyNeeded(resultSet.getDouble("product_QtyNeeded"));
				productvo.setProduct_Review(resultSet.getString("product_Review"));
				productvo.setProduct_Image(resultSet.getString("product_Image"));
				productvo.setProduct_createddate(resultSet.getDate("product_createddate"));
				productvo.setProduct_lastmodifieddate(resultSet.getDate("product_lastmodifieddate"));
				allproducts.add(productvo);
			}
		} catch (SQLException e) {
			System.out.println("EEEEEEEEEEEEEE OCCURED IN GETALLPRODUCTS IN DAO");
			e.printStackTrace();
		}
		return allproducts;
	}

}
