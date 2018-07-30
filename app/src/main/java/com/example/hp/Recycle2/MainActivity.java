package com.example.hp.Recycle2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private int mCount = 0;
    private RecyclerView mRecyclerView;
    private com.example.hp.Recycle2.WordListAdapter mAdapter;
    public static final int TEXT_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Flame	" + mCount++);
        }


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new com.example.hp.Recycle2.WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                mWordList.addLast("+Flame	" + wordListSize);
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });

    }

    public void LaunchSecondActivity(View view) {
        Intent intent = new Intent(this, Description.class);
        startActivityForResult(intent, TEXT_REQUEST);

    }
}
