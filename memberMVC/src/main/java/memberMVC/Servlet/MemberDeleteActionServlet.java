package memberMVC.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberMVC.dao.MemberDao;
import memberMVC.dao.MemberDaoImpl;
import memberMVC.dto.MemberDto;


@WebServlet("/member/delete_action")
public class MemberDeleteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardDto생성, 데이터 저장
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("id");
				
				String url = "/member_ok.jsp";
				try {
					MemberDao dao = new MemberDaoImpl();
					dao.delete( id );
					request.setAttribute("msg", "게시물 삭제 성공");
				} catch (Exception e) {
					e.printStackTrace();
					url = "/member_error.jsp";
					request.setAttribute("err_msg", e.getMessage());
				}
				request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
