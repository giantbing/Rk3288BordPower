package giantbing.zonlinks.com.datepowerlibrary.Util;

import android.content.Context;
import android.content.Intent;

import java.util.Date;

import giantbing.zonlinks.com.datepowerlibrary.Bean.PowerBean;

/**
 * Created by P on 2017/9/14.
 */

public class HradvareUtil {
    public static void setoff(Context context) {
        Intent intent = new Intent("android.56iq.intent.action.setpoweronoff");
        int[] timeonArray = {2017, 9, 14, 11, 20};
        //下次开机具体日期时间，即在2014/10/1 8:30会开机
        int[] timeoffArray = {2017, 9, 14, 11, 17};
        //下次关机具体日期时间，即在2014/9/1 8:25会关机
        intent.putExtra("timeon", timeonArray);
        intent.putExtra("timeoff", timeoffArray);
        intent.putExtra("enable", true);
        //使能开关机功能，设为false,则为关闭
        context.sendBroadcast(intent);


    }

    public static void setoff(Context context, int[] timeonArray, int[] timeoffArray, boolean isSet) {
        Intent intent = new Intent("android.56iq.intent.action.setpoweronoff");
        intent.putExtra("timeon", timeonArray);
        intent.putExtra("timeoff", timeoffArray);
        intent.putExtra("enable", isSet);
        //使能开关机功能，设为false,则为关闭
        context.sendBroadcast(intent);
    }

    /**
     * 设置接下来一周的开关机时间
     * @param isEveryDay 是不是每天需要 true为每天设置，false为周末关机
     */
    public static void setThisWeekPower(Context context, PowerBean bean, boolean isEveryDay) {
        if (bean == null)
            return;
        if (bean.getOffHour()<bean.getOnHour())
            return;
        int week;
        Date dNow = new Date();
        week = DateUtil.getWeekInt(dNow);
        switch (week) {
            //星期天
            case 0:
                setDayNeedSet(context, dNow, 7, bean, isEveryDay);
                break;
            case 1:
                setDayNeedSet(context, dNow, 6, bean, isEveryDay);
                break;
            case 2:
                setDayNeedSet(context, dNow, 5, bean, isEveryDay);
                break;
            case 3:
                setDayNeedSet(context, dNow, 4, bean, isEveryDay);
                break;
            case 4:
                setDayNeedSet(context, dNow, 3, bean, isEveryDay);
                break;
            case 5:
                setDayNeedSet(context, dNow, 2, bean, isEveryDay);
                break;
            case 6:
                setDayNeedSet(context, dNow, 1, bean, isEveryDay);
                break;
        }
    }

    /**
     * 单独设置每天关机时间
     *
     * @param offDayOffset 关机的日期与开机的偏移量
     */
    public static void setDayPower(Context context, Date date, int offDayOffset, PowerBean bean) {
        if (bean == null)
            return;
        if (bean.getOffHour()<bean.getOnHour())
            return;

        int[] dateArray;
        int[] offDateArray;
        Date offDate;
        dateArray = DateUtil.getDateArray(date);
        if (offDayOffset >= 0) {
            offDate = DateUtil.getDateAfter(offDayOffset);
            offDateArray = DateUtil.getDateArray(offDate);
        } else
            return;
        int[] timeonArray = {dateArray[0], dateArray[1], dateArray[2], bean.getOnHour(), bean.getOnMinute()};
        //下次开机具体日期时间，即在2014/10/1 8:30会开机
        int[] timeoffArray = {offDateArray[0], offDateArray[1], offDateArray[2], bean.getOffHour(), bean.getOffMinute()};
        setoff(context, timeonArray, timeoffArray, bean.isSet());
    }

    /**
     * 单独设置当天关机时间
     */
    public static void setDayPower(Context context, Date date, PowerBean bean) {
        if (bean == null)
            return;
        if (bean.getOffHour()<bean.getOnHour())
            return;
        int[] dateArray;
        Date offDate;
        dateArray = DateUtil.getDateArray(date);

        int[] timeonArray = {dateArray[0], dateArray[1], dateArray[2], bean.getOnHour(), bean.getOnMinute()};
        //下次开机具体日期时间，即在2014/10/1 8:30会开机
        int[] timeoffArray = {dateArray[0], dateArray[1], dateArray[2], bean.getOffHour(), bean.getOffMinute()};
        setoff(context, timeonArray, timeoffArray, bean.isSet());
    }

    /**
     * 有几天需要设置
     */
    private static void setDayNeedSet(Context context, Date date, int dayset, PowerBean bean, boolean isEverday) {
        if (bean == null)
            return;
        if (bean.getOffHour()<bean.getOnHour())
            return;
        for (int i = 0; i <= dayset; i++) {
            Date dateAnnother = DateUtil.getDateAfter(i);
            int week = DateUtil.getWeekInt(dateAnnother);

            if (i == 0) {
                if (isEverday) {
                    setDayPower(context, date, bean);
                } else {
                    if (week == 0 || week == 6) {
                        bean.setSet(false);
                    } else {
                        bean.setSet(true);
                    }
                    setDayPower(context, date, bean);
                }

            } else {

                if (isEverday) {
                    setDayPower(context, dateAnnother, bean);
                } else {
                    if (week == 0 || week == 6) {
                        bean.setSet(false);
                    } else {
                        bean.setSet(true);
                    }
                    setDayPower(context, dateAnnother, bean);
                }

            }

        }
    }
}
