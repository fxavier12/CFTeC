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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "artifact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artifact.findAll", query = "SELECT a FROM Artifact a")
    , @NamedQuery(name = "Artifact.findByCodigo", query = "SELECT a FROM Artifact a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Artifact.findByNome", query = "SELECT a FROM Artifact a WHERE upper(a.nome) like :nome")})
public class Artifact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Size(max = 10)
    @Column(name = "versao")
    private String versao;
    @Column(name = "arquivo")
    private byte[] arquivo;
    @Column(name = "arquivo_type")
    private String arquivo_type;
    @Column(name = "arquivo_name")
    private String arquivo_name;
    @NotNull
    @Column(name = "message_codigo")
    private Integer message_codigo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getArquivo_type() {
        return arquivo_type;
    }

    public void setArquivo_type(String arquivo_type) {
        this.arquivo_type = arquivo_type;
    }

    public String getArquivo_name() {
        return arquivo_name;
    }

    public void setArquivo_name(String arquivo_name) {
        this.arquivo_name = arquivo_name;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public Integer getMessage_codigo() {
        return message_codigo;
    }

    public void setMessage_codigo(Integer message_codigo) {
        this.message_codigo = message_codigo;
    }

    public Artifact() {
    }

    public Artifact(Integer codigo) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artifact)) {
            return false;
        }
        Artifact other = (Artifact) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Artifact[ codigo=" + codigo + " ]";
    }
    
}
