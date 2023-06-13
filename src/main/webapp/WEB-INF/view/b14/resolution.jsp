<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> List of Tivi Resolution </h1>
<table border="1">
    <tr>
        <th> Resolution </th>
        <th> Count </th>
        <th> Action </th>
    </tr>
    <c:forEach items="${tiviResolutions}" var="tiviReso">
        <tr>
            <td> ${tiviReso.doPhanGiai} </td>
            <td> ${tiviReso.soLuong} </td>
            <td>
                <a href="/b14/tivi?resolution=${tiviReso.doPhanGiai}">Detail</a>
            </td>
        </tr>
    </c:forEach>
</table>