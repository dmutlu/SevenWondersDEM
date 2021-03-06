package edu.umbc.dmutlu1.sevenwondersdem;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private ImageView expandedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setNestedScrollingEnabled(true);

        gridview.setOnItemClickListener((adapterView, view, pos, id) -> {
            zoomImageFromThumb(ImageAdapter.mThumbIds[pos]);
            makeToast(ImageAdapter.imageDescriptions[pos]);
        });
    }

    private void zoomImageFromThumb(int imageResId)
    {
        // Load the high-resolution "zoomed-in" image.
        expandedImageView = findViewById(R.id.expanded_image);
        expandedImageView.setImageResource(imageResId);
        expandedImageView.setBackground(getDrawable(R.drawable.image_background));
        expandedImageView.setVisibility(0);

        expandedImageView.setOnClickListener(view -> expandedImageView.setVisibility(4));
    }

    private void makeToast(String text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
