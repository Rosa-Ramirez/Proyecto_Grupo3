/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Calendar;

/**
 *
 * @author ramir
 */
public class Time {
    Calendar calendar = Calendar.getInstance();
    int hour, minute, day, month, year;
    
    public String getTime(){
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        return hour + ":" + minute;
    }
    
    public String getDay(){
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH);
        this.year = calendar.get(Calendar.YEAR);
        return day + "/" + month + "/" + year;
    }
}
