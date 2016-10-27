

package com.michaelwu.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button playGameButton, settingsButton, rateThisAppButton;
    private RatingBar ratingBarRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        rateThisAppButton.setVisibility(View.GONE);
        //responses rating bar
        ratingBarRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()

        {
            public void onRatingChanged (RatingBar ratingBar,float rating,
                                         boolean fromUser){
                double d = rating;
                if (d <= 1)
                    Toast.makeText(MainActivity.this, getString(R.string.activity_main_Toast_die_die_Die), Toast.LENGTH_SHORT).show();
                else if (d <= 2)
                    Toast.makeText(MainActivity.this, getString(R.string.activity_main_Toast_you_know_this_deserves_at_least_a_3_star), Toast.LENGTH_SHORT).show();
                else if (d <= 3)
                    Toast.makeText(MainActivity.this, getString(R.string.activity_main_Toast_this_deserves_at_least_a_4_star), Toast.LENGTH_SHORT).show();
                else if (d <= 4)
                    Toast.makeText(MainActivity.this, getString(R.string.activity_main_Toast_this_deserves_at_least_a_5_star), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, getString(R.string.activity_main_Toast_ty_ty), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void wireWidgets() {
        playGameButton = (Button) findViewById(R.id.activity_main_button_play_game);
        settingsButton = (Button) findViewById(R.id.activity_main_button_settings);
        rateThisAppButton = (Button) findViewById(R.id.activity_main_button_rate_this_app);
        ratingBarRatingBar = (RatingBar) findViewById(R.id.activity_main_ratingbar_ratingbar);
    }

    public void activity_main_button_play_game_clicked(View view) {
        startActivity(new Intent(this, PvpActivity.class));

    }

    //TODO: toggle the rating bar when rate this app is clicked.
    public void activity_main_button_rate_this_app_clicked(View view) {

        //toggling text w/ the rating bar
        if (rateThisAppButton.getText().equals(getString(R.string.activity_main_button_rate_this_app))) {
            rateThisAppButton.setText("hide");
            ratingBarRatingBar.setVisibility(View.GONE);
        } else {
            rateThisAppButton.setText(getString(R.string.activity_main_button_rate_this_app));
            ratingBarRatingBar.setVisibility(View.VISIBLE);
        }
    }


    public void activity_main_button_setting_clicked(View view) {
        startActivity(new Intent(this,SettingActivity.class));

    }
}
