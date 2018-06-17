/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author alexandrelerario
 */
@ManagedBean
@RequestScoped
public class JsfArtifact {

    /**
     * Creates a new instance of JsfTeste
     */
    public JsfArtifact() {
    }
    private int codigo;
    private byte[] arquivo;
    UploadedFile file;
    private String descricao;
    private int message = 1 ;
    private String nome;
    private String versao;

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
    private String arquivo_type;
    private String arquivo_name;
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
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


    public String persist() {
      
        br.data.entity.Artifact art;
        art = new br.data.entity.Artifact();
        art.setCodigo(codigo);
        art.setNome(nome);
        art.setArquivo_type(file.getContentType());
        art.setArquivo_name(file.getFileName());
        art.setArquivo(file.getContents());
        art.setDescricao(descricao);
        art.setVersao(versao);
        art.setMessage_codigo(message);
        
        Exception insert = new br.data.crud.CrudArtifact().persist(art);
        if (insert == null) {
            this.setCodigo(0);
            this.setNome("");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro adicionado com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = insert.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
        
        return "/operacoes/index.xhtml";
    }

    public String update(br.data.entity.Artifact artifact) {
        this.codigo = artifact.getCodigo();
        this.nome = artifact.getNome();
        this.descricao = artifact.getDescricao();
        this.versao = artifact.getVersao();
        this.message = artifact.getMessage_codigo();
        this.arquivo_name = artifact.getArquivo_name();
        this.arquivo_type = artifact.getArquivo_type();
        return "merge.xhtml";
    }
    
    public String merge() {
        br.data.entity.Artifact art;
        art = new br.data.crud.CrudArtifact().find(this.codigo);
        art.setNome(nome);
        art.setDescricao(descricao);
        art.setVersao(versao);
        art.setMessage_codigo(message);
        art.setArquivo_name(arquivo_name);
        art.setArquivo_type(arquivo_type);
        Exception e = new br.data.crud.CrudArtifact().merge(art);
        if (e == null) {
            this.setCodigo(0);
            this.setNome("");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro alterado com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "/operacoes/index.xhtml";
    }
    
    public java.util.List<br.data.entity.Artifact> getAll() {
        return new br.data.crud.CrudArtifact().getAll();
    }

    public java.util.List<br.data.entity.Artifact> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudArtifact().SelectByNome(nome);
        } else {
            return null;
        }
    }

    public void remove(br.data.entity.Artifact artifact) {
        Exception e =new br.data.crud.CrudArtifact().remove(artifact);
         if (e == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro excluido com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void buttonAction(ActionEvent actionEvent) {
        System.out.println("ola mundo ======================");
    }
}
