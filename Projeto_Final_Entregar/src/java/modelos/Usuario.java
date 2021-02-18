/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import dados.Mock;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author AI-Dev1
 * * Tempo de dev: 5 min
 */
public class Usuario {
    private int id;    
    private String nome;
    private String email;
    private String senha;
    private String biografia;
    private int idade;
    private ArrayList<Projeto> projetos;  
    
    public static int lastId = 0;
    public static ArrayList<Usuario> dados = Mock.makeUsuarios();    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }  
    
    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(ArrayList<Projeto> projetos) {
        this.projetos = projetos;
    }        
    
}
