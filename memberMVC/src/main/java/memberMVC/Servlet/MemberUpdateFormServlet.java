package memberMVC.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberMVC.dao.MemberDao;
import memberMVC.dao.MemberDaoImpl;
import memberMVC.dto.MemberDto;



@WebServlet("/member/update_form")
public class MemberUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		String url = "/member_update_form.jsp";
		MemberDao dao = new MemberDaoImpl();
		try {
			MemberDto dto = dao.findById(id);
			System.out.println(dto);
			request.setAttribute("dto", dto);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "/member_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);

	}
}
