package com.task.Servlets;

import java.text.SimpleDateFormat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import com.task.Class.FileInterface;
import com.task.Class.Time;
@WebServlet("/AddHistory")
/**
 * Servlet implementation class History
 */
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task=request.getParameter("task");
		String category=request.getParameter("category");
		TreeMap<String,Set<String>> taskMap=FileInterface.getTreeFromDetails();
		Set<String> taskSet=new HashSet<>();
		taskSet=taskMap.get(category);
		taskSet.remove(task);
		taskMap.put(category, taskSet);
		if(taskSet.isEmpty()){
			taskMap.remove(category);
		}
		FileInterface.WriteTreeIntoDetails(taskMap);
		HashSet<String> historySet= FileInterface.getSetFromHistory();
		String strDate=Time.getDateWithTime();
	    String history=task+" Completed On :"+strDate;
	    historySet.add(history);
		FileInterface.WriteSetIntoHistory(historySet);
		response.sendRedirect("historypg.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
