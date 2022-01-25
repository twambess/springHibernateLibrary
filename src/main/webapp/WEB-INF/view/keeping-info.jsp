<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>

<div style="text-align: center;">

    <h2>Keeping Info</h2>

    <br>

    <table>
        <tr>
            <td>
                <form:form action="saveKeeping" modelAttribute="keeping">

                    <form:hidden path="id"/>

                    Book <form:select path="bookId">
                    <c:forEach var="bk" items="${allBooks}">
                        <form:option value="${bk.id}" label="${bk.name}"/>
                    </c:forEach>
                </form:select>
                    <br><br>

                    Reader <form:select path="readerId">
                    <c:forEach var="rdr" items="${allReaders}">
                        <form:option value="${rdr.id}" label="${rdr.name}"/>
                    </c:forEach>
                </form:select>
                    <br><br>

                    Date <form:input path="date"/>
                    <br><form:errors path="date"/><br>
                    <input type="submit" value="OK">
                </form:form>
            </td>
        </tr>
    </table>

</div>

</body>

</html>