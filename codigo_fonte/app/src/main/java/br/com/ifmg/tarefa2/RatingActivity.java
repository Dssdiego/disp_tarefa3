package br.com.ifmg.tarefa2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        RatingBar ratingFood = findViewById(R.id.ratingFood);
        RatingBar ratingDelivery = findViewById(R.id.ratingDelivery);
        RatingBar ratingCorrect = findViewById(R.id.ratingCorrect);
        EditText editComment = findViewById(R.id.editComment);

        Button btnLogin = findViewById(R.id.btnSend);
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt(Keys.RATING_FOOD, (int) ratingFood.getRating());
            b.putInt(Keys.RATING_DELIVERY, (int) ratingDelivery.getRating());
            b.putInt(Keys.RATING_CORRECT, (int) ratingCorrect.getRating());
            b.putString(Keys.COMMENT, editComment.getText().toString());
            intent.putExtras(b);
            startActivity(intent);
        });
    }
}