package com.dimasadjie.worldtour;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class Paris extends AppCompatActivity {
    TextView data;
    String url;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paris);
        data = findViewById(R.id.timeparis);
        url = "https://worldtimeapi.org/api/timezone/Europe/Paris";
        fetchData();
    }

    private void fetchData() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String datetime = response.getString("datetime");

                    String[] parts = datetime.split("T");
                    String datePart = parts[0];
                    String timePart = parts[1].substring(0, 8);
                    String formattedDateTime = datePart + " " + timePart;
                    data.setText(formattedDateTime);
                } catch (Exception e) {
                    e.printStackTrace();
                    data.setText("Error parsing date");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                data.setText("Error fetching data");
            }
        });

        Volley.newRequestQueue(this).add(request);
    }
    public void back(View view){
        Intent intent = new Intent(Paris.this, MainMenus.class);
        startActivity(intent);
    }
    public void parismaps(View view){
        Intent intent = new Intent(Paris.this, Parismaps.class);
        startActivity(intent);
    }
}
