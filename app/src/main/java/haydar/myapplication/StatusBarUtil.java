package haydar.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

/**
 * @author Haydar
 * @Package haydar.myapplication
 * @DATE 2017-02-28
 */

public class StatusBarUtil {



    public static void setNavigationStatusColor(Activity activity, int color) {
        //如果等于API等于19
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            //设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置layout不留出空间
            activity.findViewById(R.id.drawer_layout).setFitsSystemWindows(false);
        }

        //如果api大于21
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //设置navigationview预留出空间，不设置此项，navigaionview布局不会到状态栏
            activity.findViewById(R.id.nav_view).setFitsSystemWindows(true);

            //设置可以修改状态栏背景
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //toolbar.setBackgroundColor(Color.parseColor("#ff00ba90"));

            //隐藏自己添加的statusbar
            activity.findViewById(R.id.status_bar).setVisibility(View.GONE);
            // getWindow().setStatusBarColor(Color.parseColor("#00ff00"));

            //设置状态栏为透明颜色
            activity.getWindow().setStatusBarColor(Color.parseColor("#00000000"));
        }
        activity.findViewById(R.id.status_bar).setBackgroundColor(color);
    }
}
