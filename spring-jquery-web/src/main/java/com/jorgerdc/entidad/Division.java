/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 29/12/2017
 */
package com.jorgerdc.entidad;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
public class Division extends Catalogo {

    /**
     * 
     */
    public Division() {
        super();
    }

    /**
     * @param id
     * @param clave
     * @param descripcion
     * @param activo
     */
    public Division(Integer id, String clave, String descripcion, boolean activo) {
        super(id, clave, descripcion, activo);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Division [ ");
        builder.append(super.toString());
        return builder.toString();
    }
}