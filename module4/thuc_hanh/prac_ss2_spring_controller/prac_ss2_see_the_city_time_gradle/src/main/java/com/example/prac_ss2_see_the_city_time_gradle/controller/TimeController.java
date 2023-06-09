package com.example.prac_ss2_see_the_city_time_gradle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/")
    public String getTimeByTimezone(ModelMap modelMap, @RequestParam(name = "city", required = false,
            defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Lấy ra thời gian hiện tại
        Date date = new Date();
        // Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();
        // Lấy ra time zone của 1 thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);
        // Tính thời gian hiện tại của một thành phố cụ thể
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        // Cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố cụ thể
        date.setTime(locale_time);
        // Chuyển dữ liệu va gửi qua view
        modelMap.addAttribute("city", city);
        modelMap.addAttribute("date", date);
        return "index";
    }

/*@GetMapping("/")
public String getTimeByTimezone(ModelMap model,
                                @RequestParam(name = "city", defaultValue = "Asia/Ho_Chi_Minh") String city) {
    Date currentDate = new Date();

    // get local timezone
    TimeZone localTimeZone = TimeZone.getDefault();

    // get timezone of specific city
    TimeZone cityTimeZone = TimeZone.getTimeZone(city);

    // calculate current time of specific city
    long cityCurrentTime = currentDate.getTime() + (cityTimeZone.getRawOffset() - localTimeZone.getRawOffset());

    // set the time of currentDate to the current time of specific city
    currentDate.setTime(cityCurrentTime);

    // pass data to view
    model.addAttribute("city", city);
    model.addAttribute("date", currentDate);

    return "index";
}*/
}
