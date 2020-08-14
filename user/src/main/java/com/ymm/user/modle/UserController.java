package com.ymm.user.modle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2020-08-11 11:34
 * @Author ymm
 **/
@RestController
@RequestMapping("/api/user/")
public class UserController {

  @GetMapping("selectList")
  public String selectList() {
    return "Hello Word User!";
  }
}