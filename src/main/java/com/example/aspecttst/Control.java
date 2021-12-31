package com.example.aspecttst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Control {
    private static final Logger logger = LoggerFactory.getLogger(Control.class);
    @ApiOperation("测试方法")
    @PostMapping("/test")
    public String tstHello(@RequestBody unAdd req){
        logger.info("方法执行中");
        return req.toString();

    }
}
