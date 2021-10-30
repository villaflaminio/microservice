package com.flaminiovilla.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class FeignConfiguration implements RequestInterceptor {
	
	private static final String HOST_HEADER = "Host";
    private static final String X_FORWARDED_HOST = "X-Forwarded-Host";
    
	@Value("${feign.username}")
	private String feignUsername;
	@Value("${feign.password}")
	private String feignPassword;
	
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor(feignUsername, feignPassword);
	}

	@Override
	/* imposta la richiesta in maniera da far si che hateoas generi i link corretti alla risorse (per zuul o proxy/feign) */
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        String host = request.getHeader(X_FORWARDED_HOST);
        if (host == null) {
            host = request.getHeader(HOST_HEADER);
        }

        requestTemplate.header(X_FORWARDED_HOST, host);
    }
}
