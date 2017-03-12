package com.jessen;

import com.jessen.domain.ExampleDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by sen.ye on 2017/3/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JessenApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFindAll(){
        String json = restTemplate.getForObject("/example/",String.class);
        System.out.println(json);
    }

    @Test
    public void testCreate(){
        ExampleDomain domain = new ExampleDomain();
        domain.setId(7000L);
        domain.setName("test4");
        domain.setPassword("123");
        domain.setCreateTime(new Date());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

//        String param = "{\"id\":6000,\"name\":\"test\",\"password\":\"test\",\"createTime\":1488349824000}";
//        String json = restTemplate.postForObject("/example/",new HttpEntity(param,headers),String.class,"");
//        System.out.println(json);

        String json = restTemplate.postForObject("/example/",new HttpEntity(domain,headers),String.class,"");
        System.out.println(json);

        //domain 与 json 只要定义的协议与请求的协议一样
    }

    @Test
    public void testUpdate(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ExampleDomain domain = new ExampleDomain();
        domain.setName("test4");
        domain.setPassword("123");
        domain.setCreateTime(new Date());

        restTemplate.put("/example/1000",new HttpEntity(domain,headers));

    }

    @Test
    public void testFindOne(){
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);

        String json = restTemplate.getForObject("/example/1000",String.class,"");
        System.out.println(json);
    }
}
