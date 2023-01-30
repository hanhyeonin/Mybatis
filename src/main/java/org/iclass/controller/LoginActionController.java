package org.iclass.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;

public class LoginActionController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();

		Map<String, String> map = new HashMap<String, String>();

		map.put("id", id);
		map.put("password", password);
		NewMember vo = dao.login(map);
		// ㄴ dao.login() 메소드 안에는 id, password 값을 비교하는 sql문이 있다
		// 즉, if문으로 한번 더 비교할 필요가 없다.

		// System.out.println(vo.getPassword()); => null (?)
		// dao.login() 안에서 사용된 select문에는 id, name, email만 조회하는 sql문이 있다.
		// 그래서 vo.getPassword() 값은 null로 나온다.

		if (vo != null) {
			// 로그인 성공
			session.setAttribute("user", vo); // 핵심
			response.sendRedirect(request.getContextPath());
		} else
			response.sendRedirect("fail.jsp");
	}

}

