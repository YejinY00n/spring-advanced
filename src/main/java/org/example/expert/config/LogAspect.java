package org.example.expert.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

  /**
   * - 요청한 사용자의 ID
   * - API 요청 시각
   * - API 요청 URL
   * - 요청 본문(`RequestBody`)
   * - 응답 본문(`ResponseBody`)
   */
  @Around("execution(* org.example.expert.domain.comment.controller.CommentAdminController.*(..)) ||"
      + "execution(* org.example.expert.domain.user.controller.UserAdminController.*(..))")
  public void logAdmin(ProceedingJoinPoint pjp) {
    Object[] params = pjp.getArgs();
    System.out.println("AOP CALLED!!!");
    for (Object param : params) {
      log.info(param.toString());
    }
  }
}
