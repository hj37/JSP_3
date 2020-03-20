package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//현재 아래의 서블릿 클래스는 login.html에서 입력한 정보를 요청받아 웹브라우저로 응답하는 역할의 서블릿임.

//흐름> 클라이언트가 웹브라우저 주소창에 http://localhost:8080/pro06/login.html을 입력후
//     정적인 페이지인 login.html을 아파치 웹서버에 요청한다.
//	   정적인 login.html페이지가 웹브라우저 화면에 나오면  클라이언트는 아이디, 비밀번호를 입력후 
//    로그인 버튼을 클릭해  LoginServlet3서블릿을 요청한다.
//    요청시 <form>태그에서는  post방식의 요청이 일어나므로 서블릿을 요청한 매핑주소는
//    <form action="login3" method="post"> 이다
//    이때 입력한 데이터는 웹브라우저를 통해 LoginServlet3의 doPost()메소드의 매개변수인자로 전달되게 된다.

@WebServlet("/login3") //서블릿 매핑이름을 이용해서 요청받음
public class LoginServlet3 extends HttpServlet {
	//메소드오버라이딩(메소드 기능 재구현)
	
	//클라이언트가 login.html에서 이름과 비밀번호 입력후 로그인버튼(전송,요청버튼)을 클릭했을때..
	//현재 위의 LoginServlet을 요청한다.
	//요청시.. 입력한 정보들을  HttpServletRequest객체에 저장후~ doGet메소드의 매개변수로 전달 한다.
	//이런 HttpServletRequest객체는 톰캣컨테이너가 객체를 생성한후  doGet메소드의 매개변수로 전달 한다.
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		System.out.println("GET방식으로 요청이 들어왔네");
//	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("POST방식으로 요청이 들어왔네");
		
		//request객체에 저장된 요청값들이 한글이 하나라도 존재하면 꺠지므로 인코딩(문자셋) 방식을 UTF-8로 셋팅
		request.setCharacterEncoding("UTF-8");   //EUC-KR , UTF-8, ISO8859-1방식
		
		//1.login.html에서 입력한 요청값 얻기
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println(user_id + "," + user_pw);//post방식으로 요청이 들어왔을때의 요청값 콘솔탭에 출력
		
		//2.요청값을 얻은후 응답값 마련하기 (예를 들면...DB와 연동하여 검색한  회원정보  데이터 )
		
		//3.마련한 응답값 클라이언트의 웹브라우저로 응답하기 
		
		
	}
	
}





