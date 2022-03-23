package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 시큐리티가 로그인을 대신 진행해주고 완료 되면 UserDetails 타입의 오브젝트를 고유한 세션 저장소에 저장해줌
public class PrincipalDetail implements UserDetails {

    private User user;


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getJoinId();
    }

    // 계정이 만료되지 않은지 리턴 (true: 만료 안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있지 않은지 리턴
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만료되지 않은지 리턴
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    // 계정이 활성화인지 리턴
    @Override
    public boolean isEnabled() {
        return false;
    }

    // 계정의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
//        collectors.add(new GrantedAuthority(){
//
//            @Override
//            public String getAuthority() {
//                return "ROLE_" + user.getRole();
//            }
//        });
        collectors.add(()->{
            return "ROLE_" + user.getRole();   // 꼭 ROLE_USER 와 같은 식으로 리턴해야 함
        });

        return collectors;
    }
}
