package edu.mum.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class ContactNumber implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="{ContactNumber.area.empty}")
 	@Min(value = 100, message="{Min.Area.code.validation}")
 	@Max(value = 999, message="{Max.Area.code.validation}")
	@Column(name="AREA")
 	private Integer area;
 	
	@NotNull(message="{ContactNumber.prefix.empty}")
 	@Min(value = 000, message="{Min.prefix.code.validation}")
 	@Max(value = 999, message="{Max.prefix.code.validation}")
 	@Column(name="PREFIX")
 	private Integer prefix;
 	
	@NotNull(message="{ContactNumber.number.empty}")
 	@Min(value = 0000, message="{Min.number.code.validation}")
 	@Max(value = 9999, message="{Max.number.code.validation}")
	@Column(name="NUMBER")
	private Integer number;

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
