package com.ethan.sb.labs.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * @author zhenghui
 * @Description 不启动tomcat单元测试
 * @Date 2022/6/25
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SpringSecurityLabApplicationMockTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andDo(MockMvcResultHandlers.print());
    }
}
