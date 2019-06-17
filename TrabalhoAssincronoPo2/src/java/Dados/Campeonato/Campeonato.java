/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Campeonato;

import Dados.Area.area;
import java.util.List;

/**
 *
 * @author carlo
 */
@lombok.Data
public class Campeonato {

    private String id;
    private area area;
    private String name;
    private String code;
    private String plan;
    private CampeonatoTemporada currentSeason;
    private List<CampeonatoTemporada> seasons;
    private String lastUpdated;

}
