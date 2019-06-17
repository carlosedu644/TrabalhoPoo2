/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Partida;

import Dados.Campeonato.Campeonato;
import Dados.Time.Time;
import java.util.List;

/**
 *
 * @author carlo
 */
@lombok.Data
public class Partida {

    private String id;
    private Campeonato competition;
    private Campeonato season;
    private String utcDate;
    private String status;
    private String venue;
    private String matchday;
    private String stage;
    private String group;
    private String lastUpdated;
    private Time homeTeam;
    private Time awayTeam;
    private PartidaPlacar score;
    private List<ArbitroPartida> referees;

}
