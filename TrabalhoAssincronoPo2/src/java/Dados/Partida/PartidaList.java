/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Partida;

import Dados.Campeonato.Campeonato;
import java.util.List;

/**
 *
 * @author carlo
 */
@lombok.Data
public class PartidaList {

    private String count;
    private Campeonato competition;
    private List<Partida> matches;
}
