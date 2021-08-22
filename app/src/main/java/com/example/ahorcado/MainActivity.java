package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtPrincipal;
    TextView tvLetralCorrecta1, tvLetralCorrecta2, tvLetralCorrecta3,tvLetralCorrecta4, tvLetraAhorcado1, tvLetraAhorcado2, tvLetraAhorcado3, tvLetraAhorcado4, tvLetraAhorcado5, tvLetraAhorcado6, tvLetraAhorcado7, tvLetraAhorcado8, tvResultado;
    Button btnVerificar, btnLimpiar;
    int contador=0;
    int contadorBuenas=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPrincipal = findViewById(R.id.edtPrincipal);
        tvLetralCorrecta1 = findViewById(R.id.tvLetraCorrecta1);
        tvLetralCorrecta2 = findViewById(R.id.tvLetraCorrecta2);
        tvLetralCorrecta3 = findViewById(R.id.tvLetraCorrecta3);
        tvLetralCorrecta4 = findViewById(R.id.tvLetraCorrecta4);
        tvLetraAhorcado1 = findViewById(R.id.tvLetraAhorcado1);
        tvLetraAhorcado2 = findViewById(R.id.tvLetraAhorcado2);
        tvLetraAhorcado3 = findViewById(R.id.tvLetraAhorcado3);
        tvLetraAhorcado4 = findViewById(R.id.tvLetraAhorcado4);
        tvLetraAhorcado5 = findViewById(R.id.tvLetraAhorcado5);
        tvLetraAhorcado6 = findViewById(R.id.tvLetraAhorcado6);
        tvLetraAhorcado7 = findViewById(R.id.tvLetraAhorcado7);
        tvLetraAhorcado8 = findViewById(R.id.tvLetraAhorcado8);
        tvResultado = findViewById(R.id.tvResultado);
        btnVerificar = findViewById(R.id.btnVerificar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        btnLimpiar.setEnabled(false);
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String letraIngresada = edtPrincipal.getText().toString().trim();

                //verificar si está vacío
                if(TextUtils.isEmpty(letraIngresada)){
                    edtPrincipal.setError("Ingrese una letra");
                    edtPrincipal.requestFocus();
                } else {
                    switch(letraIngresada.toUpperCase()){
                        case "E":
                            tvLetralCorrecta1.setText(" E ");
                            contadorBuenas++;
                            break;
                        case "T":
                            tvLetralCorrecta2.setText(" T ");
                            contadorBuenas++;
                            break;
                        case "P":
                            tvLetralCorrecta3.setText(" P ");
                            contadorBuenas++;
                            break;
                        case "S":
                            tvLetralCorrecta4.setText(" S ");
                            contadorBuenas++;
                            break;
                        default:
                            contador++;
                            break;
                    }
                    switch(contador){
                        case 1:
                            tvLetraAhorcado1.setText("A");
                            break;
                        case 2:
                            tvLetraAhorcado2.setText("H");
                            break;
                        case 3:
                            tvLetraAhorcado3.setText("O");
                            break;
                        case 4:
                            tvLetraAhorcado4.setText("R");
                            break;
                        case 5:
                            tvLetraAhorcado5.setText("C");
                            break;
                        case 6:
                            tvLetraAhorcado6.setText("A");
                            break;
                        case 7:
                            tvLetraAhorcado7.setText("D");
                            break;
                        case 8:
                            tvLetraAhorcado8.setText("O");
                            tvResultado.setText("Perdió");
                            btnLimpiar.setEnabled(true);
                            break;

                    }
                }
                if (contadorBuenas==4){
                    tvResultado.setText("Ganó");
                    btnLimpiar.setEnabled(true);
                }

//                Toast.makeText(getApplicationContext(),Integer.toString(contador), Toast.LENGTH_SHORT).show();
                //limpiar al final
                limpiar();

            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador=0;
                contadorBuenas=0;
                edtPrincipal.setText("");
                tvLetralCorrecta1.setText(" * ");
                tvLetralCorrecta2.setText(" * ");
                tvLetralCorrecta3.setText(" * ");
                tvLetralCorrecta4.setText(" * ");
                tvLetraAhorcado1.setText(" - ");
                tvLetraAhorcado2.setText(" - ");
                tvLetraAhorcado3.setText(" - ");
                tvLetraAhorcado4.setText(" - ");
                tvLetraAhorcado5.setText(" - ");
                tvLetraAhorcado6.setText(" - ");
                tvLetraAhorcado7.setText(" - ");
                tvLetraAhorcado8.setText(" - ");
                edtPrincipal.requestFocus();
                tvResultado.setText("");
                btnLimpiar.setEnabled(false);
            }
        });

    }
    private void limpiar () {
        edtPrincipal.setText("");
        edtPrincipal.requestFocus();
    }

}