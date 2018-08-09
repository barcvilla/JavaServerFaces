/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.backing;

import beans.model.Candidato;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@ManagedBean
@Named(value = "vacanteForm")
@RequestScoped
public class VacanteForm {

    //establecemos una dependencia
    @ManagedProperty(value = "#{candidato}")
    private Candidato candidato;

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String enviar() {
        System.out.println("Enviar() Nombre: " + this.candidato.getNombre());
        System.out.println("Enviar() Apellido: " + this.candidato.getApellido());
        System.out.println("Enviar() Sueldo deseado: " + this.candidato.getSueldoDeseado());
        System.out.println("enviar() Fecha Nacimiento: " + this.candidato.getFechaNacimiento());
        // Validacion Interdependiente
        if (this.candidato.getNombre().equals("Juan")){
            if(this.candidato.getApellido().equals("Perez")){
            String msg = "Gracias, pero Juan Perez ya trabaja con nosotros";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String clientId = null; // este es un mensaje gobal
            facesContext.addMessage(clientId, facesMessage);
            return "index";
            }
            return "exito";
        } 
        else {
            return "fallo";
        }
    }

}
