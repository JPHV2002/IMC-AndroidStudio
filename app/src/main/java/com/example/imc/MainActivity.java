package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText PESO;
    private EditText ALTURA;
    private TextView RESULTADO;
    private TextView CATEGORIA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PESO = findViewById(R.id.Peso);
        ALTURA = findViewById(R.id.Altura);
        RESULTADO = findViewById(R.id.Resultado);
        CATEGORIA = findViewById(R.id.Categoria);
    }

    public int Calcular(View v){
        double peso = 0, altura = 0, imc = 0;
        String res;
        try {
            peso = Double.parseDouble(PESO.getText().toString());
            altura = Double.parseDouble(ALTURA.getText().toString());
            altura = altura / 100;
        }catch (Exception e){
            RESULTADO.setText("Dados Invalidos");
            CATEGORIA.setText("CATEGORIA");
            return 0;
        }
        if (peso != -1) imc = peso/Math.pow(altura,2);
        else imc = 0;

        res = String.format("%.2f", imc);
        RESULTADO.setText("Resultado: " + res);

        validarCategoria(imc);
        return 0;
    }

    private void validarCategoria(double imc){
        if (imc < 18) CATEGORIA.setText("Magro");
        else if (imc >= 18 && imc < 25) CATEGORIA.setText("Normal");
        else if (imc >= 25 && imc < 30) CATEGORIA.setText("Sobrepeso");
        else if (imc >= 30 && imc <35) CATEGORIA.setText("Obesidade I");
        else CATEGORIA.setText("Obesidade II");
    }
}