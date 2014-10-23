package org.fastlane.stats.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="data_values")
public class DataValue {
	@Id
	private Long timestamp;

	private Integer cost;

	public DataValue() {
	}

	
	public DataValue(Long timestamp, Integer cost) {
		this();
		setTimestamp(timestamp);
		setCost(cost);
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	@Column(name="timestamp")
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	public Integer getCost() {
		return cost;
	}

	@Column(name="cost")
	public void setCost(Integer cost) {
		this.cost = cost;
	}
}
