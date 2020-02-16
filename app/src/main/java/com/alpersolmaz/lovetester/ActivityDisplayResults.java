package com.alpersolmaz.lovetester;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;

public class ActivityDisplayResults extends AppCompatActivity {
//    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_display_result);

        TextView result_message_tv = (TextView) findViewById(R.id.result_message); // ActivityDisplayResults message TextView
        TextView love_point_tv = (TextView) findViewById(R.id.love_point); // Love score TextView
        LinearLayout share = (LinearLayout) findViewById(R.id.share_ly); // Share button

//        adLoad_Banner(); // Display banner

        final String your_name = getIntent().getStringExtra("your_name"); // Get your name from ActivityTesting page.
        final String your_love_name = getIntent().getStringExtra("your_love_name"); // Get your love name from ActivityTesting page.
        final int love_point = getIntent().getIntExtra("love_score",0); // Get your love score from ActivityTesting page.

        result_message_tv.setText(getString(R.string.result_message, your_name, your_love_name)); // Print your result message.
        love_point_tv.setText(String.valueOf(love_point)); // Print your love score.

        // When you click on the share button
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_message, your_love_name, "%"+love_point)); // Message to be shared
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        //////////////////////////////////////




    }

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
    //////////////////////////////////////////

}
