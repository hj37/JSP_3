package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//현재 아래의 서블릿 클래스는 login.html에서 입력한 정보를 요청받아 웹브라우저로 응답하는 역할의 서블릿임.


@WebServlet("/login2") //서블릿 매핑이름을 이용해서 요청받음
public class LoginServlet2 extends HttpServlet {
	//메소드오버라이딩(메소드 기능 재구현)
	
	//클라이언트가 login.html에서 이름과 비밀번호 입력후 로그인버튼(전송,요청버튼)을 클릭했을때..
	//현재 위의 LoginServlet을 요청한다.
	//요청시.. 입력한 정보들을  HttpServletRequest객체에 저장후~ doGet메소드의 매개변수로 전달 한다.
	//이런 HttpServletRequest객체는 톰캣컨테이너가 객체를 생성한후  doGet메소드의 매개변수로 전달 한다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전송된 데이터가 한글이 하나라도 존재 하면 한글이 깨지므로 인코딩 방식을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		//response객체에 클라이언트의 웹브라우저로 응답할 데이터 종류를 지정함
		response.setContentType("text/html;charset=utf-8");
		
		//response객체의 getWriter()메소드를 호출해 클라이언트의 웹브라우저로 응답데이터를 내보내는 역할을 하는
		//PrintWriter객체를 리턴받아 사용함.
		PrintWriter out = response.getWriter();
		
		//login.html에서 입력한 아이디를  request객체메모리에서 꺼내어서 얻기 
		//request객체메모리에서 하나의 값을 얻을때는 getParameter()메소드를 이용한다.
		String user_id = request.getParameter("user_id");	
		String user_pw = request.getParameter("user_pw");
	
		//클라이언트의 웹브라우저 내보낼?(응답할?,출력할?) 데이터를 html태그 형식의 문자열로 만든다.
		String data = "<html>";
			   	data += "<body>";
			   		data +="아이디 : " + user_id + "<br>";
			   		data +="비밀번호 : " + user_pw;
			   	data += "</body>";
			   data += "</html>";
	
		//클라이언트의 웹브라우저로 출력(응답,데이터 내보내기)
	    out.print(data);  //PrintWriter객체의 print()메소드를 이용해 HTML태그형식의 문자열을 웹브라우저로 출력
	}
	@Override
	public void destroy() {
		
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init 메소드 호출");
	}	
}
