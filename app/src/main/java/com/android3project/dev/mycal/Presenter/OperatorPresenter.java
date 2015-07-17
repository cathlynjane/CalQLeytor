package com.android3project.dev.mycal.Presenter;

import com.android3project.dev.mycal.Model.OperandManager;

/**
 * Created by Dev on 7/15/2015.
 */
public interface OperatorPresenter {
    static final String KEY_FIRST_NUM = "firstNumKey";
    static final String KEY_SECOND_NUM = "secondNumKey";
    static final String KEY_OPERATOR = "operatorKey";
    static final String KEY_RESULT = "resultKey";
    static final double ERRORID = -1D;

    public void initializeOManager(String firstNum, String secondNum, String operator);
    public double compute();
    public boolean isComputable();
}
