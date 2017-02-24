package edu.csulb.android.zooapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            int resID = extras.getInt("resID");
            String name = extras.getString("name");
            String description = extras.getString("description");

            setTitle(name);
            imageView.setImageResource(resID);
            textView.setText(description);
        }
    }
}
