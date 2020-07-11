package qbo.net.apprecyclervolleypicasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import qbo.net.apprecyclervolleypicasso.adapter.FlorAdapter;
import qbo.net.apprecyclervolleypicasso.model.Flor;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvdatos;
    private FlorAdapter adapter;
    //Definimos la cola de peticiones
    private RequestQueue colapeticiones;
    ArrayList<Flor> listflor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvdatos = findViewById(R.id.rvdatos);
        rvdatos.setLayoutManager(new LinearLayoutManager(
                MainActivity.this
        ));
        adapter = new FlorAdapter(MainActivity.this);
        rvdatos.setAdapter(adapter);
        listflor = new ArrayList<>();
        colapeticiones = Volley.newRequestQueue(this);
        ConsumirWebService();
    }

    private void ConsumirWebService() {
        String url = "https://pixabay.com/api/?key=12544769-ce772d6f6df4078b74b23c3cf&q=yellow+flowers&image_type=photo&pretty=true";
        //Definimos la peticion (JsonArrayRequest o JsonObjectRequest).
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for (int i =0; i< jsonArray.length(); i++){
                                JSONObject objJson = jsonArray.getJSONObject(i);
                                listflor.add(new Flor(
                                        objJson.getString("tags"),
                                        objJson.getString("user"),
                                        objJson.getString("webformatURL")
                                ));
                            }
                            adapter.agregarelementos(listflor);
                        }catch (JSONException ex){

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        colapeticiones.add(request);
    }

}
