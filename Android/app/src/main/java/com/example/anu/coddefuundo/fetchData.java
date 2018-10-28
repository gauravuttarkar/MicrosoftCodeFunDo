package com.example.anu.coddefuundo;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class fetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    String link = "";
    String weather1 = "";
    String temper = "";
    String humidty = "";
    String pressr = "";
    String color1 = "";
    String set = "";

    public fetchData(String urlll) {
        link = urlll;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONObject JO = new JSONObject(data);
            JSONObject JO1 = (JSONObject) JO.get("coord");
            singleParsed = "Lattitude" + JO1.get("lon");
            JSONArray JA1 = (JSONArray) JO.get("weather");
            JSONObject JOJA = (JSONObject) JA1.get(0);
            weather1 = "" + JOJA.get("description");
            color1 = "" + JOJA.get("main");
            JSONObject JOT = (JSONObject) JO.get("main");
            temper = "" + JOT.get("temp");
            humidty = "" + JOT.get("humidity");
            pressr = "" + JOT.get("pressure");
            if(color1 == "Clouds"){
                set = "Moonstone";
            }else if(color1 == "Clear"){
                set = "Sky blue";
            }else if(color1 == "Dust"){
                set = "Dark yellow";
            }else if(color1 == "Fog"){
                set = "#e9e9e9";
            }else if(color1 == "Mist"){
                set = "#ffffff";
            }else if(color1 == "Rain"){
                set = "#00ccff";
            }else{
                set = "#e5f8ff";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.textView1.setText("" +  this.temper + "^F");
        MainActivity.textView02.setText("" + this.weather1);
        MainActivity.textView02.setBackgroundColor(101);
        MainActivity.textView002.setText("Pressure:" + this.pressr + "    Humidty:" + this.humidty);
    }
}