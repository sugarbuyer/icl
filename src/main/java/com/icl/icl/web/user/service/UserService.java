package com.icl.icl.web.user.service;

import com.icl.icl.core.generic.service.GenericService;
import com.icl.icl.web.user.UserCriterion;
import com.icl.icl.web.user.UserInfo;
import com.icl.icl.web.user.dao.UserDao;

public interface UserService extends GenericService<UserInfo, UserCriterion, UserDao> {
}
