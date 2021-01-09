package br.com.ifmg.tarefa3;

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
            RatingData ratingData = new RatingData();
            ratingData.setRatingFood((int) ratingFood.getRating());
            ratingData.setRatingDelivery((int) ratingDelivery.getRating());
            ratingData.setRatingCorrect((int) ratingCorrect.getRating());
            ratingData.setComment(editComment.getText().toString());
            intent.putExtra(Keys.RATING_DATA, ratingData);
            startActivity(intent);
        });
    }
}