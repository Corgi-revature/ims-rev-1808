package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	Txact addTxact(Txact txa) {
		ts.addTxact(txa);
		return txa;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Txact getTxactById(Integer id) {
		return ts.getTxactById(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	Set<Txact> getTxacts() {
		return ts.getTxacts();
	}

	@RequestMapping(method = RequestMethod.GET)
	Set<Txact> getTxactsCriteria() {
		return ts.getTxactsCriteria();
	}

	@RequestMapping(method = RequestMethod.PUT)
	void updateTxact(Txact txa) {
		ts.updateTxact(txa);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	void deleteTxact(Txact txa) {
		ts.deleteTxact(txa);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deleteTxactById(int id) {
		ts.deleteTxactById(id);
	}
}
