package com.quimby.appnetwork;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Quimby on 16.09.2016.
 */

public class ImageLoader {
    private final String urlServer = "http://testapi.odezhda-master.ru";
    private final String added = "/images/";
    public ImageLoader(String urlImage, ImageView imageView, Context context)
    {
        if (urlImage.contains("images"))
            Picasso.with(context).load(urlServer + "/" + urlImage).into(imageView);
        else
            Picasso.with(context).load(urlServer + added + urlImage).into(imageView);
    }
}
