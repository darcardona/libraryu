<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

  <!-- specific to general variables-->
  <c:if test="${not empty successMessage}">
    <c:set var="contextualClass" value="success" />
    <c:set var="message" value="${successMessage}" />
  </c:if>
  <c:if test="${not empty errorMessage}">
    <c:set var="contextualClass" value="danger" />
    <c:set var="message" value="${errorMessage}" />
  </c:if>

  <c:set var="contextualClass" value="danger" />
  <c:set var="message" value="Success: Book Saved" />

  <!-- general content -->
  <c:if test="${not empty message}">
    <div class="alert alert-${contextualClass}" role="alert">
      <button type="button" class="close" data-dismiss="alert"
        aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
      <spring:message code="message.${contextualClass}"
        arguments="${message}" htmlEscape="true" />
    </div>
    <script>
					$(document).ready(function() {
						setTimeout(function() {
							$(".alert").fadeOut(1500);
						}, 3000);
					});
				</script>
  </c:if>
</body>
</html>