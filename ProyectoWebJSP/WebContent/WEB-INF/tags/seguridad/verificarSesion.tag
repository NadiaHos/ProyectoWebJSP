<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="tipo" required="true" %>
<%@ page import="entidades.Usuario" %>

<%
  Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

  boolean autorizado = false;

  if (usuario != null) {
    if ("admin".equals(tipo) && usuario.esAdmin()) {
      autorizado = true;
    } else if ("cliente".equals(tipo) && usuario.esCliente()) {
      autorizado = true;
    }
  }

  if (!autorizado) {
    response.sendRedirect(request.getContextPath() + "/Login.jsp");
    return;
  }
%>
