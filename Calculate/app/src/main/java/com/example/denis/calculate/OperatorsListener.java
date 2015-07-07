package com.example.denis.calculate;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by denis on 06/07/2015.
 */
public class OperatorsListener implements View.OnClickListener {
    private TextView textViewFirtsOperating;
    private TextView textViewSecontOperating;
    private Button[] btnOperators;
    private TextView textViewOperator;
    private boolean isFound;

    public OperatorsListener(Button[] btnOperators,TextView textViewFirtsOperating,TextView textViewSecontOperating, TextView textViewOperator) {
        this.textViewFirtsOperating = textViewFirtsOperating;
        this.textViewOperator = textViewOperator;
        this.btnOperators = btnOperators;
        this.textViewSecontOperating = textViewSecontOperating;
        isFound = false;
    }

    @Override
    public void onClick(View v) {
        //es necesario???
        Button pressed = (Button)v;
        //for(Button btn : btnOperators){
         //   if(btn ==pressed){
        //textView2.setText(textView1.getText().toString());
        //textView1.setText("");

        for (int i = 0; i < btnOperators.length; i++) {
            if(!textViewFirtsOperating.getText().toString().equals("")||!textViewSecontOperating.getText().toString().isEmpty()){
                if(btnOperators[0]==pressed){
                    textViewOperator.setText("+");
                }else if(btnOperators[1]==pressed){
                    textViewOperator.setText("-");
                }else if(btnOperators[2]==pressed){
                    textViewOperator.setText("x");
                }else if(btnOperators[3]==pressed){
                    textViewOperator.setText("/");
                }
            }


        }

           // }
       // }
    }
}
