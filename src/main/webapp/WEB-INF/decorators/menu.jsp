<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>

  <div class="sidebar sidebar-inset">
    <h4>
      <spring:message code="layout.menu" />
    </h4>
    <ul>
      <li><a href="<c:url value="/books"/>"><spring:message
            code="layout.menu.books" /></a></li>
      <li><a href="<c:url value="/categories"/>"><spring:message
            code="layout.menu.categories" /></a></li>
    </ul>
  </div>

</body>
</html>