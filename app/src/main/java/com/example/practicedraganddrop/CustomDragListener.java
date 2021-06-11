package com.example.practicedraganddrop;

import android.graphics.Color;
import android.view.DragEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomDragListener implements View.OnDragListener {
    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DROP:
                View dragView = (View) event.getLocalState();
                dragView.setBackgroundColor(Color.TRANSPARENT);
                ((TextView)dragView).setTextColor(Color.BLACK);

                ((LinearLayout) dragView.getParent()).removeView(dragView);
                ((LinearLayout) v).addView(dragView);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                break;

        }
        return true;
    }
}
