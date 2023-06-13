<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> Detail of Tivi: ${tivi.maTivi} </h1>
<form method="post">
    <p>
        Tivi name: <input name="name" value="${tivi.tenTivi}"/>
    </p>
    <p>
        Resolution: <input name="resolution" value="${tivi.doPhanGiai}"/>
    </p>
    <input type="submit" value="Update"/>
</form>