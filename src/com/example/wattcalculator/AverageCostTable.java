package com.example.wattcalculator;

import java.util.HashMap;

public class AverageCostTable
{
    private HashMap<String, String> costTable;
    static private String[] costArray = {
	"CT", "0.1805",
	"ME", "0.1575",
	"MA", "0.1466",
	"NH", "0.1633",
	"RI", "0.1621",
	"VT", "0.1573",
	"NJ", "0.1612",
	"NY", "0.1731",
	"PA", "0.1253",
	"IL", "0.1033",
	"IN", "0.0917",
	"MI", "0.1211",
	"OH", "0.1005",
	"WI", "0.1235",
	"IA", "0.0927",
	"KS", "0.0943",
	"MN", "0.1028",
	"MO", "0.0795",
	"NE", "0.0777",
	"ND", "0.0695",
	"SD", "0.0833",
	"DE", "0.1294",
	"DC", "0.1362",
	"FL", "0.1149",
	"GA", "0.0971",
	"MD", "0.1322",
	"NC", "0.0941",
	"SC", "0.1017",
	"VA", "0.0961",
	"WV", "0.0878",
	"AL", "0.1028",
	"KY", "0.0847",
	"MS", "0.0962",
	"TN", "0.0928",
	"AR", "0.0785",
	"LA", "0.0801",
	"OK", "0.0803",
	"TX", "0.1092",
	"AZ", "0.0983",
	"CO", "0.1036",
	"ID", "0.0785",
	"MT", "0.091",
	"NV", "0.116",
	"NM", "0.0965",
	"UT", "0.0816",
	"WY", "0.0833",
	"CA", "0.1578",
	"OR", "0.0924",
	"WA", "0.0809",
	"AK", "0.164",
	"HI", "0.3013",
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