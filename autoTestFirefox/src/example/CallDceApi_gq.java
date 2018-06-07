package example;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

/**
 * Created by gq on 2017/12/8.
 */
public class CallDceApi_gq {
    public static JSONObject call(String url, String user, String pwd, String params, RestTemplate restTemplate){

        //构建http url访问地址
        String http = "http://"+url +"/dce/kube-apps";

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        //访问dce平台的用户名和密码，添加到访问头信息中
        //String plainCredentials="admin:admin";
        String plainCredentials=user+":"+pwd;
        String base64Credentials = Base64.getEncoder().encodeToString(plainCredentials.getBytes());
        requestHeaders.add("Authorization", "Basic " + base64Credentials);


        //Map params = new TreeMap();
/*
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            requestHeaders.add(key, value);
        }*/

        //将map对象转换成json对象
        //JSONObject jsonParams = JSONObject.parseObject(JSON.toJSONString(params));

        JSONObject jsonParams2 = JSONObject.parseObject(params);

        HttpEntity<JSONObject> requestEntity = new HttpEntity(jsonParams2, requestHeaders);

        JSONObject jsonBody = restTemplate.postForEntity(http, requestEntity, JSONObject.class).getBody();

        String result = jsonBody.toJSONString();

        System.out.println("Class: CallDceApi.java  -----|"+result);
        return jsonBody;

    }
}
