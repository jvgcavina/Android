package com.jv.connect3game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GameImageView[][] matrix;
    private GridLayout gl;
    private TextView info;
    private Button btnReset;
    private boolean isPlayerOne;
    private boolean isPlayerOneLastPlayer = false;
    private int winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        gl = (GridLayout) findViewById(R.id.GridLayout);
        info = (TextView) findViewById(R.id.tvInfo);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnReset.setText("Reset");
                resetGame();
            }
        });
        matrix = new GameImageView[3][3];

        // Initialize matrix adding items
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = new GameImageView(getApplicationContext());
                matrix[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        GameImageView item = (GameImageView) view;

                        item.setTranslationY(-1000);

                        // Set player button and matrix value
                        if (isPlayerOne) {  // Player 1
                            item.setValue(1);
                            item.setBackgroundResource(R.drawable.red);
                        } else {    // Player 2
                            item.setValue(2);
                            item.setBackgroundResource(R.drawable.yellow);
                        }

                        item.animate().translationYBy(1000).rotation(7200).setDuration(1000);

                        item.setEnabled(false); // Prevent click on already clicked position

                        // If game finished with winner or draw
                        if (!isGameFinished()) {
                            isPlayerOne = !isPlayerOne; // Update turn player
                            updateTurnText();
                        } else {
                            checkWinner();
                        }
                    }
                });

                // Add view to grid
                gl.addView(matrix[i][j]);
            }
        }

        resetGame();
    }

    private void resetGame() {
        isPlayerOne = !isPlayerOneLastPlayer;
        isPlayerOneLastPlayer = isPlayerOne;
        winner = 0;

        // Reset all matrix positions
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j].setBackgroundResource(0);
                matrix[i][j].setValue(0);
                matrix[i][j].setEnabled(true);
            }
        }

        updateTurnText();
    }

    private void updateTurnText() {
        if (isPlayerOne) {
            info.setText("Player 1 turn");
        } else {
            info.setText("Player 2 turn");
        }
    }

    // Check if game has finished
    private boolean isGameFinished() {
        boolean result;
        int i, j, value, count = 0;

        // Line verification
        for (i = 0; i < 3; i++) {
            result = true;
            value = 0;
            for (j = 1; j < 3; j++) {
                value = matrix[i][j].getValue();
                if (matrix[i][j - 1].getValue() != matrix[i][j].getValue()) {
                    result = false;
                    break;
                }
            }

            // If whole line has same value and value is not zero
            if (result && value != 0) {
                winner = value;
                return result;
            }
        }

        // Column verification
        for (i = 0; i < 3; i++) {
            result = true;
            value = 0;
            for (j = 1; j < 3; j++) {
                value = matrix[j][i].getValue();
                if (matrix[j - 1][i].getValue() != matrix[j][i].getValue()) {
                    result = false;
                    break;
                }
            }

            // If whole column has same value and value is not zero
            if (result && value != 0) {
                winner = value;
                return result;
            }
        }

        result = true;
        value = 0;
        // Diagonal verification left to right
        for (i = 1; i < 3; i++) {
            value = matrix[i][i].getValue();
            if (matrix[i - 1][i - 1].getValue() != matrix[i][i].getValue()) {
                result = false;
                break;
            }
        }

        // If whole diagonal has same value and value is not zero
        if (result && value != 0) {
            winner = value;
            return result;
        }

        result = true;
        value = 0;
        // Diagonal verification right to left
        for (i = 1; i < 3; i++) {
            value = matrix[2 - i][i].getValue();
            if (matrix[2 - i + 1][i - 1].getValue() != matrix[2 - i][i].getValue()) {
                result = false;
                break;
            }
        }

        // If whole diagonal has same value and value is not zero
        if (result && value != 0) {
            winner = value;
            return result;
        }


        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (matrix[j][i].getValue() == 0) {
                    count++;
                }
            }
        }

        if (count == 0) {
            winner = 0;
            return true;
        }

        return false;
    }

    private void checkWinner() {
        if (winner == 1) {
            info.setText("Player 1 is the winner!");
        } else if (winner == 2) {
            info.setText("Player 2 is the winner!");
        } else {
            info.setText("Draw");
        }
        btnReset.setText("New Game");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[j][i].setEnabled(false);
            }
        }
    }
}
