package in.amit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.amit.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan,Integer>

{
	
	

}
