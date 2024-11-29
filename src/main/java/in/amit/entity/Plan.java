package in.amit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Plan 

{
	@Id
	@GeneratedValue
	
	private Integer planId;
	private String activeSw;
	
	public String getActiveSw() {
		return activeSw;
	}
	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public LocalDate getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	private String planName;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	
}
