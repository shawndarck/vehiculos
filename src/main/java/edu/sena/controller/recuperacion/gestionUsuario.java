/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.recuperacion;

import edu.sena.entitty.recuperacion.Usuario;
import edu.sena.facade.recuperacion.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Julian Paredes
 */
@Named(value = "gestionUsuario")
@SessionScoped
public class gestionUsuario implements Serializable {
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private Usuario usuReg = new Usuario();

    /**
     * Creates a new instance of gestionUsuario
     */
    public gestionUsuario() {
    }
    
    public void registrarUsuario(){
        usuarioFacadeLocal.registrarUsuario(usuReg);
    }

    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }

}
