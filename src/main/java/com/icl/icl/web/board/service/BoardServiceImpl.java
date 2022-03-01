package com.icl.icl.web.board.service;

import com.icl.icl.core.generic.service.GenericServiceImpl;
import com.icl.icl.web.board.BoardCriterion;
import com.icl.icl.web.board.BoardInfo;
import com.icl.icl.web.board.dao.BoardDao;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl extends GenericServiceImpl<BoardInfo, BoardCriterion, BoardDao> implements BoardService {
    public BoardServiceImpl(){super(BoardDao.class);}
}