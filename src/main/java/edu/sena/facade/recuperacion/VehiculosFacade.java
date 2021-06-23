/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.recuperacion;

import edu.sena.entitty.recuperacion.Vehiculos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julian Paredes
 */
@Stateless
public class VehiculosFacade extends AbstractFacade<Vehiculos> implements VehiculosFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_recuperacion_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculosFacade() {
        super(Vehiculos.class);
    }
    
}
