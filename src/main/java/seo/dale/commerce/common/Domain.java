package seo.dale.commerce.common;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class Domain implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@CreatedDate
    private Date createdDate;

	public Domain() {
	}

	public Domain(Long id) {
		this.id = id;
	}

}
