package com.icl.icl.web.user.dao;

import com.icl.icl.core.generic.dao.GenericDao;
import com.icl.icl.web.user.UserCriterion;
import com.icl.icl.web.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends GenericDao<UserInfo, UserCriterion> {
}
