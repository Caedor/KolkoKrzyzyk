package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int []games={2,2,2,2,2,2,2,2,2};
int [][]win={{0,1,2}, {3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
int activeplayer=0;
boolean gameactive=true;

    public void fade(View view ){

    ImageView count= (ImageView) view;
    int tapp=Integer.parseInt(count.getTag().toString());

if(games[tapp]==2 && gameactive) {

    games[tapp] = activeplayer;
    count.setTranslationY(-1500);
    if (activeplayer == 0) {
        count.setImageResource(R.drawable.krzyz);
        Toast.makeText(this, "Gracz 1", Toast.LENGTH_SHORT).show();
        activeplayer = 1;
    } else {
        count.setImageResource(R.drawable.kolko);
        Toast.makeText(this, "Gracz 2", Toast.LENGTH_SHORT).show();
        activeplayer = 0;

    }

    count.animate().translationYBy(1500).setDuration(300);
    for (int[] winp : win) {
        if (games[winp[0]] == games[winp[1]] && games[winp[1]] == games[winp[2]] && games[winp[0]] != 2) {
            gameactive=false;
            String winner = "";

            if (activeplayer == 1) {
                winner = "yellow";

            } else {
                winner = "red";
            }
            Toast.makeText(this, winner + " has won", Toast.LENGTH_SHORT).show();
            Button button=(Button) findViewById(R.id.button);

            button.setVisibility(View.VISIBLE);

        }
        else { if (games[0]!=2 && games[1]!=2 && games[2]!=2 && games[3]!=2 && games[4]!=2 && games[5]!=2
                && games[6]!=2 && games[7]!=2 && games[8]!=2){

            gameactive=false;
            Toast.makeText(this,  " Draw", Toast.LENGTH_SHORT).show();
            Button button=(Button) findViewById(R.id.button);

            button.setVisibility(View.VISIBLE);


            }



        }


    }
}
    }
    public void playagain(View view){
        Button button=(Button) findViewById(R.id.button);
        TextView textView=(TextView) findViewById(R.id.textView);
        button.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);

        ConstraintLayout crr= (ConstraintLayout) findViewById(R.id.cr);
        for( int i=0; i<crr.getChildCount(); i++) {
            ImageView counter =(ImageView) crr.getChildAt(i);
            counter.setImageDrawable(null);
        }

for ( int i=0; i<games.length; i++){
         games[i]=2;}

         activeplayer=0;
         gameactive=true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
