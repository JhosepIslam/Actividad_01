package com.islam.tarea01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView PreguntaLabel, NumeroPreguntaLabel;
    private Button btnNext, btnSalir;
    private RadioButton rb1, rb2, rb3;
    private RadioGroup radioGroup;
    private Double Puntuacion;
    private int Index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_Components();
        Puntuacion = 0.00;
        Index = 0;
        fillQuestion(Index);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void init_Components(){
        //se inicializan los componentes
        NumeroPreguntaLabel = findViewById(R.id.txtNumPregunta);
        PreguntaLabel = findViewById(R.id.txtPregunta);

        btnNext = findViewById(R.id.btnNext);
        btnSalir = findViewById(R.id.btnSalir);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);

        radioGroup = findViewById(R.id.radioGroup);

    }

    private void fillQuestion(int index){
        //depende del numero de pregunta se llenará los componentes en la vista
        switch (index){
            case 0:
                NumeroPreguntaLabel.setText(getString(R.string.question_label)+ " "+ (this.Index+1));
                PreguntaLabel.setText(R.string.question_01);
                rb1.setText(R.string.question_rp1_01);
                rb2.setText(R.string.question_rp1_02);
                rb3.setText(R.string.question_rp1_03);
                break;
            case 1:
                NumeroPreguntaLabel.setText(getString(R.string.question_label)+ " "+ (this.Index+1));
                PreguntaLabel.setText(R.string.question_02);
                rb1.setText(R.string.question_rp1_01);
                rb2.setText(R.string.question_rp1_02);
                rb3.setText(R.string.question_rp2_03);
                break;
            case 2:
                NumeroPreguntaLabel.setText(getString(R.string.question_label)+ " "+ (this.Index+1));
                PreguntaLabel.setText(R.string.question_03);
                rb1.setText(R.string.question_rp3_01);
                rb2.setText(R.string.question_rp3_02);
                rb3.setText(R.string.question_rp3_03);
                break;
            case 3:
                NumeroPreguntaLabel.setText(getString(R.string.question_label)+ " "+ (this.Index+1));
                PreguntaLabel.setText(R.string.question_04);
                rb1.setText(R.string.question_rp4_01);
                rb2.setText(R.string.question_rp4_02);
                rb3.setText(R.string.question_rp4_03);
                break;
            case 4:
                NumeroPreguntaLabel.setText(getString(R.string.question_label)+ " "+ (this.Index+1));
                PreguntaLabel.setText(R.string.question_05);
                rb1.setText(R.string.question_rp5_01);
                rb2.setText(R.string.question_rp5_02);
                rb3.setText(R.string.question_rp5_03);
                break;
            default:
                NumeroPreguntaLabel.setText(getString(R.string.finish) + " " +this.Puntuacion);
                if (this.Puntuacion < 6){
                    PreguntaLabel.setText(R.string.finish_estado_b);
                }else {
                    PreguntaLabel.setText(R.string.finish_estdo_a);
                }
                radioGroup.setVisibility(View.GONE);
                btnNext.setVisibility(View.GONE);
                PreguntaLabel.setTextSize(30);
                NumeroPreguntaLabel.setTextSize(30);
                break;
        }
    }

    private void nextQuestion(){
        switch (this.Index){
            case  2:
            case  0:
                if (rb2.isChecked()){
                    this.Puntuacion +=  2;
                }
                break;
            case  3:
            case  1:
                if (rb3.isChecked()){
                    this.Puntuacion  +=  2;
                }
                break;
            case  4:
                if (rb1.isChecked()){
                    this.Puntuacion  += 2;
                }
                break;
        }

        rb3.setChecked(false);
        rb2.setChecked(false);
        rb1.setChecked(false);
        this.Index++;
        this.fillQuestion(this.Index);
    }
}