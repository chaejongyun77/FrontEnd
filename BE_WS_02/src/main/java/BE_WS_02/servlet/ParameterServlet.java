package BE_WS_02.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BE_WS_02.dto.ParameterDto;



@WebServlet("/parameterServlet")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ParameterServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Map<String, Object> dataMap = new HashMap<>();
		    dataMap.put("job", "insert");
		    dataMap.put("pageNo", "10");
		    dataMap.put("searchWord", "bank");
		    
		    // 필요한 데이터를 추가로 담을 수 있습니다.
		    
		    // request 객체에 Map을 저장해서 forward
		    request.setAttribute("dataMap", dataMap);
		    
		    // getResult.jsp로 forward
		    request.getRequestDispatcher("getResult.jsp").forward(request, response);	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParameterDto dto = new ParameterDto();
		String name = request.getParameter("name");
		dto.setName(name);
		String email = request.getParameter("email");
		dto.setEmail(email);
		String gender = request.getParameter("gender");
		if(gender.equals("M")) {
			dto.setGender(gender);
		}
		if(gender.equals("F")){
			dto.setGender(gender);
		}
		
		
		String hobby = request.getParameter("hobby");
		if(hobby.equals("movie")){
			dto.setHobby(hobby);
		}
		if(hobby.equals("sport")){
			dto.setHobby(hobby);
		}
		if(hobby.equals("music")){
			dto.setHobby(hobby);
		}
		
		String favorite = request.getParameter("favorite");
		if(favorite.equals("ST")) {
			dto.setFavorite(favorite);
		}
		if(favorite.equals("SV")) {
			dto.setFavorite(favorite);
		}
		if(favorite.equals("PS")) {
			dto.setFavorite(favorite);
		}
		
		String desc = request.getParameter("desc");
		dto.setDesc(desc);

		
		request.setAttribute("dto", dto); //jsp에서 "dto"를 뽑아야함
		
		
		
		
		//memberRegist2.jsp로 포워드 , 출력은 JSP
		request.getRequestDispatcher("/postResult.jsp").forward(request, response);
	}

}
