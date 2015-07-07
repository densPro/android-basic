package com.example.denis.calculate;

import android.view.View;
import android.widget.TextView;

/**
 * Created by denis on 07/07/2015.
 */
public class EqualsListener implements View.OnClickListener {
    private TextView textViewFirtsOperating;
    private TextView textViewSecontOperating;
    private TextView textViewOperator;

    public EqualsListener(TextView textViewFirtsOperating, TextView textViewSecontOperating, TextView textViewOperator) {
        this.textViewOperator = textViewOperator;
        this.textViewFirtsOperating = textViewFirtsOperating;
        this.textViewSecontOperating = textViewSecontOperating;
    }

    @Override
    public void onClick(View v) {
        String fisrt = textViewFirtsOperating.getText().toString();
        String secont = textViewSecontOperating.getText().toString();
        String operanding = textViewOperator.getText().toString();
        if (!fisrt.isEmpty() && !secont.isEmpty() && !operanding.isEmpty()) {
            double firstNumber = Double.parseDouble(fisrt);
            double secontNumber = Double.parseDouble(secont);
            switch (textViewOperator.getText().toString()) {
                case "+":
                    textViewSecontOperating.setText(secontNumber + firstNumber + "");
                    textViewOperator.setText("");
                    textViewFirtsOperating.setText("") ;
                    break;
                case "-":
                    textViewSecontOperating.setText(secontNumber - firstNumber + "");
                    textViewOperator.setText("");
                    textViewFirtsOperating.setText("");
                    break;
                case "x":
                    textViewSecontOperating.setText(secontNumber * firstNumber + "");
                    textViewOperator.setText("");
                    textViewFirtsOperating.setText("");
                    break;
                case "/":
                    textViewSecontOperating.setText(secontNumber / firstNumber + "");
                    textViewOperator.setText("");
                    textViewFirtsOperating.setText("");
                    break;
            }
        }
    }
}
