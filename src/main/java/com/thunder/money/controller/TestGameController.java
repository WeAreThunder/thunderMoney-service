package com.thunder.money.controller;

import com.thunder.money.entity.BASE.RestFul;
import com.thunder.money.entity.BASE.Result;
import com.thunder.money.entity.DTO.TestGameDTO;
import com.thunder.money.entity.TestGame;
import com.thunder.money.service.TestGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController()
@RequestMapping("/game")
@Api(tags = "TestGameController测试接口")
@Slf4j
public class TestGameController {
    /**
    * 使用Autowired引入service，使用Qualifier指定引入service的同名impl
    * */
    @Autowired
    @Qualifier("TestGameServiceImpl")
    private TestGameService testGameService;

    @Autowired
    @Qualifier("TestGameServiceImplCopy")
    private TestGameService testGameServiceCopy;

    /**
    * 该模块实现了对数据库表的增删改查和多条件分页查询
    * java doc
     * @param page 页数
     * @param size 每页显示个数
     * @return 封装后的数据
    * */
    @ApiOperation("多条件分页查询")
    @PostMapping("/getAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页数",defaultValue  = "1"),
            @ApiImplicitParam(name = "size",value = "每页条数",defaultValue  = "5")
    })
    public List<TestGame> testGet(@RequestParam(value = "page",defaultValue="1") int page,
                                  @RequestParam(value = "size",defaultValue="5") int size,
                                  @RequestBody TestGameDTO testGameDTO) {
        List<TestGame> testGames = testGameService.selectAllByTestGameDTOAndPage(page, size,testGameDTO);
        List<TestGame> testGames1 = testGameServiceCopy.selectAllByTestGameDTOAndPage(page, size, testGameDTO);
        return testGames;
    }

    @PostMapping("/getAllByDTO")
    public List<TestGame> testPost(@RequestBody TestGameDTO testGameDTO){
        List<TestGame> testGames = testGameService.selectByTestGameDTO(testGameDTO);
        return testGames;
    }

    @GetMapping("/{id}")
    public TestGame get(@PathVariable("id") int id) {
        TestGame testGame = testGameService.selectByPrimaryKey(id);
        return testGame;
    }

    @PostMapping("/insert")
    public TestGame post(@RequestBody TestGame testGame) {
        int i = testGameService.insertSelective(testGame);
        TestGame dbTestGame = testGameService.selectByPrimaryKey(i);
        return dbTestGame;
    }

    @PostMapping("/update")
    public TestGame postUpdate(@RequestBody TestGame testGame) {
        int i = testGameService.updateByPrimaryKeySelective(testGame);
        TestGame dbTestGame1 = testGameService.selectByPrimaryKey(testGame.getId());
        return dbTestGame1;
    }

    @DeleteMapping("/{id}")
    public int detect(@PathVariable("id") int id) {
        int i = testGameService.deleteByPrimaryKey(id);
        return i;
    }

    @PostMapping("/saveList")
    //异步注解
    @Async
    public RestFul saveList(@RequestBody List<TestGame> testGameList,
                            HttpServletRequest request) {
        int i = testGameServiceCopy.insertList(testGameList);
        StringBuilder stringBuilder = new StringBuilder();
        for (TestGame testGame : testGameList) {
            stringBuilder.append(testGame.toString());
        }
        //spring
        System.out.println(stringBuilder);
        String s = stringBuilder.toString();
        StringBuffer stringBuffer = new StringBuffer();
        log.info("ip:"+request.getRemoteAddr()+"用户aaaa_ss_2尝试访问改接口");
        stringBuffer.append("233333333");
        return RestFul.s(testGameList);
    }

    @GetMapping("/testMySql")
    public Result testSql(){

        return Result.success("2333");
    }

}
