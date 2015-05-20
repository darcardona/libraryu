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
		<h1>Category</h1>
		<p class="lead">Use this form to add new categories.</p>
	</div>

	<div class="row-fluid">
		<div class="span8">

			<c:set var="action" value="Create" />
			<form:form id="categoryForm" method="post" modelAttribute="category"
				acceptCharset="UTF-8" action="/categories/add">

				<fieldset>

					<!-- ID -->
					<c:if test="${category.id != null}" var="isEditing" scope="request">
						<c:set var="action" value="Update" />
						<form:label path="id" cssClass="string required control-label">ID</form:label>
						<form:input cssClass="input-block-level" path="id" readonly="true" />
					</c:if>

					<!-- name -->
					<form:label path="name" cssClass="string required control-label">
						<abbr title="required">*</abbr> Name</form:label>
					<form:input cssClass="input-block-level" path="name" />
					<form:errors path="name" cssClass="alert alert-error" element="div" />

					<!-- location -->
					<form:label path="location"
						cssClass="string required control-label">
						<abbr title="required">*</abbr> Location</form:label>
					<form:input cssClass="input-block-level" path="location" />
					<form:errors path="location" cssClass="alert alert-error"
						element="div" />

					<!-- actions -->
					<input class="btn btn-primary" name="commit" type="submit"
						value="${action} Category"> <a class="btn btn-danger"
						href="<c:url value="/categories"/>">Cancel</a>
				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>