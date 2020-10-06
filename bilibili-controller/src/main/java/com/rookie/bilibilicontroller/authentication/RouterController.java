package com.rookie.bilibilicontroller.authentication;

import com.rookie.bilibiliapi.authentication.LoginService;
import com.rookie.bilibiliapi.authentication.RegisterService;
import com.rookie.bilibilibean.entity.entity.TConsumers;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @Reference
    RegisterService registerService;
    @Reference
    LoginService loginService;

    @RequestMapping({"/index","/"})
    public String index(){
        return "b_index";
    }

    @RequestMapping("/register")
    public String insert(@RequestBody TConsumers tConsumers){
        int i = 0;
        i = registerService.insert(tConsumers);
        if(i!=0){
            return "redirect:index";
        }else {
            return "b_404";
        }
    }

    @PostMapping("/toLogin")
    public String toLogin(@RequestBody TConsumers tConsumers){
        String name = tConsumers.getName();
        String password = tConsumers.getPassword();
        TConsumers tConsumers1 = loginService.login(name, password);
        if(tConsumers1!=null) {
            return "redirect:index";
        }else {
            return "b_404";
        }
    }
}
