package com.rookie.bilibilicontroller.seckill;

import com.rookie.bilibiliapi.seckill.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference
    TestService testService;

    @GetMapping("get")
    public String get(){
        return this.testService.get();
    }

}
