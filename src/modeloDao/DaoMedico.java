//O controle é responsável por inserir e salvar os dados no Formulário ModeloMedicos
package modeloDao;

import modeloConection.ConexaoDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansMedico;


public class DaoMedico {
    
    
    ConexaoDB conex  = new ConexaoDB();
    BeansMedico mod = new BeansMedico();
   
    public void Salvar(BeansMedico mod){ //Salvar no banco de Dados
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos"
                    + "(nome_medico,especialidade,crm,telefone) values (?,?,?, ?)");
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getEspecialidade());
            pst.setInt(3,mod.getCrm());
            pst.setString(4,mod.getTelefone());
            pst.execute(); 
            JOptionPane.showMessageDialog(null,"Dados Inseridos com Sucesso!");
         }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Falha ao Salvar Dados! /n Erro: " + ex);
        }
         //conex.desconecta();
    }
    public void Editar (BeansMedico  mod){
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update medicos set nome_medico=?, especialidade=?, "
                    + "crm=?, telefone=? where id_medico=?");
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getEspecialidade());
            pst.setInt(3,mod.getCrm());
            pst.setString(4,mod.getTelefone());
            pst.setInt(5,mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Alteração dos Dados! \n Erro: " + ex);
        }
        //conex.desconecta();
        }
    
    public void Excluir(BeansMedico mod){   
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement(" delete from medicos where id_medico=?");
            pst.setInt(1,mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Registo Excluído com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Exclusão do Registo! \n Erro: " + ex);
        }
        
        
        //conex.desconecta();
        
        }
    
    public BeansMedico buscaMedico(BeansMedico mod){ //Pesquisar no Banco de Dados 
        conex.getConnection();
        conex.executaSql(" select * from medicos where nome_medico ilike '%" + mod.getPesquisa()+ "%'");
        
        try {conex.rs.first();
         
            mod.setCodigo(conex.rs.getInt("id_medico"));
            mod.setNome(conex.rs.getString("nome_medico"));
            mod.setEspecialidade(conex.rs.getString("especialidade"));
            mod.setCrm(conex.rs.getInt("crm"));
            mod.setTelefone(conex.rs.getString("telefone"));
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Médico não Cadastrado!");
               
       }
        //conex.desconecta(); 
        return mod;
    }
}