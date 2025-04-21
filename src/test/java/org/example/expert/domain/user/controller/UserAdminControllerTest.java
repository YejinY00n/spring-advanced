package org.example.expert.domain.user.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.example.expert.config.LogInterceptor;
import org.example.expert.domain.user.dto.request.UserRoleChangeRequest;
import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.service.UserAdminService;
import org.example.expert.domain.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import org.springframework.test.web.servlet.MockMvc;

// @WebMvcTest(UserAdminController.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Import(LogInterceptor.class)
class UserAdminControllerTest {

//  @Autowired
//  private MockMvc mockMvc;
//
  @Autowired
  private UserAdminController userAdminController;
//
//  @MockitoBean
//  UserAdminService adminService;
//
//  @Test
//  @DisplayName("admin 컨트롤러 접근 시 Interceptor 로깅")
//  void changeUserRoleInterceptor() throws Exception {
//    // given : admin 사용자가 일반 사용자의
//    String userEmail = "user@example.com";
//    String userPassword = "password";
//    User user = new User(userEmail, userPassword, UserRole.USER);
//
//    String adminEmail = "admin@example.com";
//    String adminPassword = "password";
//    User admin = new User(adminEmail, adminPassword, UserRole.ADMIN);
//
//    // when : 역할을 바꿀 때 (interceptor 로깅)
//    mockMvc.perform(patch("/admin/users/{userId}", 1L));
//
//    // then
//  }

  @Test
  @DisplayName("admin 컨트롤러 접근 시 AOP 로깅")
  void changeUserRoleAOP() throws Exception {
    // given : admin 사용자가 일반 사용자의
    String userEmail = "user@example.com";
    String userPassword = "password";
    User user = new User(userEmail, userPassword, UserRole.USER);

    String adminEmail = "admin@example.com";
    String adminPassword = "password";
    User admin = new User(adminEmail, adminPassword, UserRole.ADMIN);

    // when : 역할을 바꿀 때 (AOP 로깅)
    System.out.println("AOP TEST START!");
    userAdminController.changeUserRole(1L, new UserRoleChangeRequest("ADMIN"));

    // then
  }

  // TODO: comment admin 로깅 테스트 추가
}