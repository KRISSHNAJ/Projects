package youtube.krishnaitprojects.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import youtube.krishnaitprojects.dao.ProductsDao;
import youtube.krishnaitprojects.model.CustomerVo;
import youtube.krishnaitprojects.model.ProductVo;
import youtube.krishnaitprojects.utils.Tools;

public class ProductsBean extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ProductVo productvo1 = new ProductVo();
		ProductsDao productdaovo1 = new ProductsDao();
		
		// Read the JSON payload from the request body
	    BufferedReader reader = request.getReader();
	    StringBuilder requestBody = new StringBuilder();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        requestBody.append(line);
	    }
	    
	    JSONObject jsonPayload = null;

	    // Parse the JSON payload into a JSONObject
	    try {
			jsonPayload = new JSONObject(requestBody.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Extract individual parameters from the JSON payload
		try {
		productvo1.setSeller_Id(jsonPayload.getInt("sellerId"));
		productvo1.setProduct_Image(jsonPayload.getString("productImage"));
		productvo1.setProduct_Name(jsonPayload.getString("productName"));
		productvo1.setProduct_Description(jsonPayload.getString("productDescription"));
		productvo1.setProduct_PerPrice(jsonPayload.getDouble("productPerPrice"));
		productvo1.setProduct_QtyObtained(jsonPayload.getInt("productQuantityObtained"));
		productvo1.setProduct_createddate(Tools.getSqlCurrentDate());
		productvo1.setProduct_lastmodifieddate(Tools.getSqlCurrentDate());
		
////		productvo1.setSeller_Id(Integer.parseInt(request.getParameter("sellerId")));
////		productvo1.setCustomer_Id(Integer.parseInt(request.getParameter("")));
////		productvo1.setOrder_Id(Integer.parseInt((request.getParameter(""))));
////		productvo1.setProduct_Id(Integer.parseInt((request.getParameter(""))));
////		productvo1.setProduct_No(request.getParameter(""));
//		productvo1.setProduct_Image(request.getParameter("productImage"));
//		productvo1.setProduct_Name(request.getParameter("productName"));
//		productvo1.setProduct_Description(request.getParameter("productDescription"));
//		productvo1.setProduct_PerPrice(Double.parseDouble(request.getParameter("productPerPrice")));
//		productvo1.setProduct_QtyObtained(Double.parseDouble(request.getParameter("productQuantityObtained")));
////		productvo1.setProduct_QtyNeeded(Double.parseDouble(request.getParameter("")));
////		productvo1.setProduct_Review(request.getParameter(""));
//		productvo1.setProduct_createddate(Tools.getSqlCurrentDate());
//		productvo1.setProduct_lastmodifieddate(Tools.getSqlCurrentDate());
////		productvo1.setProduct_InCorrectData("");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean success = productdaovo1.saveProducts(productvo1);
		
		List<ProductVo> productvo2 = productdaovo1.getAllProducts();
		
		// Convert the List<ProductVo> to JSON using Gson library
		Gson gson = new Gson();
		String productListJson = gson.toJson(productvo2);

		// Send response back to the client
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("{ \"success\": " + success + ", \"productList\": " + productListJson + " }");
		
	}
	

}
