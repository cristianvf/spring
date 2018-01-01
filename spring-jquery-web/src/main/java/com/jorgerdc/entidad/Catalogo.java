/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 29/12/2017
 */
package com.jorgerdc.entidad;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
public abstract class Catalogo {

    private Integer id;

    private String clave;

    private String descripcion;

    private boolean activo;

    /**
     * @param id
     * @param clave
     * @param descripcion
     * @param activo
     */
    public Catalogo(Integer id, String clave, String descripcion, boolean activo) {
        super();
        this.id = id;
        this.clave = clave;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Catalogo() {

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave
     *        the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion
     *        the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo
     *        the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" id=");
        builder.append(id);
        builder.append(", clave=");
        builder.append(clave);
        builder.append(", descripcion=");
        builder.append(descripcion);
        builder.append(", activo=");
        builder.append(activo);
        builder.append("]");
        return builder.toString();
    }

}
