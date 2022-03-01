package com.icl.icl.web.board.dao;

import com.icl.icl.core.generic.dao.GenericDao;
import com.icl.icl.web.board.BoardCriterion;
import com.icl.icl.web.board.BoardInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface BoardDao extends GenericDao<BoardInfo, BoardCriterion> {
}