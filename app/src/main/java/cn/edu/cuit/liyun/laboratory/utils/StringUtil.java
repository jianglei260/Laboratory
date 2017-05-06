package cn.edu.cuit.liyun.laboratory.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jianglei on 2016/12/1.
 */

public class StringUtil {
    public static String playMosaic(String src, int start, int num) {
        if (start <= 0 || start + num > src.length())
            throw new IllegalArgumentException("range is not in " + src + "\'s length");
        char[] chars = new char[num];
        for (int i = 0; i < num; i++) {
            chars[i] = '*';
        }
        String mosaic = new String(chars);
        return src.replace(src.substring(start, start + num), mosaic);
    }

    public static String getFormatDate(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        Date date = new Date(time);
        return format.format(date);
    }
}
