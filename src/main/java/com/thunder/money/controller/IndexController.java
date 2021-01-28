package com.thunder.money.controller;

import com.sun.media.jfxmedia.logging.Logger;
import com.thunder.money.entity.TestEntity;
import com.thunder.money.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    private TestService testService;

    @GetMapping("/")
    public String index(){
        return "helloWord";
    }

    @DeleteMapping("/something/{value}")
    public String testDelete(@PathVariable("value") String value){
        HashMap<String,Integer> love = new HashMap<String,Integer>();
        love.put("2ds",1);
        love.put("2sdf",1);
        love.put("2dfv",1);
        love.put("22sdfad",1);
        love.put(null,1);
        love.put(null,6);
        System.out.println(love.size());
        return "2333"+value+love;
    }

    @GetMapping("/getAll")
    public List<TestEntity> getAll(){
        List<TestEntity> testEntity = testService.selectAll();
        return testEntity;
    }

    @GetMapping("/getOne/{id}")
    public TestEntity getOne(@PathVariable("id") int id){
        TestEntity testEntity = testService.selectById(id);
        return testEntity;
    }

    @GetMapping("/getAllByXml")
    public List<TestEntity> getAllByXml(){
        List<TestEntity> allByXml = testService.getAllByXml();
        return allByXml;
    }

    @GetMapping("/getOneByXml/{id}")
    public TestEntity getOneByXml(@PathVariable("id") int id){
        TestEntity testEntity = testService.getOneByXml(id);
        return testEntity;
    }

    @GetMapping("/insert")
    public int insertGet(){
        TestEntity testEntity = new TestEntity();
        testEntity.setName(Long.toString(System.currentTimeMillis()));
        return testService.insert(testEntity);
    }

    @PostMapping("/insert")
    public TestEntity insertPost(@RequestBody TestEntity testEntity){
        int insert = testService.insert(testEntity);
        System.out.println(testEntity);
        return testEntity;
    }

}
