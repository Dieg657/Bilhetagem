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
@Table(name = "tb_usuario_func")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioFuncionario.findAll", query = "SELECT u FROM UsuarioFuncionario u")
    , @NamedQuery(name = "UsuarioFuncionario.findByCpfFunc", query = "SELECT u FROM UsuarioFuncionario u WHERE u.cpfFunc = :cpfFunc")
    , @NamedQuery(name = "UsuarioFuncionario.findByUsuario", query = "SELECT u FROM UsuarioFuncionario u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuarioFuncionario.findBySenha", query = "SELECT u FROM UsuarioFuncionario u WHERE u.senha = :senha")})
public class UsuarioFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf_func")
    private Long cpfFunc;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "senha")
    private String senha;
    @JoinColumn(name = "cpf_func", referencedColumnName = "cpf_func", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Funcionario funcionario;

    public UsuarioFuncionario() {
    }

    public UsuarioFuncionario(Long cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public Long getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(Long cpfFunc) {
        this.cpfFunc = cpfFunc;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfFunc != null ? cpfFunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioFuncionario)) {
            return false;
        }
        UsuarioFuncionario other = (UsuarioFuncionario) object;
        if ((this.cpfFunc == null && other.cpfFunc != null) || (this.cpfFunc != null && !this.cpfFunc.equals(other.cpfFunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ClassesDB.UsuarioFuncionario[ cpfFunc=" + cpfFunc + " ]";
    }
    
}
