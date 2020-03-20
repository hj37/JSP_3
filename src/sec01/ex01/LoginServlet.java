package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//현재 아래의 서블릿 클래스는 login.html에서 입력한 정보를 요청받아 웹브라우저로 응답하는 역할의 서블릿임.


@WebServlet("/login") //서블릿 매핑이름을 이용해서 요청받음
public class LoginServlet extends HttpServlet {
	//메소드오버라이딩(메소드 기능 재구현)
	
	//클라이언트가 login.html에서 이름과 비밀번호 입력후 로그인버튼(전송,요청버튼)을 클릭했을때..
	//현재 위의 LoginServlet을 요청한다.
	//요청시.. 입력한 정보들을  HttpServletRequest객체에 저장후~ doGet메소드의 매개변수로 전달 한다.
	//이런 HttpServletRequest객체는 톰캣컨테이너가 객체를 생성한후  doGet메소드의 매개변수로 전달 한다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전송된 데이터가 한글이 하나라도 존재 하면 한글이 깨지므로 인코딩 방식을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		//login.html에서 입력한 아이디를  request객체메모리에서 꺼내어서 얻기 
		//request객체메모리에서 하나의 값을 얻을때는 getParameter()메소드를 이용한다.
		String user_id = request.getParameter("user_id");	
		String user_pw = request.getParameter("user_pw");
	
		System.out.println(user_id);
		System.out.println(user_pw);
		
	}
	@Override
	public void destroy() {
		
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init 메소드 호출");
	}	
}
