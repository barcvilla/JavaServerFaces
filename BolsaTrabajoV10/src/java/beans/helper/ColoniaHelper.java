/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.helper;

//import domain.dto.Colonia;
import domain.entity.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import servicio.ejb.ColoniaFacade;

/**
 *
 * @author PC
 */
@Named(value = "coloniaHelper")
@RequestScoped
public class ColoniaHelper {

    /**
     * Creates a new instance of ColoniaHelper
     */
    public ColoniaHelper() {
    }
    
    @EJB
    ColoniaFacade coloniaFacade;
    
    public List<Colonia> getColonias()
    {
        List<Colonia> colonias = coloniaFacade.findAll();
        return colonias;
    }
    
    public long getColoniaIdPorNombre(String nombreColonia)
    {
        long coloniaId =0;
        List<Colonia> colonias = getColonias(); // recupera una lista de colonias
        for(Colonia colonia : colonias)
        {
            if(colonia.getNombreColonia().equals(nombreColonia))
            {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }
    
    public long getColoniaIdPorCP(long codigoPostal)
    {
        long coloniaId = 0;
        List<Colonia> colonias = getColonias();
        for(Colonia colonia : colonias)
        {
            if(colonia.getCodigoPostal() == codigoPostal)
            {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }
    
    public List<SelectItem> getSelectItems()
    {
        List<SelectItem> selectItems;
        selectItems = new ArrayList<SelectItem>();
        List<Colonia> colonias = getColonias();
        for(Colonia colonia : colonias)
        {
            SelectItem selectItem = new SelectItem(colonia.getColoniaId(), colonia.getNombreColonia());
            selectItems.add(selectItem);
        }
        return selectItems;
    }
    
}
