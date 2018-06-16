/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ysazaka
 */

@Entity
@Table(name = "evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT t FROM Evaluation t")
    , @NamedQuery(name = "Evaluation.findByCodigo", query = "SELECT t FROM Evaluation t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "City.findByNome", query = "SELECT t FROM City t WHERE upper(t.nome) like :nome")})
public class Evaluation implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
//    @JoinColumn(name = "codigo_collaborator", referencedColumnName = "codigo")
//    @ManyToOne(optional = false)
//    private Collaborator codigo_collaborator;
//    @JoinColumn(name = "codigo_message", referencedColumnName = "codigo")
//    @ManyToOne(optional = false)
//    private Message codigo_message;
//    private Date data;
    private float value;

    // Getters and Setters
    
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
