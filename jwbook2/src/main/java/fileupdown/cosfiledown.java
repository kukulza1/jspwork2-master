package fileupdown;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cosdown.do")
public class cosfiledown extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
		String filename = request.getParameter("filename");
		
		 ServletContext  context = getServletContext();
		 String realfolder  = context.getRealPath("upload");
		 
		 //실제서버에 저장된 파일 이름
		 String realfile = realfolder + "\\"+ filename;
		 
		 //파일객체생성
		 File file = new File(realfile);
		 
		 //파일이름에 한글이있는경우 인코딩
		 filename = new String(filename.getBytes("utf-8"),"ISO-8859-1");
		 
		 //헤더설정
		 //content-Disposition-저장형태 attachment-파일저장 inline-브라우저로 저장
		 response.setHeader("Content-Disposition", 
				 "attachment;filename=\"" + filename+ "\"");
		 //다운로드할 파일 크기를 클라에 저장
		 response.setContentLength((int) file.length());
		 //항상 파일이 서버에서 다운로드 되도록함,cache(임시저장)에서 다운로드 되지 않고
		 response.setHeader("Cache-control", "no-cache");
		
		//파일쓰기-다운로드
		FileInputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		
		byte[] data = new byte[1024*1024];
		
		int count = 0;
		while((count = in.read()) != -1) {
			out.write(data,0,count);
			
			
			
			
			
		}
		in.close();
		out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


































