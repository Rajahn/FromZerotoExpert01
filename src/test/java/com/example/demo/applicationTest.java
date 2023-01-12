package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;

@SpringBootTest
public class applicationTest {
    @Autowired(required = false)
    private DataSource dataSource;
    @Test
    public  void  datesourceTest() throws SQLException {
        System.out.println("数据源"+dataSource.getClass());
        Connection connection=dataSource.getConnection();
        System.out.println(connection!=null);
    }

}
