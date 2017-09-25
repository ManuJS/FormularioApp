package com.example.emanuellemenali.formularioapp;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FormularioActivity extends AppCompatActivity {

    TextView exibicaoNome;
    private EditText inputName;
    private TextInputLayout inputLayoutName;
    private Button adicionaNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputName = findViewById(R.id.input_name);
        exibicaoNome = findViewById(R.id.text_view_exibe_nome);
        adicionaNome = findViewById(R.id.button_adiciona_nome);
        adicionaNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateName()) {
                    Log.d("nome", "" + inputName.getText().toString());

                    exibicaoNome.setText(inputName.getText().toString());
                }

            }

        });
    }



    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError("escreva seu nome");
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
            }
        }
    }
}
