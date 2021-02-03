/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrojogojava;

import java.io.Serializable;

/**
 *
 * @author PREDATOR
 */
public class Usuario implements Serializable {
    
    int id;
    String username;
    String senha;
    int perfil;
    int carteira;
    
    public Usuario() {
    }

    
    public Usuario(int id, String username, String senha, int perfil) {
        this.username = username;
        this.senha = senha;
        this.perfil = perfil;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCarteira() {
        return carteira;
    }

    public void setCarteira(int carteira) {
        this.carteira = carteira;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    
    
    
}
