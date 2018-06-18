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
 * @author Diego Vilella Rodrigues
 */
@ManagedBean
@ViewScoped
public class JsfSiteView {

    /**
     * Creates a new instance of JsfSiteView
     */
    public JsfSiteView() {
    }

    private int codigo;
    private String nome;
    private int codigoProject;

    public int getCodigoProject() {
        return codigoProject;
    }

    public void setCodigoProject(int codigoProject) {
        this.codigoProject = codigoProject;
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

    public java.util.List<br.data.entity.Site> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudSite().SelectByNome(nome);
        } else {
            return null;
        }
    }

  
}
