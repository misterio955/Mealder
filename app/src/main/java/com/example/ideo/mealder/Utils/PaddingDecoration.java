package com.example.ideo.mealder.Utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class PaddingDecoration extends RecyclerView.ItemDecoration {
    private int padding;
    private Type[] types;

    public PaddingDecoration(int padding, Type... types) {
        this.padding = padding;
        this.types = types;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (contains(Type.Top) && parent.getChildAdapterPosition(view) == 0)
            outRect.top = padding;
        if (contains(Type.Bottom) && parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1)
            outRect.bottom = padding;
    }

    private boolean contains(Type type) {
        for (Type t : types) if (t == type) return true;
        return false;
    }

    public enum Type {
        Top, Bottom
    }
}