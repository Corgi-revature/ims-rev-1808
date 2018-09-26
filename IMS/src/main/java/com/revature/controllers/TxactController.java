package com.revature.controllers;

import java.util.Set;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Txact getTxactById(Integer id) {
		return ts.getTxactById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	Set<Txact> getTxacts() {
		return ts.getTxacts();
	}
	
	@RequestMapping(value = "/txact", method = RequestMethod.GET)
	Set<Txact> getTxactCriteria() {
		return ts.getTxactsCriteria();
	}

	@RequestMapping(value="/txact", method=RequestMethod.POST)
	Txact createTxact(@RequestBody Txact txa) {
			ts.addTxact(txa);
			return txa;
	}

	@RequestMapping(value = "/txact", method = RequestMethod.PUT)
	void updateTxact(@RequestBody Txact txa) {
		ts.updateTxact(txa);
	}

	@RequestMapping(value = "/txact", method = RequestMethod.DELETE)
	void deleteTxact(@RequestBody Txact txa) {
		ts.deleteTxact(txa);
	}
	
	@RequestMapping(value = "/txact", method = RequestMethod.DELETE)
	void deleteTxact(@RequestBody int id) {
		ts.deleteTxactById(id);
	}
}
