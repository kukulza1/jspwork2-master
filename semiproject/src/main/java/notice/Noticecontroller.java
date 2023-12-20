/*package notice;

import java.io.IOException;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("*notice.do")
public class Noticecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticeDAO nDAO;
    public Noticecontroller() {
    	nDAO= new NoticeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri= request.getRequestURI();
		System.out.println(uri);
		String command = uri.substring(uri.lastIndexOf("/"));
		String nextPage = "";
		System.out.println(command);
		
		
		if(command.equals("/noticeWrite.do")) { //관리자 공지사항에 글쓰기
		
		String realForder ="C:\\jspwork2-master\\semiproject\\src\\main\\webapp\\upload";
		int maxsize = 10*1024*1024; //1000
		String enctype = "utf-8"; //파일이름 한글인코딩
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		//5가지인자
		MultipartRequest multi = new MultipartRequest(request,realForder
				  ,maxsize,enctype,policy);
		Enumeration<?> files = multi.getFileNames();
		
		String filename = "";
		while(files.hasMoreElements()) { //파일명이 있는동안반복
			String userfilename = (String) files.nextElement();
			
			
			filename = multi.getFilesystemName(userfilename);					
		}
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String nname = multi.getParameter("nname");
		
		NoticeVO nv = new NoticeVO();
		nv.setNtitle(title);
		nv.setNcontent(content);
		nv.setNname(nname);
		nv.setFilename(filename);
		
		nDAO.noticewrite(nv);
		nextPage="/notice/noticeWrite.jsp";
		
	}else if(command.equals("/deletenotice.do")){
		int nno = Integer.parseInt(request.getParameter("nno"));
		nDAO.deleteboard(nno);
		
		nextPage="/notice/notice.jsp";
		
	}else if(command.equals("/updatenoticeform.do")) {
		int nno = Integer.parseInt(request.getParameter("nno"));
		NoticeVO nv = nDAO.getnotice(nno);
		
		request.setAttribute("nv", nv);	
		
		nextPage="/notice/updateboardform.jsp";
	}
	
	else if(command.equals("/updatenotice.do")) {
		
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		NoticeVO nv = new NoticeVO();
		nv.setNtitle(ntitle);
		nv.setNcontent(ncontent);
		nv.setNno(nno);
		
		nDAO.updatenotice(nv);
			
		nextPage="/notice/notice.do";
			
	}else if(command.equals("/notice.do")) {
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) { 
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10;
		int startRow = (currentPage-1)*pageSize + 1;
		int startPage = startRow / pageSize + 1;
		
		int totalRow = nDAO.getnoticecount();
		int endPage = totalRow /pageSize;
		endPage = (totalRow % pageSize == 0) ? endPage : endPage + 1;
		
		//검색 처리
		String _field = request.getParameter("field"); 
		String _kw = request.getParameter("kw");
		
		String field = "";
		String kw ="";
		
		if(_field != null) { 
			field = _field;
		}else { 
			field = "title";
		}
		if(_kw != null) { 
			kw = _kw;
		}else { 
			kw = "";
		}
		
		
		
		List<NoticeVO> nl = nDAO.getnoticelist(currentPage);
		
		request.setAttribute("nl", nl);
		
		request.setAttribute("page", currentPage); 
		request.setAttribute("startpage", startPage); 
		request.setAttribute("endp", endPage); 
		
		//request.setAttribute("field", field); 
		//request.setAttribute("kw", kw);  
		
		nextPage="/notice/notice.jsp";
	}
		
		
		
	 RequestDispatcher ds= request.getRequestDispatcher(nextPage);
		ds.forward(request, response);
		
		//doGet(request, response);
	}

}
*/