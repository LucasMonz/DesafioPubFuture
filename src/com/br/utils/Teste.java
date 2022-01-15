/*
* Classe criada para testar as mensagens do JOptionPane
*/
package com.br.utils;

public class Teste {

    public static void main(String[] args) {
        //Mensagens em pop-up da classe Msg:
        Msg.alert(null, "Mensagem de Alerta");
        Msg.informacao(null, "Mensagem de Informação");
        Msg.erro(null, "Mensagem de Erro");
        Msg.confirmar(null, "Mensagem de Confirmação");
    }
}
