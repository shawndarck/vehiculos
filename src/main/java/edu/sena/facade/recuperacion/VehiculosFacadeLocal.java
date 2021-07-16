/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.recuperacion;

import edu.sena.entitty.recuperacion.Vehiculos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Paredes
 */
@Local
public interface VehiculosFacadeLocal {

    void create(Vehiculos vehiculos);

    void edit(Vehiculos vehiculos);

    void remove(Vehiculos vehiculos);

    Vehiculos find(Object id);

    List<Vehiculos> findAll();

    List<Vehiculos> findRange(int[] range);

    int count();
   public List<Vehiculos> todosVehiculos();
    
}
