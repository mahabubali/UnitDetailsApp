package org.me.unitDetailsApp.controller;

import java.util.List;
import java.util.Optional;
import org.me.unitDetailsApp.entity.UnitDetails;
import org.me.unitDetailsApp.entity.UnitDetailsNav;
import org.me.unitDetailsApp.entity.UnitResponse;
import org.me.unitDetailsApp.repo.UnitDetailsNavRepo;
import org.me.unitDetailsApp.repo.UnitDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitDetailsController {

	@Autowired(required=true)
	UnitDetailsRepo unitsRepo;
	
	@Autowired(required=true)
	UnitDetailsNavRepo unitDetailsNavRepo;
	
	
	@GetMapping("/ms/unitdetails")
	public ResponseEntity<List<UnitDetails>> getUnitDetails() {
		return new ResponseEntity<>(unitsRepo.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/ms/unitdetailsnav")
	public ResponseEntity<List<UnitDetailsNav>> getUnitDetailsNav() {
		return new ResponseEntity<>(unitDetailsNavRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/ms/unit/{id}")
	public ResponseEntity<UnitDetails> getUnit(@PathVariable String id) {
		Optional<UnitDetails> unitObj = unitsRepo.findById(id);
		if(unitObj.isPresent()) {
			return new ResponseEntity<>(unitObj.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/ms/floorplandetails", produces = "application/json")
	public ResponseEntity<UnitResponse> getFloorplanDetails() {
	    try {
	        List<UnitDetailsNav> navList = unitDetailsNavRepo.findAll();
	        UnitDetailsNav nav = navList.isEmpty() ? null : navList.get(0); // assuming one record

	        List<UnitDetails> unitList = unitsRepo.findAll();

	        UnitResponse response = new UnitResponse(nav, unitList);
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
}
