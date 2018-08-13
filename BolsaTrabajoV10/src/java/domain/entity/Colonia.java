/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colonia.findAll", query = "SELECT c FROM Colonia c")
    , @NamedQuery(name = "Colonia.findByColoniaId", query = "SELECT c FROM Colonia c WHERE c.coloniaId = :coloniaId")
    , @NamedQuery(name = "Colonia.findByNombreColonia", query = "SELECT c FROM Colonia c WHERE c.nombreColonia = :nombreColonia")
    , @NamedQuery(name = "Colonia.findByCodigoPostal", query = "SELECT c FROM Colonia c WHERE c.codigoPostal = :codigoPostal")})
public class Colonia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "colonia_id")
    private Integer coloniaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_colonia")
    private String nombreColonia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_postal")
    private int codigoPostal;

    public Colonia() {
    }

    public Colonia(Integer coloniaId) {
        this.coloniaId = coloniaId;
    }

    public Colonia(Integer coloniaId, String nombreColonia, int codigoPostal) {
        this.coloniaId = coloniaId;
        this.nombreColonia = nombreColonia;
        this.codigoPostal = codigoPostal;
    }

    public Integer getColoniaId() {
        return coloniaId;
    }

    public void setColoniaId(Integer coloniaId) {
        this.coloniaId = coloniaId;
    }

    public String getNombreColonia() {
        return nombreColonia;
    }

    public void setNombreColonia(String nombreColonia) {
        this.nombreColonia = nombreColonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coloniaId != null ? coloniaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colonia)) {
            return false;
        }
        Colonia other = (Colonia) object;
        if ((this.coloniaId == null && other.coloniaId != null) || (this.coloniaId != null && !this.coloniaId.equals(other.coloniaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.entity.Colonia[ coloniaId=" + coloniaId + " ]";
    }
    
}
