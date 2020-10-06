package com.rookie.bilibiliservice.authentication;

import com.rookie.bilibiliapi.authentication.RegisterService;
import com.rookie.bilibilibean.entity.entity.TConsumers;
import com.rookie.bilibilidao.dao.TConsumersDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Service
@Component
public class RegisterServiceImpl implements RegisterService {
    @Resource
    TConsumersDao tConsumersDao;

    @Override
    public int insert(TConsumers tConsumers) {
        return this.tConsumersDao.insert(tConsumers);
    }
}
