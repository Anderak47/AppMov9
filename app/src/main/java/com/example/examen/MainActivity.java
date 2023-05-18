package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    private int numeroAleatorioJugador1;
    private int numeroAleatorioJugador2;
    private int contadorClics = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView ale1 = findViewById(R.id.textAle1);
        TextView ale2 = findViewById(R.id.textAle2);
        TextView result = findViewById(R.id.textResult);

        Button btnGenerarJugador = findViewById(R.id.btnCambiar);
        Button reset = findViewById(R.id.btnReset);
        reset.setOnClickListener(v ->{
            ale1.setText("");
            ale2.setText("");
            result.setText("Result");
            btnGenerarJugador.setText("jugador1");

        });
        btnGenerarJugador.setOnClickListener(v -> {

            contadorClics++; // Incrementa el contador de clics

            if (contadorClics == 1) {
                btnGenerarJugador.setText("jugador1");
                numeroAleatorioJugador1 = generarNumeroAleatorio(1, 10);
                ale1.setText(String.valueOf(numeroAleatorioJugador1));
            } else if (contadorClics == 2) {
                btnGenerarJugador.setText("jugador2");
                numeroAleatorioJugador2 = generarNumeroAleatorio(1, 10);
                ale2.setText(String.valueOf(numeroAleatorioJugador2));
                contadorClics = 0; // Reinicia el contador de clics para el próximo ciclo

                // Comparar los números aleatorios y mostrar el resultado
                if (numeroAleatorioJugador1 < numeroAleatorioJugador2) {
                    result.setText("Jugador 2 gana");
                } else if (numeroAleatorioJugador1 > numeroAleatorioJugador2) {
                    result.setText("Jugador 1 gana");
                } else {
                    result.setText("Empate");
                }

            }
        });
    }
    private int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}