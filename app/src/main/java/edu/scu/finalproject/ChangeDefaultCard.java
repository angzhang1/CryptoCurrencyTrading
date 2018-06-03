package edu.scu.finalproject;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChangeDefaultCard extends AppCompatActivity {
    private static final String[] cards = {"ending with 1111", "ending with 2222", "ending with 3333"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_default_card);

        Toolbar myToolbar = findViewById(R.id.default_card_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
        }

        ListView all_cards = findViewById(R.id.lv_all_cards);
        all_cards.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter cards_adapter = new ArrayAdapter<>(this, R.layout.checked_credit_card_entry,
                R.id.card_lv_item, cards);
        all_cards.setAdapter(cards_adapter);
    }
}
