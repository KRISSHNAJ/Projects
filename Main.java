package youtube.krishnaitprojects;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String action = " ";
		
		action = request.getParameter("action");
		
	    response.setContentType("text/html");  
	    
	    PrintWriter out = response.getWriter(); 
		
		if ("Registration".equals(action)) {
			
			RequestDispatcher rd1=request.getRequestDispatcher("/WEB-INF/ui/jsp/Registration.jsp");  
	        rd1.forward(request, response);
			
		} else if ("Login".equals(action)) {
			
			RequestDispatcher rd2=request.getRequestDispatcher("/WEB-INF/ui/jsp/Login.jsp");  
	        rd2.forward(request, response);

		} else if ("MainRequest?action=Admin".equals(action)) {
			
			out.print(" SORRY!!! SERVER IS IN UNDERCONSTRUCTION.... Try to Conact Admin or send your question through abcd@youtube.com ");
			
			RequestDispatcher rd3=request.getRequestDispatcher("/JSP_SERVLET_JDBC_PROJECT/src/main/webapp/index.html");  
			
	        rd3.include(request, response);

		}else {
			
			out.print(" SORRY!!! SERVER IS IN UNDERCONSTRUCTION.... Try to Conact Admin or send your question through abcd@youtube.com ");
			
			RequestDispatcher rd4=request.getRequestDispatcher("/JSP_SERVLET_JDBC_PROJECT/src/main/webapp/index.html");  
	        rd4.include(request, response);

		}

	}

}
