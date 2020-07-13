package qbo.net.apprecyclervolleypicasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

import qbo.net.apprecyclervolleypicasso.adapter.FlorAdapter;
import qbo.net.apprecyclervolleypicasso.model.Flor;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvdatos;
    private DataAdapter adapter;
    //Definimos la cola de peticiones
    private RequestQueue colapeticiones;
    ArrayList<Data> datoss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvdatos = findViewById(R.id.rvdatos);
        /*rvdatos.setLayoutManager(new LinearLayoutManager(
                MainActivity.this
        ));*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2);
        adapter = new DataAdapter(MainActivity.this);
        rvdatos.setAdapter(adapter);
        rvdatos.setLayoutManager(gridLayoutManager);
        datoss = new ArrayList<>();
        colapeticiones = Volley.newRequestQueue(this);
        ConsumirWebService();
    }

    private void ConsumirWebService() {
        System.out.println("HOLA AMIGO");
        String url = "https://jsonplaceholder.typicode.com/comments";
        //Definimos la peticion (JsonArrayRequest o JsonObjectRequest).
        /* JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println("HOLA MUNDO"+response);
                        System.out.println("HOLA MUNDO");
                        try {
                            JSONArray jsonArray = response.getJSONArray("");
                            for (int i =0; i< jsonArray.length(); i++){
                                JSONObject objJson = jsonArray.getJSONObject(i);
                                listflor.add(new Data(
                                        objJson.getInt("postId"),
                                        objJson.getInt("id")
                                ));
                            }
                            adapter.addData(listflor);
                        }catch (JSONException ex){

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error: "+error.getMessage());
            }
        });*/
        //MySingleton.getInstance(this).addToRequestQueue(request);
        StringRequest peticion = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String respuesta) {
                    Gson gson= new Gson();
                    JsonParser jParser = new JsonParser();
                    JsonArray aJson= jParser.parse(respuesta).getAsJsonArray();
                    System.out.println(aJson);
                    datoss=new ArrayList<>();

                        for (JsonElement jElement:aJson) {
                            Data datos = gson.fromJson(jElement,Data.class);
                            datoss.add(datos);
                        }
                        for (int i=0;i<datoss.size();i++)
                        {
                            Data evaluar = datoss.get(i);

                            if (evaluar.getPostId()%2!=0 && evaluar.getPostId()%1!=0 || evaluar.getPostId()!=2)
                            {
                                datoss.remove(i);
                            }
                        }

                        System.out.println("IMPRIMIENDO: "+datoss);
                        adapter.addData(datoss);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );

        colapeticiones.add(peticion);
    }

}
