/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 29/12/2017
 */
package com.jorgerdc.web.demo.validator;

import static com.jorgerdc.web.validator.CustomValidator.REQUIRED_MESSAGE_KEY;
import static com.jorgerdc.web.validator.CustomValidator.rejectIfNotEmail;
import static com.jorgerdc.web.validator.CustomValidator.rejectIfNotGreaterThan;
import static com.jorgerdc.web.validator.CustomValidator.rejectIfNotInLength;
import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jorgerdc.entidad.Estudiante;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
@Component
public class EstudianteValidator implements Validator {

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> clazz) {

        return Estudiante.class.isAssignableFrom(clazz);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    @Override
    public void validate(Object target, Errors errors) {

        Estudiante e;

        rejectIfEmptyOrWhitespace(errors, "nombre", REQUIRED_MESSAGE_KEY);
        rejectIfEmptyOrWhitespace(errors, "apPaterno", REQUIRED_MESSAGE_KEY);
        rejectIfEmptyOrWhitespace(errors, "apMaterno", REQUIRED_MESSAGE_KEY);
        rejectIfEmptyOrWhitespace(errors, "tipoEstudiante", REQUIRED_MESSAGE_KEY);
        rejectIfEmptyOrWhitespace(errors, "fechaNacimiento", REQUIRED_MESSAGE_KEY);
        rejectIfEmptyOrWhitespace(errors, "numCuenta", REQUIRED_MESSAGE_KEY);
        e = (Estudiante) target;
        rejectIfEmptyOrWhitespace(errors, "CURP", REQUIRED_MESSAGE_KEY);
        rejectIfNotInLength("CURP", e.getCURP(), 18, 18, errors);
        if (e.getEmail() != null) {
            rejectIfNotEmail("email", e.getEmail(), errors);
        }
        rejectIfEmptyOrWhitespace(errors, "tipoEstudiante", REQUIRED_MESSAGE_KEY);
        rejectIfNotGreaterThan("semestre", e.getSemestre(), 0, errors);

        rejectIfEmptyOrWhitespace(errors, "division.id", REQUIRED_MESSAGE_KEY);
        if (e.getDivision() != null) {
            rejectIfNotGreaterThan("division.id", e.getDivision().getId(), 0, errors);
        }
        rejectIfEmptyOrWhitespace(errors, "departamento.id", REQUIRED_MESSAGE_KEY);
        if (e.getDepartamento() != null) {
            rejectIfNotGreaterThan("departamento.id", e.getDepartamento().getId(), 0, errors);
        }
        rejectIfEmptyOrWhitespace(errors, "carrera.id", REQUIRED_MESSAGE_KEY);
        if (e.getCarrera() != null) {
            rejectIfNotGreaterThan("carrera.id", e.getCarrera().getId(), 0, errors);
        }
    }

}
