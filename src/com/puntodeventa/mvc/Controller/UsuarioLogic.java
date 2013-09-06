/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.services.DAO.UsuarioDAO;
import java.util.List;

/**
 *
 * @author USER
 */
public class UsuarioLogic {

    static UsuarioDAO usuarioDAO = new UsuarioDAO();
    LogHelper objLog = new LogHelper("UsuarioLogic");

    public Usuario getUsuario(String user, String pwd) {
        Usuario usuario;

        usuario = usuarioDAO.selectUsuario(111);

        return usuario;
    }

    public Usuario logonUsuario(String user, String pwd) {
        Usuario usuario = null;
        try {
            List<Usuario> usuarios = usuarioDAO.logonUsuario(user, pwd);

            if (usuarios.size() > 0) {
                usuario = usuarios.get(0);
            }

        } catch (Exception e) {
            objLog.Log(e.getMessage());
        }
        return usuario;
    }
    
    public Usuario getUser(int idUsuario){
        Usuario user;
        user = usuarioDAO.selectUsuario(idUsuario);
        return user;
    }
    
    public List<Usuario> getByCveUser(String cve_usuario){
        List<Usuario> listUser;
        listUser = usuarioDAO.selectByCveUser(cve_usuario);
        return listUser;
    }
    
    public void updateUser(Usuario usuario){
        usuarioDAO.updateUsuario(usuario);
    }
    
    public int saveUser(Usuario usuario){
        int IdUser;
        IdUser = usuarioDAO.saveUsuario(usuario);
        return IdUser;
    }
    
    public void saveUpdateUsuario(Usuario usuario) {
        usuarioDAO.saveUpdateUsuario(usuario);
    }
    
    public Usuario getUserSerializable() {
        Usuario usuario;
        usuario = Util.getCurrentUser();
        return usuario;
    }
    
    public String getAcceso(String user, String pass, String codPOS){
        String codePOS;
        codePOS = usuarioDAO.getAcceso(user, pass, codPOS);
        return codePOS;
    }
    
    public void alterUserdb(String user, String pass){
        usuarioDAO.alterUserdb(user, pass);
    }
       
}