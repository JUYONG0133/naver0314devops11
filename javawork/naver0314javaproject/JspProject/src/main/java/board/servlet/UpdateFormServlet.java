package board.servlet;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "updateform", value = "/board/updateform")
public class UpdateFormServlet extends HttpServlet {
    SimpleBoardDao dao = new SimpleBoardDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int num = Integer.parseInt(request.getParameter("num"));
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));

        SimpleBoardDto dto = dao.getData(num);

        request.setAttribute("dto",dto);
        request.setAttribute("currentPage",currentPage);



        RequestDispatcher rd=request.getRequestDispatcher("../day0514/updateform.jsp");
        rd.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
