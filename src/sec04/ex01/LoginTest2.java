package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//문제 : 로그인시 admin ID로 로그인하면 회원관리와 회원삭제 기능을 보여주도록 작성하시오.

//LoginTest서블릿의 주요역할 : 
//ID나 비밀번호를 제대로 입력하지 않으면 오류메세지를 출력한 후 
//다시 로그인창으로 이동시킴 

@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init메소드 호출당함");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 한글 처리(인코딩 방식 설정)
		request.setCharacterEncoding("UTF-8");
		// 2. 요청값 얻기 (입력한 아이디, 비밀번호 얻기)
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		// 3. 응답값 마련
		// 응답할 데이터의 종류(유형,MINE-TYPE)을 텍스트기반의 HTML태그형식으로 설정, 또한 응답할 데이터 한글처리
		response.setContentType("text/html;charset=utf-8");
		// 클라이언트의 웹브라우저로 출력할 스트림통로역할을 하는 객체 얻기
		PrintWriter out = response.getWriter();
		// 입력한 아이디가 존재한다면?
		if (id != null && (id.length() != 0)) {

			// 입력한 아이디가 admin이면 관리자 화면을 보여줍니다.
			if (id.equals("admin")) {
				out.print("<html>");
				out.print("<body>");
				out.print("<font size='12'>관리자로 로그인 하셨습니다!</font>");
				out.print("<br>");
				out.print("<input type='button' value='회원정보 수정하기'/>");
				out.print("<input type='button' value='회원정보 삭제하기'/>");
				out.print("</body>");
				out.print("</html>");
			} else {// 입력한 아이디가 admin이 아닌 일반 회원 아이디라면?
					// 클라이언트의 웹브라우저로 id님~ 로그인 하셨습니다. <-- 출력
				out.print("<html>");
				out.print("<body>");
				out.print(id + "님! 로그인 하셨습니다.");
				out.print("</body>");
				out.print("</html>");
			}

		} else {// 입력한 아이디가 존재 하지 않는다면? 다시~~ 로그인창으로 이동시키는 <a>링크를 작성하자
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요!!!<br>");
			out.print("<a href='http://localhost:8080/pro07/test01/login.html'>로그인 창으로 이동</a>");
			out.print("</body>");
			out.print("</html>");
		}
	}
}
