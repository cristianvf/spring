/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 29/12/2017
 */
package com.jorgerdc.entidad;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
public enum TipoEstudiante {

    REGULAR(1, "REGULAR", "Alumno regular sin adeudos", true),

    OYENTE(2, "OYENTE", "Alumno sin derecho a inscripción", true),

    EXALUMNO(3, "EXALMNO", "Ha terminado sus estudios sin adeudos", true);

    private int id;

    private String clave;

    private String descripcion;

    private boolean activo;

    private TipoEstudiante(int id, String clave, String descripcion, boolean activo) {

        this.id = id;
        this.clave = clave;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }
}
