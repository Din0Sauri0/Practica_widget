package com.ovalle.practica_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private  EditText txtApellido;
    private Button btnEnviar;
    private RadioGroup rbUsas;
    private  RadioGroup rbRecomiendas;
    private CheckBox cbxNotificaciones;
    private RatingBar ratingBar;
    private ProgressBar progressBar;

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
        progressBar = findViewById(R.id.progressBar);

        txtApellido.setEnabled(false);
        ratingBar.setEnabled(false); //desahabilitar widget en la interfaz al momento de inicar (ratingBar).
        btnEnviar.setEnabled(false); //desahabilitar widget en la interfaz al momento de iniciar (btnEviar).
        //Desabilitar radio group
        disableRadioGroup();

        /*
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

         */
        txtNombre.setOnKeyListener(new View.OnKeyListener() { // setOnKeyListener por cada letra pesionada se ejecuta el escuchador
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Toast.makeText(MainActivity.this,"Texto: "+txtNombre.getText().toString(),Toast.LENGTH_LONG).show();
                if (txtNombre.getText().toString().length() > 3){
                    txtApellido.setEnabled(true);
                    progressBar.setProgress(20);
                }else{
                    txtApellido.setEnabled(false);
                    txtNombre.setError("Error min 3 caracteres.");
                }
                return false;
            }
        });
        txtApellido.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (txtApellido.getText().toString().length() >= 3){
                    findViewById(R.id.rbNo).setEnabled(true);
                    findViewById(R.id.rbSi).setEnabled(true);
                    progressBar.setProgress(40);
                }else{
                    if (findViewById(R.id.rbSi))
                    progressBar.setProgress(20);
                    txtApellido.setError("Error min 3 caracteres.");
                    rbUsas.clearCheck();
                    findViewById(R.id.rbNo).setEnabled(false);
                    findViewById(R.id.rbSi).setEnabled(false);
                }
                return false;
            }
        });
        rbUsas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbSi){
                    findViewById(R.id.rbNoReco).setEnabled(true);
                    findViewById(R.id.rbSiReco).setEnabled(true);
                    progressBar.setProgress(60);
                }else{
                    findViewById(R.id.rbNoReco).setEnabled(false);
                    findViewById(R.id.rbSiReco).setEnabled(false);
                    ratingBar.setRating(0);
                    rbRecomiendas.clearCheck();
                    progressBar.setProgress(100);
                }
            }
        });
        rbRecomiendas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ratingBar.setEnabled(true);
                progressBar.setProgress(80);
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(progressBar.getProgress() > 0){
                    btnEnviar.setEnabled(true);
                    progressBar.setProgress(100);
                    Toast.makeText(MainActivity.this,"Completado, presione en enviar",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextPage = new Intent(MainActivity.this,resultado.class);
                startActivity(nextPage);
            }
        });
    }


    private void disableRadioGroup(){
        findViewById(R.id.rbNoReco).setEnabled(false);
        findViewById(R.id.rbSiReco).setEnabled(false);

        findViewById(R.id.rbNo).setEnabled(false);
        findViewById(R.id.rbSi).setEnabled(false);
    }


}
