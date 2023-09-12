package com.ruoyi.common.utils;

/**
 * Created by KamLeung on 17/8/17.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 工具类
 */
@SuppressWarnings("restriction")
public class KamUtil {

    /**
     * 红包
     *
     * @param n
     * @param money 单位：分
     * @return
     */
    public static double[] redPacket(int n, double money) {
        // 红包结果
        double[] result = new double[n];
        // 随机数
        double[] randNum = new double[n];
        // 随机总数
        double randSum = 0;
        // 保证每个人都分到一分钱，扣除后分配
        double redSum = money - n;
        // 先随机，生成指定个数的随机数
        for (int i = 0; i < randNum.length; i++) {
            randNum[i] = Math.random() * redSum;
            randSum += randNum[i];
        }
        // 重新分配
        double left = redSum;
        // 设置随机红包结果
        for (int i = 0; i < result.length - 1; i++) {
            // 取整
            result[i] = Math.round(randNum[i] / randSum * redSum);
            left -= result[i];
            // 每人至少一分钱
            result[i] = (result[i] + 1) * 1.0 / 100;
        }
        // 设置最后一个红包
        result[n - 1] = (left + 1) * 1.0 / 100;

        return result;
    }

    /*String格式数字过万显示w*/
    public static String strToWan(String a) {
        if (a.length() > 4) {
            int b = Integer.parseInt(a);
            a = String.valueOf(Math.floor(b / 1000) / 10) + "w";
        }
        return a;
    }

    /**
     * 腾讯云直播后台返前端密钥
     */
    private final static String CHARSET = "UTF-8";

