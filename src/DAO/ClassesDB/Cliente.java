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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "tb_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByNmCli", query = "SELECT c FROM Cliente c WHERE c.nmCli = :nmCli")
    , @NamedQuery(name = "Cliente.findByDocCli", query = "SELECT c FROM Cliente c WHERE c.docCli = :docCli")
    , @NamedQuery(name = "Cliente.findByOrgCli", query = "SELECT c FROM Cliente c WHERE c.orgCli = :orgCli")
    , @NamedQuery(name = "Cliente.findByDtnascCli", query = "SELECT c FROM Cliente c WHERE c.dtnascCli = :dtnascCli")
    , @NamedQuery(name = "Cliente.findByCpfCli", query = "SELECT c FROM Cliente c WHERE c.cpfCli = :cpfCli")
    , @NamedQuery(name = "Cliente.findByEndCli", query = "SELECT c FROM Cliente c WHERE c.endCli = :endCli")
    , @NamedQuery(name = "Cliente.findByNumCli", query = "SELECT c FROM Cliente c WHERE c.numCli = :numCli")
    , @NamedQuery(name = "Cliente.findByComplCli", query = "SELECT c FROM Cliente c WHERE c.complCli = :complCli")
    , @NamedQuery(name = "Cliente.findByBairroCli", query = "SELECT c FROM Cliente c WHERE c.bairroCli = :bairroCli")
    , @NamedQuery(name = "Cliente.findByCidadeCli", query = "SELECT c FROM Cliente c WHERE c.cidadeCli = :cidadeCli")
    , @NamedQuery(name = "Cliente.findByEmailCli", query = "SELECT c FROM Cliente c WHERE c.emailCli = :emailCli")})
public class Cliente implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private UsuarioCliente usuarioCliente;
    @OneToMany(mappedBy = "cpfPassageiro", fetch = FetchType.LAZY)
    private Collection<Passagem> passagemCollection;

    private static final long serialVersionUID = 1L;
    @Column(name = "nm_cli")
    private String nmCli;
    @Column(name = "doc_cli")
    private String docCli;
    @Column(name = "org_cli")
    private String orgCli;
    @Column(name = "dtnasc_cli")
    @Temporal(TemporalType.DATE)
    private Date dtnascCli;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf_cli")
    private Long cpfCli;
    @Column(name = "end_cli")
    private String endCli;
    @Column(name = "num_cli")
    private String numCli;
    @Column(name = "compl_cli")
    private String complCli;
    @Column(name = "bairro_cli")
    private String bairroCli;
    @Column(name = "cidade_cli")
    private String cidadeCli;
    @Column(name = "email_cli")
    private String emailCli;
    @Lob
    @Column(name = "obs_cli")
    private String obsCli;
    @JoinColumn(name = "iduf_cli", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idufCli;
    @JoinColumn(name = "idest_cli", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idestCli;

    public Cliente() {
    }

    public Cliente(Long cpfCli) {
        this.cpfCli = cpfCli;
    }

    public String getNmCli() {
        return nmCli;
    }

    public void setNmCli(String nmCli) {
        this.nmCli = nmCli;
    }

    public String getDocCli() {
        return docCli;
    }

    public void setDocCli(String docCli) {
        this.docCli = docCli;
    }

    public String getOrgCli() {
        return orgCli;
    }

    public void setOrgCli(String orgCli) {
        this.orgCli = orgCli;
    }

    public Date getDtnascCli() {
        return dtnascCli;
    }

    public void setDtnascCli(Date dtnascCli) {
        this.dtnascCli = dtnascCli;
    }

    public Long getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(Long cpfCli) {
        this.cpfCli = cpfCli;
    }

    public String getEndCli() {
        return endCli;
    }

    public void setEndCli(String endCli) {
        this.endCli = endCli;
    }

    public String getNumCli() {
        return numCli;
    }

    public void setNumCli(String numCli) {
        this.numCli = numCli;
    }

    public String getComplCli() {
        return complCli;
    }

    public void setComplCli(String complCli) {
        this.complCli = complCli;
    }

    public String getBairroCli() {
        return bairroCli;
    }

    public void setBairroCli(String bairroCli) {
        this.bairroCli = bairroCli;
    }

    public String getCidadeCli() {
        return cidadeCli;
    }

    public void setCidadeCli(String cidadeCli) {
        this.cidadeCli = cidadeCli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    public String getObsCli() {
        return obsCli;
    }

    public void setObsCli(String obsCli) {
        this.obsCli = obsCli;
    }

    public Estado getIdufCli() {
        return idufCli;
    }

    public void setIdufCli(Estado idufCli) {
        this.idufCli = idufCli;
    }

    public Estado getIdestCli() {
        return idestCli;
    }

    public void setIdestCli(Estado idestCli) {
        this.idestCli = idestCli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfCli != null ? cpfCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cpfCli == null && other.cpfCli != null) || (this.cpfCli != null && !this.cpfCli.equals(other.cpfCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Pessoa.Cliente[ cpfCli=" + cpfCli + " ]";
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public Collection<Passagem> getPassagemCollection() {
        return passagemCollection;
    }

    public void setPassagemCollection(Collection<Passagem> passagemCollection) {
        this.passagemCollection = passagemCollection;
    }
    
}
