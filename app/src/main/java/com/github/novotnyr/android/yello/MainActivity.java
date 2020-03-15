package com.github.novotnyr.android.yello;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.*;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.*;
import butterknife.*;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.noteRecyclerView)
    RecyclerView noteRecyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    NoteListAdapter noteListAdapter;

    NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        noteRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        noteListAdapter = new NoteListAdapter();

        noteRecyclerView.setAdapter(noteListAdapter);


        ViewModelProvider.AndroidViewModelFactory viewModelFactory
                = new ViewModelProvider.AndroidViewModelFactory(getApplication());
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, viewModelFactory);
        noteViewModel = viewModelProvider.get(NoteViewModel.class);

        noteViewModel.getNotes().observe(this, notes -> noteListAdapter.submitList(notes));
    }

    @OnClick(R.id.fab)
    public void onAddNote(View view) {
        EditText descriptionEditText = new EditText(this);
        new AlertDialog.Builder(this)
                .setView(descriptionEditText)
                .setPositiveButton("Save", (dialog, which) -> onDialogOkClick(descriptionEditText))
                .show();
    }

    public void onDialogOkClick(EditText descriptionEditText) {
        Note note = new Note();
        note.setDescription(descriptionEditText.getText().toString());
        noteViewModel.addNote(note);
    }
}
