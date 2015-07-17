package com.android3project.dev.mycal.PresenterImpl;

import android.text.TextUtils;
import com.android3project.dev.mycal.Model.OperandManager;
import com.android3project.dev.mycal.Presenter.OperatorPresenter;
import java.text.ParseException;

/**
 * Created by Dev on 7/15/2015.
 */
public class OperatorPresenterImpl implements OperatorPresenter {

    OperandManager operandManager;

    @Override
    public void initializeOManager(String firstNum, String secondNum, String operator) {
        operandManager = new OperandManager(firstNum, secondNum, operator);
    }

    @Override
    public double compute() {
        double firstNum = 0;
        double secondNum = 0;
        String operator;
        try {
            firstNum = operandManager.getNumFormat(operandManager.getFirstNumber()).doubleValue();
            secondNum = operandManager.getNumFormat(operandManager.getSecondNumber()).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        operator = String.valueOf(operandManager.getOperator().charAt(0));
        double result = 0;

        if (!isComputable()) {
            return ERRORID;
        } else {
            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "x":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    result = firstNum / secondNum;
                    break;
            }
            return result;
        }
    }

    public boolean isComputable() {
        if (!TextUtils.isEmpty(operandManager.getFirstNumber()) && !TextUtils.isEmpty(operandManager.getSecondNumber()) && !TextUtils.isEmpty(operandManager.getOperator())) {
            try {
                operandManager.setFirstNumber(operandManager.getNumFormat(operandManager.getFirstNumber()).toString());
                operandManager.setSecondNumber(operandManager.getNumFormat(operandManager.getSecondNumber()).toString());
            } catch (ParseException parseexception) {
                return false;
            }
            if (operandManager.getOperator().length() == 1) {
                char c1 = operandManager.getOperator().charAt(0);
                if (c1 == '+' || c1 == '-' || c1 == 'x' || c1 == '/') {
                    return true;
                }
            }
        }
        return false;
    }
}
