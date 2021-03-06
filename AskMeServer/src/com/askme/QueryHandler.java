package com.askme;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class QueryHandler extends AbstractHandler{

	public void init() throws Exception {
		Server server = new Server(8081);
		server.setHandler(new QueryHandler());
				
		server.start();
		server.join();
		
		System.out.println("query server started");
	}
	
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);

		String out = "";

		if (baseRequest.getParameter("subject") != null)	{
			out += "subject 11 response";
		}

		if (baseRequest.getParameter("predicate") != null)	{
			out += "predicate response";
		}

		if (baseRequest.getParameter("object") != null)	{
			out += "object response";
		}

		if (baseRequest.getParameter("query") != null)	{
			out += "query response";
		}

		response.getWriter().println(out);
	}

}
