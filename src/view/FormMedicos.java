package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloConection.ConexaoDB;
import modeloDao.DaoMedico;
import modeloBeans.BeansMedico;
import modeloBeans.ModeloTabela;
/**
 *
 * @author Denis
 */
public class FormMedicos extends javax.swing.JFrame {

    BeansMedico mod = new BeansMedico();
    DaoMedico control = new DaoMedico();
    ConexaoDB conex = new ConexaoDB();
    int flag = 0;
    
    public FormMedicos() {
        
      initComponents();
      
       URL caminhoIcone = getClass().getResource("/Imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        
      preencherTabela("select *from medicos order by nome_medico");
      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldCrm = new javax.swing.JFormattedTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jComboBoxEspecialidade = new javax.swing.JComboBox<>();
        jButtonSalvar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMedico = new javax.swing.JTable();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jButtonLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Médicos / Especialistas");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Nome: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("CRM:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setText("Especialidade: ");

        try {
            jFormattedTextFieldCrm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCrm.setEnabled(false);
        jFormattedTextFieldCrm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldCrmKeyTyped(evt);
            }
        });

        jTextFieldNome.setEnabled(false);
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyTyped(evt);
            }
        });

        jComboBoxEspecialidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cirurgião", "Ginecologista", "Biomédico", "Pediátra", "Ortopedista", "Oncologista", "Clínico Geral" }));
        jComboBoxEspecialidade.setEnabled(false);

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1472621632_Accept-Male-User.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1472621621_Add-Male-User.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1472621627_Edit-Male-User.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1472621652_Remove-Male-User.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1472622028_message-delete.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jTableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMedico);

        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyTyped(evt);
            }
        });

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/add-icon.png"))); // NOI18N
        jLabel5.setText(" ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setText("Telefone: ");

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldTelefone.setEnabled(false);
        jFormattedTextFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldTelefoneActionPerformed(evt);
            }
        });
        jFormattedTextFieldTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldTelefoneKeyTyped(evt);
            }
        });

        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Gnome-Edit-Clear-32.png"))); // NOI18N
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setText("ID: ");

        jTextFieldCod.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldCrm, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSalvar)
                            .addComponent(jButtonExcluir)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelar, jButtonEditar, jButtonExcluir, jButtonNovo, jButtonSalvar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(jFormattedTextFieldCrm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButtonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar)
                        .addGap(4, 4, 4)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jFormattedTextFieldCrm, jTextFieldNome});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancelar, jButtonEditar, jButtonExcluir, jButtonNovo, jButtonSalvar});

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Cadastro de Médicos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(730, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
       if (jTextFieldNome.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Por Favor!\nPreencha o Campo Nome!");
           jTextFieldNome.requestFocus();
       }else if (jFormattedTextFieldCrm.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Por Favor!\nPreencha o Campo Crm!"); 
           jFormattedTextFieldCrm.requestFocus();
       }else if(jFormattedTextFieldTelefone.getText().equals("(  )     -    ")){
           JOptionPane.showMessageDialog(null,"Por Favor!\nPreencha o Campo Telefone!");
           jFormattedTextFieldTelefone.requestFocus();
       }else
        if(flag == 1){
        mod.setNome(jTextFieldNome.getText());
        mod.setEspecialidade((String)jComboBoxEspecialidade.getSelectedItem());
        mod.setCrm(Integer.parseInt(jFormattedTextFieldCrm.getText()));
        mod.setTelefone(jFormattedTextFieldTelefone.getText());
        control.Salvar(mod);
        jTextFieldNome.setText("");
        jFormattedTextFieldCrm.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldCod.setText("");
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldCrm.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jComboBoxEspecialidade.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jTextFieldPesquisar.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
        jButtonLimpar.setEnabled(true);
        jButtonCancelar.setEnabled(!true);
        jButtonNovo.setEnabled(true);
        preencherTabela("select *from medicos order by nome_medico");
        }else{
            mod.setCodigo((Integer.parseInt(jTextFieldCod.getText())));
            mod.setNome(jTextFieldNome.getText());
            mod.setEspecialidade((String)jComboBoxEspecialidade.getSelectedItem());
            mod.setCrm(Integer.parseInt(jFormattedTextFieldCrm.getText()));
            mod.setTelefone(jFormattedTextFieldTelefone.getText());
            control.Editar(mod);
        jTextFieldNome.setText("");
        jFormattedTextFieldCrm.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldCod.setText("");
            jTextFieldNome.setEnabled(false);
       jFormattedTextFieldCrm.setEnabled(false);
       jFormattedTextFieldTelefone.setEnabled(false);
       jComboBoxEspecialidade.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonNovo.setEnabled(true);
       jButtonCancelar.setEnabled(false);
       jTextFieldPesquisar.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
        jButtonLimpar.setEnabled(true);
         jButtonNovo.setEnabled(true);
         preencherTabela("select *from medicos order by nome_medico");
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        if (jTextFieldPesquisar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Por Favor!\nPreencha o Campo de Pesquisa!");
            jTextFieldPesquisar.requestFocus();
        preencherTabela("select *from medicos order by nome_medico"); 
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        }else{
        
        mod.setPesquisa(jTextFieldPesquisar.getText());
        BeansMedico model = control.buscaMedico(mod);
        jTextFieldNome.setText(model.getNome());
        jTextFieldCod.setText(String.valueOf(model.getCodigo()));
        jFormattedTextFieldCrm.setText(String.valueOf(model.getCrm()));
        jComboBoxEspecialidade.setSelectedItem(model.getEspecialidade());
        jFormattedTextFieldTelefone.setText(model.getTelefone());
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        preencherTabela("select *from medicos where nome_medico ilike '%" + mod.getPesquisa()+ "%'");}
        
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flag = 1 ;
        jTextFieldNome.setText("");
        jFormattedTextFieldCrm.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldPesquisar.setText("");
        jTextFieldCod.setText("");
        jTextFieldPesquisar.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
        jButtonLimpar.setEnabled(false);
        jTextFieldNome.setEnabled(true);
       jFormattedTextFieldCrm.setEnabled(true);
       jFormattedTextFieldTelefone.setEnabled(true);
       jComboBoxEspecialidade.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonNovo.setEnabled(false);
       jButtonEditar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldNome.setText("");
        jFormattedTextFieldCrm.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldPesquisar.setText("");
        jTextFieldCod.setText("");
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        preencherTabela("select *from medicos order by nome_medico"); 
        jButtonCancelar.setEnabled(false);
        jButtonNovo.setEnabled(true);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextFieldNome.setEnabled(!true);
       jFormattedTextFieldCrm.setEnabled(!true);
       jFormattedTextFieldTelefone.setEnabled(!true);
       jComboBoxEspecialidade.setEnabled(!true);
       jButtonSalvar.setEnabled(!true);
       jButtonCancelar.setEnabled(!true);
       jButtonNovo.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisar.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
        jButtonLimpar.setEnabled(true);
        jTextFieldNome.setText("");
        jFormattedTextFieldCrm.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldPesquisar.setText("");
        jTextFieldCod.setText("");
        preencherTabela("select *from medicos order by nome_medico"); 
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
       flag = 2 ;
       jTextFieldNome.setEnabled(true);
       jFormattedTextFieldCrm.setEnabled(true);
       jFormattedTextFieldTelefone.setEnabled(true);
       jComboBoxEspecialidade.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonEditar.setEnabled(false);
       jButtonNovo.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonPesquisar.setEnabled(false);
       jButtonLimpar.setEnabled(false);
       jTextFieldPesquisar.setEnabled(false);
       jTextFieldPesquisar.setText("");
              
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jFormattedTextFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefoneActionPerformed
 
    }//GEN-LAST:event_jFormattedTextFieldTelefoneActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
       int resposta = 0;
       resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja Realmente Excluir Registro?");
       if(resposta==JOptionPane.YES_OPTION){
           mod.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
           control.Excluir(mod);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jTextFieldNome.setText("");
        jFormattedTextFieldCrm.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldPesquisar.setText("");
        jTextFieldCod.setText("");
        jButtonCancelar.setEnabled(false);
        jButtonNovo.setEnabled(true);
       }else{
        JOptionPane.showMessageDialog(null,"Os Registros não foram Deletados");   
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jTextFieldNome.setText("");
        jFormattedTextFieldCrm.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldPesquisar.setText("");
        jTextFieldCod.setText("");        
       }
       preencherTabela("select *from medicos order by nome_medico");
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMedicoMouseClicked
       String nome_medico=""+jTableMedico.getValueAt(jTableMedico.getSelectedRow(),1);
       conex.getConnection();
       conex.executaSql("select *from medicos where nome_medico='"+ nome_medico+"'");
       try{
           conex.rs.first();
           jTextFieldCod.setText(String.valueOf(conex.rs.getInt("id_medico")));
           jTextFieldNome.setText(conex.rs.getString("nome_medico"));
           jComboBoxEspecialidade.setSelectedItem(conex.rs.getString("especialidade"));
           jFormattedTextFieldCrm.setText(conex.rs.getString("crm"));
           jFormattedTextFieldTelefone.setText(conex.rs.getString("telefone"));
        jButtonExcluir.setEnabled(true);
        jButtonEditar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jTextFieldPesquisar.setEnabled(!false);
        jButtonPesquisar.setEnabled(!false);
        jButtonLimpar.setEnabled(!false);
        
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Erro ao Selecionar Dados "+ ex);
       }
       //conex.desconecta();
    }//GEN-LAST:event_jTableMedicoMouseClicked

    private void jFormattedTextFieldTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefoneKeyTyped
              String caracteres="0987654321";
