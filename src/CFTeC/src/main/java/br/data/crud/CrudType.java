/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author gabri
 */public class CrudType extends AbstractCrud<br.data.entity.Type> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudType() {
        super(br.data.entity.Type.class);
    }

    public List<br.data.entity.Type> SelectByDescricao(String descricao) {
        List<br.data.entity.Type> lista;
        try {
            lista= getEntityManager().createNamedQuery("Type.findByDescricao").setParameter("descricao", "%" + descricao.toUpperCase() + "%").getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }

}
