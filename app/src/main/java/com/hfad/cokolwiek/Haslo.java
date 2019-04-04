package com.hfad.cokolwiek;

import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Haslo extends Activity {
    String obecneHaslo="";
    String pokazywaneHaslo;
    int ileBledow=0;
    boolean czyKoniec=false;
    int[] doUzytych=new int[24];
    String opcja="";
    int p=0;
    int pozycja=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haslo);
        TextView haslo = (TextView) findViewById(R.id.haslo);
        TextView kategoria = (TextView) findViewById(R.id.kategoria);
        Intent intent=this.getIntent();
        opcja=intent.getStringExtra("ktore");
        kategoria.setText("Kategoria:"+opcja);
        if(savedInstanceState==null)
        {
            if(opcja.equals("zwierze"))
            {
                int losowyFilm = (int) (Math.random() * (PulaHasel.haslaZwierzeta.length - 1));
                obecneHaslo = PulaHasel.haslaZwierzeta[losowyFilm];
            }//if(opcja.equals("film"))
            else if(opcja.equals("kwiat"))
            {
                int losowySerial = (int) (Math.random() * (PulaHasel.haslaKwiaty.length - 1));
                obecneHaslo = PulaHasel.haslaKwiaty[losowySerial];
            }//if(opcja.equals("serial"))
            else if(opcja.equals("owoce i warzywa"))
            {
                int losowySerial = (int) (Math.random() * (PulaHasel.haslaOwoce.length - 1));
                obecneHaslo = PulaHasel.haslaOwoce[losowySerial];
            }//if(opcja.equals("serial"))
            else if(opcja.equals("kolor"))
            {
                int losowySerial = (int) (Math.random() * (PulaHasel.haslaKolory.length - 1));
                obecneHaslo = PulaHasel.haslaKolory[losowySerial];
            }//if(opcja.equals("serial"))
            else if(opcja.equals("jedzenie"))
            {
                int losowySerial = (int) (Math.random() * (PulaHasel.haslaJedzenie.length - 1));
                obecneHaslo = PulaHasel.haslaJedzenie[losowySerial];
            }//if(opcja.equals("serial"))
            else if(opcja.equals("ubranie"))
            {
                int losowySerial = (int) (Math.random() * (PulaHasel.haslaUbranie.length - 1));
                obecneHaslo = PulaHasel.haslaUbranie[losowySerial];
            }//if(opcja.equals("serial"))
            else if(opcja.equals("rzecz"))
            {
                int losowySerial = (int) (Math.random() * (PulaHasel.haslaRzeczy.length - 1));
                obecneHaslo = PulaHasel.haslaRzeczy[losowySerial];
            }//if(opcja.equals("serial"))
            else if(opcja.equals("miejsca i obiekty"))
            {
                int losowySerial = (int) (Math.random() * (PulaHasel.haslaMiejsce.length - 1));
                obecneHaslo = PulaHasel.haslaMiejsce[losowySerial];
            }//if(opcja.equals("serial"))
            else if(opcja.equals("zawód"))
            {
                int losowySerial = (int) (Math.random() * (PulaHasel.haslaZawody.length - 1));
                obecneHaslo = PulaHasel.haslaZawody[losowySerial];
            }//if(opcja.equals("serial"))
           // pokazywaneHaslo = Character.toString(obecneHaslo.charAt(0)) + " ";
            pokazywaneHaslo="";
            for (int i = 0; i < obecneHaslo.length(); i++)
            {
                char literka = obecneHaslo.charAt(i);
                if (literka > 96 && literka < 123)
                {
                    pokazywaneHaslo = pokazywaneHaslo + "_" + " ";
                }// if (literka > 96 && literka < 123)
                else
                {
                    pokazywaneHaslo = pokazywaneHaslo + Character.toString(literka) + " ";
                }//else  if (literka > 96 && literka < 123)
            }// for (int i = 1; i < obecneHaslo.length(); i++)
        }// if(savedInstanceState==null)

        if(savedInstanceState!=null){
            obecneHaslo=savedInstanceState.getString("obecne");
            pokazywaneHaslo=savedInstanceState.getString("pokazywane");
            ileBledow=savedInstanceState.getInt("ile");
            czyKoniec=savedInstanceState.getBoolean("czy");
            pozycja=savedInstanceState.getInt("pozycja");

        }//if(savedInstanceState!=null){

        haslo.setText(pokazywaneHaslo);
        zmienObrazek();

        AdapterView.OnItemClickListener sluchacz1=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> first, View v, int position, long id){


                pozycja= v.getId();
                if(position==0)
                {
                    if(!czyJest(11))
                    {
                        pokazUzyte(11);
                        if(znajdzLitere(1,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==1)
                    if(!czyJest(12))
                    {
                        pokazUzyte(12);
                        if(znajdzLitere(1,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                if(position==2)
                    if(!czyJest(13))
                    {
                        pokazUzyte(13);
                        if(znajdzLitere(1,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }

            }
        };
        ListView first=(ListView)findViewById(R.id.first);
        first.setOnItemClickListener(sluchacz1);

        AdapterView.OnItemClickListener sluchacz2=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> second, View v, int position, long id){


                if(position==0)
                {
                    if (!czyJest(21))
                    {
                        pokazUzyte(21);
                        if(znajdzLitere(2,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==1)
                {
                    if (!czyJest(22))
                    {
                        pokazUzyte(22);
                        if(znajdzLitere(2,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==2)
                {
                    if (!czyJest(23))
                    {
                        pokazUzyte(23);
                        if(znajdzLitere(2,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
            }
        };
        ListView second=(ListView)findViewById(R.id.second);
        second.setOnItemClickListener(sluchacz2);

        AdapterView.OnItemClickListener sluchacz3=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> third, View v, int position, long id){
                if(position==0)
                {
                    if (!czyJest(31))
                    {
                        pokazUzyte(31);
                        if(znajdzLitere(3,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==1)
                {
                    if (!czyJest(32))
                    {
                        pokazUzyte(32);
                        if(znajdzLitere(3,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==2)
                {
                    if (!czyJest(33))
                    {
                        pokazUzyte(33);
                        if(znajdzLitere(3,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
            }
        };
        ListView third=(ListView)findViewById(R.id.third);
        third.setOnItemClickListener(sluchacz3);

        AdapterView.OnItemClickListener sluchacz4=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> fourth, View v, int position, long id){
                if(position==0)
                {
                    if (!czyJest(41))
                    {
                        pokazUzyte(41);
                        if(znajdzLitere(4,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==1)
                {
                    if (!czyJest(42))
                    {
                        pokazUzyte(42);
                        if(znajdzLitere(4,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==2)
                {
                    if (!czyJest(43))
                    {
                        pokazUzyte(43);
                        if(znajdzLitere(4,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
            }
        };
        ListView fourth=(ListView)findViewById(R.id.fourth);
        fourth.setOnItemClickListener(sluchacz4);

        AdapterView.OnItemClickListener sluchacz5=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> fifth, View v, int position, long id){
                if(position==0)
                {
                    if (!czyJest(51))
                    {
                        pokazUzyte(51);
                        if(znajdzLitere(5,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==1)
                {
                    if (!czyJest(52))
                    {
                        pokazUzyte(52);
                        if(znajdzLitere(5,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==2)
                {
                    if (!czyJest(53))
                    {
                        pokazUzyte(53);
                        if(znajdzLitere(5,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
            }
        };
        ListView fifth=(ListView)findViewById(R.id.fifth);
        fifth.setOnItemClickListener(sluchacz5);

        AdapterView.OnItemClickListener sluchacz6=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> sixth, View v, int position, long id){
                if(position==0)
                {
                    if (!czyJest(61))
                    {
                        pokazUzyte(61);
                        if(znajdzLitere(6,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==1)
                {
                    if (!czyJest(62))
                    {
                        pokazUzyte(62);
                        if(znajdzLitere(6,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==2)
                {
                    if (!czyJest(63))
                    {
                        pokazUzyte(63);
                        if(znajdzLitere(6,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
            }
        };
        ListView sixth=(ListView)findViewById(R.id.sixth);
        sixth.setOnItemClickListener(sluchacz6);

        AdapterView.OnItemClickListener sluchacz7=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> seventh, View v, int position, long id){
                if(position==0)
                {
                    if (!czyJest(71))
                    {
                        pokazUzyte(71);
                        if(znajdzLitere(7,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==1)
                {
                    if (!czyJest(72))
                    {
                        pokazUzyte(72);
                        if(znajdzLitere(7,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==2)
                {
                    if (!czyJest(73))
                    {
                        pokazUzyte(73);
                        if(znajdzLitere(7,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
            }
        };
        ListView seventh=(ListView)findViewById(R.id.seventh);
        seventh.setOnItemClickListener(sluchacz7);

        AdapterView.OnItemClickListener sluchacz8=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> eigth, View v, int position, long id){
                if(position==0)
                {
                    if (!czyJest(81))
                    {
                        pokazUzyte(81);
                        if(znajdzLitere(8,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==1)
                {
                    if (!czyJest(82))
                    {
                        pokazUzyte(82);
                        if(znajdzLitere(8,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
                if(position==2)
                {
                    if (!czyJest(83))
                    {
                        pokazUzyte(83);
                        if(znajdzLitere(8,position))
                            v.setBackgroundColor(Color.GREEN);
                        else v.setBackgroundColor(Color.RED);
                    }
                }
            }
        };
        ListView eigth=(ListView)findViewById(R.id.eigth);
        eigth.setOnItemClickListener(sluchacz8);

        Parcelable state =first .onSaveInstanceState();
        if(savedInstanceState!=null)
            first.onRestoreInstanceState(state);

    }

    public void pokazUzyte(int pozycja)
    {
        doUzytych[p]=pozycja;
        p++;
    }

    public boolean czyJest(int position)
    {
        boolean czy=false;
        for(int i=0;i<p;i++)
        {
            if(doUzytych[i]==position) czy=true;
        }

        return czy;
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("obecne",obecneHaslo);
        savedInstanceState.putString("pokazywane",pokazywaneHaslo);
        savedInstanceState.putInt("ile",ileBledow);
        savedInstanceState.putBoolean("czy",czyKoniec);
        // savedInstanceState.putString("uzyte",doUzytych);
        savedInstanceState.putInt("pozycja",pozycja);

    }
    public boolean znajdzLitere(int kolumna, int wiersz){
        String pokazujHaslo="";
        char gloska=0;
        if(kolumna==1){
            if(wiersz==0) gloska='a';
            if(wiersz==1) gloska='i';
            if(wiersz==2) gloska='r';
        }

        if(kolumna==2){
            if(wiersz==0) gloska='b';
            if(wiersz==1) gloska='j';
            if(wiersz==2) gloska='s';
        }

        if(kolumna==3){
            if(wiersz==0) gloska='c';
            if(wiersz==1) gloska='k';
            if(wiersz==2) gloska='t';
        }

        if(kolumna==4){
            if(wiersz==0) gloska='d';
            if(wiersz==1) gloska='l';
            if(wiersz==2) gloska='u';
        }

        if(kolumna==5){
            if(wiersz==0) gloska='e';
            if(wiersz==1) gloska='m';
            if(wiersz==2) gloska='w';
        }

        if(kolumna==6){
            if(wiersz==0) gloska='f';
            if(wiersz==1) gloska='n';
            if(wiersz==2) gloska='x';
        }

        if(kolumna==7){
            if(wiersz==0) gloska='g';
            if(wiersz==1) gloska='o';
            if(wiersz==2) gloska='y';
        }

        if(kolumna==8){
            if(wiersz==0) gloska='h';
            if(wiersz==1) gloska='p';
            if(wiersz==2) gloska='z';
        }
        int liczbaLiter=0;
        for(int i=0;i<pokazywaneHaslo.length();i++){
            char literka=pokazywaneHaslo.charAt(i);
            if(literka!='_') {
                liczbaLiter++;
                pokazujHaslo = pokazujHaslo + Character.toString(literka);
            }
            else if(obecneHaslo.charAt(i/2)==gloska)
                pokazujHaslo=pokazujHaslo+Character.toString(gloska);
            else{
                liczbaLiter++;
                pokazujHaslo=pokazujHaslo+"_";}
        }

        czyKoniec=true;

        pokazywaneHaslo=pokazujHaslo;
        for(int j=0;j<pokazywaneHaslo.length();j++){
            char litera=pokazywaneHaslo.charAt(j);
            if(litera=='_'){
                czyKoniec=false;
            }
        }

        if(czyKoniec)
        {
            Intent intencja = new Intent(this, Wygrany.class);
            intencja.putExtra("haslo",obecneHaslo);
            intencja.putExtra("ktore",opcja);
            finish();
            startActivity(intencja);
        }
        boolean toColor=true;
        if(liczbaLiter==pokazywaneHaslo.length()) {ileBledow++; toColor=false;}
        zmienObrazek();
        TextView haslo=(TextView)findViewById(R.id.haslo);
        haslo.setText(pokazywaneHaslo);
        return toColor;
    }

    public void zmienObrazek(){
        ImageView obrazek=(ImageView)findViewById(R.id.wisielec);
        if(ileBledow==0){
            obrazek.setImageResource(R.drawable.puste);
        }
        if(ileBledow==1){
            obrazek.setImageResource(R.drawable.pierwszy);
        }
        if(ileBledow==2){
            obrazek.setImageResource(R.drawable.drugi);
        }
        if(ileBledow==3){
            obrazek.setImageResource(R.drawable.trzeci);
        }
        if(ileBledow==4){
            obrazek.setImageResource(R.drawable.czwarty);
        }
        if(ileBledow==5){
            obrazek.setImageResource(R.drawable.piaty);
        }
        if(ileBledow==6){
            obrazek.setImageResource(R.drawable.szosty);
        }
        if(ileBledow==7){
            obrazek.setImageResource(R.drawable.siodmy);
        }
        if(ileBledow==8){
            obrazek.setImageResource(R.drawable.osmy);
        }
        if(ileBledow==9){
            obrazek.setImageResource(R.drawable.dziewiaty);
        }
        if(ileBledow==10){
            obrazek.setImageResource(R.drawable.dziesiaty);
        }
        if(ileBledow==11){
            obrazek.setImageResource(R.drawable.jedenasty);
            // obrazek.setImageResource(R.drawable.dwunasty);
            Intent intent=new Intent(Haslo.this, Przegrany.class);
            intent.putExtra("haslo",obecneHaslo);
            intent.putExtra("ktore",opcja);
            try {
                obrazek.setImageResource(R.drawable.dwunasty);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finish();
            startActivity(intent);

        }
    }
    public void onBackPressed()
    {
        Intent wroc=new Intent(this,MainActivity.class);
        wroc.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(wroc);
    }
    }

