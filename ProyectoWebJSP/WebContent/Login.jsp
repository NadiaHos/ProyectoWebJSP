<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inicio</title>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
 	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
</head>
<body>

  <my:navbar activeTab="login" userRole="" />

  <main class="container p-4 rounded-3 bg-card" style="max-width: 400px; width: 100%;">
    <my:loginForm />
	
    <c:if test="${not empty error}">
      <div class="d-flex justify-content-center mt-3">
        <div class="alert alert-danger text-center w-100">
          <c:out value="${error}" />
        </div>
      </div>
    </c:if>
  </main>




  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>