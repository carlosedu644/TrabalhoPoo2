/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Campeonato;

import java.util.List;

/**
 *
 * @author carlo
 */
@lombok.Data
public class CampeonatoList {

    private String count;
    private List<Campeonato> competitions;

}
