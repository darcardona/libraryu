<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>books</title>
</head>
<body>
	<div class="page-header">
		<h1>Books</h1>
		<p class="lead">Registered books.</p>
	</div>

	<div class="row-fluid">
		<div class="span8">

			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert">&times;</a>
					<spring:message code="message.success" arguments="${message}"
						htmlEscape="true" />
				</div>
			</c:if>

			<div class="table-responsive">
				<table class="table table-hover">

					<thead>
						<th>ISBN</th>
						<th>Title</th>
						<th>Autor</th>
						<th>Edition</th>
					</thead>

					<c:forEach items="${books}" var="book">
						<tr>
							<td><a href="<c:url value="/books/edit/${book.isbn}"/>">${book.isbn}</a></td>
							<td>${book.title}</td>
							<td>${book.autor}</td>
							<td>${book.edition}</td>
							<td><a class="icon-remove"
								href="<c:url value="/books/delete/${book.isbn}"/>"></a>&nbsp;</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="spacer">&nbsp;</div>

			<div class="control-group">
				<div class="btn btn-default">
					<a href="<c:url value="/books/add"/>">Create Book</a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>