# StatusBarColor
android状态栏沉浸式demo
##效果图



![4.4.png](http://upload-images.jianshu.io/upload_images/2379788-d4ff0fdc334def74.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![5.0.png](http://upload-images.jianshu.io/upload_images/2379788-6dfe6b4674a315be.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##代码
在oncreate()方法里
```  
 //如果等于API等于19
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            //设置状态栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置layout不留出空间
            drawer.setFitsSystemWindows(false);


        }

        //如果api大于21
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //设置navigationview预留出空间，不设置此项，navigaionview布局不会到状态栏
            navigationView.setFitsSystemWindows(true);

            //设置可以修改状态栏背景
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //toolbar.setBackgroundColor(Color.parseColor("#ff00ba90"));

            //隐藏自己添加的statusbar
            findViewById(R.id.status_bar).setVisibility(View.GONE);
            // getWindow().setStatusBarColor(Color.parseColor("#00ff00"));

            //设置状态栏为透明颜色
            getWindow().setStatusBarColor(Color.parseColor("#00000000"));
        }
```



在app_bar_main布局文件里加入
```

<RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="false"
        >

    <include layout="@layout/status_bar"
            android:visibility="visible"

            />

    <android.support.design.widget.CoordinatorLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            tools:context="haydar.myapplication.MainActivity"
            android:layout_below="@+id/status_bar"

            >

        <android.support.design.widget.AppBarLayout
                android:layout_height="wrap_content"
                android:layout_width="match_parent"
                android:theme="@style/AppTheme.AppBarOverlay"
                >

            <android.support.v7.widget.Toolbar
                    android:id="@+id/toolbar"
                    android:layout_width="match_parent"
                    android:layout_height="?actionBarSize"
                    android:background="?attr/colorPrimary"
                    app:popupTheme="@style/AppTheme.PopupOverlay"

                    />

        </android.support.design.widget.AppBarLayout>

        <include layout="@layout/content_main"/>

        <android.support.design.widget.FloatingActionButton
                android:id="@+id/fab"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="bottom|end"
                android:layout_margin="@dimen/fab_margin"
                app:srcCompat="@android:drawable/ic_dialog_email"/>

    </android.support.design.widget.CoordinatorLayout>


</RelativeLayout>
```

status_bar.xml
```
<?xml version="1.0" encoding="utf-8"?>
<View xmlns:android="http://schemas.android.com/apk/res/android"
      android:id="@+id/status_bar"
      android:background="#ff009573"
      android:layout_width="fill_parent"
      android:layout_height="@dimen/status_bar_padding_top"/>

```
status_bar_padding
values里dimen是0.0dp
values-v19是24.0dp
values-v21是24.0dp

在values-v21文件夹里新建style
```
<resources>
             <style name="AppTheme.NoActionBar">
        <item name="android:windowBackground">@color/white</item>

        <item name="android:actionModeBackground">?colorPrimaryDark</item>
        <item name="android:windowTranslucentStatus">false</item>
        <item name="android:windowTranslucentNavigation">false</item>
        <item name="android:windowContentTransitions">true</item>
        <item name="android:windowDrawsSystemBarBackgrounds">true</item>
        <item name="android:statusBarColor">@android:color/transparent</item>
        <item name="windowActionBar">false</item>

        <item name="windowNoTitle">true</item>
        <item name="windowActionModeOverlay">true</item>
    </style>
</resources>
```
