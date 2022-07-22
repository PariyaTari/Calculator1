package com.example.calculator_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        buttonColor();
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
            if(flagPoint == true){
                setNumber(".");
                flagPoint = false;
            }
        }
        else if (id == R.id.btnAdd){
            flagPoint = true;
            if(flagNum2 == true){
                equal();
            }
            if(op != "") {
                textView.getText().toString();
                op = "+";
                textView.setText("+");
            }
            else {
                num1 = Float.parseFloat(textView.getText().toString());
                op = "+";
                textView.setText("+");
            }
        }
        else if (id == R.id.btnSub){
            flagPoint = true;
            if(flagNum2 == true){
                equal();
            }
            if(op != "") {
                textView.getText().toString();
                op = "-";
                textView.setText("-");
            }
            else {
                num1 = Float.parseFloat(textView.getText().toString());
                op = "-";
                textView.setText("-");
            }
        }
        else if (id == R.id.btnMul){
            flagPoint = true;
            if(flagNum2 == true){
                equal();
            }
            if(op != "") {
                textView.getText().toString();
                op = "×";
                textView.setText("×");
            }
            else {
                num1 = Float.parseFloat(textView.getText().toString());
                op = "×";
                textView.setText("×");
            }
        }
        else if (id == R.id.btnDiv){
            flagPoint = true;
            if(flagNum2 == true){
                equal(); btnDiv.cancelLongPress();
            }
            if(op != "") {
                textView.getText().toString();
                op = "÷";
                textView.setText("÷");
            }
            else {
                num1 = Float.parseFloat(textView.getText().toString());
                op = "÷";
                textView.setText("÷");
            }
        }
        else if (id == R.id.btnPer){
            flagPoint = true;
            if(flagNum2 == true){
                equal();
            }
            if(op != "") {
                textView.getText().toString();
                op = "%";
                textView.setText("%");
            }
            else {
                num1 = Float.parseFloat(textView.getText().toString());
                op = "%";
                textView.setText("%");
            }
        }
        else if (id == R.id.btnEqual){
            if(op != "" && flagNum2 == false)
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
                textView.setText((number * -1)+"");
        }
    }

    void setNumber(String number){
        String tmp = textView.getText().toString();
        if (op == ""){
            if(tmp.equalsIgnoreCase("0 ")){
                if(number == ".")
                    textView.setText("0.");
                else
                    textView.setText(number);
            }
            else
                textView.setText(tmp+number);
        }
        else {
            if (flagNum2 == false){
                if(number == ".")
                    textView.setText("0.");
                else
                    textView.setText(number);
                flagNum2 = true;
            }
            else
                textView.setText(tmp+number);
        }
    }

    void equal(){
        num2 = Float.parseFloat(textView.getText().toString());
        float result = 0;
        if(op == "+")
            result = num1 + num2;
        else if(op == "-")
            result = num1 - num2;
        else if(op == "×")
            result = num1 * num2;
        else if(op == "÷"){
            if(num2 == 0)
                Toast.makeText(MainActivity.this , R.string.info , Toast.LENGTH_LONG).show();
            else
                result = num1 / num2;
        }
        else if(op == "%")
            result = (num1/100) * num2;

        textView.setText(result+"");
        num1 = num2 = 0;
        op = "";
        flagNum2 = false;
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

    void buttonColor (){
        btn0.setBackgroundColor(getColor(R.color.dimGray));
        btn1.setBackgroundColor(getColor(R.color.dimGray));
        btn2.setBackgroundColor(getColor(R.color.dimGray));
        btn3.setBackgroundColor(getColor(R.color.dimGray));
        btn4.setBackgroundColor(getColor(R.color.dimGray));
        btn5.setBackgroundColor(getColor(R.color.dimGray));
        btn6.setBackgroundColor(getColor(R.color.dimGray));
        btn7.setBackgroundColor(getColor(R.color.dimGray));
        btn8.setBackgroundColor(getColor(R.color.dimGray));
        btn9.setBackgroundColor(getColor(R.color.dimGray));
        btnPoint.setBackgroundColor(getColor(R.color.dimGray));
        btnAC.setBackgroundColor(getColor(R.color.lightGray));
        btnSign.setBackgroundColor(getColor(R.color.lightGray));
        btnPer.setBackgroundColor(getColor(R.color.lightGray));
        btnDiv.setBackgroundColor(getColor(R.color.orange));
        btnMul.setBackgroundColor(getColor(R.color.orange));
        btnSub.setBackgroundColor(getColor(R.color.orange));
        btnAdd.setBackgroundColor(getColor(R.color.orange));
        btnEqual.setBackgroundColor(getColor(R.color.orange));

    }

//    public void buttonPressed(View view){
//        String text = ((AppCompatButton)view).getText().toString();
//        textView.setText(textView.getText().toString().concat(text));
//    }
}