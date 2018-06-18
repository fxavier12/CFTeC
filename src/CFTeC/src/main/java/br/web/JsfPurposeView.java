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
 * @author utfpr
 */

@ManagedBean
@ViewScoped
public class JsfPurposeView {
    
    public JsfPurposeView() {
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
    
    
    public java.util.List<br.data.entity.Purpose> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudPurpose().SelectByNome(nome);
        } else {
            return null;
        }
    }
}
