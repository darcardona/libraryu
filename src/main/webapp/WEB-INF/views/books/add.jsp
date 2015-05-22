<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>book</title>
</head>
<body>
  <div>
    <h1>Book</h1>
    <p class="lead">Use this form to add new books.</p>
  </div>

  <div class="row col-xs-12">
    <c:set var="action" value="Create" />
    <form:form id="bookForm" method="post" modelAttribute="book"
      acceptCharset="UTF-8" action="/books/add"
      cssClass="form-horizontal">

      <!-- ID -->
      <c:if test="${book.id != null}" var="isEditing" scope="request">
        <div class="form-group">
          <c:set var="action" value="Update" />
          <form:label path="id" cssClass="col-sm-2 control-label">ID</form:label>
          <div class="col-sm-10">
            <form:input path="id" cssClass="form-control"
              readonly="true" />
          </div>
        </div>
      </c:if>

      <!-- isbn -->
      <div class="form-group">
        <form:label path="isbn" cssClass="col-sm-2 control-label">
          <abbr title="required">*</abbr> ISBN</form:label>
        <div class="col-sm-10">
          <form:input path="isbn" cssClass="form-control" />
          <form:errors path="isbn" cssClass="bg-danger" element="div" />
        </div>
      </div>

      <!-- title -->
      <div class="form-group">
        <form:label path="title" cssClass="col-sm-2 control-label">
          <abbr title="required">*</abbr> Title</form:label>
        <div class="col-sm-10">
          <form:input path="title" cssClass="form-control" />
          <form:errors path="title" cssClass="bg-danger" element="div" />
        </div>
      </div>

      <!-- author -->
      <div class="form-group">
        <form:label path="author" cssClass="col-sm-2 control-label">
          <abbr title="required">*</abbr> Author</form:label>
        <div class="col-sm-10">
          <form:input path="author" cssClass="form-control" />
          <form:errors path="author" cssClass="bg-danger" element="div" />
        </div>
      </div>

      <!-- edition -->
      <div class="form-group">
        <form:label path="edition" cssClass="col-sm-2 control-label">
          <abbr title="required">*</abbr> Edition</form:label>
        <div class="col-sm-10">
          <form:input path="edition" cssClass="form-control" />
          <form:errors path="edition" cssClass="alert bg-danger"
            element="div" />
        </div>
      </div>

      <!-- review -->
      <div class="form-group">
        <form:label path="review" cssClass="col-sm-2 control-label">
          <abbr title="required">*</abbr> Review</form:label>
        <div class="col-sm-10">
          <form:textarea path="review" cssClass="form-control" />
          <form:errors path="review" cssClass="bg-danger" element="div" />
        </div>
      </div>

      <!-- category -->
      <div class="form-group">
        <form:label path="category" cssClass="col-sm-2 control-label">
					Category</form:label>
        <div class="col-sm-10">
          <form:select path="category.id" cssClass="form-control">
            <form:option value="" label="-- select --" />
            <form:options items="${categories}" itemLabel="name"
              itemValue="id" />
          </form:select>
          <form:errors path="category.id" cssClass="bg-danger"
            element="div" />
        </div>
      </div>

      <!-- actions -->
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <input class="btn btn-primary" name="commit" type="submit"
            value="${action} Book"> <a class="btn btn-default"
            href="<c:url value="/books"/>">Cancel</a>
        </div>
      </div>
    </form:form>
  </div>
</body>
</html>