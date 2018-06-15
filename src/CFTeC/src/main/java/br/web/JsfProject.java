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

/**
 *
 * @author Diego Vilella Rodrigues
 */
@ManagedBean
@RequestScoped
public class JsfProject {

    /**
     * Creates a new instance of JsfProject
     */
    public JsfProject() {
    }

    private int codigo;
    private String nome;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        br.data.entity.Project project;
        project = new br.data.entity.Project();
        project.setCodigo(codigo);
        project.setNome(nome);
        project.setDescricao(descricao);
        Exception insert = new br.data.crud.CrudProject().persist(project);
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

    public java.util.List<br.data.entity.Project> getAll() {
        return new br.data.crud.CrudProject().getAll();
    }

    public java.util.List<br.data.entity.Project> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudProject().SelectByNome(nome);
        } else {
            return null;
        }
    }

    public void remove(br.data.entity.Project project) {
        Exception e =new br.data.crud.CrudProject().remove(project);
         if (e == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro excluido com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String update(br.data.entity.Project project) {
        this.codigo = project.getCodigo();
        this.nome = project.getNome();
        return "merge.xhtml";
    }

    public String merge() {
        br.data.entity.Project project;
        project = new br.data.crud.CrudProject().find(this.codigo);
        project.setNome(nome);
        Exception e = new br.data.crud.CrudProject().merge(project);
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
    
    public void buttonAction(ActionEvent actionEvent) {
        System.out.println("Buttun Action do Project");
    }
}
