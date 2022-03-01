package com.icl.icl.core.generic.criterion;

public interface EntityCriterion {
    Integer getRequestIdx();
    void setRequestIdx(Integer requestIdx);

    Integer getPageSize();
    void setPageSize(Integer pageSize);
}
