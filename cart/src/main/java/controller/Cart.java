package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.ProductVO;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = request.getSession();
	ArrayList<ProductVO> cart = (ArrayList<ProductVO>) session.getAttribute("cart");

	if (cart == null) {
	    cart = new ArrayList<>();
	    session.setAttribute("cart", cart);
	}

	// 장바구니를 JSP로 전달합니다.
	request.setAttribute("cart", cart);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
	dispatcher.forward(request, response);
	}
    public Cart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 번호를 받아와서 해당 상품을 상품 목록에서 찾습니다.
		int pno = Integer.parseInt(request.getParameter("pno"));

		// 실제 데이터를 가져오는 코드를 추가하세요.
		ProductVO selectedProduct = new ProductVO();  // 여기에 실제 데이터를 가져오는 코드를 추가하세요.

		// 세션에서 장바구니를 가져옵니다.
		HttpSession session = request.getSession();
		ArrayList<ProductVO> cart = (ArrayList<ProductVO>) session.getAttribute("cart");

		if (cart == null) {
		    cart = new ArrayList<>();
		    session.setAttribute("cart", cart);
		}

		// 선택한 상품을 장바구니에 추가합니다.
		cart.add(selectedProduct);

		// 상품 목록 페이지로 리다이렉트합니다.
		response.sendRedirect("productList.jsp");
		doGet(request, response);
	}

}



