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
public class ComandoNaoEntendi extends Comando{

    @Override
    @SuppressWarnings("empty-statement")
    public String[] getPalavrasChave() {
       return null;
    }

    @Override
    public String run(String mensagem) {
        return "Nao entendi. Fale novamente.";
    }
    
}
