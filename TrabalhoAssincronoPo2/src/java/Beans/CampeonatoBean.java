/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dados.Partida.Partida;
import Dados.Partida.PartidaList;
import Dados.Time.TimeList;
import Tabela.Tabela;
import Tabela.TimeTabela;
import Util.UtilJson;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author carlo
 */
@ManagedBean
@RequestScoped
@lombok.Data
public class CampeonatoBean {

    private static final String URI = "https://api.football-data.org/v2/";
    public static ExecutorService ex = Executors.newFixedThreadPool(100);
    List<TimeTabela> listaTabela;
    List<Partida> partidaList;

    /**
     * Creates a new instance of CampeonatoBean
     *
     *
     * @throws java.lang.InterruptedException
     */
    public CampeonatoBean() throws InterruptedException {

        //Pegar Todos os times da Serie A do Campeonato Brasileiro 
        listaTabela = new LinkedList<>();
        listaTabela.addAll(getTabelaPorCampeonato(2013).getStandings().get(0).getTable());

        partidaList = new LinkedList<>();
        partidaList.addAll(getPartidasCampeonato().getMatches());

        ex.shutdown();
        ex.awaitTermination(10, TimeUnit.MINUTES);

    }

    public String enviar() {

        return "times";
    }

    public static TimeList getTimePorCampenato(int IdCampeonato) {
        
        UtilJson<TimeList> utilJson = new UtilJson<>();
      
        return utilJson.getObjectFromJson(URI + "competitions/" + IdCampeonato + "/teams", TimeList.class);
    }
    
    

    public static Tabela getTabelaPorCampeonato(int idCompetition) {
        UtilJson<Tabela> utilJson = new UtilJson<>();
        return utilJson.start(URI + "competitions/" + idCompetition + "/standings", Tabela.class);
    }

    public static PartidaList getPartidasCampeonato() {
        UtilJson<PartidaList> utilJson = new UtilJson<>();
        return utilJson.getObjectFromJson(URI + "competitions/2013/matches", PartidaList.class);
    }

    public String FormatarData(String data) throws ParseException {
        Date date;
        DateFormat m_ISO8601Local = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        date = m_ISO8601Local.parse(data);
        SimpleDateFormat DataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        return DataFormatada.format(date);
    }

}
