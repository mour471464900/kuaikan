package com.android.kuaikanmanhua.kuaikan.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络连接工具类
 * Created by hengheng on 2016/6/20.
 */
public class HttpUtilNow {

    private static final int TIMEOUT = 3000;

    private static HttpURLConnection getConnection(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(TIMEOUT);
        return conn;
    }

    private static String getResponseResult(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while((str = reader.readLine()) != null){
            buffer.append(str);
        }
        return buffer.toString();
    }

    /**
     * 实现get请求
     * @param urlStr
     * @return
     */
    public static String get(String urlStr){
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            conn = getConnection(urlStr);
            conn.setRequestMethod("GET");
            inputStream = conn.getInputStream();
            return getResponseResult(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null)
                conn.disconnect();
        }
        return null;
    }

    /**
     * 实现post请求
     * @param urlStr
     * @return
     */
    public static String post(String urlStr,String param){
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            conn = getConnection(urlStr);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            //得到输出流,发送参数
            PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
            printWriter.write(param);
            printWriter.flush();
            printWriter.close();
            inputStream = conn.getInputStream();
            return getResponseResult(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null)
                conn.disconnect();
        }
        return null;
    }

    /**
     * 从网路读图片
     * @param urlStr
     * @return
     */
    public static Bitmap getImage(String urlStr){
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            conn = getConnection(urlStr);
            conn.setRequestMethod("GET");
            inputStream = conn.getInputStream();
            return BitmapFactory.decodeStream(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null)
                conn.disconnect();
        }
        return null;
    }

}
