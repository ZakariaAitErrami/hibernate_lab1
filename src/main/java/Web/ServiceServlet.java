package Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.Message;
import Metier.ServiceMetier;
import Metier.User;

/**
 * Servlet implementation class ServiceServlet
 */
@WebServlet("/ServiceServlet")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ServiceServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("user", null);
		getServletContext().getRequestDispatcher("/login.jsp").forward(request,  response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String page = (String) session.getAttribute("page");
		
		User user ;
		if(page.equals("inscription")) {
			
			String nomPr = request.getParameter("nomPr");
			String email = request.getParameter("email");
			String password = request.getParameter("passWord");
			String statut = request.getParameter("statut");
			
			
			if(ServiceMetier.getUserByEmail(email)==null) {
				user= new User();
				user.setNomPr(nomPr);
				user.setEmail(email);
				user.setPassword(password);
				user.setStatut(statut);
				
				try {
					ServiceMetier.addUser(user);
					doGet(request, response);
				}catch (Exception e) {
					request.setAttribute("error", "Error sign up "+e);
					getServletContext().getRequestDispatcher("/inscription.jsp").forward(request,  response);
				}
				
		   }
			else {
				request.setAttribute("error", "An account is already exists with this email");
				getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
			}
			
			
			
		}
		
		else if(page.equals("login")) {
			String email = request.getParameter("email");
			String pass = request.getParameter("passWord");
			user = ServiceMetier.getUser(email, pass);
			if(user == null) {
				request.setAttribute("error", "Email or password is incorrect");
				doGet(request, response);
			}
			else {
				session.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/AjoutMessage.jsp").forward(request, response);
			}
		}
		
		else if(page.equals("AjoutMessage")) {
			String action = request.getParameter("action");
			if(action.equals("Send")) {
				String msgtxt = request.getParameter("message");
				user = (User) session.getAttribute("user");
				Message msg = new Message();
				msg.setUser(user);
				msg.setMessage(msgtxt);
				
				try {
					ServiceMetier.addMessage(msg);
					getServletContext().getRequestDispatcher("/AjoutMessage.jsp").forward(request, response);
				} catch (Exception e) {
					
				}
			} else if (action.equals("See messages")) {
				getServletContext().getRequestDispatcher("/Visualiser.jsp").forward(request, response);
			}
		}
	}

}
