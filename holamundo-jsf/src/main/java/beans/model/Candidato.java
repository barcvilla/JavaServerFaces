package beans.model;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Named
public class Candidato {

  private String nombre = "Introduce tu nombre";

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
