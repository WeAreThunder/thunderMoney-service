package com.thunder.money.mapper;

import com.thunder.money.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface TestMapper {

    @Select("select * from test_love")
    public List<TestEntity> selectAll();

    @Select("select * from test_love where id = ${id}")
    public TestEntity selectById(@PathParam("id") int id);

    public List<TestEntity> getAllByXml();

    TestEntity getOneByXml(@PathParam("id") int id);

    int insert(@PathParam("testEntity") TestEntity testEntity);


}
