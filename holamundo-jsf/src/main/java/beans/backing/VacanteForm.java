package beans.backing;

import beans.model.Candidato;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
@Named
public class VacanteForm {

  @Inject
  private Candidato candidato;

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
