/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 29/12/2017
 */
package com.jorgerdc.entidad;

import java.util.Date;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
public class Estudiante {

    private Long id;

    private String nombre;

    private String apPaterno;

    private String apMaterno;

    private TipoEstudiante tipoEstudiante;

    private Date fechaNacimiento;

    private String CURP;

    private String numCuenta;

    private String email;

    private int semestre;

    private Division division;

    private Departamento departamento;

    private Carrera carrera;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     *        the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apPaterno
     */
    public String getApPaterno() {
        return apPaterno;
    }

    /**
     * @param apPaterno
     *        the apPaterno to set
     */
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    /**
     * @return the apMaterno
     */
    public String getApMaterno() {
        return apMaterno;
    }

    /**
     * @param apMaterno
     *        the apMaterno to set
     */
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    /**
     * @return the tipoEstudiante
     */
    public TipoEstudiante getTipoEstudiante() {
        return tipoEstudiante;
    }

    /**
     * @param tipoEstudiante
     *        the tipoEstudiante to set
     */
    public void setTipoEstudiante(TipoEstudiante tipoEstudiante) {
        this.tipoEstudiante = tipoEstudiante;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento
     *        the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the cURP
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * @param cURP
     *        the cURP to set
     */
    public void setCURP(String cURP) {
        CURP = cURP;
    }

    /**
     * @return the numCuenta
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * @param numCuenta
     *        the numCuenta to set
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *        the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre
     *        the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the division
     */
    public Division getDivision() {
        return division;
    }

    /**
     * @param division
     *        the division to set
     */
    public void setDivision(Division division) {
        this.division = division;
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento
     *        the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the carrera
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     * @param carrera
     *        the carrera to set
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Estudiante [id=");
        builder.append(id);
        builder.append(", nombre=");
        builder.append(nombre);
        builder.append(", apPaterno=");
        builder.append(apPaterno);
        builder.append(", apMaterno=");
        builder.append(apMaterno);
        builder.append(", tipoEstudiante=");
        builder.append(tipoEstudiante);
        builder.append(", fechaNacimiento=");
        builder.append(fechaNacimiento);
        builder.append(", CURP=");
        builder.append(CURP);
        builder.append(", numCuenta=");
        builder.append(numCuenta);
        builder.append(", email=");
        builder.append(email);
        builder.append(", semestre=");
        builder.append(semestre);
        builder.append(", division=");
        builder.append(division);
        builder.append(", departamento=");
        builder.append(departamento);
        builder.append(", carrera=");
        builder.append(carrera);
        builder.append("]");
        return builder.toString();
    }
}
