package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import member.MemberDAO;

@WebServlet("/member/checkid")


public class checkid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
          MemberDAO mdao = new MemberDAO();
		//컨텐츠응답
		response.setContentType("text/html; charset=utf-8");
		
		//메시지받기
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		boolean result = mdao.getDuplicatedid(id);
		if(result) { //중복데이타가 있으면
			out.print("notusable");
		}else {
			out.print("usable");
		}
/*if(command.equals("/boardlist.do")) {
			
			String pn = request.getParameter("pagenum");
			int currentpage = Integer.parseInt(pn);
			int pagesize =10;
			int totalrow=bdao.getboardc();
			int startrow = (currentpage -1)*pagesize +1;
			
			 int startpage = startrow/pagesize +1 ;
			 
			int endpage = totalrow/pagesize;
			endpage = (totalrow % pagesize == 0)? endpage : endpage+1;
					
			if(pn == null) {
				pn= "1";
			}
			//검색처리
         String _field = request.getParameter("field");
         String _kw = request.getParameter("keyword");
         
         String field = "";
         String kw = "";
         if(_field != null) {
        	 field = _field;
         }else {//검색값이 없는 경우(디폴트)
        	 field = "title";
         }
         if(_kw != null) {//검색어가 있는경우
        	 kw = _kw;
         }else {  //검색어가 없는경우
        	 kw="";
         }
         
			List<Board> boardlist = bdao.getblist(field, kw);
         
			request.setAttribute("boardlist", boardlist);
			
		//	List<Board> bList = bdao.getblist(currentpage);
			//request.setAttribute("bList", bList);
			request.setAttribute("startpage", startpage);//시작페이지	
			request.setAttribute("page", currentpage);//현재페이지
			request.setAttribute("endp", endpage);//종료페이지
			
			nextPage="/board/boardlist.jsp";*/
		
		
		
	}

}
