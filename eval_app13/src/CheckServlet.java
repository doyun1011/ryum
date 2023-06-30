
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CheckupService;
import vo.MemberVO;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String addr = request.getParameter("addr");

		PrintWriter out = response.getWriter();
		CheckupService check = new CheckupService();

		if (addr != null) {
			MemberVO member = new MemberVO(name, id, pw, tel, addr);
			check.regMember(member);
			return;
		}
		if (id != null) {
			int result = check.checkId(id);
			out.print(result);
			return;
		}
		if (tel != null) {
			int result = check.checkTel(tel);
			out.print(result);
			return;
		}

	}

}
