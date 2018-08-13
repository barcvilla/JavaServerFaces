/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.backing;

import beans.helper.ColoniaHelper;
import beans.helper.FacesContextHelper;
import beans.model.Candidato;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author PC
 */
@ManagedBean
@Named(value = "vacanteForm")
@RequestScoped
public class VacanteForm {
    
    private boolean comentarioEnviado = false;
    
    //establecemos una dependencia
    @ManagedProperty(value = "#{candidato}")
    private Candidato candidato;
    
    @ManagedProperty(value = "#{coloniaHelper}")
    private ColoniaHelper coloniaHelper;

    public ColoniaHelper getColoniaHelper() {
        return coloniaHelper;
    }

    public void setColoniaHelper(ColoniaHelper coloniaHelper) {
        this.coloniaHelper = coloniaHelper;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public boolean isComentarioEnviado()
    {
        return comentarioEnviado;
    }
    
    public void setComentarioEnviado(boolean comentarioEnviado)
    {
        this.comentarioEnviado = comentarioEnviado;
    }
    
    //Metodo que nos permite controlar si se muestra u oculta el elemento de <h:PanelGroup>
    public void ocultarComentario(ActionEvent actionEvent)
    {
        this.comentarioEnviado = !this.comentarioEnviado;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesContextHelper.limpiarImmediateFacesMessages(facesContext);
    }
    
    //Metodo qu escucha cualquier modificacion en el capo Codigo postal de la pagina index 
    public void codigoPostalListener(ValueChangeEvent valueChangeEvent)
    {
        //obtenemos la instancia actual del contexto faces
        FacesContext facesContext = FacesContext.getCurrentInstance();
        //contenemos todos los objetos contenidos en el formulario html
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        //obtenemos el nuevo valor del codigo postal, ingresado por el usuario
        String newCodigoPostal = (String) valueChangeEvent.getNewValue();
        
        //recuperamos los elementos de ciudad y colonia en el formulario index.xhtml
        UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
        String ciudad = "DF";
        ciudadInputText.setValue(ciudad);
        ciudadInputText.setSubmittedValue(ciudad);

        UIInput coloniaInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:coloniaId");
        Long coloniaId = this.getColoniaHelper().getColoniaIdPorCP(Long.parseLong(newCodigoPostal));
        coloniaInputText.setValue(coloniaId);
        coloniaInputText.setSubmittedValue(coloniaId);

        facesContext.renderResponse();
        
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
