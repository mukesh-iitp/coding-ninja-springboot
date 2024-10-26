<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<h1>This is the signup page</h1>
<form:form action="done" modelAttribute="car">
Car Number:
<form:input path="RegisterationNumber"/>
<br>
<br>
Car Name:
<form:input path="CarName"/>
<br>
<br>
Covered In Warranty:
<form:select path="CarDetails">
<form:option value="Yes"></form:option>
<form:option value="No"></form:option>
</form:select>
<br>
<br>
Any Remarks:
<form:input path="CarWork"/>
<br>
<br>
<input type="submit">
</form:form>
</html>

