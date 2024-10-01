/*
@author:<Matheus Augusto Marti>
 */

package br.edu.fateczl.ex1atv2eqseggrau;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumA;
    private EditText etNumB;
    private EditText etNumC;
    private TextView tvErro;
    private TextView tvDelta;
    private TextView tvX1;
    private TextView tvX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumA = findViewById(R.id.etNumA);
        etNumA.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etNumB = findViewById(R.id.etNumB);
        etNumB.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etNumC = findViewById(R.id.etNumC);
        etNumC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvErro = findViewById(R.id.tvErro);
        tvErro.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvDelta = findViewById(R.id.tvDelta);
        tvDelta.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvX1 = findViewById(R.id.tvX1);
        tvX1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvX2 = findViewById(R.id.tvX2);
        tvX2.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(op -> calc());
    }

    private void calc() {
        tvErro.setText("");
        tvDelta.setText("");
        tvX1.setText("");
        tvX2.setText("");
        double a = Double.parseDouble(etNumA.getText().toString());
        double b = Double.parseDouble(etNumB.getText().toString());
        double c = Double.parseDouble(etNumC.getText().toString());
        double delta = (Math.pow(b, 2)) - (4*a*c);
        double x1 = (-b + Math.sqrt(delta))/ (2*a);
        double x2 = (-b - Math.sqrt(delta))/ (2*a);
        if (a == 0) {
            tvErro.setText(R.string.erro_nao_e_segundo_grau);
        } else if (delta < 0) {
            tvErro.setText(R.string.erro_nao_tem_raiz_real);
        } else {
            String resDelta = "Δ: " + delta;
            String resX1 = "X1: " + x1;
            String resX2 = "X2: " + x2;
            tvDelta.setText(resDelta);
            tvX1.setText(resX1);
            tvX2.setText(resX2);
        }
        etNumA.setText("");
        etNumB.setText("");
        etNumC.setText("");
    }
}