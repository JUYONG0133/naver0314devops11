package board.servlet;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "update", value = "/board/update")
public class UpdateServlet extends HttpServlet {
    SimpleBoardDao dao = new SimpleBoardDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        SimpleBoardDto dto = new SimpleBoardDto();
        int num = Integer.parseInt(request.getParameter("num"));
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        dto.setNum(num);
        dto.setWriter(request.getParameter("writer"));
        dto.setSubject(request.getParameter("subject"));
        dto.setAvata(request.getParameter("avata"));
        dto.setContent(request.getParameter("content"));

        dao.updateBoard(dto);

        response.sendRedirect("./detail?num="+num+"&currentPage="+currentPage);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
