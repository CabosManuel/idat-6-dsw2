package com.cabos.util;

import java.util.Base64;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BAInterceptor {

	public static void agregar(RestTemplate rt) {
		String autho = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest().getHeader(HttpHeaders.AUTHORIZATION);
		
		if(autho!=null) {
			System.out.println("autho: "+autho);
			System.out.println(autho.substring(6));
			byte[] code = Base64.getDecoder().decode(autho.substring(6));
			String usuarioPassword = new String(code);
			System.out.println(usuarioPassword);
			
			String usuario = usuarioPassword.substring(0, usuarioPassword.indexOf(":"));
			String password = usuarioPassword.substring(usuarioPassword.indexOf(":")+1);
			
			System.out.println("usuario: "+usuario);
			System.out.println("password: "+password);
			
			rt.getInterceptors().clear();
			//BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor(usuario,password);
			rt.getInterceptors().add(new BasicAuthenticationInterceptor(usuario, password));
			
			System.out.println("inner_size: "+rt.getInterceptors().size());
		}
	}
}
