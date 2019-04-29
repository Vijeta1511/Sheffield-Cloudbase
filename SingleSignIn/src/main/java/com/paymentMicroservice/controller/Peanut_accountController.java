/**
 * 
 */
package com.paymentMicroservice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.paymentMicroservice.command.peanut_accountCommand;
import com.paymentMicroservice.service.Peanut_accountService;
import com.paymentMicroservice.service.TransactionService;


/**
 * @author vijetaagrawal
 *
 */
@RestController
public class Peanut_accountController {
	@Autowired 
	private TransactionService transactionService;
	@Autowired
	private Peanut_accountService peanut_accountService;
	
	@RequestMapping(value = {"/viewAccount"}, method = RequestMethod.GET)
	public ModelAndView viewTransactions(HttpSession session, Model m) {
//		m.addAttribute("command", new peanut_accountCommand());
		Integer UserId = (Integer)session.getAttribute("UserId");
		m.addAttribute("available_balance", peanut_accountService.balance(UserId));
		m.addAttribute("transactionList", transactionService.viewAllTransactions(UserId));
		ModelAndView mav = new ModelAndView("/viewAccount");
		return mav;
	}
	
}



