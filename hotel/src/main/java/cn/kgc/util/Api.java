/*
package cn.kgc.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class Api {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject postRequestFromUrl(String url, String body) throws IOException, JSONException {
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        PrintWriter out = new PrintWriter(conn.getOutputStream());
        out.print(body);
        out.flush();

        InputStream inputStream = null;
        try {
            inputStream = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            inputStream.close();
        }
    }

    public static JSONObject getRequestFromUrl(String url) throws IOException, JSONException {
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        InputStream inputStream = null;
        try {
            inputStream = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            inputStream.close();
        }
    }
    public static void main(String[] args) throws IOException, JSONException {

// 请求示例 url 默认请求参数已经做URL编码
        String url = "http://api01.idataapi.cn:8000/hotel/ctrip?cityid=30&get_proxy=1&id=457399&no_flat=1&islogin=1&source=app&checkInDate=2019-12-16&checkOutDate=2019-12-18&web_detail=1&detail=1&get_brand=1&apikey=WQ3q4oXEKv20MfzKyFFnUsEYd43h96FIN1GVAdirGO0RzyqSnj3YmE9TBDKgrqGH";
        JSONObject json = getRequestFromUrl(url);

        System.out.println(json.toString());




        //String data=json.get("data").toString();
        //JsonObject dataJson=JONObject.parseObject(data);


       System.out.println(json.toString());

       // Object parse = JSON.parse(String.valueOf(json));
    }
}
*/
