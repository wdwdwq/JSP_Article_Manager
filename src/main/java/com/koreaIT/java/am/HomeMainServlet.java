package com.koreaIT.java.am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home/main")
public class HomeMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/jsp/home/main.jsp").forward(request, response);
		
	}

}

//		.append(request.getContextPath())
// 여기를 지정을 안해줘서 아직 내 프로젝트 이름으로 들어간다

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		doGet(request, response);
//	}
