<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    All Books
    <br>
    <table>
        <tr>
            <th>Name</th>
            <th>Author</th>
            <th>Book code</th>
        </tr>
        <c:forEach var="bk" items="${allBooks}">

            <c:url var="updateButton" value="/updateInfoBook">
                <c:param name="bookId" value="${bk.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteBook">
                <c:param name="bookId" value="${bk.id}"/>
            </c:url>

            <tr>
                <td>${bk.name}</td>
                <td>${bk.author}</td>
                <td>${bk.shifr}</td>
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
           onclick="window.location.href='addNewBook'"/>
</h2>
</body>
</html>