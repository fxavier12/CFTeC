/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Collaborator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author alann
 */
public class CrudCollaborator extends AbstractCrud<br.data.entity.Collaborator> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudCollaborator() {
        super(br.data.entity.Collaborator.class);
    }

    public List<br.data.entity.Collaborator> SelectByNome(String nome) {
        List<br.data.entity.Collaborator> lista;
        try {
            lista = getEntityManager().createNamedQuery("Collaborator.findByNome").setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public br.data.entity.Collaborator SelectByCodAtivacao(String codativacao) {

        try {
            return (Collaborator) getEntityManager().createNamedQuery("Collaborator.findByCodAtivacao")
                    .setParameter("codativacao", codativacao).getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public br.data.entity.Collaborator SelectByCodigo(Integer codigo) {

        try {
            return (Collaborator) getEntityManager().createNamedQuery("Collaborator.findByCodigo")
                    .setParameter("codativacao", codigo).getSingleResult();

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

    public void Atualiza() {
        Query query = em.createQuery("UPDATE collaborator e SET e.collaborator_ativo  = true");
        int rowCount = query.executeUpdate();
    }
}
