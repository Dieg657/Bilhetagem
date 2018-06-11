/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.ClassesDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "tb_voo_poltrona")
@NamedQueries({
    @NamedQuery(name = "VooPoltrona.findAll", query = "SELECT v FROM VooPoltrona v")
    , @NamedQuery(name = "VooPoltrona.findByIdtbVooPoltrona", query = "SELECT v FROM VooPoltrona v WHERE v.idtbVooPoltrona = :idtbVooPoltrona")
    , @NamedQuery(name = "VooPoltrona.findByPoltrona", query = "SELECT v FROM VooPoltrona v WHERE v.poltrona = :poltrona")})
public class VooPoltrona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtb_voo_poltrona")
    private Integer idtbVooPoltrona;
    @Basic(optional = false)
    @Column(name = "poltrona")
    private int poltrona;
    @JoinColumn(name = "localizador", referencedColumnName = "pass_localizador")
    @ManyToOne
    private Passagem localizador;
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "voo_tag", referencedColumnName = "voo_tag")
    @ManyToOne(optional = false)
    private Voo vooTag;

    public VooPoltrona() {
    }

    public VooPoltrona(Integer idtbVooPoltrona) {
        this.idtbVooPoltrona = idtbVooPoltrona;
    }

    public VooPoltrona(Integer idtbVooPoltrona, int poltrona) {
        this.idtbVooPoltrona = idtbVooPoltrona;
        this.poltrona = poltrona;
    }

    public Integer getIdtbVooPoltrona() {
        return idtbVooPoltrona;
    }

    public void setIdtbVooPoltrona(Integer idtbVooPoltrona) {
        this.idtbVooPoltrona = idtbVooPoltrona;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

    public Passagem getLocalizador() {
        return localizador;
    }

    public void setLocalizador(Passagem localizador) {
        this.localizador = localizador;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Voo getVooTag() {
        return vooTag;
    }

    public void setVooTag(Voo vooTag) {
        this.vooTag = vooTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtbVooPoltrona != null ? idtbVooPoltrona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VooPoltrona)) {
            return false;
        }
        VooPoltrona other = (VooPoltrona) object;
        if ((this.idtbVooPoltrona == null && other.idtbVooPoltrona != null) || (this.idtbVooPoltrona != null && !this.idtbVooPoltrona.equals(other.idtbVooPoltrona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ClassesDB.VooPoltrona[ idtbVooPoltrona=" + idtbVooPoltrona + " ]";
    }
    
}
