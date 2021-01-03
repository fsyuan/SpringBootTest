package com.test.base.tcl;

import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class huaxing {

    public static String doPost(String url, String appId, String token, String fileContent, String fileExt, String
            fileName)
            throws Exception {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("appId", appId);
        jsonObject.addProperty("token", token);
        jsonObject.addProperty("fileContent",
                new String(Files.readAllBytes(Paths.get(fileContent, new String[0])), "ISO-8859-1"));
        jsonObject.addProperty("fileExt", fileExt);
        jsonObject.addProperty("fileName", fileName);
        String json = jsonObject.toString();

        BufferedReader reader = null;
        String result = null;
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.setRequestMethod("POST");

            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setConnectTimeout(10000);

            urlConnection.setReadTimeout(10000);

            urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            byte[] bypes = json.getBytes("UTF-8");
            urlConnection.getOutputStream().write(bypes);

            //获取返回结果
            StringBuilder sb = new StringBuilder(30);

            int code = urlConnection.getResponseCode();
            System.out.println(code);
//            reader = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream(), Charset.forName("UTF-8")));

            if (code == 200) {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), Charset.forName("UTF-8")));
            } else {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream(), Charset.forName("UTF-8")));
            }
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
            System.out.println("请求返回：" + url + "，结果：" + result);
        } catch (Exception e) {
            throw e;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return result;
    }

    public static String doPost(String url, String appId, String token, String fileContent, String fileExt, String
            fileName, String type)
            throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(url);
            FileBody bin = new FileBody(new File(fileContent));
            StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);

//            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).addPart("comment", comment).build();
            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).addPart("comment", comment).build();
            httppost.setEntity(reqEntity);

            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}


