package com.example.hekd.kotlinapp.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by hekd on 2017/12/29.
 */

public class PermissionUtils {

    private static final int RESULT_PICK = 1001;

    public static void premissionPic(Context context, Activity activity) {

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, RESULT_PICK);
            }
        } else {
            //选择图片
            startPickPhoto(context);
        }


    }

    private static void startPickPhoto(Context context) {
        Toast.makeText(context, "选择图片", Toast.LENGTH_SHORT).show();
    }

}
