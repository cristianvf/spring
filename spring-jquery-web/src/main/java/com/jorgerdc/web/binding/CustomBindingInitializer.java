/**
 * CustomBindingInitializer.java Fecha de creación: 06/02/2010, 16:32:06
 */
package com.jorgerdc.web.binding;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

/**
 * Esta clase define la conversión de objetos tipo Date a nivel global, evitando asi tener que
 * configurar el tratamiento empleando @InitBinder en cada controller. Adicionalmente, registra un
 * property editor personalizado que permite dejar pasar comnbos mapeados a un enum como valores
 * nulos cuando la seleccion del combo sea opcional.
 * 
 * @author Jorge A. Rodríguez Campos (jorgerdc@gmail.com)
 * @version 1.0
 */
public class CustomBindingInitializer implements WebBindingInitializer {

    public static final String DATE_FORMAT = "dd-MM-yyyy";

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_OBJ = new SimpleDateFormat(DATE_FORMAT);

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.bind.support.WebBindingInitializer#initBinder(org.springframework.web
     * .bind.WebDataBinder)
     */
    @Override
    public void initBinder(WebDataBinder binder) {

        SIMPLE_DATE_FORMAT_OBJ.setLenient(false);
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(SIMPLE_DATE_FORMAT_OBJ, false));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
