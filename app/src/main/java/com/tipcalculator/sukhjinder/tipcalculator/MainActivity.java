package com.tipcalculator.sukhjinder.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    double val = 0;
    double percent = 0;
    double Tip = 0 ;
    int numberOfPeople = 0;
    double totalVal = 0;
    double TotalPerPerson = 0;

    TextView value;
    TextView percentage;
    TextView total;
    TextView tip;
    TextView numOfPeople;
    TextView totalPerPerson;
    Button calcButton;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Tip Calculator");

        value = (TextView) findViewById(R.id.value);
        percentage = (TextView) findViewById(R.id.tipPercentage);
        total = (TextView) findViewById(R.id.Total);
        tip = (TextView) findViewById(R.id.tip);
        numOfPeople = (TextView) findViewById(R.id.numOfPeople);
        totalPerPerson = (TextView) findViewById(R.id.totalPerPerson);
        calcButton = (Button) findViewById(R.id.CalcButton);

    }


    public void calculate(View v) {

        hideKeyboard(this);

        if(value.getText().toString().equals("") | percentage.getText().toString().equals("") | numOfPeople.getText().toString().equals("") )
        {
            Toast.makeText(getApplicationContext(),"Enter all Values", Toast.LENGTH_SHORT).show();
        }

        else{
            val = Double.parseDouble(value.getText().toString());
            percent = Double.parseDouble(percentage.getText().toString());
            numberOfPeople = Integer.parseInt(numOfPeople.getText().toString());
            Tip = (val * percent / 100);
            totalVal = ((val * percent) / 100 + val);
            TotalPerPerson = (totalVal / numberOfPeople);
            total.setText("$ " + String.valueOf(round(totalVal)));
            tip.setText("$ " + String.valueOf(round(Tip)));
            totalPerPerson.setText("$ " + round(TotalPerPerson));
        }
    }


    public void amountDueUp(View view)
    {
        if(value.getText().toString().equals(""))
        {
            value.setText(String.valueOf(0.0));
        }
        else {
        val = Double.parseDouble(value.getText().toString());
        if(val>=0)
            val++;
        value.setText(String.valueOf(val));
        }
    }

    public void amountDueDown(View view)
    {
        if(value.getText().toString().equals(""))
        {
            value.setText(String.valueOf(0.0));
        }
        else
        {
            val = Double.parseDouble(value.getText().toString());
            if (val > 0)
                val--;
            value.setText(String.valueOf(val));
        }
    }

    public void tipUp(View view)
    {
        if(percentage.getText().toString().equals("")){
            percentage.setText(String.valueOf(0.0));
        }
        else {
            percent = Double.parseDouble(percentage.getText().toString());
            if (percent >= 0)
                percent++;
            percentage.setText(String.valueOf(percent));
        }
    }

    public void tipDown(View view)
    {
        if(percentage.getText().toString().equals("")){
            percentage.setText(String.valueOf(0.0));
        }
        else {
            percent = Double.parseDouble(percentage.getText().toString());
            if (percent > 0)
                percent--;
            percentage.setText(String.valueOf(percent));
        }
    }

    public void numUp (View view)
    {
        if(numOfPeople.getText().toString().equals(""))
        {
            numOfPeople.setText(String.valueOf("1"));
        }
        if(numberOfPeople>=0)
        {
            numberOfPeople++;
        }
        numOfPeople.setText(String.valueOf(numberOfPeople));
    }

    public void numDown(View view)
    {
        if(numOfPeople.getText().toString().equals(""))
        {
            numOfPeople.setText(String.valueOf("1"));
        }
        if(numberOfPeople>1)
        {
            numberOfPeople--;
        }
        numOfPeople.setText(String.valueOf(numberOfPeople));
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

    public static void hideKeyboard(Activity activity)
    {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    double round(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }
}
