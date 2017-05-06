package cn.edu.cuit.liyun.laboratory.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.Log;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.HashMap;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseActivity;
import cn.edu.cuit.liyun.laboratory.data.entity.Discuss;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private BottomNavigationBar bottomNavigationView;
    private HashMap<Integer, Fragment> menuMap;
    private Fragment selectd;
    private FrameLayout container;
    private EventFragment eventFragment;
    private DiscussFragment discussFragment;
    private MeFragment meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (FrameLayout) findViewById(R.id.container);
        bottomNavigationView = (BottomNavigationBar) findViewById(R.id.bottom_navigation);
        initFragment(savedInstanceState);
        menuMap = new HashMap<>();
        initBottomNavigation();
    }
    /*
   *初始化底部导航栏
   */
    public void initBottomNavigation() {
        bottomNavigationView.addItem(initItem(R.drawable.ic_event, R.string.event, 0, eventFragment))
                .addItem(initItem(R.drawable.ic_discuss, R.string.discuss, 1, discussFragment))
                .addItem(initItem(R.drawable.ic_me, R.string.me, 2, meFragment)).initialise();
//        bottomNavigationView.setMode(BottomNavigationBar.MODE_DEFAULT);
//        bottomNavigationView.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
//        bottomNavigationView.setBarBackgroundColor(R.color.white);
        bottomNavigationView.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                show(menuMap.get(position));
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
    public void initFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (!getFragmentManager().isDestroyed()) {
                EventFragment event = (EventFragment) getFragmentManager().findFragmentByTag("event");
                if (event != null)
                    eventFragment = event;
                else
                    initEvent();
                DiscussFragment discuss = (DiscussFragment) getFragmentManager().findFragmentByTag("discuss");
                if (discuss != null)
                    discussFragment = discuss;
                else
                    initDiscuss();
                MeFragment me = (MeFragment) getFragmentManager().findFragmentByTag("me");
                if (me != null)
                    meFragment = me;
                else
                    initMe();
            }
        } else {
            initEvent();
            initDiscuss();
            initMe();
        }
        getFragmentManager().beginTransaction().show(eventFragment).hide(discussFragment).hide(meFragment).commit();
        selectd = eventFragment;
    }
    public void initEvent() {
        eventFragment = new EventFragment();
        getFragmentManager().beginTransaction().add(R.id.container, eventFragment, "event").commit();
    }

    public void initDiscuss() {
        discussFragment = new DiscussFragment();
        getFragmentManager().beginTransaction().add(R.id.container, discussFragment, "discuss").hide(discussFragment).commit();
    }

    public void initMe() {
        meFragment = new MeFragment();
        getFragmentManager().beginTransaction().add(R.id.container, meFragment, "me").hide(meFragment).commit();
    }
    public BottomNavigationItem initItem(@DrawableRes int icon, @StringRes int title, int position, Fragment fragment) {
        BottomNavigationItem item = new BottomNavigationItem(icon, getString(title));
        item.setActiveColorResource(R.color.colorPrimary);
        item.setInActiveColorResource(R.color.deepGray);
        menuMap.put(position, fragment);
        return item;
    }
    private void show(Fragment fragment) {
        Log.d(TAG, "show: " + fragment.getClass().getName());
        if (fragment == selectd)
            return;
        if (selectd != null)
            getFragmentManager().beginTransaction().hide(selectd).commit();
        getFragmentManager().beginTransaction().show(fragment).commit();
        selectd = fragment;
    }
}
