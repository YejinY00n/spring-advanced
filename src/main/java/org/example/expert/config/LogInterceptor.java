package org.example.expert.config;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Null;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.example.expert.domain.auth.exception.AuthException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

  // 어드민 컨트롤러 호출 전 실행
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    log.info("ADMIN CONTROLLER REQUEST");

    // 요청 시각
    log.info(LocalDateTime.now().toString());

    // URL
    log.info(request.getRequestURL().toString());

    return true;
  }
}
