package com.camavilca.orlando.practica.vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.camavilca.orlando.practica.R;
import com.camavilca.orlando.practica.repositorio.RepositorioUsuario;
import com.camavilca.orlando.practica.vistas.MainActivity;

public class Registrar extends AppCompatActivity {

    EditText usuario;
    EditText nombre;
    EditText correo;
    EditText contra;
    Button registrar;
    Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        usuario = (EditText)findViewById(R.id.registro_usuario);
        nombre = (EditText)findViewById(R.id.registro_nombre);
        correo = (EditText)findViewById(R.id.registro_correo);
        contra = (EditText)findViewById(R.id.registro_contraseña);
    }

    public void Accion(View view) {
        switch (view.getId()){
            case R.id.regitro_btn_registrar:
                RegistrarUsuario();
                break;

            case R.id.registro_btn_atras:
                atrasInicioSesion();
                break;
        }
    }

    private void RegistrarUsuario() {
        String usu =  usuario.getText().toString();
        String nom =  nombre.getText().toString();
        String cor = correo.getText().toString();
        String cont = contra.getText().toString();
        if(usu.isEmpty() || nom.isEmpty() || cor.isEmpty() || cont.isEmpty() ){
            Toast.makeText(this,"LOS CAMPOS SON REQUERIDOS",Toast.LENGTH_LONG).show();
            return;
        }
        RepositorioUsuario.create(usu,nom,cor,cont);
        limpiar();
    }

    private void limpiar() {
        usuario.setText("");
        nombre.setText("");
        correo.setText("");
        contra.setText("");
    }

    private void atrasInicioSesion() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
