/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Evaluation;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author yoshi
 */
public class CrudEvaluation extends AbstractCrud<br.data.entity.Evaluation> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;
    
    public CrudEvaluation() {
        super(br.data.entity.Evaluation.class);
    }

    public br.data.entity.Evaluation SelectByCodigo(Integer codigo) {

        try {
            return (Evaluation) getEntityManager()
                    .createNamedQuery("Evaluation.findByCodigo")
                    .setParameter("codigo", codigo).getSingleResult();

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
