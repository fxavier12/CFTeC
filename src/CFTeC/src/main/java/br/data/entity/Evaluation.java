/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yoshi
 */

@Entity
@Table(name = "evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT t FROM Evaluation t")
    , @NamedQuery(name = "Evaluation.findByCodigo", query = "SELECT t FROM Evaluation t WHERE t.codigo = :codigo")})
public class Evaluation implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "codigo_collaborator", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Collaborator codigo_collaborator;
    @JoinColumn(name = "codigo_message", referencedColumnName = "codigo")
    private Message codigo_message;
    
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    private float valor;

    // Getters and Setters

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Collaborator getCodigo_collaborator() {
        return codigo_collaborator;
    }

    public void setCodigo_collaborator(Collaborator codigo_collaborator) {
        this.codigo_collaborator = codigo_collaborator;
    }

    public Message getCodigo_message() {
        return codigo_message;
    }

    public void setCodigo_message(Message codigo_message) {
        this.codigo_message = codigo_message;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    // Constructor
    public Evaluation() {}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }
}
