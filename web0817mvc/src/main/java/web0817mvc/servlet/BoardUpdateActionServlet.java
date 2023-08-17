package web0817mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0817mvc.dao.BoardDao;
import web0817mvc.dao.BoardDaoImpl;
import web0817mvc.dto.BoardDto;
import web0817mvc.exception.DuplicatedIdException;

/**
 * Servlet implementation class BoardInsertActionServlet
 */
@WebServlet("/board/update_action")
public class BoardUpdateActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardDto생성, 데이터 저장
		request.setCharacterEncoding("UTF-8"); //한글화,getParameter전에 선언
		BoardDto dto = new BoardDto();
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContent(request.getParameter("content"));
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		
	
		String url="/board_ok.jsp"; // /는 wepapp
		try {
			BoardDao dao = new BoardDaoImpl();
			dao.update(dto);
			request.setAttribute("msg", "게시물 수정 성공");
		} catch (Exception e) {
		
			e.printStackTrace();
			url="/board_error.jsp";
			request.setAttribute("err_msg", e.getMessage()); //jsp한테 값 전달 setAttribute
		} 
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
