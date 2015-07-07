package com.example.denis.calculate;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by denis on 05/07/2015.
 */
public class NumbersListener implements View.OnClickListener {
    private Button[] btnNumbers;
    private  TextView firtsOperating;
    private TextView secontOperating;
    private TextView textViewOperator;
    public NumbersListener(Button[] btnNumbers, TextView firtsOperating, TextView secontOperating, TextView textViewOperator) {
        this.btnNumbers = btnNumbers;
        this.firtsOperating = firtsOperating;
        this.secontOperating = secontOperating;
        this.textViewOperator = textViewOperator;
    }

    @Override

    public void onClick(View v) {
        Button pressed = (Button) v;
        for(Button btn : btnNumbers){
            if(pressed == btn ){
                if(firtsOperating.getText().toString().equals("")|| textViewOperator.getText().toString().isEmpty()){
                    String btn_text =  btn.getText().toString();
                    firtsOperating.append(btn_text);
                }else if(secontOperating.getText().toString().equals("")){
                    String btn_text =  btn.getText().toString();
                    secontOperating.setText(firtsOperating.getText().toString());
                    firtsOperating.setText(btn_text);
                }else{
                    String btn_text =  btn.getText().toString();
                    firtsOperating.append(btn_text);
                }

            }

        }
    }
}
