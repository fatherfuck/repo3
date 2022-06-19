package com.itheima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.Class.User;
import com.itheima.Class.Userdao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestspringbootApplication.class)
public class test {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    @Test
    public void test2() throws JsonProcessingException {
        String findAll = redisTemplate.boundValueOps("findAll").get();
        if (findAll==null){
            List<User> all = userDao.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(all);
            redisTemplate.boundValueOps("findAll").set(s);
        }
        System.out.println(findAll);
    }

}
