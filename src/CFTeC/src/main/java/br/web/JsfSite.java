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
 * @author alexandrelerario
 */
@ManagedBean
@RequestScoped
public class JsfSite {

    /**
     * Creates a new instance of JsfSite
     */
    public JsfSite() {
    }

    private int codigo;
    private int codigoProject;   
    private String nome;
    private String posicaoGeo;

    public String getPosicaoGeo() {
        return posicaoGeo;
    }

    public void setPosicaoGeo(String posicaoGeo) {
        this.posicaoGeo = posicaoGeo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    private String observacao;

    public int getCodigo() {
        return codigo;
    }
    
     public int getCodigoProject() {
        return codigoProject;
    }

    public void setCodigoProject(int codigoProject) {
        this.codigoProject = codigoProject;
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
        br.data.entity.Site site;
        site = new br.data.entity.Site();
        site.setCodigo(codigo);
        site.setCodigoProject(codigoProject);
        site.setNome(nome);
        site.setPosicaoGeo(posicaoGeo);
        site.setObservacao(observacao);
        Exception insert = new br.data.crud.CrudSite().persist(site);
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

    public java.util.List<br.data.entity.Site> getAll() {
        return new br.data.crud.CrudSite().getAll();
    }

    public java.util.List<br.data.entity.Site> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudSite().SelectByNome(nome);
        } else {
            return null;
        }
    }

    public void remove(br.data.entity.Site site) {
        Exception e =new br.data.crud.CrudSite().remove(site);
         if (e == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro excluido com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String update(br.data.entity.Site site) {
        this.codigo = site.getCodigo();
        this.codigoProject = site.getCodigoProject();
        this.nome = site.getNome();
        this.posicaoGeo = site.getPosicaoGeo();
        this.observacao = site.getObservacao();
        return "merge.xhtml";
    }

    public String merge() {
        br.data.entity.Site tes;
        tes = new br.data.crud.CrudSite().find(this.codigo);
        tes.setNome(nome);
        Exception e = new br.data.crud.CrudSite().merge(tes);
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
