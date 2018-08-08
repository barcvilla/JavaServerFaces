/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.model;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author PC
 */
@ManagedBean
@Named(value = "candidato")
@RequestScoped
public class Candidato {
    
    private String nombre = "Introduce tu nombre";
    private String apellido = "Introduce apellido";
    private int sueldoDeseado;
    private Date fechaNacimiento;
    /**
     * Creates a new instance of Candidato
     */
    public Candidato() {
        
    }

    

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido()
    {
        return apellido;
    }
    
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    
    public int getSueldoDeseado()
    {
        return sueldoDeseado;
    }
    
    public void setSueldoDeseado(int sueldo)
    {
        this.sueldoDeseado = sueldo;
    }
    
    public Date getFechaNacimiento()
    {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

}
