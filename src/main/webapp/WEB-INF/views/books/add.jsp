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

  <div class="row-fluid">
    <div class="span8">

      <c:set var="action" value="Create" />
      <form:form id="bookForm" method="post" modelAttribute="book"
        acceptCharset="UTF-8" action="/books/add">

        <!-- ID -->
        <c:if test="${book.id != null}" var="isEditing" scope="request">
          <c:set var="action" value="Update" />
          <form:label path="id" cssClass="string required control-label">ID</form:label>
          <form:input cssClass="input-block-level" path="id"
            readonly="true" />
        </c:if>

        <!-- isbn -->
        <form:label path="isbn" cssClass="string required control-label">
          <abbr title="required">*</abbr> ISBN</form:label>
        <form:input cssClass="input-block-level" path="isbn" />
        <form:errors path="isbn" cssClass="alert alert-error"
          element="div" />

        <!-- title -->
        <form:label path="title"
          cssClass="string required control-label">
          <abbr title="required">*</abbr> Title</form:label>
        <form:input cssClass="input-block-level" path="title" />
        <form:errors path="title" cssClass="alert alert-error"
          element="div" />

        <!-- autor -->
        <form:label path="autor"
          cssClass="string required control-label">
          <abbr title="required">*</abbr> Autor</form:label>
        <form:input cssClass="input-block-level" path="autor" />
        <form:errors path="autor" cssClass="alert alert-error"
          element="div" />

        <!-- edition -->
        <form:label path="edition"
          cssClass="string required control-label">
          <abbr title="required">*</abbr> Edition</form:label>
        <form:input cssClass="input-block-level" path="edition" />
        <form:errors path="edition" cssClass="alert alert-error"
          element="div" />

        <!-- review -->
        <form:label path="review"
          cssClass="string required control-label">
          <abbr title="required">*</abbr> Review</form:label>
        <form:textarea path="review" cssClass="input-block-level" />
        <form:errors path="review" cssClass="alert alert-error"
          element="div" />

        <!-- category -->
        <form:label path="category" cssClass="string control-label">
					Category</form:label>
        <form:select path="category.id" cssClass="input-block-level">
          <form:options items="${categories}" itemLabel="name"
            itemValue="id" />
        </form:select>
        <form:errors path="category" cssClass="alert alert-error"
          element="div" />

        <!-- actions -->
        <input class="btn btn-primary" name="commit" type="submit"
          value="${action} Book">
        <a class="btn btn-danger" href="<c:url value="/books"/>">Cancel</a>

      </form:form>
    </div>
  </div>
</body>
</html>