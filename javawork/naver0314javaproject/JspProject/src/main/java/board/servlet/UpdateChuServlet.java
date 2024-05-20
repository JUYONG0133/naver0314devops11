package board.servlet;

import data.dao.SimpleBoardDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "updatechu", value = "/board/updatechu")
public class UpdateChuServlet extends HttpServlet {
    SimpleBoardDao dao = new SimpleBoardDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));

        dao.updateChu(num);

        int chu = dao.getData(num).getChu();

        String s = "{\"chu\":"+chu+"}";

        request.setAttribute("s",s);

        RequestDispatcher rd = request.getRequestDispatcher("../day0514/jsonchu.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
