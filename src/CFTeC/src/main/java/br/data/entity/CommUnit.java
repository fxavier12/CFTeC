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
 * @author Sirnande Lima
 */
@Entity
@Table(name = "communit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommUnit.findAll", query = "SELECT t FROM CommUnit t")
    , @NamedQuery(name = "CommUnit.findByCodigo", query = "SELECT t FROM CommUnit t WHERE t.codigo = :codigo")})
public class CommUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 255)
    
    @NotNull
    @Column(name = "codigo_purpose")
    private Integer codigo_purpose;
    @Size(max = 255)
    
    @Column(name = "codigo_communit")
    private Integer codigo_communit;
    @Size(max = 255)
    

    public CommUnit() {
    }

    public CommUnit(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo_purpose() {
        return codigo_purpose;
    }

    public void setCodigo_purpose(Integer codigo_purpose) {
        this.codigo_purpose = codigo_purpose;
    }

    public Integer getCodigo_communit() {
        return codigo_communit;
    }

    public void setCodigo_communit(Integer codigo_communit) {
        this.codigo_communit = codigo_communit;
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
        if (!(object instanceof CommUnit)) {
            return false;
        }
        CommUnit other = (CommUnit) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Teste[ codigo=" + codigo + " ]";
    }
    
}
