package youtube.krishnaitprojects.bean;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import youtube.krishnaitprojects.model.CustomerVo;
import youtube.krishnaitprojects.model.OrdersVo;
import youtube.krishnaitprojects.model.ProductsVo;
import youtube.krishnaitprojects.model.SellerVo;

public class DashboardBean extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		CustomerVo customervo2 = (CustomerVo) request.getAttribute("customer");
		request.setAttribute("customervo", customervo2);
		
		customervo2.getCustomer_Role();

		ProductsVo productsvo = new ProductsVo();
		request.setAttribute("productsvo", productsvo);

		OrdersVo ordersvo = new OrdersVo();
		request.setAttribute("ordersvo", ordersvo);

		SellerVo sellervo = new SellerVo();
		request.setAttribute("sellervo", sellervo);
		
		String userRole = customervo2.getCustomer_Role();
		
		if("customer".equalsIgnoreCase(userRole)) {
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/ui/jsp/DashboardCustomer.jsp");
			dispatcher1.include(request, response);
		}else if ("seller".equalsIgnoreCase(userRole)) {
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/ui/jsp/DashboardSeller.jsp");
			dispatcher1.include(request, response);
		}else if ("admin".equalsIgnoreCase(userRole)) {
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/ui/jsp/DashboardCustomer.jsp");
			dispatcher1.include(request, response);
		}else {
			
		}

	}

}
