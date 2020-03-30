package com.qiangssvip.summary.interceptor;

import com.qiangssvip.summary.consts.CommonConst;
import com.qiangssvip.summary.exception.UserLoginException;
import com.qiangssvip.summary.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * true 表示继续，false表示终端
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute(CommonConst.CURRENT_USER);
        if (employee == null) {
            throw new UserLoginException();
        }
        return true;
    }

}
