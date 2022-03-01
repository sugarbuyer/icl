package com.icl.icl.web.board.service;

import com.icl.icl.core.generic.service.GenericService;
import com.icl.icl.web.board.BoardCriterion;
import com.icl.icl.web.board.BoardInfo;
import com.icl.icl.web.board.dao.BoardDao;

public interface BoardService extends GenericService<BoardInfo, BoardCriterion, BoardDao> {
}