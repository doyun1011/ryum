package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ShareObj;


@WebServlet("/Context3")
public class ServletContextTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext sc = this.getServletContext();
		
		ShareObj obj1 = (ShareObj)sc.getAttribute("data1");
		ShareObj obj2 = (ShareObj)sc.getAttribute("data2");
		
		out.print("DATA 1 : " +obj1.getNum() + ", " + obj1.getStr() + "<br>");
		out.print("DATA 2 : " +obj2.getNum() + ", " + obj2.getStr());
		out.close();
	}


}
