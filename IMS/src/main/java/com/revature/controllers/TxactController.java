package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Txact;
import com.revature.services.TxactService;

@Controller
@RequestMapping(value = "/Txact")
@CrossOrigin(origins = "http://localhost:4200")
public class TxactController {
	@Autowired
	private TxactService ts;

	@RequestMapping(method = RequestMethod.GET)
	List<Txact> getAllTxacts() {
		return ts.getTxacts();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Txact getTxactById(Integer id) {
		return ts.getTxactById(id);
	}

	@RequestMapping(value = "/txact", method = RequestMethod.GET)
	Txact getTxactCriteria() {
		return ts.getTxactCriteria();
	}

	@RequestMapping(value="/txact", method=RequestMethod.POST)
	Integer createTxact(@RequestBody Integer id) {
			ts.createTxact(id);
			return id;
	}

	@RequestMapping(value = "/txact", method = RequestMethod.PUT)
	void updateTxact(@RequestBody Integer id) {
		ts.updateTxact(id);
	}

	@RequestMapping(value = "/txact", method = RequestMethod.DELETE)
	void deleteTxact(@RequestBody Integer id) {
		ts.deleteTxact(id);
	}

}
