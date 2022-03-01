package com.icl.icl.core.generic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class EntityInfoImpl implements EntityInfo{
    @JsonIgnore private Date created;
    @JsonIgnore private Date updated;

    public void setCreated(Date created) {this.created = created;}
    public void setUpdated(Date updated) {this.updated = updated;}
}
