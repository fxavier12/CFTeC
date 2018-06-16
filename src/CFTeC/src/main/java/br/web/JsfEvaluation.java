/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import br.data.entity.Collaborator;
import br.data.entity.Message;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author yoshi
 */
@ManagedBean
@RequestScoped
public class JsfEvaluation {

    public JsfEvaluation() {}
    
    private Integer codigo;
    private Collaborator codigo_collaborator;
    private Message codigo_message;
    private Date created_at;
    private float valor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Collaborator getCodigo_collaborator() {
        return codigo_collaborator;
    }

    public void setCodigo_collaborator(Collaborator codigo_collaborator) {
        this.codigo_collaborator = codigo_collaborator;
    }

    public Message getCodigo_message() {
        return codigo_message;
    }

    public void setCodigo_message(Message codigo_message) {
        this.codigo_message = codigo_message;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    public java.util.List<br.data.entity.Evaluation> getAll() {
        return new br.data.crud.CrudEvaluation().getAll();
    }
    
}
