<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="seg" tagdir="/WEB-INF/tags/seguridad" %>

<seg:verificarSesion tipo="cliente" />

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
	
	<div class="container mt-5">
    <div class="row mb-4">
      <div class="col-12 text-center">
        <h2 class="fw-bold"><i class="bi bi-person-circle me-2"></i>Panel del Cliente</h2>
        <p class="lead text-muted">Gestión de sus productos bancarios</p>
      </div>
    </div>

    <div class="row g-4 justify-content-center">
      <!-- Tarjeta Cuentas -->
      <div class="col-md-3 col-sm-6">
        <div class="card h-100 border-primary shadow-sm text-center">
          <div class="card-body">
            <i class="bi bi-bank text-primary fs-1 mb-3"></i>
            <h5 class="card-title">Mis Cuentas</h5>
            <p class="card-text text-muted">Consulta y gestión de cuentas</p>
            <a href="${pageContext.request.contextPath}/ServletMisCuentas" class="btn btn-outline-primary stretched-link">
              <i class="bi bi-box-arrow-in-right me-1"></i> Acceder
            </a>
          </div>
        </div>
      </div>

      <!-- Tarjeta Transferencias -->
      <div class="col-md-3 col-sm-6">
        <div class="card h-100 border-info shadow-sm text-center">
          <div class="card-body">
            <i class="bi bi-send text-info fs-1 mb-3"></i>
            <h5 class="card-title">Transferencias</h5>
            <p class="card-text text-muted">Realizar transferencias</p>
            <a href="${pageContext.request.contextPath}/ClienteTransferir.jsp" class="btn btn-outline-info stretched-link">
              <i class="bi bi-box-arrow-in-right me-1"></i> Acceder
            </a>
          </div>
        </div>
      </div>
      
    </div>
  </div>  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
