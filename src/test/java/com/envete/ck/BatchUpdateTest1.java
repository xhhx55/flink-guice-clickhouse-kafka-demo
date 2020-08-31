package com.envete.ck;

import lombok.val;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

// connection = DriverManager.getConnection(address, "root", "BcBRrDAd");

public class BatchUpdateTest1 {
    public static void main(String[] args) {
        String address = "jdbc:clickhouse://dev201:8123";
        // 这种方式可批量插入数据
        try {
            Class.forName("ru.yandex.clickhouse.ClickHouseDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(address)) {

            PreparedStatement ps = connection.prepareStatement("insert into test.event_2 VALUES (?, ?, ?)");


            ps.setObject(1, "2020-08-26");
            ps.setObject(2, "Kasa");
            ps.setObject(3, 12);
            ps.addBatch();

            System.out.println("add batch");

            TimeUnit.SECONDS.sleep(5);

            System.out.println("before execute");

            ps.executeBatch();
            connection.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }




    public static String capitalize(String str) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            char firstChar = str.charAt(0);
            return Character.isTitleCase(firstChar)?str:(new StringBuilder(strLen)).append(Character.toTitleCase(firstChar)).append(str.substring(1)).toString();
        } else {
            return str;
        }
    }
}
