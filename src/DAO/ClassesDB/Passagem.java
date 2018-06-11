/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.ClassesDB;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego.soares
 */
@Entity
@Table(name = "tb_passagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passagem.findAll", query = "SELECT p FROM Passagem p")
    , @NamedQuery(name = "Passagem.findByPassBagagem", query = "SELECT p FROM Passagem p WHERE p.passBagagem = :passBagagem")
    , @NamedQuery(name = "Passagem.findByPassLocalizador", query = "SELECT p FROM Passagem p WHERE p.passLocalizador = :passLocalizador")})
public class Passagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "pass_bagagem")
    private Integer passBagagem;
    @Id
    @Basic(optional = false)
    @Column(name = "pass_localizador")
    private String passLocalizador;
    @JoinColumn(name = "cpf_passageiro", referencedColumnName = "cpf_cli")
    @ManyToOne
    private Cliente cpfPassageiro;
    @OneToMany(mappedBy = "localizador")
    private Collection<VooPoltrona> vooPoltronaCollection;

    public Passagem() {
    }

    public Passagem(String passLocalizador) {
        this.passLocalizador = passLocalizador;
    }

    public Integer getPassBagagem() {
        return passBagagem;
    }

    public void setPassBagagem(Integer passBagagem) {
        this.passBagagem = passBagagem;
    }

    public String getPassLocalizador() {
        return passLocalizador;
    }

    public void setPassLocalizador(String passLocalizador) {
        this.passLocalizador = passLocalizador;
    }

    public Cliente getCpfPassageiro() {
        return cpfPassageiro;
    }

    public void setCpfPassageiro(Cliente cpfPassageiro) {
        this.cpfPassageiro = cpfPassageiro;
    }

    @XmlTransient
    public Collection<VooPoltrona> getVooPoltronaCollection() {
        return vooPoltronaCollection;
    }

    public void setVooPoltronaCollection(Collection<VooPoltrona> vooPoltronaCollection) {
        this.vooPoltronaCollection = vooPoltronaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passLocalizador != null ? passLocalizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passagem)) {
            return false;
        }
        Passagem other = (Passagem) object;
        if ((this.passLocalizador == null && other.passLocalizador != null) || (this.passLocalizador != null && !this.passLocalizador.equals(other.passLocalizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ClassesDB.Passagem[ passLocalizador=" + passLocalizador + " ]";
    }
    
}
