package youtube.krishnaitprojects.bean;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import youtube.krishnaitprojects.dao.RegistrationLoginDao;
import youtube.krishnaitprojects.model.CustomerVo;
import youtube.krishnaitprojects.utils.Tools;

public class RegistrationLoginBean extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	RegistrationLoginDao registrationlogindao = new RegistrationLoginDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		String action = request.getParameter("action");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if ("Registration".equals(action)) {

			CustomerVo customervo1 = new CustomerVo();

			customervo1.setCustomer_Role(request.getParameter("role"));
			customervo1.setCustomer_Name(request.getParameter("fullName"));
			customervo1.setCustomer_Username(request.getParameter("username"));
			customervo1.setCustomer_Password(request.getParameter("password"));
			customervo1.setCustomer_Address(request.getParameter("address"));
			customervo1.setCustomer_createddate(Tools.getSqlCurrentDate());
			customervo1.setCustomer_lastmodifieddate(Tools.getSqlCurrentDate());

			boolean success = registrationlogindao.saveCustomer(customervo1);

			if (success == true) {
				out.print("Registration Successful & UserID Has been sent to your registered EmailID !!!");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ui/jsp/Login.jsp");
				rd.include(request, response);
			} else {
				out.print("Registration Failed !!!");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ui/jsp/Registration.jsp");
				rd.include(request, response);
			}
		} else if ("Update".equals(action)) {

		} else if ("Delete".equals(action)) {

		} else if ("Login".equals(action)) {

			CustomerVo customervo1 = new CustomerVo();

			customervo1.setCustomer_Id(Integer.parseInt(request.getParameter("userid")));
			customervo1.setCustomer_Role(request.getParameter("role"));
			customervo1.setCustomer_Username(request.getParameter("username"));
			customervo1.setCustomer_Password(request.getParameter("password"));

			CustomerVo customervo2 = registrationlogindao.getCustomerById(customervo1);
			String incorrectData = customervo2.getCustomer_InCorrectData();

			if ("role".equals(incorrectData)) {
				out.print("Login Failed (given ROLE is mis-mattached) !!!");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ui/jsp/Login.jsp");
				rd.include(request, response);
			} else if ("username".equals(incorrectData)) {
				out.print("Login Failed (given USERNAME is mis-mattached) !!!");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ui/jsp/Login.jsp");
				rd.include(request, response);
			} else if ("password".equals(incorrectData)) {
				out.print("Login Failed (given PASSWORD is mis-mattached) !!!");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ui/jsp/Login.jsp");
				rd.include(request, response);
			} else {
				request.setAttribute("customer", customervo2);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/DashboardBeanServlet");
				dispatcher.include(request, response);
			}

		} else if ("GetAllUsersDetails".equals(action)) {

		} else {

		}
		
	}
	

}
