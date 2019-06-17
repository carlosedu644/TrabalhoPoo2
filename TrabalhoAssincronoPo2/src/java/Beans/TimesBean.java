/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dados.Jogador.Jogador;
import Dados.Partida.Partida;
import Dados.Partida.PartidaList;
import Dados.Time.TimeEquipe;
import Util.UtilJson;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author carlo
 */
@ManagedBean
@ViewScoped
@lombok.Data
public class TimesBean {

    private static final String URI = "https://api.football-data.org/v2/";
    /**
     * Creates a new instance of TimesBean
     */
    String id;
    List<Partida> listPartida;
    List<Jogador> listJogador;

    public TimesBean() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();

        id = request.getParameter("id");
        listPartida = new LinkedList<>();
        listPartida.addAll(getPartidaByTimeId(id).getMatches());
        
        listJogador = new LinkedList<>();
        listJogador.addAll(getJogadoresTime(id).getSquad());

    }

    public String FormatarData(String data) throws ParseException {
        Date date;
        DateFormat m_ISO8601Local = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        date = m_ISO8601Local.parse(data);
        SimpleDateFormat DataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        return DataFormatada.format(date);
    }

    public String TraduzirStatusJogo(String status) {

        switch (status) {
            case "FINISHED":
                return "Finalizado";
            case "SCHEDULED":
                return "A Confirmar";
        }

        return null;
    }

    public static PartidaList getPartidaByTimeId(String idTime) {
        UtilJson<PartidaList> utilJson = new UtilJson<>();
        return utilJson.getObjectFromJson(URI + "teams/" + idTime + "/matches", PartidaList.class);
    }

    public static TimeEquipe getJogadoresTime(String idTime) {
        UtilJson<TimeEquipe> utilJson = new UtilJson<>();
        return utilJson.getObjectFromJson(URI + "teams/" + idTime , TimeEquipe.class);
    }

}
