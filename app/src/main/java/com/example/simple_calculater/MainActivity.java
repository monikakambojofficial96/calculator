package com.example.simple_calculater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button add, subtract, divide, equalTo;
    float value1 = 0, value2 = 0;
    Boolean mAddition = false;
    Boolean mSubtraction = false;
    Boolean mDivide = false;
    float total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumbersClickListner list = new NumbersClickListner();
        findViewById(R.id.btn1).setOnClickListener(list);
        findViewById(R.id.btn2).setOnClickListener(list);
        findViewById(R.id.btn3).setOnClickListener(list);
        findViewById(R.id.btn4).setOnClickListener(list);
        findViewById(R.id.btn5).setOnClickListener(list);
        findViewById(R.id.btn6).setOnClickListener(list);
        findViewById(R.id.btn7).setOnClickListener(list);
        findViewById(R.id.btn8).setOnClickListener(list);
        findViewById(R.id.btn9).setOnClickListener(list);
        findViewById(R.id.btn_point).setOnClickListener(list);
        findViewById(R.id.btn_zero).setOnClickListener(list);
        findViewById(R.id.cls).setOnClickListener(list);

        editText = findViewById(R.id.editText5);
        editText.setShowSoftInputOnFocus(false);  //unaable internal keyboard
        add = findViewById(R.id.btn_add);
        subtract = findViewById(R.id.subtract);
        divide = findViewById(R.id.Divide_btn);
        equalTo = findViewById(R.id.equal_to);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    value1 = Float.parseFloat(editText.getText() + " ");
                    editText.setText("");
                    mAddition = true;
                    mSubtraction = false;
                    mDivide = false;

            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = Float.parseFloat(editText.getText() + " ".trim());
                editText.setText("");
                mSubtraction = true;
                mDivide = false;
                mAddition = false;

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = Float.parseFloat(editText.getText() + "");
                editText.setText("");
                mDivide = true;
                mSubtraction = false;
                mAddition = false;
            }
        });


        equalTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value2 = Float.parseFloat(editText.getText() + " ");

                if (mAddition) {
                    
                    if (total > 0) {

                        total = total + value2;
                    } else {

                        total = value1 + value2;
                    }
                    editText.setText(String.format("%s", total));


                } else if (mSubtraction) {

                    if (total > 0) {

                        total = total - value2;
                    } else {
                        total = value1 - value2;
                    }
                    editText.setText(String.format("%s", total));


                } else if (mDivide) {

                    if (total > 0) {

                        total = total / value2;
                    } else {

                        total = value1 / value2;
                    }
                    editText.setText(String.format("%s", total));

                } else {
                    editText.setText(String.format("%s", value2));

                }
            }
        });
    }

    class NumbersClickListner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1: {

                    editText.setText(String.format("%s", editText.getText() + "1"));
                    return;
                }
                case R.id.btn2: {
                    editText.setText(String.format("%s", editText.getText() + "2"));
                    return;
                }

                case R.id.btn3: {
                    editText.setText(String.format("%s", editText.getText() + "3"));
                    return;
                }

                case R.id.btn4: {

                    editText.setText(String.format("%s", editText.getText() + "4"));
                    return;
                }

                case R.id.btn5: {

                    editText.setText(String.format("%s", editText.getText() + "5"));
                    return;
                }

                case R.id.btn6: {
                    editText.setText(String.format("%s", editText.getText() + "6"));
                    return;
                }

                case R.id.btn7: {

                    editText.setText(String.format("%s", editText.getText() + "7"));
                    return;
                }

                case R.id.btn8: {
                    editText.setText(String.format("%s", editText.getText() + "8"));
                    return;
                }

                case R.id.btn9: {
                    editText.setText(String.format("%s", editText.getText() + "9"));
                    return;
                }

                case R.id.btn_zero: {
                    editText.setText(String.format("%s", editText.getText() + "0"));
                    return;
                }

                case R.id.btn_point: {
                    if (editText.getText().toString().trim().contains(".")) {
//                        Toast.makeText(v.getContext(), "Only one point is allowed", Toast.LENGTH_SHORT).show();
                    } else
                        editText.setText(String.format("%s", editText.getText() + "."));
                    return;

                }

                case R.id.cls: {
                    editText.setText("");
                }
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }
        }
    }
}
