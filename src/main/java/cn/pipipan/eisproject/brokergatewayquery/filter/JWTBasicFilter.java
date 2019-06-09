package cn.pipipan.eisproject.brokergatewayquery.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JWTBasicFilter extends BasicAuthenticationFilter {
    public JWTBasicFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("token");

        //判断是否有token
        if (token == null || !token.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //放行
        chain.doFilter(request, response);
    }

    @Override
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {
        super.onSuccessfulAuthentication(request, response, authResult);
    }

    @Override
    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        super.onUnsuccessfulAuthentication(request, response, failed);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {


        try {
            Claims claims = Jwts.parser().setSigningKey("MyJwtSecret")
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();

            //得到用户名
            String username = claims.getSubject();

            if (username != null) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("admin"));
                return new UsernamePasswordAuthenticationToken(username, null, authorities);
            }
            return null;
        }
        catch (Exception e){
            return null;
        }
    }
}
