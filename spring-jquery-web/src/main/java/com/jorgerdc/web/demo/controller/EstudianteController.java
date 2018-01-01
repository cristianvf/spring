/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 29/12/2017
 */
package com.jorgerdc.web.demo.controller;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerdc.entidad.Carrera;
import com.jorgerdc.entidad.Departamento;
import com.jorgerdc.entidad.Division;
import com.jorgerdc.entidad.Estudiante;
import com.jorgerdc.web.demo.validator.EstudianteValidator;

/**
 * Controller que administra la página de inicio.
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
@Controller
@RequestMapping("/estudiante/")
public class EstudianteController {

    private static final Logger logger = LoggerFactory.getLogger(EstudianteController.class);

    private static final String view_captura = "estudiante/captura";

    private static final String view_resultado = "general/resultado";

    @Resource
    private EstudianteValidator estudianteValidator;

    /**
     * @return
     */
    @RequestMapping("captura")
    public String captura(ModelMap model) {
        Estudiante estudiante;

        estudiante = new Estudiante();
        estudiante.setSemestre(1);
        estudiante.setDivision(new Division());
        estudiante.setDepartamento(new Departamento());
        estudiante.setCarrera(new Carrera());
        model.addAttribute(estudiante);
        logger.debug("Mostrando pagina de captura de estudiantes");
        return view_captura;
    }

    /**
     * @param binder
     */
    @InitBinder(value = { "estudiante" })
    public void initBinderLibro(WebDataBinder binder) {
        binder.setValidator(estudianteValidator);
    }

    @RequestMapping("crea")
    public String crea(@Valid Estudiante estudiante, BindingResult result, ModelMap model) {
        logger.debug("recibiendo datos del estudiante, verificando resultado de validacion {}",
                estudiante);
        if (result.hasErrors()) {
            return view_captura;
        }
        logger.debug("Sin errores, se procede a crear el objeto");
        model.addAttribute("keys", Arrays.asList("id", "Nombre", "Apellido Paterno",
                "Apellido Materno", "Email", "Num. de Cuenta", "CURP", "Semestre"));
        model.addAttribute("values",
                Arrays.asList(estudiante.getId(), estudiante.getNombre(), estudiante.getApPaterno(),
                        estudiante.getApMaterno(), estudiante.getEmail(), estudiante.getNumCuenta(),
                        estudiante.getCURP(), estudiante.getSemestre()));

        return view_resultado;
    }

}
