<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Nombre completo del Sistema</title>

<link id="comun-template" href="<c:url value='/resources/css-comun/template-comun.css'/>" rel="stylesheet" type="text/css" />
<link id="comun-forms" href="<c:url value='/resources/css-comun/forms-comun.css'/>" rel="stylesheet" type="text/css" />
<link id="jgrid" href="<c:url value='/resources/css-comun/jsgrid.min.css'/>" rel="stylesheet" type="text/css" />
<link id="jgrid-theme" href="<c:url value='/resources/css-comun/jsgrid-theme.min.css'/>" rel="stylesheet" type="text/css" />

<link id="theme-default"  href="<c:url value='/resources/themes/default/jquery-ui.min.css'/>" rel="stylesheet" type="text/css" />
<link id="theme-default"  href="<c:url value='/resources/themes/default/jquery-ui.structure.min.css'/>" rel="stylesheet" type="text/css" />
<link id="theme-default"  href="<c:url value='/resources/themes/default/jquery-ui.theme.min.css'/>" rel="stylesheet" type="text/css" />
<link id="theme-default"  href="<c:url value='/resources/themes/default/menu.css'/>" rel="stylesheet" type="text/css" />
<link id="theme-default"  href="<c:url value='/resources/themes/default/template.theme.css'/>" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="<c:url value='/resources/js-comun/jquery-3.2.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/jquery-ui.min-1.12.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/jquery.cookie.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/jquery.easing.1.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/jquery.easing.compatibility.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/jquery.form.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/jquery.jclock-1.2.0.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/menu.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/jquery.springmvc.ajax.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/jquery.system.styles.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js-comun/jsgrid.min.js'/>"></script>


<!-- header dinamico -->
<sitemesh:write property='head'/>

</head>
  <body>
 
  <!-- header seccion 1 -->
  <div id="header-top" class="ui-state-hover">
    <c:import url="/WEB-INF/decorators/header-top.jsp"/>
  </div>
  
  <!-- header seccion 2  -->
  <div id="header-center" class="ui-state-default"> 
    <c:import url="/WEB-INF/decorators/header-center.jsp"/>
  </div>
  
  <!--  menu superior -->
  <div id="header-bottom">
  	<div id="menu" class="ui-widget">
    		<c:import url ="/WEB-INF/decorators/menu.jsp"/>
  	</div>
  </div>
  <!-- page-wrapper -->
  <div id="page-wrapper">
    
    <!-- columna izquierda-->
    <div id="columna-izquierda">
      <c:import url ="/WEB-INF/decorators/columna-izquierda.jsp"/>
    </div>
    
    <!-- panel principal -->
    <div id="main-content">
      
      <div class="portlet">
        <div class="portlet-header">Nombre del sistema</div>
        <div class="portlet-content" >
              <sitemesh:write property='body'/>
        </div>
      </div>        
    
    </div>
    
    <!-- columna derecha -->
    <div id="columna-derecha">
      <c:import url ="/WEB-INF/decorators/columna-derecha.jsp"/>
    </div>
    
  </div>
  <!-- fin page-wrapper -->
  
  <!-- footer -->
  <div id="footer" align="center" class="ui-state-hover ui-widget"> 
    <c:import url ="/WEB-INF/decorators/footer.jsp"/>
  </div>
    <!-- requisito para usar el menu, no quitar. -->
    <a href="http://apycom.com/">.</a>
  
  </body>
</html>
