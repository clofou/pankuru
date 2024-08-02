package org.odk.g1.pankuru.Entity.Visitor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.odk.g1.pankuru.Service.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Component
public class VisitorLogger implements HandlerInterceptor {


    @Autowired
    private VisitorService visitorService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        final String ip = HttpRequestResponseUtils.getClientIpAddress();
        final String url = HttpRequestResponseUtils.getRequestUrl();
        final String page = HttpRequestResponseUtils.getRequestUri();
        final String refererPage = HttpRequestResponseUtils.getRefererPage();
        final String queryString = HttpRequestResponseUtils.getPageQueryString();
        final String userAgent = HttpRequestResponseUtils.getUserAgent();
        final String requestMethod = HttpRequestResponseUtils.getRequestMethod();
        final LocalDateTime timestamp = LocalDateTime.now();

        Visitor visitor = new Visitor();
        visitor.setPersonne(HttpRequestResponseUtils.getLoggedInUser());
        visitor.setIp(ip);
        visitor.setMethod(requestMethod);
        visitor.setUrl(url);
        visitor.setPage(page);
        visitor.setQueryString(queryString);
        visitor.setRefererPage(refererPage);
        visitor.setUserAgent(userAgent);
        visitor.setLoggedTime(timestamp);
        visitor.setUniqueVisit(true);

        visitorService.saveVisitorInfo(visitor);

        return true;
    }
}
