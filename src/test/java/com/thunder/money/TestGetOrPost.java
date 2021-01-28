package com.thunder.money;

import com.sun.deploy.net.offline.WIExplorerOfflineHandler;
import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class TestGetOrPost {
    public static void main(String[] args) {

//        sendGet("http://localhost:2333/game/", "10");
//
//        sendPost("http://localhost:2333/game/saveList", "[\n" +
//                "        {\"name\": \"6\",\n" +
//                "            \"version\": 2,\n" +
//                "            \"likeCount\": 0,\n" +
//                "            \"createTime\": \"2020-09-11T14:13:16.000+00:00\",\n" +
//                "            \"editTime\": \"2020-09-11T14:13:16.000+00:00\"},\n" +
//                "        {\"name\": \"66\",\n" +
//                "            \"version\": 2,\n" +
//                "            \"likeCount\": 0,\n" +
//                "            \"createTime\": \"2020-09-11T14:13:16.000+00:00\",\n" +
//                "            \"editTime\": \"2020-09-11T14:13:16.000+00:00\"},\n" +
//                "        {\"name\": \"666\",\n" +
//                "            \"version\": 2,\n" +
//                "            \"likeCount\": 0,\n" +
//                "            \"createTime\": \"2020-09-11T14:13:16.000+00:00\",\n" +
//                "            \"editTime\": \"2020-09-11T14:13:16.000+00:00\"},\n" +
//                "        {\"name\": \"6666\",\n" +
//                "            \"version\": 2,\n" +
//                "            \"likeCount\": 0,\n" +
//                "            \"createTime\": \"2020-09-11T14:13:16.000+00:00\",\n" +
//                "            \"editTime\": \"2020-09-11T14:13:16.000+00:00\"}\n" +
//                "]");
//
//        sendPost("http://localhost:2333/game/getAll?page=1&size=10", "{\n" +
//                "    \"name\":\"6\",\n" +
//                "    \"version\":2,\n" +
//                "    \"maxLikeCount\":100,\n" +
//                "    \"minLikeCount\":0,\n" +
//                "    \"maxCreateDate\":\"2020-12-01\",\n" +
//                "    \"minCreateDate\":\"2020-09-11\"\n" +
//                "}");
//
//        sendDelete("http://localhost:2333/game/11", null);
//
//        sendPost("http://he-erm.fehorizon.com/hxbiz/gdms/list-process-method.action",
//                "{\"equNo\":\"SHX-SG01862860SJ\",\"componentCode\":\"202170708\"}");
//        doPost("http://he-erm.fehorizon.com/hxbiz/gdms/list-process-method.action","{\"equNo\":\"SHX-SG01862860SJ\",\"componentCode\":\"202170708\"}");


        sendGet("http://172.16.90.27:7003/cplink/EMPWebService/accountBalanceQuery", null);

    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            if (!StringUtils.isBlank(param)) {
                urlNameString = url + "/" + param;
            }
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            // 建立实际的连接
            connection.connect();
            String contentType = connection.getContentType();
            System.out.println("链接类型" + contentType);
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            System.out.println("GET返回头为：");
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println("GET返回值为：" + result);
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url  发送请求的 URL
     * @param json 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String json) {
        DataOutputStream out = null;

        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //设置传输字符编码使用utf8
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new DataOutputStream(conn.getOutputStream());
            // 发送请求参数
            out.writeChars(json);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            // 获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            System.out.println("POST返回头为：");
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("POST返回值为：" + result);
        return result;
    }


    /**
     * 访问delete接口
     @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     *
     * */
    public static String sendDelete(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            if (!StringUtils.isBlank(param)) {
                urlNameString = url + "/" + param;
            }
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setRequestMethod("DELETE");
            // 建立实际的连接
            connection.connect();
            String contentType = connection.getContentType();
            System.out.println("链接类型" + contentType);
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            System.out.println("DELETE返回头为：");
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送DELETE请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println("DELETE返回值为：" + result);
        return result;
    }

    public static String doPost(String URL,String json){
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        try{
            URL url = new URL(URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            //发送POST请求必须设置为true
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //设置连接超时时间和读取超时时间
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //获取输出流
            out = new OutputStreamWriter(conn.getOutputStream());
            String jsonStr = json;
            out.write(jsonStr);
            out.flush();
            out.close();
            //取得输入流，并使用Reader读取
            if (200 == conn.getResponseCode()){
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null){
                    result.append(line);
                    System.out.println(line);
                }
            }else{
                System.out.println("ResponseCode is an error code:" + conn.getResponseCode());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(out != null){
                    out.close();
                }
                if(in != null){
                    in.close();
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
        return result.toString();
    }


}

