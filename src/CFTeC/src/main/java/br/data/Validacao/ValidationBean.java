/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.Validacao;

import br.data.crud.CrudCollaborator;
import br.data.entity.Collaborator;
import br.web.JsfCollaborator;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

/**
 *
 * @author alann
 */
@ManagedBean
@RequestScoped
public class ValidationBean {

    Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().
            getRequestParameterMap();
    String parameterOne = params.get("p1");

    public String getP1() {
        String cod = params.get("p1");
        Collaborator colab = new CrudCollaborator().SelectByCodAtivacao(cod);
        
        
        if (colab != null) {
            colab.setCollaborator_ativo(true);
            return ("Cadastro Validado com sucesso ---- " + colab.getNome());

        }
        return ("erro na validação do cadastro");
    }

}
