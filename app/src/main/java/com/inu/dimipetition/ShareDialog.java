package com.inu.dimipetition;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ShareDialog extends Dialog {
    Context context;

    Button cancel;
    LinearLayout cancelPanel;

    public ShareDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public ShareDialog(@NonNull Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_share);

        cancel = (Button) findViewById(R.id.btn_cancel);
        cancelPanel = (LinearLayout) findViewById(R.id.btn_cancelpanel);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
        cancelPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }
}


