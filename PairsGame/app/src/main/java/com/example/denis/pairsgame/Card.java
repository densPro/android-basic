package com.example.denis.pairsgame;

import android.view.View;
import android.widget.ImageButton;

/**
 * Created by denis on 16/07/2015.
 */
public class Card implements View.OnClickListener{
    private int idImageON;
    private int idImageOF;
    private ImageButton button;
    private boolean isOn;
    private MainActivity activity;
    private boolean hasPar;

    public Card(ImageButton button, int idImageOF , MainActivity activity) {
        this.button = button;
        this.idImageOF = idImageOF;
        button.setImageResource(idImageOF);
        isOn = false;
        hasPar = false;
        this.activity = activity;

    }

    public boolean isHasPar() {
        return hasPar;
    }
    public void setIsHasPar(Boolean par) {
        hasPar = par;
    }

    public void setIsOn(boolean isOn){
        this.isOn = isOn;
    }
    public boolean isOn(){
        return  isOn;
    }
    public void setIdImageON(int idImageON) {
        this.idImageON = idImageON;
    }

    public int getIdImageON() {
        return idImageON;
    }

    public int getIdImageOF() {
        return idImageOF;
    }

    public void setIdImageOF(int idImageOF) {
        this.idImageOF = idImageOF;
    }


    @Override
    public void onClick(View v) {
        button.setImageResource(idImageON);
        isOn = true;
        activity.evaluate();
    }
}
