package com.example.melisatokmak.numberguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Guessing extends AppCompatActivity {

    int winningNumber;

    EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);
        inputField = (EditText) findViewById(R.id.input);
        resetGame();
    }

    public void resetGame() {
        Random randy = new Random();
        winningNumber = randy.nextInt(1000);
    }

    public void submit_click(View view) {
        EditText editText = (EditText) findViewById(R.id.input);
        if (Integer.parseInt(inputField.getText().toString()) == winningNumber) {
            Toast winMessage = Toast.makeText(getApplicationContext(), "YOU WON!!!!!! GOOD JOB", Toast.LENGTH_LONG);
            winMessage.show();
        } else if (Integer.parseInt(inputField.getText().toString()) > winningNumber) {
            Toast downMessage = Toast.makeText(getApplicationContext(), "Try something lower.", Toast.LENGTH_LONG);
            downMessage.show();
        } else {
            Toast upMessage = Toast.makeText(getApplicationContext(), "Try something higher.", Toast.LENGTH_LONG);
            upMessage.show();
        }
        ((EditText) findViewById(R.id.input)).setText("");
    }

    public void new_game_click(View view) {
        ((EditText) findViewById(R.id.input)).setText("");
        resetGame();
    }
}