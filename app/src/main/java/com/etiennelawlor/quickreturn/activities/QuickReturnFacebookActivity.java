package com.etiennelawlor.quickreturn.activities;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.etiennelawlor.quickreturn.R;
import com.etiennelawlor.quickreturn.fragments.QuickReturnFacebookFragment;
import com.etiennelawlor.quickreturn.interfaces.QuickReturnInterface;
import com.etiennelawlor.quickreturn.utils.QuickReturnUtils;


public class QuickReturnFacebookActivity extends QuickReturnBaseActivity implements ActionBar.TabListener, QuickReturnInterface {

    // region Member Variables
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private PagerSlidingTabStrip mTabs;
    private ViewPager mViewPager;
    private LinearLayout mTabsLinearLayout;
    // endregion

    // region Listeners
    private ViewPager.OnPageChangeListener mTabsOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            for(int i=0; i < mTabsLinearLayout.getChildCount(); i++){
                ImageButton ib = (ImageButton) mTabsLinearLayout.getChildAt(i);
                switch (i){
                    case 0:
                        if(i == position)
                            ib.setImageResource(R.drawable.ic_action_event_highlighted);
                        else
                            ib.setImageResource(R.drawable.ic_action_event);
                        break;
                    case 1:
                        if(i == position)
                            ib.setImageResource(R.drawable.ic_action_cc_bcc_highlighted);
                        else
                            ib.setImageResource(R.drawable.ic_action_cc_bcc);
                        break;
                    case 2:
                        if(i == position)
                            ib.setImageResource(R.drawable.ic_action_chat_highlighted);
                        else
                            ib.setImageResource(R.drawable.ic_action_chat);
                        break;
                    case 3:
                        if(i == position)
                            ib.setImageResource(R.drawable.ic_action_web_site_highlighted);
                        else
                            ib.setImageResource(R.drawable.ic_action_web_site);
                        break;
                    case 4:
                        if(i == position)
                            ib.setImageResource(R.drawable.ic_action_sort_by_size_highlighted);
                        else
                            ib.setImageResource(R.drawable.ic_action_sort_by_size);
                        break;
                    default:
                        break;
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    // endregion

    // region Lifecycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_return_facebook);

        bindUIElements();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mTabs.setAllCaps(false);
        mTabs.setShouldExpand(true);
//        mTabs.setTextSize(QuickReturnUtils.dp2px(this, 16));
//        mTabs.setTabBackground(R.drawable.selector_bg_tab);
        mTabs.setIndicatorColorResource(R.color.steel_blue);
        mTabs.setIndicatorHeight(QuickReturnUtils.dp2px(this, 5));
        mTabs.setDividerColor(getResources().getColor(android.R.color.transparent));
//        mTabs.setBackgroundColor(getResources().getColor(R.color.indigo));
        mTabs.setOnPageChangeListener(mTabsOnPageChangeListener);
        mTabs.setViewPager(mViewPager);

        // Set first tab selected
        mTabsLinearLayout = ((LinearLayout)mTabs.getChildAt(0));
        ImageButton ib = (ImageButton) mTabsLinearLayout.getChildAt(0);
        ib.setImageResource(R.drawable.ic_action_event_highlighted);

    }
    // endregion

    // region ActionBar.TabListener Methods
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
    // endregion

    // region QuickReturnInterface Methods
    @Override
    public PagerSlidingTabStrip getTabs() {
        return mTabs;
    }

    @Override
    public ViewPager getViewPager() {
        return mViewPager;
    }
    // endregion

    // region Helper Methods
    private void bindUIElements(){
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mTabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
    }
    // endregion

    // region Inner Classes

    /**
     * A {@link android.support.v13.app.FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return QuickReturnFacebookFragment.newInstance();
                case 1:
                    return QuickReturnFacebookFragment.newInstance();
                case 2:
                    return QuickReturnFacebookFragment.newInstance();
                case 3:
                    return QuickReturnFacebookFragment.newInstance();
                case 4:
                    return QuickReturnFacebookFragment.newInstance();
                default:
                    return QuickReturnFacebookFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public int getPageIconResId(int position) {
            switch (position) {
                case 0:
                    return R.drawable.ic_action_event;
                case 1:
                    return R.drawable.ic_action_cc_bcc;
                case 2:
                    return R.drawable.ic_action_chat;
                case 3:
                    return R.drawable.ic_action_web_site;
                case 4:
                    return R.drawable.ic_action_sort_by_size;
            }

            return 0;
        }

    }

    // endregion

}