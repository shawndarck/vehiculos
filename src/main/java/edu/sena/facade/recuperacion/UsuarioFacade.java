/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.recuperacion;

import edu.sena.entitty.recuperacion.Usuario;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Julian Paredes
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_recuperacion_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    
    
    @Override
    public boolean registrarUsuario(Usuario usuReg){
    
        try {
            Query q = em.createNativeQuery("INSERT INTO usuario (idUsuario, nombreUsuario, password) VALUES (?, ?, ?);");
            q.setParameter(1, usuReg.getIdUsuario());
            q.setParameter(2, usuReg.getNombreUsuario());
            q.setParameter(3, usuReg.getPassword());
            q.executeUpdate();
            return TRUE;
        } catch (Exception e) {
            System.out.println("ERROR ::registrarUsuario -->"+e.getMessage());
            return FALSE;
        }
    
    }
    
    
    
}
