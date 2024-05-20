package board.servlet;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/insert")
public class InsertServlet extends HttpServlet {
    SimpleBoardDao dao=new SimpleBoardDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        SimpleBoardDto dto = new SimpleBoardDto();
        dto.setWriter(request.getParameter("writer"));
        dto.setSubject(request.getParameter("subject"));
        dto.setAvata(request.getParameter("avata"));
        dto.setContent(request.getParameter("content"));

        dao.insertBoard(dto);



        //목록으로 리다이렉트
        response.sendRedirect("./list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
