package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class HelloWorld extends Activity
{
    private Button mCalculateButton;
    private EditText mWattText;
    private EditText mKWhText;
    private TextView mCostPerYearText;
    private TextView mCostPerDayText;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
	setContentView(R.layout.main_layout);

	mCalculateButton = (Button)findViewById(R.id.calculate_button);
	mCostPerYearText = (TextView)findViewById(R.id.cost_per_year_text);
	mCostPerDayText = (TextView)findViewById(R.id.cost_per_day_text);
	mWattText = (EditText)findViewById(R.id.watt_text);
	mKWhText = (EditText)findViewById(R.id.kilowatt_hour_text);

	mCalculateButton.setOnClickListener(mCalculateClickListener);
    }

    private View.OnClickListener mCalculateClickListener = new View.OnClickListener() {
        public void onClick(View v) {
	    // todo: use BigDecimal instead of double for money values
	    double costPerDay = Double.valueOf(mWattText.getText().toString()) / 1000
		* Double.valueOf(mKWhText.getText().toString()) * 24;
	    double costPerYear = costPerDay * 365;

	    mCostPerDayText.setText(formatCurrency(costPerDay) + " Per Day");
	    mCostPerYearText.setText(formatCurrency(costPerYear)+ " Per Year");
        }
    };

    private String formatCurrency(double money) {
	// lifted from the internets
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(money);
    }
}
