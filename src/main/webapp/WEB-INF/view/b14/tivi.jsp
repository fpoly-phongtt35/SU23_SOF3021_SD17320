<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post">
    Enter name: <input name="name"/>
    Enter resolution <input name="resolution" type="number"/>
    <input type="submit" value="Add"/>
</form>

<form method="get">
    Find by name: <input name="name" value="${name}"/>
    <input type="submit" value="Find"/>
</form>

<form method="get">
    Find by resolution: <input name="resolution" value="${resolution}"/>
    <input type="submit" value="Find"/>
</form>

<h1> List of Tivi </h1>
<table border="1">
    <tr>
        <th> Name </th>
        <th> Resolution </th>
        <th> Action </th>
    </tr>
    <c:forEach items="${tiviPage.getContent()}" var="tivi">
        <tr>
            <td> ${tivi.tenTivi} </td>
            <td> ${tivi.doPhanGiai} </td>
            <td>
                <a href="tivi/delete/${tivi.maTivi}">Delete</a>
                <a href="tivi/${tivi.maTivi}">Detail</a>
            </td>
        </tr>
    </c:forEach>
</table>

<div>
    <a href="?page=${tiviPage.getNumber() - 1}">Prev</a>
    <span>${tiviPage.getNumber()} / ${tiviPage.getTotalPages()}</span>
    <a href="?page=${tiviPage.getNumber() + 1}">Next</a>
</div>