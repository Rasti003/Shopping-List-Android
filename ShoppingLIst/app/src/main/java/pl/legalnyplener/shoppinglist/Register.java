package pl.legalnyplener.shoppinglist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;



public class Register extends AsyncTask<String,String,String> {
    private TextView roleField;
    private Context context;
    private int byGetOrPost = 0;

    //flag 0 means get and 1 means post.(By default it is get.)
    public Register(Context context, TextView roleField, int flag) {
        this.context = context;
        this.roleField = roleField;
        byGetOrPost = flag;                                                    //flaga zaleznosci od wyboru metody logowania
    }

    protected void onPreExecute() {
    }


    protected String doInBackground(String... arg0) {
        if (byGetOrPost == 0) { //means by Get Method

            try {


                String username = (String) arg0[0];
                String password = (String) arg0[1];
                String email = (String) arg0[2];


                String link =##


                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                in.close();
                return sb.toString();
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        this.roleField.setText(result);
    }

}
