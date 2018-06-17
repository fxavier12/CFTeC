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
 * @author Diego Vilella Rodrigues
 */
@Entity
@Table(name = "site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT t FROM Site t")
    , @NamedQuery(name = "Site.findByCodigo", query = "SELECT t FROM Site t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Site.findByNome", query = "SELECT t FROM Site t WHERE upper(t.nome) like :nome")})
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;    
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Column(name = "posicaoGeo")
    private String posicaoGeo;    
    @Column(name = "observacao")
    private String observacao; 
    @Column(name = "codigoProject")
    private Integer codigoProject;

   
    public Site() {
    }
    
    
    
    public Site(Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getPosicaoGeo() {
        return posicaoGeo;
    }
    
    
    public void setPosicaoGeo(String posicaoGeo) {
        this.posicaoGeo = posicaoGeo;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public String getObservacao() {
        return observacao;
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
    
    public Integer getCodigoProject() {
        return codigoProject;
    }

    public void setCodigoProject(Integer codigoProject) {
        this.codigoProject = codigoProject;
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
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Site[ codigo=" + codigo + " ]";
    }
    
}
