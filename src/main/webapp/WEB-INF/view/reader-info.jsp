<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Reader Info</h2>
<br>

<form:form action="saveReader" modelAttribute="reader">

    <form:hidden path="id"/>


    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Number Phone <form:input path="number_phone"/>
    <br><br>
    <input type="submit" value ="OK">
</form:form>

</body>
</html>