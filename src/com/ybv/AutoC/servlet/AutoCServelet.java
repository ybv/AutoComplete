package com.ybv.AutoC.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoCServelet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IncNGTrie in;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("user");
		System.out.println("name is "+ name);
		if (name.isEmpty()) { 
			in = new IncNGTrie();
			HashSet<String> ret=in.sreenivas("");
			resp.setContentType("text/plain");  
			resp.setCharacterEncoding("UTF-8"); 
			resp.getWriter().write("Suggestions are: " + ret.toString()+"!");
			
		}
		else{
		name= name.trim();
		HashSet<String> ret = in.sreenivas(name);
		//System.out.println(ret.toString());
		resp.setContentType("text/plain");  
		resp.setCharacterEncoding("UTF-8"); 
		resp.getWriter().write("Suggestions are:\n");
		for(String s:ret){
			resp.getWriter().write(s.toString()+"\n");
		}
		
		}
		//super.doGet(req, resp);
	}

}
