/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.comandos;

import bot.processamentolinguaguem.Verificador;

/**
 *
 * @author rafa
 */
public class ComandoListarFeriados extends Comando{

    @Override
    public String[] getPalavrasChave() {
        String[] resultado = {"quantos", "feriados", "folgas"};
        return resultado;
        
    }

    @Override
    public String run(String mensagem) {
       
        String[] ama = {"amanha"};
        int amanha = new Verificador(1).calculaScore(mensagem, ama);
                
        if (amanha > 0)
            return "Amanha nao eh feriado, bro";
        
        return "Quer saber os feriados desse semestre?"  + System.lineSeparator() + "Segue a lista: " + System.lineSeparator() + "Corpus cristi, Tiradentes, N senhra aparecida";
        
        
    }
    
}
