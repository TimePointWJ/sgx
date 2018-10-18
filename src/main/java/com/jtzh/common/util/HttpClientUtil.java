package com.jtzh.common.util;

import com.google.common.collect.Lists;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Yufeng Yao on 2016/6/13 15:50.
 */
public class HttpClientUtil {

    public static String doGet(String url, Map<String, String> param) {
        return doGetWithAuth(url, param, null);
    }

    public static String doGetWithAuth(String url, Map<String, String> param, Map<String, String> auth) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = getCloseableHttpClient(auth);

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String doGet(String url) {
        return doGet(url, null);
    }

    public static String doPost(String url, Map<String, String> param) {
        return doPost(url, param, null);
    }

    public static String doPostWithAuth(String url, Map<String, String> param, Map<String, String> head, Map<String, String> auth) {
        CloseableHttpClient httpClient = getCloseableHttpClient(auth);

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = Lists.newArrayListWithCapacity(param.size());
                paramList.addAll(param.keySet().stream().map(key -> new BasicNameValuePair(key, param.get(key))).collect(Collectors.toList()));
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            if (head != null) {
                List<Header> headers = Lists.newArrayListWithCapacity(head.size());
                headers.addAll(head.keySet().stream().map(key -> new BasicHeader(key, head.get(key))).collect(Collectors.toList()));
                httpPost.setHeaders(headers.toArray(new Header[headers.size()]));
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    private static CloseableHttpClient getCloseableHttpClient(Map<String, String> auth) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient;
        if (!CollectionUtils.isEmpty(auth)) {
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(auth.get("userName"), auth.get("password"));
            provider.setCredentials(AuthScope.ANY, credentials);
            httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
        } else {
            httpClient = HttpClients.createDefault();
        }
        return httpClient;
    }

    public static String doPost(String url, Map<String, String> param, Map<String, String> head) {
        return doPostWithAuth(url, param, head, null);
    }

    public static String doPost(String url) {
        return doPost(url, null);
    }

    public static String doPostJsonWithAuth(String url, String json, Map<String, String> auth) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = getCloseableHttpClient(auth);
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String doPostJson(String url, String json) {
        return doPostJsonWithAuth(url, json, null);
    }

}

