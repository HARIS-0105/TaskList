package com.task.Servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import com.task.Class.FileInterface;
import com.task.Class.Time;
/**
 * Servlet implementation class AddTask
 */
@WebServlet("/AddtheTask")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String category=request.getParameter("Category"); 
		String task=request.getParameter("task");
		task=task.substring(0,1).toUpperCase()+task.substring(1);
		TreeMap<String,Set<String>>taskMap=FileInterface.getTreeFromDetails();
		if(taskMap.containsKey(category)) 
		{
			Set<String> tasks=taskMap.get(category);
			tasks.add(task);
			taskMap.put(category,tasks);
		}
		else 
		{
			Set<String> tasks=new HashSet<>();
			tasks.add(task);
			taskMap.put(category,tasks);
		}
		FileInterface.WriteTreeIntoDetails(taskMap);
		response.sendRedirect("addTask.html");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
