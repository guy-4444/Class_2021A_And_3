package com.classy.class_2021a_and_3.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.classy.class_2021a_and_3.R;
import com.classy.class_2021a_and_3.objects.Record;
import com.classy.class_2021a_and_3.objects.TopTen;
import com.google.gson.Gson;

import java.util.Random;

import static com.classy.class_2021a_and_3.Constants.SP_FILE;

public class MainActivity extends Activity_Base {

    private ImageView main_IMG_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isDoubleBackPressToClose = true;

        main_IMG_background = findViewById(R.id.main_IMG_background);

        Glide
                .with(this)
                .load(R.drawable.img_poker_table)
                .into(main_IMG_background);

        SharedPreferences prefs = getSharedPreferences(SP_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        for (int i = 0; i < 10; i++) {
            editor.putString("name"+i, "guy"+i);
            editor.putInt("score"+i, new Random().nextInt(100));
        }
        editor.apply();

        for (int i = 0; i < 12; i++) {
            String name = prefs.getString("name"+i, "NA");
            int idName = prefs.getInt("score"+i, -1);

            Log.d("pttt", i + ". name: " + name + "   " + idName);
        }


        TopTen topTen = generateMockData();

        Gson gson = new Gson();
        String ttJson = gson.toJson(topTen);
        Log.d("pttt", "ttJson = " + ttJson);
        TopTen tt2 = gson.fromJson(ttJson, TopTen.class);

        Log.d("pttt", "topTen size = " + topTen.getRecords().size());
    }

    private TopTen generateMockData() {
        TopTen topTen = new TopTen();

        for (int i = 0; i < 10; i++) {
            Record record = new Record()
                    .setDate(System.currentTimeMillis() - (1000l * 60 * 60 * 24 * i))
                    .setName("Or" + i)
                    .setScore(new Random().nextInt(26));

            topTen.getRecords().add(record);
        }
        return topTen;
    }

}