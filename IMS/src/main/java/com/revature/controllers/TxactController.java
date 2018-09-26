package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Txact;
import com.revature.data.UserHibernate;
import com.revature.services.TxactService;

@Controller
@RequestMapping(value = "/Txact")
public class TxactController {
	private Logger log = Logger.getLogger(TxactController.class);
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
	Txact getTxactByCriteria() {
		return ts.getTxactCriteria();
	}

	@RequestMapping(value="/txact", method=RequestMethod.POST)
	Integer createTxact(@RequestBody Integer id) {
			ts.createTxact(id);
			return id;
	}

	@RequestMapping(value = "/txact", method = RequestMethod.PUT)
	void updateTxact() {
	}

	@RequestMapping(value = "/txact", method = RequestMethod.DELETE)
	void deleteTxact() {

	}

}
