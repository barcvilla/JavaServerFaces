/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.ejb;

import domain.entity.Colonia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class ColoniaFacade extends AbstractFacade<Colonia> {

    @PersistenceContext(unitName = "BolsaTrabajoV10PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ColoniaFacade() {
        super(Colonia.class);
    }
    
}
