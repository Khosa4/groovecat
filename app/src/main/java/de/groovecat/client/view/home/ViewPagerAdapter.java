package de.groovecat.client.view.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.groovecat.client.R;
import de.groovecat.client.view.discovery.DiscoveryFragment_;
import de.groovecat.client.view.feed.FeedFragment_;
import de.groovecat.client.view.profile.ProfileFragment_;

/**
 * Created by Muki-Zenbook on 10.11.2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public final static List<Drawable> icons = new ArrayList<>();
    private Context context;
    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();


    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        initIconsAndTitles();

    }

    private void initIconsAndTitles() {
        icons.add(ContextCompat.getDrawable(context, R.drawable.ic_feed));
        icons.add(ContextCompat.getDrawable(context, R.drawable.ic_disvovery));
        icons.add(ContextCompat.getDrawable(context, R.drawable.ic_profile));

    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // save the appropriate reference depending on position
        switch (position) {
            case 0:
                FeedFragment_ feedFragment = (FeedFragment_) super.instantiateItem(container, position);
                registeredFragments.put(position, feedFragment);
                return feedFragment;
            case 1:
                DiscoveryFragment_ searchFragment = (DiscoveryFragment_) super.instantiateItem(container, position);
                registeredFragments.put(position, searchFragment);
                return searchFragment;

            case 2:
                ProfileFragment_ profileFragment = (ProfileFragment_) super.instantiateItem(container, position);
                registeredFragments.put(position, profileFragment);
                return profileFragment;
        }
        return null;
    }

    @Override
    public Fragment getItem(int position) {
        // Do NOT try to save references to the Fragments in getItem(),
        // because getItem() is not always called. If the Fragment
        // was already created then it will be retrieved from the FragmentManger
        // and not here (i.e. getItem() won't be called again).
        switch (position) {
            case 0:
                return new FeedFragment_();
            case 1:
                return new DiscoveryFragment_();
            case 2:
                return new ProfileFragment_();
            default:
                // This should never happen. Always account for each position above
                return null;
        }
    }
}
