/**
 * 
 */
package com.paymentMicroservice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.paymentMicroservice.command.peanut_accountCommand;
import com.paymentMicroservice.service.Peanut_accountService;

/**
 * @author vijetaagrawal
 *
 */

@RestController
public class TransactionController {
	
	@Autowired
	private Peanut_accountService peanut_accountService;
	
	@RequestMapping(value = {"/checkout"}, method = RequestMethod.GET)
	public ModelAndView checkout(Model m) {
		m.addAttribute("command", new peanut_accountCommand());
		ModelAndView mav = new ModelAndView("/checkout");
		return mav;
	}

	@RequestMapping(value = "/paymentSuccessful", method = RequestMethod.POST)
	public ModelAndView paymentSuccessful(@ModelAttribute("command") peanut_accountCommand cmd,Model m,  HttpSession session) {
		
		Integer UserId = (Integer)session.getAttribute("UserId");
		
		try {
			
			if(Integer.parseInt(cmd.available_peanuts)<5) {
				
				m.addAttribute("err", "Insufficient Peanuts.");
				ModelAndView mav = new ModelAndView("/checkout");
				return mav;
				
			}else {
				
			peanut_accountService.debit(UserId);
			peanut_accountService.credit(UserId);//Require UserId of Application Owner
			
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("/paymentSuccessful"); // Require link for application
		return mav;
	}
	
//	@RequestMapping(value = {"/paymentFailed"}, method = RequestMethod.GET)
//	public ModelAndView paymentFailed(Model m) {
//		ModelAndView mav = new ModelAndView("/paymentFailed");
//		return mav;
//	}

}
