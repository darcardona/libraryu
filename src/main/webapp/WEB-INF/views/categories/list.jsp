<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>category</title>
</head>
<body>
	<div class="page-header">
		<h1>Categories</h1>
		<p class="lead">Registered categories.</p>
	</div>

	<div class="row-fluid">
		<div class="span8">

			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert">&times;</a>
					<spring:message code="message.youWrote" arguments="${message}"
						htmlEscape="true" />
				</div>
			</c:if>

			<div class="table-responsive">
				<table class="table table-hover">

					<thead>
						<th>Name</th>
						<th>Location</th>
					</thead>

					<c:forEach items="${categories}" var="category">
						<tr>
							<td><a
								href="<c:url value="/categories/edit/${category.id}"/>">${category.name}</a></td>
							<td>${category.location}</td>
							<td><a class="icon-remove"
								href="<c:url value="/categories/delete/${category.id}"/>"></a>&nbsp;</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="spacer">&nbsp;</div>

			<div class="control-group">
				<div class="btn btn-default">
					<a href="<c:url value="/categories/add"/>">Create Category</a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>