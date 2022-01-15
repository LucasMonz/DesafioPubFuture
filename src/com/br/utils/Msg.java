/*
Classe para criar mensagens para o usuário usando o JOptionPane
 */
package com.br.utils;


import java.awt.Component;
import javax.swing.JOptionPane;

public class Msg {

    public static void alert(Component frame, String msg) {
        //Método que cria uma mensagem de Alerta na interface do JFrame
        JOptionPane.showMessageDialog(frame, msg, "Alerta", JOptionPane.WARNING_MESSAGE);
    }

    public static void informacao(Component frame, String msg) {
        //Método que cria uma mensagem de Informação na interface do JFrame
        JOptionPane.showMessageDialog(frame, msg, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void erro(Component frame, String msg) {
        //Método que cria uma mensagem de Erro na interface do JFrame
        JOptionPane.showMessageDialog(frame, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean confirmar(Component frame, String msg) {
        
        /* Método que cria uma mensagem de Confirmação na interface do JFrame
        * dando ao usuário a opção de confirmação (Sim ou não)
        */
        
        Object[] options = {"Sim", "Não"};
        int option = JOptionPane.showOptionDialog(frame, msg, "Confirmar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        //Verificação de lógica:
        if (option == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }

    }
}
