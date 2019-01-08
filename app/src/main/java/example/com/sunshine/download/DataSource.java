package example.com.sunshine.download;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspsine on 2015/7/8.
 */
public class DataSource {

    private static DataSource sDataSource = new DataSource();

    private static final String[] NAMES = {
            "网易云音乐",
            "优酷",
            "腾讯视频",
            "网易云音乐",
            "360手机卫士",
            "前程无忧51job",
            "搜狐视频",
            "微信电话本",
            "淘宝",
            "聚美优品",
    };

    private static final String[] IMAGES = {
            "http://img.wdjimg.com/mms/icon/v1/d/f1/1c8ebc9ca51390cf67d1c3c3d3298f1d_512_512.png",
            "http://img.wdjimg.com/mms/icon/v1/3/2d/dc14dd1e40b8e561eae91584432262d3_512_512.png",
            "http://img.wdjimg.com/mms/icon/v1/8/10/1b26d9f0a258255b0431c03a21c0d108_512_512.png",
            "http://img.wdjimg.com/mms/icon/v1/d/f1/1c8ebc9ca51390cf67d1c3c3d3298f1d_512_512.png",
            "http://img.wdjimg.com/mms/icon/v1/d/29/dc596253e9e80f28ddc84fe6e52b929d_512_512.png",
            "http://img.wdjimg.com/mms/icon/v1/e/d0/03a49009c73496fb8ba6f779fec99d0e_512_512.png",
            "http://img.wdjimg.com/mms/icon/v1/2/bf/939a67b179e75326aa932fc476cbdbf2_512_512.png",
            "http://img.wdjimg.com/mms/icon/v1/b/fe/718d7c213ce633fd4e25c278c19acfeb_512_512.png",
            "http://img.wdjimg.com/mms/icon/v1/f/29/cf90d1294ac84da3b49561a6f304029f_512_512.png",
            "http://img.wdjimg.com/mms/icon/v1/4/43/0318ce32731600bfa66cbb5018e1a434_512_512.png",
    };

    private static final String[] URLS = {
            "http://s1.music.126.net/download/android/CloudMusic_2.8.1_official_4.apk",
            "http://dl.m.cc.youku.com/android/phone/Youku_Phone_youkuweb.apk",
            "http://dldir1.qq.com/qqmi/TencentVideo_V4.1.0.8897_51.apk",
            "http://s1.music.126.net/download/android/CloudMusic_2.8.1_official_4.apk",
            "http://msoftdl.360.cn/mobilesafe/shouji360/360safesis/360MobileSafe_6.2.3.1060.apk",
            "http://www.51job.com/client/51job_51JOB_1_AND2.9.3.apk",
            "http://upgrade.m.tv.sohu.com/channels/hdv/5.0.0/SohuTV_5.0.0_47_201506112011.apk",
            "http://dldir1.qq.com/qqcontacts/100001_phonebook_4.0.0_3148.apk",
            "http://download.alicdn.com/wireless/taobao4android/latest/702757.apk",
            "http://apps.wandoujia.com/apps/com.jm.android.jumei/download",
    };

    public static DataSource getInstance() {
        return sDataSource;
    }

    public List<Task> getData() {
        List<Task> appInfos = new ArrayList<>();
        for (int i = 1; i < NAMES.length; i++) {
            final Task task1 = new Task();
            task1.setName(NAMES[i]);
            task1.setIamgeUrl(IMAGES[i]);
            task1.setId(i);
            task1.setmUniquely_id(String.valueOf(i));
            task1.setUrl(URLS[i]);
            appInfos.add(task1);
        }
        return appInfos;
    }
}
