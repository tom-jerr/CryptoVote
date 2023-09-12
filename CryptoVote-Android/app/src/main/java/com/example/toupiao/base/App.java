package com.example.toupiao.base;



import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;




import java.io.File;

public class App extends Application {
    /**
     * 全局Context，方便引用
     */
    public static App application = null;
    public static Context context;
    public static Handler handler;
    public static int mNetWorkState;
    public static boolean is_debug = false;
    /* 文件缓存的目录 */
    public String mAppDir01;
    public String mPicturesDir01;
    public String mVoicesDir01;
    public String mVideosDir01;
    public String mFilesDir01;
    /* 文件缓存的目录 */
    public String mAppDir;
    public String mPicturesDir;
    public String mVoicesDir;
    public String mVideosDir;
    public String mFilesDir;


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        context = getApplicationContext();
        handler = new Handler();
        initAppDir();
        initAppDirsecond();
    }
    private void initAppDirsecond() {
        File file = getExternalFilesDir(null);

        if (file == null) {
            return;
        }

        if (!file.exists()) {
            file.mkdirs();
        }
        mAppDir01 = file.getAbsolutePath();

        file = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!file.exists()) {
            file.mkdirs();
        }
        mPicturesDir01 = file.getAbsolutePath();

        file = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (!file.exists()) {
            file.mkdirs();
        }
        mVoicesDir01 = file.getAbsolutePath();

        file = getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (!file.exists()) {
            file.mkdirs();
        }
        mVideosDir01 = file.getAbsolutePath();

        file = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (!file.exists()) {
            file.mkdirs();
        }
        mFilesDir01 = file.getAbsolutePath();
    }

    private void initAppDir() {
        File file = getExternalFilesDir(null);
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        if (file != null) {
            mAppDir = file.getAbsolutePath();
        }

        file = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        if (file != null) {
            mPicturesDir = file.getAbsolutePath();
        }

        file = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        if (file != null) {
            mVoicesDir = file.getAbsolutePath();
        }

        file = getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        if (file != null) {
            mVideosDir = file.getAbsolutePath();
        }

        file = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        if (file != null) {
            mFilesDir = file.getAbsolutePath();
        }
    }

}
