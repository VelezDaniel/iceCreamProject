package com.example.icecreamprojectv2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.icecreamprojectv2.R;
import com.example.icecreamprojectv2.fr_forgotPass;


public class Login extends AppCompatActivity {
    private String idUsuario, nombres, usuario, email, telefono, rol, estado;
    private String[] dataUser;

    private String user, contrasena;
    private EditText correo;
    private EditText password;
    private Button btnIngreso;
    private Button btnRegistro;
    private ImageButton arrowBack;

    //Button hiden password
    private boolean passVisible = false;
    private ImageButton showPassword; //visibility img

    private Button btnForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correo = findViewById(R.id.edtDoc);
        password = findViewById(R.id.Text2pass);
        btnIngreso = findViewById(R.id.btnContinuar);
        btnRegistro = findViewById(R.id.btnRegister);
        showPassword = findViewById(R.id.imgBtnvisibility);
        btnForgot = findViewById(R.id.btnOlvidar);

        //Evento btn ingresar -----------------
        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = correo.getText().toString();
                contrasena = password.getText().toString();
                Toast.makeText(Login.this, "Hola Usuario " + user, Toast.LENGTH_SHORT).show();
                //overridePendingTransition(R.anim.to_left, R.anim.from_right);
            }
        });

        //OCULTACION DE CONTRASEÑA------
        showPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passVisible){
                    //Si la contraseña es visible, ocultarla
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showPassword.setImageResource(R.drawable.baseline_visibility_off_24);
                    //passVisible = false;
                }else{
                    //Si no está visible la contraseña, mostrarla
                    //password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    password.setTransformationMethod(null);
                    showPassword.setImageResource(R.drawable.baseline_visibility_24);
                    //passVisible = true;
                }
                passVisible = !passVisible; //Invierte el valor del Boolean
            }
        });

        //Inicio activity RECUPERAR CONTRASEÑA---------------
        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr_forgotPass fr_forgotPass1 = new fr_forgotPass();
                FragmentTransaction frT = getSupportFragmentManager().beginTransaction();
                frT.replace(R.id.constraintLogin,fr_forgotPass1);

                frT.commit();
            }
        });

        //Inicio de la activity de Registro de nuevos usuarios------------////
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Login.this, RegistroUser.class);
                startActivity(intent1);
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

    }
}