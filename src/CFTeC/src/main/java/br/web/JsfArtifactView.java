/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author alexandrelerario
 */
@ManagedBean
@ViewScoped
public class JsfArtifactView {

    /**
     * Creates a new instance of JsfTeste
     */
    public JsfArtifactView() {
    }

    private int codigo;
    private byte[] arquivo; 
    private String descricao;
    private int message = 1 ;
    private String nome;
    private String versao;

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public java.util.List<br.data.entity.Artifact> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudArtifact().SelectByNome(nome);
        } else {
            return null;
        }
    }

  
}
