package fileupdown;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/cos")
public class cosfileup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//폼에입력된 한글데이터 인코딩
		request.setCharacterEncoding("utf-8");
		
		//브라우저로 응답컨텐츠형식
		response.setContentType("text/html; charset=utf-8");
		
		//브라우저에 데이터출력
		PrintWriter out = response.getWriter();
		
		String realForder ="C:\\jspwork2-master\\jwbook2\\src\\main\\webapp\\upload";
		int maxsize = 10*1024*1024; //1000
		String enctype = "utf-8"; //파일이름 한글인코딩
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		//5가지인자
		MultipartRequest multi = new MultipartRequest(request,realForder
				  ,maxsize,enctype,policy);
		
		//일반name속성
		String comment =  multi.getParameter("comment");
		out.println("설명:"+comment+"<br>");
		
		//file 파라미터 추출
		Enumeration<?> files = multi.getFileNames();
		
		while(files.hasMoreElements()) { //파일명이 있는동안반복
			String userfilename = (String) files.nextElement();
			
			//원본파일 이름
			String originalFilename = multi.getOriginalFileName(userfilename);
			if(originalFilename != null) {
				out.println("원본파일:"+originalFilename+"<br>");
				//실제저장될 이름
				String fileSystemname = multi.getFilesystemName(userfilename);
				out.println("실제파일:"+fileSystemname+"<br>");
				out.println("<a href=cosdown.do?filename="+fileSystemname+">다운로드</a><br>");
				
				//file객체생성
				File userfile = multi.getFile(userfilename);
				
				long filesize = userfile.length();
				
				//파일의 크기와 타입 출력
				if(filesize>0) {
					out.println("크기"+filesize+"B<br>");
					out.println("유형"+ multi.getContentType(userfilename) +"<br>");
					out.println("<p>=========================================</p>");
				}
			}
		}
		
		
	}

}








