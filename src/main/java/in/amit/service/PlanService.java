package in.amit.service;

import java.util.List;
import java.util.Map;


import in.amit.entity.*;

public interface PlanService {

	public Map<Integer,String> getPlanCategories();
	
	public boolean savePlan(Plan plan);
	
	public List<Plan>getAllPlans();
	
	public Plan getPlanById(Integer planId);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanbyId(Integer planId);
	
	public boolean planStatuschange(Integer planId,String status);
	
	

	
}
