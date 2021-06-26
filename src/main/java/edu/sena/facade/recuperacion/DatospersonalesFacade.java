/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.recuperacion;

import edu.sena.entitty.recuperacion.Datospersonales;
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
public class DatospersonalesFacade extends AbstractFacade<Datospersonales> implements DatospersonalesFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_recuperacion_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatospersonalesFacade() {
        super(Datospersonales.class);
    }
    
    
    @Override
    public boolean registrarDatos(Datospersonales datosReg){
    
        try {
            
            Query qp = em.createNativeQuery("INSERT INTO datospersonales (idDatosPersonales, usuario_idUsuario, tipoDocumento, primer_nombre, segundo_nombre, primer_Apellido, segundo_Apellido, telefono, correo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            qp.setParameter(1, datosReg.getIdDatosPersonales());
             qp.setParameter(2, datosReg.getUsuarioidUsuario());
              qp.setParameter(3, datosReg.getTipoDocumento());
               qp.setParameter(4, datosReg.getPrimerNombre());
                qp.setParameter(5, datosReg.getSegundoNombre());
                 qp.setParameter(6, datosReg.getPrimerApellido());
                  qp.setParameter(7, datosReg.getSegundoApellido());
                   qp.setParameter(8, datosReg.getTelefono());
                    qp.setParameter(9, datosReg.getCorreo());
                    qp.executeUpdate();
                    return TRUE;
                    
                    
        } catch (Exception e) {
            
            System.out.println("ERROR ::registrarDatos -->"+e.getMessage());
            return FALSE;
        }
        
        
    }
    
}
