package com.android3project.dev.mycal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android3project.dev.mycal.Model.OperandManager;
import com.android3project.dev.mycal.Presenter.OperatorPresenter;
import com.android3project.dev.mycal.PresenterImpl.OperatorPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ResultActivity extends AppCompatActivity {

    @Bind(R.id.tvFirstNumber)
    TextView tvFirstNumber;
    @Bind(R.id.tvOperator)
    TextView tvOperator;
    @Bind(R.id.tvSecondNumber)
    TextView tvSecondNumber;
    @Bind(R.id.tvResult)
    TextView tvResult;

    OperatorPresenter operatorPresenter;
    OperandManager operandManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        operatorPresenter = new OperatorPresenterImpl();
        Intent intent = getIntent();
        tvFirstNumber.setText(intent.getStringExtra(operatorPresenter.KEY_FIRST_NUM));
        tvSecondNumber.setText(intent.getStringExtra(operatorPresenter.KEY_SECOND_NUM));
        tvOperator.setText(intent.getStringExtra(operatorPresenter.KEY_OPERATOR));
        tvResult.setText(String.valueOf(intent.getDoubleExtra(operatorPresenter.KEY_RESULT, 0)));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
