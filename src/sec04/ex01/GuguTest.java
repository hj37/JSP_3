package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트의 요청을 받아 <table> 태그와 <tr>태그와 자바의 for문을 이용해 구구단을 연속해서 행으로 출력! 
@WebServlet("/guguTest")
public class GuguTest extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		//한글처리 
		request.setCharacterEncoding("UTF-8");
		//응답할 데이터 타입 설정
		response.setContentType("text/html;charset=utf-8");
		//응답할 출력 스트림 통로 역할을 하는 PrintWriter객체 얻기 
		PrintWriter out = response.getWriter();
		//입력한 단수를 request 객체메모리에서 꺼내오기 (요청값 얻기) 
		String newdan = request.getParameter("dan");
		//입력한 단수(문자열)을 정수로 변환해서 dan변수에 저장 
		int dan = Integer.parseInt(newdan);
		
		out.print("<table border=1 width=800 align=center>");
			out.print("<tr align=center bgcolor='yellow'>");
				out.print("<td colspan=2>" + dan + " 단 출력 </td>");
			out.print("</tr>");
		//응답값 마련 
		for(int i=1; i<10; i++) {
			
			out.print("<tr align=center>");
				out.print("<td width=400>");
				out.print(dan + "*" + i);
				out.print("</td>");
				out.print("<td width=400>");
				out.print(i * dan);
				out.print("</td>");
			out.print("</tr>");
		}
		
		out.print("</table>");
	}

}
