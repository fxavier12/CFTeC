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
 */
public class CrudPostalcode extends AbstractCrud<br.data.entity.Postalcode> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudPostalcode() {
        super(br.data.entity.Postalcode.class);
    }

    public List<br.data.entity.Postalcode> SelectByCodigoPostal(String nome) {
        List<br.data.entity.Postalcode> lista;
        try {
            lista= getEntityManager().createNamedQuery("Teste.findByCodigoPostal").setParameter("codigo_postal", "%" + nome.toUpperCase() + "%").getResultList();
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