if(!caracteres.contains(evt.getKeyChar()+"")){
evt.consume();
}
    }//GEN-LAST:event_jFormattedTextFieldTelefoneKeyTyped

    private void jFormattedTextFieldCrmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCrmKeyTyped
              String caracteres="0987654321";
if(!caracteres.contains(evt.getKeyChar()+"")){
evt.consume();
}
    }//GEN-LAST:event_jFormattedTextFieldCrmKeyTyped

    private void jTextFieldPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyTyped
             String caracteres="0987654321";
if(caracteres.contains(evt.getKeyChar()+"")){
evt.consume();
}
    }//GEN-LAST:event_jTextFieldPesquisarKeyTyped

    private void jTextFieldNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyTyped
        String caracteres="0987654321";
if(caracteres.contains(evt.getKeyChar()+"")){
evt.consume();
    }//GEN-LAST:event_jTextFieldNomeKeyTyped
    }    
    public void preencherTabela(String Sql){
    ArrayList dados = new ArrayList();
    String [] colunas;
        colunas = new String[]{"ID","Nome","Especialidade","CRM","Telefone"};
    conex.getConnection();
    conex.executaSql(Sql);
    
    
    try{
    conex.rs.first(); 
    do{
       
        dados.add(new Object[]{conex.rs.getInt("id_medico"),conex.rs.getString("nome_medico"),conex.rs.getString("especialidade"),conex.rs.getInt("crm"),conex.rs.getString("telefone")});
     
    }while(conex.rs.next());
        
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, " Erro ao Procurar na  Lista! \n Por Favor Pesquise novamente!");
        jTextFieldPesquisar.requestFocus();
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jTextFieldNome.setText("");
        jFormattedTextFieldCrm.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldPesquisar.setText("");
        jTextFieldCod.setText("");
        preencherTabela("select *from medicos order by nome_medico");
      return; 
           
    }ModeloTabela modelo = new ModeloTabela(dados,colunas);
    jTableMedico.setModel(modelo);
    jTableMedico.getColumnModel().getColumn(0).setPreferredWidth(40);
    jTableMedico.getColumnModel().getColumn(0).setResizable(false);
    jTableMedico.getColumnModel().getColumn(1).setPreferredWidth(200);
    jTableMedico.getColumnModel().getColumn(1).setResizable(false);
    jTableMedico.getColumnModel().getColumn(2).setPreferredWidth(90);
    jTableMedico.getColumnModel().getColumn(2).setResizable(false);
    jTableMedico.getColumnModel().getColumn(3).setPreferredWidth(100);
    jTableMedico.getColumnModel().getColumn(3).setResizable(false);
    jTableMedico.getColumnModel().getColumn(4).setPreferredWidth(115);
    jTableMedico.getColumnModel().getColumn(4).setResizable(false);
    jTableMedico.getTableHeader().setReorderingAllowed(false);
    jTableMedico.setAutoResizeMode(jTableMedico.AUTO_RESIZE_OFF);
    jTableMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //conex.desconecta();
    }
    
    
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxEspecialidade;
    private javax.swing.JFormattedTextField jFormattedTextFieldCrm;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMedico;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables

        }