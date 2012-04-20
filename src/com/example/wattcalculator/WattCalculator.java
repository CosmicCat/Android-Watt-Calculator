package com.example.wattcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import java.text.NumberFormat;
import java.util.HashMap;

public class WattCalculator extends Activity
{
    private Button mCalculateButton;
    private EditText mWattText;
    private EditText mKWhText;
    private TextView mCostPerYearText;
    private TextView mCostPerDayText;
    private AutoCompleteTextView mState;
    private HashMap<String, String> mCostTable;

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
	mState = (AutoCompleteTextView)findViewById(R.id.state_autocomplete);

	mCalculateButton.setOnClickListener(mCalculateClickListener);

        mCostTable = (new AverageCostTable()).getCostTable();

	ArrayAdapter<String> adapter =
	    new ArrayAdapter<String>(this, R.layout.list_item,
				     (String[])mCostTable.keySet().toArray(new String[0]));
	mState.setAdapter(adapter);
	setupStateListener();
    }

    private void setupStateListener() {
	mState.addTextChangedListener(new TextWatcher() {
		public void afterTextChanged(Editable s) {
		    String stateText = mState.getText().toString();
		    String kwhText = mCostTable.get(stateText);
		    if (kwhText != null) {
			mKWhText.setText(kwhText);
		    }
		}
		public void onTextChanged(CharSequence s, int start, int before, int count) {

		}
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		}
	    });
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