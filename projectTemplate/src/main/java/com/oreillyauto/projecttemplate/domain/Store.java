package com.oreillyauto.projecttemplate.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "STORE")
public class Store implements Serializable {
    private static final long serialVersionUID = 7560977249032911342L;

    @Id
    @Column(name = "STORE_NUMBER", columnDefinition = "DECIMAL(8,0)", insertable = false, updatable = false, nullable = false)
    private Integer storeNumber;

    @Column(name = "OPENED_DATE", columnDefinition = "DATE", insertable = false, updatable = false, nullable = false)
    private Date openDate;

    public Integer getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((openDate == null) ? 0 : openDate.hashCode());
        result = prime * result + ((storeNumber == null) ? 0 : storeNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Store other = (Store) obj;
        if (openDate == null) {
            if (other.openDate != null)
                return false;
        } else if (!openDate.equals(other.openDate))
            return false;
        if (storeNumber == null) {
            if (other.storeNumber != null)
                return false;
        } else if (!storeNumber.equals(other.storeNumber))
            return false;
        return true;
    }

}
