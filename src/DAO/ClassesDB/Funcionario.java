/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.ClassesDB;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "tb_funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByNmFunc", query = "SELECT f FROM Funcionario f WHERE f.nmFunc = :nmFunc")
    , @NamedQuery(name = "Funcionario.findByCpfFunc", query = "SELECT f FROM Funcionario f WHERE f.cpfFunc = :cpfFunc")
    , @NamedQuery(name = "Funcionario.findByTelFunc", query = "SELECT f FROM Funcionario f WHERE f.telFunc = :telFunc")
    , @NamedQuery(name = "Funcionario.findByEmailFunc", query = "SELECT f FROM Funcionario f WHERE f.emailFunc = :emailFunc")
    , @NamedQuery(name = "Funcionario.findByIdsexoFunc", query = "SELECT f FROM Funcionario f WHERE f.idsexoFunc = :idsexoFunc")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nm_func")
    private String nmFunc;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf_func")
    private Long cpfFunc;
    @Column(name = "tel_func")
    private Integer telFunc;
    @Column(name = "email_func")
    private String emailFunc;
    @Column(name = "idsexo_func")
    private Integer idsexoFunc;
    @Lob
    @Column(name = "obs_func")
    private String obsFunc;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private UsuarioFuncionario usuarioFuncionario;
    @JoinColumn(name = "cnpj_emp", referencedColumnName = "cnpj")
    @ManyToOne(optional = false)
    private Empresa cnpjEmp;

    public Funcionario() {
    }

    public Funcionario(Long cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getNmFunc() {
        return nmFunc;
    }

    public void setNmFunc(String nmFunc) {
        this.nmFunc = nmFunc;
    }

    public Long getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(Long cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public Integer getTelFunc() {
        return telFunc;
    }

    public void setTelFunc(Integer telFunc) {
        this.telFunc = telFunc;
    }

    public String getEmailFunc() {
        return emailFunc;
    }

    public void setEmailFunc(String emailFunc) {
        this.emailFunc = emailFunc;
    }

    public Integer getIdsexoFunc() {
        return idsexoFunc;
    }

    public void setIdsexoFunc(Integer idsexoFunc) {
        this.idsexoFunc = idsexoFunc;
    }

    public String getObsFunc() {
        return obsFunc;
    }

    public void setObsFunc(String obsFunc) {
        this.obsFunc = obsFunc;
    }

    public UsuarioFuncionario getUsuarioFuncionario() {
        return usuarioFuncionario;
    }

    public void setUsuarioFuncionario(UsuarioFuncionario usuarioFuncionario) {
        this.usuarioFuncionario = usuarioFuncionario;
    }

    public Empresa getCnpjEmp() {
        return cnpjEmp;
    }

    public void setCnpjEmp(Empresa cnpjEmp) {
        this.cnpjEmp = cnpjEmp;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.cpfFunc == null && other.cpfFunc != null) || (this.cpfFunc != null && !this.cpfFunc.equals(other.cpfFunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ClassesDB.Funcionario[ cpfFunc=" + cpfFunc + " ]";
    }
    
}
