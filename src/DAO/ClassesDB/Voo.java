/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.ClassesDB;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "tb_voo")
@NamedQueries({
    @NamedQuery(name = "Voo.findAll", query = "SELECT v FROM Voo v")
    , @NamedQuery(name = "Voo.findByVooTag", query = "SELECT v FROM Voo v WHERE v.vooTag = :vooTag")
    , @NamedQuery(name = "Voo.findByOrigem", query = "SELECT v FROM Voo v WHERE v.origem = :origem")
    , @NamedQuery(name = "Voo.findByDestino", query = "SELECT v FROM Voo v WHERE v.destino = :destino")
    , @NamedQuery(name = "Voo.findByDtPartida", query = "SELECT v FROM Voo v WHERE v.dtPartida = :dtPartida")
    , @NamedQuery(name = "Voo.findByHrPartida", query = "SELECT v FROM Voo v WHERE v.hrPartida = :hrPartida")
    , @NamedQuery(name = "Voo.findByVlVoo", query = "SELECT v FROM Voo v WHERE v.vlVoo = :vlVoo")})
public class Voo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "voo_tag")
    private String vooTag;
    @Basic(optional = false)
    @Column(name = "origem")
    private String origem;
    @Basic(optional = false)
    @Column(name = "destino")
    private String destino;
    @Basic(optional = false)
    @Column(name = "dt_partida")
    @Temporal(TemporalType.DATE)
    private Date dtPartida;
    @Basic(optional = false)
    @Column(name = "hr_partida")
    @Temporal(TemporalType.TIME)
    private Date hrPartida;
    @Basic(optional = false)
    @Column(name = "vl_voo")
    private long vlVoo;
    @JoinColumn(name = "cpnj_emp", referencedColumnName = "cnpj")
    @ManyToOne(optional = false)
    private Empresa cpnjEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vooTag")
    private Collection<VooPoltrona> vooPoltronaCollection;

    public Voo() {
    }

    public Voo(String vooTag) {
        this.vooTag = vooTag;
    }

    public Voo(String vooTag, String origem, String destino, Date dtPartida, Date hrPartida, long vlVoo) {
        this.vooTag = vooTag;
        this.origem = origem;
        this.destino = destino;
        this.dtPartida = dtPartida;
        this.hrPartida = hrPartida;
        this.vlVoo = vlVoo;
    }

    public String getVooTag() {
        return vooTag;
    }

    public void setVooTag(String vooTag) {
        this.vooTag = vooTag;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getDtPartida() {
        return dtPartida;
    }

    public void setDtPartida(Date dtPartida) {
        this.dtPartida = dtPartida;
    }

    public Date getHrPartida() {
        return hrPartida;
    }

    public void setHrPartida(Date hrPartida) {
        this.hrPartida = hrPartida;
    }

    public long getVlVoo() {
        return vlVoo;
    }

    public void setVlVoo(long vlVoo) {
        this.vlVoo = vlVoo;
    }

    public Empresa getCpnjEmp() {
        return cpnjEmp;
    }

    public void setCpnjEmp(Empresa cpnjEmp) {
        this.cpnjEmp = cpnjEmp;
    }

    public Collection<VooPoltrona> getVooPoltronaCollection() {
        return vooPoltronaCollection;
    }

    public void setVooPoltronaCollection(Collection<VooPoltrona> vooPoltronaCollection) {
        this.vooPoltronaCollection = vooPoltronaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vooTag != null ? vooTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voo)) {
            return false;
        }
        Voo other = (Voo) object;
        if ((this.vooTag == null && other.vooTag != null) || (this.vooTag != null && !this.vooTag.equals(other.vooTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ClassesDB.Voo[ vooTag=" + vooTag + " ]";
    }
    
}
