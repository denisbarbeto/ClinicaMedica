/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Date;
import java.util.Calendar;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansAgenda;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoDB;
import modeloDao.DaoAgenda;

/**
 *
 * @author Denis
 */
public class FormAgendaDia extends javax.swing.JFrame {
    ConexaoDB conex = new ConexaoDB();
    BeansAgenda agenda = new BeansAgenda();
    BeansAgenda agen = new BeansAgenda();
    DaoAgenda daoAgenda = new DaoAgenda();
    
    String dtHoje;
    String status;    
    /**
     * Creates new form FormAgendamento
     */
    public FormAgendaDia() {
        initComponents();
        
        
         URL caminhoIcone = getClass().getResource("/Imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        
        Calendar data =  Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.format(d);
        
        dtHoje = dateFormat.format(d);
        status = "Aberto";
        
        preencherTabela("select * from agenda inner join pacientes on agenda_idpaciente = id_paciente "
                + "inner join medicos on agenda_idmedico = id_medico where agenda_data = '"+ dtHoje +"' and status = '"+ status +"' order by turno");
     }
    
    
    public void preencherTabela(String Sql){
    ArrayList dados = new ArrayList();
    String [] colunas = new String[]{"ID","Nome","Turno","Data","Status","Médico"};
    conex.getConnection();
    conex.executaSql(Sql);
    try{
    conex.rs.first(); 
    do{
       
        dados.add(new Object[]{conex.rs.getInt("id_agenda"),conex.rs.getString("nome_paciente"),
            conex.rs.getString("turno"),conex.rs.getString("agenda_data"),conex.rs.getString("status"),
            conex.rs.getString("nome_medico")});
     
    }while(conex.rs.next());
        
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, " Não existem Agendamentos para Hoje!");
        
        
           
    }ModeloTabela modelo = new ModeloTabela(dados,colunas);
    jTableAgenda.setModel(modelo);
    jTableAgenda.getColumnModel().getColumn(0).setPreferredWidth(83);
    jTableAgenda.getColumnModel().getColumn(0).setResizable(false);
    jTableAgenda.getColumnModel().getColumn(1).setPreferredWidth(302);
    jTableAgenda.getColumnModel().getColumn(1).setResizable(false);
    jTableAgenda.getColumnModel().getColumn(2).setPreferredWidth(92);
    jTableAgenda.getColumnModel().getColumn(2).setResizable(false);
    jTableAgenda.getColumnModel().getColumn(3).setPreferredWidth(102);
    jTableAgenda.getColumnModel().getColumn(3).setResizable(false);
    jTableAgenda.getColumnModel().getColumn(4).setPreferredWidth(102);
    jTableAgenda.getColumnModel().getColumn(4).setResizable(false);
    jTableAgenda.getColumnModel().getColumn(5).setPreferredWidth(302);
    jTableAgenda.getColumnModel().getColumn(5).setResizable(false);
    jTableAgenda.getTableHeader().setReorderingAllowed(false);
    jTableAgenda.setAutoResizeMode(jTableAgenda.AUTO_RESIZE_OFF);
    jTableAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //conex.desconecta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgenda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButtonAtender = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgenda);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Agenda de Hoje");

        jButtonAtender.setText("Atender Agendamento");
        jButtonAtender.setEnabled(false);
        jButtonAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jButtonAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAtender)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Agenda do Dia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1011, 394));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendaMouseClicked
        // Esse Método funcionará ao Clicar na tabela
        String id_agenda  = "" + jTableAgenda.getValueAt(jTableAgenda.getSelectedRow(),0);
        conex.getConnection();
        conex.executaSql("select * from agenda where id_agenda= ' "+ id_agenda +" '");
        try {
            conex.rs.first();
            agen.setStatus("Atendimento");
            agen.setAgendaId(conex.rs.getInt("id_agenda"));
            jButtonAtender.setEnabled(true);
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao Selecionar Dados"+e);
        }
    }//GEN-LAST:event_jTableAgendaMouseClicked

    private void jButtonAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtenderActionPerformed
        // Esse método muda o Status do atendimento no Banco de Dados
        daoAgenda.Alterar(agen);
        
         preencherTabela(" select * from agenda inner join pacientes on agenda_idpaciente = id_paciente inner join medicos on agenda_idmedico = id_medico where agenda_data = '"+ dtHoje +"' and status = '"+ status +"' order by turno");
    }//GEN-LAST:event_jButtonAtenderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormAgendaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendaDia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgenda;
    // End of variables declaration//GEN-END:variables
}
