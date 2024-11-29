package in.amit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity


public class PlanCategory {
	
	@Id
	@GeneratedValue
	
	private Integer categoryId;
	
	private String categoryName;
	
	//private String activeSw;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public LocalDate getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		UpdateDate = updateDate;
	}
	private String createdBy;
	private String updatedBy;
	
	@CreationTimestamp
	private LocalDate createDate;
	
	@UpdateTimestamp
	private LocalDate UpdateDate;
	
	

}
