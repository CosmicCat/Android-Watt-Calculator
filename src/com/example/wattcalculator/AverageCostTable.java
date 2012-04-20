package com.example.wattcalculator;

import java.util.HashMap;

public class AverageCostTable
{
    private HashMap<String, String> costTable;
    static private String[] costArray = {
        "CT", "18.05",
        "ME", "15.75",
        "MA", "14.66",
        "NH", "16.33",
        "RI", "16.21",
        "VT", "15.73",
        "NJ", "16.12",
        "NY", "17.31",
        "PA", "12.53",
        "IL", "10.33",
        "IN", "9.17",
        "MI", "12.11",
        "OH", "10.05",
        "WI", "12.35",
        "IA", "9.27",
        "KS", "9.43",
        "MN", "10.28",
        "MO", "7.95",
        "NE", "7.77",
        "ND", "6.95",
        "SD", "8.33",
        "DE", "12.94",
        "DC", "13.62",
        "FL", "11.49",
        "GA", "9.71",
        "MD", "13.22",
        "NC", "9.41",
        "SC", "10.17",
        "VA", "9.61",
        "WV", "8.78",
        "AL", "10.28",
        "KY", "8.47",
        "MS", "9.62",
        "TN", "9.28",
        "AR", "7.85",
        "LA", "8.01",
        "OK", "8.03",
        "TX", "10.92",
        "AZ", "9.83",
        "CO", "10.36",
        "ID", "7.85",
        "MT", "9.1",
        "NV", "11.6",
        "NM", "9.65",
        "UT", "8.16",
        "WY", "8.33",
        "CA", "15.78",
        "OR", "9.24",
        "WA", "8.09",
        "AK", "16.4",
        "HI", "30.13",
    };

    public AverageCostTable() {
	costTable = new HashMap();
	for (int i=0; i<costArray.length; i+=2) {
	    costTable.put(costArray[i], costArray[i+1]);
	}
    }

    public HashMap getCostTable() {
	return costTable;
    }
}