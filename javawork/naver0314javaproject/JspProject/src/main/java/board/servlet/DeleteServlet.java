package board.servlet;

import data.dao.SimpleBoardDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "delete", value = "/board/delete")
public class DeleteServlet extends HttpServlet {
    SimpleBoardDao dao = new SimpleBoardDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int num = Integer.parseInt(request.getParameter("num"));
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));


        dao.deleteBoard(num);
        response.sendRedirect("./list?currentPage="+currentPage);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
