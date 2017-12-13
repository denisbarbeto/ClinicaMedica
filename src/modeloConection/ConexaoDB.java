package modeloConection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoDB { 

    
   
    //Variáveis para conexão entre o DataBase!
    
    //Utilizado para fazer a pesquisa no banco de DB
    public Statement stm; 
    //Armazenar o resultado dessa pesquisa
    public ResultSet rs; 
    //Responsável pela conexão com DB
    public static Connection con; 

   
    //Identifica o Serviço no caso PostgreSQL
    private static final String driver = "org.postgresql.Driver";  
    //Caminho onde se encontra o DB
    private static final String caminho = "jdbc:postgresql://localhost:5432/clinica"; 
     //Usuario do DB
    private static final String usuario = "postgres";
    //Senha do DB
    private static final String senha ="h@ck3rd3d3";         
    
    public static Connection getConnection(){ //Método para conexão com o Banco de Dados
        
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null,"Conexão Bem Sucedida");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se Conectar: \n" + ex.getMessage());
        }
         return con;
    }

    public void executaSql(String sql){//Método de pesquisa no DB
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao executar comando SQL: \n " + ex.getMessage());
        }
    }
    
    public void desconecta(){ //Método para desconexão com o Banco de Dados
        try {
            con.close();
            //JOptionPane.showMessageDialog(null,"Banco de Dados Desconectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Desconectar Banco de Dado \n" + ex.getMessage());
        }
    }

    
    
}
