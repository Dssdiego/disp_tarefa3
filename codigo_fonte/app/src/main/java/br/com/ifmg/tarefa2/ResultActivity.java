package br.com.ifmg.tarefa2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Primeira Parte
        RatingBar ratingMean = findViewById(R.id.ratingMean);
        TextView txtComment = findViewById(R.id.txtComment);
        TextView txtRatingFinal = findViewById(R.id.txtRatingFinal);

        // Segunda Parte
        ProgressBar progressDelivery = findViewById(R.id.progressDelivery);
        TextView txtDelivery = findViewById(R.id.txtDelivery);

        ProgressBar progressFood = findViewById(R.id.progressFood);
        TextView txtFood = findViewById(R.id.txtFood);

        ProgressBar progressCorrect = findViewById(R.id.progressCorrect);
        TextView txtCorrect = findViewById(R.id.txtCorrect);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            int ratingFood = b.getInt(Keys.RATING_FOOD);
            int ratingDelivery = b.getInt(Keys.RATING_DELIVERY);
            int ratingCorrect = b.getInt(Keys.RATING_CORRECT);
            String comment = b.getString(Keys.COMMENT);

            // Aplica o valor da média nas estrelas
            int mean = (ratingCorrect + ratingDelivery + ratingFood) / 3;
            ratingMean.setRating(mean);

            // Aplica o valor do comentário
            txtComment.setText(comment);

            // Aplica o valor da média no texto de média final
            txtRatingFinal.setText(mean + "/" + 5);

            // Aplica os valores nos progressos em círculo
            progressDelivery.setProgress(ratingDelivery * 20);
            txtDelivery.setText(Integer.toString(ratingDelivery));

            progressFood.setProgress(ratingFood * 20);
            txtFood.setText(Integer.toString(ratingFood));

            progressCorrect.setProgress(ratingCorrect * 20);
            txtCorrect.setText(Integer.toString(ratingCorrect));
        } else {
            Toast.makeText(this, "Não foi possível buscar os dados da activity anterior!", Toast.LENGTH_LONG).show();
        }
    }
}