package com.example.icecreamprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        ImageView logo = findViewById(R.id.logoImage);
        TextView title = findViewById(R.id.textHelart);

        logo.setAnimation(animacion1);
        title.setAnimation(animacion2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
        contar();
    }


    public void contar(){ //Sirve para crear un contador
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                FinalizarSplash();
            }
        }, 3000); //  miliSegundos
    }
    //Este contador es para que pase del splash al login
    public void FinalizarSplash(){ //Se tumba el splash para que ingrese otra Activity (en este caso Login)
        Intent siguiente = new Intent(Splash.this, Login.class);
        startActivity(siguiente);
        finish(); //Finaliza el activity splash
    }
}