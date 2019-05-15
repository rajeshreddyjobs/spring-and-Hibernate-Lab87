<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1 align="center">${MSG}</h1>
<spring:form action="addcontact.jlc" method="POST" commandName="contact">
<table align="center">

<tr>
<td align="center" colspan="2"><h1>ADD NEW CONTACT</h1></td>
</tr>

<tr>
<td>contact Name</td>
<td><spring:input path="contactName"/></td>
</tr>

<tr>
<td>contact Email</td>
<td><spring:input path="contactEmail"/> </td>
</tr>

<tr>
<td>contact phone</td>
<td><spring:input path="contactPhone"/></td>
</tr>

<tr>
<td align="center" colspan="2"><input type="submit" value="ADD CONTACT"></td>
</tr>

</table>
</spring:form>


<c:if test="${CLIST ne null}">
<hr/>
<table align="center" width="40%">
<tr>
<td>Contact Id</td>
<td>Contact Name</td>
<td>Contact Email</td>
<td>Contact Phone</td>
</tr>

<c:forEach items="${CLIST}" var="cto">
<tr>

<td>${cto.contactid}</td>
<td>${cto.contactName}</td>
<td>${cto.contactEmail}</td>
<td>${cto.contactPhone}</td>
</tr>

</c:forEach>
</table>
</c:if>
</body>
</html>