package com.awesome.alikhundmiri.curden;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

import static android.os.SystemClock.sleep;

/**
 * Created by alikhundmiri on 06/11/16.
 */
public class second_activity extends Fragment {

    private AdView mAdView;

    TextView summation;
    EditText et_1000;
    EditText et_500;
    EditText et_2000;
    EditText et_100;
    EditText et_50;
    EditText et_20;
    EditText et_10;
    EditText et_5;
    EditText et_1;
    Button activate_two;

    int den[] = {
            1000,
            500,
            200,
            100,
            50,
            20,
            10,
            2,
            1
    };

    int totalNotes = 0;
    int count = 0;

    int ot;
    int fh;
    int ttt;
    int oh;
    int fifty;
    int tt;
    int ten;
    int five;
    int one;

    String txt_1000;
    String txt_500;
    String txt_2000;
    String txt_100;
    String txt_50;
    String txt_20;
    String txt_10;
    String txt_5;
    String txt_1;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public second_activity() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static second_activity newInstance(int sectionNumber) {
        second_activity fragment = new second_activity();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.counter, container, false);
        summation = (TextView) rootView.findViewById(R.id.tv_NumberText);
        et_1 = (EditText) rootView.findViewById(R.id.et_1);
        et_5 = (EditText) rootView.findViewById(R.id.et_5);
        et_10 = (EditText) rootView.findViewById(R.id.et_10);
        et_20 = (EditText) rootView.findViewById(R.id.et_20);
        et_50 = (EditText) rootView.findViewById(R.id.et_50);
        et_100 = (EditText) rootView.findViewById(R.id.et_100);
        et_500 = (EditText) rootView.findViewById(R.id.et_500);
        et_1000 = (EditText) rootView.findViewById(R.id.et_1000);
        et_2000 = (EditText) rootView.findViewById(R.id.et_2000);
        activate_two = (Button) rootView.findViewById(R.id.activate_2);


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(getActivity(), "ca-app-pub-7313204296797742~4607977948");

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) rootView.findViewById(R.id.ad_view);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("F9DCC53EB82B5C057D8374860A5AFCC0") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("F9DCC53EB82B5C057D8374860A5AFCC0")
                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);

        et_2000.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {

                et_1000.requestFocus();
            }
        });
        et_1000.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                et_500.requestFocus();
            }
        });
        et_500.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                et_100.requestFocus();
            }
        });
        et_100.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                et_50.requestFocus();
            }
        });
        et_50.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                et_20.requestFocus();
            }
        });
        et_20.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                et_10.requestFocus();
            }
        });
        et_10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                et_5.requestFocus();
            }
        });
        et_5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                et_1.requestFocus();
            }
        });
        et_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {
//                et_1000.requestFocus();
            }
        });

        activate_two.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txt_2000 = (et_2000.getText().toString());
                        txt_1000 = (et_1000.getText().toString());
                        txt_500 = (et_500.getText().toString());
                        txt_100 =(et_100.getText().toString());
                        txt_50 = (et_50.getText().toString());
                        txt_20 = (et_20.getText().toString());
                        txt_10 = (et_10.getText().toString());
                        txt_5 = (et_5.getText().toString());
                        txt_1 = (et_1.getText().toString());

                        if((txt_1.matches(""))&&(txt_5.matches(""))&&(txt_10.matches(""))&&(txt_20.matches(""))&&(txt_50.matches(""))&&(txt_100.matches(""))&&(txt_2000.matches(""))&&(txt_500.matches(""))&&(txt_1000.matches(""))){
                            Toast.makeText(getActivity(), "Please enter Atleast one Blank", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            calculate();
                        }
                    }
                }
        );
        return rootView;
    }

    public void calculate(){

        // check all blanks are filled
        // any blank with null or zero should effect the algorithm
        // add a bit of delay before shifting to next blank!

        int empty = 0;
        ttt = Integer.parseInt(et_2000.getText().toString());
        ot = Integer.parseInt(et_1000.getText().toString());
        fh = Integer.parseInt(et_500.getText().toString());
        oh = Integer.parseInt(et_100.getText().toString());
        fifty = Integer.parseInt(et_50.getText().toString());
        tt = Integer.parseInt(et_20.getText().toString());
        ten = Integer.parseInt(et_10.getText().toString());
        five = Integer.parseInt(et_5.getText().toString());
        one = Integer.parseInt(et_1.getText().toString());

        int sumproduct;
        String sumproduct_format;
        sumproduct = (ot*1000)+(fh*500)+(ttt *2000)+(oh*100)+(fifty*50)+(tt*20)+(ten*10)+(five *5)+(one);
        DecimalFormat formatter = new DecimalFormat("###,##,##,###");
        sumproduct_format = formatter.format(sumproduct);
        summation.setText(sumproduct_format);

    }
}

