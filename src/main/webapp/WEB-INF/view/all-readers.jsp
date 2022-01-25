<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    All Readers
    <br>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Number Phone</th>
            <th>Operations</th>
        </tr>
        <c:forEach var="rdr" items="${allReaders}">

            <c:url var="updateButton" value="/updateInfo">
                <c:param name="readerId" value="${rdr.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteReader">
                <c:param name="readerId" value="${rdr.id}"/>
            </c:url>

            <tr>
                <td>${rdr.name}</td>
                <td>${rdr.surname}</td>
                <td>${rdr.number_phone}</td>
                <td>
                    <input type="button" value="Update"
                           onClick = "window.location.href='${updateButton}'"/>
                </td>

                <td>
                    <input type="button" value="Delete"
                           onClick = "window.location.href='${deleteButton}'"/>
                </td>
            </tr>


        </c:forEach>

    </table>

    <br>
    <input type="button" value="Add"
           onclick="window.location.href='addNewReader'"/>
</h2>
</body>
</html>