package com.example.denis.pairsgame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {

    private ImageButton[] buttons;
    private Card[] cards;
    private ImageButton firtsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        int ramdomNumbers[] = generateRamdomNumbers();
        putImages(ramdomNumbers);
        evaluate();
    }


    public void evaluate() {
        for (int i = 0; i < cards.length - 1; i++) {
            boolean isOn1  =  cards[i].isOn();
            boolean hasPar1 = cards[i].isHasPar();
            for (int j = i + 1; j <cards.length ; j++) {
                boolean isOn2 = cards[j].isOn();
                boolean hasPar2 = cards[j].isHasPar();
                int questionid = R.drawable.question;
                 if(isOn1 && isOn2 && !hasPar1 && !hasPar2){
                     if(cards[i].getIdImageON() != cards[j].getIdImageON() ){
                         buttons[i].setImageResource(cards[i].getIdImageOF());
                         buttons[j].setImageResource(cards[j].getIdImageOF());
                         cards[i].setIsOn(false);
                         cards[j].setIsOn(false);
                     }else{
                         cards[i].setIsHasPar(true);
                         cards[j].setIsHasPar(true);
                     }
                 }
            }
        }
    }

    private void initComponents() {
        buttons = new ImageButton[16];
        cards = new Card[16];
        buttons[0] = (ImageButton)findViewById(R.id.imageButton1);
        buttons[1] = (ImageButton)findViewById(R.id.imageButton2);
        buttons[2] = (ImageButton)findViewById(R.id.imageButton3);
        buttons[3] = (ImageButton)findViewById(R.id.imageButton4);
        buttons[4] = (ImageButton)findViewById(R.id.imageButton5);
        buttons[5] = (ImageButton)findViewById(R.id.imageButton6);
        buttons[6] = (ImageButton)findViewById(R.id.imageButton7);
        buttons[7] = (ImageButton)findViewById(R.id.imageButton8);
        buttons[8] = (ImageButton)findViewById(R.id.imageButton9);
        buttons[9] = (ImageButton)findViewById(R.id.imageButton10);
        buttons[10] = (ImageButton)findViewById(R.id.imageButton11);
        buttons[11] = (ImageButton)findViewById(R.id.imageButton12);
        buttons[12] = (ImageButton)findViewById(R.id.imageButton13);
        buttons[13] = (ImageButton)findViewById(R.id.imageButton14);
        buttons[14] = (ImageButton)findViewById(R.id.imageButton15);
        buttons[15] = (ImageButton)findViewById(R.id.imageButton16);
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(buttons[i],R.drawable.question, this);
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(cards[i]);
        }



    }

   private void putImages(int[] ramdomNumbers) {
        for (int i = 0; i < ramdomNumbers.length ; i++) {
            switch (ramdomNumbers[i]){
                case 1:
                    cards[i].setIdImageON(R.drawable.android);
                    break;
                case 2:
                    cards[i].setIdImageON(R.drawable.android);
                    break;
                case 3:
                    cards[i].setIdImageON(R.drawable.blackblackberry);
                    break;
                case 4:
                    cards[i].setIdImageON(R.drawable.blackblackberry);
                    break;
                case 5:
                    cards[i].setIdImageON(R.drawable.cellphone);
                    break;
                case 6:
                    cards[i].setIdImageON(R.drawable.cellphone);
                    break;
                case 7:
                    cards[i].setIdImageON(R.drawable.iphone);
                    break;
                case 8:
                    cards[i].setIdImageON(R.drawable.iphone);
                    break;
                case 9:
                    cards[i].setIdImageON(R.drawable.multiplesmatphones);
                    break;
                case 10:
                    cards[i].setIdImageON(R.drawable.multiplesmatphones);
                    break;
                case 11:
                    cards[i].setIdImageON(R.drawable.nfcheckpoint);
                    break;
                case 12:
                    cards[i].setIdImageON(R.drawable.nfcheckpoint);
                    break;
                case 13:
                    cards[i].setIdImageON(R.drawable.smartphone);
                    break;
                case 14:
                    cards[i].setIdImageON(R.drawable.smartphone);
                    break;
                case 15:
                    cards[i].setIdImageON(R.drawable.smartphoneandtablet);
                    break;
                case 0:
                    cards[i].setIdImageON(R.drawable.smartphoneandtablet);
                    break;
            }
        }
    }

    private int[] generateRamdomNumbers() {
        int vector[]=new int [16];
        int i=0,j;
        vector[i]=(int)(Math.random()*16);
        for(i=1;i<16;i++)
        {
            vector[i]=(int)(Math.random()*16);
            for(j=0;j<i;j++)
            {
                if(vector[i]==vector[j])
                {
                    i--;
                }
            }
        }
        return vector;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
