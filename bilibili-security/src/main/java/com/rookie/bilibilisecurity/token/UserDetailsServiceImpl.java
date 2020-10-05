package com.rookie.bilibilisecurity.token;

import com.rookie.bilibilibean.entity.TConsumers;
import com.rookie.bilibilidao.dao.TConsumersDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Resource
	TConsumersDao tConsumersDao;
 
	@Override
	public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
		TConsumers tConsumers = tConsumersDao.queryByName(name);
		if (tConsumers == null) {
			throw new UsernameNotFoundException(name + "该用户信息不存在");
		}else{
			List<GrantedAuthority> authList = new ArrayList<>();
//			// 具体具有什么的权限
//			authList.add(new SimpleGrantedAuthority(tConsumers.getRoleNo()));
			return new User(tConsumers.getName(),tConsumers.getPassword(),authList);
		}
	}
}