package com.project.pdf.pdf_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class AccueilActivity extends Activity {

    ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        imgButton = (ImageButton)findViewById(R.id.imageButtonServices);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AccueilActivity.this, ServicesActivity.class);
                startActivity(intent);
            }
        });

        imgButton = (ImageButton)findViewById(R.id.imageButtonPlanning);
        imgButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent intent = new Intent(AccueilActivity.this, PlanningActivity.class);
                startActivity(intent);
            }
        });

        imgButton = (ImageButton)findViewById(R.id.imageButtonMap);
        imgButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent intent = new Intent(AccueilActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        imgButton = (ImageButton)findViewById(R.id.imageButtonSpectacle);
        imgButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent intent = new Intent(AccueilActivity.this, SpectacleActivity.class);
                startActivity(intent);
            }
        });

        imgButton = (ImageButton)findViewById(R.id.imageButtonPartage);
        imgButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent intent = new Intent(AccueilActivity.this, PartageActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
        return true;
    }


}
