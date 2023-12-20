/*package member;

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

import buyend.BuyendDAO;
import notice.NoticeDAO;
import notice.NoticeVO;

@WebServlet("*member.do")
public class Membercontroller extends HttpServlet {
	private static final long serialVersionUID = 22L;
    BuyendDAO bDAO;   
	MemberDAO mDAO;
	NoticeDAO nDAO;
    public Membercontroller() {
        bDAO = new BuyendDAO();
        mDAO = new MemberDAO();
        nDAO= new NoticeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri= request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		String nextPage = "";
		
		HttpSession session = request.getSession();
		
		
		
		if(command.equals("/memberlist.do")) {//관리자 회원목록보기
			List<MemberVO> ml = mDAO.getAllmember();
			request.setAttribute("ml", ml);		
			nextPage="/memberlist.jsp";
			
		}else if(command.equals("/memberjoin.do")) { //회원가입 db넣기
			
			MemberVO m = new MemberVO();
			
			String id = request.getParameter("id");
			String pw = request.getParameter("passwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String zip_code = request.getParameter("zip_code");	
			String address = request.getParameter("address");
			String address2 = request.getParameter("detailAddress");
			
			m.setId(id);
			m.setPasswd(pw);
			m.setName(name);
			m.setEmail(email);
			m.setPhone(phone);
			m.setZip_code(zip_code);		
			m.setAddress(address);
			m.setDetailAddress(address2);
			
			mDAO.insertmember(m);
			nextPage = "/petshop/buyend.jsp";
						
		
		}else {
			
		}
		RequestDispatcher ds= request.getRequestDispatcher(nextPage);
		ds.forward(request, response);
		//doGet(request, response);
		
	}

}
*/