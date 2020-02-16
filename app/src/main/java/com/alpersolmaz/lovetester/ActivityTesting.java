package com.alpersolmaz.lovetester;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
//
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;

public class ActivityTesting extends AppCompatActivity {
//    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_love_testing);

        final ImageView button = (ImageView) findViewById(R.id.button); // Test button
        final EditText your_name = (EditText) findViewById(R.id.you_edittext); // Your name EditText
        final EditText your_love_name = (EditText) findViewById(R.id.yourlove_edittext); // Your love name EditText

//        adLoad_Banner(); // Display banner

        // Do this when the button is clicked to test.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_your_name = your_name.getText().toString(); // Get your name from EditText
                String get_your_love_name = your_love_name.getText().toString(); // Get your love name from EditText
                int love_score = calculateLove(get_your_name,get_your_love_name); // Calculate your love score via the "calculateLove" method

                // If your name or your love name areas are empty.
                if(get_your_name.isEmpty() || get_your_love_name.isEmpty()){
                    Toast.makeText(ActivityTesting.this, getResources().getString(R.string.empty_form_message), Toast.LENGTH_SHORT).show(); // Error message
                }else {
                    Intent transition = new Intent(getApplicationContext(), ActivityDisplayResults.class);
                    transition.putExtra("love_score", love_score);
                    transition.putExtra("your_name", get_your_name);
                    transition.putExtra("your_love_name", get_your_love_name);
                    startActivity(transition); // Switch to result page
                }
                //////////////////////////////////////////////////

            }
        });
        ////////////////////////////////////////////

    }


    // Function of calculating love score.
    public int calculateLove(String your_name,String your_love_name) {
        your_name = your_name.toUpperCase();
        int your_name_length = your_name.length();

        your_love_name = your_love_name.toUpperCase();
        int your_love_name_length = your_love_name.length();

        int loveCount=0;

        for (int i = 0; i < your_name_length; i++) {

            String letter1 = your_name.substring(i,i+1);

            if (letter1.equals("L")){loveCount+=2;}
            if (letter1.equals("O")){loveCount+=2;}
            if (letter1.equals("V")){loveCount+=2;}
            if (letter1.equals("E")){loveCount+=2;}
            if (letter1.equals("Y")){loveCount+=3;}
            if (letter1.equals("O")){loveCount+=1;}
            if (letter1.equals("U")){loveCount+=3;}
        }


        for (int i = 0; i < your_love_name_length; i++) {

            String letter1 = your_love_name.substring(i,i+1);

            if (letter1.equals("L")){loveCount+=2;}
            if (letter1.equals("O")){loveCount+=2;}
            if (letter1.equals("V")){loveCount+=2;}
            if (letter1.equals("E")){loveCount+=2;}
            if (letter1.equals("Y")){loveCount+=3;}
            if (letter1.equals("O")){loveCount+=1;}
            if (letter1.equals("U")){loveCount+=3;}
        }


        int result = 0;

        if (loveCount> 0) {result=  5-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 2) {result=  10-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 4) {result=  20-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 6) {result=  30-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 8) {result=  40-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 10) {result=  50-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 12) {result=  60-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 14) {result=  70-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 16) {result=  80-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 18) {result=  90-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 20) {result=  100-((your_name_length+your_love_name_length)/2);}
        if (loveCount> 22) {result=  110-((your_name_length+your_love_name_length)/2);}


        if (result < 0) {result=0;}
        if (result>99){result=99;}

        return result;


    }
    //////////////////////////////////////////////////

    // Function to show banner.
//    private void adLoad_Banner() {
//        adView = new AdView(this);
//        adView.setAdSize(AdSize.SMART_BANNER);
//        adView.setAdUnitId(getString(R.string.advertising_id_banner));
//        LinearLayout layout = (LinearLayout) findViewById(R.id.banner_bottom_ly);
//        layout.addView(adView);
//
//        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
//
//        adView.loadAd(adRequest);
//
//    }
    //////////////////////////////////////////////////

}
