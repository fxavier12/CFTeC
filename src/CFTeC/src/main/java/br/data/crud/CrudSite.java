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
 * @author alexandrelerario
 */
public class CrudSite extends AbstractCrud<br.data.entity.Site> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudSite() {
        super(br.data.entity.Site.class);
    }

    public List<br.data.entity.Teste> SelectByNome(String nome) {
        List<br.data.entity.Teste> lista;
        try {
            lista= getEntityManager().createNamedQuery("Teste.findByNome").setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
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
