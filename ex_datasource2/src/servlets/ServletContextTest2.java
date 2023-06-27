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


@WebServlet("/Context2")
public class ServletContextTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext sc = this.getServletContext();
		
		ShareObj obj1 = new ShareObj();
		obj1.setNum(100);
		sc.setAttribute("data1", obj1);
		
		ShareObj obj2 = new ShareObj();
		obj2.setNum(200);
		sc.setAttribute("data2", obj2);
		
		
		out.print("ServletContext 객체에 데이터 등록을 하였습니다.");
		out.close();
	}



}
