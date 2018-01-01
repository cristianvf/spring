/**
 * CustomValidator.java Fecha de creación: 09/02/2010, 17:47:45 Este software es de propósito
 * educativo, puede ser empleado para fines sin lucro haciendo referencia al autor intelectual.
 */
package com.jorgerdc.web.validator;

import static com.jorgerdc.web.binding.CustomBindingInitializer.SIMPLE_DATE_FORMAT_OBJ;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;

/**
 * Clase de utileria que contiene métodos para realizar validaciones de los datos que contienen las
 * entidades de negocio. Estos validadores se pueden aplicar a cualquier capa (Web, servicios,
 * validacion de notificaciones xml).
 * 
 * @author Jorge A. Rodríguez Campos (jorgerdc@gmail.com)
 * @version 1.0
 */
public class CustomValidator {

    /**
     * Property name que indica que un campo debe ser obligatorio.
     */
    public static final String REQUIRED_MESSAGE_KEY = "required";

    /**
     * property name que asocia al mensaje enviado a la vista cuando una lista esta nula o vacia.
     */
    public static final String EMPTY_LIST_MESSAGE_KEY = "custom.validation.empty.list";

    /**
     * Valor menor al especificado. Su valor debe estar configurado en un archivo properties de
     * mensajes: custom.validation.notGreaterThanValue
     */
    public static String NOT_GREATER_THAN_MESSAGE_KEY = "custom.validation.not.greater.than.value";

    /**
     * Mensaje empleado para indicar que una cadena no cumple con la longitud requerida.
     */
    public static String NOT_IN_LENGTH = "custom.validation.string.length";

    /**
     * Mensaje empleado para correos electrónicos con formato incorrecto.
     */
    public static String NOT_EMAIL = "custom.validation.not.email";

    /**
     * Mensaje de error empleado para fechas que no están antes de la especificada
     */
    public static String NOT_BEFORE_DATE = "custom.validation.not.before.date";

    /**
     * Mensaje de error empleado para fechas que están antes de la especificada
     */
    public static String BEFORE_DATE = "custom.validation.before.date";

    /**
     * mensaje de error empleado para fechas que están después de la especificada.
     */
    public static String NOT_AFTER_DATE = "custom.validation.not.after.date";

    /**
     * mensaje de error empleado para fechas que no están después de la especificada.
     */
    public static String AFTER_DATE = "custom.validation.after.date";

    /**
     * Esta cadena se imprimirá en las visas en caso de que no se encuentre el nombre del property
     * en el archovo messages.properties.
     */
    public static String DEFAULT_MESSAGE = "message key not found in properties file (add it)";

    /**
     * Verifica que el valor de un campo no sea menor al valor referenciado. El mensaje generado
     * acepta un argumento para indicar el valor de referencia.
     * 
     * @author Jorge A. Rodríguez Campos (jorgerdc@gmail.com)
     * @param fieldName
     * @param value
     * @param referencedValue
     * @param errors
     */
    public static void rejectIfNotGreaterThan(String fieldName, double value,
            double referencedValue, Errors errors) {
        if (value <= referencedValue) {
            errors.rejectValue(fieldName, NOT_GREATER_THAN_MESSAGE_KEY, new Object[] { value },
                    DEFAULT_MESSAGE);
        }
    }

    /**
     * Verifica que el valor de un campo no sea menor al valor referenciado. El mensaje generado
     * acepta un argumento para indicar el valor de referencia.
     * 
     * @author Jorge A. Rodríguez Campos (jorgerdc@gmail.com)
     * @param fieldName
     * @param value
     * @param referencedValue
     * @param errors
     */
    public static void rejectIfNotGreaterThan(String fieldName, Number value,
            double referencedValue, Errors errors) {

        if (value == null) {
            errors.reject(fieldName, REQUIRED_MESSAGE_KEY);
        } else if (value.doubleValue() <= referencedValue) {
            errors.rejectValue(fieldName, NOT_GREATER_THAN_MESSAGE_KEY, new Object[] { value },
                    DEFAULT_MESSAGE);
        }
    }

