package com.flaminiovilla.zullapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

//@Log4j2
@Component
public class BasicAuthorizationHeaderFilter extends ZuulFilter {


	@Override
	public String filterType() {
		return "pre"; //pre: prerouting, post: postrouting
	}

	@Override
	public int filterOrder() {
		return 11;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest hhtHttpServletRequest = ctx.getRequest();

		String uri = hhtHttpServletRequest.getRequestURI();
		String auth;

		if(uri.contains("/book") ) {
			auth = "flaminio" + ":" + "villa";
//			log.info("Redirecting to company service");
		}

		else {
//			log.info("No match found for url: {0}", uri);
			auth = null;
		}

		if(auth!=null) {
			byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.US_ASCII));
			String authHeader = "Basic " + new String(encodedAuth);
			ctx.addZuulRequestHeader("Authorization", authHeader);
		}

		return null;
	}
}