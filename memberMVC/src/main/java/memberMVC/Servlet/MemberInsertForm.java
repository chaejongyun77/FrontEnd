package memberMVC.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/insert_form")
public class MemberInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberInsertForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member_insert_form.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	

}
