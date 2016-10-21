package seo.dale.commerce.record;

import org.hibernate.validator.constraints.NotEmpty;
import seo.dale.commerce.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Record extends BaseEntity {

    @Id @GeneratedValue
    private long id;

    @NotEmpty
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
