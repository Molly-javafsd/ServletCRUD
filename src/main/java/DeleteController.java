

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteController
 */
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s=new Student();
		s.setName(request.getParameter("name"));
		
		PrintWriter pw=response.getWriter();
		StudentDAO dao=new StudentDAO();
		try {
			int row=dao.delete(s);
			if(row>0) {
				RequestDispatcher rd=request.getRequestDispatcher("StudentForm.html");
				rd.include(request, response);
				pw.print("Deleted");
				//response.sendRedirect("Success.html");
			}
			else {
				//response.sendRedirect("Fail.html");
				pw.print("Failed to delete");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
