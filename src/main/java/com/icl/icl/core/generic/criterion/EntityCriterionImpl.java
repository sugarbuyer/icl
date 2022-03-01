package com.icl.icl.core.generic.criterion;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EntityCriterionImpl implements EntityCriterion{
    private Integer requestIdx = 0;
    private Integer pageStart = 0;
    private Integer pageSize = 20;

    private void setPaging(){
        this.pageStart = this.requestIdx * this.pageSize;
    }

    public void setRequestIdx(Integer requestIdx) {
        this.requestIdx = requestIdx;
        setPaging();
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        setPaging();
    }
}
