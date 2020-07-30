package com.caifu.util;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Auther: Lyf
 * @Date: 2020/7/8 09:36
 * @Description:
 */
@PropertySource("classpath:definition.properties")
public class Util {

    @Value("${file.upload.path}")
    private static String fileUploadPath;
    @Value("${file.upload.result.path}")
    private static String fileUploadResultPath;

    /**
     * 功能描述: 日期转字符串
     *
     * @auther: Lyf
     * @date: 2020/7/8 9:47
     * @param:
     * @return:
     */
    public static String dateToString(Date date,String format){
        try {
            if(date == null){
                date = new Date();
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }catch (Exception e){
            return  "";
        }
    }

    /**
     * 功能描述: 字符串转日期
     *
     * @auther: Lyf
     * @date: 2020/7/8 9:51
     * @param:
     * @return:
     */
    public static Date stringToDate(String date,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(date);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 功能描述: 日期推算
     *
     * @auther: Lyf
     * @date: 2020/7/8 10:23
     * @param: date 需要前推的日期（传递null默认当前日期）
     * @param: days 需要前推的天数
     * @return:
     */
    public static String dateCalculation(Date date,int days){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if(date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = (Date) calendar.getTime();
        String day = df.format(date);
        return day;
    }

    /**
     * 功能描述: 日期推算
     *
     * @auther: Lyf
     * @date: 2020/7/8 10:23
     * @param: date 需要前推的日期（传递null默认当前日期）
     * @param: days 需要前推的年
     * @return:
     */
    public static String dateCalculation_year(Date date,int years){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if(date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, years);
        date = (Date) calendar.getTime();
        String day = df.format(date);
        return day;
    }

    /**
     * 功能描述: 日期推算
     *
     * @auther: Lyf
     * @date: 2020/7/8 10:23
     * @param: date 需要前推的日期字符串
     * @param: format 需要前推的日期字符串格式
     * @param: days 需要前推的天数
     * @return:
     */
    public static String dateCalculation(String date,String format,int days){
       //DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        DateFormat dsf = new SimpleDateFormat(format);
        if(StringUtils.isNotBlank(date)) {
            try {
                Date d = dsf.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(d);
                calendar.add(Calendar.DAY_OF_MONTH, days);
                d = (Date) calendar.getTime();
                String day = dsf.format(d);
                return day;
            }catch (Exception e){
                return "";
            }
        }else{
            return "";
        }
    }

    /**
     * 功能描述: 生成随机数字和字母
     *
     * @auther: Lyf
     * @date: 2020/7/8 10:38
     * @param: length  生成位数
     * @return:
     */
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 功能描述: 根据uuid生成不重复的文件名
     *
     * @auther: Lyf
     * @date: 2020/7/20 10:26
     * @param:
     * @return:
     */
    public static String getNewFileName(String fileName){
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString().replace("-","") + suffix;
    }

    public static JSONObject uploadFile(MultipartFile file, String path){
        JSONObject obj = new JSONObject();
        try{
            String fileName = file.getOriginalFilename();
            String newFileName = getNewFileName(fileName);

            String now = dateToString(null,"yyyyMMdd");

            String newPath = fileUploadPath + now + "/" + path + "/" + newFileName;
            String resultPath = fileUploadResultPath + now + "/" + path + "/" + newFileName;

            File newFile = new File(newPath);
            file.transferTo(newFile);

            obj.put("path",resultPath);
            obj.put("name",fileName);
            obj.put("code","success");
        }catch (Exception e){
            obj.put("code","error");
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 功能描述: 根据日期计算年龄
     *
     * @auther: Lyf
     * @date: 2020/7/23 15:26
     * @param:
     * @return:
     */
    public static int getAgeByBirth(Date birthDay){
        int age = 0;
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }
}
