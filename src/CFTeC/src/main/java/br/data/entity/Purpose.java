/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
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
 * @author utfpr
 */

@Entity
@Table(name = "purpose")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purpose.findAll", query = "SELECT p FROM Purpose p")
    , @NamedQuery(name = "Purpose.findByCodigo", query = "SELECT p FROM Purpose p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Purpose.findByNome", query = "SELECT p FROM Purpose p WHERE upper(p.nome) like :nome")})

public class Purpose implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 120)
    @Column(name = "descricao")
    private String descricao;

    public Purpose() {
    }

    public Purpose(Integer codigo) {
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
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String nome) {
        this.descricao = descricao;
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
        if (!(object instanceof Purpose)) {
            return false;
        }
        Purpose other = (Purpose) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Purpose[ codigo=" + codigo + " ]";
    }
    
}
