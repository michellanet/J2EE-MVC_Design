package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.Query;
import model.M_56_Friend;

/**
 * Servlet implementation class read
 */
@WebServlet("/C_56_Update")
public class C_56_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_56_Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = null;
		M_56_Friend friend;
		String url = null;
		try {
			Query q = new Query();
			if(request.getParameter("add") == null) {
				int id = Integer.parseInt(request.getParameter("id").toString());
				q.doRead(id);
				ArrayList<M_56_Friend> friends = q.getHTMLTable();
				request.setAttribute("friends", friends);
				url = "/V_56_Update.jsp";
			}
			else {
				if(request.getParameter("name")==null && request.getParameter("email")==null 
						&& request.getParameter("age")==null && request.getParameter("color")==null) {

					url = "error.jsp";
					rd = request.getRequestDispatcher(url);
					rd.forward(request, response);
				}
				else {
					if(request.getParameter("age").matches("[0-9]+")) {	
			int id = Integer.parseInt(request.getParameter("id").toString());
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			int age = Integer.parseInt(request.getParameter("age").toString());
			String color = request.getParameter("color");
			friend = new M_56_Friend(name,email,age,color);
			friend.setId(id);
			q.doUpdate(friend);
			q.doRead();
			ArrayList<M_56_Friend> friends = q.getHTMLTable();
			request.setAttribute("friends", friends);
			url = "/V_56_Read.jsp";
					}
					else {

						url = "error.jsp";
						rd = request.getRequestDispatcher(url);
						rd.forward(request, response);				
					}
			}
		}
			
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
