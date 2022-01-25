<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    All Book-keeping
    <br>
    <table>
        <tr>
            <th>Book_Name</th>
            <th>Reader</th>
            <th>Date</th>
            <th>Operations</th>
        </tr>
        <c:forEach var="keeping" items="${allKeepings}">

            <c:url var="updateButton" value="/updateKeeping">
                <c:param name="keepingId" value="${keeping.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteKeeping">
                <c:param name="keepingId" value="${keeping.id}"/>
            </c:url>

            <tr>
                <td>${keeping.book.name}</td>
                <td>${keeping.reader.name}</td>
                <td>
                    <fmt:formatDate value="${keeping.date}" pattern="yyyy-MM-dd HH:mm" />
                        ${keeping.date}
                </td>


                <td>
                    <input type="button" value="Update"
                           onclick="window.location.href = '${updateButton}'"/>
                    <input type="button" value="Delete"
                           onclick="if (confirm('Are you sure?')) window.location.href = '${deleteButton}'"/>
                </td>






        </c:forEach>

    </table>

    <br>
    <input type="button" value="Add"
           onclick="window.location.href='addNewKeeping'"/>
</h2>
</body>
</html>