

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetriveController
 */
public class RetriveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetriveController() {
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
	StudentDAO dao=new StudentDAO();
	PrintWriter pw=response.getWriter();
	RequestDispatcher rd=request.getRequestDispatcher("StudentForm.html");
	rd.include(request, response);
	response.setContentType("text/html");
	try {
		List<Student> list=dao.getall();
		pw.println("<html><body><h1>Student Table</h1>");
		pw.println("\n<table border='1|0'><thead><tr><th>Name</th><th>Email</th><th>PassWord</th><th>Phone</th></thead>");
		for(Student s:list) {
			pw.println(
		"<tbody><tr><td>"+s.getName()+"</td><td>"+s.getEmail()+"</td><td>"+s.getPassword()+"</td><td>"+s.getPhno()+"</td></tbody>");
		}
		pw.print("</body></html>");
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

}
