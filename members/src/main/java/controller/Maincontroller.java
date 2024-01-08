package controller;

import java.io.IOException;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.Board;
import board.BoardDAO;
import member.Member;
import member.MemberDAO;
import reply.Reply;
import reply.ReplyDAO;
import voter.Voter;
import voter.VoterDAO;

@WebServlet("*.do")// */*이하의 경로에서 do로끝나는확장자는 모두허용
public class Maincontroller extends HttpServlet {
	private static final long serialVersionUID = 10L;
      MemberDAO mdao;
      BoardDAO bdao;
      ReplyDAO rdao;
      VoterDAO vdao;
     
    public Maincontroller() {
    	  mdao = new MemberDAO();
    	  bdao=new BoardDAO();
    	  rdao = new ReplyDAO();
    	  vdao= new VoterDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    //한글인코딩
		request.setCharacterEncoding("utf-8");
		//응답할컨텐츠 유형
		response.setContentType("text/html; charset=utf-8");
		
		//경로설정
		//uri= context(/)+파일경로(.do)
		String uri= request.getRequestURI();
		System.out.println(uri);
		String command = uri.substring(uri.lastIndexOf("/"));
		System.out.println(command);
		
		
		String nextPage = "";
		
		HttpSession sst = request.getSession();
		//viwe에출력객체생성
		//PrintWriter out = response.getWriter();
		if(command.equals("/main.do")) {
			//메인페이지에 게시글보내기
			List<Board> bl= bdao.getblist();
			System.out.println(bl.size()+"개");
			request.setAttribute("bl1",bl);
			if(bl.size() >=3) {
			Board[] newBoard= {bl.get(0),bl.get(1),bl.get(2)};						
			request.setAttribute("bl1",newBoard);			
			}
			nextPage="/main.jsp";	
			
		}else if(command.equals("/memberlist.do")) {
			//회원정보를 db에서조회
			List<Member> ml= mdao.getAllmember();
			request.setAttribute("ml2",ml);		
			//이동할페이지
			nextPage = "/member/memberlist.jsp";	
			
		}else if(command.equals("/memberjoin.do")) {
			nextPage = "/member/memberjoin.jsp";
			
		}else if(command.equals("/insertmember.do")) {
			//빈회원 객체 생성
			Member m = new Member();
			//폼 데이터 받기
			String id = request.getParameter("id");
			String pw = request.getParameter("passwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			
			m.setMemid(id);
			m.setPw(pw);
			m.setName(name);
			m.setEmail(email);
			m.setGender(gender);
			mdao.insertmember(m);
			
			//회원가입후 자동로그인
			sst.setAttribute("sbsession",m.getMemid()); //아이디를 가져와서 세션이름발급
			sst.setAttribute("sessionname",m.getName()); //성명을가져와서 sessionname 발급
					
			nextPage = "index.jsp";	
			
		}else if(command.equals("/memberview.do")) {
			String memid = request.getParameter("memid");
			
			Member onem= mdao.getmember(memid);
			//모델생성
			request.setAttribute("onem1", onem);
			
			nextPage = "/member/memberview.jsp";
		}else if(command.equals("/loginform.do")) {//로그인홈페이지 이동
			nextPage="/member/loginform.jsp";
			
		}else if(command.equals("/login.do")) {//로그인처리
			
			//아디 비번 파라메다 받기
			String id = request.getParameter("memid");
			String pw = request.getParameter("pw");
			
			Member m = new Member();
			m.setMemid(id);
			m.setPw(pw);			
			//로그인인증
			Member result =  mdao.checkLogin(m);
			
			String name = result.getName();
			if(name != null) {//result가 참이면 세션발급
				sst.setAttribute("sbsession", id);
				sst.setAttribute("sessionname", name);
				//로그인 후 페이지 이동
				nextPage="/index.jsp";
			}else {
				String errora="아이디나 비밀번호를 다시 확인해주세요";
				request.setAttribute("errora", errora);
				nextPage="/member/loginform.jsp";
				System.out.println("에러");			
			}
												
		}else if(command.equals("/logout.do")) {
			sst.invalidate();//모든세션삭제
			nextPage="/index.jsp";			
		}
						
		//게시판
		if(command.equals("/boardlist.do")) {
			//페이지 처리
			String pageNum = request.getParameter("pageNum");
			if(pageNum == null) { //페이지 번호를 클릭하지 않았을때 기본값
				pageNum = "1";
			}
			//현재 페이지
			int currentPage = Integer.parseInt(pageNum);
			//페이지당 게시글 수 = 10(pageSize)
			int pageSize = 10;
			//페이지당 게시글 수 - 10개로 설정(pageSize)
			//1페이지의 첫번째 행(startRow) : 1번,  1페이지 : 1~10, 2페이지 : 11~20
			int startRow = (currentPage-1)*pageSize + 1;
			//시작페이지(StartPage) - 12행 - 2페이지, 22행 - 3페이지
			int startPage = startRow / pageSize + 1;
			
			//종료(끝) 페이지 : (전체 게시글 총 수 / 페이지 당 개수)
			int totalRow = bdao.getboardc();
			int endPage = totalRow /pageSize;
			//페이지당 개수(10)로 나누어 떨어지지 않는 경우
			endPage = (totalRow % pageSize == 0) ? endPage : endPage + 1;
			
			//검색 처리
			String _field = request.getParameter("field"); //임시로 저장
			String _kw = request.getParameter("kw");
			
			String field = "";
			String kw ="";
			
			//null 처리
			if(_field != null) { //검색값이 있는 경우
				field = _field;
			}else { //검색값이 없는 경우(디폴트)
				field = "title";
			}
			if(_kw != null) { //검색어가 있는경우
				kw = _kw;
			}else { //검색어가 없는경우
				kw = "";
			}
			
			//페이지 처리 목록 매서드 호출
			//List<Board> boardList = bdao.getblist(currentPage);
			
			//검색 처리
			//List<Board> boardList = bdao.getblist(field, kw) ;
			
			//페이지와 검색처리
			List<Board> bl = bdao.getblist(field, kw, currentPage);
			
			//모델로 생성
			request.setAttribute("bList", bl);
			
			request.setAttribute("page", currentPage); //현재페이지
			request.setAttribute("startpage", startPage); //시작페이지
			request.setAttribute("endp", endPage); //마지막페이지
			
			request.setAttribute("field", field);  //검색어
			request.setAttribute("kw", kw);  //검색어
			
			nextPage = "/board/boardlist.jsp";
			
			
			
		}else if(command.equals("/writeform.do")) {	
			nextPage = "/board/writeform.jsp";
			
		}else if(command.equals("/writer.do")) {
			
			
		
			String realForder ="C:\\jspwork2-master\\members\\src\\main\\webapp\\upload";
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
				
				//원본파일 이름
				//String originalFilename = multi.getOriginalFileName(userfilename);
				
					//실제저장될 이름
					filename = multi.getFilesystemName(userfilename);					
			}
					
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
		
			String sid = (String) sst.getAttribute("sbsession");
			//DB에 저장
			Board b = new Board();
			b.setTitle(title);
			b.setContent(content);
			b.setMemid(sid);
			b.setFilename(filename);
			
			bdao.insertwrite(b);
			
			nextPage = "/boardlist.do";
		}else if(command.equals("/boardview.do")) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			Board bb = bdao.getboard(bno);
			
			String id = (String) sst.getAttribute("sbsession");
						//좋아요 개수 해당 개시글의 개수를 출력
			int votecount =  vdao.votecount(bno);
			
		    //하트상태변경
			boolean sw = false;
			int result = vdao.checkvoter(bno, id);
			if(result == 0 ) {
				sw = true;
			}else {
				sw = false;
			}
			
			List<Reply> rl =  rdao.getreplylist(bno);
			//모델생성해서뷰로보내기
			 
			request.setAttribute("votecount", votecount);
			request.setAttribute("bb1", bb);
			request.setAttribute("rl1", rl);
			request.setAttribute("sw", sw);
			nextPage="/board/boardview.jsp";
		}else if(command.equals("/deleteboard.do")) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			bdao.deleteboard(bno);
			nextPage="/boardlist.do";
			
		}else if(command.equals("/updateboardform.do")) {
			
			int bno = Integer.parseInt(request.getParameter("bno"));
			Board b = bdao.getboard(bno);
			
			//댓글목록보기
			request.setAttribute("b", b);				
			
			nextPage="/board/updateboardform.jsp";
			
		}else if(command.equals("/updateboard.do")){
			
			String realForder ="C:\\jspwork2-master\\members\\src\\main\\webapp\\upload";
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
				
				//원본파일 이름
				//String originalFilename = multi.getOriginalFileName(userfilename);
				
					//실제저장될 이름
			filename = multi.getFilesystemName(userfilename);					
			}
			
			int bno = Integer.parseInt(multi.getParameter("bno"));
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
		
			//String sid = (String) sst.getAttribute("sbsession");
			//DB에 저장
			Board b = new Board();
			b.setTitle(title);
			b.setContent(content);
			b.setFilename(filename);
			b.setBno(bno);
			//파일 유무에 따른처리
			if(filename != null) {
				bdao.updateboard(b);
			}else {
				bdao.updatenofileboard(b);
			}
			nextPage="/boardlist.do";
			
		}else if(command.equals("/like.do")) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			String id = request.getParameter("id");
			Voter v = new Voter();
			
			v.setBno(bno);
			v.setMid(id);
			//좋아요 저장 유무체크
			int result = vdao.checkvoter(bno,id);
			if(result == 0) {
				vdao.insertvote(v); //좋아요 추가
			}else{ 
				vdao.deletevote(v);
			}
			//좋아요삭제
			//vdao.deletevote();
			
	
		}
		 if(command.equals("/insertreply.do")) {
			String rcontent= request.getParameter("rcontent");
			String replyer=  request.getParameter("replyer");
			int bno =Integer.parseInt(request.getParameter("bno"));
			
			Reply rr = new Reply();
			rr.setBno(bno);
			rr.setRcontent(rcontent);
			rr.setReplyer(replyer);
			
			rdao.insertreply(rr);
			
		 }if(command.equals("/deletereply.do")) {
			int rno =  Integer.parseInt(request.getParameter("rno"));
			rdao.deletereply(rno);
		 }
			if(command.equals("/writer.do")||command.equals("/updateboard.do")) {
				//새로고침 중복생성 문제해결
				response.sendRedirect("/boardlist.do");
				
			}else if(command.equals("/insertreply.do") || command.equals("/deletereply.do")
					|| command.equals("/like.do")) {
				int bno =Integer.parseInt(request.getParameter("bno"));
				response.sendRedirect("/boardview.do?bno="+bno);
			}
			else {
				RequestDispatcher ds= request.getRequestDispatcher(nextPage);
				ds.forward(request, response);
			}
		
	}
}