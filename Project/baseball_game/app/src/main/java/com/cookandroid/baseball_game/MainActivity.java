package com.cookandroid.baseball_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2, input3;
    TextView txtHistory;
    Button btnCheck, btnNewGame, btnExit, btnStart;

    int[] answer = new int[3];
    int tryCount = 0;
    Random random = new Random();

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);

        setInputsEnabled(false);

        txtHistory = findViewById(R.id.txtHistory);
        btnStart = findViewById(R.id.btnStart);
        btnCheck = findViewById(R.id.btnCheck);
        btnNewGame = findViewById(R.id.btnNewGame);
        btnExit = findViewById(R.id.btnExit);
        scrollView = findViewById(R.id.scrollView);

        input1.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_UP) {
                if (input1.getText().length() == 1) {
                    input2.requestFocus();
                }
            }
            return false;
        });

        input2.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_UP) {
                if (input2.getText().length() == 1) {
                    input3.requestFocus();
                }
            }
            return false;
        });

        btnStart.setOnClickListener(v -> {
            newGame();
            setInputsEnabled(true);
            input1.requestFocus();
            Toast.makeText(this, "Random numbers generated", Toast.LENGTH_SHORT).show();
        });

        //newGame();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (input1.getText().toString().isEmpty() ||
                        input2.getText().toString().isEmpty() ||
                        input3.getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity.this,
                            "Please enter 3 numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                int g1 = Integer.parseInt(input1.getText().toString());
                int g2 = Integer.parseInt(input2.getText().toString());
                int g3 = Integer.parseInt(input3.getText().toString());

                int[] guess = {g1, g2, g3};
                tryCount++;

                int strike = 0;
                int ball = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (guess[i] == answer[j]) {
                            if (i == j) strike++;
                            else ball++;
                        }
                    }
                }

                String line = "#" + tryCount + " Guess: "
                        + g1 + " ⌖ " + g2 + " ⌖ " + g3
                        + " ↪ " + strike + " strike ✦ " + ball + " ball\n";

                txtHistory.append(line);

                scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));

                if (strike == 3) {
                    txtHistory.append("\n᧖(• ᦢ •)ᦣ Correct! The answer is: "
                            + answer[0] + " ✦ " + answer[1] + " ✦ " + answer[2]
                            +"\n⸜( ⌓̈ )⸝ Total tried:" + tryCount + "\n");

                    scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
                }
            }
        });

        btnNewGame.setOnClickListener(v -> newGame());
        btnExit.setOnClickListener(v -> finish());
    }

    private void newGame() {
        boolean[] used = new boolean[10];

        for (int i = 0; i < 3; i++) {
            int num;
            do {
                num = random.nextInt(9) + 1;
            } while (used[num]);
            used[num] = true;
            answer[i] = num;
        }

        tryCount = 0;
        txtHistory.setText("");

        input1.setText("");
        input2.setText("");
        input3.setText("");

        Toast.makeText(this, "new game starting", Toast.LENGTH_SHORT).show();
    }

    private void setInputsEnabled(boolean enabled) {
        input1.setEnabled(enabled);
        input2.setEnabled(enabled);
        input3.setEnabled(enabled);
    }

}

