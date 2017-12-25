/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansPaciente;
import modeloConection.ConexaoDB;


public class DaoPaciente {

    ConexaoDB conex  = new ConexaoDB();
    BeansPaciente mod = new BeansPaciente(); 
    ConexaoDB conexBairro = new ConexaoDB();
 
       
    

 public void Salvar(BeansPaciente mod){ //Salvar no banco de Dados
     
     conex.getConnection();
       
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into pacientes"
                    + "(nome_paciente,"
                    + "nasc_paciente,"
                    + "rg_paciente, "
                    + "telefone, "
                    + "rua_paciente, "
                    + "cep_paciente, "
                    + "complemento, "
                    + "bairro_paciente,"
                    + "cpf_paciente, "
                    + "numero,"
                    + "cidade_paciente,"
                    + "estado_paciente,"
                    + "celular_paciente) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getNome_paciente());
            pst.setString(2,mod.getNasc_paciente());
            pst.setString(3,mod.getRg());
            pst.setString(4,mod.getTelefone());
            pst.setString(5,mod.getRua());
            pst.setString(6,mod.getCep());
            pst.setString(7,mod.getComplemento());
            pst.setString(8,mod.getBairro());
            pst.setString(9,mod.getCpf());
            pst.setInt(10,mod.getNumero());
            pst.setString(11,mod.getCidade());
            pst.setString(12,mod.getEstado());
            pst.setString(13,mod.getCelular());
            
            pst.execute(); 
            JOptionPane.showMessageDialog(null,"Paciente Cadastrado com Sucesso!");
            
         }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Falha ao Salvar Paciente! \n Erro: " + ex);
        }
         //conex.desconecta();
}


public void Editar(BeansPaciente mod){ //Salvar no banco de Dados
     conex.getConnection();
       
        try {
            PreparedStatement pst = conex.con.prepareStatement("update pacientes set nome_paciente=?,"
                    + " nasc_paciente=?,"
                    + " rg_paciente=?, "
                    + "telefone=?, "
                    + "rua_paciente=?, "
                    + "cep_paciente=?, "
                    + "complemento=?, "
                    + "bairro_paciente=?"
                    + "cpf_paciente=?,"
                    + "numero=?,"
                    +"cidade_paciente=?,"
                    +"estado_paciente=?,"
                    +"celular_paciente=?," 
                    + "where id_paciente=?");
            
            pst.setString(1,mod.getNome_paciente());
            pst.setString(2,mod.getNasc_paciente());
            pst.setString(3,mod.getRg());
            pst.setString(4,mod.getTelefone());
            pst.setString(5,mod.getRua());
            pst.setString(6,mod.getCep());
            pst.setString(7,mod.getComplemento());
            pst.setString(8,mod.getBairro());
            pst.setString(9,mod.getCpf());
            pst.setInt(10,mod.getNumero());
            pst.setString(11,mod.getCidade());
            pst.setString(12,mod.getEstado());
            pst.setString(13,mod.getCelular());
            
            pst.setInt(14,mod.getId_paciente());
            pst.execute(); 
            JOptionPane.showMessageDialog(null,"Paciente Alterado com Sucesso!");
            
         }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Alterar Paciente! \n Erro: " + ex);
        }
         //conex.desconecta();
}
public BeansPaciente  buscaPaciente (BeansPaciente mod){
    conex.getConnection();
        conex.executaSql(" select * from pacientes where nome_paciente  ilike '%" + mod.getPesquisa()+ "%'" );
        try {
            
            conex.rs.first();
            mod.setNome_paciente(conex.rs.getString("nome_paciente"));
            mod.setNasc_paciente(conex.rs.getString("nasc_paciente"));
            mod.setRg(conex.rs.getString("rg_paciente"));
            mod.setTelefone(conex.rs.getString("telefone"));
            mod.setRua(conex.rs.getString("rua_paciente"));
            mod.setCep(conex.rs.getString("cep_paciente"));
            mod.setComplemento(conex.rs.getString("complemento"));
            mod.setBairro(conex.rs.getString("bairro_paciente"));
            mod.setCpf(conex.rs.getString("cpf_paciente"));
            mod.setNumero(conex.rs.getInt("numero"));
            mod.setCidade(conex.rs.getString("cidade_paciente"));
            mod.setEstado(conex.rs.getString("estado_paciente"));
            mod.setCelular(conex.rs.getString("celular_paciente"));
            mod.setId_paciente(conex.rs.getInt("id_paciente"));
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Buscar Paciente! \n Erro: Talvez não existem Pacientes com esse Nome ");
            ex.printStackTrace();
        }
            return mod;
              
 
}

    public void Excluir(BeansPaciente mod){   
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement(" delete from pacientes where id_paciente=?");
            pst.setInt(1,mod.getId_paciente());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Registo Excluído com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Exclusão do Registo! \n Erro: " + ex);
        }
        
        
        //conex.desconecta();
        
        }}