package com.revature.controllers;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Txact;
import com.revature.services.TxactService;

@RestController
@RequestMapping(value = "/txact")
@CrossOrigin(origins = "http://localhost:4200")
public class TxactController {
	@Autowired
	private TxactService ts;

	@RequestMapping(method = RequestMethod.POST)
	int addTxact() {
		Txact txa = new Txact();
		txa.setId(0);
		txa.setToken("Test");
		txa.setCreated((new Date()).toString());
		txa.setTxid(generateUUID());
		txa.setStatus("Pending");
		return ts.addTxact(txa);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Txact getTxactById(@PathVariable int id) {
		return ts.getTxactById(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	Set<Txact> getTxacts() {
		return ts.getTxacts();
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	List<Txact> getTxactsCriteria(@RequestBody Txact txact) {
		return ts.getTxactsCriteria(txact);
	}

	@RequestMapping(method = RequestMethod.PUT)
	void updateTxact(@RequestBody Txact txa) {
		ts.updateTxact(txa);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	void deleteTxact(@RequestBody Txact txa) {
		ts.deleteTxact(txa);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deleteTxactById(@PathVariable int id) {
		ts.deleteTxactById(id);
	}
	
	String generateUUID(){
		String newID = UUID.randomUUID().toString();
//		System.out.println(stringID);
//		int newID = stringID.hashCode();
//		System.out.println(newID);
		return newID;
	}
}
