/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoDB;
import modeloDao.DaoAgenda;
import modeloDao.DaoConsulta;


/**
 *
 * @author Denis
 */
public class FormAgendaMedico extends javax.swing.JFrame {

    ConexaoDB conex = new ConexaoDB();
    String dtHoje;
    String status;
    DaoAgenda daoAgenda = new DaoAgenda();
    String cod_ag;
    /**
     * Creates new form FormAgendaMedico
     */
    public FormAgendaMedico() {
        initComponents();
        
         URL caminhoIcone = getClass().getResource("/Imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        
        Calendar data =  Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.format(d);
        
        dtHoje = dateFormat.format(d);
        status = "Atendimento";
        
        preencherMedico();
    }
    
    public void preencherMedico(){
        conex.getConnection();
        conex.executaSql("select *from medicos order by nome_medico");
        try{
            conex.rs.first();
            jComboBoxMedicos.removeAllItems();
            do{
                jComboBoxMedicos.addItem(conex.rs.getString("nome_medico"));
            }while(conex.rs.next());
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher Médicos");
         }
        conex.desconecta();
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
        JOptionPane.showMessageDialog(rootPane, " Não Existem Agendamentos para este Médico!");
        
        
           
    }ModeloTabela modelo = new ModeloTabela(dados,colunas);
    jTableAtender.setModel(modelo);
    jTableAtender.getColumnModel().getColumn(0).setPreferredWidth(83);
    jTableAtender.getColumnModel().getColumn(0).setResizable(false);
    jTableAtender.getColumnModel().getColumn(1).setPreferredWidth(302);
    jTableAtender.getColumnModel().getColumn(1).setResizable(false);
    jTableAtender.getColumnModel().getColumn(2).setPreferredWidth(92);
    jTableAtender.getColumnModel().getColumn(2).setResizable(false);
    jTableAtender.getColumnModel().getColumn(3).setPreferredWidth(102);
    jTableAtender.getColumnModel().getColumn(3).setResizable(false);
    jTableAtender.getColumnModel().getColumn(4).setPreferredWidth(102);
    jTableAtender.getColumnModel().getColumn(4).setResizable(false);
    jTableAtender.getColumnModel().getColumn(5).setPreferredWidth(302);
    jTableAtender.getColumnModel().getColumn(5).setResizable(false);
    jTableAtender.getTableHeader().setReorderingAllowed(false);
    jTableAtender.setAutoResizeMode(jTableAtender.AUTO_RESIZE_OFF);
    jTableAtender.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    conex.desconecta();
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
        jTableAtender = new javax.swing.JTable();
        jComboBoxMedicos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonAtender = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendamentos Médicos");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableAtender.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAtender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAtenderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAtender);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        jComboBoxMedicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("Médico:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Listagem de Agendamentos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Agendamentos Médicos");

        jButtonAtender.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButtonAtender.setText("Atender Paciente");
        jButtonAtender.setEnabled(false);
        jButtonAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtenderActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jButtonAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxMedicos)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(3, 3, 3)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(791, 434));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int cod = daoAgenda.BuscaIDMedico((String)jComboBoxMedicos.getSelectedItem());
        String codigo = String.valueOf(cod);
        preencherTabela("select * from agenda inner join pacientes on agenda_idpaciente = id_paciente inner join medicos on agenda_idmedico = id_medico where agenda_idmedico = '"+codigo+"' and agenda_data = '"+dtHoje+"' and status = '"+status+"' ");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableAtenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAtenderMouseClicked
        //Esse método pega o valor da Jtable em envia o código para a tabela de atendimento
        cod_ag =""+jTableAtender.getValueAt(jTableAtender.getSelectedRow(), 0);
        jButtonAtender.setEnabled(true);
    }//GEN-LAST:event_jTableAtenderMouseClicked

    private void jButtonAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtenderActionPerformed
        FormConsulta tela = new FormConsulta(cod_ag);
        tela.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(FormAgendaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendaMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtender;
    private javax.swing.JComboBox<String> jComboBoxMedicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAtender;
    // End of variables declaration//GEN-END:variables
}