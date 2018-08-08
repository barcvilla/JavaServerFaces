/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.backing;

import beans.model.Candidato;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

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
  
  public Candidato getCandidato()
  {
      return candidato;
  }
  
  public void setCandidato(Candidato candidato) {
    this.candidato = candidato;
  }

  public String enviar() {
    if (this.candidato.getNombre().equals("Juan")) {
      return "exito";
    } else {
      return "fallo";
    }
  }
    
}
