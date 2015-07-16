package com.android3project.dev.mycal;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @Bind(R.id.edtFirstNumber)
    EditText edtFirstNum;

    @Bind(R.id.edtSecondNumber)
    EditText edtSecondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCancel)
    public void clearEditText(){
        this.edtFirstNum.setText("");
        this.edtSecondNum.setText("");
        this.edtFirstNum.setError(null);
        this.edtSecondNum.setError(null);
        this.edtFirstNum.requestFocus();
    }

    @OnClick(R.id.btnExit)
    public void exitApp(){
        this.finish();
    }


}
