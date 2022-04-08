package com.olix.stock_system.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomExit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OffsetDateTime exitDate;
    @OneToMany(mappedBy = "customExit", fetch = FetchType.EAGER)
    private List<ExitItem> exitItems = new ArrayList<ExitItem>();

    public CustomExit() {

    }

    public CustomExit(Long id, OffsetDateTime exitDate, List<ExitItem> exitItems) {
        this.id = id;
        this.exitDate = exitDate;
        this.exitItems = exitItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(OffsetDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public List<ExitItem> getExitItems() {
        return exitItems;
    }

    public void setExitItems(List<ExitItem> exitItems) {
        this.exitItems = exitItems;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        CustomExit other = (CustomExit) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
