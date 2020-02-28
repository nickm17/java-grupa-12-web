<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer details</title>
</head>
<body>

<h1>Customer records</h1>
<table border="1" style="width:100%">
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Adress</th>
    </tr>

    <c:forEach var="customer" items="${customers}">
        <tr>
            <td align="justify"><c:out value="${customer.id}"></c:out></td>
            <td align="justify"><c:out value="${customer.name}"></c:out></td>
            <td align="justify"><c:out value="${customer.phone}"></c:out></td>
            <td align="justify"><c:out value="${customer.adress}"></c:out></td>
        </tr>
    </c:forEach>
</table>


<form action="customersWithJsp" method="post">
    <fieldset style="color:blue">
        <legend style="color:blue"><h2>Insert Customer</h2></legend>
        ID:<br>
        <input type="text" name="id"><br>
        <div style="color:red;">
            Name:<br>
            <input type="text" name="name"><br>
            Phone:<br>
            <input type="text" name="phone"><br>
        </div>
        Adress:<br>
        <input type="text" name="adress"><br><br>
        <input type="submit" value="Insert Customer" style="color:blue;">
    </fieldset>
</form>
</body>
</html>