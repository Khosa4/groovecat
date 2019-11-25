package de.groovecat.client.view.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import de.groovecat.client.R;
import de.groovecat.client.common.ToolbarActivity;

/**
 * Created by Muki-Zenbook on 10.11.2016.
 */

@EActivity(R.layout.activity_home)
public class HomeActivity extends ToolbarActivity {

    @ViewById protected ViewPager viewpager;
    @ViewById protected TabLayout sliding_tabs;

    @AfterViews
    protected void initViews() {
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), this));
        sliding_tabs.setupWithViewPager(viewpager);
        for (int i = 0; i < 3; i++) {
            View view1 = getLayoutInflater().inflate(R.layout.custom_tab, null);
            ImageView imageView = (ImageView) view1.findViewById(R.id.icon);
            imageView.setImageDrawable(ViewPagerAdapter.icons.get(i));
            sliding_tabs.getTabAt(i).setCustomView(view1);
        }
    }

    @Override
    public int getToolbarMenu() {
        return R.menu.empty_menu;
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    public int getToolbarIcon() {
        return R.drawable.logo;
    }
}
