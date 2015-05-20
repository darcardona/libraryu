<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<body>

	<div class="well sidebar-nav">
		<ul class="nav nav-list">
			<li class="nav-header"><spring:message code="layout.menu" /></li>
			<li><a href="<c:url value="/books"/>"><spring:message
						code="layout.menu.books" /></a></li>
			<li><a href="<c:url value="/categories"/>"><spring:message
						code="layout.menu.categories" /></a></li>
		</ul>
	</div>

</body>
</html>