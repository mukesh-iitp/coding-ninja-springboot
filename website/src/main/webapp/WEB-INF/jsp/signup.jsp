<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<h1>Sign Up Page</h1>
<form:form action="registerUser" modelAttribute="user">
Name:
<form:input path="name"/>
<br>
<br>
Gender:
Male<form:radiobutton path="gender" value="male"/>
Female<form:radiobutton path="gender" value="female"/>
<br>
<br>
Location:
<form:select path="location">
<form:option value="India"></form:option>
<form:option value="NRI"></form:option>
</form:select>
<br>
<br>
College:
<form:select path="college">
<form:option value="IIT Patna"></form:option>
<form:option value="NIT Patna"></form:option>
</form:select>
<br>
<br>
<input type="submit">
</form:form>
</html>