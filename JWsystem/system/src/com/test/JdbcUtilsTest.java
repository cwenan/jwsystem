package com.test;

import com.utils.JdbcUtils;
import org.junit.Test;

public class JdbcUtilsTest {
    @Test
    public void jdbcutiltest(){
        System.out.println(JdbcUtils.getConnection());
    }
}
