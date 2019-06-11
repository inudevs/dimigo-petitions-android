package com.inu.dimipetition;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

//이 유틸리티 클래스는 여러가지 기능을 한 곳에 모아놓아 그다지 보기에 좋은 형태가 아닐 수 있습니다.

@SuppressWarnings("WeakerAccess")
public final class UtilClass {

    //안드로이드 스테이터스 바 색상을 변경할 수 있습니다, 인자로는 ( getWindow(), getApplicationContext, '원하는 색상의 ID 값' ) 을 넣어주면 됩니다.
    public static void SetStatusBarColor(Window win, Context context, Integer id)
    {
        win.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        win.setStatusBarColor(ContextCompat.getColor(context, id));
    }

}
