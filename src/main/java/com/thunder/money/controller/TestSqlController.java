package com.thunder.money.controller;

import com.thunder.money.entity.BASE.Result;
import com.thunder.money.entity.DTO.TestSqlDTO;
import com.thunder.money.entity.TestSql;
import com.thunder.money.service.TestGameService;
import com.thunder.money.service.TestService;
import com.thunder.money.service.TestSqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/testSql")
public class TestSqlController {
    @Autowired
    private TestSqlService testSqlService;

    @PostMapping("/save")
    public Result save(@RequestBody TestSql testSql) {
        int insert = testSqlService.insert(testSql);
        return Result.success("插入" + insert + "行", testSql);
    }

    @PostMapping("/select")
    public Result<List<TestSqlDTO>> select(@RequestBody TestSqlDTO testSqlDTO) {
        List<TestSqlDTO> testSqlDTOS = testSqlService.testSql(testSqlDTO);
        log.info("page:" + testSqlDTO.getPage() + ",size:" + testSqlDTO.getSize());
        return Result.success("查询成功", testSqlDTOS);
    }

}
