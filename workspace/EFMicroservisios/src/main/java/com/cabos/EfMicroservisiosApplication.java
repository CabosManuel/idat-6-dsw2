package com.cabos;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

@SpringBootApplication
public class EfMicroservisiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfMicroservisiosApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		System.out.println("restTemplate");
		RestTemplate rt = new RestTemplate();
		return rt;
	}
		
	// PRUEBAS
	
		//BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor("cabos","c123");
		
        //RestTemplate rt = new RestTemplate();
        //rt.getInterceptors().add(interceptor);
        //rt.getInterceptors().add(new BasicAuthenticationInterceptor("manuel", "m123"));
	
		
		
		/*String autho = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
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
			
			//BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor(usuario,password);
			
			System.out.println("inner_size: "+rt.getInterceptors().size());
		}*/
		
		
		
		/*RestTemplate rt = new RestTemplate();
		System.out.println("size: "+rt.getInterceptors().size());
		try {
		    rt.getInterceptors().add(new ClientHttpRequestInterceptor() {
				@Override
				public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
						throws IOException {
					
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
						
						nuevoBAInterceptor(rt,usuario, password);
						
						System.out.println("inner_size: "+rt.getInterceptors().size());
					}
					
					throw new IOException();
				}
			});
		    System.out.println("size: "+rt.getInterceptors().size());
		}catch (Exception e){
			System.out.println("error");
		}*/
		
		
		
		
		
		
		
		/*
		RestTemplate rt = new RestTemplate();
	 	rt.getInterceptors().add(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				ClientHttpResponse response = execution.execute(request, body);
				
				//System.out.println("getStatusText: "+response.getStatusText());
				//System.out.println("getBody: "+response.getBody());
				//System.out.println("H - AUTHORIZATION : "+response.getHeaders().getFirst(HttpHeaders.AUTHORIZATION));
				//System.out.println("H - PROXY_AUTHENTICATE : "+response.getHeaders().getFirst(HttpHeaders.PROXY_AUTHENTICATE));
				//System.out.println("H - PROXY_AUTHORIZATION : "+response.getHeaders().getFirst(HttpHeaders.PROXY_AUTHORIZATION));
				//System.out.println("H - WWW_AUTHENTICATE : "+response.getHeaders().getFirst(HttpHeaders.WWW_AUTHENTICATE));
				//System.out.println("H - COOKIE : "+response.getHeaders().getFirst(HttpHeaders.COOKIE));
				
				return response;
			}
		});*/
        

	/*private void nuevoBAInterceptor(RestTemplate rt, String usuario, String password) {
		System.out.println("bai");
		rt.getInterceptors().add(new BasicAuthenticationInterceptor(usuario, password));
	}*/
	
	/*private BasicAuthenticationInterceptor nuevoBAInterceptor() {
		BasicAuthenticationInterceptor interceptor = null;

		String autho = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest()
				.getHeader(HttpHeaders.AUTHORIZATION);

		if (autho != null) {
			System.out.println("autho: " + autho);
			System.out.println(autho.substring(6));
			byte[] code = Base64.getDecoder().decode(autho.substring(6));
			String user_pass = new String(code);
			System.out.println(user_pass);
			System.out.println(user_pass.substring(0, user_pass.indexOf(":")));
			System.out.println(user_pass.substring(user_pass.indexOf(":")));

			interceptor = new BasicAuthenticationInterceptor("cabos", "c123");
		}

		return interceptor;
	}*/
}
