package com.digitest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by onobrac on 11/10/15.
 */
public class Test3 extends AppCompatActivity {
    int posicion =  0;
    int progresoNum = 0;
    RespuestasT3 r = new RespuestasT3();
    PreguntasT3 p  = new PreguntasT3();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent in = getIntent();
        Bundle bundle = in.getExtras();
        final String nombrePac = bundle.getString("nombrePac");
        setContentView(R.layout.fragment);


        final ProgressBar progreso = (ProgressBar) findViewById(R.id.progressBar);
        final Button btnAnt = (Button) findViewById(R.id.btnAnterior);
        final Button btnAvan = (Button) findViewById(R.id.btnAvanzar);

        btnAvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicion++;



                progresoNum=(100/20)*posicion;
                progreso.setProgress(progresoNum);
                TextView questi = (TextView) findViewById(R.id.question);
                RadioGroup group1 = (RadioGroup) findViewById(R.id.botoncitos);


                if (posicion < 20) {
                    btnAvan.setText("Siguiente");

                    questi.setText(p.getPregunta(posicion));
                    String[] a = r.setRespuestas(posicion);
                    group1.setVisibility(View.VISIBLE);
                    group1.clearCheck();


                    RadioButton op1 = (RadioButton) findViewById(R.id.opc1);
                    RadioButton op2 = (RadioButton) findViewById(R.id.opc2);
                    RadioButton op3 = (RadioButton) findViewById(R.id.opc3);
                    RadioButton op4 = (RadioButton) findViewById(R.id.opc4);
                    op1.setText(a[1]);
                    op2.setText(a[2]);
                    op3.setText(a[3]);
                    op4.setText(a[4]);

                    btnAnt.setVisibility(View.VISIBLE);
                } else if (posicion == 20) {
                    group1.setVisibility(View.INVISIBLE);
                    questi.setText("Test terminado");
                    btnAvan.setText("Finalizar");


                } else {
                    Log.d("argumento", nombrePac);
                    Intent newForm = new Intent(Test3.this, Main.class);
                    newForm.putExtra("nombrePac",nombrePac);
                    startActivity(newForm);
                }
            }
        });


        btnAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View x) {

                TextView questi = (TextView) findViewById(R.id.question);
                RadioGroup group1 = (RadioGroup) findViewById(R.id.botoncitos);

                if (posicion > 1) {
                    posicion--;

                    progresoNum=(100/20)*posicion;
                    progreso.setProgress(progresoNum);
                    btnAvan.setText("Siguiente");

                    questi.setText(p.getPregunta(posicion));
                    String[] a = r.setRespuestas(posicion);
                    group1.setVisibility(View.VISIBLE);
                    group1.clearCheck();


                    RadioButton op1 = (RadioButton) findViewById(R.id.opc1);
                    RadioButton op2 = (RadioButton) findViewById(R.id.opc2);
                    RadioButton op3 = (RadioButton) findViewById(R.id.opc3);
                    RadioButton op4 = (RadioButton) findViewById(R.id.opc4);
                    op1.setText(a[1]);
                    op2.setText(a[2]);
                    op3.setText(a[3]);
                    op4.setText(a[4]);

                } else if (posicion==1){
                    posicion--;

                    btnAnt.setVisibility(View.INVISIBLE);
                    progresoNum=(100/20)*posicion;
                    progreso.setProgress(progresoNum);
                    questi.setText(p.getPregunta(posicion));
                    String[] a = r.setRespuestas(posicion);
                    group1.setVisibility(View.VISIBLE);
                    group1.clearCheck();


                    RadioButton op1 = (RadioButton) findViewById(R.id.opc1);
                    RadioButton op2 = (RadioButton) findViewById(R.id.opc2);
                    RadioButton op3 = (RadioButton) findViewById(R.id.opc3);
                    RadioButton op4 = (RadioButton) findViewById(R.id.opc4);
                    op1.setText(a[1]);
                    op2.setText(a[2]);
                    op3.setText(a[3]);
                    op4.setText(a[4]);

                }
            }
        });
    }

}
