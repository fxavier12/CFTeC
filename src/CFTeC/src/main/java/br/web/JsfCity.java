/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import br.data.entity.Estado;
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
public class JsfCity {

    /**
     * Creates a new instance of JsfTeste
     */
    public JsfCity() {
    }

    private int codigo;
    private String nome;
    private Estado codigo_estado = new Estado();

    
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
    
     public Estado getCodigo_estado() {
        return codigo_estado;
    }

    public void setCodigo_estado(Estado codigo_estado) {
        this.codigo_estado = codigo_estado;
    }


    public String persist() {
        br.data.entity.City tes;
        tes = new br.data.entity.City();
        tes.setCodigo(codigo);
        tes.setNome(nome);
        
        tes.setCodigo_estado(codigo_estado);
        Exception insert = new br.data.crud.CrudCity().persist(tes);
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

    public java.util.List<br.data.entity.City> getAll() {
        return new br.data.crud.CrudCity().getAll();
    }

    public java.util.List<br.data.entity.City> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudCity().SelectByNome(nome);
        } else {
            return null;
        }
    }

    public void remove(br.data.entity.City teste) {
        Exception e =new br.data.crud.CrudCity().remove(teste);
         if (e == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro excluido com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String update(br.data.entity.City teste) {
        this.codigo = teste.getCodigo();
        this.nome = teste.getNome();
        this.codigo_estado = teste.getCodigo_estado();
        return "merge.xhtml";
    }

    public String merge() {
        br.data.entity.City tes;
        tes = new br.data.crud.CrudCity().find(this.codigo);
        tes.setNome(nome);
        Exception e = new br.data.crud.CrudCity().merge(tes);
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
        System.out.println("ola mundo ======================");
    }
}

