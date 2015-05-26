/*
 * 微信公众平台(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * 
 * http://www.weixin4j.org/sdk/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.weixin4j.http;

import java.io.BufferedInputStream;
import org.weixin4j.Configuration;
import org.weixin4j.WeixinException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import net.sf.json.JSONObject;

/**
 * 请求微信平台及响应的客户端类
 *
 * <p>
 * 每一次请求即对应一个<tt>HttpClient</tt>，
 * 每次登陆产生一个<tt>OAuth</tt>用户连接,使用<tt>OAuthToken</tt>
 * 可以不用重复向微信平台发送登陆请求，在没有过期时间内，可继续请求。</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class HttpClient implements java.io.Serializable {

    private static final int OK = 200;  // OK: Success!
    private static final int ConnectionTimeout = Configuration.getConnectionTimeout();
    private static final int ReadTimeout = Configuration.getReadTimeout();
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String _GET = "GET"; // GET
    private static final String _POST = "POST";// POST

    public HttpClient() {
    }

    /**
     * Post JSON数据
     *
     * @param url 提交地址
     * @param json JSON数据
     * @return 输出流对象
     * @throws WeixinException
     */
    public Response post(String url, JSONObject json) throws WeixinException {
        //将JSON数据转换为String字符串
        String jsonString = json == null ? null : json.toString();
        if (Configuration.isDebug()) {
            System.out.println("URL POST 数据：" + jsonString);
        }
        //提交数据
        return httpRequest(url, _POST, jsonString);
    }

    /**
     * Get 请求
     *
     * @param url 请求地址
     * @return 输出流对象
     * @throws WeixinException
     */
    public Response get(String url) throws WeixinException {
        return httpRequest(url, _GET, null);
    }

    /**
     * Post XML格式数据
     *
     * @param url 提交地址
     * @param xml XML数据
     * @return 输出流对象
     * @throws WeixinException
     */
    public Response postXml(String url, String xml) throws WeixinException {
        return httpRequest(url, _POST, xml);
    }

    private Response httpRequest(String url, String method, String postData) throws WeixinException {
        Response res = null;
        OutputStream osw;
        try {
            //创建http请求连接
            HttpsURLConnection http = getHttpsURLConnection(url);
            if (http != null) {
                //设置Header信息
                setHeaders(http, method);
                //判断是否提交数据
                if (null != postData) {
                    //讲参数转换为字节提交
                    byte[] bytes = postData.getBytes(DEFAULT_CHARSET);
                    //设置头信息
                    http.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                    //开始连接
                    http.connect();
                    //获取返回信息
                    osw = http.getOutputStream();
                    osw.write(bytes);
                    osw.flush();
                    osw.close();
                } else {
                    //开始连接
                    http.connect();
                }
                //创建输出对象
                res = new Response(http);
                //获取响应代码
                if (res.getStatus() == OK) {
                    return res;
                }
                // 关闭连接
                http.disconnect();
            }
        } catch (NoSuchAlgorithmException ex) {
            throw new WeixinException(ex.getMessage(), ex);
        } catch (KeyManagementException ex) {
            throw new WeixinException(ex.getMessage(), ex);
        } catch (NoSuchProviderException ex) {
            throw new WeixinException(ex.getMessage(), ex);
        } catch (IOException ex) {
            throw new WeixinException(ex.getMessage(), ex);
        }
        return res;
    }

    /**
     * 获取https请求连接
     *
     * @param url 连接地址
     * @return https连接对象
     * @throws IOException
     */
    private HttpsURLConnection getHttpsURLConnection(String url) throws IOException {
        URL urlGet = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) urlGet.openConnection();
        if (ConnectionTimeout > 0) {
            con.setConnectTimeout(ConnectionTimeout);
        }
        if (ReadTimeout > 0) {
            con.setReadTimeout(ReadTimeout);
        }
        return con;
    }

    /**
     * 获取http请求连接
     *
     * @param url 连接地址
     * @return https连接对象
     * @throws IOException
     */
    private HttpURLConnection getHttpURLConnection(String url) throws IOException {
        URL urlGet = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlGet.openConnection();
        if (ConnectionTimeout > 0) {
            con.setConnectTimeout(ConnectionTimeout);
        }
        if (ReadTimeout > 0) {
            con.setReadTimeout(ReadTimeout);
        }
        return con;
    }

    private void setHeaders(HttpsURLConnection http, String method) throws NoSuchAlgorithmException, KeyManagementException, NoSuchProviderException, IOException {
        //创建https请求证书
        TrustManager[] tm = {new MyX509TrustManager()};
        //创建证书上下文对象
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        //初始化证书信息
        sslContext.init(null, tm, new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象  
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        //设置header信息
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //设置User-Agent信息
        http.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36");
        //设置可接受信息
        http.setDoOutput(true);
        //设置可输入信息
        http.setDoInput(true);
        //设置连接超时时间
        http.setConnectTimeout(ConnectionTimeout);
        //设置 读取超时 --服务器响应比较慢，增大时间
        http.setReadTimeout(ReadTimeout);
        //设置请求方式
        http.setRequestMethod(method);
        //设置ssl证书
        http.setSSLSocketFactory(ssf);
    }

    private void setHeader(HttpURLConnection http, String method) throws IOException {
        // 连接超时
        http.setConnectTimeout(25000);
        // 读取超时 --服务器响应比较慢，增大时间
        http.setReadTimeout(25000);
        http.setRequestMethod(method);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        http.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36");
        http.setDoOutput(true);
        http.setDoInput(true);
        http.connect();
    }

    /**
     * 上传文件
     *
     * @param url 上传地址
     * @param file 上传文件对象
     * @return 服务器上传响应结果
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws KeyManagementException
     */
    public String upload(String url, File file) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        String BOUNDARY = "----WebKitFormBoundaryiDGnV9zdZA1eM1yL"; // 定义数据分隔线  
        StringBuffer bufferRes;
        URL urlGet = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlGet.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36");
        conn.setRequestProperty("Charsert", "UTF-8");
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

        OutputStream out = null;
        DataInputStream dataIns = null;
        try {
            out = new DataOutputStream(conn.getOutputStream());
            byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线  
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filename=\"").append(file.getName()).append("\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] data = sb.toString().getBytes();
            out.write(data);
            //读取文件流
            dataIns = new DataInputStream(new FileInputStream(file));
            int bytes;
            byte[] bufferOut = new byte[1024];
            while ((bytes = dataIns.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            out.write("\r\n".getBytes()); //多个文件时，二个文件之间加入这个  
            dataIns.close();
            out.write(end_data);
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }

        // 定义BufferedReader输入流来读取URL的响应  
        InputStream ins = null;
        try {
            ins = conn.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
            String valueString;
            bufferRes = new StringBuffer();
            while ((valueString = read.readLine()) != null) {
                bufferRes.append(valueString);
            }
        } finally {
            if (ins != null) {
                ins.close();
            }
        }

        // 关闭连接
        conn.disconnect();
        return bufferRes.toString();
    }

    /**
     * 下载附件
     *
     * @param url 附件地址
     * @return 附件对象
     * @throws IOException
     */
    public Attachment download(String url) throws IOException {
        Attachment att = new Attachment();
        URL _url = new URL(url);
        HttpURLConnection http = (HttpURLConnection) _url.openConnection();
        //设置头
        setHeader(http, "GET");
        if (http.getContentType().equalsIgnoreCase("text/plain")) {
            // 定义BufferedReader输入流来读取URL的响应  
            InputStream in = http.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String valueString = null;
            StringBuilder bufferRes = new StringBuilder();
            while ((valueString = read.readLine()) != null) {
                bufferRes.append(valueString);
            }
            in.close();
            att.setError(bufferRes.toString());
        } else {
            BufferedInputStream bis = new BufferedInputStream(http.getInputStream());
            String ds = http.getHeaderField("Content-disposition");
            String fullName = ds.substring(ds.indexOf("filename=\"") + 10, ds.length() - 1);
            String relName = fullName.substring(0, fullName.lastIndexOf("."));
            String suffix = fullName.substring(relName.length() + 1);

            att.setFullName(fullName);
            att.setFileName(relName);
            att.setSuffix(suffix);
            att.setContentLength(http.getHeaderField("Content-Length"));
            att.setContentType(http.getHeaderField("Content-Type"));

            att.setFileStream(bis);
        }
        return att;
    }
}
