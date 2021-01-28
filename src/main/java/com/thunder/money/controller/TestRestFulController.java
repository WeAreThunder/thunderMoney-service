package com.thunder.money.controller;

import com.thunder.money.entity.BASE.RestFul;
import com.thunder.money.entity.BASE.Result;
import com.thunder.money.entity.DTO.TestGameDTO;
import com.thunder.money.entity.TestGame;
import com.thunder.money.service.TestGameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RestFul")
@Api("测试Restful")
public class TestRestFulController {
    @Qualifier("TestGameServiceImplCopy")
    @Autowired
    private TestGameService testGameService;

    @GetMapping("/getAll")
    public RestFul<List<TestGame>> getAll(){
        List<TestGame> testGames = testGameService.selectAll();
        TestGame testGame = new TestGame();
        RestFul.s(testGame);
        return RestFul.s(testGames).message("2333333333");
    }

    @GetMapping("/testResult")
    public Result test(){
        List<TestGame> testGames = testGameService.selectAll();
        TestGameDTO testGameDTO = new TestGameDTO();
        testGameDTO.setPage(1);
        testGameDTO.setSize(20);
//        testGameService.selectAllByTestGameDTO()
        return Result.success("success",testGames);
    }




}
