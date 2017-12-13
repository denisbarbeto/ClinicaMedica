/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansAgenda;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoDB;
import modeloDao.DaoAgenda;
import modeloDao.DaoPaciente;



/**
 *
 * @author Denis
 */
public class FormAgendamentos extends javax.swing.JFrame {
    ConexaoDB conex = new ConexaoDB();
    BeansAgenda agenda = new BeansAgenda();
    FormPacientes telaprincipal = new FormPacientes();

    /**
     * Creates new form FormAgenda
     */
    public FormAgendamentos() {
        initComponents();
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jTextFieldMotivo = new javax.swing.JTextField();
        jComboBoxMedicos = new javax.swing.JComboBox<>();
        jButtonFinalizarA = new javax.swing.JButton();
        jButtonCancelarA = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jDateChooserData = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel2.setText("Paciente: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel3.setText("Médico: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel4.setText("Data Agendamento: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel5.setText("Motivo: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel6.setText("Turno: ");

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde", "Noite" }));
        jComboBoxTurno.setEnabled(false);

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
        jButtonBuscar.setToolTipText("Buscar Pacientes Cadastrados");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePaciente);

        jTextFieldMotivo.setEnabled(false);

        jComboBoxMedicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMedicos.setEnabled(false);
        jComboBoxMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxMedicosMouseClicked(evt);
            }
        });

        jButtonFinalizarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1473312428_4.png"))); // NOI18N
        jButtonFinalizarA.setText("Salvar Agendamento");
        jButtonFinalizarA.setToolTipText("Efetuar o Agendamento");
        jButtonFinalizarA.setEnabled(false);
        jButtonFinalizarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarAActionPerformed(evt);
            }
        });

        jButtonCancelarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1473312439_6.png"))); // NOI18N
        jButtonCancelarA.setText("Cancelar Agendamento");
        jButtonCancelarA.setToolTipText("Cancelar a Operação de Agendamento");
        jButtonCancelarA.setEnabled(false);
        jButtonCancelarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarAActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Agenda.png"))); // NOI18N

        jDateChooserData.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/if_1_41688.png"))); // NOI18N
        jButton1.setText("Novo Paciente");
        jButton1.setToolTipText("Cadastrar Novo Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonCancelarA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonFinalizarA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(31, 31, 31)
                            .addComponent(jTextFieldMotivo))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelarA, jButtonFinalizarA});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jComboBoxMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonFinalizarA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jButtonCancelarA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldMotivo))
                .addGap(30, 30, 30))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBuscar, jComboBoxMedicos, jComboBoxTurno});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancelarA, jButtonFinalizarA});

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Agendamentos ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );

        setSize(new java.awt.Dimension(764, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        preencherTabela("select id_paciente, nome_paciente, rg_paciente, nasc_paciente, rua_paciente, telefone, cep_paciente from pacientes where nome_paciente like '%" + jTextFieldNome.getText() + "%'");
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jComboBoxMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxMedicosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMedicosMouseClicked

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        String nome_paciente=""+jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(),1);
       conex.getConnection();
       conex.executaSql("select *from pacientes where nome_paciente='"+ nome_paciente+"'");
       try{
           conex.rs.first();
        jTextFieldNome.setText(conex.rs.getString("nome_paciente"));
       
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(rootPane,"Erro ao Selecionar Dados");
       }
        conex.desconecta(); 
        jComboBoxTurno.setEnabled(true);
        jComboBoxMedicos.setEnabled(true);
        jTablePaciente.setEnabled(true);
        jButtonFinalizarA.setEnabled(true);
        jButtonCancelarA.setEnabled(true);
        jTextFieldMotivo.setEnabled(true);
        jDateChooserData.setEnabled(true);
        
    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jButtonFinalizarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarAActionPerformed
        agenda.setNomePaciente(jTextFieldNome.getText());
        agenda.setNomeMedico((String)jComboBoxMedicos.getSelectedItem());
        agenda.setTurno((String)jComboBoxTurno.getSelectedItem());
        agenda.setMotivo(jTextFieldMotivo.getText());
        agenda.setData(jDateChooserData.getDate());
        agenda.setStatus("Aberto");
        DaoAgenda dao = new DaoAgenda();
        dao.Salvar(agenda);
        jComboBoxTurno.setEnabled(!true);
        jComboBoxMedicos.setEnabled(!true);
        jTablePaciente.setEnabled(!true);
        jButtonFinalizarA.setEnabled(!true);
        jButtonCancelarA.setEnabled(!true);
        jTextFieldMotivo.setEnabled(!true);
        jDateChooserData.setEnabled(!true);
        jTablePaciente.setEnabled(!true);
        jTextFieldNome.setText("");
        jTextFieldMotivo.setText("");
        jDateChooserData.setDateFormatString("");
    }//GEN-LAST:event_jButtonFinalizarAActionPerformed

    private void jButtonCancelarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarAActionPerformed
       jComboBoxTurno.setEnabled(!true);
        jComboBoxMedicos.setEnabled(!true);
        jTablePaciente.setEnabled(!true);
        jButtonFinalizarA.setEnabled(!true);
        jButtonCancelarA.setEnabled(!true);
        jTextFieldMotivo.setEnabled(!true);
        jDateChooserData.setEnabled(!true);
        jTextFieldNome.setText("");
        jTextFieldMotivo.setText("");
        jDateChooserData.setDate(null);
        jTablePaciente.setEnabled(!true);
    }//GEN-LAST:event_jButtonCancelarAActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Esse Método Chama a Tela de Cadastro de Pacientes
        FormPacientes tela = new FormPacientes();
         tela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void preencherTabela(String Sql){
    ArrayList dados = new ArrayList();
    String [] colunas;
        colunas = new String[]{"ID","Nome","RG","Aniversário","Rua","Telefone","Cep"};
    conex.getConnection();
    conex.executaSql(Sql);
    try{
    conex.rs.first(); 
    do{
       
        dados.add(new Object[]{conex.rs.getInt("id_paciente"),conex.rs.getString("nome_paciente"),conex.rs.getString("rg_paciente"),conex.rs.getString("nasc_paciente"),conex.rs.getString("rua_paciente"),conex.rs.getString("telefone"),conex.rs.getString("cep_paciente")});
    }while(conex.rs.next());
       
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, " Erro ao Procurar na  Lista! \n Por Favor Pesquise novamente!");
       
        jTextFieldNome.setText("");
         
        preencherTabela("select *from pacientes order by nome_paciente");
     
           
    }ModeloTabela modelo = new ModeloTabela(dados,colunas);
    jTablePaciente.setModel(modelo);
    jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(40);
    jTablePaciente.getColumnModel().getColumn(0).setResizable(false);
    jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(210);
    jTablePaciente.getColumnModel().getColumn(1).setResizable(false);
    jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(90);
    jTablePaciente.getColumnModel().getColumn(2).setResizable(false);
    jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(100);
    jTablePaciente.getColumnModel().getColumn(3).setResizable(false);
    jTablePaciente.getColumnModel().getColumn(4).setPreferredWidth(190);
    jTablePaciente.getColumnModel().getColumn(4).setResizable(false);
     jTablePaciente.getColumnModel().getColumn(5).setPreferredWidth(105);
    jTablePaciente.getColumnModel().getColumn(5).setResizable(false);
     jTablePaciente.getColumnModel().getColumn(6).setPreferredWidth(98);
    jTablePaciente.getColumnModel().getColumn(6).setResizable(false);
    jTablePaciente.getTableHeader().setReorderingAllowed(false);
    jTablePaciente.setAutoResizeMode(jTablePaciente.AUTO_RESIZE_OFF);
   jTablePaciente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    conex.desconecta();
    }
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
            java.util.logging.Logger.getLogger(FormAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelarA;
    private javax.swing.JButton jButtonFinalizarA;
    private javax.swing.JComboBox<String> jComboBoxMedicos;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    private com.toedter.calendar.JDateChooser jDateChooserData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField jTextFieldMotivo;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
