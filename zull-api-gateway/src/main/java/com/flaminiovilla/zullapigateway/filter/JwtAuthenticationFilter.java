package com.flaminiovilla.zullapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//@Log4j2
@Component
public class JwtAuthenticationFilter extends ZuulFilter {
//
//	@Autowired
//	private LoginFeignClient loginClient;
	
	public String filterType() {
		return "pre"; //pre: prerouting, post: postrouting
	}

	@Override
	public int filterOrder() {
		return 10;
	}

	@Override
	public boolean shouldFilter() {
		HttpServletRequest hhtHttpServletRequest = RequestContext.getCurrentContext().getRequest();
		String uri = hhtHttpServletRequest.getRequestURI();

		//System.out.println(uri);
		return !uri.startsWith("/api/authenticate") && !uri.startsWith("/swagger-ui.html") && !uri.startsWith("/api-docs");
	}

	@Override
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.getRequest().getRequestURL();
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
		String token = httpServletRequest.getHeader("Authorization");

		try {
//			ResponseEntity<Boolean> validateToken = loginClient.validateToken(token);
//			if(validateToken.getStatusCode().equals(HttpStatus.OK)
//					&& validateToken.getBody()!=null && validateToken.getBody()) {
//				//ok
				return null;
//			}
//		}catch(Unauthorized | BadRequest e) {
//			ctx.setSendZuulResponse(false);
//	        ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//	        ctx.setResponseBody("Invalid or expired Authorization");
//	        return null;
//		}catch(Forbidden e) {
//			ctx.setSendZuulResponse(false);
//	        ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
//	        ctx.setResponseBody("Invalid or expired Authorization");
//	        return null;
		}catch(Throwable e) {
//			log.error("AUTHORIZATION ERROR - EXCEPTION ->" + e.getMessage());
			throw e;
		}
//		log.warn("Invalid authentication with token - TOKEN ->" + token);
//		ctx.setSendZuulResponse(false);
//		ctx.setResponseBody("Invalid or expired Authorization");
//        ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        return null;
	}

}