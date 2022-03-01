package com.icl.icl.web.user.controller;

import com.icl.icl.core.generic.controller.GenericController;
import com.icl.icl.web.user.UserCriterion;
import com.icl.icl.web.user.UserInfo;
import com.icl.icl.web.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController extends GenericController<UserInfo, UserCriterion, UserService> {
    public UserController(){super(UserInfo.class, UserCriterion.class, UserService.class);}
}
