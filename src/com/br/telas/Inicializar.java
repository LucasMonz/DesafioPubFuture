
package com.br.telas;

import com.br.utils.Msg;
import com.br.utils.Singleton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

public class Inicializar {

    private static Progress p;

    public static void main(String[] args) {

        /**
         * Temas para tela: 
         * com.jtattoo.plaf.fast.FastLookAndFeel
         * com.jtattoo.plaf.graphite.GraphiteLookAndFeel
         */
        //Trycatch para avisar se houver algum erro ao ativar tema da interface
        try {

            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new JFrame());
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(null, "Erro ao aplicar o tema.");
        }

        //Mensagem de inicialização
        p = new Progress(new JFrame(), "Aguarde enquanto codamos a tela inicial!");

        /**
        *
        * @author Breke
        */
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {

                p.gerarJanela();
                Singleton.setConection();
                return null;
            }

            @Override
            protected void done() {
                p.fechar();
                new TelaPrincipal().setVisible(true);
            }
        };

        worker.execute();
    }

}
