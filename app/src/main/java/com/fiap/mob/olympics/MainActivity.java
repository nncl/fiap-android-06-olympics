package com.fiap.mob.olympics;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText    nome;
    private EditText    idade;
    private Spinner     modalidades;
    private CheckBox    manha;
    private CheckBox    tarde;
    private CheckBox    noite;
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
        manha =         (CheckBox) findViewById(R.id.chkManha);
        tarde =         (CheckBox) findViewById(R.id.chkTarde);
        noite =         (CheckBox) findViewById(R.id.chkNoite);

        dialog =        new Dialog(this);
        dialog.setTitle("Confirmação");
        dialog.setContentView(R.layout.confirmacao);
        dialogName =            (TextView) dialog.findViewById(R.id.txtNomeResult);
        dialogIdade =           (TextView) dialog.findViewById(R.id.txtIdadeResult);
        dialogModalidade =      (TextView) dialog.findViewById(R.id.txtModalidadeResult);
        dialogPeriodo =         (TextView) dialog.findViewById(R.id.txtPeriodoResult);
        dialogButton =          (Button) dialog.findViewById(R.id.btnConfirmar);

        alertBuilder =  new AlertDialog.Builder(this);
        alertBuilder.setTitle("Confirmado");
        alertBuilder.setMessage("Você está confirmado para essa Olimpíada :)");
    }

    public void reservar(View v) {

        dialogName.setText(nome.getText());
        dialogIdade.setText(idade.getText());
        dialogModalidade.setText(modalidades.getSelectedItem().toString());
        dialogPeriodo.setText(
                manha.isChecked() ? "Manhã" : null
        );

        dialog.show();
    }

    public void confirmar(View v) {
        alertBuilder.show();
    }
}
