package com.inu.dimipetition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    PetitionListRecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UtilClass.SetStatusBarColor(getWindow(), getApplicationContext(), R.color.colorPrimary);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_root);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        recyclerAdapter = new PetitionListRecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter.addItem("테스트용 분류","준호는 정말 잘생겼어요 그리고 이 레이아웃은 밑으로도 늘어나지요",699264);
        recyclerAdapter.addItem("생활/기숙사","학생들의 정당한",2543);
        recyclerAdapter.addItem("생확/기숙사","학봉관에 와이파이를 설치하여 학생들의 여가를 보장해 주세요",45566);
        recyclerAdapter.addItem("생활/기숙사","학생의 인권을 침해하는 야외점호 제도를 폐지해주세요",58956);
        recyclerAdapter.addItem("생활/기숙사","학생들의 정당한",2543);
        recyclerAdapter.addItem("생확/기숙사","학봉관에 와이파이를 설치하여 학생들의 여가를 보장해 주세요",45566);
    }
}
