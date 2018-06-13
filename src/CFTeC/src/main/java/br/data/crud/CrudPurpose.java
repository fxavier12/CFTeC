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
 * @author utfpr
 */
public class CrudPurpose extends AbstractCrud<br.data.entity.Purpose> {
    
        private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudPurpose() {
        super(br.data.entity.Purpose.class);
    }

    public List<br.data.entity.Purpose> SelectByNome(String nome) {
        List<br.data.entity.Purpose> lista;
        try {
            lista= getEntityManager().createNamedQuery("Purpose.findByNome").setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
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
