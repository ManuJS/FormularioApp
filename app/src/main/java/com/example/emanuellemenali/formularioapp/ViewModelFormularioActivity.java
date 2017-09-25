package com.example.emanuellemenali.formularioapp;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by emanuellemenali on 25/09/17.
 */

public class ViewModelFormularioActivity extends LifecycleActivity {

    @BindView(R.id.text_view_exibe_nome)
    protected TextView exibicaoNome;

    @BindView(R.id.input_name)
    protected EditText inputName;

    @BindView(R.id.button_adiciona_nome)
    protected Button adicionaNome;

    @BindView(R.id.input_layout_name)
    protected TextInputLayout inputLayoutName;


    private FormularioViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(FormularioViewModel.class);

        insereNomeModelo(viewModel.getNome());
    }

    @OnClick(R.id.button_adiciona_nome)
    public void insereNomeFormulario(View button) {
        if (validateName()) {
            viewModel.setNome(inputName.getText().toString());
            insereNomeModelo(viewModel.getNome());
        }

    }

    private void insereNomeModelo(String nome) {
        exibicaoNome.setText(String.valueOf(nome));
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

}
