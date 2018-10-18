/*package com.jtzh;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jtzh.entity.UnionSource;

import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SgxOaApplicationTests {

	@Test
	public void contextLoads() {
	}

	private MockMvc mockMvc;
	
	@Autowired  
    private WebApplicationContext wac; // 注入WebApplicationContext  
	
	   @Before // 在测试开始前初始化工作  
	    public void setup() {  
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();  
	    } 
	   
	   
	   @Test  
	    public void testSave() throws Exception {  
	    	Map<String, Object> map = new HashMap<>();
	    	map.put("newsTitle", "合肥");
	    	map.put("newsSource", "测试");
	    	map.put("newsContent", "heddd");
	    	List<UnionSource> s = new ArrayList<UnionSource>();
	    	map.put("sourceList", s);
	    	MvcResult result = mockMvc.perform(post("/news/addNews").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
	    			.andExpect(status().isOk())// 模拟向testRest发送get请求  
	    			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8  
	    			.andReturn();// 返回执行请求的结果  
	    	
	    	System.out.println(result.getResponse().getContentAsString());  
	    }  


}
*/