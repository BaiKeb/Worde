package com.example.demo01.controller;

import com.example.demo01.dao.Dao;
import com.example.demo01.entity.Bean;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.*;

public class WordToSql {

//    public static int sar_id;
//    public static String air_type;
//    public static String air_open_type;
//    public static String air_temp;
//    public static String run_type;
//    public static String air_model;
//    public static String frame;
//    public static String remark;
//    public static String wind_direction;
//    public static String wind_speed;

    public static void readAndWriterTesta4() throws IOException {
        File file = new File("D:\\chengtianjiliang\\码值\\码值模板(海尔).docx");
//        String str = "";

        FileInputStream fis = new FileInputStream(file);
        System.out.println("获取到：" + fis);
        XWPFDocument xdoc = new XWPFDocument(fis);

        Iterator<IBodyElement> bodyEle = xdoc.getBodyElementsIterator();
        List<Object> datas = new ArrayList<>();
//        String datas1 = String.valueOf(datas);
        Bean bean = new Bean();
        Dao dao = new Dao();
        while (bodyEle.hasNext()) {
            IBodyElement bodyElement = bodyEle.next();
            String content = handlerByBodyType(bodyElement, bodyElement.getPartType());
//            if (content == null || content.equals("")){
//                printAllDatas(datas);
//            }
            datas.add(content);
        }

//        Bean bean = new Bean();
//        Dao dao = new Dao();
//        for (Object contents : datas) {
//            String content = contents.toString();
//            System.out.println("第一次获取："+content.toString());
//            System.out.println("第一步:"+content);
//            if (content.contains("cmode")) {
//
//                bean.setAir_type("华凌");
//                bean.setAir_model("0168");
//                System.out.println("可以获取" + content.substring(6, 8));
//                bean.setRun_type(content.substring(6, 8));
//            }
//
//            if (content.contains("conoff")) {
//                System.out.println("可以获取" + content.substring(7, 8));
//                bean.setAir_open_type(content.substring(7, 8));
//            }
//            if (content.contains("ctemp")) {
//                System.out.println("可以获取" + content.substring(6, 8));
//                bean.setAir_temp(content.substring(6, 8));
//            }
//            if (content.contains("cwind")) {
//                System.out.println("可以获取" + content.substring(6, 8));
//                bean.setWind_speed(content.substring(6, 8));
//            }
//            if (content.contains("direction")) {
//                String str = content.substring(0, content.indexOf(":"));
//                String str1 = content.substring(str.length() + 1, content.length());
//                System.out.println("可以获取" + str1);
//                bean.setWind_direction(str1);
//            }
//            if (content.contains("irdata")) {
//                String str = content.substring(0, content.indexOf(":"));
//                String str1 = content.substring(str.length() + 1, content.length());
//                System.out.println("可以获取" + str1);
//                bean.setFrame(str1);
//            }
//        }
        xdoc.close();
        fis.close();
//        dao.add(bean);
        printAllDatas(datas);

    }

    public static void printAllDatas(Collection<?> datas) {
        System.out.println("出来了");
        System.out.println(datas);

        Bean bean = new Bean();
        Dao dao = new Dao();
        for (Object contents : datas) {
            String content = contents.toString();
            System.out.println("第一次获取：" + content.toString());
            System.out.println("第一步:" + content);
            if (content.contains("cmode")) {

                bean.setAir_type("格力");
                bean.setAir_model("YADOF");
                System.out.println("可以获取" + content.substring(6, 8));
                bean.setRun_type(content.substring(6, 8));
            }

            if (content.contains("conoff")) {
                System.out.println("可以获取" + content.substring(7, 8));
                bean.setAir_open_type(content.substring(7, 8));
            }
            if (content.contains("ctemp")) {
                System.out.println("可以获取" + content.substring(6, 8));
                bean.setAir_temp(content.substring(6, 8));
            }
            if (content.contains("cwind")) {
                System.out.println("可以获取" + content.substring(6, 8));
                bean.setWind_speed(content.substring(6, 8));
            }
            if (content.contains("direction")) {
                String str = content.substring(0, content.indexOf(":"));
                String str1 = content.substring(str.length() + 1, content.length());
                System.out.println("可以获取" + str1);
                bean.setWind_direction(str1);
            }
            if (content.contains("irdata")) {
                String str = content.substring(0, content.indexOf(":"));
                String str1 = content.substring(str.length() + 1, content.length());
                System.out.println("可以获取" + str1);
                bean.setFrame(str1);
            }
            if (content.contains("irdata")) {
                dao.add(bean);
            }

        }


    }

