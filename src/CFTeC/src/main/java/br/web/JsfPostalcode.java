/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import br.data.entity.City;
import br.data.entity.Type;
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
public class JsfPostalcode {

    /**
     * Creates a new instance of JsfTeste
     */
    public JsfPostalcode() {
    }

    private int codigo;
    private String codigo_postal;
    private City codigo_city = new City();
    private Type codigo_type = new Type();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
    

    public String persist() {
        br.data.entity.Postalcode tes;
        tes = new br.data.entity.Postalcode();
        tes.setCodigo(codigo);
        tes.setCodigo_postal(codigo_postal);
        Exception insert = new br.data.crud.CrudPostalcode().persist(tes);
        if (insert == null) {
            this.setCodigo(0);
            this.setCodigo_postal("");
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

    public java.util.List<br.data.entity.Postalcode> getAll() {
        return new br.data.crud.CrudPostalcode().getAll();
    }

    public java.util.List<br.data.entity.Postalcode> getSelect() {
        if (this.codigo_postal != null && !this.codigo_postal.equals("")) {
            return new br.data.crud.CrudPostalcode().SelectByCodigoPostal(codigo_postal);
        } else {
            return null;
        }
    }

    public void remove(br.data.entity.Postalcode teste) {
        Exception e =new br.data.crud.CrudPostalcode().remove(teste);
         if (e == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro excluido com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String update(br.data.entity.Postalcode teste) {
        this.codigo = teste.getCodigo();
        this.codigo_postal = teste.getCodigo_postal();
        return "merge.xhtml";
    }

    public String merge() {
        br.data.entity.Postalcode tes;
        tes = new br.data.crud.CrudPostalcode().find(this.codigo);
        tes.setCodigo_postal(codigo_postal);
        Exception e = new br.data.crud.CrudPostalcode().merge(tes);
        if (e == null) {
            this.setCodigo(0);
            this.setCodigo_postal(codigo_postal);
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
