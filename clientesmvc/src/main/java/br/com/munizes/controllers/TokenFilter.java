package br.com.munizes.controllers;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
			 {
		System.out.println("Verificação de token");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String auth = httpRequest.getHeader("Authorization");
		
		if (auth == null || !auth.startsWith("Bearer ")) {
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "token inexistente!!!");
			
		}
		
		String token = auth.substring(7);
		
		try {
			
			Claims claims = Jwts.parser().setSigningKey("rjmj").parseClaimsJws(token).getBody();
			if(claims!= null) {
				System.out.println(claims.getSubject());
				
			}
			
		} catch (SignatureException | ExpiredJwtException e) {
			 ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "token Invalido!!!");
			  
			
		}
		
		chain.doFilter(request, response);
	}

}
