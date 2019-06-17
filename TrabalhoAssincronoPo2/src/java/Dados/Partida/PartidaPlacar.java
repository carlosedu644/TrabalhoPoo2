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
@lombok.Data
public class PartidaPlacar {

    private String winner;
    private String duration;
    private PartidaTempo fullTime;
    private PartidaTempo halfTime;
    private PartidaTempo extraTime;
    private PartidaTempo penalties;

}
