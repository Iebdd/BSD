package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.PremiumUser;
import Utils.HibernateSupport;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").include(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		if(username == null || username.trim().isEmpty() || pw1 == null || pw1.trim().isEmpty() || pw2 == null || pw2.trim().isEmpty()) {
			request.setAttribute("error", "Please fill all fields marked with a *");
			request.getRequestDispatcher("register.jsp").include(request, response);
			return;
		}
		
		if(!pw1.equals(pw2)) {
			request.setAttribute("error", "Password do not match !");
			request.getRequestDispatcher("register.jsp").include(request, response);
			return;
		}
		
		PremiumUser user = new PremiumUser(username, pw2, phone!=null?phone:"not given", email!=null?email:"no MAIL");
		boolean userCreation = false;
		
		HibernateSupport.beginTransaction();
		userCreation = user.save();
		HibernateSupport.commitTransaction();
		
		if(!userCreation) {
			request.setAttribute("error", "Error during registration - please try again later! ");
			request.getRequestDispatcher("register.jsp").include(request, response);
			return;
		}
		
		response.sendRedirect("Home?id="+user.getId());
		return;
	}

}
