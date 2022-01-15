//Interface da Tela Movimentação
package com.br.telas;

import com.br.dao.MovimentacaoDao;
import com.br.entidades.Movimentacao;
import com.br.utils.Msg;
import com.br.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class TelaMovimentacao extends javax.swing.JDialog {

    private List<Movimentacao> lista = new ArrayList<>();

    public TelaMovimentacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Utils.maximizar(this); - Usado para maximizar a tela de Categoria (Não utilizado)
        atualizaTabela();
    }

    protected void atualizaTabela() {
        //Trycatch para notificar se algum erro acontecer com os dados da tabela
        try {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setNumRows(0);
            double despesa = 0;
            double receita = 0;

            lista = new MovimentacaoDao().getListaData(txPesquisa.getText(), txDataInicial.getDate(), txDataFinal.getDate());
            for (Movimentacao c : lista) {
                //Condição para calcular os valores em "Receita" e "Despesa"
                if (c.getIdCategoria().getTipo().equals("Despesa")) {
                    despesa += c.getValor();
                } else {
                    receita += c.getValor();
                }
                model.addRow(new Object[]{
                    c.getIdMovimentacao(),
                    Utils.convertData(c.getData()),
                    c.getIdCategoria().getTipo(),
                    Utils.convertDouble(c.getValor()),
                    c.getIdCategoria().getDescricao()
                });
            }
            //Retorno dos valores "Receita" e "Despesa" e calcular valor de "Saldo"
            txDespesa.setText(Utils.convertDouble(despesa));
            txReceita.setText(Utils.convertDouble(receita));
            txSaldo.setText(Utils.convertDouble(receita - despesa));

        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "Erro ao atualizar a tabela.\nErro:" + e.getMessage());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txPesquisa = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txSaldo = new javax.swing.JTextField();
        txDespesa = new javax.swing.JTextField();
        txReceita = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txDataInicial = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        txDataFinal = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação");

        tabela.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        tabela.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Tipo", "Valor", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(50);
            tabela.getColumnModel().getColumn(0).setMaxWidth(50);
            tabela.getColumnModel().getColumn(1).setMinWidth(90);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(90);
            tabela.getColumnModel().getColumn(1).setMaxWidth(90);
        }

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/money_add.png"))); // NOI18N
        jButton1.setText("Inserir Receita");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/money_delete.png"))); // NOI18N
        jButton6.setText("Inserir Despesa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/arrow_switch.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/delete.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/door_out.png"))); // NOI18N
        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jLabel1.setText("Pesquisar:");

        txPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisaActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/magnifier.png"))); // NOI18N
        jButton5.setText("Pesquisar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Receita:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Despesa:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Saldo:");

        txSaldo.setEditable(false);
        txSaldo.setText("0,00");
        txSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSaldoActionPerformed(evt);
            }
        });

        txDespesa.setEditable(false);
        txDespesa.setText("0,00");
        txDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDespesaActionPerformed(evt);
            }
        });

        txReceita.setEditable(false);
        txReceita.setText("0,00");
        txReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txReceitaActionPerformed(evt);
            }
        });

        jLabel5.setText("Data Inicial:");

        txDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDataInicialActionPerformed(evt);
            }
        });

        jLabel6.setText("Data Final:");

        txDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDataFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jLabel5)
                    .addComponent(txDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Método para chamar a tela no botão "Inserir receita" da TelaMovimentacaoCadastro
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaMovimentacaoCadastro t = new TelaMovimentacaoCadastro(this, true);
        t.setInserir(true);
        t.setDespesa(false);
        t.atualizaCombo();
        t.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    //Barra de Pesquisa
    private void txPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisaActionPerformed
        //Não implementado.
    }//GEN-LAST:event_txPesquisaActionPerformed

    //Botão de "Alterar"
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Condição para selecionar um item da lista para modificação
        if (tabela.getSelectedRow() > -1) {
            TelaMovimentacaoCadastro t = new TelaMovimentacaoCadastro(this, true);
            t.setInserir(false);
            
            /*
             * Condição para verificar se está alterando uma Despesa ou uma Receita
             * e retornar uma mensagem de alerta se o usuário não selecionar registro
             */
            if (lista.get(tabela.getSelectedRow()).getIdCategoria().getTipo().equals("Despesa")) {
                t.setDespesa(true);
                t.atualizaCombo();
                t.preencheCampos(lista.get(tabela.getSelectedRow()));
                t.setVisible(true);
                atualizaTabela();
            } else {
                t.setDespesa(false);
                t.atualizaCombo();
                t.preencheCampos(lista.get(tabela.getSelectedRow()));
                t.setVisible(true);
                atualizaTabela();
            }
        } else {
            Msg.alert(this, "Selecione um registro!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Botão de Pesquisar
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_jButton5ActionPerformed

    //Botão de Sair
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    //Botão de Excluir
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Condição para selecionar linha da tabela
        if (tabela.getSelectedRow() > -1) {
            //Condição para excluir a linha e atualizar os dados da tabela
            if (Msg.confirmar(this, "Tem certeza que deseja excluir este arquivo permanentemente?")) {
                new MovimentacaoDao().excluir(lista.get(tabela.getSelectedRow()));
                Msg.informacao(this, "Excluído com sucesso!");
                atualizaTabela();
            }
        } else {
            Msg.alert(this, "Selecione um registro!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    //Método para chamar a tela no botão "Inserir Despesa" da TelaMovimentacaoCadastro
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        TelaMovimentacaoCadastro t = new TelaMovimentacaoCadastro(this, true);
        t.setInserir(true);
        t.setDespesa(true);
        t.atualizaCombo();
        t.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    //Data Inicial
    private void txDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDataInicialActionPerformed

    }//GEN-LAST:event_txDataInicialActionPerformed

    //Data Final
    private void txDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDataFinalActionPerformed

    }//GEN-LAST:event_txDataFinalActionPerformed

    //Área "Receita"
    private void txReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txReceitaActionPerformed
        
    }//GEN-LAST:event_txReceitaActionPerformed

    //Área "Despesa"
    private void txDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDespesaActionPerformed
        
    }//GEN-LAST:event_txDespesaActionPerformed

    //Área "Saldo"
    private void txSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSaldoActionPerformed
       
    }//GEN-LAST:event_txSaldoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaMovimentacao dialog = new TelaMovimentacao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private org.jdesktop.swingx.JXDatePicker txDataFinal;
    private org.jdesktop.swingx.JXDatePicker txDataInicial;
    private javax.swing.JTextField txDespesa;
    private javax.swing.JTextField txPesquisa;
    private javax.swing.JTextField txReceita;
    private javax.swing.JTextField txSaldo;
    // End of variables declaration//GEN-END:variables
}
