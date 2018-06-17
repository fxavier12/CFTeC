/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templacolab
 * and open the template in the editor.
 */
package br.web;

import br.data.Validacao.JavaMailApp;
import br.data.Validacao.RandomString;
import java.util.concurrent.ThreadLocalRandom;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author alann
 */
@ManagedBean
@RequestScoped
public class JsfCollaborator {

    public JsfCollaborator() {

    }

    private int codigo;
    private String nome;
    private String email;
    private String data_nascimento;
    private String codativacao;
    private boolean collaborator_ativo;

    public boolean isCollaborator_ativo() {
        return collaborator_ativo;
    }

    public void setCollaborator_ativo(boolean collaborator_ativo) {
        this.collaborator_ativo = collaborator_ativo;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getCodativacao() {
        return codativacao;
    }

    public void setCodativacao(String codativacao) {
        this.codativacao = codativacao;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String persist() {
        br.data.entity.Collaborator colab;
        colab = new br.data.entity.Collaborator();
        colab.setCodigo(codigo);
        colab.setNome(nome);
        colab.setEmail(email);
        colab.setData_nascimento(data_nascimento);
        RandomString cod = new RandomString(8, ThreadLocalRandom.current());
        colab.setCodativacao(cod.nextString());
        Exception insert = new br.data.crud.CrudCollaborator().persist(colab);
        colab.setCollaborator_ativo(false);
        if (insert == null) {
            this.setCodigo(0);
            this.setCollaborator_ativo(true);
            this.setNome("");
            this.setEmail("");
            this.setData_nascimento("");
            this.setCodativacao(cod.nextString());
            JavaMailApp email = new JavaMailApp();
            email.sendMail(colab.getEmail(), colab.getCodativacao());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro adicionado com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = insert.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }

        return "/index.xhtml";
    }

    public java.util.List<br.data.entity.Collaborator> getAll() {
        return new br.data.crud.CrudCollaborator().getAll();
    }

    public java.util.List<br.data.entity.Collaborator> getSelect() {
        if (this.nome != null && !this.nome.equals("")) {
            return new br.data.crud.CrudCollaborator().SelectByNome(nome);
        } else {
            return null;
        }
    }

    public void remove(br.data.entity.Collaborator colab) {
        Exception e = new br.data.crud.CrudCollaborator().remove(colab);
        if (e == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!!", "Registro excluido com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String update(br.data.entity.Collaborator colab) {
        this.codigo = colab.getCodigo();
        this.nome = colab.getNome();
        this.email = colab.getEmail();
        this.data_nascimento = colab.getData_nascimento();
        this.collaborator_ativo = true;
        return "mergeCrudColaborador.xhtml";
    }
     
    

    public String merge() {
        br.data.entity.Collaborator colab;
        colab = new br.data.crud.CrudCollaborator().find(this.codigo);
        colab.setNome(nome);
        colab.setEmail(email);
        colab.setData_nascimento(data_nascimento);
        Exception e = new br.data.crud.CrudCollaborator().merge(colab);
        if (e == null) {
            this.setCodigo(0);
            this.setNome("");
            this.setEmail("");
            this.setData_nascimento("");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Collaborator", "modificado!");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "/index.xhtml";
    }

}
