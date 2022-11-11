package com.codestates.main.other.oauth;

import com.codestates.main.other.member.entity.Member;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Data
public class PrincipalDetails extends Member implements UserDetails {
    private Member member;
    public PrincipalDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<GrantedAuthority>(Arrays.asList(Member.ROLE.values()));
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        member.getRoleList().forEach(n -> {
//            authorities.add(() -> n);
//        });
//        return authorities;
//    }

    @Override
    public String getPassword() throws NullPointerException{
        try{
            return member.getPassword();
        }catch (NullPointerException nullPointerException){
            return null;
        }

    }

    @Override
    public String getUsername() {
        return member.getEmail();
    }

    @Override
    public long getMemberId() {
        return member.getMemberId();
    }

    @Override
    public ROLE getRole() {
        return member.getRole();
    }

    @Override
    public String getNickname() {
        return member.getNickname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
