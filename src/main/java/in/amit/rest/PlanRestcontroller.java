package in.amit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.amit.entity.Plan;
import in.amit.service.PlanService;

@RestController
public class PlanRestcontroller {
	
	@Autowired
	private PlanService planService;
	
	public ResponseEntity<Map<Integer,String>>planCategories()
	{
		Map<Integer,String>categories = planService.getPlanCategories();
		
		return new ResponseEntity<>(categories,HttpStatus.OK);
		
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String>savePlan(@RequestBody Plan plan)
	
	{
		String responseMsg = "";
		
		boolean isSaved = planService.savePlan(plan);
		
		if(isSaved)
		{
			responseMsg = "Plan saved";
		}
		
		else
		{
			responseMsg="plan not saved";
		}
		
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>>plans()
	{
		List<Plan>allPlans = planService.getAllPlans();
		
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
		
	}
	
		@GetMapping("/plan/{planId}")
		public ResponseEntity<Plan>editplan(@PathVariable Integer planId)
		
		{
			
			Plan plan = planService.getPlanById(planId);
			return new ResponseEntity<>(plan,HttpStatus.OK);
			
		}
		
		@DeleteMapping("/plan/{planId}")
		public ResponseEntity<String>deletePlan(@PathVariable Integer planId)
		{
			boolean isDeleted = planService.deletePlanbyId(planId);
			
			String msg = "";
			
			if(isDeleted)
			{
				msg = " plan deleted ";
			}
			else
			{
				msg = "plan not delted";
			}
				
			return new ResponseEntity<>(msg,HttpStatus.OK);
			
			
			
		}
		
		@PutMapping("/plan")
		public ResponseEntity<String>updatePlan(@RequestBody Plan plan)
		{
			boolean isUpdated = planService.updatePlan(plan);
			
			String msg = "";
			
			if(isUpdated)
			{
				msg = "plan updated";
				
			}
			else
			{
				msg = "plan not updated";
			}
			
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		
		@PutMapping("/status-change")
		public ResponseEntity<String>statusChange(Integer planId,String status)
		{
			String msg = "";
			
			boolean isStatus = planService.planStatuschange(planId, status);
			
			if(isStatus)
			{
				msg = "status changed";
			}
			else
			{
				msg = " status not changed";
			}
			
			return new ResponseEntity<>(msg,HttpStatus.OK);
			
			
		}
}
