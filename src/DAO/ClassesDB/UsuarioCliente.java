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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego.soares
 */
@Entity
@Table(name = "tb_usuario_cli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioCliente.findAll", query = "SELECT u FROM UsuarioCliente u")
    , @NamedQuery(name = "UsuarioCliente.findByCpfCli", query = "SELECT u FROM UsuarioCliente u WHERE u.cpfCli = :cpfCli")
    , @NamedQuery(name = "UsuarioCliente.findByUsuario", query = "SELECT u FROM UsuarioCliente u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuarioCliente.findBySenha", query = "SELECT u FROM UsuarioCliente u WHERE u.senha = :senha")})
public class UsuarioCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf_cli")
    private Long cpfCli;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @JoinColumn(name = "cpf_cli", referencedColumnName = "cpf_cli", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cliente cliente;

    public UsuarioCliente() {
    }

    public UsuarioCliente(Long cpfCli) {
        this.cpfCli = cpfCli;
    }

    public UsuarioCliente(Long cpfCli, String usuario, String senha) {
        this.cpfCli = cpfCli;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(Long cpfCli) {
        this.cpfCli = cpfCli;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof UsuarioCliente)) {
            return false;
        }
        UsuarioCliente other = (UsuarioCliente) object;
        if ((this.cpfCli == null && other.cpfCli != null) || (this.cpfCli != null && !this.cpfCli.equals(other.cpfCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ClassesDB.UsuarioCliente[ cpfCli=" + cpfCli + " ]";
    }
    
}
