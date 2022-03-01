package com.icl.icl.web.user.service;

import com.icl.icl.core.generic.service.GenericServiceImpl;
import com.icl.icl.web.user.UserCriterion;
import com.icl.icl.web.user.UserInfo;
import com.icl.icl.web.user.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<UserInfo, UserCriterion, UserDao> implements UserService {
    public UserServiceImpl(){super(UserDao.class);}
}
