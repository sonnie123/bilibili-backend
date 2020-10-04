package com.rookie.bilibiliservice.seckill;

import com.rookie.bilibiliapi.seckill.TestService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class TestSServiceImpl implements TestService {
    @Override
    public String get() {
        return "hello";
    }
}
