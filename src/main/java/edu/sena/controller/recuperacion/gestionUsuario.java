/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.recuperacion;

import edu.sena.entitty.recuperacion.Datospersonales;
import edu.sena.entitty.recuperacion.Usuario;
import edu.sena.entitty.recuperacion.Vehiculos;
import edu.sena.facade.recuperacion.CategoriaFacadeLocal;
import edu.sena.facade.recuperacion.DatospersonalesFacadeLocal;
import edu.sena.facade.recuperacion.UsuarioFacadeLocal;
import edu.sena.facade.recuperacion.VehiculosFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Julian Paredes
 */
@Named(value = "gestionUsuario")
@SessionScoped
public class gestionUsuario implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    @EJB
    DatospersonalesFacadeLocal datospersonalesFacadeLocal;
    @EJB
    VehiculosFacadeLocal vehiculosFacadeLocal;
    @EJB 
    CategoriaFacadeLocal categoriaFacadeLocal;

    private Usuario usuReg = new Usuario();
    private Usuario usuLog = new Usuario();
    private Datospersonales datosReg = new Datospersonales();
    private String mensajes = "";
    private String nombUsuIn = "";
    private String claveIn = "";

    /**
     * Creates a new instance of gestionUsuario
     */
    public gestionUsuario() {
        
    }
    
    
    public List<Vehiculos> todosVehiculos(){
    
    return vehiculosFacadeLocal.todosVehiculos();
    
    }

    public void registrarUsuario() {
        if (usuarioFacadeLocal.registrarUsuario(usuReg)) {
            mensajes = "RegistOK";
        } else {
            mensajes = "RegistBAD";
        }

        usuReg = new Usuario();

    }

    public void validarUsuario() throws IOException {
    usuLog = usuarioFacadeLocal.iniciarSesion(nombUsuIn, claveIn);
    if(usuLog == null){
        mensajes = "iniBAD";
    }else{
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().redirect("usuario/index_usu.xhtml");
    }
    
    }

    public void registrarDatos() {
       
        
        if (datospersonalesFacadeLocal.registrarDatos(datosReg)) {
            mensajes = "RegistOK";
        } else {
            mensajes = "RegistBAD";
        }

        datosReg = new Datospersonales();
        
        
    }
    

    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }

    public Datospersonales getDatosReg() {
        return datosReg;
    }

    public void setDatosReg(Datospersonales datosReg) {
        this.datosReg = datosReg;
    }

    public String getMensajes() {
        return mensajes;
    }

    public void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

    public Usuario getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(Usuario usuLog) {
        this.usuLog = usuLog;
    }

    public String getNombUsuIn() {
        return nombUsuIn;
    }

    public void setNombUsuIn(String nombUsuIn) {
        this.nombUsuIn = nombUsuIn;
    }

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }

}
