<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <script type="text/javascript">
    
    //Codigo empleado para llenar los objetos tipo selectMenu de division, depto y carrera 
    //empleando ajax y el web service REST implementado por CatalogoRestController
    
    $(document).ready(function(){
    	
    	//inicializa el selectMenu de divisiones
		$("#division\\.id").loadSelectMenu("<c:url value='/restService/divisiones'/>",null,'id','clave');
		
    	//departamentos
    	 $("#division\\.id").on('selectmenuchange',function(){
    		 var params={ "divisionId" : $(this).val() };	
 			 $(this).loadChildSelectMenu("#departamento\\.id",
 			 	"<c:url value='/restService/departamentos'/>",params,'id','clave');	 
    	 }).trigger("selectmenuchange");
    	 
    	//carreras
    	$("#departamento\\.id").on('selectmenuchange',function(){
    		var params={ "departamentoId" : $(this).val() };	
			$(this).loadChildSelectMenu("#carrera\\.id",
				"<c:url value='/restService/carreras'/>",params,'id','clave');
    	}).trigger("selectmenuchange");
    	
    });
    
    </script>
  </head>
  <body>

    <div id="page-title">
      <b>Capturar Estudiante</b>
      <div id="page-subtitle">Datos generales del nuevo Estudiante:</div>
    </div>
    
    <!-- para procesar el formulario de forma asincrona, agregar /async al inicio del url -->
    <c:url value="/async/estudiante/crea"  var="url"/>
    
    <form:form method="post" action="${url}" modelAttribute="estudiante">
      <fieldset>
        <legend>Datos generales</legend>
        <ul class="three">
          <li>
            <label>Nombre : *</label>
            <form:errors cssClass="validation-error" path="nombre"/>
            <form:input path="nombre" cssClass="large"/>
          </li>
          <li>
            <label>Apellido paterno : *</label>
            <form:errors cssClass="validation-error" path="apPaterno"/>
            <form:input path="apPaterno" cssClass="large"/>
          </li>
          <li>
            <label>Apellido materno : *</label>
            <form:errors cssClass="validation-error" path="apMaterno"/>
            <form:input path="apMaterno" cssClass="large"/>
          </li>
        </ul>
        <ul class="four">
          <li>
            <label>Fecha de nacimiento (dd-mm-yyyy) : *</label>
            <form:errors cssClass="validation-error" path="fechaNacimiento"/>
            <form:input path="fechaNacimiento" cssClass="calendar medium"/>
          </li>
          <li>
            <label>CURP : </label>
            <form:errors cssClass="validation-error" path="CURP"/>
            <form:input path="CURP" cssClass="medium"/>    
          </li>
          <li>
            <label>N&uacute;mero de cuenta : *</label>
            <form:errors cssClass="validation-error" path="numCuenta"/>
            <form:input path="numCuenta" cssClass="medium"/>
          </li>
          <li>
            <label>Email : </label>
            <form:errors cssClass="validation-error" path="email"/>
            <form:input path="email" cssClass="large"/>  
          </li>
        </ul>
      </fieldset>
      <br><br>
      <fieldset>
        <legend>Datos acad&eacute;micos</legend>
        <ul>
          <li class="w30">
            <label>Tipo Estudiante</label>
            <form:errors cssClass="validation-error" path="tipoEstudiante"/>
              <form:select path="tipoEstudiante">
                <form:option value="0">SELECCIONE</form:option>
                <form:options/>
              </form:select>
          </li>
          <li class="w30">
            <label>Semestre : </label>
            <form:errors cssClass="validation-error" path="semestre"/>
              <form:select path="semestre">
                <form:option value="0">SELECCIONE</form:option>
                <c:forEach begin="1" end="10" varStatus="status">
                  <form:option value="${status.index}">${status.index}</form:option>
                </c:forEach>
              </form:select>
          </li>
          </ul>
          
          <ul>
            <li class="w30">
              <label>Divisi&oacute;n</label>
              <form:errors cssClass="validation-error" path="division.id"/>
                <form:select path="division.id" id="division.id">
                  <form:option value="0">SELECCIONE</form:option>
                </form:select>
            </li>
            
             <li class="w30">
              <label>Departamento :</label>
              <form:errors cssClass="validation-error" path="departamento.id"/>
                <form:select path="departamento.id" id ="departamento.id">
                  <form:option value="0">SELECCIONE</form:option>
                </form:select>
            </li>
            
             <li class="w30">
              <label>Carrera :</label>
              <form:errors cssClass="validation-error" path="carrera.id"/>
                <form:select path="carrera.id" id="carrera.id">
                  <form:option value="0">SELECCIONE</form:option>
                </form:select>
            </li>
          
        </ul>
      </fieldset>
      <br>
      <div align="center">   
        <input type="submit" value="Crear estudiante">
        <input type="reset" value="Limpiar">
        </div>
    </form:form>
  </body>
</html>
    