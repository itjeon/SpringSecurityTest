package kr.re.inspace;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticateService implements UserDetailsService{
    
    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
         UserVO userVO = userService.getUsersByID(username);
         if (userVO == null) {
             throw new UsernameNotFoundException("No user found with username" + userVO.getName());
         }
         
         Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
         roles.add(new SimpleGrantedAuthority("ROLE_USER"));
         
         UserDetails user = new User(username, userVO.getPassword(), roles);
         return user;
     }
}