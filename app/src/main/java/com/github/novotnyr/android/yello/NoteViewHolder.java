package com.github.novotnyr.android.yello;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.*;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text)
    TextView text;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setNote(Note note) {
        this.text.setText(note.getDescription());
    }
}