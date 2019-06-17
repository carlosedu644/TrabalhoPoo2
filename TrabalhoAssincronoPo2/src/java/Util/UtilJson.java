/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import javax.xml.ws.Response;

/**
 *
 * @author carlo
 */
public class UtilJson<T> {

    private final static String TOKEN = "1dee77b6ae5b4a8ab04d92784645be6b";
    public static ExecutorService ex = Executors.newFixedThreadPool(100);

//    public static Future<Object> getObjectAsync() {
//    return CompletableFuture.supplyAsync(() -> doHttpCall());
//}
    public T getObjectFromJson(String urlTarget, Class<T> myclass) {

        Gson gson = new Gson();
        String json;
        T result = null;
        // json = (String.valueOf(CompletableFuture.supplyAsync(()->getJsonStringByUrl(urlTarget))));

        json = getJsonStringByUrl(urlTarget);
        if (json != null) {
            result = gson.fromJson(json, myclass);
        }

        return result;
    }

    public T start(String urlTarget, Class<T> myclass) {
        Gson gson = new Gson();
        T result = null;
        CompletableFuture.supplyAsync(() -> getJsonStringByUrl(urlTarget), ex).thenAccept((Consumer<? super String>) getObjectFromJson(urlTarget, myclass));
        String json = getJsonStringByUrl(urlTarget);
        result = gson.fromJson(json, myclass);
        return result;
    }

    private static String getJsonStringByUrl(String urlTarget) {

        try {

            URL url = new URL(urlTarget);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            http.setRequestMethod("GET");
            http.setRequestProperty("X-Auth-Token", TOKEN);
            http.setUseCaches(false);
            http.setAllowUserInteraction(false);
            http.connect();
            int status = http.getResponseCode();

//Condicional para verificar se a API REST executou com sucesso 
//qualquer ação solicitada pelo cliente.
            if (status == 200) {

                StringBuilder sb;
                try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"))) {
                    sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                }
                return sb.toString();
            } else {
                return "URL não responde.";
            }

        } catch (ProtocolException e) {
            return "Algo não funcionou";
        } catch (IOException e) {
            return "Algo não funcionou";
        }

    }

}
