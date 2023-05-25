<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>List of Products</h1>
<form>
    Enter something: <input name="tenSanPham" value="${param.tenSanPham}"/>
    <input type="submit" value="Search"/>
</form>
<table border="1">
    <tr>
        <th>Product Id</th>
        <th>Product Name</th>
    </tr>
    <c:forEach items="${danhSachSanPham}" var="sanPham">
        <tr>
            <td> ${sanPham.tenSanPham} </td>
            <td> ${sanPham.maSanPham} </td>
        </tr>
    </c:forEach>
</table>