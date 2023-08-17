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


@WebServlet("/member/update_action")
public class MemberUpdateActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //한글화,getParameter전에 선언
		MemberDto dto = new MemberDto();
		dto.setName(request.getParameter("name"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setStatus(request.getParameter("status"));
		dto.setId(request.getParameter("id"));
		
	
		String url="/member_ok.jsp"; // /는 wepapp
		try {
			MemberDao dao = new MemberDaoImpl();
			dao.update(dto);
			request.setAttribute("msg", "게시물 수정 성공");
		} catch (Exception e) {
		
			e.printStackTrace();
			url="/member_error.jsp";
			request.setAttribute("err_msg", e.getMessage()); //jsp한테 값 전달 setAttribute
		} 
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
