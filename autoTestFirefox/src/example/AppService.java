package example;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface AppService {

	List<JSONObject> createApp(String url, String appName, String user, String pwd, String times, String interval)
			throws Exception;

}
