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
 * @author gabri
 */
@ManagedBean
@RequestScoped
public class JsfType {

    /**
     * Creates a new instance of JsfTeste
     */
    public JsfType() {
    }

    private int codigo;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String persist() {
        br.data.entity.Type tes;
        tes = new br.data.entity.Type();
        tes.setCodigo(codigo);
        tes.setDescricao(descricao);
        Exception insert = new br.data.crud.CrudType().persist(tes);
        if (insert == null) {
            this.setCodigo(0);
            this.setDescricao("");
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

    public java.util.List<br.data.entity.Type> getAll() {
        return new br.data.crud.CrudType().getAll();
    }

    public java.util.List<br.data.entity.Type> getSelect() {
        if (this.descricao != null && !this.descricao.equals("")) {
            return new br.data.crud.CrudType().SelectByDescricao(descricao);
        } else {
            return null;
        }
    }

    public void remove(br.data.entity.Type type) {
        Exception e =new br.data.crud.CrudType().remove(type);
         if (e == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro excluido com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String update(br.data.entity.Type type) {
        this.codigo = type.getCodigo();
        this.descricao = type.getDescricao();
        return "merge.xhtml";
    }

    public String merge() {
        br.data.entity.Type tes;
        tes = new br.data.crud.CrudType().find(this.codigo);
        tes.setDescricao(descricao);
        Exception e = new br.data.crud.CrudType().merge(tes);
        if (e == null) {
            this.setCodigo(0);
            this.setDescricao("");
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
        System.out.println("ola mundo ======================");
    }
}
