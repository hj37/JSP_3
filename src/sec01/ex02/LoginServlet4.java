package sec01.ex02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//get방식으로 요청 가능, Post방식으로 요청 가능한 서블릿 만들기

@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet{
	
	//doGet, doPost메소드 오버라이딩   ->  alt + shift + s  v
	
	//클라이언트가 GET방식으로 요청하면 호출되는 메소드 
	//GET요청방식의 종류
	//1. <a href='/login4'>서블릿으로 요청</a>
	//2. <form method="get"></form>
	//3. 웹브라우저 주소창에 주소를 직접 입력해서 서블릿 요청!
	//GET요청방식은? 요청시 웹브라우저 주소창에 주소  + 값을 노출 시키면서 요청하여 보안에 취약하다.
	//             적은 양의 데이터를 서블릿으로 요청할때 사용함.(개발시 전달하는 값이 무엇인지 알아낼떄 사용)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet메소드 호출당함");
		doHandle(request, response);
	}
	//클라이언트가 POST방식으로 요청하면 호출되는 메소드 
	//1. <form method="post"></form>
	//POST요청방식은? 요청시 웹브라우저 주소창에 주소 만 노출시켜 보안에 좋다.
	//              많은 양의 데이터를 서블릿으로 요청할떄 사용함.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost메소드 호출당함");
		doHandle(request, response);
	}

	//클라이언트가 GET방식으로 요청 하든 POST방식으로 요청하든간에 모든 호출방식에 대해서 처리할수 있는 메소드 
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doHandle메소드 호출당함.");
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		//요청값얻기(입력한 아이디, 비밀번호)
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("입력한 아이디 : " + user_id);
		System.out.println("입력한 비밀번호 : " + user_pw);
	}
	
	
}





