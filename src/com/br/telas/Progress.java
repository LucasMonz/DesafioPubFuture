
package com.br.telas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JWindow;


public class Progress {

    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    private javax.swing.JLabel labelMensagem;
    private String mensagem;
    private JWindow Jwindowns;
    private JFrame jframe;
    private JDialog jdialog;

    public Progress(JFrame jframe, String mensagem) {
        this.jframe = jframe;
        this.mensagem = mensagem;
        Jwindowns = new JWindow(jframe);
    }

    public Progress(JDialog jdialog, String mensagem) {
        this.jdialog = jdialog;
        this.mensagem = mensagem;
        Jwindowns = new JWindow(jdialog);
    }
    
 //Método para gerar tela de inicialização
    public void gerarJanela() {
        jPanel1 = new javax.swing.JPanel();
        labelMensagem = new javax.swing.JLabel();
        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        labelMensagem.setText(mensagem);

        jXTitledSeparator1.setTitle("");

        jProgressBar1.setIndeterminate(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/5.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                .addComponent(labelMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelMensagem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //
        Jwindowns.add(jPanel1);
        Jwindowns.pack();
        if (jframe != null) {
            Jwindowns.setLocationRelativeTo(jframe);
        }
        if (jdialog != null) {
            Jwindowns.setLocationRelativeTo(jdialog);
        }
        Jwindowns.setVisible(true);

    }

    //Método para fechar a tela de inicialização
    public void fechar() {
        Jwindowns.dispose();
    }

}
