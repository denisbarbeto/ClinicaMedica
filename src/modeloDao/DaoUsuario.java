/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansMedico;
import modeloBeans.BeansUsuario;
import modeloConection.ConexaoDB;



public class DaoUsuario {
    ConexaoDB conex  = new ConexaoDB();
    BeansUsuario mod = new BeansUsuario();
    
    //Método de Salvar Usuario
    public void Salvar(BeansUsuario mod){ //Salvar no banco de Dados
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into usuarios"
                    + "(nome_usuario,senha_usuario,tipo) values (?,?,?)");
            pst.setString(1,mod.getUserNome());
            pst.setString(2,mod.getUserSenha());
            pst.setString(3,mod.getUserTipo());
            
            pst.execute(); 
            JOptionPane.showMessageDialog(null,"Usuário Cadastrado com Sucesso!");
         }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Falha ao Salvar Usuário! \n Erro: " + ex);
        }
         //conex.desconecta();
    
}
    //Método de Editar Usuario
    public void Alterar (BeansUsuario  mod){//Editar no Banco de Dados
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update usuarios set nome_usuario=?, senha_usuario=?, "
                    + "tipo=? where id_usuario=? ");
            
            pst.setString(1,mod.getUserNome());
            pst.setString(2,mod.getUserSenha());
            pst.setString(3,mod.getUserTipo());
            pst.setInt(4,mod.getUserID());
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Alteração dos Dados! \n Erro: " + ex);
        }
        //conex.desconecta();
        }
    //Método de Exclusão de Usuários
    public void Excluir(BeansUsuario mod){   
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement(" delete from usuarios where id_usuario= ?");
            pst.setInt(1,mod.getUserID());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Registo Excluído com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Exclusão do Registo! \n Erro: " + ex);
        }
        //conex.desconecta();
        }
    //Método de Pesquisa de Usuario
    public BeansUsuario buscaUsuario(BeansUsuario mod){ //Pesquisar no Banco de Dados 
        conex.getConnection();
        conex.executaSql("select * from usuarios where nome_usuario ilike'%" + mod.getUserPesquisa()+ "%'");
        
        try {conex.rs.first();
        
            mod.setUserID(conex.rs.getInt("id_usuario"));
            mod.setUserNome(conex.rs.getString("nome_usuario"));
            mod.setUserSenha(conex.rs.getString("senha_usuario"));
            mod.setUserTipo(conex.rs.getString("tipo"));
            
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Usuário não Cadastrado!");
        return null;   
       }
        //conex.desconecta(); 
        return mod;
    }
}
