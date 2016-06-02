/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot.estados;

import java.text.ParseException;

/**
 *
 * @author rafa
 */
public class EstadoJogando extends Estado {

    private int numeroSorteado;
    private int tentativas;
    private int MAX_TENTATIVAS = 3;

    public int getNumeroSorteado() {
        return numeroSorteado;
    }

    public EstadoJogando(int numeroSorteado, int tentativas) {
        this.numeroSorteado = numeroSorteado;
        this.tentativas = tentativas;

    }

    public void setNumeroSorteado(int numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    @Override
    public void processaTexto(String texto) {

        String[] tokens = texto.split("");

        int palpite = -1;
        for (String palavra : tokens) {
            try {
                palpite = Integer.parseInt(palavra);
            } catch (NumberFormatException e) {
            }
        }

        if (palpite < 0) {
            mensagemResposta = "Vamos la cara! Digite um numero. (Nao use o numero por extenso...)";
            proximoEstado = new EstadoJogando(numeroSorteado, tentativas);
        } else if (palpite != numeroSorteado) {
            tentativas++;
            int diff = Math.abs(numeroSorteado - palpite);
            if (diff <= 2) {
                mensagemResposta = "Voce quase acertou!";
            } else {
                mensagemResposta = "Seu palpite foi pessimo!";
            }

            if (tentativas >= MAX_TENTATIVAS) {
                mensagemResposta += System.lineSeparator() + "Voce nao tem mais tentativas. o numer era " + numeroSorteado;
                proximoEstado = new EstadoJogoFinalizado();
            } else {
                mensagemResposta += System.lineSeparator() + "Voce ainda tem " + (MAX_TENTATIVAS - tentativas) + " tentativas. nao desista!";
                proximoEstado = new EstadoJogando(numeroSorteado, tentativas);
            }
            
        } else {
            mensagemResposta = "Parabens! Voce acertou! Miseravi";
            proximoEstado = new EstadoJogoFinalizado();
        }

    }
}
