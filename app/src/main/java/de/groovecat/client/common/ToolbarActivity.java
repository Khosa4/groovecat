package de.groovecat.client.common;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by mgerc on 26.10.2016.
 */

@EActivity
public abstract class ToolbarActivity extends AppCompatActivity {

    @ViewById public Toolbar toolbar;

    @ViewById public TextView toolbar_title;

    @ViewById public ImageView toolbar_image;

    public abstract int getToolbarMenu();

    public abstract String getToolbarTitle();

    public abstract int getToolbarIcon();


    @AfterViews
    protected void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (getToolbarTitle() != null) {
            toolbar_title.setText(getToolbarTitle());
        } else {
            toolbar_title.setVisibility(View.GONE);
        }
        if (getToolbarIcon() != 0) {
            toolbar_image.setImageDrawable(ContextCompat.getDrawable(this, getToolbarIcon()));
        } else {
            toolbar_image.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(getToolbarMenu(), menu);
        return true;
    }
}
