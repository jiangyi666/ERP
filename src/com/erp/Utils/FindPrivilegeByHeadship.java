package com.erp.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 本类是通过职位来查找到相应的特权编号
 */
public class FindPrivilegeByHeadship {
    private static HashMap map;//在map里面来保存所有的权限映射
    static {
        map=new HashMap<String,Integer>();//用一个map来存储职工特权列表
        ClassLoader classLoader = JDBCUtil.class.getClassLoader();
        InputStreamReader resourceAsStream = null;
        try {
            //一定需要指定类型为UTF—8，使用InputStreamReader来代替InputStream
            resourceAsStream = new InputStreamReader(classLoader.getResourceAsStream("headship.properties"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();//从配置文件中拿到数据
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();//便利配置文件
        for (Map.Entry<Object, Object> entry : entries) {
            //由于拿到的为Object而privilege是Integer类型的
            //所以需要把Object类型转换为Integer类型
            map.put(entry.getKey(),Integer.parseInt(entry.getValue().toString()));//把配置文件中的职位和对应的特权写入map中
        }

//        map=new HashMap<String,Integer>();
//        map.put("总经理",1);
//        map.put("仓管经理",2);
//        map.put("销售经理",3);
//        map.put("财务经理",4);
//        map.put("采购经理",5);
//        map.put("生产经理",6);
//        map.put("普通员工",7);
    }

    /**
     * 通过headship来得到特权编号
     * @param headship
     * @return 特权编号
     */
    public static int getPrivilege(String headship){
        if (map.get(headship)!=null){
            //即输入的职位有在事先定义的列表当中，就返回相应的权限编号
            return (int) map.get(headship);
        }else {
            //如果没有的话就返回7，即普通员工的权限
            return 7;
        }
    }

    public static HashMap getMap() {
        return map;
    }

    public static void main(String[] args) {
        System.out.println(map);
    }
}
