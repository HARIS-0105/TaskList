<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import ="java.io.*" %>
<%@ page import ="java.util.*" %>
<%@page import="com.task.Class.FileInterface" %>
<%@page import="com.task.Class.Time" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Option 1: Include in HTML -->
<!-- Option 1: Include in HTML -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="view.css">
 <script src="view.js"></script>
<title>Your tasks</title>
</head>
<body>
<%TreeMap<String,Set<String>> hash=FileInterface.getTreeFromDetails();%>
<div class="row use scrollbar">
<%
if(!hash.isEmpty()|| hash!=null)
{%>
	<h2>Your Task <a href="ToDo.html" type="button" class="btn btn-secondary btn"><i class="bi bi-arrow-return-left"></i></a></h2>
	<% for(String dueDate:hash.keySet())
	{
		    String taskDate=Time.convertDate(dueDate);
			Set<String> set=new HashSet<>();
			String todayDate=Time.getDateDash();
			set=hash.get(dueDate);%>
			<% if(!set.isEmpty())
		    {%>
			     <%int daysDifference=Time.getDaysDifference(taskDate,todayDate);
			    // out.print(String.valueOf(daysDifference+" "+todayDate+" "+dueDate));
			     if(daysDifference<0){%>
					 <div class="col-3 use1 force-overflow ">
					 <h3 class="ended"><%=taskDate+" (Missed)"%></h3>
					 <h4 class="ended"><%=Math.abs(daysDifference)+" days Passed"%></h4>
				 <%}
				 else if(daysDifference<5){%>
					 <div class="col-3 use1 force-overflow ">
					 <h3 class="urgent"><%=taskDate+" (Upcoming)"%></h3>
					 <%if(daysDifference==1 ){%>       
					 	<h4 class="urgent">1 day left</h4>
					 <%}
					 else 
					 {%>
					 	<h4 class="urgent"><%=Math.abs(daysDifference)+" days left"%></h4>
				     <%}   
			     }
				 else{%>
					 <div class="col-3 use1 force-overflow ">
					 <h3 class="cool"><%=taskDate+" (Have Time)"%></h3>
					 <h4 class="cool"><%=Math.abs(daysDifference)+" days more"%></h4>
				 <%}%>
					 <ol>
						 <% 
						 int count=1;
						 for(String s1:set)
						 { %>
						 	 <h6 id="<%=s1+dueDate%>"> <%=(count+". "+s1)%><a type="button"  onclick="del('<%=s1 %>','<%=dueDate %>')" class="btn btn-secondary btn"><i class="bi bi-check-circle"></i></a></h6>
							 <%out.println(); %>
							 <% count++;
					     } %>
					 </ol>
				 </div>
			<%}
		}
}%>
<% if(hash.isEmpty() || hash==null){ %>
<div>
<h2> No Task</h2>
</div>
<%} %>
</div>
</body>
</html>