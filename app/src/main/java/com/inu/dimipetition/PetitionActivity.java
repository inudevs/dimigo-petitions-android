package com.inu.dimipetition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PetitionActivity extends AppCompatActivity {
    Context context;

    ShareDialog shareDialog;
    PetitionItem petitionItem;

    TextView category;
    TextView title;
    TextView participant;
    TextView participant2;

    LinearLayout root;

    ImageButton back;
    ImageButton share;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition);

        context = this;

        shareDialog = new ShareDialog(this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        petitionItem = (PetitionItem) getIntent().getSerializableExtra("data");

        category = (TextView) findViewById(R.id.text_category);
        title = (TextView) findViewById(R.id.text_title);
        participant = (TextView) findViewById(R.id.text_participant);
        participant2 = (TextView) findViewById(R.id.text_participant2);

        root = (LinearLayout) findViewById(R.id.layout_root);

        back = (ImageButton) findViewById(R.id.imgbtn_back);
        share = (ImageButton) findViewById(R.id.imgbtn_share);

        category.setText(petitionItem.getCategory());
        title.setText(petitionItem.getTitle());
        participant.setText(String.valueOf(petitionItem.getParticipant()));
        participant2.setText(String.valueOf(petitionItem.getParticipant()));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareDialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
