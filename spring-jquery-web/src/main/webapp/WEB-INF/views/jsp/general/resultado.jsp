<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="page-title">
    <b>Proceso concluido</b>
    <div id="page-subtitle">Resultado del proceso:</div>
</div>

<div class="response-msg success ui-corner-all"> 
  <span>Resultado de la operaci&oacute;n</span> 
  <br>Los datos capturados han sido registrados correctamente.<br>
</div>
<br>
<div align="center">
  <table class = "grid">
      <thead>
        <tr><td>Nombre del atributo</td><td>Valor registrado</td></tr>
      </thead>
      <tbody>
        <c:forEach items="${keys}" varStatus="status">
          <tr><td>${keys[status.index]}</td><td>${values[status.index]}</td></tr>
        </c:forEach>
      </tbody>
  </table>
</div>
  <br><br>
<div align="center">
  <form method="get" action="<c:url value='/estudiante/captura'/>">
  <input type="submit" value="Regresar">
  </form>
</div>