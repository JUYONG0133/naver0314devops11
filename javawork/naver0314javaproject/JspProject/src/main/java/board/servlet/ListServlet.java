package board.servlet;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "list", value = "/board/list")
public class ListServlet extends HttpServlet {
    SimpleBoardDao dao = new SimpleBoardDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int totalCount = dao.getTotalCount();

        List<SimpleBoardDto> list=null;

        int perPage=5;
        int perBlock=3;
        int start;
        int startPage;
        int totalPage;
        int endPage;
        int currentPage;
        int no;

        if(request.getParameter("currentPage")==null)
            currentPage=1;
        else
            currentPage=Integer.parseInt(request.getParameter("currentPage"));

        totalPage=totalCount/perPage+(totalCount%perPage>0?1:0);

        startPage=(currentPage-1)/perBlock*perBlock+1;

        endPage=startPage+perBlock-1;

        if(endPage>totalPage)
            endPage=totalPage;

        start=(currentPage-1)*perPage;

        no=totalCount-(currentPage-1)*perPage;



        list=dao.getAllDatas(start,perPage);
        request.setAttribute("totalcount",totalCount);
        request.setAttribute("list",list);

        request.setAttribute("currentPage",currentPage);
        request.setAttribute("startPage",startPage);
        request.setAttribute("endPage",endPage);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("no",no);

        RequestDispatcher rd=request.getRequestDispatcher("/day0514/boardlist.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
