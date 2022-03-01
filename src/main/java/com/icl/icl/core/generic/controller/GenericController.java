package com.icl.icl.core.generic.controller;

import com.icl.icl.core.generic.appContext.AppContextUtil;
import com.icl.icl.core.generic.criterion.EntityCriterion;
import com.icl.icl.core.generic.dao.GenericDao;
import com.icl.icl.core.generic.entity.EntityInfo;
import com.icl.icl.core.generic.response.ResponseInfo;
import com.icl.icl.core.generic.response.StatusEnum;
import com.icl.icl.core.generic.response.StatusInfo;
import com.icl.icl.core.generic.service.GenericService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GenericController<T extends EntityInfo, C extends EntityCriterion, S extends GenericService<T, C, ? extends GenericDao<T, C>>>
        extends AbstractController implements ApplicationContextAware, InitializingBean
{
    protected S service;
    protected Class<T> entityClass;
    protected Class<C> criterionClass;
    protected Class<S> serviceClass;

    protected GenericController(Class<T> entityClass, Class<C> criterionClass, Class<S> serviceClass) {
        super();
        this.entityClass = entityClass;
        this.criterionClass = criterionClass;
        this.serviceClass = serviceClass;
    }

    public void afterPropertiesSet() throws Exception {
        service = (S) AppContextUtil.getBeanByType(applicationContext, serviceClass);
    }

    // 공통적으로 HttpServletRequest 를 받는 것은 별도의 parameter 혹은 Header 를 받을 수 있는 가능성 때문에 generic 으로 받는 것 이외에 설정함.

    @GetMapping(value = "/list")
    public ResponseInfo list(HttpServletRequest request, C criterion){
        try{
            List<T> list = service.list(criterion);
            int size = service.searchCount(criterion);
            int maxIdx = (size / criterion.getPageSize());  // 최대 인덱스 수.. 0부터 시작

            return new ResponseInfo(new StatusInfo(StatusEnum.SUCCESS), list, maxIdx);
        }catch (Exception e){
            return new ResponseInfo(new StatusInfo(StatusEnum.UNKNOWN_EXCEPTION), e.getMessage());
        }
    }

    @GetMapping(value = "/detail")
    public ResponseInfo detail(HttpServletRequest request, T entity){
        try{
            T item = service.detail(entity);

            return new ResponseInfo(new StatusInfo(StatusEnum.SUCCESS), item);
        }catch (Exception e){
            return new ResponseInfo(new StatusInfo(StatusEnum.UNKNOWN_EXCEPTION), e.getMessage());
        }
    }

    @PutMapping(value = "/insert")
    public ResponseInfo insert(HttpServletRequest request, T entity){
        try{
            service.insert(entity);

            return new ResponseInfo(new StatusInfo(StatusEnum.SUCCESS));
        }catch (Exception e){
            return new ResponseInfo(new StatusInfo(StatusEnum.UNKNOWN_EXCEPTION), e.getMessage());
        }
    }

    @PatchMapping(value = "/update")
    public ResponseInfo update(HttpServletRequest request, T entity){
        try{
            service.update(entity);

            return new ResponseInfo(new StatusInfo(StatusEnum.SUCCESS));
        }catch (Exception e){
            return new ResponseInfo(new StatusInfo(StatusEnum.UNKNOWN_EXCEPTION), e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseInfo delete(HttpServletRequest request, T entity){
        try{
            service.delete(entity);

            return new ResponseInfo(new StatusInfo(StatusEnum.SUCCESS));
        }catch (Exception e){
            return new ResponseInfo(new StatusInfo(StatusEnum.UNKNOWN_EXCEPTION), e.getMessage());
        }
    }
}
