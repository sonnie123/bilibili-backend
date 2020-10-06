package com.rookie.bilibiliapi.authentication;

import com.rookie.bilibilibean.entity.entity.TConsumers;

public interface LoginService {
    TConsumers login(String name,String Password);
}
