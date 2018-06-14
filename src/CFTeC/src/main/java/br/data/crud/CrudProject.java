/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Project_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Vilella Rodrigues
 */
public class CrudProject extends AbstractCrud<br.data.entity.Project> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudProject() {
        super(br.data.entity.Project.class);
    }

    public List<br.data.entity.Project> SelectByNome(String nome) {
        List<br.data.entity.Project> lista;
        try { 
            lista= getEntityManager().createNamedQuery("Project.findByNome").setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
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
