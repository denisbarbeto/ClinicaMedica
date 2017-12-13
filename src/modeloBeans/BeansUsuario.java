/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;


public class BeansUsuario {
    private Integer userID;
    private String userNome;
    private String userTipo;
    private String userSenha;
    private String userPesquisa;

    public String getUserPesquisa() {
        return userPesquisa;
    }

    public void setUserPesquisa(String userPesquisa) {
        this.userPesquisa = userPesquisa;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public String getUserTipo() {
        return userTipo;
    }

    public void setUserTipo(String userTipo) {
        this.userTipo = userTipo;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

   
}