    public static String sign(String s, String key, String method) throws Exception {
        Mac mac = Mac.getInstance(method);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHARSET), mac.getAlgorithm());
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(s.getBytes(CHARSET));
        return DatatypeConverter.printBase64Binary(hash);
    }

    public static String getStringToSign(TreeMap<String, Object> params) {
        StringBuilder s2s = new StringBuilder("GETcvm.tencentcloudapi.com/?");
        // 签名时要求对参数进行字典排序，此处用TreeMap保证顺序
        for (String k : params.keySet()) {
            s2s.append(k).append("=").append(params.get(k).toString()).append("&");
        }
        return s2s.toString().substring(0, s2s.length() - 1);
    }

    public static String getUrl(TreeMap<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder("https://cvm.tencentcloudapi.com/?");
        // 实际请求的url中对参数顺序没有要求
        for (String k : params.keySet()) {
            // 需要对请求串进行urlencode，由于key都是英文字母，故此处仅对其value进行urlencode
            url.append(k).append("=").append(URLEncoder.encode(params.get(k).toString(), CHARSET)).append("&");
        }
        return url.toString().substring(0, url.length() - 1);
    }
    /*
     * 腾讯云直播后台返前端密钥
     * */

    /**
     * 获取字符串中间逗号隔开形式的随机x个数的字符串
     *
     * @param num :随机几个
     * @param str :中间以逗号隔开的字符串
     * @author 77785
     */
    public static String getRandomFromStr(String str, int num) {
        String[] a = str.split(",");
        int l = a.length;
        String str1 = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int random_index = (int) (Math.random() * l);
            str1 = a[random_index];
            a[random_index] = a[l - 1];
            l--;
            if (i == (num - 1)) {
                sb.append(str1);
            } else {
                sb.append(str1).append(",");
            }
        }
        return sb.toString();
    }

    public static Map<String, Object> nullToEmpty(Map<String, Object> map) {
        Set<String> set = map.keySet();
        if (set != null && !set.isEmpty()) {
            for (String key : set) {
                if (map.get(key) == null) {
                    map.put(key, "");
                }
            }
        }
        return map;
    }

    /*
     * 利用java原生的类实现SHA256加密
     * */
    public static String getSHA256(String str) {
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodestr = byte2Hex(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodestr;
    }

    /*
     * 将byte转为16进制
     * */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    /*根据两点经纬度返回距离，千米*/
    public static double getDistanceKM(double aj, double aw, double bj, double bw) {
        final double EARTH_RADIUS = 6371.393; // 平均半径,单位：km
        double radiansAX = Math.toRadians(aj); // A经弧度
        double radiansAY = Math.toRadians(aw); // A纬弧度
        double radiansBX = Math.toRadians(bj); // B经弧度
        double radiansBY = Math.toRadians(bw); // B纬弧度
        // 公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
        double acos = Math.acos(cos); // 反余弦值
        return new BigDecimal(EARTH_RADIUS * acos).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue(); // 最终结果
    }

    /*根据两点经纬度返回距离，米*/
    public static double getDistanceM(double aj, double aw, double bj, double bw) {
        final double EARTH_RADIUS = 6371393; // 平均半径,单位：m
        double radiansAX = Math.toRadians(aj); // A经弧度
        double radiansAY = Math.toRadians(aw); // A纬弧度
        double radiansBX = Math.toRadians(bj); // B经弧度
        double radiansBY = Math.toRadians(bw); // B纬弧度
        // 公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
        double acos = Math.acos(cos); // 反余弦值
        return new BigDecimal(EARTH_RADIUS * acos).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue(); // 最终结果
    }

    /*String转Date*/
    public static Date stringToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*String转Date*/
    public static Date stringToDateNomm(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*String转Date*/
    public static Date stringHmToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取一年以后日期
     */
    public static String getAfterAYear(String str) {
        String dateStr = null;
        SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = formats.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            calendar.add(Calendar.YEAR, 1);
            dateStr = formats.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return dateStr;
    }

    /**
     * 转换时间格式为指定样式
     */
    public static String stringToPatten(String str, String pattern) {
        String dateStr = null;
        SimpleDateFormat formats = new SimpleDateFormat(pattern);
        try {
            Date parse = formats.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            calendar.add(Calendar.HOUR_OF_DAY, 0);
            dateStr = formats.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return dateStr;
    }
    //获取今天的日期
    public static Date stringToDateNoTime(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*获取随机5位数字组成的字符串*/
    public static String returnRandomFive() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += random.nextInt(10);
        }
        return result;
    }

    /*获取随机5位数字组成的字符串*/
    public static String getRandom(int len) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < len; i++) {
            result += random.nextInt(10);
        }
        return result;
    }


    /*根据时间day+分钟数x，返回到达时间*/
    public static String arrive_time(String day, int x) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, x);
        date = cal.getTime();
