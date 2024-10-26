<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<html>
<h1>Here are your instructors</h1>
<% 
	ArrayList<HashMap<String, Object>> listOfInstructors = 
		(ArrayList<HashMap<String, Object>>)request.getAttribute("instructor");
	for(HashMap<String, Object> instructor: listOfInstructors )
	{
%>
		Name: <%=instructor.get("name")%>
		<a href="profile/<%=instructor.get("id")%>"> profile</a><br>
<%
	}
%>
</html>