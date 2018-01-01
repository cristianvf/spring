/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 30/12/2017
 */
package com.jorgerdc.web.demo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jorgerdc.entidad.Carrera;
import com.jorgerdc.entidad.Departamento;
import com.jorgerdc.entidad.Division;

/**
 * RestController empleado para obtener datos que son empleados por los formularios empleando
 * Peticiones as�ncronas (Ajax). Ver la vista estudiante/captura.jsp para ver detalles de las
 * invocaciones as�ncronas.
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
@RestController
@RequestMapping("/restService/")
public class CatalogoRestController {

    private static final Logger logger = LoggerFactory.getLogger(CatalogoRestController.class);

    /**
     * @return
     */
    @RequestMapping(path = "divisiones", method = GET)
    public Set<Division> getDivisiones() {
        Set<Division> setDivision;

        logger.debug("Obteniendo divisiones ");

        setDivision = new HashSet<>(
                Arrays.asList(new Division(1, "MECANICA", "Ingenieria Mecanica", true),
                        new Division(2, "ELECTRICA", "Ingenieria electrica", true),
                        new Division(3, "CIENCIAS DE LA TIERRA", "Ciencias de la tierra", true)));
        return setDivision;
    }

    /**
     * @param divisionId
     * @return
     */
    @RequestMapping(path = "departamentos", method = GET)
    public Set<Departamento> getDepartamentos(@RequestParam("divisionId") int divisionId) {

        logger.debug("Obteniendo departamentos para divisionId = {} ", divisionId);

        if (divisionId == 1) {
            return new HashSet<>(
                    Arrays.asList(new Departamento(1, "D.HIDRAULICA", "D. Hidraulica", true),
                            new Departamento(2, "D.FLUIDOS", "D. Fluidos", true)));
        } else if (divisionId == 2) {
            return new HashSet<>(
                    Arrays.asList(new Departamento(3, "D.COMPUTACION", "D. Computaci�n", true),
                            new Departamento(4, "D.ELECTRONICA", "D. Electr�nica", true)));
        } else if (divisionId == 3) {
            return new HashSet<>(
                    Arrays.asList(new Departamento(5, "D. GEOFISICA", "D. Geof�sica", true),
                            new Departamento(6, "D.GEOLOGIA", "D. Geolog�a", true)));
        } else {
            throw new IllegalArgumentException("Valor invalido para departamentoId: " + divisionId);
        }
    }

    /**
     * @param departamentoId
     * @return
     */
    @RequestMapping(path = "carreras", method = GET)
    public Set<Carrera> getCarreras(@RequestParam("departamentoId") int departamentoId) {

        logger.debug("Obteniendo carreras para departamentoId = {} ", departamentoId);

        if (departamentoId == 1) {
            return new HashSet<>(Arrays
                    .asList(new Carrera(1, "ING. HIDRAULICA", "Ingenier�a Hidr�ulica", true)));
        } else if (departamentoId == 2) {
            return new HashSet<>(
                    Arrays.asList(new Carrera(2, "ING. FLUIDOS", "Ingenier�a en Fluidos", true)));
        } else if (departamentoId == 3) {
            return new HashSet<>(Arrays.asList(
                    new Carrera(3, "ING. COMPUTACION", "Ingenier�a en Computaci�n", true),
                    new Carrera(4, "ING. DATOS", "Ingenier�a en Datos", true)));
        } else if (departamentoId == 4) {
            return new HashSet<>(Arrays.asList(
                    new Carrera(5, "ING. ELECTRONICA", "Ingenier�a Electr�nica", true),
                    new Carrera(6, "ING. ELECTRICA", "Ingenier�a Electrica", true)));
        } else if (departamentoId == 5) {
            return new HashSet<>(
                    Arrays.asList(new Carrera(7, "ING. GEOFISICA", "Ingenier�a Geof�sica", true)));
        } else if (departamentoId == 6) {
            return new HashSet<>(
                    Arrays.asList(new Carrera(8, "ING. GEOLOGIA", "Ingenier�a Geolog�a", true)));
        } else {
            throw new IllegalArgumentException(
                    "Valor invalido para departamentoId: " + departamentoId);
        }
    }
}
