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
class EstadoJogoFinalizado extends Estado {

    String[] fimJogo = {"nao", "negativo"};
    String[] novoJogo = {"sim", "novo", "denovo", "novamente", "quero"};
    
    @Override
    public void processaTexto(String texto) {
        
        String[] tokens = texto.split(" ");
        
        for (String palavra : tokens) {
            for (String textoFim : fimJogo) {
                if (palavra.trim().equals(textoFim.trim())){
                    mensagemResposta = "Okay. ate logo";
                    proximoEstado = new EstadoInicial();
                }
            }
            for (String textoNovo : novoJogo) {
                if (palavra.trim().equals(textoNovo.trim())){
                    Random rand = new Random(new Date().getTime());
                    mensagemResposta = "Legal!! la vamos nos de novo! sorteei um numero de 0 a 9. tente adivinha-lo!";
                    proximoEstado = new EstadoJogando(rand.nextInt(10), 0);
                }
            }
        }
        
        if (proximoEstado == null) {
            mensagemResposta = "Foi bom jogar com voce. Quer jogar de novo?";
            proximoEstado = this;
        }
    }
    
}
