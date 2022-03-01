package com.icl.icl.core.generic.service;

import com.icl.icl.core.generic.appContext.AppContextUtil;
import com.icl.icl.core.generic.criterion.EntityCriterion;
import com.icl.icl.core.generic.dao.GenericDao;
import com.icl.icl.core.generic.entity.EntityInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

public abstract class GenericServiceImpl<T extends EntityInfo, C extends EntityCriterion, D extends GenericDao<T, C>>
implements GenericService<T, C, D>, ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;

    protected Class<D> daoClass;
    protected D dao;

    protected GenericServiceImpl(Class<D> daoClass){
        this.daoClass = daoClass;
    }

    /**
     ApplicationContextAware 인터페이스 구현.
     @author GIL
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     InitializingBean 인터페이스 구현. 유형별로 GenericDao 자동 실행.
     @author GIL
     */
    public void afterPropertiesSet() throws Exception{
        if(dao == null){
            dao = (D) AppContextUtil.getBeanByType(applicationContext, daoClass);
        }
    }

    /**
     기본 정보 세팅. 필요에 따라 로그인 정보 등을 넣어줄 수 있다. 함수명은 자유.
     @author GIL
     */
    public void init(){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initEntity(T entity){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    /**
     상속된 기본 service 함수
     @author GIL
     */

    /** Entity Implement **/
    @Override
    public void insert(T entity) {
        dao.insert(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public T detail(T entity) {
        return dao.detail(entity);
    }


    /** List Implement **/
    @Override
    public List<T> list(C criterion) {
        return dao.list(criterion);
    }

    /** Count Implement **/
    @Override
    public Integer searchCount(C criterion) {
        return dao.searchCount(criterion);
    }
}