package dce.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

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

@Test
public class ServiceHighCfgYamlString extends ServiceHighCfg {
	/**
	 * 
	 * @author yangw
	 * @version 1.0.0
	 * @project DCE
	 */
	Base pubMeth = new Base();
	static WebDriver driver;
	CreateOneApp oneApp = new CreateOneApp();
	@Test
	public void serviceHigh() throws Exception {
			//driver = useAppit.createOneApplication(driver);
			Object obj = callResult("highcon");
			System.out.println(obj);
		}
	
	@Autowired
	private static  RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public static String callResult (String appName) throws IOException{	
			//参数解析类型转换
			 File file = ResourceUtils.getFile("/Users/yangwei/eclipse-workspace/autoTestFirefox/src/dce/service/"+appName);
			 String params2 = "";
			 String temp = "";
			 BufferedReader br = new BufferedReader((new FileReader(file)));
			 do {
				 params2 += "\n" + temp; 
				 temp = br.readLine();
			 }while (temp != null); 
			//System.out.println("params2="+params2);
			 String response = call("192.168.123.109/dce/kube-apps-utils/verify-yaml","admin","admin",params2,restTemplate);
			 System.out.println("callResult"+response);
			 return response;	 
		}
	
	@Test
	public static String call(String url, String user, String pwd, String params, RestTemplate restTemplate){
			String http = "http://"+url +"";
			System.out.println(http);
			
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			String plainUser = user+":"+pwd;
			String base64plainUser = Base64.getEncoder().encodeToString(plainUser.getBytes());
			requestHeaders.add("Authorization", "Basic " + base64plainUser);

			requestHeaders.add("content-type", "text/yaml" );
			//requestHeaders.add("x-dce-access-token", "eyJhbGciOiJIUzI1NiIsImV4cCI6MTUyNTc4MDI3NCwiaWF0IjoxNTIzMTg4Mjc0fQ.eyJ1c2VybmFtZSI6ImFkbWluIn0.rrsi4Mpfr0SvleAEHQabia6h3wtryGnwANfRtSdZcmk");
			//JSONObject jsonParams2 = JSONObject.parseObject(params);
			//System.out.println("jsonParams2="+jsonParams2);
			System.out.println("headers"+requestHeaders);
			HttpEntity<String> requestEntity = new HttpEntity(params, requestHeaders);
			//System.out.println("new requestheader"+params);
			String rsp = restTemplate.postForEntity(http, requestEntity, String.class).getBody();
			System.out.println("send body"+rsp);
			//String result = jsonBody.toJSONString();
			//System.out.println("Class: CallDceApi.java  -----|"+result);
	        return rsp;  
		}
		
	//public static void main(String[] args) throws Exception {
	//	Object obj = callResult("highcon");
	//	System.out.println(obj);
	//}
	
}
