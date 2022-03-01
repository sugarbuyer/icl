package com.icl.icl.core.generic.entity;

import java.util.Date;

public interface EntityInfo {
    Date getCreated();
    void setCreated(Date created);

    Date getUpdated();
    void setUpdated(Date updated);
}
