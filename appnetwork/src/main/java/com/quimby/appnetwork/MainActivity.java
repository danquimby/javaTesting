package com.quimby.appnetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
//http://testapi.odezhda-master.ru/images/catalog_4/554130d54c5c3.jpg
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imId);

        new ImageLoader("catalog_4/554130d54c5c3.jpg",imageView,this);
    }
}
