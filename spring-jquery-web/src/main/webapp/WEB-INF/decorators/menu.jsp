 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <ul class="menu">
    <!-- Titulo Menu 1-->
    <li><a href="#" class="parent"><span>Estudiantes</span></a>
      <ul>
        <li>
          <a href="<c:url value='/estudiante/captura'/>" class="parent"><span>Capturar estudiante</span></a>
        </li>
        <li ><a href="#"><span>Opcion 2</span></a></li>
        <li><a href="#"><span>Opcion 3</span></a></li>
        <li><a href="#"><span>Opcion 4</span></a></li>
      </ul>
    </li>
    <!-- Titulo menu 2-->
    <li><a href="#" class="parent"><span>Formularios -Demo </span></a>
      <ul>
        <li>
          <a href="<c:url value='/formulario'/>" class="parent"><span>Ver Formulario</span></a>
        </li>
        <li><a href="#"><span>Opcion 3</span></a></li>
        <li><a href="#" class="parent"><span>Opcion 4</span></a>
          <ul>
          <li>
            <a href="#"><span>Modificar</span></a> <a href="#"><span>Consultar</span></a>
           </li> 
          </ul>
        </li>
      </ul>
    </li>
    <!--Titulo de menu 3-->
    <li><a href="#" class="parent"><span>Titulo de menu 3</span></a>
      <ul>
        <li><a href="#"><span>Opcion 3</span></a></li>
        <li><a href="#"><span>Opcion 4</span></a></li>
      </ul>
    </li>
    <!-- Titulo de menu 4-->
    <li><a href="#" class="parent"><span>Titulo de menu 4</span></a>
      <ul>
        <li><a href="#"><span>Opcion 41</span></a></li>
        <li><a href="#"><span>Opcion 42</span></a></li>
        <li><a href="#"><span>Opcion 43</span></a></li>
        <li><a href="#"><span>Opcion 44</span></a></li>
      </ul>
    </li>
     <!-- Titulo de menu 5-->
    <li><a href="#"><span>Titulo de menu 5</span></a>
      <ul>
        <li><a href="#"><span>Opcion 51</span></a></li>
        <li><a href="#"><span>Opcion 52</span></a></li>
      </ul>
    </li>
    <!-- Reportes-->
    <li><a href="#"><span>Reportes</span></a>
      <ul>
        <li><a href="#"><span>Reporte 1</span></a></li>
        <li><a href="#"><span>Estadisticos</span></a></li>
        <li><a href="#"><span>Concentrado</span></a></li>
        <li><a href="#"><span>Detallado</span></a></li>
        <li><a href="#"><span>Grafico</span></a></li>
      </ul>
    </li>
  </ul>