package com.example.practicedraganddrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener{
    private TextView textView;
    private LinearLayout leftLayout;
    private LinearLayout rightLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tezt);
        leftLayout = findViewById(R.id.left_layout);
        rightLayout = findViewById(R.id.right_layout);

        textView.setOnLongClickListener(this);

        CustomDragListener listener = new CustomDragListener();
        leftLayout.setOnDragListener(listener);
        rightLayout.setOnDragListener(listener);
    }

    @Override
    public boolean onLongClick(View v) {
        ClipData data = ClipData.newPlainText("text", ((TextView)v).getText().toString());
        v.startDrag(data, new View.DragShadowBuilder(v), (Object)v, 0);
        return true;
    }
}