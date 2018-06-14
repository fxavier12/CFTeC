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
 * @author utfpr
 */
@ManagedBean
@RequestScoped
public class JsfPurpose {
    
    public JsfPurpose() {
    }
    
    private int codigo;
    private String nome;
    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String persist() {
        br.data.entity.Purpose pur;
        pur = new br.data.entity.Purpose();
        pur.setCodigo(codigo);
        pur.setNome(nome);
        pur.setDescricao(descricao);
        Exception insert = new br.data.crud.CrudPurpose().persist(pur);
        if (insert == null) {
            this.setCodigo(0);
            this.setNome("");
            this.setDescricao("");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Purpose", "adicionado!");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = insert.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
        
        return "/operacoes/index.xhtml";
    }

    public java.util.List<br.data.entity.Purpose> getAll() {
        return new br.data.crud.CrudPurpose().getAll();
    }

    public java.util.List<br.data.entity.Purpose> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudPurpose().SelectByNome(nome);
        } else {
            return null;
        }
    }

    public void remove(br.data.entity.Purpose purpose) {
        Exception e =new br.data.crud.CrudPurpose().remove(purpose);
         if (e == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Purpose", "excluído!");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String update(br.data.entity.Purpose purpose) {
        this.codigo = purpose.getCodigo();
        this.nome = purpose.getNome();
        this.descricao = purpose.getDescricao();
        return "merge.xhtml";
    }

    public String merge() {
        br.data.entity.Purpose pur;
        pur = new br.data.crud.CrudPurpose().find(this.codigo);
        pur.setNome(nome);
        pur.setDescricao(descricao);
        Exception e = new br.data.crud.CrudPurpose().merge(pur);
        if (e == null) {
            this.setCodigo(0);
            this.setNome("");
            this.setDescricao("");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Purpose", "modificado!");
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
