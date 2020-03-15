package com.github.novotnyr.android.yello;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class NoteViewModel extends AndroidViewModel {

    private LiveData<List<Note>> notes;

    private NoteDao noteDao;

    private AppDatabase db;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getDb(application);
        noteDao = db.noteDao();
        notes = noteDao.list();
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        db.getTransactionExecutor().execute(() -> noteDao.save(note));
    }

}
