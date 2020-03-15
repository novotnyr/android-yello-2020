package com.github.novotnyr.android.yello;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class NoteDiff extends DiffUtil.ItemCallback<Note> {
    @Override
    public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
        return Objects.equals(oldItem.getId(), newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
        return Objects.equals(oldItem.getDescription(), newItem.getDescription())
                && Objects.equals(oldItem.getTimestamp(), newItem.getTimestamp());
    }
}