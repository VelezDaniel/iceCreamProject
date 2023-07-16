package com.example.icecreamprojectv2.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.icecreamprojectv2.ForgotPass;
import com.example.icecreamprojectv2.R;

import java.util.HashMap;
import java.util.Map;


public class Login extends AppCompatActivity {
    //private String idUsuario, nombres, usuario, email, telefono, rol, estado;
    //private String[] dataUser;

    private String user, contrasena;
    private EditText document;
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

        document = findViewById(R.id.edtDoc);
        password = findViewById(R.id.Text2pass);
        btnIngreso = findViewById(R.id.btnContinuar);
        btnRegistro = findViewById(R.id.btnRegister);
        showPassword = findViewById(R.id.imgBtnvisibility);
        btnForgot = findViewById(R.id.btnOlvidar);

        //Evento btn ingresar -----------------
        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doc = document.getText().toString();
                String pass = password.getText().toString();
                if (!doc.isEmpty() && !pass.isEmpty()) {
                    validarUsuario("https://helarticoproject.000webhostapp.com/apiicedreamproject/autenticar.php");
                } else {
                    Toast.makeText(Login.this, "Completa todos los campos para continuar", Toast.LENGTH_SHORT).show();
                }
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
                Intent intent2 = new Intent(Login.this, ForgotPass.class);
                startActivity(intent2);
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

    //VALIDACION DE USUARIO BASE DE DATOS 000WEBHOST
    private void validarUsuario(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent seguir = new Intent(Login.this, MainActivity.class);
                    startActivity(seguir);
                    //overridePendingTransition(R.anim.to_left, R.anim.from_right);
                }else{
                    Toast.makeText(Login.this, "Usuario y contraseña incorrecta", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Nullable

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>parametros= new HashMap<String,String>();
                parametros.put("texto1",document.getText().toString());
                parametros.put("texto2",password.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestqueve = Volley.newRequestQueue(this);
        requestqueve.add(stringRequest);
    }
}