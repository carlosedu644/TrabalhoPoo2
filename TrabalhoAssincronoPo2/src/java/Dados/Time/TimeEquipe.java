/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Time;

import Dados.Area.area;
import Dados.Campeonato.CampeonatoTime;
import Dados.Jogador.Jogador;
import java.util.List;

/**
 *
 * @author carlo
 */
@lombok.Data
public class TimeEquipe {

    private String id;
    private area area;
    private List<CampeonatoTime> activeCompetitions;
    private String name;
    private String shortName;
    private String tla;
    private String crestUrl;
    private String address;
    private String phone;
    private String website;
    private String email;
    private String founded;
    private String clubColors;
    private String venue;
    private List<Jogador> squad;

}
