package com.ovalle.practica_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private  EditText txtApellido;
    private Button btnEnviar;
    private RadioGroup rbUsas;
    private  RadioGroup rbRecomiendas;
    private CheckBox cbxNotificaciones;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        btnEnviar = findViewById(R.id.btnEnviar);
        rbUsas = findViewById(R.id.rgUsas);
        rbRecomiendas = findViewById(R.id.rgRecomiendas);
        cbxNotificaciones = findViewById(R.id.cbxNotificaciones);
        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setEnabled(false); //desahabilitar widget en la interfaz al momento de inicar (ratingBar).
        btnEnviar.setEnabled(false); //desahabilitar widget en la interfaz al momento de iniciar (btnEviar).
        rbRecomiendas.setEnabled(false);


        rbUsas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rbSi){
                    ratingBar.setEnabled(true);
                    rbRecomiendas.setEnabled(true);
                }else{
                    ratingBar.setEnabled(false);
                    ratingBar.setRating(0);
                    rbRecomiendas.setEnabled(false);
                }
            }
        });
    }
}
