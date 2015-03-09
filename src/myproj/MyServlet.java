package myproj;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	private Thing thing = new Thing();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int counter = thing.doStuff();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>Hello, world ("+counter+")</body></html>");
	}

}