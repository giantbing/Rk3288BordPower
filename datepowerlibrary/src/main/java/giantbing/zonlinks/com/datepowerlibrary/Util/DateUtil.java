package giantbing.zonlinks.com.datepowerlibrary.Util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by P on 2017/8/9.
 */

public class DateUtil {
    private static final String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    /**
     * 得到几天前的时间
     *
     * @param day
     * @return date
     */
    public static Date getDateBefore(int day) {
        Date dNow = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(dNow);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param day
     * @return
     */
    public static Date getDateAfter(int day) {
        Date dNow = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(dNow);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    //根据日期取得星期几
    public static String getWeek(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * 根据Date获取星期几
     *
     * @return int
     * ex.
     * 0:星期天
     * 1：星期一
     */
    public static int getWeekInt(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return week_index;
    }

    /**
     * 根据Date获取年月日数组
     *
     * @return int[3]
     * ex.
     * int[0]:年
     * int[1]:月
     * int[2]:日
     */
    public static int[] getDateArray(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int[] dateArray = new int[3];
        dateArray[0] = cal.get(Calendar.YEAR) ;
        dateArray[1] = cal.get(Calendar.MONTH)+1 ;
        dateArray[2] = cal.get(Calendar.DATE) ;
        return dateArray;
    }
}
