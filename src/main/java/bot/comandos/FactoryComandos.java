/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.comandos;

import bot.processamentolinguaguem.Verificador;
import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public class FactoryComandos {
    
    private static int MAX_DIST = 2;
    
    public static Comando getComando(String mensagem) {
        
        Verificador verificador = new Verificador(MAX_DIST);
        
        ArrayList<Comando> comandos = getComandoList();
        Comando result = null;
        int maxScore = 0;
        for (Comando comando : comandos) {
            if (verificador.calculaScore(mensagem, comando.getPalavrasChave()) > maxScore){
                result = comando;
            }
        }
        
        return result;
    }

    private static ArrayList<Comando> getComandoList() {
        ArrayList<Comando> comandos = new ArrayList<>();
        comandos.add(new ComandoListarFeriados());
        return comandos;
    }
}
