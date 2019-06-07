package czd.wcssbackend.web.security;

import czd.wcssbackend.common.model.User;
import czd.wcssbackend.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
//自定义配置用户信息
@Component
public class WCSSUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userBean=getLoginUser(s);

        return new org.springframework.security.core.userdetails.User(String.valueOf(userBean.getId()),passwordEncoder.encode(userBean.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList(userBean.getIdentity()));
    }

    private User getLoginUser(String s)throws UsernameNotFoundException
    {
        int id=-1;
        try{
            id=Integer.valueOf(s);
        } catch (NumberFormatException e)
        {

        }
        User userBean=null;
        if(id!=-1)
            userBean=userService.getUser(Integer.valueOf(s));
        if(userBean==null)
        {
            if((userBean=userService.getUserByName(s))==null)
                if((userBean=userService.getUserByPhone(s))==null)
                    if((userBean=userService.getUserByEmail(s))==null)
                        throw new UsernameNotFoundException("找不到该账户信息！");
        }
        return userBean;
    }
}
