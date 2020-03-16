package com.github.novotnyr.android.yello;

import android.view.*;

import androidx.annotation.*;
import androidx.recyclerview.widget.ListAdapter;

public class NoteListAdapter extends ListAdapter<Note, NoteViewHolder> {

    public NoteListAdapter() {
        super(new NoteDiff());
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @LayoutRes int layout = R.layout.note;
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(layout, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.setNote(getItem(position));
    }
}
