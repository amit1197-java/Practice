package in.amit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.amit.entity.PlanCategory;



public interface PlanCategoryRepo extends JpaRepository<PlanCategory,Integer>

{
	
}
