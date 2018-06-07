package dce.service;

import java.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;

import common.Base;
import common.CreateOneApp;

//@Test
public class ServiceHighCfg {
	/**
	 * 
	 * @author yangw
	 * @version 1.0.0
	 * @project DCE
	 */
	Base pubMeth = new Base();
	static WebDriver driver;
	
	@Autowired
	private static  RestTemplate restTemplate = new RestTemplate();
	
	//@Test
	public static  Object callResult (String appName) throws IOException{
			
			//参数解析类型转换
			 File file = ResourceUtils.getFile("/Users/yangwei/eclipse-workspace/autoTestFirefox/src/dce/service/"+appName);
			 String params2 = "";
			 String temp = "";
			 BufferedReader br = new BufferedReader((new FileReader(file)));
			 do {
				 params2 += "\n" + temp; 
				 temp = br.readLine();
			 }while (temp != null); 
			 System.out.println("params2="+params2);
			 Object response = call("192.168.123.109/dce/kube-apps-utils/verify-yaml","admin","admin",params2,restTemplate);
			 System.out.println(response);
			 return response;	 
		}
	
	//@Test
	public static  Object call(String url, String user, String pwd, String params, RestTemplate restTemplate){
			String http = "http://"+url +"";
			System.out.println(http);
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.add("content-type", "text/yaml" );
			requestHeaders.add("x-dce-access-token", "eyJhbGciOiJIUzI1NiIsImV4cCI6MTUyNTc4MDI3NCwiaWF0IjoxNTIzMTg4Mjc0fQ.eyJ1c2VybmFtZSI6ImFkbWluIn0.rrsi4Mpfr0SvleAEHQabia6h3wtryGnwANfRtSdZcmk");
		
			//JSONObject jsonParams2 = JSONObject.parseObject(params);
			//System.out.println("jsonParams2="+jsonParams2);
			System.out.println("headers"+requestHeaders);
			HttpEntity<JSONObject> requestEntity = new HttpEntity(params, requestHeaders);
			System.out.println("new requestheader"+params);
			JSONObject jsonBody = restTemplate.postForEntity(http, requestEntity, JSONObject.class).getBody();
			
			System.out.println("send body"+jsonBody);
			String result = jsonBody.toJSONString();
			System.out.println("result="+result);
	        return result;
	        
		}
		
	public static void main(String[] args) throws Exception {
		Object obj = callResult("highcon");
		System.out.println(obj);
	}
	
}
