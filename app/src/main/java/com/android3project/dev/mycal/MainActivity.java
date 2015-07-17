package com.android3project.dev.mycal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android3project.dev.mycal.Model.OperandManager;
import com.android3project.dev.mycal.Presenter.OperatorPresenter;
import com.android3project.dev.mycal.PresenterImpl.OperatorPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity{

    @Bind(R.id.edtFirstNumber)
    EditText edtFirstNum;

    @Bind(R.id.edtSecondNumber)
    EditText edtSecondNum;

    OperatorPresenter operatorPresenter;
    OperandManager operandManager;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        operatorPresenter = new OperatorPresenterImpl();
    }

    @OnClick({R.id.btnAdd, R.id.btnMinus, R.id.btnDivide, R.id.btnMultiply})
    public void computeOperation(Button view) {
        String fNum = this.edtFirstNum.getText().toString();
        String sNum = this.edtSecondNum.getText().toString();
        String optr = view.getText().toString();
        operatorPresenter.initializeOManager(fNum, sNum, optr);
        result = operatorPresenter.compute();
        Toast.makeText(this,result+"",Toast.LENGTH_SHORT).show();
        viewResult(optr,result);
    }

    @OnClick(R.id.btnCancel)
    public void clearEditText() {
        this.edtFirstNum.setText("");
        this.edtSecondNum.setText("");
        this.edtFirstNum.setError(null);
        this.edtSecondNum.setError(null);
        this.edtFirstNum.requestFocus();
    }

    @OnClick(R.id.btnExit)
    public void exitApp() {
        this.finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void viewResult(String operator,double result){
        Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
        intent.putExtra(operatorPresenter.KEY_FIRST_NUM,edtFirstNum.getText().toString());
        intent.putExtra(operatorPresenter.KEY_SECOND_NUM,edtSecondNum.getText().toString());
        intent.putExtra(operatorPresenter.KEY_OPERATOR,operator);
        intent.putExtra(operatorPresenter.KEY_RESULT,result);
        startActivity(intent);
    }
}
