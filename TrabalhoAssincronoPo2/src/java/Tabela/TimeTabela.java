/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabela;

import Dados.Time.Time;

/**
 *
 * @author carlo
 */
@lombok.Data
public class TimeTabela {

    private String position;
    private Time team;
    private String playedGames;
    private String won;
    private String draw;
    private String lost;
    private String points;
    private String goalsFor;
    private String goalsAgainst;
    private String goalDifference;

}
