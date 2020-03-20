package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost메소드 호출당함");
		
		//요청한 데이터들은 모두 request객체메모리 영역에 저장되어 있다.
		//만약 한글이 하나라도 존재하면 한글이 깨지므로 
		//인코딩방식을 UTF-8로 설정해서 한글이 깨지는 것을 방지하자
		//<<<<한글 처리>>>>
		request.setCharacterEncoding("UTF-8");
		
		//요청값 얻기(입력한 아이디, 비밀번호 , <input type="hidden" name="user_addresss">으로 전달되온  주소 )
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		
		//요청값을 얻은 후 응답할 값을 마련 
		String data = "<html><body>";
			   data += "아이디 : " + id + "<br>";
			   data += "비밀번호 : " + pw + "<br>";
			   data += "주소 : " + address + "<br>";
			   data += "</body></html>";
		
		//마련한 응답값을 웹브라우저로 전송 하여 출력(응답)
		//1.응답할 데이터의 마임타입 설정
		response.setContentType("text/html;charset=utf-8");
		//2.클라이언트로 응답할 출력 스트림 통로역할을 하는 PrintWriter객체 얻기 
		PrintWriter out = response.getWriter();
		//3.PrintWriter객체의 print()메소드를 이용하여 클라이언트의 웹브라우저로 데이터를 응답함.
		out.print(data);
		
	}

}






