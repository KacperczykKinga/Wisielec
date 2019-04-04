package com.hfad.cokolwiek;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Wygrany extends Activity {
    String haslo;
    String opcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wygrany);
        Button coLosowac=(android.widget.Button)findViewById(R.id.los2);
        Intent intent2=this.getIntent();
        haslo=intent2.getStringExtra("haslo");
        TextView naPokaz=(TextView) findViewById(R.id.hasloW);
        naPokaz.setText("Szukane haslo to:"+haslo);
        opcja=intent2.getStringExtra("ktore");
    }

    public void kolejnyFilm(View view){
        Intent intent=new Intent(this,Haslo.class);
        int losowaKategoria = (int) (Math.random() * 9);
        if(losowaKategoria==0)  intent.putExtra("ktore","zwierze");
        else if(losowaKategoria==1)  intent.putExtra("ktore","kwiat");
        else if(losowaKategoria==2)  intent.putExtra("ktore","owoce i warzywa");
        else if(losowaKategoria==3)  intent.putExtra("ktore","kolor");
        else if(losowaKategoria==4)  intent.putExtra("ktore","jedzenie");
        else if(losowaKategoria==5)  intent.putExtra("ktore","ubranie");
        else if(losowaKategoria==6)  intent.putExtra("ktore","rzecz");
        else if(losowaKategoria==7)  intent.putExtra("ktore","miejsca i obiekty");
        else if(losowaKategoria==8)  intent.putExtra("ktore","zawód");
       // intent.putExtra("ktore",opcja);
        finish();
        startActivity(intent);
    }
    public void onBackPressed()
    {
        Intent wroc=new Intent(this,MainActivity.class);
        wroc.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(wroc);
    }
    }

