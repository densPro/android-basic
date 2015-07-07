package com.example.denis.calculate;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

    private Button[] btnNumbers;
    private Button[] btnOperators;
    private static final int BUTTON_NUMBERS_SIZE = 11;
    private static final int BUTTON_OPERATORS_SIZE = 4;
    private TextView textViewFirtsOperating;
    private TextView textViewSecontOperating;
    private TextView textViewOperator;
    private Button btn_equals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        for (Button btn : btnNumbers) {
            btn.setOnClickListener(new NumbersListener(btnNumbers, textViewFirtsOperating,textViewSecontOperating, textViewOperator));
        }
        for (Button btn : btnOperators) {
            btn.setOnClickListener(new OperatorsListener(btnOperators, textViewFirtsOperating,textViewSecontOperating, textViewOperator));
        }

        btn_equals.setOnClickListener(new EqualsListener(textViewFirtsOperating,textViewSecontOperating,textViewOperator));
    }

    private void initComponents() {
        //number buttons
        btnNumbers = new Button[BUTTON_NUMBERS_SIZE];
        btnOperators = new Button[BUTTON_OPERATORS_SIZE];
        btnNumbers[0] = (Button)findViewById(R.id.btn_0);
        btnNumbers[1] = (Button)findViewById(R.id.btn_1);
        btnNumbers[2] = (Button)findViewById(R.id.btn_2);
        btnNumbers[3] = (Button)findViewById(R.id.btn_3);
        btnNumbers[4] = (Button)findViewById(R.id.btn_4);
        btnNumbers[5] = (Button)findViewById(R.id.btn_5);
        btnNumbers[6] = (Button)findViewById(R.id.btn_6);
        btnNumbers[7] = (Button)findViewById(R.id.btn_7);
        btnNumbers[8] = (Button)findViewById(R.id.btn_8);
        btnNumbers[9] = (Button)findViewById(R.id.btn_9);
        btnNumbers[10] = (Button)findViewById(R.id.btn_00);
        btnOperators[0] = (Button)findViewById(R.id.btn_plus);
        btnOperators[1] = (Button)findViewById(R.id.btn_rest);
        btnOperators[2] = (Button)findViewById(R.id.btn_multiply);
        btnOperators[3] = (Button)findViewById(R.id.btn_divide);
        //text views
        textViewFirtsOperating = (TextView) findViewById(R.id.textViewFirtsOperating);
        textViewSecontOperating = (TextView) findViewById(R.id.textViewSecontOperating);
        textViewOperator = (TextView) findViewById(R.id.textViewOperator);

        //equals button
        btn_equals = (Button)findViewById(R.id.btn_equals);
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
