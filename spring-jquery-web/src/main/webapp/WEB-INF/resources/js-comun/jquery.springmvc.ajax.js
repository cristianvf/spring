/**
 * Plugin - Wrapper Method empleado para habilitar y personalizar el envio de
 * formas y su validacion con springMVC vía AJAX.
 * @author Jorge Rodríguez Campos
 * */

/**
 * Este wrapper method permite hacer submit de una forma html empleando ajax,
 * mostrando los resultados de validacion en caso de error que generan SpringMVC
 * a través del tag <form:errors>.
 * 
 * Una vez que se recibe la respuesta asincrona al enviar la forma via ajax
 * (html generado por el server), esta función busca todos los elementos dentro
 * de esta respuesta que tengan un estilo igual al especificado por el parametro
 * ccsClass. Por ejemplo:
 * 
 * En el HTML se tiene: <form:errors path="nombre" cssClass="validation-error"/>, 
 * que al ser procesados por Spring MVC genera: <span
 * class="validation-error" id="nombre.errors"> mensaje </span>
 * 
 * Lo anterior se usa para anexar dichos elementos ( con etiqueta "span") que
 * genera SpringMVC con los posibles errores de validacion.
 * 
 * Para determinar en que parte del documento actual se deben anexar los
 * mensajes de validacion, se explica con el siguiente ejemplo:
 * 
 * Suponer que en el jsp actual se tiene: <form:input path="nombre"/>
 * <form:errors path="nombre" cssClass="validation-error" />
 * 
 * lo que se muestra como: <input type ="text" id="nombre">
 * 
 * Si este campo tiene errores de validacion, SpringMVC regresa un elemento como
 * el siguiente:
 * 
 * <span class="validation-error" id="nombre.errors"> mensaje </span>
 * 
 * Las acciones que realiza esta funcion para agregar el mensaje de validación
 * son:
 * 
 * 1. obtiene el id del elemento con el mensaje de error (en este caso
 * "nombre.errors") <br>
 * 2. A la cadena le quita el subfijo ".errors", por lo que queda "nombre" <br>
 * 3. Obtiene de la pagina actual el elemento cuyo id sea "nombre" y con el
 * metodo insertAfter agrega el elemento de validacion. <br>
 * De esta forma se tiene el mismo resultado a como si se hubiera hecho la
 * peticion sin AJAX. La ventaja es que se puede hacer switch entre ajax y la
 * forma tradicional unicamente eliminando el valor del id del elemento form.
 * 
 * Adicionalmente, la funcion recibe el parametro targetElement, el cual
 * corresponde al id de algun elemento html de la pagina actual en el que se
 * pintará la respuesta del server en caso de que no se encuentren errores de
 * validación.
 */
(function($) {
	$.fn.ajaxSpringMVCValidation = function(cssClass, targetElement) {
		
		// envia peticion con ajaxForm
		return this.ajaxForm(function(data) {

			// elimina posibles mensajes de error existentes en la pagina actual
				$("." + cssClass).remove();

				// parsea la respuesta para presentar los errores de validacion.
				var validationElements = $("." + cssClass, data);
				var arreglo = $.makeArray(validationElements);

				if (arreglo.length > 0) {
					$.each(arreglo, function(index, elemento) {
						var id = $(elemento).attr("id");
						var formElement = id.substr(0, id.indexOf(".errors"));
						//escapa el "." para atributos correspondientes a agregaciones
						//por ejemplo path="direccion.nombre"
						formElement=formElement.replace(".","\\.");						
						$(elemento).insertAfter("#" + formElement);
					});
				} else {

					// sin errores de validacion, muestra el html del server, y
					// agrega los
					// estilos dinamicos a los elementos
					$(targetElement).html(data).applyDynamicStyles();
				}
			});
	};
})(jQuery);

