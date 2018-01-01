<html>
  <head>
    <script type="text/javascript">
    // Muestra el uso de jsGrid.  Se puede integrar con Spring MVC para
    // mostrar los datos y en general para administrarlos empleando peticiones ajax.
    $(document).ready(function(){
  	
    	var direcciones = [
        	{"calle": "Av. Insurgentes","numero":2342, "colonia": 1,"cp":"01010","residencia": true},
        	{"calle": "Zapata","numero":34, "colonia": 2,"cp":"98348","residencia": true},
        	{"calle": "Av. Revolución","numero":21, "colonia": 3,"cp":"34701","residencia": false},
        	{"calle": "Interlomas","numero":4321, "colonia": 4,"cp":"08948","residencia": true},
        	{"calle": "Norte 34","numero":9, "colonia": 5,"cp":"07312","residencia": false},
        	{"calle": "Sur 567","numero":56, "colonia": 5,"cp":"10348","residencia": true}
        
        ];
     
    	var colonias = [
            { Name: "", Id: 0 },
            { Name: "Napoles", Id: 1 },
            { Name: "Alpes", Id: 2 },
            { Name: "Hidalgo", Id: 3 },
            { Name: "Juarez", Id: 4},
            { Name: "Chalco", Id: 5 }
        ];
     
        $(".jsgrid").jsGrid({
            width: "100%",
            height: "220px",
     
            inserting: true,
            editing: true,
            sorting: true,
            paging: true,
            pageSize: 4,
     
            data: direcciones,
     
            fields: [
                { name: "calle",title: "Calle", type: "text", width: 100, validate: "required" },
                { name: "colonia",title: "Número", type: "number", width: 30 },
                { name: "colonia",title: "Colonia", type: "select", items: colonias, valueField: "Id", textField: "Name" },
                { name: "cp", title: "Código Postal", type: "text", width: 50, validate: "required" },
                { name: "residencia",title: "Residencia", type: "checkbox", width: 30, sorting: false },
                { type: "control" }
            ]
        });
    });
	</script>  
  </head>
  <body>
    
    <div id="page-title">
      <b>Capturar cliente</b>
      <div id="page-subtitle">Datos generales del nuevo cliente:</div>
    </div>
    <br>
    <div align="center">
    
    <b>Este formulario no tiene funcionalidad. Su utilidad es mostrar la forma en la
    que se construyen los formularios empleando esta plantilla.</b>
    </div>
    <br><br>
    
    <form>
      <fieldset>
        <legend>Datos generales</legend>
        <ul class="four">
           <li>
            <label>Tipo Cliente : </label>
            <div class="controlgroup">
            <select>
              <option>SELECCIONE</option>
              <option>ORDINARIO</option>
              <option>VIP</option>
              <option>TEMPORAL</option>
              <option>PERMANENTE</option>
            </select>
            </div>
          </li>
          <li>         
            <label>Nombre * : </label>
            <input type="text" name="nombre" class="large">     
          </li>
          <li>         
            <label>Apellido Paterno * : </label>
            <input type="text" name="nombre" class="large">     
          </li>
          <li>         
            <label>Apellido Materno * : </label>
            <input type="text" name="nombre" class="large">     
          </li>
        </ul>
        <ul class="four">
          <li>
            <label>RFC * :</label>
            <input type="text" class="medium">
          </li>
          <li>
            <label>CURP * :</label>
            <input type="text" class="medium">
          </li>
          <li>
            <label>Fecha de nacimiento * :</label>
            <input type="text" class="medium" id="datepicker">
          </li>
          <li>
            <label>Correo electr&oacute;nico * :</label>
            <input type="text" class="large">
          </li>
        </ul>
        <ul class="four">
          <li>
            <label>Nombre de usuario * :</label>
            <input type="text" class="medium">
          </li>
          <li>
            <label>password * :</label>
            <input type="text" class="medium">
          </li>
          <li>
            <label>Confirmar password * :</label>
            <input type="text" class="medium">
          </li>
        </ul>
      </fieldset>
     <br><br>
    <fieldset>
      <legend>Datos de pago</legend>
      <ul>
        <li class="w20">
          <label>N&uacute;mero de tarjeta * : </label>
          <input type="text" size="18">
        </li>
        <li class="w40">
          <label>Tipo de tarjeta * : </label>
          <div class="radioset">
             <input type="radio" name="tipoTarjeta" id="mcard">
             <label for="mcard">Master Card</label>
             <input type="radio" name="tipoTarjeta" id="visa">
             <label for="visa">VISA</label>
             <input type="radio" name="tipoTarjeta" id="ae">
             <label for="ae">American Express</label>
          </div>	
        </li>
        <li class="w15">
            <label>Mes expiraci&oacute;n * :</label>
            <input type="text" class="tiny">
          </li>
          <li class="w15">
            <label>A&ntilde;o expiraci&oacute;n * :</label>
            <input type="text" class="tiny">
          </li>
      </ul>
      <ul>
        <li class="w30">
            <label>Nombre del titular * :</label>
            <input type="text" class="large">
          </li>
      </ul>
    </fieldset>
    <br><br>
     <fieldset>
      <legend>&Aacute;reas de inter&eacute;s</legend>
      <ul>
        <li>
          <div class="controlgroup">
          <label for="prog">Programaci&oacute;n</label>
          <input type="checkbox" name="prog" id="prog">
          <label for="lit">Literatura</label>
          <input type="checkbox" name="prog" id="lit">
          <label for="mat">Matem&aacute;ticas</label>
          <input type="checkbox" name="prog" id="mat">
          <label for="dep">Deportes</label>
          <input type="checkbox" name="prog" id="dep">
          <label for="mus">M&uacute;sica</label>
          <input type="checkbox" name="prog" id="mus">
          </div>
        </li> 
      </ul>
    </fieldset>
    <br><br>
    <fieldset>
      <legend>Direcciones del cliente</legend>
      <br>
      <div class="jsgrid"></div>
       
    </fieldset>
    <br><br>
    <fieldset>
      <legend>Lista de roles del nuevo cliente</legend>
      <br> 
      <div align="center">
        <table class ="grid">
          <thead>
            <tr>
              <td>Num.rol</td>
              <td>Clave</td>
              <td>Descripci&oacute;n</td>
              <td>Activo</td>
            </tr>
          </thead>
          <tbody>
          <tr>
            <td>1</td>
            <td>CAPTURISTA</td>
            <td>Realiza la captura de datos en las pantallas del sistema</td>
            <td>true</td>
            </tr>
            <tr>
              <td>2</td>
              <td>ADMIN</td>
              <td>Encargado de autorizar acciones administrativas en el sistema</td>
              <td>false</td>
            </tr>
          </tbody>
        </table>
       </div>
        
    </fieldset>
    
    <br><br>
      <div align="center">
        <input type="button" value="Guardar">
      </div>  
    </form>
  </body>
</html>
 