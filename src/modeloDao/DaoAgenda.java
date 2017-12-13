package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansAgenda;
import modeloConection.ConexaoDB;

/**
 *
 * @author Denis
 */
public class DaoAgenda {
    BeansAgenda agenda = new BeansAgenda();
    ConexaoDB conex = new ConexaoDB();
    ConexaoDB conexPaciente = new ConexaoDB();
    ConexaoDB conexMedico = new ConexaoDB();
    
    int idMed;
    int idPac;    

public void Salvar (BeansAgenda agenda){
BuscaMedico(agenda.getNomeMedico());
BuscaPaciente(agenda.getNomePaciente());
conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into agenda (agenda_idpaciente, agenda_idmedico, motivo, turno, agenda_data, status) values(?,?,?,?,?, ?)");
            pst.setInt(1,idPac);
            pst.setInt(2,idMed);
            pst.setString(3,agenda.getMotivo());
            pst.setString(4,agenda.getTurno());
            pst.setDate(5,new java.sql.Date(agenda.getData().getTime()));
            pst.setString(6,agenda.getStatus());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Agendamento Salvo com Sucesso");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao Salvar Agendamento" + ex);
        }
//conex.desconecta();
}

public void BuscaMedico(String nomeMedico){
conexMedico.getConnection();
conexMedico.executaSql("select *from medicos where nome_medico='"+nomeMedico+"'");
        try {
            conexMedico.rs.first();
            idMed = conexMedico.rs.getInt("id_medico");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico não Encontrado!");
        }
}

public int BuscaIDMedico(String nomeMedico){
conexMedico.getConnection();
conexMedico.executaSql("select *from medicos where nome_medico='"+nomeMedico+"'");
        try {
            conexMedico.rs.first();
            idMed = conexMedico.rs.getInt("id_medico");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico não Encontrado!");
        }
        return idMed;
}

public void BuscaPaciente(String nomePaciente){
conexPaciente.getConnection();
conexPaciente.executaSql("select *from pacientes where nome_paciente='"+nomePaciente+"'");
        try {
            conexPaciente.rs.first();
            idPac=conexPaciente.rs.getInt("id_paciente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico não Encontrado!");
        }
}

public void Alterar(BeansAgenda agenda){
    conex.getConnection();
    try {
            PreparedStatement pst = conex.con.prepareStatement("update agenda set status=? where id_agenda=?");
            pst.setString(1,agenda.getStatus());
            pst.setInt(2,agenda.getAgendaId());
            
            pst.execute(); 
            JOptionPane.showMessageDialog(null,"Agendamento em Atendimento!");
            
         }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Efetuar Agendamento /n Erro: " + ex);
        }
         conex.desconecta();
}
public void BuscaAgendamento(BeansAgenda agenda){
    conexMedico.getConnection();
    conexMedico.executaSql("select * from agenda where agenda_data = '" +agenda.getData()+"' ");
    try{
        conexMedico.rs.first();
        idMed = conexMedico.rs.getInt("id_medico");
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Agendamento não encontrado!");
    }
}

public BeansAgenda BuscaAgendaPorCodigo(int cod){
    BeansAgenda agen = new BeansAgenda();
    

    conex.getConnection();
    conex.executaSql(" select * from agenda inner join pacientes on agenda_idpaciente = id_paciente inner join medicos on agenda_idmedico = id_medico where id_agenda = '"+cod+"' ");
    try{
        conex.rs.first();
        agen.setNomePaciente(conex.rs.getString("nome_paciente"));
        agen.setNomeMedico(conex.rs.getString("nome_medico"));
        agen.setMotivo(conex.rs.getString("motivo"));
        agen.setNascimento(conex.rs.getString("nasc_paciente"));
        
        
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro ao Buscar pelo Código!"+ex);
    }
    return agen;
}
}