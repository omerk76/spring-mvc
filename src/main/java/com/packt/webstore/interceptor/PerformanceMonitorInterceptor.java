package com.packt.webstore.interceptor;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by okeynan on 4/27/15.
 */
public class PerformanceMonitorInterceptor implements HandlerInterceptor {
    ThreadLocal<StopWatch> mStopWatchLocal = new ThreadLocal<>();
    Logger                 logger          = LogManager.getLogger("performance");

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StopWatch stopWatch = new StopWatch(handler.toString());
        stopWatch.start(handler.toString());
        mStopWatchLocal.set(stopWatch);
        logger.info("Accessing path: " + getURLPath(request));
        logger.info("Request processing started on " + getCurrentTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("Request processing ended on " + getCurrentTime());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        StopWatch stopWatch = mStopWatchLocal.get();
        stopWatch.stop();
        logger.info("Total processing time: " + stopWatch.getTotalTimeMillis() + "ms");
        mStopWatchLocal.set(null);
        logger.info("==============================================================");
    }

    private String getURLPath(HttpServletRequest request) {
        String currentPath = request.getRequestURI();
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : "?" + queryString;
        return currentPath + queryString;
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
