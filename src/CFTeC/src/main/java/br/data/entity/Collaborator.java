/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import br.web.JsfCollaborator;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alann
 */
@Entity
@Table(name = "collaborator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collaborator.findAll", query = "SELECT t FROM Collaborator t")
    , @NamedQuery(name = "Collaborator.findByCodigo", query = "SELECT t FROM Collaborator t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Collaborator.findByNome", query = "SELECT t FROM Collaborator t WHERE upper(t.nome) like :nome")
    , @NamedQuery(name = "Collaborator.findByCodAtivacao", query = "SELECT t FROM Collaborator t WHERE t.codativacao = :codativacao")})
   
public class Collaborator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "data_nascimento")
    @Size(max = 15)
    private String data_nascimento;
    @Column(name = "codativacao")
    @Size(max = 8)
    private String codativacao;
    @Column (name = "collaborator_ativo")
    private boolean collaborator_ativo;

    public boolean isCollaborator_ativo() {
        return collaborator_ativo;
    }

    public void setCollaborator_ativo(boolean collaborator_ativo) {
        this.collaborator_ativo = collaborator_ativo;
    }

    public String getCodativacao() {
        return codativacao;
    }

    public void setCodativacao(String codativacao) {
        this.codativacao = codativacao;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

      

    public Collaborator() {
    }

    public Collaborator(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collaborator)) {
            return false;
        }
        Collaborator other = (Collaborator) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Collaborator[ codigo=" + codigo + " ]";
    }
}
