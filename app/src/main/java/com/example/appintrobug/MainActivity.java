package com.example.appintrobug;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.appintro.AppIntro;

public class MainActivity  extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        addSlide(Frag2.newInstance(Color.parseColor("#FFFFFF")));
        addSlide(Frag1.newInstance(Color.parseColor("#FFFFFF")));

    }

    public void go(View view) {
        goToNextSlide(false);
    }
}