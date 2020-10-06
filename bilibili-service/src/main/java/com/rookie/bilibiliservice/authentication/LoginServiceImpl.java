package com.rookie.bilibiliservice.authentication;

import com.rookie.bilibiliapi.authentication.LoginService;
import com.rookie.bilibilibean.entity.entity.TConsumers;
import com.rookie.bilibilidao.dao.TConsumersDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Service
@Component
public class LoginServiceImpl implements LoginService {
    @Resource
    TConsumersDao tConsumersDao;

    @Override
    public TConsumers login(String name, String Password) {
        return this.tConsumersDao.queryByNameAndPwd(name, Password);
    }
}
