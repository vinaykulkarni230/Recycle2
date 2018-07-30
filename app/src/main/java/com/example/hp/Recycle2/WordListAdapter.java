package com.example.hp.Recycle2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LayoutInflater mInflater;

    private final LinkedList<String> mWordList;

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }


    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView wordItemView;
        public final ImageView wordItemView2;

        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word1);
            wordItemView2 = (ImageView) itemView.findViewById(R.id.image1);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
           //mWordList.set(mPosition, "Clicked!	" + element);
            mAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }


    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
