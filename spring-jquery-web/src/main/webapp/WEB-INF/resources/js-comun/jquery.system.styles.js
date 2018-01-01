/**
 * 
 * Al momento de que se carga la plantilla, se le aplican algunos estilos via jquery. Estos
 * estilos se clasifican en estaticos y dinamicos. Los dinamicos se aplican a través de la
 * funcion dynamicContentElements y los estaticos en la funcion staticElements. Ver
 * documentacion (abajo) para mayores detalles.
 * 
 * @author Jorge Rodríguez Campos.
 */

$(document).ready(function() {
  $("document").applyDynamicStyles().applyStaticStyles();
});

/**
 * Esta funcion agrega estilos al html que se muestra en la parte central(main-content) de la
 * pantalla via jQuery. Esta funcion se invoca en 2 lugares distintos:<br>
 * 1.AL momento de cargar la plantilla, es decir, en la funcion anterior (en el estado ready
 * del documento, esto cuando se carga toda la pagina. <br>
 * 2. en la funcion ajaxSpringMVCValidation en el archivo jquery.springmvc.ajax para los casos
 * en los que el server genera html y lo regresa al navegador via ajax mismo que requiere ser
 * desplegado en la parte central. <br>
 * Si este html contiene estilos que son aplicados via jQuery, estos no se mostrarian ya que
 * nunca se le aplicaron al html que regresa el server. Notese que en esta funcion solo se
 * definen los estilos que pueden aparecer en elementos html que en un momento dado pueden
 * aparecer en la parte central de la plantilla.
 * 
 */

(function($) {

  $.fn.applyDynamicStyles = function() {

    $("#main-content #page-title").addClass("ui-corner-all ui-widget-content");
    $("#main-content #page-title b").append('<div class="page-title-separator"></div>');

    // agrega tooltip a las formas de captura
    $("form fieldset legend").addClass("tooltip").attr("title",
        "Forma de captura - * Datos requeridos");

    // Tooltip
    $('.tooltip').tooltip({
      track : true,
      delay : 0,
      showURL : false,
      showBody : " - ",
      fade : 250
    });

    //botones de formularios
    $('input[type=button],input[type=reset],input[type=submit]').addClass(
    	'ui-button ui-corner-all ui-widget');
   
    //ligas en formularios
    $('.link-form').addClass('ui-corner-all ui-state-active');
    
    //formularios
    $( ".calendar" ).datepicker({dateFormat:"dd-mm-yy"});
    
    //input
    $('input[type=text]').addClass('ui-state-active');
    $('textarea').addClass('ui-state-active');
    $('form select').addClass('ui-state-active');
    
    // habilita formas para hacer submit con ajax
    //todas las formas cuyo atributo action tenga /async serán procesadas
    //de forma asíncrona.  Revisar web.xml y sitemesh3.xml en donde se 
    //configura el sporte de paths que inicien con /async.
    $('form[action*="/async"]').ajaxSpringMVCValidation(
        "validation-error", "#page-wrapper #main-content .portlet-content");
  
   //look & feel para radio buttons
    $( ".controlgroup" ).controlgroup();
   
    //look & feel para combos
    $("select").selectmenu();
   
    
    //radio buttons
    $( ".radioset" ).buttonset();
      
    return this;
  };
})(jQuery);

/**
 * Esta funcion agrega estilos via jQuery llamados estaticos porque solamente se aplican cuando
 * se carga toda la plantilla. Generalmente estos corresponden a los estilos de las 2 barras
 * laterales, la cuales no cambian especialmente en una peticion ajax. Esta funcion solo se
 * ejecuta al momento de cargar la plantilla en el estado ready del docmuento. Agrega estilos a
 * las cajas de texto, al elemento accordion, datepicker y reloj digital.
 * 
 */

(function($) {

  $.fn.applyStaticStyles = function() {

    // el elemento portlert se refiere alas cajas de texto (agrega
    // estilos)
    $(".portlet").addClass("ui-widget ui-widget-content ui-helper-clearfix ui-corner-all")
        .find(".portlet-header").addClass("ui-widget-header  ui-state-default ").prepend(
            '<span class=" ui-icon ui-icon-circle-arrow-s "></span>');

    $(".portlet-header .ui-icon").click(function() {
      $(this).toggleClass("ui-icon-circle-arrow-n");
      $(this).parents(".portlet:first").find(".portlet-content").slideToggle();
    });

    $(".portlet-header").addClass("ui-helper-clearfix ui-corner-all").hover(function() {
      $(this).addClass('ui-state-hover');
    }, function() {
      $(this).removeClass('ui-state-hover');
    });

    $(".portlet-menu").addClass("ui-widget-content ui-corner-all");

    $(".portlet-menu ul li").hover(function() {
      $(this).addClass('ui-state-hover');
    }, function() {
      $(this).removeClass('ui-state-hover');
    });

    // Accordion
    $("#accordion").accordion({
      header : "h3"
    });

    // datepicker
    $("#datepicker").datepicker();

    // clock
    $('.jclock').jclock({
      timeNotation : '12h',
      am_pm : true
    });

    // theme a mostrar
    $(function() {
      var newTheme = $.cookie("theme");

      if (newTheme) {
        swapTheme(newTheme);
      } else {
        swapTheme("default");
      }
    });

    // themes. Establece la accion al darle clic a estos elementos, empleados
    // para hacer swap de themes.
    $("#set_theme a").click(function() {
      var newTheme = $(this).attr("id");
      swapTheme(newTheme);
    });

    return this;

  };

})(jQuery);

/**
 * Esta funcion se encarga de hacer el swap entre 2 themes. La estrategia es la siguiente: en
 * main.jsp se encuentran definidos los elementos que apuntan a las hojas de estilo: <br>
 * <link id="theme-default" href="/themes/default/css/ui.css"/> La idea es hacer que se
 * sustituya el link, en este caso la cadena "default" con el valor del nuevo theme.<br>
 * El elemento id de <link> indica el theme que actualmente se muestra (currentTheme) el cual
 * se extrae del elemento.<br>
 * Teniendo estos 2 elementos, simplemente se hace la sustitucion de la cadena con base al
 * valor del id de la liga que selecciono el usuario: Por ejemplo<br>
 * <li id="set_theme"><a href="javascript:void(0);" id="default">Tema por default</a></li>
 * 
 * 
 */
function swapTheme(newTheme) {

  // obtiene los elementos <link> de las hojas de estilo para cambiarles el
  // url
  var arreglo = $.makeArray($("link[id|=theme]"));
  var currentTheme;
  $.each(arreglo, function(index, elemento) {
    var id = $(elemento).attr("id");
    // theme actual, le quita la cadena "theme-"
    currentTheme = id.substring(id.indexOf("-") + 1);
    // obtiene el url y le cambia la cadena para establecer el nuevo
    // theme
    var url = $(elemento).attr("href");
    url = url.replace(currentTheme, newTheme);
    $(elemento).attr("id", "theme-" + newTheme);
    $(elemento).attr("href", url);
  });

  // pone en negritas el seleccionado y en normal el anterior.
  $("#set_theme " + "#" + currentTheme).css("fontWeight", "normal");
  $("#set_theme " + "#" + newTheme).css("fontWeight", "bold");
  // actualiza el cookie
  $.cookie("theme", newTheme, {
    expires : 2
  });
}
