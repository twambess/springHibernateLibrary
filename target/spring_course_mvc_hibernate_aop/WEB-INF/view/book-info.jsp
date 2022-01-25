<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Book Info</h2>
<br>

<form:form action="saveBook" modelAttribute="book">

    <form:hidden path="id"/>


    Name <form:input path="name"/>
    <br><br>
    Author <form:input path="author"/>
    <br><br>
    Book code <form:input path="shifr"/>
    <br><br>
    <input type="submit" value ="OK">
</form:form>

</body>
</html>