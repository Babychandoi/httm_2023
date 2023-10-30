package com.httm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.httm.api.output.BT2Output;
import com.httm.dto.BT2DTO;
import com.httm.service.IBT2Service;

@CrossOrigin
@RestController
public class Bt2API {
	@Autowired
	private IBT2Service ibt2Service;
	
	@GetMapping(value = "/bt2")
	public BT2Output showSimple(@RequestParam("page") int page,
			                    @RequestParam("limit") int limit) {
		BT2Output result = new BT2Output();
		result.setPage(page);
		Pageable pageable = new PageRequest(page -1, limit);
		result.setListSimple(ibt2Service.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (ibt2Service.totalItem())/limit));
		return result;
	}
	@GetMapping(value = "/Search")
	public BT2Output showCoor(@RequestParam("name") String name){
		BT2Output result = new BT2Output();
		 result.setListSimple(ibt2Service.findall(name));
		return result;
	}
	@PostMapping(value = "/bt2")
	public void createBT2(@RequestBody BT2DTO model) {
		ibt2Service.save(model);
	}
	
	@PutMapping(value = "/bt2/{id}")
	public void updateBT2(@RequestBody BT2DTO model,@PathVariable("id")  long id) {
		model.setId(id);
		ibt2Service.save(model);	
	}
	
	@DeleteMapping(value = "/deletedSimple/{id}")
	public void delete(@PathVariable("id") long id) {
		ibt2Service.delete(id);
	}
}