    /**
     * Verifica que una lista no sea nula o vacia.
     * 
     * @author Jorge A. Rodríguez Campos (jorgerdc@gmail.com)
     * @param fieldName
     * @param value
     * @param errors
     */
    public static void rejectIfEmpty(String fieldName, Collection<?> value, Errors errors) {
        if (value == null || value.size() == 0) {
            errors.rejectValue(fieldName, EMPTY_LIST_MESSAGE_KEY, DEFAULT_MESSAGE);
        }
    }

    /**
     * Rechaza el campo si fecha1 no es anterior a fecha2
     * 
     * @param fieldname
     * @param fecha1
     * @param fecha2
     * @param errors
     */
    public static void rejectIfNotBefore(String fieldname, Date fecha1, Date fecha2,
            Errors errors) {
        if (!fecha1.before(fecha2)) {
            errors.rejectValue(fieldname, NOT_BEFORE_DATE,
                    new Object[] { SIMPLE_DATE_FORMAT_OBJ.format(fecha2) }, DEFAULT_MESSAGE);
        }
    }

    /**
     * Rechaza el campo si fecha1 no es posterior a fecha2
     * 
     * @param fieldname
     * @param fecha1
     * @param fecha2
     * @param errors
     */
    public static void rejectIfNotAfter(String fieldname, Date fecha1, Date fecha2, Errors errors) {
        if (!fecha1.after(fecha2)) {

            errors.rejectValue(fieldname, NOT_AFTER_DATE,
                    new Object[] { SIMPLE_DATE_FORMAT_OBJ.format(fecha2) }, DEFAULT_MESSAGE);
        }

    }

    /**
     * Rechaza el campo si fecha1 es anterior a fecha2
     * 
     * @param fieldname
     * @param fecha1
     * @param fecha2
     * @param errors
     */
    public static void rejectIfBefore(String fieldname, Date fecha1, Date fecha2, Errors errors) {
        if (fecha1.before(fecha2)) {

            errors.rejectValue(fieldname, BEFORE_DATE,
                    new Object[] { SIMPLE_DATE_FORMAT_OBJ.format(fecha2) }, DEFAULT_MESSAGE);
        }

    }

    /**
     * Rechaza el campo si fecha1 es posterior a fecha2
     * 
     * @param fieldname
     * @param fecha1
     * @param fecha2
     * @param errors
     */
    public static void rejectIfAfter(String fieldname, Date fecha1, Date fecha2, Errors errors) {
        if (fecha1.after(fecha2)) {

            errors.rejectValue(fieldname, AFTER_DATE,
                    new Object[] { SIMPLE_DATE_FORMAT_OBJ.format(fecha2) }, DEFAULT_MESSAGE);
        }

    }

    /**
     * Rechaza un campo vacío
     * 
     * @param fieldName
     * @param value
     * @param errors
     */
    public static void rejectIfEmpty(String fieldName, String value, Errors errors) {
        if (value == null || value.trim().length() == 0) {
            errors.rejectValue(fieldName, REQUIRED_MESSAGE_KEY, DEFAULT_MESSAGE);
        }
    }

    /**
     * Verifica que una cadena tenga como longitud minima y máxima la especificada en los
     * parámetros.
     * 
     * @param fieldName
     * @param value
     * @param minValue
     * @param maxValue
     */
    public static void rejectIfNotInLength(String fieldName, String value, int minValue,
            int maxValue, Errors errors) {
        int length = value == null ? 0 : value.trim().length();
        if (value == null || length < minValue || length > maxValue) {
            errors.rejectValue(fieldName, NOT_IN_LENGTH, new Object[] { minValue, maxValue },
                    DEFAULT_MESSAGE);
        }
    }

    /**
     * @param fieldName
     * @param value
     */
    public static void rejectIfNotEmail(String fieldName, String value, Errors errors) {
        if (value == null || !EmailValidator.getInstance().isValid(value)) {
            errors.rejectValue(fieldName, NOT_EMAIL, DEFAULT_MESSAGE);
        }
    }

}
