package com.example.demo01.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo01.dao.Dao;
import com.example.demo01.entity.Bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import java.util.Date;

import static com.example.demo01.util.Unicode.unicodeDecode;


public class CapuC {

    public static void main(String[] args) {
//        0: "电源"
//        1: "运作模式"
//        2: "温度+"
//        3: "温度-"
//        4: "风速"
//        5: "风向"


        getPageContent("https://ir.spgui.com/keyevent.asp?mac=2019072601&keyid=1&kfid=010129", "post", 100500);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String Url = "https://ir.spgui.com/keyevent.asp?mac=2019072601&keyid=1&kfid=010129";
        String Url2 = "https://ir.spgui.com/keyevent.asp?mac=2019072601&keyid=2&kfid=010129";
        String Url4 = "https://ir.spgui.com/keyevent.asp?mac=2019072601&keyid=4&kfid=010129";
        String Url5 = "https://ir.spgui.com/keyevent.asp?mac=2019072601&keyid=5&kfid=010129";
        String strP = "post";
        int maX = 100500;

        Boolean result = false;
        int count = 0;
        while (!result) {
            try {
                Thread.sleep(5 * 1000); //设置暂停的时间 5 秒
                count++;
                System.out.println(sdf.format(new Date()) + "--循环执行第" + count + "次");
//                getPageContent(Url, strP, maX);
                for (int i = 1; i <= 30; i++) {
//                    Thread.sleep(5 * 1000);
                    getPageContent(Url2, strP, maX);
                    for (int ij = 1; ij <= 5; ij++) {
                        getPageContent(Url4, strP, maX);
                        for (int j = 1; j <= 5; j++) {
                            getPageContent(Url5, strP, maX);
                        }
                    }
                }
//                Thread.sleep(4 * 1000); //设置暂停的时间 4 秒
//                getPageContent("https://ir.spgui.com/keyevent.asp?mac=2019072601&keyid=2&kfid=010254","post",100500);
//                Thread.sleep(4 * 1000); //设置暂停的时间 4 秒
//                getPageContent("https://ir.spgui.com/keyevent.asp?mac=2019072601&keyid=4&kfid=010254","post",100500);
//                Thread.sleep(4 * 1000); //设置暂停的时间 4 秒
//                getPageContent("https://ir.spgui.com/keyevent.asp?mac=2019072601&keyid=5&kfid=010254","post",100500);
                if (count == 20) {
                    result = true;
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static String getPageContent(String strUrl, String strPostRequest,
                                        int maxLength) {
        // 读取结果网页
        StringBuffer buffer = new StringBuffer();
        System.setProperty("sun.net.client.defaultConnectTimeout", "5000");
        System.setProperty("sun.net.client.defaultReadTimeout", "5000");
        try {
            URL newUrl = new URL(strUrl);
            HttpURLConnection hConnect = (HttpURLConnection) newUrl
                    .openConnection();
            // POST方式的额外数据
            if (strPostRequest.length() > 0) {
                hConnect.setDoOutput(true);
                OutputStreamWriter out = new OutputStreamWriter(hConnect
                        .getOutputStream());
                out.write(strPostRequest);
                out.flush();
                out.close();
            }
            // 读取内容
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    hConnect.getInputStream()));
            int ch;
            for (int length = 0; (ch = rd.read()) > -1
                    && (maxLength <= 0 || length < maxLength); length++)
                buffer.append((char) ch);
            String s = buffer.toString();
            s.replaceAll("//&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
//            System.out.println(s);
            rd.close();
            hConnect.disconnect();
//            System.out.println("输出："+s);
//            unicodeDecode(s);

//            System.out.println(unicodeDecode(s));

            String substring = s.substring(1, s.length() - 1);
//            System.out.println("substring:"+substring);
            String[] split = substring.split(":");//以逗号分割

            Bean bean = new Bean();
            Dao dao = new Dao();

            for (String string2 : split) {

                if (string2.equals("\"\\u5F00\",\"cmode\"")) {
                    System.out.println("cmode:开");

                    bean.setAir_type("志高");
                    bean.setAir_model("0082");

                    bean.setAir_open_type("开");
                } else if (string2.equals("\"\\u5173\",\"cmode\"")) {
                    System.out.println("cmode:关");
                    bean.setAir_type("志高");
                    bean.setAir_model("0082");
                    bean.setAir_open_type("关");
                } else if (string2.equals("\"\\u5236\\u51B7\",\"ctemp\"")) {
                    System.out.println("ctemp:制冷");
                    bean.setRun_type("制冷");
                } else if (string2.equals("\"\\u5236\\u70ED\",\"ctemp\"")) {
                    System.out.println("ctemp:制热");
                    bean.setRun_type("制热");
                } else if (string2.equals("\"\\u81EA\\u52A8\",\"cwinddir\"")) {
                    System.out.println("cwind:自动");
                    bean.setWind_speed("自动");
                } else if (string2.equals("\"\\u81EA\\u52A8\",\"irdata\"")) {
                    System.out.println("cwinddir:自动");
                    bean.setWind_direction("自动");
                } else if (string2.equals("16,\"cwind\"")) {
                    System.out.println("ctemp:16");
                    bean.setAir_temp("16");
                } else if (string2.equals("17,\"cwind\"")) {
                    System.out.println("ctemp:17");
                    bean.setAir_temp("17");
                } else if (string2.equals("18,\"cwind\"")) {
                    System.out.println("ctemp:18");
                    bean.setAir_temp("18");
                } else if (string2.equals("19,\"cwind\"")) {
                    System.out.println("ctemp:19");
                    bean.setAir_temp("19");
                } else if (string2.equals("20,\"cwind\"")) {
                    System.out.println("ctemp:20");
                    bean.setAir_temp("20");
                } else if (string2.equals("21,\"cwind\"")) {
                    System.out.println("ctemp:21");
                    bean.setAir_temp("21");
                } else if (string2.equals("22,\"cwind\"")) {
                    System.out.println("ctemp:22");
                    bean.setAir_temp("22");
                } else if (string2.equals("23,\"cwind\"")) {
                    System.out.println("ctemp:23");
                    bean.setAir_temp("23");
                } else if (string2.equals("24,\"cwind\"")) {
                    System.out.println("ctemp:24");
                    bean.setAir_temp("24");
                } else if (string2.equals("25,\"cwind\"")) {
                    System.out.println("ctemp:25");
                    bean.setAir_temp("25");
                } else if (string2.equals("26,\"cwind\"")) {
                    System.out.println("ctemp:26");
                    bean.setAir_temp("26");
                } else if (string2.equals("27,\"cwind\"")) {
                    System.out.println("ctemp:27");
                    bean.setAir_temp("27");
                } else if (string2.equals("28,\"cwind\"")) {
                    System.out.println("ctemp:28");
                    bean.setAir_temp("28");
                } else if (string2.equals("29,\"cwind\"")) {
                    System.out.println("ctemp:29");
                    bean.setAir_temp("29");
                } else if (string2.equals("30,\"cwind\"")) {
                    System.out.println("ctemp:30");
                    bean.setAir_temp("30");
                } else if (string2.equals("\"\\u9001\\u98CE\",\"ctemp\"")) {
                    System.out.println("ctemp:送风");
                    bean.setRun_type("送风");
                } else if (string2.equals("\"\\u9664\\u6E7F\",\"ctemp\"")) {
                    System.out.println("ctemp:除湿");
                    bean.setRun_type("除湿");
                } else if (string2.equals("\"\\u81EA\\u52A8\",\"ctemp\"")) {
                    System.out.println("ctemp:自动");
                    bean.setRun_type("自动");
                } else if (string2.equals("\"\\u98CE\\u54111\",\"irdata\"")) {
                    System.out.println("cwinddir:风向1");
                    bean.setWind_direction("风向1");
                } else if (string2.equals("\"\\u98CE\\u54112\",\"irdata\"")) {
                    System.out.println("cwinddir:风向2");
                    bean.setWind_direction("风向2");
                } else if (string2.equals("\"\\u98CE\\u54113\",\"irdata\"")) {
                    System.out.println("cwinddir:风向3");
                    bean.setWind_direction("风向3");
                } else if (string2.equals("\"\\u98CE\\u54114\",\"irdata\"")) {
                    System.out.println("cwinddir:风向4");
                    bean.setWind_direction("风向4");
                } else if (string2.equals("\"\\u4F4E\\u98CE\",\"cwinddir\"")) {
                    System.out.println("cwind:低风");
                    bean.setWind_speed("低风");
                } else if (string2.equals("\"\\u4E2D\\u98CE\",\"cwinddir\"")) {
                    System.out.println("cwind:中风");
                    bean.setWind_speed("中风");
                } else if (string2.equals("\"\\u9AD8\\u98CE\",\"cwinddir\"")) {
                    System.out.println("cwind:高风");
                    bean.setWind_speed("高风");
                } else if (string2.contains("4B,A4,A9,")) {
                    System.out.println("irdata:" + string2);
                    String sub = string2.substring(1, string2.length() - 1);

                    String str = sub.replace(",", "");


                    bean.setFrame(str);

                }
//                if (string2.equals("\"\\u5F00\",\"cmode\"")) {

                if (string2.contains("4B,A4,A9,")) {
                    dao.add(bean);

                }
//                }
            }
//            System.out.println(decodeUnicode(substring));
            return buffer.toString().trim();
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * unicode编码转中文
     */
    public static String decodeUnicode(String dataStr) {
        try {
            StringBuffer buffer = new StringBuffer(dataStr == null ? "" : dataStr);
            if (StringUtils.isNotBlank(dataStr) && dataStr.contains("\\u")) {
                buffer.delete(0, buffer.length());
                int start = 0;
                int end = 0;
                while (start > -1) {
                    end = dataStr.indexOf("\\u", start + 2);
                    String a = "";//如果夹着非unicode编码的字符串，存放在这
                    String charStr = "";
                    if (end == -1) {
                        if (dataStr.substring(start + 2, dataStr.length()).length() > 4) {
                            charStr = dataStr.substring(start + 2, start + 6);
                            a = dataStr.substring(start + 6, dataStr.length());
                        } else {
                            charStr = dataStr.substring(start + 2, dataStr.length());
                        }
                    } else {
                        charStr = dataStr.substring(start + 2, end);
                    }
                    char letter = (char) Integer.parseInt(charStr.trim(), 16); // 16进制parse整形字符串。
                    buffer.append(new Character(letter).toString());
                    if (StringUtils.isNotBlank(a)) {
                        buffer.append(a);
                    }
                    start = end;
                }
            }
            return buffer.toString();
        } catch (Exception e) {
            System.out.println(" 字符串转换失败");
        }
        return dataStr;
    }


}
