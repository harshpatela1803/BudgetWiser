package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Client;
import com.model.ClientModel;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("submit").equalsIgnoreCase("submit")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Client client = new Client();
			client.setUsername(username);
			client.setPassword(password);
			client = ClientModel.checkLogin(client);
			if(client!=null){
//				System.out.println("In if loop");
				response.sendRedirect("BudgetWiser_1.1/exp.html");
			}
			else{
				response.sendRedirect("loginForm.jsp");
			}
			
		}
		
		if(request.getParameter("submit").equalsIgnoreCase("GetStarted")){
			System.out.println("In if loop::::::");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Client client = new Client();
			client.setFirstname(firstname);
			client.setLastname(lastname);
			client.setUsername(email);
			client.setPassword(password);
			ClientModel.addUser(client);
			response.sendRedirect("loginForm.jsp");
			
		}
		
	}

	

}