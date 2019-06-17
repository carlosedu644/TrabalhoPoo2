/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Time;

import Dados.Campeonato.Campeonato;
import Dados.Campeonato.CampeonatoTemporada;
import java.util.List;

/**
 *
 * @author carlo
 */
@lombok.Data
public class TimeList {

    private String count;
    private Campeonato competition;
    private CampeonatoTemporada season;
    private List<Time> teams;

}
