package com.chm.exam.exam2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chm.exam.exam2.dto.Article;
import com.chm.mysqlutil.MysqlUtil;
import com.chm.mysqlutil.SecSql;

@WebServlet("/usr/article/list")
public class UsrArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsrArticleListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 들어오는 파라미터를 UTF-8로 해석
		request.setCharacterEncoding("UTF-8");
		
		// 서블릿이 HTML 파일을 만들 때 UTF-8 로 쓰기
		response.setCharacterEncoding("UTF-8");
		// HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
		response.setContentType("text/html;charset=utf-8");
		
		MysqlUtil.setDBInfo("localhost", "chmst", "chm1234", "jsp_board");
		MysqlUtil.setDevMode(true);
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		SecSql sql = new SecSql();
		sql.append("SELECT A.*");
		sql.append("FROM article AS A");
		sql.append("ORDER BY A.id DESC");
		List<Article> articles = MysqlUtil.selectRows(sql, Article.class);
		
		request.setAttribute("articles", articles);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/usr/article/list.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
