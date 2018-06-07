package example;


import com.alibaba.fastjson.JSONObject;
//import io.daocloud.utils.CallDceApi;
//import io.daocloud.utils.Getuuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gq on 2017/12/6.
 */

@Service(value="appServer")
public class AppServer implements AppService{

    @Autowired
    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<JSONObject> createApp(String url,String appName,String user,String pwd,String times,String interval) throws Exception {

        List<JSONObject> results = new ArrayList<>();

        //参数解析类型转换
        File file = ResourceUtils.getFile("classpath:templates/"+appName);
        String params2 = new BufferedReader((new FileReader(file))).readLine();

        float intervals = Float.parseFloat(interval);
        int time = Integer.parseInt(times);
        long delay = 1000L;
        long period = (long) (intervals * 60 * 1000);


        for(int i=0;i<time;i++){

            //String uuid = Getuuid.getUUID();
           // String newParams = params2.replaceAll("autotest",uuid);

            //JSONObject response = CallDceApi.call(url,user,pwd,newParams,restTemplate);
           // results.add(response);
            if(period != 0)
                Thread.sleep(period);

        }

        //任务调度器进行任务调度，保证线程安全
        /*Timer timer = new Timer();
        MyTimerTask mytask = new MyTimerTask(url,user,pwd,newParams,restTemplate);
        mytask.setExecNumber(time);

        timer.schedule(mytask,delay,period);

        //JSONObject response = CallDceApi.call(url,user,pwd,newParams,restTemplate);

        while(!mytask.isFlag()){
            Thread.sleep(10);
        }*/

        return results;
    }


    public static void main(String[] args) throws Exception {

        //new AppService().getApp("https://192.168.222.146/dce/kube-apps");
    }
}