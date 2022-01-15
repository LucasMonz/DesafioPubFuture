package com.br.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;

public class Utils {

    //Maximiza as telas de cadastro (não utilizado):
    public static void maximizar(JDialog dialog) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        screen = new Dimension((int) screen.getWidth(), (int) screen.getHeight() - 60);
        dialog.setSize(screen);
        dialog.setLocationRelativeTo(null);
    }

    //Converte o valor com ponto ao invés de vírgula:
    public static String convertDouble(double valor) {
        return new DecimalFormat("#0.00").format(valor);
    }
   
    //Converte data de "mm/dd/yyyy" para "dd/mm/yyyy":
    public static String convertData(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
