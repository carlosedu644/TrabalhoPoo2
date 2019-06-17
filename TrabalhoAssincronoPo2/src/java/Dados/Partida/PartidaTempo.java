/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Partida;

/**
 *
 * @author carlo
 */
public class PartidaTempo {

    private String homeTeam;
    private String awayTeam;

    public PartidaTempo() {
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return  "homeTeam=" + homeTeam + ", awayTeam=" + awayTeam ;
    }

}
