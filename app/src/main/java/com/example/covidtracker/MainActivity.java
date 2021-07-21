package com.example.covidtracker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView cases,recovered,critical,today_cases,Active,Today_deaths,total_deaths,affected_countries;

    PieChart pieChart;
    ScrollView scrollView;
    Button b1;
    SimpleArcLoader simpleArcLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cases=(TextView)findViewById(R.id.txtCases);
        recovered=(TextView)findViewById(R.id.txtRecovered);
        critical=(TextView)findViewById(R.id.Critical);
        today_cases=(TextView)findViewById(R.id.today_cases);
        Active=(TextView)findViewById(R.id.active);
        Today_deaths=(TextView)findViewById(R.id.today_deaths);
        total_deaths=(TextView)findViewById(R.id.total_deaths);
        affected_countries=(TextView)findViewById(R.id.affected_countries);

         b1=findViewById(R.id.button1);

        pieChart=(PieChart)findViewById(R.id.piechart);
        simpleArcLoader=(SimpleArcLoader)findViewById(R.id.loader);
        scrollView=(ScrollView)findViewById(R.id.scroll_view);

        callData();

    }

    private void callData() {

        String url="https://corona.lmao.ninja/v2/all";
        simpleArcLoader.start();
        //now use volley
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject=new JSONObject(response.toString());

                    cases.setText(jsonObject.getString("cases"));
                    recovered.setText(jsonObject.getString("recovered"));
                    critical.setText(jsonObject.getString("critical"));
                    today_cases.setText(jsonObject.getString("todayCases"));
                    Active.setText(jsonObject.getString("active"));
                    Today_deaths.setText(jsonObject.getString("todayDeaths"));
                    total_deaths.setText(jsonObject.getString("deaths"));
                    affected_countries.setText(jsonObject.getString("affectedCountries"));


                    pieChart.addPieSlice(new PieModel("Total cases",Integer.parseInt(cases.getText().toString()), Color.parseColor("#fb7268")));
                    pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(Active.getText().toString()), Color.parseColor("#FF0000")));
                    pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(total_deaths.getText().toString()), Color.parseColor("#FFA726")));
                    pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(recovered.getText().toString()), Color.parseColor("#008000")));

                    pieChart.startAnimation();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);

                    scrollView.setVisibility(View.VISIBLE);



                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

    public void show(View view) {
        try {
            Intent intent = new Intent(MainActivity.this, Countries.class);
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}