/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Campeonato;

import Dados.Area.area;

/**
 *
 * @author carlo
 */
@lombok.Data
public class CampeonatoTime {
    
    private String id;
    private area area;
    private String name;
    private String code;
    private String plan;
    private String lastUpdated;
    
    
}
