package com.petShot.clitente.infra.security;

import com.petShot.clitente.repository.ClienteSubscriptionRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClienteSubscriptionRepository clienteRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       var tokenJwt = recuperaToke(request);

      if(tokenJwt != null){
          var subject = tokenService.getSubject(tokenJwt);
          var usuario = clienteRepository.findByEmail(subject);

          var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.get().getAuthorities());

          SecurityContextHolder.getContext().setAuthentication(authentication);
      }
      filterChain.doFilter(request, response);
    }

    private String recuperaToke (HttpServletRequest request){
         var authorizationHeader =request.getHeader("Authorization");

      if(authorizationHeader != null){
        return authorizationHeader.replace("Bearer ", "").trim();
      }
      return null;
    }
}
