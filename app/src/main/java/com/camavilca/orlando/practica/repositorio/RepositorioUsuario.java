package com.camavilca.orlando.practica.repositorio;

import com.camavilca.orlando.practica.modelo.Usuario;
import com.orm.SugarRecord;

import java.util.List;

public class RepositorioUsuario {

    public static Boolean inicioSesion(String usuario,String contraseña){
        List<Usuario> users = SugarRecord.listAll(Usuario.class);
        for (Usuario user :
                users) {
            if(user.getUsuario().equalsIgnoreCase(usuario) && user.getContraseña().equals(contraseña)){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
    public static Usuario read(Long id){
        Usuario user = SugarRecord.findById(Usuario.class, id);
        return user;
    }
    public static void create(String usuario,String nombre,String correo, String contraseña){
        Usuario user = new Usuario(usuario,nombre,correo,contraseña);
        SugarRecord.save(user);
    }
}
