package com.thunder.money.entity.DTO;

import com.thunder.money.entity.TestEntity;
import com.thunder.money.entity.TestGame;
import com.thunder.money.entity.TestSql;
import lombok.Data;

@Data
public class TestSqlDTO {
    private int page;
    private int size;
    private int startRow;
    private int endRow;

    private TestSql testSql;
    private TestEntity testLove;
    private TestGame testGame;
}
