package com.example.calculator_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnAC,btnSign,btnDiv,btnMul,btnSub,btnAdd,btnPer,btnPoint,btnEqual;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    private TextView textView;

    float num1,num2;
    String op = "";
    boolean flagNum2 = false;
    boolean flagPoint = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void buttonPressed(View view){
        int id = view.getId();
        if(id == R.id.btn0)
            setNumber("0");
        else if (id == R.id.btn1)
            setNumber("1");
        else if (id == R.id.btn2){
            setNumber("2");}
        else if (id == R.id.btn3)
            setNumber("3");
        else if (id == R.id.btn4)
            setNumber("4");
        else if (id == R.id.btn5)
            setNumber("5");
        else if (id == R.id.btn6)
            setNumber("6");
        else if (id == R.id.btn7)
            setNumber("7");
        else if (id == R.id.btn8)
            setNumber("8");
        else if (id == R.id.btn9)
            setNumber("9");
        else if (id == R.id.btnPoint){
            if(flagPoint){
                setNumber(".");
                flagPoint = false;
            }
        }
        else if (id == R.id.btnAdd){
            flagPoint = true;
            if(flagNum2){
                equal();
            }
            if(!op.equals("")) {
                checking("+");
            }
            else {
                op = "+";
                setOp("+");

            }
        }
        else if (id == R.id.btnSub){
            flagPoint = true;
            if(flagNum2){
                equal();
            }
            if(!op.equals("")) {
                checking("-");
            }
            else {
                op = "-";
                setOp("-");
            }
        }
        else if (id == R.id.btnMul){
            flagPoint = true;
            if(flagNum2){
                equal();
            }
            if(!op.equals("")) {
                checking("×");
            }
            else {
                op = "×";
                setOp("×");
            }
        }
        else if (id == R.id.btnDiv){
            flagPoint = true;
            if(flagNum2){
                equal(); btnDiv.cancelLongPress();
            }
            if(!op.equals("")) {
                checking("÷");
            }
            else {
                op = "÷";
                setOp("÷");
            }
        }
        else if (id == R.id.btnPer){
            flagPoint = true;
            if(flagNum2){
                equal();
            }
            if(!op.equals("")) {
                checking("%");
            }
            else {
                op = "%";
                setOp("%");
            }
        }
        else if (id == R.id.btnEqual){
            flagPoint = false;
            if(!op.equals("") && !flagNum2)
                Toast.makeText(MainActivity.this , R.string.info1 , Toast.LENGTH_LONG).show();
            else
                equal();
        }
        else if (id == R.id.btnAC){
            num1 = num2 = 0;
            op = "";
            textView.setText("0 ");
            flagNum2 = false;
            flagPoint = true;
        }
        else if (id == R.id.btnSign){
            float number = Float.parseFloat(textView.getText().toString());
            if (number != 0)
                textView.setText(String.format("%s", number * -1));
        }
    }

    void setNumber(String number){
        String tmp = textView.getText().toString();
        if (op.equals("")){
            if(tmp.equalsIgnoreCase("0 ")){
                if(number.equals("."))
                    textView.setText("0.");
                else
                    textView.setText(number);
            }
            else
                textView.setText(String.format("%s%s", tmp, number));
        }
        else {
            if (!flagNum2){
                if(number.equals("."))
                    textView.setText("0.");
                else
                    textView.setText(number);
                flagNum2 = true;
            }
            else
                textView.setText(String.format("%s%s", tmp, number));
        }
    }

    void equal(){
        num2 = Float.parseFloat(textView.getText().toString());
        float result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "×":
                result = num1 * num2;
                break;
            case "÷":
                if (num2 == 0)
                    Toast.makeText(MainActivity.this, R.string.info, Toast.LENGTH_LONG).show();
                else
                    result = num1 / num2;
                break;
            case "%":
                result = (num1 / 100) * num2;
                break;
        }
        textView.setText(String.format("%s", result));
        num1 = num2 = 0;
        op = "";
        flagNum2 = false;
    }

    void setOp (String op){
        num1 = Float.parseFloat(textView.getText().toString());
        textView.setText(op);
    }

    void checking (String op){
        textView.getText();
        textView.setText(op);
        this.op = op;
    }

    void findViews(){
        textView = findViewById(R.id.textView);
        btnAC = findViewById(R.id.btnAC);
        btnSign = findViewById(R.id.btnSign);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnSub = findViewById(R.id.btnSub);
        btnAdd = findViewById(R.id.btnAdd);
        btnPer = findViewById(R.id.btnPer);
        btnPoint = findViewById(R.id.btnPoint);
        btnEqual = findViewById(R.id.btnEqual);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }
}