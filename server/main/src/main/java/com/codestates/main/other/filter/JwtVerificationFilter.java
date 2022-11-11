package com.codestates.main.other.filter;

import com.codestates.main.other.jwt.JwtTokenizer;
import com.codestates.main.other.member.entity.Member;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JwtVerificationFilter extends OncePerRequestFilter {

    private final JwtTokenizer jwtTokenizer;

    public JwtVerificationFilter(JwtTokenizer jwtTokenizer) {
        this.jwtTokenizer = jwtTokenizer;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            Map<String, Object> claims = verifyJws(request); // (3)
            setAuthenticationToContext(claims);      // (4)

        } catch (ExpiredJwtException ee) {
            request.setAttribute("exception", ee);
//            Map<String, Object> claims = verifyRefresh(request);
//            setAuthenticationToContext(claims);
        } catch (Exception e) {
            request.setAttribute("exception", e);
        }
        filterChain.doFilter(request, response); // (5)
    }

    // (6)
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String authorization = request.getHeader("Authorization");  // (6-1)
        return authorization == null || !authorization.startsWith("Bearer");  // (6-2)
    }

    private Map<String, Object> verifyJws(HttpServletRequest request) {  //JWT를 검증하는데 사용되는 private 메서드
        // 파싱하는것 자체가 성공하면 서명 검증에 성공했다는 뜻임
        String jws = request.getHeader("Authorization").replace("Bearer ", ""); // 헤더 정보 가져오기
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey()); // JWT 서명(Signature)을 검증하기 위한 Secret Key
        Map<String, Object> claims = jwtTokenizer.getClaims(jws, base64EncodedSecretKey).getBody();   // JWT에서 Claims를 파싱

        return claims;
    }

    private Map<String, Object> verifyRefresh(HttpServletRequest request) {  // Refresh 토큰 검증하는데 사용되는 private 메서드
        // 파싱하는것 자체가 성공하면 서명 검증에 성공했다는 뜻임
        String jws = request.getHeader("Refresh"); // 헤더 정보 가져오기
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey()); // JWT 서명(Signature)을 검증하기 위한 Secret Key
        Map<String, Object> claims = jwtTokenizer.getClaims(jws, base64EncodedSecretKey).getBody();   // JWT에서 Claims를 파싱

        return claims;
    }

    private void setAuthenticationToContext(Map<String, Object> claims) {
        String email = (String) claims.get("email");
        String role = (String) claims.get("role");
        Member.ROLE memberRole = Member.ROLE.valueOf(role);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(memberRole);
        Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

}
