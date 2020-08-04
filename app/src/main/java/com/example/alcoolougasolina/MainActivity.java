package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


// desenvolvido por Guilherme Leite.

public class MainActivity extends AppCompatActivity {
    private TextView resultado;
    private EditText entradaAlcool;
    private EditText entradaGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciando o componente pelo id
        resultado = findViewById(R.id.resultado);
        entradaAlcool = findViewById(R.id.editText);
        entradaGasolina = findViewById(R.id.precoGasolina);
    }

    public void calcular(View view) {

        //convertendo view em string
        String precoAlcool = entradaAlcool.getText().toString();
        String precoGasolina = entradaGasolina.getText().toString();


        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados) {
            //convertendo String em Double.
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double divisao = valorAlcool / valorGasolina;

            if (divisao >= 0.7) {
                resultado.setText("É melhor utilizar: Gasolina");
            } else {
                resultado.setText("É melhor utilizar: Álcool");
            }
        } else {
            resultado.setText("Preencha os preços primeiro!");
        }
    }

    //validando campos
    public Boolean validarCampos(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;


        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;

        }
        return camposValidados;

    }
}
