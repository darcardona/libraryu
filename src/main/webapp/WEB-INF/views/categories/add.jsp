<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>category</title>
</head>
<body>
  <div>
    <h1>Category</h1>
    <p class="lead">Use this form to add new categories.</p>
  </div>

  <div class="row col-xs-12">
    <c:set var="action" value="Create" />
    <form:form id="categoryForm" method="post" modelAttribute="category"
      acceptCharset="UTF-8" action="/categories/add"
      cssClass="form-horizontal">

      <!-- ID -->
      <c:if test="${category.id != null}" var="isEditing"
        scope="request">
        <div class="form-group">
          <c:set var="action" value="Update" />
          <form:label path="id" cssClass="col-sm-2 control-label">ID</form:label>
          <div class="col-sm-10">
            <form:input path="id" cssClass="form-control"
              readonly="true" />
          </div>
        </div>
      </c:if>

      <!-- name -->
      <div class="form-group">
        <form:label path="name" cssClass="col-sm-2 control-label">
          <abbr title="required">*</abbr> Name</form:label>
        <div class="col-sm-10">
          <form:input path="name" cssClass="form-control" />
          <form:errors path="name" cssClass="bg-danger" element="div" />
        </div>
      </div>

      <!-- location -->
      <div class="form-group">
        <form:label path="location" cssClass="col-sm-2 control-label">
          <abbr title="required">*</abbr> Location</form:label>
        <div class="col-sm-10">
          <form:input path="location" cssClass="form-control" />
          <form:errors path="location" cssClass="bg-danger"
            element="div" />
        </div>
      </div>

      <!-- actions -->
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <input class="btn btn-primary" name="commit" type="submit"
            value="${action} Category"> <a
            class="btn btn-default" href="<c:url value="/categories"/>">Cancel</a>
        </div>
      </div>

    </form:form>
  </div>
</body>
</html>