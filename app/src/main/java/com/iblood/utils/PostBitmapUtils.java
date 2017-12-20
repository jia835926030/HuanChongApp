package com.iblood.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import cn.qqtheme.framework.util.FileUtils;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/19.
 */

public class PostBitmapUtils {
    Bitmap bmp;
    String imagePath;

    //通过uri获取图片的绝对url
    public static String getPathUrlFromUri(Context context, android.net.Uri uri){
        if ( null == uri ) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if ( scheme == null )
            data = uri.getPath();
        else if ( ContentResolver.SCHEME_FILE.equals( scheme ) ) {
            data = uri.getPath();
        } else if ( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
            Cursor cursor = context.getContentResolver().query( uri, new String[] { MediaStore.Images.ImageColumns.DATA }, null, null, null );
            if ( null != cursor ) {
                if ( cursor.moveToFirst() ) {
                    int index = cursor.getColumnIndex( MediaStore.Images.ImageColumns.DATA );
                    if ( index > -1 ) {
                        data = cursor.getString( index );
                    }
                }
                cursor.close();
            }
        }
        return data;
    }
    //通过url获取到Bitmap对象
    public static Bitmap getBitmap(String path) {
        Bitmap bm = null;
        InputStream is = null;
        try {
            File outFilePath = new File(path);
            //判断如果当前的文件不存在时，创建该文件一般不会不存在
            if (!outFilePath.exists()) {
                boolean flag = false;
                try {
                    flag = outFilePath.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("---创建文件结果----" + flag);
            }
            is = new FileInputStream(outFilePath);
            bm = BitmapFactory.decodeStream(is);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bm;
    }
}
