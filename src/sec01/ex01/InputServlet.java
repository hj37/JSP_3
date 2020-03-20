package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input")
public class InputServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 방식 UTF-8로 설정 하여 요청한 데이터 한글꺠짐 방지
		request.setCharacterEncoding("UTF-8");
		//request객체 메모리에서 입력한 아이디와 비밀번호를 꺼내어서 얻기
		String user_id = request.getParameter("user_id"); //입력한 아이디 얻기 
		String user_pw = request.getParameter("user_pw"); //입력한 비밀번호 얻기
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pw);
		
		//하나의 name속성 이름으로 여러값을 전송하는 경우 
		//getParameterValues메소드를 이용해 배열 형태로 반환됩니다.
		String[] subject = request.getParameterValues("subject");
				
		for(String str : subject) {
			
			System.out.println("선택한 과목 : " + str);
		}				
	}

}





