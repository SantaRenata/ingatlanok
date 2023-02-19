/*
* File: Restapi.java
* Author: Sánta Renáta Diána
* Copyright: 2023, Sánta Renáta Diána
* Group: Szoft II N
* Date: 2023-02-19
* Github: https://github.com/SantaRenata/
* Licenc: GNU GPL
*/

package models;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Restapi {
    String host;

    public Restapi(){
        this.host = "http://[::1]:3000/";
    }

    public String getPropertiesAsString(){
        String response = null;
        try {
            response = tryGetPropertiesAsString();    
        }catch (MalformedURLException e) {
            System.err.println("Hiba! Érvénytelen url.");
        }catch (IOException e){
            System.err.println("Hiba! REST API elérése sikertelen.");
        }
        return response;
    }

    public String tryGetPropertiesAsString()throws MalformedURLException, IOException{
        String endpoint = "properties";
        String urlStr = this.host + endpoint;
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();
        int responseCode = http.getResponseCode();
        String text = null;
        if(responseCode == 200){
            InputStream inputStream = http.getInputStream();
            text = this.convertInputStreamToString(inputStream);
        }else{
            System.err.println("Hiba!");
        }
        return text;
    }

    public String convertInputStreamToString(InputStream inputStream){
        Reader reader = new InputStreamReader(inputStream);
        Scanner scanner = new Scanner(reader);
        StringBuilder stringBuilder = new StringBuilder();
        while(scanner.hasNextLine()){
            stringBuilder.append(scanner.nextLine());
        }
        scanner.close();
        return stringBuilder.toString();
    }

    public ArrayList<Property> getProperties(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text = getPropertiesAsString();
        Property[] propertyArray = gson.fromJson(text, Property[].class);
        ArrayList<Property> propertyList = new ArrayList<>(Arrays.asList(propertyArray));
        return propertyList;
    }
}
