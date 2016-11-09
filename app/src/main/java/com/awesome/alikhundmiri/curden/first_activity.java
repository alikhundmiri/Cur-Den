package com.awesome.alikhundmiri.curden;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


/**
 * Created by alikhundmiri on 06/11/16.
 */
public class first_activity extends Fragment {

    private AdView mAdView;

    Button activate_one;
    EditText input;
    TextView hint_1;
    TextView tv_2000;
    TextView tv_1000;
    TextView tv_500;
    TextView tv_100;
    TextView tv_50;
    TextView tv_20;
    TextView tv_10;
    TextView tv_5;
    TextView tv_1;
    TextView currency;
    TextView numberlimit;
    ToggleButton tb_2000;
    ToggleButton tb_1000;
    ToggleButton tb_500;
    Button refresh;

    int den[] = {
            2000,
            1000,
            500,
            100,
            50,
            20,
            10,
            5,
            1
    };

    int totalNotes = 0;
    int count = 0;

    String numLimit;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public first_activity() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static first_activity newInstance(int sectionNumber) {
        first_activity fragment = new first_activity();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.denomination, container, false);
        input = (EditText) rootView.findViewById(R.id.et_NumberText);
        tv_1 = (TextView) rootView.findViewById(R.id.tv_1);
        tv_5 = (TextView) rootView.findViewById(R.id.tv_5);
        tv_10 = (TextView) rootView.findViewById(R.id.tv_10);
        tv_20 = (TextView) rootView.findViewById(R.id.tv_20);
        tv_50 = (TextView) rootView.findViewById(R.id.tv_50);
        tv_100 = (TextView) rootView.findViewById(R.id.tv_100);
        tv_500 = (TextView) rootView.findViewById(R.id.tv_500);
        tv_1000 = (TextView) rootView.findViewById(R.id.tv_1000);
        tv_2000 = (TextView) rootView.findViewById(R.id.tv_2000);
        currency = (TextView) rootView.findViewById(R.id.Currency_label);
        hint_1 = (TextView) rootView.findViewById(R.id.tv_hint);
        activate_one = (Button) rootView.findViewById(R.id.activate_1);
        tb_2000 = (ToggleButton) rootView.findViewById(R.id.tb_twoThousand);
        tb_500 = (ToggleButton) rootView.findViewById(R.id.tb_fiveHundred);
        tb_1000 = (ToggleButton) rootView.findViewById(R.id.tb_thousand);
        numberlimit = (TextView) rootView.findViewById(R.id.numCounter);
        refresh = (Button) rootView.findViewById(R.id.btn_refresh);

        tb_2000.setChecked(true);
        tb_500.setChecked(true);
        tb_1000.setChecked(true);

        hint_1.setVisibility(View.VISIBLE);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(getActivity(), "ca-app-pub-7313204296797742~4607977948");

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) rootView.findViewById(R.id.ad_view);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("F9DCC53EB82B5C057D8374860A5AFCC0"); to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("F9DCC53EB82B5C057D8374860A5AFCC0")
                .build();
        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);


        tb_2000.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked){
                        den[0] = 2000;
                    }
                    else{
                        den[0] = 0;
                    }
                    verify_blank();
                }
            }
        );
        tb_1000.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked){
                        den[1] = 1000;
                    }
                    else{
                        den[1] = 0;
                    }
                    verify_blank();

                }
            }
        );
        tb_500.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked){
                            den[2] = 500;
                        }
                        else{
                            den[2] = 0;
                        }
                        verify_blank();
                    }
                }
        );


        activate_one.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    verify_blank();

                }
            }
        );

        input.addTextChangedListener(new TextWatcher() {
            private String current = "";
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if(charSequence.length()<1){
                    numberlimit.setText("Max Limit 8");
                    currency.setTextColor(getResources().getColor(R.color.color_first_hint));
                    currency.setTypeface(null, Typeface.NORMAL);

                }
                else{
                    currency.setTextColor(getResources().getColor(R.color.color_first));
                    currency.setTypeface(null, Typeface.BOLD);
                    int currentCharacters = Integer.parseInt(String.valueOf(charSequence.length()));
                    int remainingChars = 8-currentCharacters;
                    numLimit = toString().valueOf(remainingChars);
                    numberlimit.setText("Digit Remaining "+ numLimit);


                    if(numLimit.equals("0")){
                        numberlimit.setText("Maximum");
                        Toast.makeText(getActivity(), "You have reached Maximum Limit", Toast.LENGTH_SHORT).show();
                    }
                    verify_blank();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input.getText().length()>1){
                    Toast.makeText(getActivity(), "Amount Cleared", Toast.LENGTH_SHORT).show();
                    calculate_denomination();
                    input.setText("");
                }
                else{
                    input.setHint("cleared");
                }

            }
        });

        return rootView;
    }


    public void verify_blank(){

        {
            String checking = input.getText().toString();
            if (checking.equals("")){
                hint_1.setVisibility(View.VISIBLE);
                hint_1.setText("Please Enter the Amount.");
                //input.requestFocus();
            }
            if (checking.length()>= 9){
                Toast.makeText(getActivity(), "Please Purchase the Full version", Toast.LENGTH_SHORT).show();
            }
            else if ((checking.length()<9) && (checking.length()>0)) {
                calculate_denomination();
            }
        }

    }
    public void calculate_denomination() {

        hint_1.setVisibility(View.GONE);
        tv_1.setText("0");
        tv_5.setText("0");
        tv_10.setText("0");
        tv_20.setText("0");
        tv_50.setText("0");
        tv_100.setText("0");
        tv_500.setText("0");
        tv_1000.setText("0");
        tv_2000.setText("0");
        int amount = Integer.parseInt(input.getText().toString());
        for (int i=0;i<9;i++){
            if (den[i]!=0){
                count = amount/den[i];
                if(i==0){
                    tv_2000.setText(Integer.toString(count));
                }
                if(i==1){
                    tv_1000.setText(Integer.toString(count));
                }
                if(i==2){
                    tv_500.setText(Integer.toString(count));
                }
                if(i==3){
                    tv_100.setText(Integer.toString(count));
                }
                if(i==4){
                    tv_50.setText(Integer.toString(count));
                }
                if(i==5){
                    tv_20.setText(Integer.toString(count));
                }
                if(i==6){
                    tv_10.setText(Integer.toString(count));
                }
                if(i==7){
                    tv_5.setText(Integer.toString(count));
                }
                if(i==8){
                    tv_1.setText(Integer.toString(count));
                }

                totalNotes = totalNotes+count;
                amount = amount%den[i];
            }
            if(den[i]==0){
                amount = amount;
            }
        }
    }
}
