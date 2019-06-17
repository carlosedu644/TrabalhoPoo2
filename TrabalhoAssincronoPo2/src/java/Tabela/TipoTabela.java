/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabela;

import java.util.List;

/**
 *
 * @author carlo
 */
@lombok.Data
public class TipoTabela {

    private String stage;
    private String type;
    private String group;
    private List<TimeTabela> table;

}
