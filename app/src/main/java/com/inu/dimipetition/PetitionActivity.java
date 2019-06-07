package com.inu.dimipetition;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class PetitionActivity extends AppCompatActivity {
    Context context;

    PetitionItem petitionItem;

    TextView category;
    TextView title;
    TextView participant;

    LinearLayout root;

    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition);

        context = this;

        petitionItem = (PetitionItem) getIntent().getSerializableExtra("data");

        category = (TextView) findViewById(R.id.text_category);
        title = (TextView) findViewById(R.id.text_title);
        participant = (TextView) findViewById(R.id.text_participant);

        root = (LinearLayout) findViewById(R.id.layout_root);

        back = (ImageButton) findViewById(R.id.imgbtn_back);

        category.setText(petitionItem.getCategory());
        title.setText(petitionItem.getTitle());
        participant.setText(petitionItem.getParticipant().toString());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
