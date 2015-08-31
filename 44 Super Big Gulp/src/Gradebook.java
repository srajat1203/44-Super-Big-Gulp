import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grade;
import customTools.DBUtil;

import java.util.ArrayList;

/**
 * Servlet implementation class helloworld
 */

@WebServlet("/Gradebook")
public class Gradebook extends HttpServlet {
	private String message;

	String name = "";
	String n = "";
	String first = "";
	String last = "";
	String fname = "";
	String lname = "";
	int sum = 0;
	int count = 0;
	int avg = 0;
	ArrayList<Integer> grades;
	ArrayList<String> as;
	String gr = "";

	public void init() throws ServletException {
		// Do required initialization

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		grades = new ArrayList<Integer>();
		as = new ArrayList<String>();

		String a = request.getParameter("a1");
		String tmp = request.getParameter("g1");
		int g = Integer.parseInt(tmp);
		int gid = 3;
		// System.out.println(a);

		//Writing to DB
		
		Grade cgrade = new Grade();
		cgrade.setAssignment(a);
		cgrade.setGrade(g);

		//cgrade.setGid(gid);
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(cgrade);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		//em.close();
		}
		
		
		//Reading from DB
		
		String qString = "SELECT g FROM Grade g";
		
		TypedQuery<Grade> q =  em.createQuery(qString, Grade.class);
		
		List<Grade> grades = q.getResultList();
		
		
		try {
			gr = "";
			sum = 0;
			avg = 0;
			count = 0;
			for (Grade cur : grades) {
				
				gr = gr + cur.getGrade() + " " + cur.getAssignment() + "<br>";
				
				sum = sum + cur.getGrade();
				count++;
			}	
			}catch (Exception e){
				e.printStackTrace();
			} finally {
				em.close();
			}

			if(count != 0)
			{
				avg = sum/count;
			}
		
		
		
		//Priting to jsp
		
		response.setContentType("text/html");

		
		request.setAttribute("avg", avg);
		request.setAttribute("grades", gr);

		getServletContext().getRequestDispatcher("/output.jsp")
		.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
		// do nothing.
	}

}