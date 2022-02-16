package com.example.android.emicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;


import java.lang.Math;

public class MainActivity extends AppCompatActivity {
    double emi = 0;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /* This method is called when the calculate button is called
    * Double.parseDouble used for converting String to Double variable
    * Integer.parseInt used for converting String to int variable

     */
    public void calculate (View view) {

        EditText LoanAmount = (EditText) findViewById(R.id.loan_amount);
        if( LoanAmount.getText().toString().length() == 0 )
        {LoanAmount.setError( "Loan Amount is required" );}
        else {
            double principal = Double.parseDouble(LoanAmount.getText().toString());

            EditText LoanInterest = (EditText) findViewById(R.id.loan_interest);
            if (LoanInterest.getText().toString().length() == 0)
            {LoanInterest.setError("Loan Interest is required!");}
            else {
                double interest = Double.parseDouble(LoanInterest.getText().toString());

                EditText LoanTenure = (EditText) findViewById(R.id.loan_tenure);
                if (LoanTenure.getText().toString().length() == 0)
                {LoanTenure.setError("Loan Tenure is required!");}
                else {
                    int tenure = Integer.parseInt(LoanTenure.getText().toString());

                    double Emi = calculateEmiSummery(principal, interest, tenure, emi);
                    displayMessage(Emi);
                }
            }
        }


    }

    /*This Method is for calulation of EMI

     */

    private double calculateEmiSummery( double LoanAmount, double LoanInterest, int LoanTenure, double emi){
        double messege = emi;
        double intPerMonth = (LoanInterest/12/100);
        messege = (LoanAmount*intPerMonth*((Math.pow((1+intPerMonth),LoanTenure))/(((Math.pow((1+intPerMonth),LoanTenure)))-1)));
        return messege;


    }

    /*
    this Method display the Emi in the emi TextView
    *Math.round is used for round offing the variable
    *Double.toString is used for converting the double variable to string
     */
    private void displayMessage(Double message) {
        double roundEmi = Math.round( message * 100.0 ) / 100.0;
        String stringEmi= Double.toString(roundEmi);
        TextView emiTextView = (TextView) findViewById(R.id.emi);
        emiTextView.setText("₹ " + stringEmi);
    }




}
