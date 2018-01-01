###Notas relevantes del proyecto.

#####Caracteristicas generales.
El proyecto hace uso de spring mvc, jquery, jquery UI y sitemesh.
Con estas 3 herramientas se construye una plantilla que simplifica el desarrollo
de vistas principalmente.

El principal decorador es  WEB-INF/decorators/main.jsp
En esta plantilla se ha implementado adicionalmente funcionalidad para procesar
vistas en forma asincrona. Revisar los siguientes archivos para mayores detalles:
- WEB-INF/views/jsp/estudiante/captura
- WEB-INF/resources/js-comun/jquery.springmvc.ajax.js
- WEB-INF/resources/js-comunjquery.system.styles.js

La plantilla puede ser personalizada con temas de Jquery UI.
En la columna derecha se puede observar algunas opciones para cambiar el look & feel
de la plantilla empleando distintos 'temas' los cuales se pueden ser generados empleando
el themroller de JqueryUI:  http://jqueryui.com/themeroller/

Para crear un nuevo tema en esta plantilla se realizan los siguientes pasos:

1. Crear o modificar un nuevo tema empleando el themroller de JQueryUI.
2. Descargar el archivo zip del sitio y descomprimirlo en algun directorio.
3. Dentro de WEB-INF/resources/themes se deberá crear una nueva carpeta con
   el nombre del tema.
4. Copiar los archivos siguiendo la misma estructura que los temas existentes.
   Los scripts principales de jquery y jqueryUI no se requieren copiar ya que estos
   se encuentran dentro WEB-INF/resources/js-comun

5. Copiar los archivos del menu superior. Estos se pueden copiar de otro tema existente
   o si se desea se puede descargar uno diferente de http://apycom.com/menus/1-white-smoke.html
   Los archivos que integran al menu son:
   
   -  WEB-INF/resources/themes/<nuevo-tema>/images/menu  Contiene las imagenes del menu
   -  WEB-INF/resources/themes/<nuevo-tema>/menu.css
   -  WEB-INF/resources/js-comun/menu.js Este archivo no se requiere copiar ya que es
      el mismo para todos los temas.

6.  Copiar los siguientes archivos  de estilo para el nuevo tema a partir de otro existente.
    Básicamente estos archivos son hojas de estilo que sirven para cambiar principalmente
    los colores de algunos elementos de la plantilla para que estos hagan match con el
    nuevo tema.
    
    -  WEB-INF/resources/themes/<nuevo-tema>/template.theme.css 

 
 7. Editar el archivo WEB-INF/decotators/columna-derecha.jsp   En este archivo se deberà
    agregar una nueva entrada para habilitar el nuevo tema. El id del elemento a debe
    ser el mismo que el nombre de la carpeta creada en el punto 3. Ejemplo:
    
     li id="set_theme"><a href="javascript:void(0);" id="rojo">Rojo</a>  /li  
    
   En este ejemplo, el id tiene como valor 'rojo' y corresponde con el nombre
   de la carpeta dentro de  WEB-INF/resources/themes/


   
