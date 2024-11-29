package in.amit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.amit.entity.Plan;
import in.amit.entity.PlanCategory;
import in.amit.repo.PlanCategoryRepo;
import in.amit.repo.PlanRepo;

 
@Service

public class PlanSerImp implements PlanService{
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCategoryRepo planCatRepo;
	
	

	@Override
	public Map<Integer, String> getPlanCategories() {
		// TODO Auto-generated method stub
		
		
		
		List<PlanCategory>categor = planCatRepo.findAll();
		
		Map<Integer,String>catMap = new HashMap<>();
		
		categor.forEach(category->{
			catMap.put(category.getCategoryId(), category.getCategoryName());
		
		
		});
		
		return catMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		// TODO Auto-generated method stub
		
		Plan saved = planRepo.save(plan);
		
		if(saved.getPlanId()!=null)
		{
			return true;
		}
		else
		{
			return false;
			
		}
			
		
	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
		
		return planRepo.findAll();
		
	}

	@Override
	public Plan getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		
		Optional<Plan>findbyid = planRepo.findById(planId);
		
		if(findbyid.isPresent())
		{
			return findbyid.get();
			
			
		}
		
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		
		planRepo.save(plan);
		
		return plan.getPlanId()!=null;
		
		
	
	}

	@Override
	public boolean deletePlanbyId(Integer planId) {
		// TODO Auto-generated method stub
		
		boolean status = false;
		
		try
		{
			planRepo.deleteById(planId);
			status = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public boolean planStatuschange(Integer planId, String status) {
		// TODO Auto-generated method stub
		
		Optional<Plan>findbyid = planRepo.findById(planId);
		
		if(findbyid.isPresent())
		{
			Plan plan = findbyid.get();
			plan.setActiveSw(status);
			
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
