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
public class CrudArtifact extends AbstractCrud<br.data.entity.Artifact> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudArtifact() {
        super(br.data.entity.Artifact.class);
    }

    public List<br.data.entity.Artifact> SelectByNome(String nome) {
        List<br.data.entity.Artifact> lista;
        try {
            lista= getEntityManager().createNamedQuery("Artifact.findByNome").setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
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
