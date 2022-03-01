package com.icl.icl.web.board.controller;

import com.icl.icl.core.aes.AESService;
import com.icl.icl.core.generic.controller.GenericController;
import com.icl.icl.core.generic.response.ResponseInfo;
import com.icl.icl.core.generic.response.StatusEnum;
import com.icl.icl.core.generic.response.StatusInfo;
import com.icl.icl.web.board.BoardCriterion;
import com.icl.icl.web.board.BoardInfo;
import com.icl.icl.web.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/board")
public class BoardController extends GenericController<BoardInfo, BoardCriterion, BoardService> {
    public BoardController(){super(BoardInfo.class, BoardCriterion.class, BoardService.class);}

    @Autowired private AESService aes;

    @Override
    public ResponseInfo insert(HttpServletRequest request, BoardInfo entity) {
        if(StringUtils.isEmpty(entity.getUserId())){  // 비회원 케이스
            if(StringUtils.isEmpty(entity.getPassword())){
                return new ResponseInfo(new StatusInfo(StatusEnum.NEED_PASSWORD));
            }

            // 패스워드는 aes256 변환
            entity.setPassword(aes.encode(entity.getPassword()));
        }else{
            if(StringUtils.isEmpty(entity.getUserId())){
                return new ResponseInfo(new StatusInfo(StatusEnum.NEED_USER_AUTH));
            }
        }

        if(StringUtils.isEmpty(entity.getTitle()) || StringUtils.isEmpty(entity.getComment())){
            return new ResponseInfo(new StatusInfo(StatusEnum.NEED_PARAM));
        }

        return super.insert(request, entity);
    }

    @Override
    public ResponseInfo update(HttpServletRequest request, BoardInfo entity) {
        BoardInfo boardInfo = service.detail(entity);
        if(boardInfo == null){
            return new ResponseInfo(new StatusInfo(StatusEnum.NOT_FOUND_DATA));
        }

        if(!StringUtils.isEmpty(boardInfo.getUserId())){  // 회원 케이스
            if(!boardInfo.getUserId().equals(entity.getUser())){
                return new ResponseInfo(new StatusInfo(StatusEnum.PERMISSION_DENIED));
            }
        }else{  // 패스워드(비회원) 케이스
            String encodePass = aes.encode(entity.getPassword());
            if(!boardInfo.getPassword().equals(encodePass)){
                return new ResponseInfo(new StatusInfo(StatusEnum.PERMISSION_DENIED));
            }
        }

        return super.update(request, entity);
    }

    @Override
    public ResponseInfo delete(HttpServletRequest request, BoardInfo entity) {
        BoardInfo boardInfo = service.detail(entity);
        if(boardInfo == null){
            return new ResponseInfo(new StatusInfo(StatusEnum.NOT_FOUND_DATA));
        }

        if(!StringUtils.isEmpty(boardInfo.getUserId())){  // 회원 케이스
            if(!boardInfo.getUserId().equals(entity.getUser())){
                return new ResponseInfo(new StatusInfo(StatusEnum.PERMISSION_DENIED));
            }
        }else{  // 패스워드(비회원) 케이스
            String encodePass = aes.encode(entity.getPassword());
            if(!boardInfo.getPassword().equals(encodePass)){
                return new ResponseInfo(new StatusInfo(StatusEnum.PERMISSION_DENIED));
            }
        }

        return super.delete(request, entity);
    }
}
