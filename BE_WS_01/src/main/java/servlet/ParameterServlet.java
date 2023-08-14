package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet("/parameterServlet")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");
		
		
		
		String job = request.getParameter("job");
	     String pageNo = request.getParameter("pageNo");
	     String searchWord = request.getParameter("searchWord");
	     System.out.println("Job: " + job);
	        System.out.println("PageNo: " + pageNo);
	        System.out.println("SearchWord: " + searchWord);

	        response.setContentType("text/html");
	        response.getWriter().println("<h1>ParameterServlet - doGet 메서드 호출</h1>");
	        response.getWriter().println("<p>Job: " + job + "</p>");
	        response.getWriter().println("<p>PageNo: " + pageNo + "</p>");
	        response.getWriter().println("<p>SearchWord: " + searchWord + "</p>");
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String hobby = request.getParameter("hobby");
		
		String favorite = request.getParameter("favorite");
		String content = request.getParameter("content");
		response.getWriter().append("name : "+ name+"\n\r");
		response.getWriter().append("email : "+email+"\n\r");
		if(gender.equals("M")) {
			response.getWriter().append("gender : " + gender+"\n\r");
		}
		if(gender.equals("F")){
			response.getWriter().append("gender : " + gender+"\n\r");
		}
		if(hobby.equals("movie")){
			response.getWriter().append("hobby : " + hobby+"\n\r");
		}
		if(hobby.equals("sport")){
			response.getWriter().append("hobby : " + hobby+"\n\r");
		}
		if(hobby.equals("music")){
			response.getWriter().append("hobby : " + hobby+"\n\r");
		}
		if(favorite.equals("ST")) {
			response.getWriter().append("favorite : ST");
		}
		if(favorite.equals("SV")) {
			response.getWriter().append("favorite : SV");
		}
		if(favorite.equals("PS")) {
			response.getWriter().append("favorite : PS");
		}
		response.getWriter().append("desc : "+ content);
	
	}

}
