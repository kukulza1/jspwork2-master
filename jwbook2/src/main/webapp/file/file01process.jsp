<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");
//String name =  request.getParameter("username");
//String title =  request.getParameter("title");
 //5가지의 생성자 -request,업로드폴더경로,파일사이즈, 인코딩, 중복파일이름추가
  String realfolder = "C:/jspwork2-master/jwbook2/src/main/webapp/upload";
   MultipartRequest multi = new MultipartRequest(request,realfolder,5*1024*1024,"utf-8",
		             new DefaultFileRenamePolicy());


   //일반name속성
   String name =  multi.getParameter("username");
   String title = multi.getParameter("title");
   out.println("회원이름:"+name+"<br>");
   out.println("제목:"+title+"<br>");
     
     //file name 속성
     Enumeration<String> files = multi.getFileNames();
     while(files.hasMoreElements()){
    	 String fname = files.nextElement(); //파일의name속성이 있으면
    	 String filename = multi.getFilesystemName(fname); //업로드된파일
    	 String original = multi.getOriginalFileName(fname);//원본파일
    	 String type = multi.getContentType(fname);//컨텐츠유형
    	 
    	 //파일의 용량 알기
    	 File file =multi.getFile(fname);
    	 
    	 out.println("업로드파일 이름:"+filename+"<br>");
    	 out.println("원본파일 이름:"+original+"<br>");
    	 out.println("파일컨텐츠유형:"+type+"<br>");
    	 if(file != null){
    		 out.println(""+file.length()+"B");
    	 }
     }
     
%>