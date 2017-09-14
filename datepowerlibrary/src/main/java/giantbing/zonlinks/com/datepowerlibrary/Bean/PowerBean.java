package giantbing.zonlinks.com.datepowerlibrary.Bean;

/**
 * Created by P on 2017/9/14.
 */

public class PowerBean {
    private int offHour;
    private int offMinute;
    private int onHour;
    private int onMinute;
    private boolean isSet;

    public PowerBean(int offHour, int offMinute, int onHour, int onMinute, boolean isSet) {
        this.offHour = offHour;
        this.offMinute = offMinute;
        this.onHour = onHour;
        this.onMinute = onMinute;
        this.isSet = isSet;
    }

    public int getOffHour() {
        return offHour;
    }

    public void setOffHour(int offHour) {
        this.offHour = offHour;
    }

    public int getOffMinute() {
        return offMinute;
    }

    public void setOffMinute(int offMinute) {
        this.offMinute = offMinute;
    }

    public int getOnHour() {
        return onHour;
    }

    public void setOnHour(int onHour) {
        this.onHour = onHour;
    }

    public int getOnMinute() {
        return onMinute;
    }

    public void setOnMinute(int onMinute) {
        this.onMinute = onMinute;
    }

    public boolean isSet() {
        return isSet;
    }

    public void setSet(boolean set) {
        isSet = set;
    }
}
