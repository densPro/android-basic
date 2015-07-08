package com.example.denis.calculate;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by denis on 07/07/2015.
 */
public class SetsListener implements View.OnClickListener{
    private TextView textViewFirtsOperating;
    private TextView textViewSecontOperating;
    private TextView textViewOperator;
    private Button[] btnSetsOperators;

    public SetsListener(Button[] btnSetsOperators,TextView textViewFirtsOperating, TextView textViewSecontOperating, TextView textViewOperator) {
        this.textViewFirtsOperating = textViewFirtsOperating;
        this.textViewSecontOperating = textViewSecontOperating;
        this.textViewOperator = textViewOperator;
        this.btnSetsOperators = btnSetsOperators;
    }

    @Override
    public void onClick(View v) {
        Button pressed = (Button) v;
        String firstText = textViewFirtsOperating.getText().toString();
        //String secontText = textViewSecontOperating.getText().toString();
        //String operatorText = textViewOperator.getText().toString();
        switch (pressed.getText().toString()){
            case "DEL" :
                 if(!firstText.isEmpty()){
                     textViewFirtsOperating.setText(firstText.substring(0,firstText.length()-1));
                 }
                break;
            case "AC" :
                textViewFirtsOperating.setText("");
                textViewSecontOperating.setText("");
                textViewOperator.setText("");
                break;
            case "+/-" :
                if(firstText.startsWith("-")){
                    textViewFirtsOperating.setText(firstText.substring(1,firstText.length()));
                }else{
                    textViewFirtsOperating.setText("-"+firstText);
                }
        }
    }
}
