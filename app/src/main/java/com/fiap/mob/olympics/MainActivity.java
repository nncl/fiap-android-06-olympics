package com.fiap.mob.olympics;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText    nome;
    private EditText    idade;
    private Spinner     modalidades;
    private RadioGroup  periodo;

    private Dialog      dialog;
    private TextView    dialogName;
    private TextView    dialogIdade;
    private TextView    dialogModalidade;
    private TextView    dialogPeriodo;
    private Button      dialogButton;
    private AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome =          (EditText) findViewById(R.id.edtNome);
        idade =         (EditText) findViewById(R.id.edtIdade);
        modalidades =   (Spinner) findViewById(R.id.spinModalidade);
        periodo =       (RadioGroup) findViewById(R.id.rdgPeriodo);
    }

    public void reservar(View v) {

        dialog =        new Dialog(this);
        dialog.setContentView(R.layout.confirmacao);

        dialogName =            (TextView) dialog.findViewById(R.id.txtNomeResult); // it waits an
        // editable variable, not a string
        dialogIdade =           (TextView) dialog.findViewById(R.id.txtIdadeResult);
        dialogModalidade =      (TextView) dialog.findViewById(R.id.txtModalidadeResult);
        dialogPeriodo =         (TextView) dialog.findViewById(R.id.txtPeriodoResult);
        dialogButton =          (Button) dialog.findViewById(R.id.btnConfirmar);

        dialogName.setText(nome.getText());
        dialogIdade.setText(idade.getText());
        dialogModalidade.setText(modalidades.getSelectedItem().toString());

        int selectedID = periodo.getCheckedRadioButtonId();
        RadioButton selectedRB = (RadioButton) findViewById(selectedID);
        dialogPeriodo.setText(selectedRB.getText());

        dialog.show();
    }

    public void confirmar(View v) {
        alertBuilder =  new AlertDialog.Builder(this);
        alertBuilder.setTitle("Confirmado");
        alertBuilder.setMessage("Você está confirmado para essa Olimpíada :)");

        alertBuilder.show();
    }
}
