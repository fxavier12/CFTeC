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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabri
 */
@Entity
@Table(name = "postalcode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postalcode.findAll", query = "SELECT t FROM Postalcode t")
    , @NamedQuery(name = "Postalcode.findByCodigo", query = "SELECT t FROM Postalcode t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Postalcode.findByCodigoPostal", query = "SELECT t FROM Postalcode t WHERE upper(t.codigo_postal) like :codigo_postal")})
public class Postalcode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 255)
    @Column(name = "codigo_postal")
    private String codigo_postal;
    @JoinColumn(name = "codigo_city", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private City codigo_city;
    @JoinColumn(name = "codigo_type", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Type codigo_type;
    
    public Postalcode() {
    }

    public Postalcode(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public City getCodigo_city() {
        return codigo_city;
    }

    public void setCodigo_city(City codigo_city) {
        this.codigo_city = codigo_city;
    }

    public Type getCodigo_type() {
        return codigo_type;
    }

    public void setCodigo_type(Type codigo_type) {
        this.codigo_type = codigo_type;
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
        if (!(object instanceof Teste)) {
            return false;
        }
        Postalcode other = (Postalcode) object;
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

