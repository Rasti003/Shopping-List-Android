package pl.legalnyplener.shoppinglist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AsyncTask<String,String,String> {
    private TextView roleField;
    private Context context;
    private int byGetOrPost = 0;
    int id_user = 0;


    //flag 0 means get and 1 means post.(By default it is get.)
    public Signin(Context context, TextView roleField, int flag) {
        this.context = context;
        this.roleField = roleField;
        byGetOrPost = flag;                                                    //flaga zaleznosci od wyboru metody logowania
    }

    protected void onPreExecute(){
    }


    protected String  doInBackground(String... arg0) {
        if(byGetOrPost == 0){ //means by Get Method

            try{
                String username = (String)arg0[0];
                String password = (String)arg0[1];
                String link = ##


                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line="";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                in.close();
                return sb.toString();
            } catch(Exception e){
                return new String("Exception: " + e.getMessage());

            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result){
      //  this.statusField.setText("Login Successful");
       id_user = Integer.valueOf(result);

LoginCorect(id_user);
       this.roleField.setText("user id " + id_user); // wyswietlanie id user w teksie (niepotrzebne)
   }






   void LoginCorect (int user_id){
       if (user_id > 0){

           Toast.makeText(context,"Login successfully", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(context,MainActivity.class); //PRZENOSZENIE NA INNE ACTIVITY: twozenie INTENS getApp..- aktualny kontekst aplikacje przycisk powrót tu przeniesie , Activity docelowe.class
           context.startActivity(intent);
       }
       else
       {
           Toast.makeText(context,"Wrong login or password", Toast.LENGTH_SHORT).show();
       }

   }

}