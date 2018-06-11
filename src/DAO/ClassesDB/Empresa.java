/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.ClassesDB;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "tb_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByFantasiaEmp", query = "SELECT e FROM Empresa e WHERE e.fantasiaEmp = :fantasiaEmp")
    , @NamedQuery(name = "Empresa.findByInestEmp", query = "SELECT e FROM Empresa e WHERE e.inestEmp = :inestEmp")
    , @NamedQuery(name = "Empresa.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj")
    , @NamedQuery(name = "Empresa.findByEndEmp", query = "SELECT e FROM Empresa e WHERE e.endEmp = :endEmp")
    , @NamedQuery(name = "Empresa.findByNumEmpresa", query = "SELECT e FROM Empresa e WHERE e.numEmpresa = :numEmpresa")
    , @NamedQuery(name = "Empresa.findByComplEmp", query = "SELECT e FROM Empresa e WHERE e.complEmp = :complEmp")
    , @NamedQuery(name = "Empresa.findByCidadeEmp", query = "SELECT e FROM Empresa e WHERE e.cidadeEmp = :cidadeEmp")
    , @NamedQuery(name = "Empresa.findByCepEmp", query = "SELECT e FROM Empresa e WHERE e.cepEmp = :cepEmp")
    , @NamedQuery(name = "Empresa.findByEmailEmp", query = "SELECT e FROM Empresa e WHERE e.emailEmp = :emailEmp")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "fantasia_emp")
    private String fantasiaEmp;
    @Column(name = "inest_emp")
    private String inestEmp;
    @Id
    @Basic(optional = false)
    @Column(name = "cnpj")
    private Long cnpj;
    @Column(name = "end_emp")
    private String endEmp;
    @Column(name = "num_empresa")
    private String numEmpresa;
    @Column(name = "compl_emp")
    private String complEmp;
    @Column(name = "cidade_emp")
    private String cidadeEmp;
    @Column(name = "cep_emp")
    private Integer cepEmp;
    @Column(name = "email_emp")
    private String emailEmp;
    @Lob
    @Column(name = "obs_emp")
    private String obsEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpnjEmp")
    private Collection<Voo> vooCollection;
    @JoinColumn(name = "idest_emp", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idestEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cnpjEmp")
    private Collection<Funcionario> funcionarioCollection;

    public Empresa() {
    }

    public Empresa(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getFantasiaEmp() {
        return fantasiaEmp;
    }

    public void setFantasiaEmp(String fantasiaEmp) {
        this.fantasiaEmp = fantasiaEmp;
    }

    public String getInestEmp() {
        return inestEmp;
    }

    public void setInestEmp(String inestEmp) {
        this.inestEmp = inestEmp;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndEmp() {
        return endEmp;
    }

    public void setEndEmp(String endEmp) {
        this.endEmp = endEmp;
    }

    public String getNumEmpresa() {
        return numEmpresa;
    }

    public void setNumEmpresa(String numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    public String getComplEmp() {
        return complEmp;
    }

    public void setComplEmp(String complEmp) {
        this.complEmp = complEmp;
    }

    public String getCidadeEmp() {
        return cidadeEmp;
    }

    public void setCidadeEmp(String cidadeEmp) {
        this.cidadeEmp = cidadeEmp;
    }

    public Integer getCepEmp() {
        return cepEmp;
    }

    public void setCepEmp(Integer cepEmp) {
        this.cepEmp = cepEmp;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public void setEmailEmp(String emailEmp) {
        this.emailEmp = emailEmp;
    }

    public String getObsEmp() {
        return obsEmp;
    }

    public void setObsEmp(String obsEmp) {
        this.obsEmp = obsEmp;
    }

    @XmlTransient
    public Collection<Voo> getVooCollection() {
        return vooCollection;
    }

    public void setVooCollection(Collection<Voo> vooCollection) {
        this.vooCollection = vooCollection;
    }

    public Estado getIdestEmp() {
        return idestEmp;
    }

    public void setIdestEmp(Estado idestEmp) {
        this.idestEmp = idestEmp;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnpj != null ? cnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.cnpj == null && other.cnpj != null) || (this.cnpj != null && !this.cnpj.equals(other.cnpj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ClassesDB.Empresa[ cnpj=" + cnpj + " ]";
    }
    
}
