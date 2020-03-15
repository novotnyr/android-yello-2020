package com.github.novotnyr.android.yello;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import butterknife.*;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.noteRecyclerView)
    RecyclerView noteRecyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    NoteListAdapter noteListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        noteRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        noteListAdapter = new NoteListAdapter();
        noteRecyclerView.setAdapter(noteListAdapter);
    }

    @OnClick(R.id.fab)
    public void onAddNote(View view) {
        Snackbar.make(view, "Klik!", Snackbar.LENGTH_SHORT).show();
    }
}
