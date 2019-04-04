package com.hfad.cokolwiek;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void losujHaslo(View view){
        Intent intent = new Intent(this,Haslo.class);
        int losowaKategoria = (int) (Math.random() * 2);
        if(losowaKategoria==0)  intent.putExtra("ktore","zwierze");
        else if(losowaKategoria==1)  intent.putExtra("ktore","kwiat");
        startActivity(intent);
    }

}
