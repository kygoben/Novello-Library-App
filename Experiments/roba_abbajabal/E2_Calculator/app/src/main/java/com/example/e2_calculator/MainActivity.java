package com.example.e2_calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    TextView inputText;
    TextView solutionText;

    enum Operation {
        ADD, SUBTRACT,
        MULTIPLY, DIVIDE
    }
    Operation savedOperation;
    int operationLocation = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        inputText = (TextView) findViewById(R.id.inputText);
        solutionText = (TextView) findViewById(R.id.solutionText);
        createListeners();
    }

    public void createListeners()
    {
        Button zeroButton = (Button) findViewById(R.id.zeroButton);
        Button oneButton = (Button) findViewById(R.id.oneButton);
        Button twoButton = (Button) findViewById(R.id.twoButton);
        Button threeButton = (Button) findViewById(R.id.threeButton);
        Button fourButton = (Button) findViewById(R.id.fourButton);
        Button fiveButton = (Button) findViewById(R.id.fiveButton);
        Button sixButton = (Button) findViewById(R.id.sixButton);
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        Button eightButton = (Button) findViewById(R.id.eightButton);
        Button nineButton = (Button) findViewById(R.id.nineButton);
        Button decimalButton = (Button) findViewById(R.id.decimalButton);
        Button addButton = (Button) findViewById(R.id.addButton);
        Button subtractButton = (Button) findViewById(R.id.subtractButton);
        Button multiplyButton = (Button) findViewById(R.id.multiplyButton);
        Button divideButton = (Button) findViewById(R.id.divideButton);
        Button equalButton = (Button) findViewById(R.id.equalButton);
        Button clearButton = (Button) findViewById(R.id.clearButton);

        zeroButton.setOnClickListener(view -> inputNumber('0'));
        oneButton.setOnClickListener(v -> inputNumber('1'));
        twoButton.setOnClickListener(view -> inputNumber('2'));
        threeButton.setOnClickListener(view -> inputNumber('3'));
        fourButton.setOnClickListener(view -> inputNumber('4'));
        fiveButton.setOnClickListener(view -> inputNumber('5'));
        sixButton.setOnClickListener(view -> inputNumber('6'));
        sevenButton.setOnClickListener(view -> inputNumber('7'));
        eightButton.setOnClickListener(view -> inputNumber('8'));
        nineButton.setOnClickListener(view -> inputNumber('9'));
        decimalButton.setOnClickListener(view -> inputNumber('.'));

        addButton.setOnClickListener(view -> getOperatorButton(Operation.ADD));
        subtractButton.setOnClickListener(view -> getOperatorButton(Operation.SUBTRACT));
        multiplyButton.setOnClickListener(view -> getOperatorButton(Operation.MULTIPLY));
        divideButton.setOnClickListener(view -> getOperatorButton(Operation.DIVIDE));

        equalButton.setOnClickListener(view -> getEqualButton());
        clearButton.setOnClickListener(view -> getClearButton());
    }

    public void inputNumber(char num)
    {
        inputText.append(Character.toString(num));
    }

    public void getOperatorButton(Operation inputOperation)
    {
        if (inputText.getText().length() == 0)
            return;

        switch (inputOperation)
        {
            case ADD:
                savedOperation = Operation.ADD;
                if (operationLocation != -1) {
                    char[] previousInput = new char[inputText.getText().length()];
                    System.arraycopy(inputText.getText().toString().toCharArray(),
                            0, previousInput, 0, previousInput.length);
                    previousInput[operationLocation] = '+';
                    inputText.setText(String.valueOf(previousInput));
                }
                else {
                    char[] previousInput = new char[inputText.getText().length()+1];
                    System.arraycopy(inputText.getText().toString().toCharArray(),
                            0, previousInput, 0, previousInput.length-1);
                    operationLocation = inputText.getText().length();
                    previousInput[operationLocation] = '+';
                    inputText.setText(String.valueOf(previousInput));
                }
                break;

            case SUBTRACT:
                savedOperation = Operation.SUBTRACT;
                if (operationLocation != -1) {
                    char[] previousInput = new char[inputText.getText().length()];
                    System.arraycopy(inputText.getText().toString().toCharArray(),
                            0, previousInput, 0, previousInput.length);
                    previousInput[operationLocation] = '-';
                    inputText.setText(String.valueOf(previousInput));
                }
                else {
                    char[] previousInput = new char[inputText.getText().length()+1];
                    System.arraycopy(inputText.getText().toString().toCharArray(),
                            0, previousInput, 0, previousInput.length-1);
                    operationLocation = inputText.getText().length();
                    previousInput[operationLocation] = '-';
                    inputText.setText(String.valueOf(previousInput));
                }
                break;

            case MULTIPLY:
                savedOperation = Operation.MULTIPLY;
                if (operationLocation != -1) {
                    char[] previousInput = new char[inputText.getText().length()];
                    System.arraycopy(inputText.getText().toString().toCharArray(),
                            0, previousInput, 0, previousInput.length);
                    previousInput[operationLocation] = '*';
                    inputText.setText(String.valueOf(previousInput));
                }
                else {
                    char[] previousInput = new char[inputText.getText().length()+1];
                    System.arraycopy(inputText.getText().toString().toCharArray(),
                            0, previousInput, 0, previousInput.length-1);
                    operationLocation = inputText.getText().length();
                    previousInput[operationLocation] = '*';
                    inputText.setText(String.valueOf(previousInput));
                }
                break;

            case DIVIDE:
                savedOperation = Operation.DIVIDE;
                if (operationLocation != -1) {
                    char[] previousInput = new char[inputText.getText().length()];
                    System.arraycopy(inputText.getText().toString().toCharArray(),
                            0, previousInput, 0, previousInput.length);
                    previousInput[operationLocation] = '??';
                    inputText.setText(String.valueOf(previousInput));
                }
                else {
                    char[] previousInput = new char[inputText.getText().length()+1];
                    System.arraycopy(inputText.getText().toString().toCharArray(),
                            0, previousInput, 0, previousInput.length-1);
                    operationLocation = inputText.getText().length();
                    previousInput[operationLocation] = '??';
                    inputText.setText(String.valueOf(previousInput));
                }
                break;
        }
    }

    public void getEqualButton()
    {
        // TODO: Process everything in input text and put it in solution text.
        if (savedOperation == null)
        {
            return;
        }

        double operand1 = Double.parseDouble(inputText.getText().toString().substring(0, operationLocation));
        double operand2 = Double.parseDouble(inputText.getText().toString().substring(operationLocation + 1));
        double solution;
        switch (savedOperation)
        {
            case ADD:
                solution = operand1 + operand2;
                break;
            case SUBTRACT:
                solution = operand1 - operand2;
                break;
            case MULTIPLY:
                solution = operand1 * operand2;
                break;
            case DIVIDE:
                solution = operand1 / operand2;
                break;
            default:
                return;
        }

        operationLocation = -1;
        savedOperation = null;
        inputText.setText("");
        solutionText.setText(String.valueOf(solution));
    }

    public void getClearButton()
    {
        operationLocation = -1;
        savedOperation = null;
        inputText.setText("");
        solutionText.setText("");
    }
}
