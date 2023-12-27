package com.koreaIT.java.am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.koreaIT.example.JAM.util.DBUtil;
import com.koreaIT.example.JAM.util.SecSql;

@WebServlet("/article/delete")
public class ArticleDoDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deleteId = request.getParameter("id");

        if (deleteId != null) {
            Connection conn = null;
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
    			String url = "jdbc:mysql://127.0.0.1:3306/JSPAM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
    			conn = DriverManager.getConnection(url, "root", "");

                int articleId = Integer.parseInt(deleteId);
                SecSql deleteSql = new SecSql();
                deleteSql.append("DELETE FROM article");
                deleteSql.append("WHERE id = ?", articleId);

                int affectedRows = DBUtil.update(conn, deleteSql);

                if (affectedRows > 0) {
                    // 삭제 성공 시 list.jsp로 리다이렉트
                    response.sendRedirect(request.getContextPath() + "/article/list");
                    return;
                } else {
                    // 삭제 실패 처리
                }
            } catch (ClassNotFoundException e) {
                System.out.println("드라이버 로딩 실패");
            } catch (SQLException e) {
                System.out.println("에러: " + e);
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 삭제 실패 또는 ID가 없는 경우 detail.jsp로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/article/detail?id=" + deleteId);
    }
}
