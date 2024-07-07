package com.dimasadjie.worldtour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Mahal extends AppCompatActivity {

    TextView data;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahal);
        data = findViewById(R.id.timeindia);
        url = "https://worldtimeapi.org/api/timezone/Asia/Kolkata";
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
        Intent intent = new Intent(Mahal.this, MainMenus.class);
        startActivity(intent);
    }
    public void maps(View view){
        Intent intent = new Intent(Mahal.this, Mahalmaps.class);
        startActivity(intent);
    }
}