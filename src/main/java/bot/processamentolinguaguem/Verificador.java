/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.processamentolinguaguem;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author rafa
 */
public class Verificador {

    private int minLavenshteinDist;
    
    public Verificador(int min) {
     this.minLavenshteinDist = min;
    }
    
    public int calculaScore(String mensagem, String[] tokens) {
        int score = 0;
        
        String[] msgTokens = mensagem.split(" ");
        
        for (String token : tokens) {
            for (String msgToken : msgTokens) {
                if(StringUtils.getLevenshteinDistance(msgToken, token) <= minLavenshteinDist) {
                    score++;
                };
            }
        }
        
        return score;
    }
}
