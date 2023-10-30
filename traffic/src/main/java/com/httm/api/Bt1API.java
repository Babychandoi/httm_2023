package com.httm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.httm.api.output.BT1Output;
import com.httm.api.output.CoorOutput;
import com.httm.service.IBT1Service;
import com.httm.service.ICoorService;

@CrossOrigin
@RestController
public class Bt1API {
	@Autowired
	private IBT1Service ibt1Service;
	@Autowired
	private ICoorService icoorService;
	@GetMapping(value = "/bt1")
	public BT1Output showSimple(@RequestParam("page") int page,
			                    @RequestParam("limit") int limit) {
		BT1Output result = new BT1Output();
		result.setPage(page);
		Pageable pageable = new PageRequest(page -1, limit);
		result.setListSimple(ibt1Service.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (ibt1Service.totalItem())/limit));
		return result;
	}
	@GetMapping(value = "/bt1/{id}")
	public CoorOutput showCoor(@PathVariable("id") long id){
		CoorOutput result = new CoorOutput();
		 result.setListCoor(icoorService.findAll(id));
		return result;
		
	}
	{
		
	}
	@DeleteMapping(value = "/bt1/{id}")
	public void delete(@PathVariable("id") long id) {
		System.out.println(id);
		ibt1Service.delete(id);
	}
}
