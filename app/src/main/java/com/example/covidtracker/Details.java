package com.example.covidtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    private  int position;
    TextView country,cases,deaths,todayDeaths,Critical,recovery,active,todayCases;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        position=intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Details"+Countries.countryModels.get(position).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_detail);



        country=findViewById(R.id.txtCountry);
        cases=findViewById(R.id.txtCases1);
        deaths=findViewById(R.id.deaths);
        todayDeaths=findViewById(R.id.today_deaths1);
        Critical=findViewById(R.id.txtCritical);
        recovery=findViewById(R.id.Recovery);
        active=findViewById(R.id.active_case);
        todayCases=findViewById(R.id.today_cases1);

        country.setText(Countries.countryModels.get(position).getCountry());
        cases.setText(Countries.countryModels.get(position).getCases());
        deaths.setText(Countries.countryModels.get(position).getDeaths());
        todayCases.setText(Countries.countryModels.get(position).getToday_cases());
        todayDeaths.setText(Countries.countryModels.get(position).getToday_deaths());
        Critical.setText(Countries.countryModels.get(position).getCriticalCases());
        active.setText(Countries.countryModels.get(position).getActiveCases());
        recovery.setText(Countries.countryModels.get(position).getRecovered());


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
