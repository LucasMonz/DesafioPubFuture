//Interface da Tela Cadastro de Categoria
package com.br.telas;

import com.br.dao.CategoriaDao;
import com.br.entidades.Categoria;
import com.br.utils.Msg;


public class TelaCategoriaCadastro extends javax.swing.JDialog {

    private boolean inserir;
    private Categoria categoria;
    private TelaCategoria pai;

    public TelaCategoriaCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        categoria = new Categoria();
    }

    //Método para atualizar a tabela em TelaCategoria
    public TelaCategoriaCadastro(TelaCategoria parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pai = parent;
        categoria = new Categoria();
    }

    //Método para retornar os dados do campo selecionado
    protected void preencheCampos(Categoria cat) {
        categoria = cat;
        txDescricao.setText(categoria.getDescricao());
        cbTipo.setSelectedItem(categoria.getTipo());
    }

    
    //Método para retornar a box "Tipo" com os dados
    private Categoria getCategoria() {
        categoria.setTipo(cbTipo.getSelectedItem().toString());
        categoria.setDescricao(txDescricao.getText());
        return categoria;
    }

    //Método para evitar que a Descrição seja salva em branco
    private boolean verificaCampos() {
        boolean verifica = false;
        String msg = "Campos obrigatórios: \n";
        //Condição para verificar se o campo está em branco e avisar
        if (txDescricao.getText().trim().equals("") || txDescricao.getText().isEmpty()) {
            verifica = true;
            msg += " • Descrição. \n";
            txDescricao.requestFocus();
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
        txDescricao = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox();

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

        jLabel2.setText("Tipo:");

        txDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDescricaoActionPerformed(evt);
            }
        });

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Receita", "Despesa" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txDescricao)
                    .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDescricaoActionPerformed
       
    }//GEN-LAST:event_txDescricaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //Condição para diferenciar os botões de "Inserir" e "Alterar"
        if (!verificaCampos()) {
            if (isInserir()) {
                new CategoriaDao().inserir(getCategoria());
                Msg.informacao(this, "Salvo com sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            } else {
                new CategoriaDao().alterar(getCategoria());
                Msg.informacao(this, "Alterado com sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Botão "Cancelar"
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCategoriaCadastro dialog = new TelaCategoriaCadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txDescricao;
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
}
