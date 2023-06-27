package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Context1")
public class ServletContextTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext sc;
	public void init(ServletConfig config) throws ServletException {
		sc = config.getServletContext();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String driver = sc.getInitParameter("MariaDriver");
		System.out.println(driver);
		
	}

}
