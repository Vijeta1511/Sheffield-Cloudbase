/**
 * 
 */
package com.paymentMicroservice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.paymentMicroservice.command.peanut_accountCommand;
import com.paymentMicroservice.domain.Transaction;
import com.paymentMicroservice.service.Peanut_accountService;
import com.paymentMicroservice.service.TransactionService;

/**
 * @author vijetaagrawal
 *
 */

@RestController
public class TransactionController {
	
	@Autowired
	private Peanut_accountService peanut_accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = {"/getCheckout"}, method = RequestMethod.GET)
	public ModelAndView checkout(ModelMap m) {
		m.addAttribute("command", new peanut_accountCommand());
		return new ModelAndView("redirect:checkout",m);
		
	}
	
	@RequestMapping(value = {"/checkout"}, method = RequestMethod.GET)
	public ModelAndView getViewTransactions(HttpSession session, ModelMap m) {
		Integer UserId = (Integer)session.getAttribute("userId");
		m.addAttribute("available_balance", peanut_accountService.balance(UserId));
		ModelAndView mav = new ModelAndView("/checkout");
		return mav;
		}

	@RequestMapping(value = {"/paymentSuccessful"}, method = RequestMethod.GET)
	public ModelAndView getPaymentSuccessful(Model m) {
		m.addAttribute("command", new peanut_accountCommand());
		ModelAndView mav = new ModelAndView("/paymentSuccessful"); // Require link for application
		return mav;
		
	}
	
	@RequestMapping(value = "/paymentSuccessful", method = RequestMethod.POST)
	public ModelAndView paymentSuccessful(ModelMap m,  HttpSession session) {
		
		
		Integer UserId = (Integer)session.getAttribute("userId");
		
		
		
		Integer balance = peanut_accountService.balance(UserId);
		try {
			
			if(balance<5) {
				
				m.addAttribute("err", "Insufficient Peanuts.");
				ModelAndView mav = new ModelAndView("/checkout");
				return mav;
				
			}else {
			String AppName = "Ask";//testing
			transactionService.newTransaction(AppName , UserId);	
			peanut_accountService.debit(UserId);
			peanut_accountService.credit(21);//Require UserId of Application Owner//testing
			
			
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("/paymentSuccessful"); // Require link for application
		return mav;
	}
	


}
