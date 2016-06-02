/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.comandos;

/**
 *
 * @author rafa
 */
public abstract class Comando {
    
    public abstract String[] getPalavrasChave();  
    public abstract String run(String mensagem);
    
}