//		System.out.println("after:" + format.format(date));  //显示更新后的日期
        cal = null;
        return format.format(date);
    }

    /*根据预约时间day和分钟数x，返回该时间后取消收取费用*/
    public static String appointedCancle_time(String day, int x) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, x);
        date = cal.getTime();
        cal = null;
        return format.format(date);
    }

    public static int getFenzhong(Date date1, Date date2) {
        //一天的毫秒数
        long d = 1000 * 24 * 60 * 60;
        //一小时的毫秒数
        long h = 1000 * 60 * 60;
        //一分钟的毫秒数
        long m = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long timeDiff = date2.getTime() - date1.getTime();
        // 计算差多少天
        long day = timeDiff / d;
        // 计算差多少小时
        //long hour = timeDiff % d / h;
        long hour = timeDiff / h;
        // 计算差多少分钟
        long min = timeDiff % d % h / m;
        min = min + hour * 60;
        return Integer.valueOf(String.valueOf(min));
    }

    public static int getDayDifference(Date date1, Date date2) {
        //一天的毫秒数
        long d = 1000 * 24 * 60 * 60;
        // 获得两个时间的毫秒时间差异
        long timeDiff = date2.getTime() - date1.getTime();
        // 计算差多少天
        long day = timeDiff / d;
        //输出结果
        return Integer.valueOf(String.valueOf(day));
    }

    //获取两个日期之间相隔的工作日天数
    public static int workDays(String strStartDate, String strEndDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cl1 = Calendar.getInstance();
        Calendar cl2 = Calendar.getInstance();

        try {
            cl1.setTime(df.parse(strStartDate));
            cl2.setTime(df.parse(strEndDate));

        } catch (ParseException e) {
            System.out.println("日期格式非法");
            e.printStackTrace();
        }

        int count = 0;
        while (cl1.compareTo(cl2) <= 0) {
            if (cl1.get(Calendar.DAY_OF_WEEK) != 7 && cl1.get(Calendar.DAY_OF_WEEK) != 1)
                count++;
            cl1.add(Calendar.DAY_OF_MONTH, 1);
        }
        return count;

    }

    /*生成订单*/
    public static String getOrderNum() {
        //（订单号E+时间戳）
        String oNum = "E";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成订单*/
    public static String getOrderNum(String oNum) {
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成红包订单*/
    public static String getOrderNumR() {
        //（订单号R+时间戳）
        String oNum = "R";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成订单T币*/
    public static String getOrderNumT() {
        String oNum = "T";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成订单*/
    public static String getOrderNumWK() {
        //（订单号W+时间戳）
        String oNum = "W";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成代驾订单号*/
    public static String getOrderNumDJ() {
        String oNum = "D";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成代驾订单号*/
    public static String getOrderNumDJ2() {
        String oNum = "J";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成代驾订单号*/
    public static String getOrderNumDJ3() {
        String oNum = "M";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成有证练车订单*/
    public static String getOrderNumYZ() {
        //（订单号Y+时间戳）
        String oNum = "Y";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成驾考直通车订单号*/
    public static String getOrderNumZTC() {
        //（订单号Z+时间戳）
        String oNum = "Z";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /*生成驾校预约练车订单号*/
    public static String getOrderNumLC() {
        //（订单号L+时间戳）
        String oNum = "L";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /* 获取当前系统时间 */
    public static String getSysTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /* 获取当前系统时间 */
    public static String getSysTimeNomm() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return df.format(new Date());
    }

    public static String getSysDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    public static String getSysDates() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    /**
     * 获取当前时间为准的明天日期
     */
    @SuppressWarnings("static-access")
    public static String getTomorrowDate() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取当前时间为准的明天时间
     *
     * @throws ParseException
     */
    @SuppressWarnings("static-access")
    public static Long getTomorrowTime() throws ParseException {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        Date date1 = formatter.parse(dateString);
        long ts = date1.getTime() / 1000;
        return ts;
    }

    /**
     * 获取当前时间为准的前一天日期
     */
    @SuppressWarnings("static-access")
    public static String getYestodayDate() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);//把日期往前一天
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取当前时间为准的后天日期
     */
    @SuppressWarnings("static-access")
    public static String getAfterTomorrowDate() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 2);//把日期往后增加2天.整数往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推2天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取当前时间为准的3天后天日期
     */
    @SuppressWarnings("static-access")
    public static String bigAfterTomorrowDate() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 3);//把日期往后增加2天.整数往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推2天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static void main(String[] args) {
        // 设置日期格式
        System.out.println(getSysTime());
        System.out.println(strToDateLong(getSysTime()));
    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 格式化2个时间的间隔
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 两个时间之间的间隔
     */
    public static String between(LocalDate start, LocalDate end) {
        long betweenDay = end.toEpochDay() - start.toEpochDay();
        if (betweenDay < 0) {
            return "开始时间大于结束时间，所传参数不OK。。。。";
        }

        int year = end.getYear() - start.getYear();
        int month = end.getMonth().getValue() - start.getMonth().getValue();
        int day = end.getDayOfMonth() - start.getDayOfMonth();

        if (day < 0) {
            month = month - 1;
            boolean leapYear = end.getYear() % 4 == 0;
            if (end.getMonth() == Month.JANUARY) {
                leapYear = (end.getYear() - 1) % 4 == 0;
            }
            day = day + end.getMonth().minus(1).length(leapYear);
        }

        if (month < 0) {
            year = year - 1;
            month = month + 12;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (year > 0) {
            stringBuilder.append(year).append("年");
        }
        if (month > 0) {
            stringBuilder.append(month).append("个月");
        }
        if (day > 0) {
            stringBuilder.append(day).append("天");
        }
        return stringBuilder.toString();
    }

    public static String gettimesofdays(String time_a) {

        String a = time_a.substring(0, 4);
        String b = time_a.substring(5, 7);
        String c = time_a.substring(8, 10);
        int d = Integer.parseInt(a);
        int e = Integer.parseInt(b);
        int f = Integer.parseInt(c);
        LocalDate start = LocalDate.of(d, e, f);
        LocalDate end = LocalDate.now();
        String cc = KamUtil.between(start, end);
        return cc;
    }

    /**
     * 根据时间戳来判断当前的时间是几天前,几分钟,刚刚
     *
     * @param long_time
     * @return
     */
    public static String getTimeStateNew(String long_time) {
        if (long_time.contains(".")) {
            long_time = long_time.substring(0, long_time.lastIndexOf("."));
        }
        String long_by_13 = "1000000000000";
        String long_by_10 = "1000000000";
        if (Long.valueOf(long_time) / Long.valueOf(long_by_13) < 1) {
            if (Long.valueOf(long_time) / Long.valueOf(long_by_10) >= 1) {
                long_time = long_time + "000";
            }
        }
        Timestamp time = new Timestamp(Long.valueOf(long_time));
        Timestamp now = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	    System.out.println("传递过来的时间:"+format.format(time));
//	    System.out.println("现在的时间:"+format.format(now));
        long day_conver = 1000 * 60 * 60 * 24;
        long hour_conver = 1000 * 60 * 60;
        long min_conver = 1000 * 60;
        long time_conver = now.getTime() - time.getTime();
        long temp_conver;
//	    System.out.println("天数:"+time_conver/day_conver);
        if ((time_conver / day_conver) < 3) {
            temp_conver = time_conver / day_conver;
            if (temp_conver <= 2 && temp_conver >= 1) {
                return temp_conver + "天前";
            } else {
                temp_conver = (time_conver / hour_conver);
                if (temp_conver >= 1) {
                    return temp_conver + "小时前";
                } else {
                    temp_conver = (time_conver / min_conver);
                    if (temp_conver >= 1) {
                        return temp_conver + "分钟前";
                    } else {
                        return "刚刚";
                    }
                }
            }
        } else {
            return format.format(time);
        }
    }

    /**
     * @param map
     * @return String 类型 json
     * @discription map转String类型json 共通
     * @author KamLeung
     * @created 2017年8月15日 上午8:53:02
     */
    public static String mapToStrJson(Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 返回json字符串：参数错误
     */
    public static String returnParamError() {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 414);
            map.put("msg", "入参错误");
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 返回json字符串：参数错误
     */
    public static String returnParamError(String msg) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 414);
            map.put("msg", msg);
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 返回json字符串：自定义
     */
    public static String returnParamMsg(int code, String msg) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", code);
            map.put("msg", msg);
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 返回json字符串：操作失败
     */
    public static String returnError() {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 400);
            map.put("msg", "操作失败");
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 返回json字符串：操作失败
     */
    public static String returnError(String msg) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 400);
            map.put("msg", msg);
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 返回json字符串：无结果
     */
    public static String returnNoResult() {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 200);
            map.put("msg", "无结果");
            int[] arr = new int[0];
            map.put("content", arr);
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 返回json字符串：操作成功
     */
    public static String returnSuccess(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 200);
            map.put("msg", "操作成功！");
            if (obj != null) {
                map.put("content", obj);
            }
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 判断字符串是否为数字类型
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    /**
     * 返回map
     */
    public static Map<String, Object> returnMap(Integer code, String msg, Object content) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        if (content != null) {
            map.put("content", content);
        }
        return map;
    }

    /**
     * 返回 map
     */
    public static Map<String, Object> returnmap(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", msg);
        return map;
    }

    /**
     * 2017年8月16日 by KamLeung
     * 利用MD5进行加密
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    //--------------------------------------------------

    //md5 普通加密
    public static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes();
            //获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mdInst.update(btInput);
            //获得密文
            byte[] md = mdInst.digest();
            //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


//--------------------------------------------------

    /**2017年8月16日 by KamLeung
     * 判断用户密码是否正确
     *newpasswd  用户输入的密码
     *oldpasswd  正确密码
     *public static boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
     if(EncoderByMd5(newpasswd).equals(oldpasswd))
     return true;
     else
     return false;
     }*/

    /**
     * @return 获取随机数 6位
     * @author ChrisGai
     */
    public static String getRandom() {
        //
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        return result;
    }

    /**
     * @return 4位随机数
     * @author ChrisGai
     * 产生4位随机数(0000-9999)
     */
    public static String getFourRandom() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 1; i <= 4 - randLength; i++)
                fourRandom = "0" + fourRandom;
        }
        return fourRandom;
    }

    public static long minute(String time) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = "2018-10-31 13:15:31";
        Date date;
        try {
            date = formatter.parse(time);
            long a = KamUtil.pastMinutes(date);
            System.out.println(a);
            return a;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 10;
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * @author GZY
     * 操作成功
     */
    public static String returnSuccess() {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 200);
            map.put("msg", "操作成功！");
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * @author ChrisGai
     */
    public static String returnKeepExit(Integer code, String msg) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", code);
            map.put("msg", msg);
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 订单号
     * by ChrisGai
     *
     * @return
     */
    public static String getSerialNumber() {
        //（订单号T+时间戳）
        String oNum = "T";
        long timestamp = System.currentTimeMillis();
        String abc = String.valueOf(timestamp);
        String ooo = oNum + abc;
        return ooo;
    }

    /**
     * 计算两个时间间隔(精确到分钟)
     *
     * @param startDay  开始日(整型):0表示当日，1表示明日
     * @param startTime 开始时间(24h):00:00
     * @param endDay    结束日(整型):0表示当日，1表示明日，限制：大于等于 startDay
     * @param endTime   结束时间(24h):23:50
     * @return 格式化的日期格式：DD天HH小时mm分
     */
    public static String calculateIntervalTime(int startDay, String startTime, int endDay, String endTime) {
        int day = endDay - startDay;
        int hour = 0;
        int mm = 0;
        if (day < 0) {
            return null;
        } else {
            int sh = Integer.valueOf(startTime.split(":")[0]);
            int eh = Integer.valueOf(endTime.split(":")[0]);
            int sm = Integer.valueOf(startTime.split(":")[1]);
            int em = Integer.valueOf(endTime.split(":")[1]);
            hour = eh - sh;
            if (hour > 0) {
                mm = em - sm;
                if (mm < 0) {
                    hour--;
                    mm = 60 + mm;
                }
            } else {
                day = day - 1;
                hour = 24 + hour;
                mm = em - sm;
                if (mm < 0) {
                    hour--;
                    mm = 60 + mm;
                }
            }
        }
        if (hour == 24) {
            day++;
            hour = 0;
        }
        if (day != 0) {
            return day + "天" + hour + "小时" + mm + "分";
        } else {
            return hour + "小时" + mm + "分";
        }
    }

    /**
     * @return uuid
     * @author ChrisGai
     */
    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    /**
     * @return uuid
     * @author ChrisGai
     */
    public static String get36UUID() {
        String uuid = UUID.randomUUID().toString().trim();
        return uuid;
    }

    /**
     * 秒转时分
     * 28800 ->  08:00
     *
     * @param time
     * @return
     */
    public static String secToTime(String time) {
        //秒数
        Float dt = Float.parseFloat(time);
        if (dt < 3600) return Math.round(dt / 60) + "min";
        int hour = Math.round(dt / 3600);
        int minute = Math.round((dt - (hour * 3600)) / 60);
        String a = hour + "h" + (minute == 0 ? "" : minute + "min");
        if (a.contains("-")) {
            a = a.replaceAll("-", "");
        }
        return a;
    }


}

