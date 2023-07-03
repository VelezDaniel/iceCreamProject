package com.example.icecreamprojectv2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Functions {

    public Functions() {
    }

    /*
    public void animationRotateIce(ImageView img, final Class<?> targetActivity){
        Context context = img.getContext();

        Animation anim1 = AnimationUtils.loadAnimation(targetActivity, R.anim.rotacionimglenta);
    }*/

    //Permite volver a la activity anterior (requiere imageButton y clase final)
    public void handleArrowBackClickToLogin(ImageButton imgArrow, final Class<?> targetActivity){
        imgArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = imgArrow.getContext();
                Intent intent = new Intent(context, targetActivity);
                context.startActivity(intent);
            }
        });
    }


}