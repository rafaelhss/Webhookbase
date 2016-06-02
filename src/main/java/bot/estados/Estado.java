/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.estados;

/**
 *
 * @author rafa
 */
public abstract class Estado {
     protected String mensagemResposta;
     protected Estado proximoEstado;
     

    public abstract void processaTexto(String texto);
    
    public String getMensagemResposta() {
        return mensagemResposta;
    }

    public Estado getProximoEstado() {
        return proximoEstado;
    }
    
    
     
}
