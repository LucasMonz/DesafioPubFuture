//Interface da Tela Cadastro de Movimentação
package com.br.telas;

import com.br.dao.CategoriaDao;
import com.br.dao.MovimentacaoDao;
import com.br.entidades.Categoria;
import com.br.entidades.Movimentacao;
import com.br.utils.Msg;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelaMovimentacaoCadastro extends javax.swing.JDialog {

    private boolean inserir;
    private boolean despesa;
    private Movimentacao movimentacao;
    private TelaMovimentacao pai;
    private List<Categoria> listaCategoria = new ArrayList<>();

    public TelaMovimentacaoCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        movimentacao = new Movimentacao();
        atualizaCombo();
    }

    //Método para atualizar a tabela em TelaMovimentacao
    public TelaMovimentacaoCadastro(TelaMovimentacao parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pai = parent;
        movimentacao = new Movimentacao();
        atualizaCombo();
    }

    //Método para atualizar box "Categoria"
    protected void atualizaCombo() {
        //Trycatch para atualizar filtrar box "Categoria" e avisar se houver erro
        try {
            cbCategoria.removeAllItems();
            cbCategoria.addItem("Selecione");
            //Condição para definir somente um tipo para cada opção (Despesa ou Receita)
            if (isDespesa()) {
                listaCategoria = new CategoriaDao().getListaFiltro("Despesa");
            } else {
                listaCategoria = new CategoriaDao().getListaFiltro("Receita");
            }
            for (Categoria c : listaCategoria) {
                cbCategoria.addItem(c.getDescricao());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "Erro ao atualizar Combo Categoria.\nErro: " + e.getMessage());
        }
    }

    //Método para retornar os dados do campo selecionado
    protected void preencheCampos(Movimentacao cat) {
        movimentacao = cat;
        txData.setDate(movimentacao.getData());
        txObservacao.setText(movimentacao.getObservacao());
        txValor.setText(movimentacao.getValor()+"");
        cbCategoria.setSelectedItem(movimentacao.getIdCategoria().getDescricao());
    }

    //Método para definir "Data", "Categoria", "Descrição" e "Valor"
    private Movimentacao getMovimentacao() {
        movimentacao.setData(txData.getDate());
        
        movimentacao.setDataCadastro(new Date());
        movimentacao.setIdCategoria(listaCategoria.get(cbCategoria.getSelectedIndex() - 1));
        movimentacao.setObservacao(txObservacao.getText());
        /*
        * O campo "Valor" retorna uma String, logo convertemos para double e 
        * substituimos a vírgula por ponto
        */
        movimentacao.setValor(Double.parseDouble(txValor.getText().replace(",", ".")));
        return movimentacao;
    }

    //Método para evitar que a Descrição seja salva em branco
    private boolean verificaCampos() {
        boolean verifica = false;
        String msg = "Campos obrigatórios: \n";
        //Condição para verificar se o campo está em branco e avisar se houver erro
        if (txObservacao.getText().trim().equals("") || txObservacao.getText().isEmpty()) {
            verifica = true;
            msg += " • Descrição. \n";
            txObservacao.requestFocus();
        }

        if (verifica) {
            Msg.erro(this, msg);
        }
        return verifica;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txObservacao = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txValor = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txData = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de conta ");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/accept.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jLabel1.setText("Descrição:");

        jLabel2.setText("Categoria:");

        txObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txObservacaoActionPerformed(evt);
            }
        });

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pagar", "Receber" }));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor:");

        txValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txValor.setText("0,00");
        txValor.setToolTipText("");
        txValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txValorFocusGained(evt);
            }
        });
        txValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txValorMouseClicked(evt);
            }
        });
        txValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txValorActionPerformed(evt);
            }
        });

        jLabel4.setText("Data:");

        txData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txValor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                    .addComponent(txObservacao))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Campo "Descrição"
    private void txObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txObservacaoActionPerformed
        
    }//GEN-LAST:event_txObservacaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //Condição para diferenciar os botões de "Inserir" e "Alterar"
        if (!verificaCampos()) {
            if (isInserir()) {
                new MovimentacaoDao().inserir(getMovimentacao());
                Msg.informacao(this, "Salvo com sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            } else {
                new MovimentacaoDao().alterar(getMovimentacao());
                Msg.informacao(this, "Alterado com sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Botão de Cancelar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    //Campo "Valor"
    private void txValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txValorActionPerformed
      
    }//GEN-LAST:event_txValorActionPerformed

    private void txValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txValorFocusGained
        txValor.selectAll();
    }//GEN-LAST:event_txValorFocusGained

    private void txValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txValorMouseClicked
        txValor.selectAll();
    }//GEN-LAST:event_txValorMouseClicked

    //Box Data
    private void txDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDataActionPerformed
        
    }//GEN-LAST:event_txDataActionPerformed

    //Box Categoria
    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        
    }//GEN-LAST:event_cbCategoriaActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaMovimentacaoCadastro dialog = new TelaMovimentacaoCadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker txData;
    private javax.swing.JTextField txObservacao;
    private javax.swing.JFormattedTextField txValor;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the inserir
     */
    public boolean isInserir() {
        return inserir;
    }

    /**
     * @param inserir the inserir to set
     */
    public void setInserir(boolean inserir) {
        this.inserir = inserir;
    }

    /**
     * @return the despesa
     */
    public boolean isDespesa() {
        return despesa;
    }

    /**
     * @param despesa the despesa to set
     */
    public void setDespesa(boolean despesa) {
        this.despesa = despesa;
    }

}