    // 开始处理当前的身体元素
    public String handlerByBodyElement(IBodyElement bodyElement) {
        String content = null;
        // 用来处理XWPFParagraph
        if (bodyElement instanceof XWPFParagraph) {
            System.out.println("当前获取的元素类型为:XWPFParagraph");
            content = handlerXWPFParagraph(bodyElement);
        }
        return content;
    }

    // 用来处理当前的XWPFParagraph类型的数据
    public static String handlerXWPFParagraph(IBodyElement bodyElement) {
        XWPFParagraph xwpfParagraph = (XWPFParagraph) bodyElement;
        BodyElementType elementType = xwpfParagraph.getElementType();
        String content = getStringByBodyElementType(xwpfParagraph, elementType);
        System.out.println("当前文本的内容为:" + content);
//        Bean bean = new Bean();
//        Dao dao = new Dao();
//        for (int i = 0;i<content.length();i++){
//        if (content.contains("cmode")) {
//
//            bean.setAir_type("华凌");
//            bean.setAir_model("0168");
//            System.out.println("可以获取" + content.substring(6, 8));
//            bean.setRun_type(content.substring(6, 8));
//        }
//        }
//        if (content.contains("conoff")) {
//            System.out.println("可以获取" + content.substring(7, 8));
//            bean.setAir_open_type(content.substring(7, 8));
//        }
//        if (content.contains("ctemp")) {
//            System.out.println("可以获取" + content.substring(6, 8));
//            bean.setAir_temp(content.substring(6, 8));
//        }
//        if (content.contains("cwind")){
//            System.out.println("可以获取"+content.substring(6,8));
//            bean.setWind_speed(content.substring(6,8));
//        }
//        if (content.contains("direction")){
//            System.out.println("可以获取"+content.substring(10,12));
//            bean.setWind_direction(content.substring(10,12));
//        }
//        if (content.contains("irdata")){
//            String str = content.substring(0,content.indexOf(":"));
//            String str1 = content.substring(str.length()+1,content.length());
//            System.out.println("可以获取"+ str1);
//            bean.setFrame(str1);
////            dao.add(bean);
//        }


//        dao.add(bean);
        return content;
    }

    // 通过当前的类型和元素进行对应的处理
    public static String getStringByBodyElementType(XWPFParagraph xwpfParagraph, BodyElementType bodyElementType) {
        System.out.println(bodyElementType);// 当前测试结果为： PARAGRAPH
        String content = "";
        switch (bodyElementType) {
            case CONTENTCONTROL:
                //    如果使⽤的是⽂本控件
                break;
            case PARAGRAPH:
                //        如果是段落的处理结果
                content = xwpfParagraph.getParagraphText();
                break;
            case TABLE:
                //   如果当前的的元素部分为表格
                break;
            default:
                break;
        }
        return content;
    }

    // 通过身体类型来处理
    public static String handlerByBodyType(IBodyElement bodyElement, BodyType partType) {
        System.out.println("当前的BodyType为：" + partType);
        String content = null;
        switch (partType) {
            case CONTENTCONTROL:
                break;
            case DOCUMENT:
                content = handlerXWPFParagraph(bodyElement);
                break;
            case HEADER:
                break;
            case FOOTER:
                break;
            case FOOTNOTE:
                break;
            case TABLECELL:
                break;
            default:
                throw new IllegalArgumentException("there is no this document type !please check this type!");
        }
        return content;
    }


    public static void main(String[] args) throws IOException {
        Bean bean = new Bean();
        readAndWriterTesta4();
    }
}
