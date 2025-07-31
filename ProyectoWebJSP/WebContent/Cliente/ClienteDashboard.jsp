<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%
  if (session.getAttribute("usuario") == null) {
    response.sendRedirect("Login.jsp");
    return;
  }
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard Cliente</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
</head>
<body>
	  <!-- Navbar con rol cliente -->
  	  <my:navbar userRole="cliente" activeTab="dashboard" />
  	  
</body>
</html>