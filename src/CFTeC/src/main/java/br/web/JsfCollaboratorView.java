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
 * @author alann
 */
@ManagedBean
@ViewScoped
public class JsfCollaboratorView {

    public JsfCollaboratorView() {
    }
    private int codigo;
    private String nome;
    private String email;
    private String data_nascimento;
    private String codativacao;
    private boolean collaborator_ativo;

    public String getCodativacao() {
        return codativacao;
    }

    public void setCodativacao(String codativacao) {
        this.codativacao = codativacao;
    }

    public boolean isCollaborator_ativo() {
        return collaborator_ativo;
    }

    public void setCollaborator_ativo(boolean collaborator_ativo) {
        this.collaborator_ativo = collaborator_ativo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.util.List<br.data.entity.Collaborator> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudCollaborator().SelectByNome(nome);
        } else {
            return null;
        }
    }
   

    public br.data.entity.Collaborator getCollaborator() {
        if (this.codativacao != null && !this.codativacao.equals("")) {
            return new br.data.crud.CrudCollaborator().SelectByCodAtivacao(codativacao);
        } else {
            return null;
        }
    }

}
