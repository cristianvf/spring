/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 29/12/2017
 */
package com.jorgerdc.entidad;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
public class Departamento extends Catalogo {

    /**
     * 
     */
    public Departamento() {
        super();
    }

    /**
     * @param id
     * @param clave
     * @param descripcion
     * @param activo
     */
    public Departamento(Integer id, String clave, String descripcion, boolean activo) {
        super(id, clave, descripcion, activo);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Departamento [ ");
        builder.append(super.toString());
        return builder.toString();
    }
}