/**
 * Esta funcion realiza una llamada ajax con formato JSON para llenar el contenido
 * de su SelectMenu dependiente.
 * Nota: Estas funciones trabajan con jquery widgets tipo 'selectmenu', no son compatibles
 * con objetos 'select' nativos.
 * En caso de que no se seleccione algun valor diferente a 0, null o -,o cadena vacia
 * se deshabilita el selectMenu dependiente para que la seleccion sea congruente.
 * De forma similar, si se actualiza el valor del selectMenu padre, se actualiza tambien
 * el valor del hijo, para tener una seleccion congruente.
 * Este comportamiento se realiza de manera recursiva al agregar una llamada al metodo
 * change, lo que genera el efecto cascada. Por cada cambio se genera una peticion AJAX
 *
 * child:    El selectMenu 'hijo' a inicializar
 * keyValue: el nombre de la propiedad que se va a emplear para establecer
 *           el valor del atributo 'value' del tag 'option'
 * desc:     El nombre de la propiedad que se va a emplear para establecer
 *           la descripción o valor del tag 'option'.  Es decir:
 *           <option value='keyValue'>desc</option>
 
 * */
(function($){
	$.fn.loadChildSelectMenu=function(child,url,params,keyValue,desc){
		var parent=this;
		var value = $(parent).val();
		//alert('parent:'+ value);
		$(child).emptyOptions();
		if(!value || value=='-'|| value=='0' || value==''){				
			//con elementos comunes, en lugar de usar trigger, se usarìa 'change();'
			
			//alert('child '+$(child).val());
			$(child).selectmenu("disable").trigger('selectmenuchange');
		}else {
			$(child).loadSelectMenu(url,params,keyValue,desc).trigger('selectmenuchange');
		}	
		return parent;
	};
})(jQuery);


/**
 * Similar a loadSelectMenu, pero en este caso solo se inicializa el
 * objeto  representado por la variable this.
 * */
(function($) {
	$.fn.loadSelectMenu = function(url,params,keyValue,desc) {
		var element = this;
		//invoca al servicio
		$.getJSON(url,params, function(data) {
			loadSelectMenuFx(element,data,keyValue,desc);
		});
		return this;
	};

})(jQuery);


/**
 * Esta funcion vacia el contenido de un selectMenu.
 * Se emplea justo antes de llenarlo via AJAX
 * */
(function($) {
	$.fn.emptyOptions = function() {
		return this.each(function() {
			if (this.tagName == 'SELECT'){
				$(this).empty();
				var ua = window.navigator.userAgent;
			    var msie = ua.indexOf("MSIE ");
				if (msie > 0) {
					this.add(new Option("SELECCIONE","0"));
				} else {
					var option = new Option("SELECCIONE","0");
					option.selected=true;
					this.add(option,null);
				}
				$(this).selectmenu("refresh");
			}
		});
	};
})(jQuery);


/**
 * Función interna y reutilizable encargada de llenar los 
 * elementos de un selectMenu.
 * element:   El elemento JS que contiene al objeto selectMenu. Se requiere usar un
 *            foreach para extraer al objeto selectMenu.
 * data:	  El documento JSON que contiene los datos a mostrar
 * keyValue:  el nombre de la propiedad que se va a emplear para establecer
 *            el valor del atributo 'value' del tag 'option'
 * desc:      El nombre de la propiedad que se va a emplear para establecer
 *            la descripción o valor del tag 'option'.  Es decir:
 *            <option value='keyValue'>desc</option>
 *
 **/
function  loadSelectMenuFx(element,data,keyValue,desc){
	
	$(element).each(function() {
		if (this.tagName == 'SELECT') {
			var selectMenu = this;
			var ua = window.navigator.userAgent;
		    var msie = ua.indexOf("MSIE ");
			$(selectMenu).selectmenu("enable");
			$(selectMenu).emptyOptions();
			$.each(data, function() {
				var option = new Option(this[desc],this[keyValue]);
				if (msie > 0) {
					selectMenu.add(option);
				} else {
					selectMenu.add(option, null);
				}
			});
			$(selectMenu).selectmenu("refresh");
		}else{
			alert('Invalid Html element. Required: <select>, actual: '+element.tagName);
		}
	});
}


