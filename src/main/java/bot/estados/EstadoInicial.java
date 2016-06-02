/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.estados;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author rafa
 */
public class EstadoInicial extends Estado{

    @Override
    public void processaTexto(String texto) {
        
        Random rand = new Random(new Date().getTime());
        mensagemResposta = "Oi amigao!  vou sorteei um numero de 0 a 9. tente adivinha-lo!";
        proximoEstado = new EstadoJogando(rand.nextInt(10), 0);
    }

    
}
